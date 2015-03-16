/**
 * Created by GongXingFa on 2015/3/16.
 */

import scala.actors.Actor._

def sumOfFactorsInRange(lower: Int, upper: Int, number: Int) = {
  (1 /: (lower to upper)) { (sum, i) => if (number % i == 0) sum + i else sum}
}

def isPerfectConcurrent(candidate: Int) = {
  val RANGE = 1000000
  val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
  val caller = self

  for (i <- 0 until numberOfPartitions) {
    val lower = i * RANGE + 1
    val upper = candidate min (i + 1) * RANGE

    actor {
      caller ! sumOfFactorsInRange(lower, upper, candidate)
    }
  }

  val sum = (0 /: (0 until numberOfPartitions)) { (prtialSum, i) =>
    receive {
      case sumInRange: Int => prtialSum + sumInRange
    }
  }

  2 * candidate == sum
}

def countPerfectNumbersInRange(start: Int, end: Int, isPerfectFinder: Int => Boolean) = {
  val startTime = System.nanoTime()
  val numberOfPerfectNumbers = (0 /: (start to end)) { (count, candidate) =>
    if (isPerfectFinder(candidate)) count + 1 else count
  }
  val endTime = System.nanoTime()
  println("Found " + numberOfPerfectNumbers + " perfect numbers in given range, took " + (endTime - startTime) / 1000000000.0 + " secs")
}

val startNumber = 33550300
val endNumber = 33550400
countPerfectNumbersInRange(startNumber, endNumber, isPerfectConcurrent)
