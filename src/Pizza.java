import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    private static boolean[][] used; //Tranches confirmees
    private static boolean[][] marked;//Utilise a chaque bfs
    private static boolean[][] content; // True = tom, False = mush

    private final int TOP = 1;
    private final int BOTTOM = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;

    private static final boolean MUSH = false;
    private static final boolean TOM = true;

    private static int numLines;
    private static int numCols;
    private static int maxSize; //Le nbre d'elem max par tranche
    private static int minElem; //Le nbre d'elem min de chaque sorte

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
            switch (direction) {
                case TOP:
                    return extTop();
                case BOTTOM:
                    return extBot();
                case LEFT:
                    return extLeft();
                case RIGHT:
                    return extRight();
            }
            return true;
        }

        private boolean extTop() {
            if (topleft.y == 0) return false;
            if (size() + botright.x - topleft.x > maxSize) return false;
            for (int i = topleft.x; i <= botright.x; i++)
                if (used[i][topleft.y - 1]) return false;
            topleft.y--;
            for (int i = topleft.x; i <= botright.x; i++) {
                used[i][topleft.y] = true;
                if (content[i][topleft.y] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extBot() {
            if (botright.y == used[0].length - 1) return false;
            if (size() + botright.x - topleft.x > maxSize) return false;
            for (int i = topleft.x; i <= botright.x; i++)
                if (used[i][botright.y + 1]) return false;
            topleft.y++;
            for (int i = topleft.x; i <= botright.x; i++) {
                used[i][botright.y] = true;
                if (content[i][botright.y] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extLeft() {
            if (topleft.x == 0) return false;
            if (size() + botright.y - topleft.y > maxSize) return false;
            for (int i = topleft.y; i <= botright.y; i++)
                if (used[topleft.x - 1][i]) return false;
            topleft.x--;
            for (int i = topleft.y; i <= botright.y; i++) {
                used[topleft.x][i] = true;
                if (content[topleft.x][i] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        private boolean extRight() {
            if (botright.x == used.length) return false;
            if (size() + botright.y - topleft.y > maxSize) return false;
            for (int i = topleft.y; i <= botright.y; i++)
                if (used[botright.x + 1][i]) return false;
            topleft.x++;
            for (int i = topleft.y; i <= botright.y; i++) {
                used[botright.x][i] = true;
                if (content[botright.x][i] == TOM) tom++;
                else mush++;
            }
            return true;
        }

        public int size() {
            return (botright.x - topleft.x) * (botright.y - topleft.y);
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

    public static void read()
    {
        Scanner scanner = new Scanner(System.in);
        numLines = scanner.nextInt();
        numCols = scanner.nextInt();
        minElem = scanner.nextInt();
        maxSize = scanner.nextInt();

        used = new boolean[numLines][numCols];
        marked = new boolean[numLines][numCols];
        content = new boolean[numLines][numCols];

        scanner.nextLine();

        for(int i = 0; i<numLines; i++)
        {
            String line = scanner.nextLine();
            for(int j = 0; j<numCols; j++)
            {
                content[i][j] = (line.charAt(j) == 'T')? TOM:MUSH;
            }
        }
    }

    public static void write(ArrayList<Slice> slices)
    {
        System.out.println(slices.size());
        for(Slice e : slices)
        {
            System.out.println(e.topleft.x+" "+e.topleft.y+" "+e.botright.x+" "+e.botright.y);
        }
    }


    public static void main(String[] args)
    {
        read();

        //write(slices);
    }
}
