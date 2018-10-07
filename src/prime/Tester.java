package prime;
import java.util.Arrays;
import jbook.util.Input;

public class Tester {
	public static void main(String[] args) {
		System.out.println("Inserire il numero massimo fino a cui si vogliono conoscere i numeri primi:\n>>");
		int n = Input.readInt();
		sieve(n);
	}
	
	/* Defines all'prime numbers up to a given one using sieve of Erathostenes*/
	public static void sieve(int n) {
		int[] seq = new int[n];
		for(int i=0;i<n;i++) {
			seq[i] = i+1;
		}
		System.out.println(Arrays.toString(seq));
		// seq = ArrayUtils.remove(seq, 3);
	}
}
