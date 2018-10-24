package gm.interviews.onebit

object `package` {

	def gray(a: Int, b: Int): Boolean =
		// scala doesn't have log2, so...
		(Math.log10(a ^ b) / Math.log10(2)) % 1 == 0
}
