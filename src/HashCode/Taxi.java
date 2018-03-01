package HashCode;

import java.awt.*;
import java.util.ArrayList;

public class Taxi {

    private static int newid = -1;

    public ArrayList<Ride> done;
    public Point position;
    int freeOn;
    int id;

    Taxi() {
        position = new Point(0, 0);
        done = new ArrayList<>();
        freeOn = 0;
        id = newid;
        newid++;
    }

    public int timeToPoint(Point p) {
        return timeBetween(p, position);
    }

    private int timeBetween(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public boolean isFree(int time) {
        return time >= freeOn;
    }

    public void takeRide(Ride ride) {
        done.add(ride);
        freeOn += timeToPoint(ride.getPointStart());
        freeOn = Math.min(freeOn, ride.getTimeStart());
        position = ride.getPointStart();
        freeOn += timeToPoint(ride.getPointEnd());
        position = ride.getPointEnd();
    }

    public boolean isAccessible(Ride ride) {
        int arriveTime = freeOn + timeToPoint(ride.getPointStart());
        int leaveTime = Math.min(arriveTime, ride.getTimeStart());
        int finishTime = leaveTime + timeBetween(ride.getPointStart(), ride.getPointEnd());
        return finishTime <= ride.getTimeEnd();
    }
}
