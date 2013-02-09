package net.yummycode.jsfplate.util;

/**
 * A utility class for YummyCode
 * 
 * @author Francois Andry
 * @version 1.0
 */
public class Processing {
	/**
	 * Wait for a certain number of milliseconds
	 * Very useful to simulate long processing phases
	 * 
	 * @param n
	 *            the waiting time in milliseconds
	 * @return <code>void</code> 
	 */
	public static void waiting(int n) {
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while (t1 - t0 < n);
	}
}
