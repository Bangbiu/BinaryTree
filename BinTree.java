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
	private BinTree buildByAll(Node root,String DLR,String LDR,String LRD,char Separator)
	{
		//example pre  1 2 4 7 8 10 12 5 3 6 9 11
		//example mid  7 4 8 12 10 2 5 1 3 9 11 6
		//example suf  7 12 10 8 4 5 2 11 9 6 3 1
		//guess: exclude all right together with root from pre will be leftpre etc.
		//leftpre should be 2 4 7 8 10 12 5
		//               is 2 4 7 8 10 12 5
		//leftmid should be 7 4 8 12 10 2 5
		//               is 7 4 8 12 10 2 5
		//leftsuf should be 7 12 10 8 4 5 2
		//               is 7 12 10 8 4 5 2
		//guess verified
		BinTree building = new BinTree();
		
		int rootIndex;
		int numOfElements;
		int leftLength;
		int rightLength;
		String leftName;
		String rightName;
		
		String[] pre;
		String[] mid;
		String[] suf;
		
		numOfElements = getNumOfChar(',',DLR);
		
		pre = splitBySep(DLR,Separator,numOfElements);
		mid = splitBySep(LDR,Separator,numOfElements);
		suf = splitBySep(DLR,Separator,numOfElements);
		
		rootIndex = getIndexOfString(root.name,mid);
		
		leftLength = getLength(rootIndex,mid,true,true);
		rightLength = getLength(rootIndex,mid,false,true);
		
		String leftDLR = linkWithSep(pre,1,leftLength,Separator);
		String leftLDR = linkWithSep(mid,0,rootIndex,Separator);
		String leftLRD = linkWithSep(suf,rightLength+1,suf.length,Separator);
		
		String rightDLR = linkWithSep(pre,leftLength+1,pre.length,Separator);
		String rightLDR = linkWithSep(mid,rootIndex,mid.length,Separator);
		String rightLRD = linkWithSep(suf,leftLength,suf.length-1,Separator);
		
		/*
		leftDLR = DLR.substring(1,leftLength+1);
		leftLDR = LDR.substring(0,indexOf(root.name));
		letfLRD = LRD.sunstring(rightLength,LRD.length()-1);
																wrong!
		rightDLR = DLR.substring(leftLength+1);
		rightLDR = LDR.substring(indexOf(root.name)+1);
		rightLRD = LRD.sunstring(0,rightLength+1);
		*/
		
		
		
		if (!pre[1].equals(suf[suf.length-1]))
		{
			leftName = pre[1];
			rightName = suf[suf.length-1];
			this.root.leftNode = buildByAll(new Node(leftName),leftDLR,leftLDR,leftLRD,Separator).root;
			this.root.rightNode = buildByAll(new Node(rightName),rightDLR,rightLDR,rightLRD,Separator).root;
		}
		else if (leftLength == 0)
		{
			rightName = suf[suf.length-1];
			this.root.rightNode = buildByAll(new Node(rightName),rightDLR,rightLDR,rightLRD,Separator).root;
		}
		else if (rightLength == 0)
		{
			leftName = pre[1];
			this.root.leftNode = buildByAll(new Node(leftName),leftDLR,leftLDR,leftLRD,Separator).root;
		}
		return building;
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
	public String[] splitBySep(String source, char sep, int sepNum)
	{
		String[] re = new String[sepNum];
		int first = 0;
		int counter = 0; 
		for (int i = 0; i<source.length(); i++)
		{
			if (source.charAt(i) == sep)
			{
				re[counter] = source.substring(first,i); 
				first = i+1;
				counter++;	
			}
		}
		return re;
	}
	
	public int getLength(int rootIndex, String[] LDR, boolean direction,boolean ifConc)
	{
		
		int returnLength = 0;
		if (!ifConc)
		{
			if (direction)
			{
				for (int i = 0; i<rootIndex; i++)
				{
					returnLength += LDR[i].length();
				}
			}
			else
			{
				for (int i = rootIndex; i<LDR.length; i++)
				{
					returnLength += LDR[i].length();
				}
			}
		}
		else
		{
			returnLength = rootIndex-1;
		}
		return returnLength;
	}
	
	public int getIndexOfString(String target, String[] mid)
	{
		int rootIndex = 0;
		for (int i = 0; i<mid.length; i++)
		{
			if (mid[i].equals(target))
			{
				rootIndex = i;
				break;
			}
		}
		return rootIndex;
	}
	public int getNumOfChar(char a, String b)
	{
		int c = 0;
		for (int i = 0; i<b.length(); i++)
		{
			if (b.charAt(i) == a)
			{
				c++;
			}
		}
		return c;
	}
	public String linkWithSep(String[] target, int startIndex, int stopIndex, char separator)
	{
		String re = "";
		for (int i = startIndex; i<stopIndex; i++)
		{
			re.concat(target[i]);
			re = re+separator;
		}
		if (re.length() != 0)
		{
			return re;
		}
		else 
		{
			for (int i = 0; i<target.length; i++)  //testtttttttttttttttttttttttttttttttt here
			{
				System.out.println(target[i]);
			}
			System.out.println();
		}
		return null;
	}
	public static void main(String[] args)
	{
		//example pre  1 2 4 7 8 10 12 5 3 6 9 11
		//example mid  7 4 8 12 10 2 5 1 3 9 11 6
		//example suf  7 12 10 8 4 5 2 11 9 6 3 1
		Node root = new Node("1");
		BinTree tree = new BinTree();
		tree = tree.buildByAll(root,"1,2,4,7,8,10,12,5,3,6,9,11","7,4,8,12,10,2,5,1,3,9,11,6","7,12,10,8,4,5,2,11,9,6,3,1",',');
	}
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