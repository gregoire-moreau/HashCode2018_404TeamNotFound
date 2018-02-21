import java.awt.*;

public class Pizza {

    private boolean[][] used; //Si tranche occupe case
    private boolean[][] content; // True = tom, False = mush

    private final int TOP = 1;
    private final int BOTTOM = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;

    private final boolean MUSH = false;
    private final boolean TOM = true;

    private int maxSize;

    public class Slice {

        private Point topleft;
        private Point botright;
        private int mush;
        private int tom;

        Slice(Point topleft, Point botright, int mush, int tom) {
            this.topleft = topleft;
            this.botright = botright;
            this.mush = mush;
            this.tom = tom;
        }

        public boolean extend(int direction) {
            switch(direction) {
                case TOP:
                    if(topleft.y == 0) return false;
                    for(int i = topleft.x; i <= botright.x; i++)
                        if(used[i][topleft.y - 1]) return false;
                    topleft.y--;
                    for(int i = topleft.x; i <= botright.x; i++) {
                        used[i][topleft.y] = true;
                        if(content[i][topleft.y] == TOM) tom++;
                        else mush++;
                    }
                    break;
                case BOTTOM:
                    if(botright.y == used[0].length - 1) return false;
                    for(int i = topleft.x; i <= botright.x; i++)
                        if(used[i][botright.y + 1]) return false;
                    topleft.y++;
                    for(int i = topleft.x; i <= botright.x; i++) {
                        used[i][botright.y] = true;
                        if(used[i][botright.y] == TOM) tom++;
                        else mush++;
                    }
                    break;
                case LEFT:
                    if(topleft.x == 0) return false;
                    for(int i = topleft.y; i <= botright.y; i++)
                        if(used[topleft.x - 1][i]) return false;
                    topleft.x--;
                    for(int i = topleft.y; i <= botright.y; i++)
                        used[topleft.x][i] = true;
                    break;
                case RIGHT:
                    if(botright.x == used.length) return false;
                    for(int i = topleft.y; i <= botright.y; i++)
                        if(used[botright.x + 1][i]) return false;
                    topleft.x++;
                    for(int i = topleft.y; i <= botright.y; i++)
                        used[botright.x][i] = true;
                    break;
            }
            return true;
        }
    }
}
