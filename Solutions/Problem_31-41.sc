object Problem_31 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import arithmetic.S99Int._
  
  5.isPrime                                       //> res0: Boolean = true
  
  gcd(7,8)                                        //> res1: Int = 1
  
  7.isCoprimeTo(64)                               //> res2: Boolean = true
  
  10.totient                                      //> res3: Int = 4
  
  315.primeFactors                                //> res4: List[Int] = List(3, 3, 5, 7)
  
  315.primeFactorMultiplicity                     //> res5: List[(Int, Int)] = List((3,2), (5,1), (7,1))
  
	listPrimesinRange(7 to 31)                //> res6: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
	
	28.goldbach                               //> res7: (Int, Int) = (5,23)
	
	printGoldbachList(9 to 22)                //> 10 = 3 + 7
                                                  //| 12 = 5 + 7
                                                  //| 14 = 3 + 11
                                                  //| 16 = 3 + 13
                                                  //| 18 = 5 + 13
                                                  //| 20 = 3 + 17
                                                  //| 22 = 3 + 19
}