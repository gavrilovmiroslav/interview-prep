
object Main {
  type Matrix = Array[Array[Int]]

  def main(args: Array[String]) {
    val a = createMatrix(5)
    printMatrix(a)
    println("---------------")
    printMatrix(zero(a))
  }

  def printMatrix(m: Matrix) = {
    m.foreach { r =>
      println(r.map { v => f"$v%3d" }.mkString(" "))
    }
  }
  
  def createMatrix(n: Int) = { 
    val mat = Array.ofDim[Int](n, n)
    for { 
      i <- 0 until n
      j <- 0 until n
    } yield mat(i)(j) = Math.abs(scala.util.Random.nextInt % 10)

    mat
  }

  def zero(m: Matrix): Matrix = {
    val zeroRows = m.map { _.contains(0) }
    val zeroCols = m.transpose.map { _.contains(0) }
    val range = 0 until m.length

    val toZeroRow = range filter zeroRows
    val toZeroCol = range filter zeroCols

    for { i <- toZeroRow; j <- range } yield m(i)(j) = 0
    for { j <- toZeroCol; i <- range } yield m(i)(j) = 0

    return m
  }
}
