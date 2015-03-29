object lists {

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(List("a", "a", "a", "b", "c", "c", "a"))   //> res0: List[List[java.lang.String]] = List(List(a, a, a), List(b), List(c, c)
                                                  //| , List(a))
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs).map( x => (x(0), x.length))          //> encode: [T](xs: List[T])List[(T, Int)]
 
   encode(List("a", "a", "a", "b", "c", "c", "a"))//> res1: List[(java.lang.String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}