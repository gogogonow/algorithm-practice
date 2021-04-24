package week4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 61404
 */
public class WalkingRobotSimulation874 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obsSet = new HashSet<>(obstacles.length);
        for (int i = 0; i < obstacles.length; i++) {
            obsSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        int sx = 0;
        int sy = 0;
        int index = 0;
        int ret = 0;
        for (int command : commands) {
            if (command == -1) {
                index = (index + 1) % 4;
            }
            else if (command == -2) {
                index = (index  + 3) % 4;
            }
            else {
                for (int i = 0; i < command; i++) {
                    int newX = sx + dx[index];
                    int newY = sy + dy[index];
                    if (obsSet.contains(newX + "," + newY)) {
                        break;
                    }
                    else {
                        sx = newX;
                        sy = newY;
                        ret = Math.max(ret, sx * sx + sy * sy);
                    }
                }
            }
        }
        return ret;
    }
}
