package gm.interviews.stockprices

import org.scalatest._

class StockPricesSpec extends FlatSpec with Matchers {

	"Profit" should "be positive" in {
		best(Seq(10, 7, 5, 8, 11, 9)) should equal (6)
		best(Seq(9, 1, 10)) should equal (9)
		best(Seq(1, 9)) should equal (8)
		best(Seq(9, 1)) should equal (0)
		best(Seq(19, 11, 10)) should equal (0)
	}
}