/**
 * Created by Gerald Glasgow on 6/2/2017.
 */

public class Main {
    public static void main(String[] args) {
        int iterations = 100;
        int values[] = {100,200,300,400,500,600,700,800,900,1000};
        double micro = 1000000.00;
        QuickSortF first = new QuickSortF(values, iterations, micro);
        QuickSortM median = new QuickSortM(values, iterations, micro);
        QuickSortR random = new QuickSortR(values, iterations, micro);
        first.startQSortF();
        median.startQSortM();
        random.startQSortR();
    }
}