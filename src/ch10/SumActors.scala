/**
 * Created by GongXingFa on 2015/3/17.
 */
// 计算1+2+3+....n n是一个很大值，如果只有一个actor去做的话 很耗时。所以把这个数分成m个区间，每个区间的计算由一个actor去计算。
// 最后由一个总的actor去汇总。
// 每个计算的actor计算完结果后,就将结果发送给汇总的actor actor进行汇总
// 从上面的过程可以看出 actor模式非常适合 并行计算。如果用Java的线程去做，要考虑线程间的同步将会很麻烦。


import scala.actors.Actor._


//计算从start到end相加的值
def calculate(start: Long, end: Long) = {
  var sum: Long = 0
  for (num <- start to end) {
    sum += num
    Thread sleep 1
  }
  sum
}

//某个数进行匀均分区
def interval(number: Long, count: Int) = {
  val step = if (number % count == 0) number / count else number / count + 1
  var inters = List[Set[Long]]()
  for (n <- 1 to count) {
    if (n * step >= number) inters = (Set((count - 1) * step + 1, number) :: inters)
    else inters = (Set((n - 1) * step + 1, n * step) :: inters)
  }
  inters.reverse
}

//最终结果
var result: Long = 0
// n的值
val number: Long = 10000
// 区间数
val count = 150
val inters = interval(number, count)

val caller = self

for (i <- 0 until inters.length) {
  val star = inters(i).head
  val end = inters(i).last
  actor {
    caller ! calculate(star, end)
  }
}

var continue = true
var index = 0
while (continue) {
  receive {
    case sum: Long => {
      index += 1
      result += sum
      if (index == count) continue = false
    }
  }
}


println("Sum of " + number + " is " + result)