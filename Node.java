public class Node{
	Node parent;
	Node leftNode;
	Node rightNode;
	String name;
	
	public Node(){
		name="";
	}
	public Node(String name)
	{
		this.name=name;
	}
	public Node(String name,Node parent)
	{
		this.name=name;
		this.parent=parent;
	}
	public Node(String name,Node left,Node right)
	{
		this.name=name;
		this.leftNode=left;
		this.rightNode=right;
	}
	public Node(String name,Node parent,Node left,Node right)
	{
		this.name=name;
		this.leftNode=left;
		this.rightNode=right;
		this.parent=parent;
	}
	//hashcode;
}