import java.awt.*;
import java.util.LinkedList;

public class Tri {
    public static Slice bfs(Point point)
    {
        LinkedList<Slice> sliceQueue = new LinkedList<>();
        //LinkedList<Point> pointQueue = new LinkedList<>();

         Slice currentSlice = new Slice(new Point(point),new Point(point),0,0);

         sliceQueue.push(currentSlice);
         //pointQueue.push(point);

         while (!sliceQueue.isEmpty())
         {
             //point = pointQueue.getFirst();
             currentSlice = sliceQueue.getFirst();

             if(currentSlice.isComplete())
                 return  currentSlice;

             if(currentSlice.extend(Pizza.BOTTOM))
             {
                 sliceQueue.add(new Slice(currentSlice));
             }

             if(currentSlice.extend(Pizza.RIGHT))
             {
                 sliceQueue.add(new Slice(currentSlice));
             }
         }
         return null;
    }
}