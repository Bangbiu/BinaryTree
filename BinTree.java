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