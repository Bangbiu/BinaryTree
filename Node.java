public class Node{
	Node parent;
	Node leftNode;
	Node rightNode;
	String name;
	public Node(){
	
	}
	public Node(Node parent)
	{
		this.parent=parent;
	}
	public Node(Node left,Node right)
	{
		this.leftNode=left;
		this.rightNode=right;
	}
	public Node(Node parent,Node left,Node right)
	{
		this.leftNode=left;
		this.rightNode=right;
		this.parent=parent;
	}
	//hashcode;
}