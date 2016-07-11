object Problem_11 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 
	def encode[A](ls:List[A]):List[(A,Int)] = {
	  	if(ls.isEmpty) List()
	  	else {
	      val (packed, next) = ls span { _ == ls.head }
	      if (next == Nil) List((ls.head,packed.length))
	      else (ls.head,packed.length) :: encode(next)
	    }
	  }                                       //> encode: [A](ls: List[A])List[(A, Int)]
	  
  def encodeModified[A](ls: List[A]): List[Any] =
    encode(ls) map { t => if (t._2 == 1) t._1 else t }
                                                  //> encodeModified: [A](ls: List[A])List[Any]
  
  encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c))//> res0: List[Any] = List(('a,4), 'b, ('c,2))
  
}