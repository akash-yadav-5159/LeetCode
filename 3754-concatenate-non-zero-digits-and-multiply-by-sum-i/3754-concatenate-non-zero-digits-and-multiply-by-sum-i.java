class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long h=0;
        int step=0;
        while(n>0){
            int a=n%10;
            if(a==0){
                n/=10;
                continue;
            }
            sum+=a;
            h=10*h+a;
            step++;
            n/=10;
        }
        long copy=h;
        h=0;
        for(int i=1;i<=step;i++){
            long a=copy%10;
            copy/=10;
            h=h*10+a;
        }
        return (sum*h);
    }
}