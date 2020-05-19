import java.util.NoSuchElementException;

public class CellList {
	class CellNode {
		private CellPhone p;
		private CellNode d;
		
		public CellNode() {
			p=null;
			d=null;
		}
		public CellNode(CellPhone p, CellNode d) {
			this.p=p;
			this.d=d;
		}
		public CellNode(CellNode d) {
			this.p.clone(d.p);
			this.d=d;
		}
		public void clone(CellNode x) {
			this.d=x.d;
			this.p=x.p;
		}
		public CellPhone getP() {
			return p;
		}
		public void setP(CellPhone p) {
			this.p=p;
		}
		public CellNode getCellNode() {
			return d;
		}
		public void setCellNode(CellNode d) {
			this.d=d;
		}
	}
	private CellNode head;
	private int size=0;
	
	public CellList() {
		head=null;
		size=0;
	}
	public CellList (CellList c) {
		CellNode position=c.head;
		for (int i=0;i<c.size;i++) {
			try {
				this.insertAtIndex(position.getP(),i);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			position=position.d;
		}
	}
	public void addToStart(CellPhone c) {
		head = new CellNode(c,head);
		size+=1;
	}
	public void insertAtIndex(CellPhone c, int index) {
		CellNode holder = head;
		if (index ==0) {
			head=head.d;
			size++;
		}
		else {
			CellNode position = head;
			int counter = 0;
			boolean actionDone=true;
			while (counter<index-1) {
				try {
					if (position.d==null) {
						throw new NoSuchElementException();
					}
					position=position.d;
					counter++;
					}
					
				catch (NoSuchElementException e) {
					System.out.println(e);
					actionDone=false;
					System.exit(0);
				}
			}
			if (actionDone == true) {
				head= new CellNode(c,position.d.d);
				position.d=head;
				head=holder;
			}
		}
		
	}
	public CellNode find (long serNum) {
		CellNode position = head;
		boolean actionDone=false;
		int counter =0 ;
		while (position != null) {
			position = position.d;
			counter++;
			try {
				if (position.p.getSerialNum()==serNum) {
					actionDone=true;
					break;
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		if (actionDone == true) {
			System.out.println("Moved " +counter +" times with succesful action");
			return position;
		}
		else {
			System.out.println("Serial number not found");
			return null;
		}
	}
	public boolean contains (long serNum) {
		boolean actionDone=false;
		CellNode position=head;
		while (position!=null) {
			try {
				if (position.p.getSerialNum()==serNum) {
					actionDone=true;
					break;
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			position=position.getCellNode();
		}
		return (actionDone);
	}
	public void showContent() {
		int counter=0;
		CellNode position=head;
		while (position != null) {
			if (counter % 2 == 0) {
				System.out.println(position.getP() + "---> ");
			}
			else {
				System.out.println(position.getP() + "--->");
			}
			position=position.getCellNode();
			counter++;
		}
		System.out.println("X");
		System.out.println("End of the list");
	}
	public boolean equals(CellList c) {
		CellNode position = head;
		CellNode cellPosition=c.head;
		boolean isEqual=true;
		boolean condition =position.getP().equals(cellPosition.getP());
		while (position!=null) {
			if (!condition) {
				isEqual=false;
			}
			position=position.getCellNode();
			cellPosition=cellPosition.getCellNode();
		}
		return isEqual;
	}
	public void deleteFromStart() {
		head = head.d;
		size--;
	}
	
	
}
