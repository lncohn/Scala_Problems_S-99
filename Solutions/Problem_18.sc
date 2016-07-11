object Problem_18 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def slice[A](n:Int, m:Int,ls:List[A]): List[A] =
  	if(n > m) throw new NoSuchElementException
  	else { (n,m,ls) match {
  		case(_,_,Nil) => Nil
	  	case(0,m,ls) => ls.take(m).toList
	  	case(n,m,l::ls) => slice(n-1,m,ls)
   }
  }                                               //> slice: [A](n: Int, m: Int, ls: List[A])List[A]
  
  slice(2, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> res0: List[Symbol] = List('c, 'd, 'e, 'f, 'g, 'h, 'i)
}