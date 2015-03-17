/**
 * Created by GongXingFa on 2015/3/17.
 */

import scala.actors._
import Actor._

val caller = self

def accumulate(): Unit = {
  var sum = 0
  reactWithin(500) {
    case number: Int => {
      sum += number;
      accumulate()
    }
    case TIMEOUT => {
      println("Time out");
      caller ! sum
    }
  }
  println("This will not be called....")
}

val accumulator = actor {
  accumulate()
}

accumulator ! 1
accumulator ! 7
accumulator ! 8