object Problem_3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def nth[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (1, h :: _   ) => h
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }                                               //> nth: [A](n: Int, ls: List[A])A
  
  
  nth(3, List(1,2,3,4))                           //> res0: Int = 3
  
}