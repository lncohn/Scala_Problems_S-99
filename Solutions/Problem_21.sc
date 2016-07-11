object Problem_21 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
 def insertAt[A](elem:A, n:Int, ls:List[A]): List[A] = {
  	if( n < 0) throw new NoSuchElementException
  	else (elem,n,ls) match {
  		case (elem,_,Nil) => List(elem)
  		case (elem,0,ls) => elem :: ls
  		case (elem,n,l::ls) => l::insertAt(elem,n-1,ls)
  	}
  }                                               //> insertAt: [A](elem: A, n: Int, ls: List[A])List[A]
  
  insertAt('new, 2, List('a, 'b, 'c, 'd))         //> res0: List[Symbol] = List('a, 'b, 'new, 'c, 'd)
}