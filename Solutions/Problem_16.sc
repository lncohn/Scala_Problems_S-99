object Problem_16 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def drop[A](n: Int, ls: List[A]): List[A] = {
  	if(ls == Nil) throw new NoSuchElementException
  	else if(n == 0) ls.tail
  	else ls.head::drop(n-1,ls.tail)
  }                                               //> drop: [A](n: Int, ls: List[A])List[A]
  
  drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> res0: List[Symbol] = List('a, 'b, 'c, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
}