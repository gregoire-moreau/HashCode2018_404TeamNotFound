package HashCode;

import java.awt.*;

public class Ride implements Comparable<Ride>{

    private int id;
    private int timeStart;
    private int timeEnd;
    private Point pointStart;
    private Point pointEnd;
    private int length;

    public Ride(int id,Point pointStart,Point pointEnd,int timeStart,int timeEnd)
    {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.length = Math.abs(pointStart.x - pointEnd.x) + Math.abs(pointStart.y - pointEnd.y);
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
    public int getLength() {
        return length;
    }
    public int getTimeLimit() {
        return timeEnd-length;
    }

    @Override
    public int compareTo(Ride o) {
        if((this.timeEnd - o.timeEnd) == 0)
            return this.timeStart - o.timeStart;
        else
            return this.timeEnd - o.timeEnd;
    }
}
