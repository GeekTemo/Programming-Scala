/**
 * Created by gongxingfa on 15/3/13.
 */

def loopThrough(number: Int)(closure: Int => Unit): Unit = {
  for (i <- 1 to number) {
    closure(i)
  }
}

var result = 0
val addIt = { value: Int => result += value}

loopThrough(10) {
  addIt
}

println("Total of values from1 to 10 is " + result)

var product = 1
loopThrough(5) {
  product += _
}
println("Producr of values from 1 to 5 is " + product)

