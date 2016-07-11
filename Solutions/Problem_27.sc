object Problem_27 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }                                             //> flatMapSublists: [A, B](ls: List[A])(f: List[A] => List[B])List[B]
    
    flatMapSublists(List('a, 'b))(e => List(e++List('c)))
                                                  //> res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('b, 'c))
  
  def combinations[A](n: Int, ls: List[A]): List[List[A]] = {
  	if (n == 0) List(Nil)
  	else flatMapSublists(ls) { sl => combinations(n - 1, sl.tail) map {sl.head :: _}}
  }                                               //> combinations: [A](n: Int, ls: List[A])List[List[A]]
  
  combinations(3, List('a, 'b, 'c, 'd))           //> res1: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a,
                                                  //|  'c, 'd), List('b, 'c, 'd))
  
  
  def group[A](ns: List[Int], names: List[A]): List[List[List[A]]] = ns match {
    case Nil     => List(Nil)
    case n :: ns => combinations(n, names) flatMap { c => (group(ns, names diff c) map {c :: _}) }
  }                                               //> group: [A](ns: List[Int], names: List[A])List[List[List[A]]]
  
  group(List(2, 1), List("Aldo", "Beat", "Carla"))//> res2: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla)), L
                                                  //| ist(List(Aldo, Carla), List(Beat)), List(List(Beat, Carla), List(Aldo)))
 
 }