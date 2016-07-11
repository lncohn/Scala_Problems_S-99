object Problem_17 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
  	case (_,Nil) => (Nil,Nil)
  	case (0,_) => (Nil,ls)
  	case (n, h :: tail) => {
  		val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
  	}
  }                                               //> splitRecursive: [A](n: Int, ls: List[A])(List[A], List[A])
  
  splitRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 
                                                  //| 'h, 'i, 'j, 'k))
}