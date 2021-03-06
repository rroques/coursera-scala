package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   *
   * If counter gets negative, it means we started with a ) => unbalanced.
   */
  def balance(chars: List[Char]): Boolean = {
    def inspectFirstChar(chars: List[Char], currentCounter: Int, counterStatus: Boolean): Boolean =
      if (chars.isEmpty) counterStatus && currentCounter == 0
      else if (chars.head == '(')
        inspectFirstChar(chars.tail, currentCounter + 1, counterStatus && (currentCounter + 1) >= 0);
      else if (chars.head == ')')
        inspectFirstChar(chars.tail, currentCounter - 1, counterStatus && (currentCounter - 1) >= 0);
      else
        inspectFirstChar(chars.tail, currentCounter, counterStatus);

    inspectFirstChar(chars, 0, true)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) 0
      else if (money == 0) 1
      else if (money >= coins.head) countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else countChange(money, coins.tail)
  }
  
}
