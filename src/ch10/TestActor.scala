/**
 * Created by GongXingFa on 2015/3/16.
 */

import scala.actors.Actor._

val act = actor {
  while (true) {
    receive {
      case "Hi" => println("Hello")
      case msg: String => println("Message " + msg)
    }
  }
}

act ! "Hi"
act ! "Hello World"