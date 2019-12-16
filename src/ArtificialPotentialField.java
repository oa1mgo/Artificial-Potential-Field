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
        int stepDirection = -1;
        while (currentNode != finalNode || iteration < 100) {
            for (int i = 0; i < obstacleListSize; i++) {
                Node node = mapArea[obstacleList[i][0]][obstacleList[i][1]];
                addForce(currentNode, node, node.getState(), force);
            }
            stepDirection = calculateStepDirection(force.getDirection());
            //TODO: move current node.

        }


        //TODO: return node list
        return null;
    }

    private int calculateStepDirection(double dir) {
        int stepDirection = -1;
        if(dir<=Math.PI/8) {
            stepDirection = 0;
        } else if (dir<=Math.PI*3/8){
            stepDirection = 1;
        } else if (dir<=Math.PI*5/8){
            stepDirection = 2;
        } else if (dir<=Math.PI*7/8){
            stepDirection = 3;
        } else if (dir<=Math.PI*9/8){
            stepDirection = 4;
        } else if (dir<=Math.PI*11/8){
            stepDirection = 5;
        } else if (dir<=Math.PI*13/8){
            stepDirection = 6;
        } else if (dir<=Math.PI*15/8){
            stepDirection = 7;
        } else  {
            stepDirection = 0;
        }
        return stepDirection;
    }


    class Force {
        private double resultantForceX;
        private double resultantForceY;
        private double direction;
        private double size;

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
            setResultantForceX(x);
            setResultantForceY(y);
            setSize(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
            setDirection(Math.atan2(y, x));
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

    private void addForce(Node currentNode, Node node, int state, Force force) {
        int index = state == 1 ? -1 : 1;    //BLOCK_NODE = 1  FINAL_NODE = 3
        double coefficient = state == 1 ? REPULSION_COEFFICIENT : ATTRACTION_COEFFICIENT;
        double squDistance = Math.pow(currentNode.getCol() - node.getCol(), 2) + Math.pow(currentNode.getRow() - node.getRow(), 2);
        double dir = Math.atan2(currentNode.getCol() - node.getCol(), currentNode.getRow() - node.getRow());
        double direction = state == 1 ? dir : dir + Math.PI;
        double forceSize = coefficient * Math.pow(squDistance, index);

        force.setResultantForceX(force.getResultantForceX()+forceSize*Math.cos(direction));
        force.setResultantForceY(force.getResultantForceY()+forceSize*Math.sin(direction));
        force.setSize(force.getSize()+forceSize);
        force.setDirection(Math.atan2(force.getResultantForceY(),force.getResultantForceX()));
    }


}
