object Problem_2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def penultimate(xs:List[Int]): Int = xs match {
  	case h1::h2::Nil => h1
  	case h1::h2::hs => penultimate(h2::hs)
  	case _ => throw new NoSuchElementException
  
  }                                               //> penultimate: (xs: List[Int])Int
  
  penultimate(List(1,2))                          //> res0: Int = 1
}