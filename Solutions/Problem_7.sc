object Problem_7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
  	case ms: List[_] => flatten(ms)
  	case m => List(m)
  }                                               //> flatten: (ls: List[Any])List[Any]
  
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)
}