object rationals {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(31); 
  
  val x = new Rational(1,2);System.out.println("""x  : Rational = """ + $show(x ));$skip(31); 
  
  var y = new Rational(2,3);System.out.println("""y  : Rational = """ + $show(y ))}
  
}

class Rational(x: Int, y:Int) {

}