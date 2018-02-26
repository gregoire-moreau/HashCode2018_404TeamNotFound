import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        IO.read(args[0]);

        ArrayList<Slice> sliceArrayList = new ArrayList<>();
        Slice currentSlice = null;
        for (int i = 0; i < Pizza.numLines; i++) {
            for (int j = 0; j < Pizza.numCols; j++) {
                currentSlice = Tri.bfs(new Point(i,j));
                if(currentSlice != null)
                    sliceArrayList.add(currentSlice);
                currentSlice = null;
            }
        }

        IO.write(sliceArrayList);
    }
}
