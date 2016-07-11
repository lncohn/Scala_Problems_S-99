object Problem_24 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def range(n:Int, m:Int):List[Int] = {
  	if (n > m) throw new NoSuchElementException
  	else if (n == m) List(n)
  	else (n,m) match {
  		case (n,m) => n :: range(n+1,m)
  	}
  }                                               //> range: (n: Int, m: Int)List[Int]
  range(4, 9)                                     //> res0: List[Int] = List(4, 5, 6, 7, 8, 9)
  
  def removeAt[A](n:Int, ls:List[A]): (List[A],A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }                                             //> removeAt: [A](n: Int, ls: List[A])(List[A], A)

  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = removeAt(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new util.Random)
  }                                               //> randomSelect: [A](n: Int, ls: List[A])List[A]
  
  
  def lotto(n:Int, l:Int): List[Int] = randomSelect(n,range(1,l))
                                                  //> lotto: (n: Int, l: Int)List[Int]
  
  
  lotto(6, 49)                                    //> res1: List[Int] = List(31, 12, 45, 21, 47, 1)
}