package gm.interviews.stockprices

object `package` {
	def best(nums: Seq[Int]): Int = {
		assert(nums.length >= 2)

		var minPrice = nums.head
		var maxProfit = nums.tail.head - nums.head

		nums.foreach { stock =>
			maxProfit = Math.max(maxProfit, stock - minPrice)
			minPrice = Math.min(minPrice, stock)
		}

		maxProfit
	}
}

