object Problem_23 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
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
  
  
  randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
                                                  //> res0: List[Symbol] = List('b, 'd, 'f)
}