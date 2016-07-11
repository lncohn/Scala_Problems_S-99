package binarytree {

  sealed abstract class Tree[+T] {
    def isMirrorOf[V](tree:Tree[V]): Boolean
    def isSymmetric: Boolean
    def addValue[U >: T <% Ordered[U]](x: U): Tree[U]
    def nodeCount: Int
    def leafCount: Int
    def leafList: List[T]
    def internalList: List[T]
    def atLevel(level: Int): List[T]
  }

  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
    
    def nodeCount: Int = left.nodeCount + right.nodeCount + 1
    
    def leafCount: Int = (left, right) match {
      case (End, End) => 1
      case _          => left.leafCount + right.leafCount
    }
    
    def leafList: List[T] = (left, right) match {
      case (End, End) => List(value)
      case _          => left.leafList ++ right.leafList
    }
    
    def internalList: List[T] = (left, right) match {
      case (End, End) => Nil
      case _          => value :: left.internalList ::: right.internalList
    }
    
    def atLevel(level: Int): List[T] = level match {
      case n if n < 1 => Nil
      case 1 => List(value)
      case n => left.atLevel(n-1) ++ right.atLevel(n-1)
    }
    
    def isMirrorOf[V](tree: Tree[V]): Boolean = tree match {
      case Node(v,l,r) => left.isMirrorOf(r) && right.isMirrorOf(l)
      case _ => false
    }
    
    def isSymmetric = left.isMirrorOf(right)
    
    def addValue[U >: T <% Ordered[U]](x: U) = {
      if( x < value) Node(value,left.addValue(x),right)
      else Node(value,left,right.addValue(x))
    }
  }

  case object End extends Tree[Nothing] {
    override def toString = "."
    def nodeCount: Int = 0
    def leafCount: Int = 0 
    def leafList = Nil
    def internalList = Nil
    def atLevel(level: Int) = Nil
    def isMirrorOf[V](tree: Tree[V]): Boolean = (tree == End)
    def isSymmetric: Boolean = true
    def addValue[U <% Ordered[U]](x: U) = Node(x)
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End) 
  }
  
  object Tree {
    def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
      case n if n < 1 => List(End)
      case n if n % 2 == 1 => {
        val subtrees = cBalanced(n / 2, value)
        subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
      }
      case n if n % 2 == 0 => {
        val lesserSubtrees = cBalanced((n - 1) / 2, value)
        val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
        lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
      }
    }
    
    
    def fromList[T <% Ordered[T]](ls: List[T]): Tree[T] = {
      ls.foldLeft(End: Tree[T])((r,e) => r.addValue(e))
    }
    
    def symmetricBalancedTrees[T](n: Int, value: T): List[Tree[T]] = cBalanced(n,value).filter(t => t.isSymmetric)
    
    def hbalTrees[T](height: Int, value: T): List[Tree[T]] = height match {
      case n if n < 1 => List(End)
      case 1          => List(Node(value))
      case _ => {
        val fullHeight = hbalTrees(height - 1, value)
        val short = hbalTrees(height - 2, value)
        fullHeight.flatMap(l => fullHeight.map(r => Node(value, l, r))) :::
        fullHeight.flatMap(f => short.flatMap(s => List(Node(value, f, s), Node(value, s, f))))
      }
    }
    
    def minHbalNodes(height: Int): Int = height match {
      case n if n < 1 => 0
      case 1          => 1
      case n          => minHbalNodes(n - 1) + minHbalNodes(n - 2) + 1
    }
    
    def maxHbalNodes(height: Int): Int = 2 * height - 1
    
    def minHbalHeight(nodes: Int): Int =
      if (nodes == 0) 0
      else minHbalHeight(nodes / 2) + 1
      
    def maxHbalHeight(nodes: Int): Int = 
      Stream.from(1).takeWhile(minHbalNodes(_) <= nodes).last
      
    def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] =
      (minHbalHeight(nodes) to maxHbalHeight(nodes)).flatMap(hbalTrees(_, value)).filter(_.nodeCount == nodes).toList
    
  }//object tree
}//package