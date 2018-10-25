package gm.interviews.clonerandom

class Node(val v: Int, n: => Option[Node], r: => Option[Node]) {
	def next = n
	def rando = r

	override def toString = s"$v" +
		s" -!> ${n.map { _.v }.getOrElse("x")}" +
		s" -?> ${r.map { _.v }.getOrElse("x")}"
}

object Node {
	def asString(n: Node): String = {
		def rec(n: Node): Seq[String] = 
			Seq(n.toString) ++ n.next.map { rec(_) }.getOrElse(Seq())
		
		rec(n).mkString("\n")
	}
}

object CloneRandom {
	def clone(n: Node): Node = {
		var refl = Map[Node, Node]()

		def cloneRec(input: Option[Node]): Option[Node] = input match {
			case Some(n) =>
				if(refl.contains(n))
					Option(refl(n))
				else {
					lazy val newClone = new Node(n.v, 
						cloneRec(n.next), 
						cloneRec(n.rando))
					refl = refl + (n -> newClone)
					Option(newClone)
				}
			case None =>
				None
		}

		cloneRec(Option(n)).get
	}
}

