import java.util.Random;

/**
 * Created by Gerald Glasgow on 6/2/2017.
 */

class QuickSortR {

    private Random rnd = new Random();
    private int a [];          // array that is reused and resized for sorting
    private int values [];     // array of array sizes for 'a'
    private int iterations;    // iterations each value in 'a' will run
    private double time [][];  // 2D array to hold time values
    private double micro;      // number to divide nano-seconds to micro-seconds

    /**
     * Constructor initializes values of some global variables
     * @param values size of array to be sorted
     * @param iterations number of iteration each value of 'values' will be run
     * @param micro for dividing nanoseconds by to get microseconds
     */
    public QuickSortR(int [] values, int iterations, double micro){
        this.values = values;
        this.iterations = iterations;
        this.time = new double [2][values.length];
        this.micro = micro;
    }

    /**
     * Quick Sort recursive portion of function
     * @param start first index of array
     * @param end last index of array
     */
    private void quickSort(int start, int end){
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    /**
     * Quick Sorts partition step
     * @param start first index of array
     * @param end last index of array
     * @return
     */
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

    /**
     * return a random index between start and end
     * @param start first index of array
     * @param end last index of array
     * @return
     */
    private int getRandom(int start, int end){
        int temp = a[rnd.nextInt(end-start)+start];
        a[rnd.nextInt(end-start)+start] = a[start];
        a[start] = temp;
        return a[start];
    }

    /**
     * This method begins the testing of Quick Sort with pivot as a random
     * index of the array.
     * There are 2 sets of data being run: worst case and average case.
     * Worst case is sorting an array that's already in non-decreasing order.
     * Average case is sorting an array filled with random integers.
     */
    public void startQSortR() {
        int tests=0;
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
