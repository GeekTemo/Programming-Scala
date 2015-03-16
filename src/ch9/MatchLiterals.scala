/**
 * Created by gongxingfa on 15/3/15.
 */


def activity(day: String): Unit = {
  day match {
    case "Sunday" => print("Eat, sleep, repeat...")
    case "Saturday" => print("Hangout with friends..")
    case "Monday" => print("...code for fun...")
    case "Friday" => print("..read a good book...")
  }
}

List("Monday", "Sunday", "Saturday").foreach {
  activity
}
