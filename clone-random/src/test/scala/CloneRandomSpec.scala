package gm.interviews.clonerandom

import org.scalatest._

class CloneRandomSpec extends FlatSpec with Matchers {
	def assertRepEqual(n: Node, m: Node) =
		assert(Node.asString(n) == Node.asString(m))

	"Cloning" should "just work" in {
		lazy val one: Node = new Node(1, Some(two), Some(three))
		lazy val two: Node = new Node(2, Some(three), Some(one))
		lazy val three: Node = new Node(3, Some(four), Some(three))
		lazy val four: Node = new Node(4, None, Some(two))

		val clone = CloneRandom.clone(one)

		assertRepEqual(one, clone)
	}

	it should "work even if the list is short and weird" in {
		lazy val one: Node = new Node(1, None, Some(one))

		val clone = CloneRandom.clone(one)
		assertRepEqual(one, clone)
	}

	it should "work even when the list is one element only" in {
		lazy val one: Node = new Node(1, None, None)

		val clone = CloneRandom.clone(one)
		assertRepEqual(one, clone)
	}
}

