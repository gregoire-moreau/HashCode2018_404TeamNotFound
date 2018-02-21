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

    private int maxSize; //Le nbre d'elem max par tranche
    private int minElem; //Le nbre d'elem min de chaque sorte

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

        public boolean isComplete() {
            return mush > minElem && tom > minElem;
        }

        public boolean extend(int direction) {
            switch(direction) {
                case TOP: return extTop();
                case BOTTOM: return extBot();
                case LEFT: return extLeft();
                case RIGHT: return extRight();
            }
            return true;
        }

        private boolean extTop() {
            if(topleft.y == 0) return false;
            if(size() + botright.x - topleft.x > maxSize) return false;
            for(int i = topleft.x; i <= botright.x; i++)
                if(used[i][topleft.y - 1]) return false;
            topleft.y--;
            for(int i = topleft.x; i <= botright.x; i++) {
                used[i][topleft.y] = true;
                if(content[i][topleft.y] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extBot() {
            if(botright.y == used[0].length - 1) return false;
            if(size() + botright.x - topleft.x > maxSize) return false;
            for(int i = topleft.x; i <= botright.x; i++)
                if(used[i][botright.y + 1]) return false;
            topleft.y++;
            for(int i = topleft.x; i <= botright.x; i++) {
                used[i][botright.y] = true;
                if(content[i][botright.y] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extLeft() {
            if(topleft.x == 0) return false;
            if(size() + botright.y - topleft.y > maxSize) return false;
            for(int i = topleft.y; i <= botright.y; i++)
                if(used[topleft.x - 1][i]) return false;
            topleft.x--;
            for(int i = topleft.y; i <= botright.y; i++) {
                used[topleft.x][i] = true;
                if(content[topleft.x][i] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extRight() {
            if(botright.x == used.length) return false;
            if(size() + botright.y - topleft.y > maxSize) return false;
            for(int i = topleft.y; i <= botright.y; i++)
                if(used[botright.x + 1][i]) return false;
            topleft.x++;
            for(int i = topleft.y; i <= botright.y; i++) {
                used[botright.x][i] = true;
                if(content[botright.x][i] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        public int size() {
            return (botright.x - topleft.x)*(botright.y - topleft.y);
        }

        public Point getTopleft() {
            return topleft;
        }

        public void setTopleft(Point topleft) {
            this.topleft = topleft;
        }

        public Point getBotright() {
            return botright;
        }

        public void setBotright(Point botright) {
            this.botright = botright;
        }

        public int getMush() {
            return mush;
        }

        public void setMush(int mush) {
            this.mush = mush;
        }

        public int getTom() {
            return tom;
        }

        public void setTom(int tom) {
            this.tom = tom;
        }
    }
}
