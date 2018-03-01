package HashCode;

import java.awt.*;

public class Ride {

    private int timeStart;
    private int timeEnd;
    private Point pointStart;
    private Point pointEnd;

    public Ride(int timeStart,int timeEnd,Point pointStart,Point pointEnd)
    {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
    }
    public int getTimeStart() {
        return timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public Point getPointStart() {
        return pointStart;
    }

    public Point getPointEnd() {
        return pointEnd;
    }

}
