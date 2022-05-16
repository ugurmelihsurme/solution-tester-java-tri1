package com.yasirkula.bitesdemo;

public class Question2 implements RightToBinaryTree
{
	public Node connect( Node root )
	{
		Node _root = root;
		while( _root != null ) // Iterate through each depth from left-to-right
			_root = getLeftmostDescendantNodeRecursive( _root );
		
		return root;
	}
	
	private Node getLeftmostDescendantNodeRecursive( Node node )
	{
		Node nextResult = ( node.next != null ) ? getLeftmostDescendantNodeRecursive( node.next ) : null;
		
		if( node.right != null )
		{
			node.right.next = nextResult;
			
			if( node.left != null )
			{
				node.left.next = node.right;
				return node.left;
			}
			
			return node.right;
		}
		else if( node.left != null )
		{
			node.left.next = nextResult;
			return node.left;
		}
		else
			return nextResult;
	}
}