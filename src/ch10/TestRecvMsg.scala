/**
 * Created by GongXingFa on 2015/3/17.
 */

import scala.actors.Actor._

def recvMsg1() = {
  println("RcvMsg[1] start recv msg...........")
  while (true) {
    receive {
      case msg: String => println("RecvMsg[1] recv msg: " + msg)
    }
  }
}

def recvMsg2() = {
  println("RcvMsg[2] start recv msg...........")
  while (true) {
    receive {
      case msg: String => println("RecvMsg[2] recv msg: " + msg)
    }
  }
}

val a1 = actor {
  recvMsg1()
}
val a2 = actor {
  recvMsg2()
}

for (i <- 1 to 100) {
  a1 ! "hello " + i
  a2 ! "hello " + i
}
