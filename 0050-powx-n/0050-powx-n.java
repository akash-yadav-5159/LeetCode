class Solution {
    public double calculate(double x, int n){
        if(n==0)return 1;
        double halfpower=calculate(x,n/2);
        double halfpowersq=halfpower*halfpower;
        if(n%2==0){
            return halfpowersq;
        }else{
            return x*halfpowersq;
        }
    }
    public double myPow(double x, int n) {
        double ans=calculate(x,n);
        if(n<0)return 1/ans;
        return ans;
    }
}