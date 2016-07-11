package arithmetic {
  class S99Int(val start: Int) {
    import S99Int._
    
    def isPrime: Boolean = (start > 1) && (primes takeWhile { _ <= Math.sqrt(start) } forall { start % _ != 0 })
    
    def isCoprimeTo (myInt : Int): Boolean = {gcd(start,myInt)==1}
    
    def totient: Int = (1 to start) filter { start.isCoprimeTo(_) } length
    
    def primeFactors: List[Int] = {
     def primeFactorsR(n: Int, ps: Stream[Int]): List[Int] =
      if (n.isPrime) List(n)
      else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
      else primeFactorsR(n, ps.tail)
     primeFactorsR(start, primes)
    }
    
    def pack[A](ls: List[A]): List[List[A]] = {
      if (ls.isEmpty) List(List())
      else {
        val (packed, next) = ls span { _ == ls.head }
        if (next == Nil) List(packed)
        else packed :: pack(next)
      }
    }
    
    def encode[A](ls: List[A]): List[(A, Int)] = pack(ls) map { e => (e.head, e.length) }
    
    def primeFactorMultiplicity: List[(Int, Int)] = encode(start.primeFactors) 
    
   def goldbach: (Int,Int) =
    primes takeWhile { _ < start } find { p => (start - p).isPrime } match {
      case None     => throw new IllegalArgumentException
      case Some(p1) => (p1, start - p1)
    }
    
    
    
  } //end of class

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
    
    val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
    
    def gcd(m: Int, n: Int): Int = if (n == 0) m else gcd(n, m % n)
    
    def listPrimesinRange(r: Range): List[Int] = {
      def listPrimesinRangeR(range: Range, ps: Stream[Int]): List[Int] = (ps dropWhile {_ < range.start} takeWhile { _ <= range.end }).toList
      listPrimesinRangeR(r,primes)
    }
    
    def printGoldbachList(r: Range) = {
      (r filter { n => n > 2 && n % 2 == 0 } map { n => (n, n.goldbach) } 
      foreach { _ match { case (n, (p1, p2)) => println(n + " = " + p1 + " + " + p2) }
     })
    }
      
    
  }//end of object
}//end of package