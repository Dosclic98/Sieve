package prime;
import jbook.util.Input;

public class Tester {
	public static void main(String[] args) {
		System.out.print("Inserire il numero massimo fino a cui si vogliono conoscere i numeri primi:\n>>");
		int n = Input.readInt();
		long startTime = System.nanoTime();
		int seq[][] = Eratostene.sieve(n);
		long endTime = System.nanoTime();
		Printer.printMatrixCmpl(seq, n);
		Printer.printMatrixPrime(seq, n);
		long duration = endTime-startTime;
		System.out.println("\nIl programma ci ha messo: " + duration/1000000 + " ms");
	}
}
