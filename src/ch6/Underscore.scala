/**
 * Created by gongxingfa on 15/3/13.
 */

var arr = Array(1, 2, 3, 4, 5)
println("Sum of values in array is " + (0 /: arr) { (sum, elem) => sum + elem})

println("Sum of values in array is " + (0 /: arr) {
  _ + _
})


def max2(a: Int, b: Int): Int = if (a > b) a else b

var max = (Integer.MIN_VALUE /: arr) { (large, elem) => max2(large, elem)}

max = (Integer.MIN_VALUE /: arr) {
  max2(_, _)
}

max = (Integer.MIN_VALUE /: arr) {
  max2 _
}

max = (Integer.MIN_VALUE /: arr) {
  max2
}