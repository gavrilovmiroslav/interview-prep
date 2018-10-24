package gm.interview.roman

import org.scalatest._

class RomanSpec extends FlatSpec with Matchers {
	"Roman numerals" should "be straight-forward up to 3" in {
		integerToRoman(1) should equal("I")
		integerToRoman(2) should equal("II")
		integerToRoman(3) should equal("III")
		integerToRoman(13) should equal("XIII")
		integerToRoman(23) should equal("XXIII")
		integerToRoman(123) should equal("CXXIII")
	}

	they should "have focal points" in {
		integerToRoman(5) should equal("V")
		integerToRoman(10) should equal("X")
		integerToRoman(50) should equal("L")
		integerToRoman(100) should equal("C")
		integerToRoman(1000) should equal("M")
	}

	they should "use the next radix for one smaller" in {
		integerToRoman(4) should equal("IV")
		integerToRoman(9) should equal("IX")
		integerToRoman(40) should equal("XL")
		integerToRoman(49) should equal("XLIX")
	}

	they should "progress the same as the first ones after a radix" in {
		integerToRoman(6) should equal("VI")
		integerToRoman(7) should equal("VII")
		integerToRoman(8) should equal("VIII")

		integerToRoman(51) should equal("LI")
		integerToRoman(52) should equal("LII")
		integerToRoman(53) should equal("LIII")

		integerToRoman(56) should equal("LVI")
		integerToRoman(57) should equal("LVII")
		integerToRoman(58) should equal("LVIII")
	}

	they should "go up to 3999" in {
		integerToRoman(3999) should equal("MMMCMXCIX")
	}
}

