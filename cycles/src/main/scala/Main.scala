package gm.interview.cycles

import scala.collection.mutable.{ Map => Mutmap }

object `package` {
	type M = Mutmap[Node, Int]

	class Node(val v: Int, n: => Option[Node]) {
		def next: Option[Node] = n
		def cyclic: Boolean = isCyclic(this)
		def cheap: Boolean = floyd(this)
	}

	def isCyclic(n: Node): Boolean = {
		val nodes: M = Mutmap[Node, Int]().withDefaultValue(0)

		def isCyclicRec(on: Option[Node]): Boolean = on match {
			case Some(n) =>
				val count = nodes(n)
				if(count > 1) return true

				nodes(n) += 1

				isCyclicRec(n.next)
			case None => 
				false
		}

		isCyclicRec(Option(n))
	}

	def floyd(n: Node): Boolean = {
		def isCyclicRec(slow: Node, fast: Node): Boolean = 
			if(slow == fast) 
				return true
			else if(slow.next.isEmpty || fast.next.isEmpty)
				return false
			else
				isCyclicRec(slow.next.get, fast.next.get)

		isCyclicRec(n, n)
	}
}

