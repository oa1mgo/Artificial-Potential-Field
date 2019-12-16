import java.util.List;

/**
 * @program: Artificial-Potential-Field-master
 * @description: construct a map
 * @author: Miao Jiaxin
 * @create: 2019-12-15 23:57
 **/

public class Map {
    public static int DEFAULT_ROW = 10;
    public static int DEFAULT_COL = 10;
    public static Node DEFAULT_INITIAL_NODE = new Node(9, 0, 2);
    public static Node DEFAULT_FINAL_NODE = new Node(0, 9, 3);
    public static int[][] DEFAULT_BLOCK_LIST = new int[][]{{2, 3}, {3, 7}, {4, 1}, {4, 4}, {6, 8}, {7, 1}, {8, 5}};
    public List<Node> BlockList;

    public Map() {
        this.mapArea = new Node[DEFAULT_ROW][DEFAULT_COL];
        buildMap(DEFAULT_INITIAL_NODE, DEFAULT_FINAL_NODE, DEFAULT_BLOCK_LIST);
    }

    public Map(int row, int col, Node initialNode, Node finalNode, int[][] blockList) {
        this.row = row;
        this.col = col;
        this.mapArea = new Node[this.row][this.col];
        buildMap(initialNode, finalNode, blockList);
    }

    /**
     * I: initial node
     * F: final node
     * x: block node
     * 0: unblock node
     * <p>
     * default map:
     * 0   0   0   0   0   0   0   0   0   F
     * 0   0   x   0   0   0   0   0   0   0
     * 0   0   0   0   0   0   0   x   0   0
     * 0   0   0   0   0   0   0   0   0   0
     * 0   x   0   0   x   0   0   0   0   0
     * 0   0   0   0   0   0   0   0   0   0
     * 0   0   0   0   0   0   0   0   x   0
     * 0   x   0   0   0   0   0   0   0   0
     * 0   0   0   0   0   x   0   0   0   0
     * I   0   0   0   0   0   0   0   0   0
     **/

    public int row;
    public int col;
    public Node initialNode;
    public Node finalNode;
    public int[][] blockList;
    private Node[][] mapArea;

    protected void buildMap(Node initialNode, Node finalNode, int[][] blockList) {
        this.initialNode = initialNode;
        this.finalNode = finalNode;
        this.blockList = blockList;
        for (int i = 0; i < mapArea.length - 1; i++) {
            for (int j = 0; j < mapArea[0].length; j++) {
                mapArea[i][j] = new Node(col, row, 0);
            }
        }

        //TODO: set block node
        for(int i=0;i<blockList.length;i++) {

        }
    }
}
