object Problem_5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def reverse(xs: List[Int]) : List[Int] = xs match {
  	case Nil => xs
  	case x::xs => reverse(xs):::List(x)
  }                                               //> reverse: (xs: List[Int])List[Int]
  
  reverse(List(1, 1, 2, 3, 5, 8))                 //> res0: List[Int] = List(8, 5, 3, 2, 1, 1)
}