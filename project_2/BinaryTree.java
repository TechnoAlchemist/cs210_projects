public class BinaryTree
 {  
	 private Node rootNode;
	 public static class Node
	 { 
		
		 int data, N; 
		 Node left; 
		 Node right; 
		 Node(int data, int N) { 
			.....
		 } 
	 }  
	 // return true if this symbol table is empty; 
	 public boolean isEmpty() {
	        .....
	    }
	     
	//Returns the number of key-value pairs in this symbol table.  
	 public int size() {
	        .....
	    }
	 
	 // return number of key-value pairs in BST rooted at x
	    public static int size(Node x) {
	       .....
	    } 
	    
	// In order code    
 	public void inOrder(Node root) { 
 		......
 		}
 	//Pre order code
 	public void preOrder(Node root){
 		.......
 	}
 	//Post order code
 	public void postOrder(Node root){
 		.......
 	}
 	// left-leaning link lean to the right
 	private Node rotateRight(Node h) {
        .......
    }
 	
 	  // right-leaning link lean to the left
    private Node rotateLeft(Node h) {
       ........
    }
 	
 	public static void main(String[] args) { 
 		BinaryTree bi=new BinaryTree(); // Creating a binary tree 
 		Node rootNode=createBinary(); 
 		
 		System.out.println(" Inorder");
 		bi.inOrder(rootNode);  
 		System.out.println("\n Preorder");
 		bi.preOrder(rootNode);
 		System.out.println("\n Postorder");
 		bi.postOrder(rootNode);
 		
 		rootNode = bi.rotateLeft(rootNode);
 		System.out.println("\n Preorder after rotateLeft");
 		bi.preOrder(rootNode);
 		
 		rootNode = bi.rotateRight(rootNode);
 		System.out.println("\n Preorder after rotateRight");
 		bi.preOrder(rootNode);
 		} 
 		public static Node createBinary() { 
 			Node rootNode =new Node(40, 1); 
 			Node node20=new Node(20, 1); 
 			Node node10=new Node(10, 1); 
 			Node node30=new Node(30, 1); 
 			Node node60=new Node(60, 1); 
 			Node node50=new Node(50, 1); 
 			Node node70=new Node(70, 1); 
 			rootNode.left=node20; 
 			rootNode.right=node60; 
 			node20.left=node10; 
 			node20.right=node30; 
 			node60.left=node50; 
 			node60.right=node70; 
 			return rootNode; 
 	}
 }
