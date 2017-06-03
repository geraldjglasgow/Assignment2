import java.util.Random;

/**
 * Created by Gerald Glasgow on 6/2/2017.
 */

class QuickSortR {

    private Random rnd = new Random();
    private int a [];
    private int values [];
    private int iterations;
    private double time [][];
    private int tests=0;
    private double micro;

    public QuickSortR(int [] values, int iterations, double micro){
        this.values = values;
        this.iterations = iterations;
        this.time = new double [2][values.length];
        this.micro = micro;
    }


    private void quickSort(int start, int end){
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    private int partition(int start, int end){
        int pivot = getRandom(start, end);
        while(start<=end){
            while(a[start] < pivot){
                start++;
            }
            while(a[end] > pivot){
                end--;
            }
            if(start <= end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++; end--;
            }
        } // end while
        return start;
    }
    private int getRandom(int start, int end){
        int temp = a[rnd.nextInt(end-start)+start];
        a[rnd.nextInt(end-start)+start] = a[start];
        a[start] = temp;
        return a[start];
    }
    public void startQSortR() {
        long x, y;
        SortingHelper ctrl = new SortingHelper(values);
        /* Average Case */
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                a = ctrl.getAverageArray(values[k]);
                x = System.nanoTime();
                quickSort(0, a.length-1);
                y = System.nanoTime();
                time[tests][k] += (double) (y - x)/micro;
            } //  / 1000000000.00
            time[tests][k] /= (double)(iterations);
        }
        System.out.println("Results for pivot = Median(first, middle, last) for average case");
        ctrl.printResults(time, tests);
        System.out.println();

        /* Worst Case */
        tests++; // for storing times in 2D array
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                a = ctrl.getWorstArray(values[k]);
                x = System.nanoTime();
                quickSort(0, a.length-1);
                y = System.nanoTime();
                time[tests][k] += (double) (y - x)/micro;
            }
            time[tests][k] /= (double) (iterations);
        }
        System.out.println("Results for pivot = Median(first, middle, last) for worst case");
        ctrl.printResults(time, tests);
        System.out.println();
    }
}
