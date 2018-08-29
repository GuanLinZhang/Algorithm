package LeetCode;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        float count = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U' :
                    count += 1;
                    break;
                case 'D':
                    count -= 1;
                    break;
                case 'L':
                    count += 0.5;
                    break;
                case 'R':
                    count -= 0.5;
                    break;
            }
        }
        return count == 0;
    }


}
