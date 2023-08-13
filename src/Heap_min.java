import java.util.ArrayList;
class Heap{
    private ArrayList<Integer> d;
    Heap(){
        d = new ArrayList<>();
    }

    //swap
    private void swap(int i,int j){
        int di=d.get(i);
        int dj=d.get(j);
        d.set(i,dj);
        d.set(j,di);
    }
    // upheapify
    private void upheapify (int cIndx){
        int pIndx =(cIndx-1)/2;

        if(pIndx >= 0 && d.get(pIndx)>d.get(cIndx)){
            swap(cIndx,pIndx);
            upheapify(pIndx);
        }
    }
    // add
    void add(int data){
        d.add(data);
        upheapify(d.size()-1);
    }
    // peek min ele
    int peek(){
        if(d.size()>0)
            return d.get(0);
        return -1;
    }
    //donofy
    private void downify (int pIndx){
        int lcI = 2*pIndx+1;
        int rcI = 2*pIndx+2;
        int min = pIndx;
        if(lcI<d.size() && d.get(lcI)<d.get(min)){
               min=lcI;
        }
        if(rcI<d.size() && d.get(rcI)<d.get(min)){
            min=rcI;
        }
        if(min!=pIndx){
            swap(min,pIndx);
            downify(min);

        }

    }
    // remove min ele
    int pop(){
        if(d.size()==0) return -1;
        int ans=d.get(0);
        swap(0,d.size()-1);
        d.remove(d.size()-1);
        downify(0);

        return ans;
    }
    // size of heap
    int size(){
        return d.size();
    }

}
public class Heap_min {


    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(10);
        h.add(-8);
        h.add(9);
        System.out.println(h.pop());
        System.out.println(h.peek());
    }
}
