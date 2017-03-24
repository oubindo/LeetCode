import java.util.*;

/**
 * Created by oubin on 17-3-24.
 */
public class DijSuccess {



    private static final int MAX = Integer.MAX_VALUE;   // 最大值
    private static int[][] edges = {
            {0, 2, 10, 5, 3, MAX},
            {MAX, 0, 12, MAX, MAX, 10},
            {MAX, MAX, 0, MAX, 7, MAX},
            {2, MAX, MAX, 0, 2, MAX},
            {4, MAX, MAX, 1, 0, MAX},
            {3, MAX, 1, MAX, 2, 0}};    // 邻接矩阵

    public static void main(String[] args) {
        List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex a = new Vertex("1", 0);
        Vertex b = new Vertex("2");
        Vertex c = new Vertex("3");
        Vertex d = new Vertex("4");
        Vertex e = new Vertex("5");
        Vertex f = new Vertex("6");
        vertexs.add(a);
        vertexs.add(b);
        vertexs.add(c);
        vertexs.add(d);
        vertexs.add(e);
        vertexs.add(f);
        Graph graph = new Graph(vertexs, edges);
        graph.printGraph();
        graph.search();

    }


}

class Vertex implements Comparable<Vertex> {

    /**
     * 节点名称(A,B,C,D)
     */
    private String name;

    /**
     * 最短路径长度
     */
    private int path;

    /**
     * 节点是否已经出列(是否已经处理完毕)
     */
    private boolean isMarked;

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public Vertex(String name) {
        this.name = name;
        this.path = Integer.MAX_VALUE; //初始设置为无穷大
        this.setMarked(false);
    }

    public Vertex(String name, int path) {
        this.name = name;
        this.path = path;
        this.setMarked(false);
    }

    @Override
    public int compareTo(Vertex o) {
        return o.path > path ? -1 : 1;
    }


    public boolean isMarked() {
        return isMarked;
    }
}


class Graph {

    /*
     * 顶点
     */
    private List<Vertex> vertexs;

    /*
     * 边
     */
    private int[][] edges;

    /*
     * 没有访问的顶点
     */
    private Queue<Vertex> unVisited;

    public Graph(List<Vertex> vertexs, int[][] edges) {
        this.vertexs = vertexs;
        this.edges = edges;
        initUnVisited();
    }

    /*
     * 搜索各顶点最短路径
     */
    public void search() {
        while (!unVisited.isEmpty()) {
            Vertex vertex = unVisited.element();
            //顶点已经计算出最短路径，设置为"已访问"
            vertex.setMarked(true);
            //获取所有"未访问"的邻居
            List<Vertex> neighbors = getNeighbors(vertex);
            //更新邻居的最短路径
            updatesDistance(vertex, neighbors);
            pop();
        }
        System.out.println("search over");
    }

    /*
     * 更新所有邻居的最短路径
     */
    private void updatesDistance(Vertex vertex, List<Vertex> neighbors) {
        for (Vertex neighbor : neighbors) {
            updateDistance(vertex, neighbor);
        }
    }

    /*
     * 更新邻居的最短路径
     */
    private void updateDistance(Vertex vertex, Vertex neighbor) {
        int distance = getDistance(vertex, neighbor) + vertex.getPath();
        if (distance < neighbor.getPath()) {
            neighbor.setPath(distance);
        }
    }

    /*
     * 初始化未访问顶点集合
     */
    private void initUnVisited() {
        unVisited = new PriorityQueue<Vertex>();
        for (Vertex v : vertexs) {
            unVisited.add(v);
        }
    }

    /*
     * 从未访问顶点集合中删除已找到最短路径的节点
     */
    private void pop() {
        unVisited.poll();
    }

    /*
     * 获取顶点到目标顶点的距离
     */
    private int getDistance(Vertex source, Vertex destination) {
        int sourceIndex = vertexs.indexOf(source);
        int destIndex = vertexs.indexOf(destination);
        return edges[sourceIndex][destIndex];
    }

    /*
     * 获取顶点所有(未访问的)邻居
     */
    private List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        int position = vertexs.indexOf(v);
        Vertex neighbor = null;
        int distance;
        for (int i = 0; i < vertexs.size(); i++) {
            if (i == position) {
                //顶点本身，跳过
                continue;
            }
            distance = edges[position][i];    //到所有顶点的距离
            if (distance < Integer.MAX_VALUE) {
                //是邻居(有路径可达)
                neighbor = getVertex(i);
                if (!neighbor.isMarked()) {
                    //如果邻居没有访问过，则加入list;
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

    /*
     * 根据顶点位置获取顶点
     */
    private Vertex getVertex(int index) {
        return vertexs.get(index);
    }

    /*
     * 打印图
     */
    public void printGraph() {
        int verNums = vertexs.size();
        for (int row = 0; row < verNums; row++) {
            for (int col = 0; col < verNums; col++) {
                if (Integer.MAX_VALUE == edges[row][col]) {
                    System.out.print("X");
                    System.out.print(" ");
                    continue;
                }
                System.out.print(edges[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
