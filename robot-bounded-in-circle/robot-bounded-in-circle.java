/*
    @author: Nidhi
    
    Approach:
        Robot is initially facing north. If at the end also it is facing north then it can never reach origin, it will keep moving away from origin (think!).
        But if at the end, it is facing a direction othen than the north, then after 4 cycle repeats, it will definitely reach the origin again.
        
        at every move, update the coordinates
        in the end check if any of the two conditions is satisfied:
        condition 1 : back to origin (i.e. x == 0 and y == 0)
        condition 2 : not facing north
        
        if either condition 1 or condition 2 is satisfied, then return true else false
        
        Time Complexity: O(n)
        Space Complexity: O(1)
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] moves = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}}; // N E S W
        int x = 0, y = 0, dir = 0;
        for(char c : instructions.toCharArray()) {
            if(c == 'G') {
                x += moves[dir][0];
                y += moves[dir][1];
            }
            else if(c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if(c == 'R') {
                dir = (dir + 1) % 4;   
            }
        }
        return x == 0 && y == 0 || dir != 0;
    }
}