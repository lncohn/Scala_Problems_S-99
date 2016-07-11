object Problem_9 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }                                               //> pack: [A](ls: List[A])List[List[A]]
  
  pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  //> res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c)
                                                  //| , List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  
}