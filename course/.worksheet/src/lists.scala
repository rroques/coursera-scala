object lists {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(189); 

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(51); val res$0 = 
  
  pack(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res0: List[List[java.lang.String]] = """ + $show(res$0));$skip(88); 
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs).map( x => (x(0), x.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(53); val res$1 = 
 
   encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res1: List[(java.lang.String, Int)] = """ + $show(res$1))}
}