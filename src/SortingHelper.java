import java.util.Random;

/**
 * Created by Gerald Glasgow on 6/2/2017.
 */

class SortingHelper {
    private int [] values;

    public SortingHelper(int [] values){
        this.values = values;
    }

    public int[] getAverageArray(int a){
        Random rnd = new Random();
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = rnd.nextInt(100)+1;
        }
        return array;
    }

    public int[] getWorstArray(int a){
        int[] array = new int[a];
        for(int i=0;i<a;i++){
            array[i] = i;
        }
        return array;
    }

    public void printResults(double time [][], int tests){
        for(int i=tests-1;i<tests;i++){
            for(int k=0;k<values.length;k++){
                System.out.println("n = " + values[k] + " runtime: " + time[tests][k]);
            }
        }
    }

}
