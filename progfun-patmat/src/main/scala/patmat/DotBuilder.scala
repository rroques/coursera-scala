package patmat
 
import common._
import patmat.Huffman._
 
object DotBuilder {
 
  def name(node: CodeTree) : String = node match {
      case Fork(_, _, chars, _) => chars.map(x => "" + x + " ").reduce(_ + _).dropRight(1)
      case Leaf(chars, _) => chars.toString
  }
 
  def attrs(node: CodeTree) : String = node match {
    case f: Fork => "[label=\"" + label(node) + "\"]"
    case l: Leaf => "[shape=box, label=\"" + label(node) + "\"]"
  }
 
  def label(node: CodeTree) : String = node match {
    case Fork(_, _, _, w) => name(node) + " (" + w + ")"
    case Leaf(_, w) => name(node) + " (" + w + ")"
  }
 
  def visit(node: CodeTree) : Unit = {
    val nm = name(node)
    println("  \"" + nm + "\" " + attrs(node));
    node match {
      case Fork(left, right, _, weight) => {
        visit(left)
        visit(right)
        println("  \"" + nm + "\" -> \"" + name(left) + "\" [label=0]");
        println("  \"" + nm + "\" -> \"" + name(right) + "\" [label=1]");
      }
      case _ =>
    }
  }
 
  def generate(tree: CodeTree) = {
    println("digraph g {");
    visit(tree)
    println("}");
  }
 
  def main(args: Array[String]) {
    generate(createCodeTree(string2Chars("helloworld")))
  }
}