public class BinTree{
	public Node root;
	public BinTree buildTree(Node root,String DLR,String LDR,String LRD)
	{
		return buildTree(root,DLR,LDR,LRD,",");
	}
	public BinTree buildTree(Node root,String DLR,String LDR,String LRD,char Separator)
	{
		if(DLR!=null && LDR!=null)
			return buildByFM(root,DLR,LDR,Separator);
		else if(DLR!=null && LDR!=null)
			return buildByFR(root,DLR,LRD,Separator);
		else if(LDR!=null && LRD!=null)
			return buildByMR(root,LDR,LRD,Separator);
		else
			return null;
		
	}
	private BinTree buildByFM(Node root,String DLR,String LDR,char Separator)
	{
		//example pre  1 2 4 7 8 10 12 5 3 6 9 11
		//example mid  7 4 2 1 3 9 11 6 5 8 12 10
		//example suf  7 12 10 8 4 5 2 11 9 6 3 1
		int root 
	}
	
	private BinTree buildByFR(Node root,String DLR,String LRD,char Separator)
	{
	
	}

	private BinTree buildByMR(String LDR,String LRD,char Separator)
	{
	
	}
	
	public String getDLR(){
		
	}
	
	public String getLDR(){
		
	}
	
	public String getLRD(){
		
	}
	
	public Node findNode(String name)
	{
		
	}
	
	public Node getLayer(Node node)
	{
		
	}
	
}