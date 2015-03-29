import week4._

object natExcercise {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(54); 

  val v0 = Zero;System.out.println("""v0  : week4.Zero.type = """ + $show(v0 ));$skip(26); 
  val v1 = Zero.successor;System.out.println("""v1  : week4.Nat = """ + $show(v1 ));$skip(34); 
  val v2 = v1.successor.successor;System.out.println("""v2  : week4.Nat = """ + $show(v2 ));$skip(13); val res$0 = 
  
  v2 - v1;System.out.println("""res0: week4.Nat = """ + $show(res$0))}
}