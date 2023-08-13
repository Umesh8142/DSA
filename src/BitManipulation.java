public class BitManipulation {

    public static int NoOfBitsSet(int n){
        int count=0;
        int mask=1;
//        for(int i=0;i<32;i++){
//            if((n&mask)>0){
//                count++;
//
//            }
//            mask=mask<<1;
//
//        }
        while(n>0){
            if((n&mask)>0){
                count++;

            }
            n=n>>>1;
        }
       return count;
    }
    public static StringBuilder binary(int n){
        StringBuilder ans = new StringBuilder();

        while (n>0){
            int r=n%2;
            ans.append(r);
            n=n/2;
        }
        return ans.reverse();
    }
    public static int hammingDistance(int x, int y) {
        int a=x^y;
        int count=0;
        int mask=1;
        while(a>0){
            if((a&mask)>0){
                count++;
            }
            a=a>>>1;
        }
        return count;
    }
    public static StringBuilder onesComp(int a){
        StringBuilder s=new StringBuilder();
        String  b = Integer.toString(a);
        int n=b.length();

        for(int i=0;i<n;i++){
            if(b.charAt(i)=='0'){
                s.append(1);
            }
            else{
                s.append(0);
            }
        }
        return s;
    }
}
