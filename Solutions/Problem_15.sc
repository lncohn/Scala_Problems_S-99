object Problem_15 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def make[A](n:Int,x:A): List[A] = {
  	if (n == 0) List()
  	else if (n == 1) List(x)
  	else x::make(n-1,x)
  }                                               //> make: [A](n: Int, x: A)List[A]
  
  make(3,'a)                                      //> res0: List[Symbol] = List('a, 'a, 'a)
  
  def duplicateN[A](n:Int,ls:List[A]): List[A] = ls flatMap { make(n,_) }
                                                  //> duplicateN: [A](n: Int, ls: List[A])List[A]
  
  duplicateN(3, List('a, 'b, 'c, 'c, 'd))         //> res1: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd
                                                  //| , 'd, 'd)
}