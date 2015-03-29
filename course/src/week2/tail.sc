object tail {

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop( a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  sum( x => x, 0, 4)                              //> res0: Int = 10
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    def prod(a: Int, b: Int): Int = {
      if (a > b) 1
      else (f(a) * f(b) ) + prod( a+1, b)
    }
    prod(a, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  sum( x => x, 0, 4)                              //> res1: Int = 10
}