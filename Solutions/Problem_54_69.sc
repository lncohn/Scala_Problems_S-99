object Problem_54_69 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import binarytree._
  
  Node('a',Node('b', Node('d'), Node('e')),Node('c', End, Node('f', Node('g'), End))).toString
                                                  //> res0: String = T(a T(b T(d . .) T(e . .)) T(c . T(f T(g . .) .)))
  
  Tree.cBalanced(2, "x")                          //> res1: List[binarytree.Tree[String]] = List(T(x . T(x . .)), T(x T(x . .) .))
                                                  //| 
  Node('a', Node('b'), Node('c')).isSymmetric     //> res2: Boolean = true
  Node('x',Node('x',End,Node('x',End,End)),Node('x',End,End)).isSymmetric
                                                  //> res3: Boolean = false
  
  End.addValue(2).addValue(3).addValue(0)         //> res4: binarytree.Tree[Int] = T(2 T(0 . .) T(3 . .))
    
  Tree.fromList(List(3, 2, 5, 7, 1))              //> res5: binarytree.Tree[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))
  Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric
                                                  //> res6: Boolean = true
                                                  
  Tree.symmetricBalancedTrees(5, "x")             //> res7: List[binarytree.Tree[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) 
                                                  //| .)), T(x T(x T(x . .) .) T(x . T(x . .))))
  Tree.minHbalNodes(3)                            //> res8: Int = 4
  Tree.maxHbalHeight(4)                           //> res9: Int = 3
  Tree.hbalTreesWithNodes(2, "x")                 //> res10: List[binarytree.Tree[String]] = List(T(x T(x . .) .), T(x . T(x . .))
                                                  //| )
                                                  
  Node('x', Node('x'), End).leafCount             //> res11: Int = 1
  Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
                                                  //> res12: List[Char] = List(b, d, e)
  Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
                                                  //> res13: List[Char] = List(a, c)
  Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
                                                  //> res14: List[Char] = List(b, c)
}