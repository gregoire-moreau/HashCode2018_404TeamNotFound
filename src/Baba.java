import java.awt.*;
import java.util.LinkedList;

public class Baba {
    public Pizza.Slice bfs(Point point)
    {
        LinkedList<Pizza.Slice> sliceQueue = new LinkedList<>();
        LinkedList<Point> pointQueue = new LinkedList<>();

         Pizza.Slice currentSlice = new Pizza.Slice(point,point,0,0);

         sliceQueue.push(currentSlice);
         pointQueue.push(point);

         while (!sliceQueue.isEmpty())
         {
             point = pointQueue.getFirst();
             currentSlice = sliceQueue.getFirst();

             if(used[point.x][point.y])
                 continue;

             if(currentSlice.extend(BOTTOM))
             {

             }


         }


    }
}
