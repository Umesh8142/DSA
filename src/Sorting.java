import java.util.*;


public class Sorting {
    public static void main(String [] args){
        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        int [] a= new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b= selectionSort(a);
        System.out.println(Arrays.toString(b));
    }
    public static int[] bubbleSort(int []a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        return a;
    }
    public static int[] insertionSort(int []a){
        int n=a.length;
        for(int i=1;i<n;i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        return a;
    }
    public static int [] selectionSort(int []a){
        int n=a.length;
        for(int i=0;i<n-1;i++) {
            int j = i;
            int index=i;
            while (j < n) {
                if (a[index] > a[j]){
                    index=j;
                }
                j++;

            }
            int temp=a[i];
            a[i]=a[index];
            a[index]=temp;
            System.out.println(Arrays.toString(a));
        }

        return a;
    }
}
