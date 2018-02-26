import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    public static boolean[][] used; //Tranches confirmees
    public static boolean[][] marked;//Utilise a chaque bfs
    public static boolean[][] content; // True = tom, False = mush

    public static final int TOP = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public static final boolean MUSH = false;
    public static final boolean TOM = true;

    public static int numLines;
    public static int numCols;
    public static int maxSize; //Le nbre d'elem max par tranche
    public static int minElem; //Le nbre d'elem min de chaque sorte

}
