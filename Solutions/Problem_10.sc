object Problem_10 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }                                               //> pack: [A](ls: List[A])List[List[A]]
  
  def encode[A](ls:List[A]):List[(A,Int)] = {
  	if(ls.isEmpty) List()
  	else {
      val (packed, next) = ls span { _ == ls.head }
      if (next == Nil) List((ls.head,packed.length))
      else (ls.head,packed.length) :: encode(next)
    }
  }                                               //> encode: [A](ls: List[A])List[(A, Int)]
  
  encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  //> res0: List[(Symbol, Int)] = List(('a,4), ('b,1), ('c,2), ('a,2), ('d,1), ('e
                                                  //| ,4))
}