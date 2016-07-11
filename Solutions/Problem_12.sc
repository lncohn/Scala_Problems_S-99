object Problem_12 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def make[A](n:Int,x:A): List[A] = {
  	if (n == 0) List()
  	else if (n == 1) List(x)
  	else x::make(n-1,x)
  }                                               //> make: [A](n: Int, x: A)List[A]
  
  make(3,'a)                                      //> res0: List[Symbol] = List('a, 'a, 'a)
  
  def decode[A](ls: List[(Int, A)]): List[A] = ls flatMap { e => make(e._1, e._2) }
                                                  //> decode: [A](ls: List[(Int, A)])List[A]
  
  decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
                                                  //> res1: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e
                                                  //| , 'e)
}