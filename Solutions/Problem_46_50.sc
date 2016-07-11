object Problem_46_50 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import logic.S99Logic._
  
  and(true, true)                                 //> res0: Boolean = true
  xor(true,true)                                  //> res1: Boolean = false
  table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
                                                  //> A     B     result
                                                  //| true  true  true 
                                                  //| true  false true 
                                                  //| false true  false
                                                  //| false false false
  
}