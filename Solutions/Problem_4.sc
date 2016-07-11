object Problem_4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def length(xs: List[Int]) : Int = xs match {
  	case Nil => 0
  	case x::xs => 1+length(xs)
  }                                               //> length: (xs: List[Int])Int
  
  length(List(1, 1, 2, 3, 5, 8))                  //> res0: Int = 6
  
}