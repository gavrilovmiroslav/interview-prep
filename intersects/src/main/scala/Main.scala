package gm.interviews.intersects

object `package` {

	case class Line(slope: Double, offset: Double) {
		def +(off: Double) = Line(slope, offset + off)
		def -(off: Double) = Line(slope, offset - off)
		def intersects(l: Line): Boolean = areIntersecting(this, l)
		def doesntIntersect(l: Line): Boolean = !intersects(l)
	}

	import language.postfixOps
	implicit class RichInt(n: Int) {
		def x = Line(n, 0.0)
	}

	implicit class RichDouble(n: Double) {
		def x = Line(n, 0.0)
	}

	def areIntersecting(a: Line, b: Line) =
		if(a == b) true
		else Math.abs(a.slope - b.slope) > Double.MinPositiveValue
}