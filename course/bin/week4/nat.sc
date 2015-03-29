import week4._

object natExcercise {

  val v0 = Zero                                   //> v0  : week4.Zero.type = 0
  val v1 = Zero.successor                         //> v1  : week4.Nat = 10
  val v2 = v1.successor.successor                 //> v2  : week4.Nat = 1110
  
  v2 - v1                                         //> res0: week4.Nat = 110
}