
object Main {
  def main(args: Array[String]) {
    println(palperm(args.mkString("")))
  }

  def palperm(original: String): Boolean = 
    if(original.length <= 1) 
      true
    else
      original
        .sorted
        .filter { c => word.count(_ == c) == 1 }
        .length <= 1
}
