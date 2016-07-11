object Problem_28 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
 
  
  def lsort[String](ls: List[List[String]]): List[List[String]] = ls.sortWith( _.length < _.length)
                                                  //> lsort: [String](ls: List[List[String]])List[List[String]]
  
  
  lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
                                                  //> res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('
                                                  //| m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
}