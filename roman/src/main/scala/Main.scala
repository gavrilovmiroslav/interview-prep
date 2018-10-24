package gm.interview.roman

object `package` {

	def integerToRoman(n: Int): String = {
		assert(n < 4000 && n > 0)

		val focus = Map(
			0 -> Seq("I", "V", "X"),
			1 -> Seq("X", "L", "C"),
			2 -> Seq("C", "D", "M"),
			3 -> Seq("M", "", "")
		)

		def digitToRoman(n: Int, p: Int): String = n match {
			case 0 => ""
			case 1 | 2 | 3 => focus(p)(0) * n
			case 5 => focus(p)(1)
			case 4 => focus(p)(0) + focus(p)(1)
			case 9 => focus(p)(0) + focus(p)(2)
			case n => focus(p)(1) + digitToRoman(n - 5, p)
		}

		val digits = n.toString
		val positions = (0 until digits.length).reverse.toSeq

		(digits zip positions)
			.map { case (d, p) => 
				digitToRoman(d.toString.toInt, p)
			}.mkString("")
	}

}

