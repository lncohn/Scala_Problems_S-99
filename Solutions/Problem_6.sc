object Problem_6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def reverse(xs: List[Int]) : List[Int] = xs match {
  	case Nil => xs
  	case x::xs => reverse(xs):::List(x)
  }                                               //> reverse: (xs: List[Int])List[Int]
  
  def isPalindrome(xs:List[Int]): Boolean = {
   xs == reverse(xs)
  }                                               //> isPalindrome: (xs: List[Int])Boolean
 
  
  isPalindrome(List(1, 2, 3, 2, 1))               //> res0: Boolean = true
}