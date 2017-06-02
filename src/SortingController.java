import java.util.Random;

/**
 * Created by oit_hd on 6/2/2017.
 */
public class SortingController {
    private int [] values;
    private int iterations;
    private double time[] = new double[values.length];

    public SortingController(int [] values, int iterations){
        this.values = values;
        this.iterations = iterations;

    }
    public void start() {

        long x, y;
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                x = System.nanoTime();
                QuickSortR first = new QuickSortR(getAverageArray(values[k]));
                y = System.nanoTime();
                time[k] += (double) (y - x) / 1000000000.00;
            }
            time[k] /= (double) (iterations);
        }
        for (int j = 0; j < time.length; j++) {
            System.out.println("Time for n = " + values[j] + " was " + time[j]);
        }
    }
    public static int[] getAverageArray(int a){
        Random rnd = new Random();
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = rnd.nextInt(100)+1;
        }
        return array;
    }
    public static int[] getWorstArray(int a){
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = i;
        }
        return array;
    }
}
