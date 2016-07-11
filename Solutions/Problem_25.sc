object Problem_25 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
   
  
  def randomPermute(ls: List[Char]): List[Char] = {
    val rand = new util.Random
    val a = ls.toArray
    for (i <- 0 to rand.nextInt(a.length) by 1) {
      val i1 = rand.nextInt(i + 1)
      val t = a(i)
      a.update(i, a(i1))
      a.update(i1, t)
    }
    a.toList
  }                                               //> randomPermute: (ls: List[Char])List[Char]
  
  randomPermute(List('a', 'b', 'c', 'd', 'e', 'f'))
                                                  //> res0: List[Char] = List(e, b, c, a, d, f)
  
}