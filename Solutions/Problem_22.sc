object Problem_22 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def range(n:Int, m:Int):List[Int] = {
  	if (n > m) throw new NoSuchElementException
  	else if (n == m) List(n)
  	else (n,m) match {
  		case (n,m) => n :: range(n+1,m)
  	}
  }                                               //> range: (n: Int, m: Int)List[Int]
  range(4, 9)                                     //> res0: List[Int] = List(4, 5, 6, 7, 8, 9)
}