package prime;

import java.util.ArrayList;

public class Printer {
	public static void printArrayList(ArrayList<Integer> toPrint) {
		for(int i=0;i<toPrint.size();i++) {
			System.out.print(toPrint.get(i) + " ");
			if((i+1)%5 == 0) {
				System.out.println("");
			}
		}
		System.out.println("");
	}
}
