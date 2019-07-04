import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TreeDisplayer extends JFrame
{
	private class GraphicPanel extends JPanel
	{
		private BinTree tree;
		private Dimension nodeSize;
		private Graphics graph;
		private int vertSpc;
		public GraphicPanel()
		{
			super();
		}
		public GraphicPanel(BinTree tree,Dimension nodeSize,int vertSpc)
		{
			this.tree=tree;
			this.nodeSize=nodeSize;
			this.vertSpc = vertSpc;
			this.setLayout(null);
		}
		
	    @Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.removeAll();
			graph=g;
			addTree(tree.root,new Point(getWidth()/2,0),getWidth()/4);
			graph=null;
		}

		private void addTree(Node root,Point rpos,int dist)
		{
			if(root==null)return;
			addNode(root,rpos);
			if(root.leftNode!=null){
				Point nextPosL=new Point(rpos.x-dist,rpos.y+vertSpc);
				addTree(root.leftNode,nextPosL,dist/2);
				drawConnection(offsetY(rpos,nodeSize.getHeight()/2),offsetY(nextPosL,nodeSize.getHeight()/2));
			}
			if(root.rightNode!=null){
				Point nextPosR=new Point(rpos.x+dist,rpos.y+vertSpc);
				addTree(root.rightNode,nextPosR,dist/2);
				drawConnection(offsetY(rpos,nodeSize.getHeight()/2),offsetY(nextPosR,nodeSize.getHeight()/2));
			}
		}
		
		private void addNode(Node node,Point pos)
		{
			JLabel newLb = new JLabel(node.name,JLabel.CENTER);
			newLb.setLocation(offsetX(pos,-nodeSize.getWidth()/2));
			newLb.setSize(nodeSize);
			newLb.setOpaque(true);
			newLb.setBackground(Color.WHITE);
			newLb.setVisible(true);
			newLb.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			this.add(newLb);
		}
		
		private void drawConnection(Point p1,Point p2)
		{
			graph.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
		
		private Point offsetX(Point ori,double offset)
		{
			return new Point((int)(ori.x+offset),ori.y);
		}
		private Point offsetY(Point ori,double offset)
		{
			return new Point(ori.x,(int)(ori.y+offset));
		}
	}
	//Display
	
	
	private GraphicPanel tG;
	
	public TreeDisplayer()
	{
		super();
	}
	
	public TreeDisplayer(BinTree tree)
	{
		super(tree.name);
		Setup(tree,new Dimension(50,30),500,50);
	}
	
	public TreeDisplayer(BinTree tree,int windowWidth)
	{
		super(tree.name);
		Setup(tree,new Dimension(50,30),windowWidth,50);
	}
	
	public TreeDisplayer(BinTree tree,Dimension nodeSize)
	{
		super(tree.name);
		Setup(tree,nodeSize,500,50);
	}
	
	public TreeDisplayer(BinTree tree,Dimension nodeSize,int windowWidth)
	{
		super(tree.name);
		Setup(tree,nodeSize,windowWidth,50);
	}
	
	public TreeDisplayer(BinTree tree,Dimension nodeSize,int windowWidth,int vertSpc)
	{
		super(tree.name);
		Setup(tree,nodeSize,windowWidth,vertSpc);
	}
	
	private void Setup(BinTree tree,Dimension nodeSize,int windowWidth,int vertSpc)
	{
		
		//Dimension
		int len=tree.getDepth()+1;
		setSize(windowWidth,len*vertSpc);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Draw
		tG=new GraphicPanel(tree,nodeSize,vertSpc);
		add(tG);
		//Show
		setVisible(true);
		
		/*
		BufferedReader intemp = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press return key to exit.");
		try{
			String s = intemp.readLine();
		} catch(IOException e){
			System.out.println("IOException");
		}

		System.exit(0);
		*/
		//getContentPane().setBackground(Color.RED);
		
	}
}