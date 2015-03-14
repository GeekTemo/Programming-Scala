/**
 * Created by gongxingfa on 15/3/13.
 */

import java.util.Date

def log(date: Date, message: String): Unit = {
  println(date + "-------" + message)
}

val date = new Date
log(date, "message1")
log(date, "message2")
log(date, "message3")

val logWithDateBound = log(date, _: String)
logWithDateBound("message1")
logWithDateBound("message2")
logWithDateBound("message3")