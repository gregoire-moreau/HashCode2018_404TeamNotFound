package HashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static LinkedList<Taxi> listOfTaxis;
    public static LinkedList<Ride> listOfRides;
    public static int numOfRows;
    public static int numOfCols;
    public static int numOfTaxis;
    public static int numOfRides;
    public static int bonus;
    public static int numOfSteps;



    public static void main(String[] args)
    {
        IO.read(args[0]);
        Collections.sort(listOfRides);

        for(int i= 0; i<numOfSteps; i++){
            System.out.print(i + "\r");
            while(!listOfRides.isEmpty() && listOfRides.peek().getTimeLimit()<=i)
                listOfRides.poll();

            for(Taxi t : listOfTaxis)
            {
                if(t.isFree(i))
                {
                    Ride ride = t.getCloserRide(listOfRides);
                    if(ride != null) {
                        t.takeRide(ride);
                        listOfRides.remove(ride);
                    }
                    /*for(Ride r: listOfRides){
                        if(t.isAccessible(r)){
                            t.takeRide(r);
                            listOfRides.remove(r);
                            break;
                        }
                    }*/
                }
            }
        }

        IO.write(args[0]);
    }
}
