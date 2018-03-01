package HashCode;


import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class IO {

    public static void read(String in)
    {
        try {
            Scanner scanner = new Scanner(new File(in+".in"));
            Main.numOfRows = scanner.nextInt();
            Main.numOfCols = scanner.nextInt();
            Main.numOfTaxis = scanner.nextInt();
            Main.numOfRides = scanner.nextInt();
            Main.bonus = scanner.nextInt();
            Main.numOfSteps = scanner.nextInt();
            Main.listOfRides = new LinkedList<>();
            Main.listOfTaxis = new LinkedList<>();

            scanner.nextLine();

            for (int i = 0; i < Main.numOfRides; i++) {
                Main.listOfRides.add(new Ride(i,
                        new Point(scanner.nextInt(), scanner.nextInt()),
                        new Point(scanner.nextInt(), scanner.nextInt()),
                        scanner.nextInt(),
                        scanner.nextInt()));
            }


            for(int i = 0; i<Main.numOfTaxis; i++)
            {
                Main.listOfTaxis.add(new Taxi());
            }
        }
        catch (FileNotFoundException e){}
    }


    public static void write(String in)
    {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(in+".out"));
            for(Taxi e: Main.listOfTaxis)
            {
                writer.print(e.done.size());
                for(Ride x : e.done)
                {
                    writer.print(" "+x.getId());
                }
                writer.println();
            }
            writer.close();
        }
        catch (IOException e){}
    }
}
