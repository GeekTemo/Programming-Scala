/**
 * Created by GongXingFa on 2015/3/17.
 */

def calculate(start: Long, end: Long) = {
  var sum: Long = 0
  for (num <- start to end) {
    sum += num
    Thread sleep 1
  }
  sum
}

val number:Long = 10000
println("Sum of "+number+" is "+ calculate(1, number))