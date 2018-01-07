
package Tests;

/**
 *
 * @author <Jared Nelsen>
 */

public class Test {
    
    private static final int min = -1000000000;
    private static final int max = 1000000000;

    public static void print(String s) {
        System.out.println("");
        System.out.println(s + "...");
    }
    
    public static long recordMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
    
    public static void printMemory(long before, long after) {
        System.out.println("Memory = " + ((after - before) / 1000000) + " mb");
    }
    
    public static int randomInt() {
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }
    
}