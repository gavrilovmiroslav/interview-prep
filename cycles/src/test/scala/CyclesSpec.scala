package gm.interview.cycles

import org.scalatest._

class CyclesSpec extends FlatSpec with Matchers {

	"A list" should "have no cycles if it has 1 element with no tail" in {
		val singleton = new Node(1, None)
		singleton should not be 'cyclic
		singleton shouldBe 'cheap
	}

	it should "have a cycle if any element is mentioned more than once" in {
		lazy val two: Node = new Node(2, Some(three))
		lazy val three: Node = new Node(3, Some(four))
		lazy val four: Node = new Node(4, Some(two))
		val one: Node = new Node(1, Some(two))
		one shouldBe 'cyclic
		one shouldBe 'cheap
	}

	it should "work even though there's only one self-referential element" in {
		lazy val one: Node = new Node(1, Some(one))
		one shouldBe 'cyclic
		one shouldBe 'cheap
	}
}

