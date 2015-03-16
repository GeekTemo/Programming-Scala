/**
 * Created by gongxingfa on 15/3/15.
 */

def process(input: Any): Unit = {
  input match {
    case (a: Int, b: Int) => print("Processing (int, int)... ")
    case (a: Double, b: Double) => print("Processing (double, double)... ")
    case msg: Int if (msg > 1000000) => println("Processing int > 1000000")
    case msg: String => println("Processing string... ")
    case _ => printf("Can't handle %s... ", input)
  }
}

process((34.2, -159.3))
process(0)
process(10000323)
process(2.2)
