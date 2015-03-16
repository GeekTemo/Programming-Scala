/**
 * Created by gongxingfa on 15/3/16.
 */

import scala.actors._
import Actor._

class AnsweringService(val folks: String*) extends Actor {
  override def act() {
    while (true) {
      receive {
        case (caller: Actor, name: String, msg: String) =>
          caller ! {
            if (folks.contains(name))
              String.format("Hey it's %s got message %s", name, msg)
            else
              String.format("Hey there's no one with the name %s here", name)
          }
        case "ping" => println("ping!")
        case "quit" => {
          println("exiting actor")
          exit
        }
      }
    }
  }
}


val answerService1 = new AnsweringService("Sara", "Kara", "John")

answerService1 !(self, "Sara", "In town")
answerService1 !(self, "Kara", "In shopping")

answerService1.start()

answerService1 !(self, "John", "Bug fixed")
answerService1 !(self, "Bill", "What's up")

for (i <- 1 to 4) {
  receive { case msg => println(msg)}
}

answerService1 ! "ping"
answerService1 ! "quit"
answerService1 ! "ping"

Thread sleep 2000
println("The last ping was not processed")
































