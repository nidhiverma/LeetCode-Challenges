class Solution {
    public String getPermutation(int n, int k) {
        String str = "123456789";
        int[] fact = new int[]{0,1,2,6,24,120,720,5040,40320,362880};
        String res = getPermutation(str.substring(0,n), n, k, fact);
        return res;
    }
    
    protected String getPermutation(String s, int n, int k, int[] fact) {
        if(n == 1 || k == 1) {
            return s;
        }
        if(k == 0) {
            return String.valueOf(new StringBuffer(s).reverse());
        }
        int first = k / fact[n-1];
        int order = k % fact[n-1];
        if(order == 0) {
            first--;
        }
        String suffix = s.substring(0,first) + s.substring(first+1);
        String res = s.charAt(first) + getPermutation(suffix, n-1, order, fact);
        return res;
    }
}