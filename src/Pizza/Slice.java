package Pizza;

import java.awt.*;

public class Slice {

    public Point topleft;
    public Point botright;
    public int mush;
    public int tom;

    Slice(Point topleft, Point botright, int mush, int tom) {
        this.topleft = topleft;
        this.botright = botright;
        this.mush = mush;
        this.tom = tom;
    }

    Slice(Slice slice) {
        this(slice.topleft,slice.botright,slice.mush,slice.tom);
    }

    public boolean isComplete() {
        return mush >= Pizza.minElem && tom >= Pizza.minElem;
    }

    public boolean extend(int direction) {
        switch (direction) {
            case Pizza.TOP:
                return extTop();
            case Pizza.BOTTOM:
                return extBot();
            case Pizza.LEFT:
                return extLeft();
            case Pizza.RIGHT:
                return extRight();
        }
        return true;
    }

    private boolean extTop() {
        if (topleft.y == 0) return false;
        if (size() + botright.x - topleft.x > Pizza.maxSize) return false;
        for (int i = topleft.x; i <= botright.x; i++)
            if (Pizza.used[i][topleft.y - 1]) return false;
        topleft.y--;
        for (int i = topleft.x; i <= botright.x; i++) {
            Pizza.used[i][topleft.y] = true;
            if (Pizza.content[i][topleft.y] == Pizza.TOM) tom++;
            else mush++;
        }
        return true;
    }

    private boolean extBot() {
        if (botright.y == Pizza.used[0].length - 1) return false;
        if (size() + botright.x - topleft.x > Pizza.maxSize) return false;
        for (int i = topleft.x; i <= botright.x; i++)
            if (Pizza.used[i][botright.y + 1]) return false;
        botright.setLocation(botright.getX(),botright.getY()+1);
        for (int i = topleft.x; i <= botright.x; i++) {
            Pizza.used[i][botright.y] = true;
            if (Pizza.content[i][botright.y] == Pizza.TOM) tom++;
            else mush++;
        }
        return true;
    }

    private boolean extLeft() {
        if (topleft.x == 0) return false;
        if (size() + botright.y - topleft.y > Pizza.maxSize) return false;
        for (int i = topleft.y; i <= botright.y; i++)
            if (Pizza.used[topleft.x - 1][i]) return false;
        topleft.x--;
        for (int i = topleft.y; i <= botright.y; i++) {
            Pizza.used[topleft.x][i] = true;
            if (Pizza.content[topleft.x][i] == Pizza.TOM) tom++;
            else mush++;
        }
        return true;
    }

    private boolean extRight() {
        if (botright.x == Pizza.used.length-1) return false;
        if (size() + botright.y - topleft.y > Pizza.maxSize) return false;
        for (int i = topleft.y; i <= botright.y; i++)
            if (Pizza.used[botright.x + 1][i]) return false;
        botright.x++;
        for (int i = topleft.y; i <= botright.y; i++) {
            Pizza.used[botright.x][i] = true;
            if (Pizza.content[botright.x][i] == Pizza.TOM) tom++;
            else mush++;
        }
        return true;
    }

    public int size() {
        return (botright.x - topleft.x) * (botright.y - topleft.y);
    }

}
