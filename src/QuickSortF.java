/**
 * Created by Gerald Glasgow on 6/2/2017.
 *
 * This class is meant to QuickSort an array with the pivot value being
 * the first element in the array.
 */
class QuickSortF {

    private int a [];          // array that is reused and resized for sorting
    private int values [];     // array of array sizes for 'a'
    private int iterations;    // iterations each value in 'a' will run
    private double time [][];  // 2D array to hold time values
    private double micro;      // number to divide nano-seconds to micro-seconds

    /**
     * Constructor initializes values of some global variables
     * @param values      // sizes for array being sorted
     * @param iterations  // number of iterations each value of 'values' will be run
     * @param micro       // for dividing nano-seconds to microseconds
     */
    public QuickSortF(int[] values, int iterations, double micro){
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
        //printArray();
        int index = partition(start, end);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    /**
     * Quick Sorts partition step
     * @param start  first index of array
     * @param end  last index of array
     * @return  pivot index
     */
    private int partition(int start, int end){
        int pivot = a[start];
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
     *
     * This method begins the testing of Quick Sort with pivot as the first
     * index of the array.
     * There are 2 sets of data being run: worst case and average case.
     * Worst case is sorting an array that's already in non-decreasing order.
     * Average case is sorting an array filled with random integers.
     *
     */
    public void startQSortF() {
        long x, y;
        int tests = 0;
        SortingHelper ctrl = new SortingHelper(values);
        /* Average Case */
        for (int k = 0; k < values.length; k++) {
            for (int i = 0; i < iterations; i++) {
                a = ctrl.getAverageArray(values[k]);
                x = System.nanoTime();
                quickSort(0, a.length-1);
                y = System.nanoTime();
                time[tests][k] += (double) (y - x)/micro;
            }
            time[tests][k] /= (double)(iterations);
        }
        System.out.println("Results for pivot = first array element for average case");
        ctrl.printResults(time, tests);
        System.out.println();

        /* Worst Case */
        tests++;
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
        System.out.println("Results for pivot = first array element for worst case");
        ctrl.printResults(time, tests);
        System.out.println();
    }
}
