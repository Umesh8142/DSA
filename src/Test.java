import java.util.*;

class Solution1 {
    public int UnsortedSubarrayLength(int[] a) {
        // Write your code here
        int n=a.length;

        int [] ans = new int [n];

        for(int i=0;i<n;i++ ){
            ans[i]=a[i];
        }

        Arrays.sort(ans);
        int i=0;

        while(i<n ){
            if(ans[i]==a[i]) 	i++;

        }

        int j=n-1;

        while(j>=0){
            if(ans[j]==a[j]) 	j--;

        }

        if(i>=j) return 0;
        int ans1=j-i;
        return ans1;


    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = sc.nextInt();
        }

        Solution1 o = new Solution1();
        int b=o.UnsortedSubarrayLength(ar);
        System.out.println(b);
    }
}
