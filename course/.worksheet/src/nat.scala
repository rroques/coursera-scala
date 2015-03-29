object nat {
  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat
    def +(that: Nat): Nat
    def -(that: Nat): Nat
  }

  object Zero extends Nat {
    def isZero: Boolean = true

    def predecessor: Nat =
      throw new IllegalStateException();

    def successor: Nat =
      new Succ(this)

    def +(that: Nat): Nat =
      that

    def -(that: Nat): Nat =
      throw new IllegalStateException();
  }

  class Succ(n: Nat) extends Nat {
  
    def isZero: Boolean = false

    def predecessor: Nat = n

    def successor: Nat = new Succ(n)

    def +(that: Nat): Nat = if (that.isZero) this else successor + that.predecessor

    def -(that: Nat): Nat = if (that.isZero) this else predecessor - that.predecessor
  }import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(788); val res$0 = 
  
  Zero.successor;System.out.println("""res0: nat.Nat = """ + $show(res$0))}
}