import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CellListUtilization {

	public static void main(String[] args) {
		Scanner k = null;
		Scanner input = null;
		CellList list1 = new CellList();
		CellList list2=new CellList();
		long serialNum;
		String brand="";
		double price;
		int year;
		try {
			k = new Scanner (new FileInputStream("Cell_Info.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println(e);
		}
		try {
			while (k.hasNext()) {
				serialNum=k.nextLong();
				brand=k.next();
				price=k.nextDouble();
				year=k.nextInt();
				CellPhone c = new CellPhone(serialNum,brand,year,price);
				k.nextLine();
				if (!(list1.contains(c.getSerialNum()))) {
					list1.addToStart(c);
				}
			}
		}
		catch (Exception e) {
			System.out.println("List limit has been reached");
		}
		list1.showContent();
		input = new Scanner (System.in);
		System.out.println("Dear user, please enter a serial number.");
		long userInput=0;
		boolean goodType=false;
		while (!goodType) {	
			try {
				userInput=input.nextLong();
				goodType=true;
			}
			catch (Exception e) {
				System.out.println("Please enter a long-type input");
				userInput=k.nextLong();
			}
		}
		System.out.println(list1.find(userInput).getP());
		input.close();
		// Testing part
		System.out.println("Testing part");
		CellPhone c1 = new CellPhone(00000000,"Konami",2001,1000);
		CellPhone c2 = new CellPhone(00000001,"Bones",1969,1100);
		CellPhone c3 = new CellPhone(00000002,"Pierrot",2013,2000);
		CellPhone c4 = new CellPhone(00000003,"Madhouse",2020,1785);
		CellPhone c5 = new CellPhone(00000004,"Konami",1986,1365);
		CellPhone c6 = new CellPhone(00000005,"Tencent",1879,1250);
		CellPhone c7 = new CellPhone(00000006,"Valve",2001,1475);
		list2.addToStart(c1);
		list2.addToStart(c2);
		list2.insertAtIndex(c3, -2);
		list2.showContent();
		System.out.println(list2.equals(list1));
		System.out.println(list2.find(2).getP());
		list2.deleteFromStart();
		list2.showContent();
		list2.find(4);
		list2.addToStart(c4);
		list2.addToStart(c5);
		list2.addToStart(c6);
		list2.addToStart(c7);
	}

}
