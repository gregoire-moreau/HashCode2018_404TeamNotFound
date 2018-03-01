package HashCode;

import java.awt.*;

public class Ride implements Comparable<Ride>{

    private int id;
    private int timeStart;
    private int timeEnd;
    private Point pointStart;
    private Point pointEnd;

    public Ride(int id,int timeStart,int timeEnd,Point pointStart,Point pointEnd)
    {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
    }
    public int getId() {
        return id;
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

    @Override
    public int compareTo(Ride o) {
        if((this.timeEnd - o.timeEnd) == 0)
            return this.timeStart - o.timeStart;
        else
            return this.timeEnd - o.timeEnd;
    }
}
