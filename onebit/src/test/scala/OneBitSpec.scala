package gm.interviews.onebit

import org.scalatest._

class OneBitSpec extends FlatSpec with Matchers {

	"Two numbers differing in one bit" should "XOR into a square of two" in {
		assert(gray(0, 1)) 	// 0000, 0001
		assert(gray(7, 15)) // 0111, 1111
		assert(gray(7, 5))	// 0111, 0101
		assert(gray(1, 3))	// 0001, 0011
	}

	"Two numbers that aren't gray" should "not exhibit this behaviour" in {
		assert(!gray(0, 0))	// 0000, 0000
		assert(!gray(1, 2)) // 0001, 0010
	}
}

