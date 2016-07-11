object Problem_19 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def rotate[A](n:Int, ls:List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)
  }                                               //> rotate: [A](n: Int, ls: List[A])List[A]

 
  rotate(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> res0: List[Symbol] = List('c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b)
}