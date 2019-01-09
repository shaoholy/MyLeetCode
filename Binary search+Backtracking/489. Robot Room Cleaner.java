class Solution {

    //Guanjian: because of turnRight() method, the order of dirs must be correct! 
    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        Set<String> vis = new HashSet<>(); 
        backtracking(robot, 0, 0, 0, vis);
    }
    
    private void backtracking(Robot robot, int x, int y, int dir, Set<String> vis) {
        String pos = x + "-" + y;
        if (vis.contains(pos)) {
            return; 
        }
        vis.add(pos); 
        robot.clean(); 
        
        
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                
                //go all the way till cannot move, then back one step
                int nx = x + dirs[dir][0];
                int ny = y + dirs[dir][1];
                
                backtracking(robot, nx, ny, dir,vis);
                
                //trackback
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight(); 
            dir = (dir + 1) % 4; 
        }
    }
}

