object sqrt {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(299); 

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < x

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(14); val res$0 = 

  sqrt(1e-6);System.out.println("""res0: Double = """ + $show(res$0));$skip(47); val res$1 = 

  0.031260655525445276 * 0.031260655525445276;System.out.println("""res1: Double(9.772285838805523E-4) = """ + $show(res$1))}
}