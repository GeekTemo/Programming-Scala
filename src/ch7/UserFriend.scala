/**
 * Created by gongxingfa on 15/3/14.
 */

val john = new Man("John")
val sara = new Woman("Sara")
val comet = new Dog("Comet")


john.listen
sara.listen
comet.listen

val mansBestFriend: Friend = comet
mansBestFriend.listen

def helpAsFriend(friend: Friend) = friend listen

helpAsFriend(sara)
helpAsFriend(comet)