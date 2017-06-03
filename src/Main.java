/**
 * Created by Gerald Glasgow on 6/2/2017.
 *
 * This program times Quick Sort with the pivot value being the first , the median
 * of the first, middle, and last values, or a random value of the array.
 * Each of these versions of Quick Sort will also have 2 sets of data to run.
 * the average case data will be run with an array of random integers, and
 * the worst case data will be an array in non-decreasing order.
 * These sorts for both types of data will run 'iteration' times for each value
 * in the array 'values'. The running time of each sort will be summed up and
 * divided by 'iterations' for each value in 'values', to get the average running
 * time of each sort. Lastly the time is gathered in nano-seconds, so the variable
 * 'micro' is 10^-5. this will be divided by 10^6 to get from nano to microseconds.
 */

public class Main {
    public static void main(String[] args) {
        int iterations = 100;                                      // iterations each value of 'values' will run
        int values[] = {100,200,300,400,500,600,700,800,900,1000}; // size of arrays being run
        double micro = 1000000.00;                                 // divide nano-seconds by 10^6 to get micro-seconds
        QuickSortF first = new QuickSortF(values, iterations, micro);
        QuickSortM median = new QuickSortM(values, iterations, micro);
        QuickSortR random = new QuickSortR(values, iterations, micro);
        first.startQSortF();
        median.startQSortM();
        random.startQSortR();
    }
}