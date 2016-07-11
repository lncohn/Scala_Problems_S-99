object Problem_14 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def duplicate[A](ls:List[A]):List[A] = ls flatMap {e => List(e,e)}
                                                  //> duplicate: [A](ls: List[A])List[A]
  
  duplicate(List('a, 'b, 'c, 'c, 'd))             //> res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
}