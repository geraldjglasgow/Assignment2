import java.util.Random;

/**
 * Created by oit_hd on 6/2/2017.
 */

public class Main {
    public static void main(String[] args) {
        int iterations = 1;
        int arr[] = {64};  /*, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};*/
        double time[] = new double[arr.length];
        long x, y;
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < iterations; i++) {
                x = System.nanoTime();
                QuickSortM first = new QuickSortM(getWorstArray(arr[k]));
                y = System.nanoTime();
                time[k] += (double)(y-x)/1000000000.00;
            }
            time[k] /= (double)(iterations);
        }
        for(int j=0;j<time.length;j++){
            System.out.println("Time for n = " + arr[j] + " was " + time[j]);
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
