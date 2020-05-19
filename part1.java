

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class part1 {
	public static boolean isContainingNumber (String s) {
		if (s.indexOf('0') != -1 || s.indexOf('1') != -1 || s.indexOf('2') != -1 || s.indexOf('3') != -1 || s.indexOf('4') != -1 || s.indexOf('5') != -1 || s.indexOf('6') != -1 || s.indexOf('7') != -1 ||
				s.indexOf('8') != -1 || s.indexOf('9') != -1) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isExisting(String s, ArrayList <String>  array) {
		boolean bool=false;
		for (int i =0 ; i<array.size(); i++) {
			if (s.equals(array.get(i))) {
				bool=true;
			}
		}
		return bool;
	}
	public static boolean isOneLetter(String s) {
		if (s.length() == 1) {
			if (!(s.equals("A")) && !(s.equals("a")) && !(s.equals("i")) && !(s.equals("I")))
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}
	public static ArrayList <String> subDictionnary(String filename) {
		ArrayList <String> subdic = new ArrayList <String> ();
		Scanner sc=null;
		boolean skipper=false;
		try {	
			sc = new Scanner(new FileInputStream(filename));
		}
		catch (FileNotFoundException e){
			System.out.println("File could not have been opened");
		}
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] arrSplit=line.split(" ");
			for (int i=0; i<arrSplit.length;i++) {
				if (arrSplit[i].indexOf('?') != -1 || arrSplit[i].indexOf(':') != -1 || arrSplit[i].indexOf(',') != -1 || arrSplit[i].indexOf(';') != -1 || arrSplit[i].indexOf('!') != -1 || arrSplit[i].indexOf('.') != -1) {
					arrSplit[i]=arrSplit[i].substring(0,arrSplit[i].length()-1);
				}
				if (arrSplit[i].indexOf('’') != -1) {
					arrSplit[i]=arrSplit[i].substring(0,arrSplit[i].indexOf('’'));
				}
				if (arrSplit[i].equals("") || arrSplit[i].equals(" ") || arrSplit[i].equals("  ") || isContainingNumber(arrSplit[i]) || subdic.contains(arrSplit[i].toUpperCase()) || isOneLetter(arrSplit[i])) {
					skipper=true;
				}
				if (skipper == false) {
					subdic.add(arrSplit[i].toUpperCase());
				}
				skipper=false;
			}
			
		}
		sc.close();
		return subdic;
	}

	public static void main(String[] args) {
		ArrayList <String> holder=subDictionnary("PersonOfTheCentury.txt");
		String str="";
		int size =holder.size();
		
		for (int k=0;k<holder.size();k++) {
			for (int l=k+1;l<holder.size();l++) {
				if(holder.get(k).compareTo(holder.get(l)) > 0) {
					str=holder.set(k, holder.get(l));
					holder.set(l, str);
				}
			}
		}
		for (int i=0;i<holder.size();i++) {
			System.out.println(holder.get(i));
		}
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("SubDictionnary.txt",true)); 
			pw.println("The document produced this sub-dictionary, which includes "+size+ " entries.\n");
			for (int z=0;z<size;z++) {
				if (z==0) {
					pw.println(holder.get(z).charAt(0)+"\n==");
				}
				if (z==size-1) {
					pw.print(holder.get(z));
					break;
				}
				if(holder.get(z).charAt(0) != holder.get(z+1).charAt(0)) {
					pw.println(holder.get(z));
					pw.println();
					pw.println(holder.get(z+1).charAt(0)+"\n==");
					
				}
				else {
					pw.println(holder.get(z));
				}
			}
			pw.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
			
		
	}

}
