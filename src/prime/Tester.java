package prime;

import jbook.util.Input;

public class Tester {
	public static void main(String[] args) {
		System.out.print("Inserire il numero massimo fino a cui si vogliono conoscere i numeri primi:\n>>");
		int n = Input.readInt();
		int seq[][] = Eratostene.sieve(n);
		
		Printer.printMatrixCmpl(seq, n);
		Printer.printMatrixPrime(seq, n);
	}
}
