object Problem_1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Find the last element in a List
  
  def last(xs:List[Int]): Int = xs match{
  	 case ys :: Nil => ys
  	 case y::ys => last(ys)
  	 case _ => throw new NoSuchElementException
  }                                               //> last: (xs: List[Int])Int
  
  last(List(1,2,3,4))                             //> res0: Int = 4
  
  
}