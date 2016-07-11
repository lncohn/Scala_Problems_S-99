object Problem_26 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }                                             //> flatMapSublists: [A, B](ls: List[A])(f: List[A] => List[B])List[B]
    
    flatMapSublists(List('a, 'b))(e => List(e++List('c)))
                                                  //> res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('b, 'c))
  
  def combinations[A](n: Int, ls: List[A]): List[List[A]] = {
  	if (n == 0) List(Nil)
  	else flatMapSublists(ls) { sl => combinations(n - 1, sl.tail) map {sl.head :: _}}
  }                                               //> combinations: [A](n: Int, ls: List[A])List[List[A]]
  
  combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))   //> res1: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a,
                                                  //|  'b, 'e), List('a, 'b, 'f), List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c,
                                                  //|  'f), List('a, 'd, 'e), List('a, 'd, 'f), List('a, 'e, 'f), List('b, 'c, 'd)
                                                  //| , List('b, 'c, 'e), List('b, 'c, 'f), List('b, 'd, 'e), List('b, 'd, 'f), Li
                                                  //| st('b, 'e, 'f), List('c, 'd, 'e), List('c, 'd, 'f), List('c, 'e, 'f), List('
                                                  //| d, 'e, 'f))
}