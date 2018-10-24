package gm.interviews.intersects

import org.scalatest._

class IntersectsSpec extends FlatSpec with Matchers {

  // Lines intersect only if we can solve their 
  // system of equations!

  "Parallel lines" should "never intersect" in {
  	// parallel means same slope, different offsets

  	assert((3.x + 5) doesntIntersect (3.x + 7))
  	assert((22.x - 5) doesntIntersect (22.x + 7))
  }

  "Lines with different slopes" should "always intersect" in {
  	assert((3.x + 5) intersects (14.x + 5))
  	assert((-5.x + 1) intersects (4.x + 2))
  }

  "The same lines" should "intersect all the time" in {
  	assert((3.x + 5) intersects (3.x + 5))
  }
}

