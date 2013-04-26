package book.graph;

import structures.Queue;

public class BeadthFirstSearch {

    public static void Search()
    {
        // for each vertex u in V[G]
        //   u.color = white
        //   y.d = max
        //   y.pi = null

        // s.color = gray
        // s.d = 0
        // s.pi = nul;


        Queue que = new Queue(100);
        que.enqueue(3);
        while(!que.empty())
        {
            // u = que.deque
            // foreach( v in u.connections)
                // if (v.color == white)
                     // v.color = gray
                     // v.d = u.d + 1;
                     // v.pi = u;
                     // que.enque(v)

        }   // u.color = black;
    }
}
