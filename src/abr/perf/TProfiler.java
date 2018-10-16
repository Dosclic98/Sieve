package abr.perf;

public final class TProfiler {

	private static final Runnable waiter;
	private static volatile Object knownValue;
	private static long timeElapsed = Long.MAX_VALUE;

	/*
	 * ------ ESEMPIO -------------------
	*/
	public static void main(String[] args) {
		// Avvia il timer: ogni stampa considerera' questo momento
		// come momento d'origine
		TProfiler.start();

		// Ciclo che conta da 0 a 9999999999, niente di più
		for(long i = 0; i < 9999999999L; i += 1) {
			// Dice alla classe utility che è stato calcolato il valore 'i'
			TProfiler.tell(i);

			// Ogni 10^7 valori calcolati, chiede alla classe utility
			// di stampare (su un thread separato) l'ultimo valore
			// calcolato ed il tempo impiegato
			if(i % 10000000L == 0)
				TProfiler.printValue();
		}
	}

	static {
		waiter = new Runnable() {
			@Override public void run() {
				while(true) {
					synchronized(TProfiler.class) {
						try {
							TProfiler.class.wait();
						} catch (InterruptedException ex) {
							break;
						}
					}
					System.out.println(
							"Valore: "+knownValue.toString() +
							" ("+getIMillis()+"ms)");
				}
			}
		};
		new Thread(waiter, "TProfiler").start();
	}

	public static void start() {
		timeElapsed = System.nanoTime();
	}

	public static void printValue() {
		synchronized(TProfiler.class) {
			TProfiler.class.notify();
		}
	}

	public static void tell(Object n) {
		knownValue = n;
	}

	public static double getNanos() {
		return (System.nanoTime() - timeElapsed);
	}
	public static long getINanos() {
		return (System.nanoTime() - timeElapsed);
	}

	public static double getMicros() {
		return (System.nanoTime() - timeElapsed) / 1000.0;
	}
	public static long getIMicros() {
		return (long) ((System.nanoTime() - timeElapsed) / 1000.0);
	}

	public static double getMillis() {
		return (System.nanoTime() - timeElapsed) / 1000000.0;
	}
	public static long getIMillis() {
		return (long) ((System.nanoTime() - timeElapsed) / 1000000.0);
	}

}
