package week4

class Succ(n: Nat) extends Nat {

  def isZero: Boolean = false

  def predecessor: Nat = n

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat = {
    if (that.isZero) this
    else successor + that.predecessor
  }

  def -(that: Nat): Nat = {
    if (that.isZero) this
    else predecessor - that.predecessor
  }
  
  override def toString = {
    "1" + predecessor.toString
  } 

}