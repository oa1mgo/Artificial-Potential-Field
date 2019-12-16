import java.text.DecimalFormat;
import java.util.List;

/**
 * @program: Artificial-Potential-Field
 * @description: artificial potential field algorithm
 * @author: Miao Jiaxin
 * @create: 2019-12-16 16:46
 **/

public class ArtificialPotentialField {
    private Map mMap;
    Node initialNode;
    Node finalNode;
    Node[][] mapArea;


    public int iteration = 0;
    public int stepLength = 1;
    public static double ATTRACTION_COEFFICIENT = 1.0;
    public static double REPULSION_COEFFICIENT = 4.0;

    private Force force = new Force(0, 0);

    public ArtificialPotentialField(Map mMap) {
        if (mMap != null) {
            this.mMap = mMap;
            this.initialNode = mMap.initialNode;
            this.finalNode = mMap.finalNode;
            this.mapArea = mMap.mapArea;
        }
    }

    public List<Node> findPath() {
        //TODO: 算法主体
        /***
         * 1.搜索规定区域内的障碍物和终点
         * 2.判断是否到达终点或迭代次数超过规定值
         * 3.计算合力的方向
         * 4.移动一步
         * 5.跳到步骤2
         * */

        Node currentNode = initialNode;
        int[][] obstacleList = mMap.blockList;
        int obstacleListSize = obstacleList.length;
        while (currentNode != finalNode || iteration < 100) {
            for (int i = 0; i < obstacleListSize; i++) {
                Node node = mapArea[obstacleList[i][0]][obstacleList[i][1]];
                calculateResultantForce(currentNode, node, node.getState(), force);

            }
        }


        //TODO: return node list
        return null;
    }


    class Force {
        public double resultantForceX;
        public double resultantForceY;

        public double direction;
        public double size;

        public double getDirection() {
            return direction;
        }

        public void setDirection(double direction) {
            this.direction = direction;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public Force(double x, double y) {
            this.resultantForceX = x;
            this.resultantForceY = y;

        }

        private void calculateForce(double x, double y) {
            if (x == 0) {
                setDirection(y > 0 ? Math.PI / 2 : Math.PI * 3 / 2);
            }
            setSize(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));

        }

        public double getResultantForceX() {
            return resultantForceX;
        }

        public void setResultantForceX(double resultantForceX) {
            this.resultantForceX = resultantForceX;
        }

        public double getResultantForceY() {
            return resultantForceY;
        }

        public void setResultantForceY(double resultantForceY) {
            this.resultantForceY = resultantForceY;
        }
    }

    private void calculateResultantForce(Node currentNode, Node node, int state, Force force) {
//        force.setResultantForceX(force.getResultantForceX()+calculateResultantForceX(currentNode, node, node.getState()));
//        force.setResultantForceY(force.getResultantForceY()+calculateResultantForceY(currentNode, node, node.getState()));
        double squDistance = calculateSquareDistance(currentNode, node);
        int index = state == 1 ? -1 : 1;    //BLOCK_NODE = 1  FINAL_NODE = 3
        double coefficient = state == 1 ? REPULSION_COEFFICIENT : ATTRACTION_COEFFICIENT;

    }

    private double calculateResultantForceX(Node currentNode, Node node, int nodeState) {
        double squDistance = calculateSquareDistance(currentNode, node);
        return 0;
    }


    private double calculateResultantForceY(Node currentNode, Node node, int nodeState) {
        double squDistance = calculateSquareDistance(currentNode, node);
        return 0;
    }

    private double calculateSquareDistance(Node currentNode, Node node) {
        return Math.pow(currentNode.getCol() - node.getCol(), 2) + Math.pow(currentNode.getRow() - node.getRow(), 2);
    }
}
