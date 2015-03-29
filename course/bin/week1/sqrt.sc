object sqrt {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < x

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1)
  }                                               //> sqrt: (x: Double)Double

  sqrt(1e-6)                                      //> res0: Double = 0.0012961915927068783

  0.031260655525445276 * 0.031260655525445276     //> res1: Double(9.772285838805523E-4) = 9.772285838805523E-4
}