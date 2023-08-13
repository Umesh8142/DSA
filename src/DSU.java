class DSU{
    int [] parent;
    int [] size;
    DSU(int n){
        parent= new int [n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    void union(int a,int b ){
        a=find(a);
        b=find(b);
        if (a != b) {
            if(size[a]<size[b]) {
                int temp=a;
                a=b;
                b=temp;
            }
            parent[b]=a;
            size[a]+=size[b];
        }

        }

    void print(){
        for(int i=0;i<parent.length;i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println();
    }
    void size(){
        for(int i=0;i<parent.length;i++){
            System.out.print(size[i]+" ");
        }
        System.out.println();
    }
}

