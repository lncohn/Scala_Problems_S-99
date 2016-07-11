object Problem_8 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def compress[A](xs:List[A]):List[A] = xs match {
  	case Nil => Nil
  	case e::Nil => List(e)
  	case x1::x2::xs => if(x1 != x2) x1::compress(x2::xs) else compress(x2::xs)
  }                                               //> compress: [A](xs: List[A])List[A]
  
  compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  //> res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
}