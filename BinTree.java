public class BinTree{
	public String name;
	public Node root;
	
	public BinTree()
	{
		name="";
	}
	
	public BinTree(String name,Node root)
	{
		this.name=name;
		this.root=root;
	}
	
	public BinTree(String name)
	{
		this.name=name;
	}
	public BinTree buildTree(Node root,String DLR,String LDR,String LRD)
	{
		
		return buildTree(root,DLR,LDR,LRD,',');
	}
	public BinTree buildTree(Node root,String DLR,String LDR,String LRD,char Separator)
	{
		/*
		if(DLR!=null && LDR!=null)
			return buildByFM(root,DLR,LDR,Separator);
		else if(DLR!=null && LDR!=null)
			return buildByFR(root,DLR,LRD,Separator);
		else if(LDR!=null && LRD!=null)
			return buildByMR(root,LDR,LRD,Separator);
		else
			return null;
		*/
		return null;
	}
	/*
	private BinTree buildByFM(Node root,String DLR,String LDR,char Separator)
	{
	
	}
	
	private BinTree buildByFR(Node root,String DLR,String LRD,char Separator)
	{
	
	}

	private BinTree buildByMR(String LDR,String LRD,char Separator)
	{
	
	}
	*/

	
	//DLR
	public String getDLR(){
		return getDLR(this.root);
	}
	
	public String getDLR(Node root){
		return getDLR(root,',');
	}
	public String getDLR(Node root,char Separator){
		if(root==null)return "";
		return root.name+ addSepL(getDLR(root.leftNode,Separator),Separator)+ addSepL(getDLR(root.rightNode,Separator),Separator);
	}
	
	//LDR
	public String getLDR(){
		return getLDR(this.root);
	}
	
	public String getLDR(Node root){
		return getLDR(root,',');
	}
	
	public String getLDR(Node root,char Separator){
		if(root==null)return "";
		return addSepR(getLDR(root.leftNode,Separator),Separator)+root.name +addSepL(getLDR(root.rightNode,Separator),Separator);
	}
	
	//LRD
	public String getLRD(){
		return getLRD(this.root);
	}
	
	public String getLRD(Node root){
		return getLRD(root,',');
	}
	
	public String getLRD(Node root,char Separator){
		if(root==null)return "";
		return addSepR(getLRD(root.leftNode,Separator),Separator) + addSepR(getLRD(root.rightNode,Separator),Separator)+root.name;
	}
	
	//findNode
	public Node getNode(String name)
	{
		return getNode(this.root,name);
	}
	
	public Node getNode(Node root,String name)
	{
		//Self
		if(root==null)return null;
		if(root.name.equals(name))return root;
		//L Tree
		Node Lres=getNode(root.leftNode,name);
		if(Lres!=null)return Lres;
		//R Tree
		Node Rres=getNode(root.rightNode,name);
		return Rres;
	}
	
	//Depth
	public int getDepth(){
		return getDepth(this.root);
	}
	
	public int getDepth(BinTree tree)
	{
		return getDepth(tree.root);
	}
	
	public int getDepth(Node root)
	{
		if(root==null)return 0;
		int layL=getDepth(root.leftNode);
		int layR=getDepth(root.rightNode);
		if(layL>layR)
			return layL+1;
		else
			return layR+1;
	}
	
	private String addSepL(String oriStr,char Separator){
		if(oriStr!="")
			return  Separator+oriStr;
		else
			return "";
	}
	private String addSepR(String oriStr,char Separator){
		if(oriStr!="")
			return oriStr+Separator;
		else
			return "";
	}
	

}