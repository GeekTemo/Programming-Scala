/**
 * Created by GongXingFa on 2015/3/13.
 */

class Equipment(val routine : Int => Int){
  def simulate(input: Int): Unit ={
    print("Running simulation....")
    routine(input)
  }
}

val equipment1 = new Equipment({input => println("calc with" + input); input})
val equipment2 = new Equipment({input => println("calc with" + input); input})

equipment1.simulate(4)
equipment1.simulate(6)
