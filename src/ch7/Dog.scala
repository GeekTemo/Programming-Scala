/**
 * Created by gongxingfa on 15/3/14.
 */

class Dog(val name: String) extends Animal with Friend {
  override def listen = println(name + " is listening")
}
