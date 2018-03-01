package Pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IO{
    public static void read(String in)
    {
        try {
            Scanner scanner = new Scanner(new File(in));
            Pizza.numLines = scanner.nextInt();
            Pizza.numCols = scanner.nextInt();
            Pizza.minElem = scanner.nextInt();
            Pizza.maxSize = scanner.nextInt();

            Pizza.used = new boolean[Pizza.numLines][Pizza.numCols];
            Pizza.marked = new boolean[Pizza.numLines][Pizza.numCols];
            Pizza.content = new boolean[Pizza.numLines][Pizza.numCols];

            scanner.nextLine();

            for (int i = 0; i < Pizza.numLines; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < Pizza.numCols; j++) {
                    Pizza.content[i][j] = (line.charAt(j) == 'T') ? Pizza.TOM : Pizza.MUSH;
                }
            }
        }
        catch (FileNotFoundException e){}
    }

    public static void write(ArrayList<Slice> slices)
    {
        System.out.println(slices.size());
        for(Slice e : slices)
        {
            System.out.println(e.topleft.x+" "+e.topleft.y+" "+e.botright.x+" "+e.botright.y);
        }
    }
}
