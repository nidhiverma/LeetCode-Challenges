class Solution {
    Map<Character, Integer> map;
    int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0,1}, {0,-1}};
    
    public boolean judgeCircle(String moves) {
        map = new HashMap();
        map.put('L', 0);
        map.put('R', 1);
        map.put('U', 2);
        map.put('D', 3);
        
        return helper(moves.toCharArray(), 0, 0, 0);
    }
    
    private boolean helper(char[] moves, int i, int x, int y) {
        if(i == moves.length) {
            return x == 0 && y == 0;
        }
        
        int idx = map.get(moves[i]);
        
        x += dir[idx][0];
        y += dir[idx][1];
        return helper(moves, i+1, x, y);
    }
}