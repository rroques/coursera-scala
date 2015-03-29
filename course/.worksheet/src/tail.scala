object tail {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(186); 

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop( a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(24); val res$0 = 
  
  sum( x => x, 0, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(181); 
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    def prod(a: Int, b: Int): Int = {
      if (a > b) 1
      else (f(a) * f(b) ) + prod( a+1, b)
    }
    prod(a, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(24); val res$1 = 
  
  sum( x => x, 0, 4);System.out.println("""res1: Int = """ + $show(res$1))}
}