import java.util.List;



/**
 * I: initial node
 * F: final node
 * x: block node
 * 0: unblock node
 *
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
    public static int[][] DEFAULT_BLOCK_LIST = new int[][]{{1, 2}, {2,7}, {4, 1}, {4, 4}, {6, 8}, {7, 1}, {8, 5}};


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



    public int row;
    public int col;
    public Node initialNode;
    public Node finalNode;
    public int[][] blockList;
    public Node[][] mapArea;

    protected void buildMap(Node initialNode, Node finalNode, int[][] blockList) {
        this.initialNode = initialNode;
        this.finalNode = finalNode;
        this.blockList = blockList;

        //set all all nodes unblocked
        for (int i = 0; i < mapArea.length ; i++) {
            for (int j = 0; j < mapArea[0].length; j++) {
                mapArea[i][j] = new Node(i, j, 0);
            }
        }

        //set block nodes
        for (int[] blocks : blockList) {
            mapArea[blocks[0]][blocks[1]].setState(Node.BLOCK_NODE);
        }

        //set initial and final node
        mapArea[initialNode.getCol()][initialNode.getRow()].setState(Node.INITIAL_NODE);
        mapArea[finalNode.getCol()][finalNode.getRow()].setState(Node.FINAL_NODE);
    }
}
