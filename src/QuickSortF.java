/**
 * Created by oit_hd on 6/2/2017.
 */
public class QuickSortF {

    private int a [];

    public QuickSortF(int [] a){
        this.a = a;
        quickSort(0, a.length-1);
    }


    public void quickSort(int start, int end){
        //printArray();
        int index = partition(start, end);
        System.out.println(index);
        if (start < index-1){ quickSort(start, index-1); }
        if (end > index){ quickSort(index, end); }
    }

    public int partition(int start, int end){
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
            printArray();
        } // end while
        return start;
    }

    public void printArray(){
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            if(i == a.length-1){
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

}
