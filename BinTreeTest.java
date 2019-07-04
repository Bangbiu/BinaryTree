
import java.awt.*;
public class BinTreeTest{
	public static void main(String args[]){
		BinTree a=new BinTree();
		BinTree b;
		a.root=new Node("f",null,new Node("k",null,new Node("a",null,new Node("o"),new Node("l")),new Node("b")),new Node("c",null,new Node("g"),null));
		b=new BinTree("myTree",
		new Node("1",
			new Node("2",
				new Node("4",
					new Node("7"),
					new Node("8",
						null,
						new Node("10",
							new Node("12"),
							null
						)
					)
				),
				new Node("5")
			),
			new Node("3",
				null,
				new Node("6",
					new Node("9",
						null,
						new Node("11")
					),
					null
				)
			)
		)
		);
		System.out.println("DLR: " + b.getDLR());
		System.out.println("LDR: " + b.getLDR());
		System.out.println("LRD: " + b.getLRD());
		System.out.println(a.getDepth());
		TreeDisplayer Disp = new TreeDisplayer(b,500);
		//System.out.println(a.getNode("k").name);
	}
}