package gm.interviews.priorityqueue

trait Heap[T <: Comparable[T], H <: Heap[T, H]] { self: H =>
	def push(element: T): H // inserts new element
	def peek: Option[T]		// peeks at the root element
	def pop: Option[T]		// pops the root element
	def union(h: H): H 		// merges two heaps into a new valid heap
}

object Heap {
	def like[T <: Comparable[T], H <: Heap[T, H]](h: => H) = new {
		def from(elements: Seq[T]): H = 
			elements.foldLeft(h) { _.push(_) }
	}
}
