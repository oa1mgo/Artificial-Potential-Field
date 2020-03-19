import java.util.ArrayList;
import java.util.List;

/**
 * @program: Artificial-Potential-Field
 * @description: artificial potential field algorithm
 * @author: Miao Jiaxin
 * @create: 2019-12-16 16:46
 **/

public class ArtificialPotentialField {
    private Map mMap;
    private Node initialNode;
    private Node finalNode;
    private Node[][] mapArea;
    private int mapCol;
    private int mapRow;
    private int iteration = 0;
    private int maxIteration = 100;
    private int stepLength = 1;
    private static double ATTRACTION_COEFFICIENT = 0.5;
    private static double REPULSION_COEFFICIENT = 20.0;

    private ArrayList<Node> nodeList = new ArrayList<Node>();

    public ArtificialPotentialField(Map mMap) {
        if (mMap != null) {
            this.mMap = mMap;
            this.initialNode = mMap.initialNode;
            this.finalNode = mMap.finalNode;
            this.mapArea = mMap.mapArea;
            this.mapCol = mapArea[0].length;
            this.mapRow = mapArea.length;
            this.nodeList.add(initialNode);
        }
    }

    public ArrayList<Node> findPath() {
        //TODO: 算法主体
        /***
         * 1.搜索规定区域内的障碍物和终点，记录当前点
         * 2.判断是否到达终点或迭代次数超过规定值
         * 3.计算合力的方向
         * 4.移动一步，迭代次数加一
         * 5.跳到步骤2
         * */
        Node currentNode = initialNode;
        int[][] obstacleList = mMap.blockList;
        int obstacleListSize = obstacleList.length;
        int stepDirection = -1;
        while (!currentNode.equals(finalNode) && iteration <= maxIteration) {
            Force force = new Force(0, 0);
            nodeList.add(currentNode);
            addForce(currentNode, finalNode, finalNode.getState(), force);
            for (int[] obstacle : obstacleList) {
                Node node = mapArea[obstacle[0]][obstacle[1]];
                addForce(currentNode, node, node.getState(), force);
            }
            stepDirection = calculateStepDirection(force.getDirection());
//            System.out.println(currentNode + ", direction:" + stepDirection+", Force:"+force.getSize()+","+force.getDirection()*180/Math.PI);
            System.out.println(currentNode.getCol()+"   "+currentNode.getRow());
            //TODO: move current node.
            currentNode = moveCurrentNode(currentNode, stepDirection);
            iteration++;
        }
        return nodeList;
    }

    private Node moveCurrentNode(Node currentNode, int stepDirection) {
        int col = currentNode.getCol();
        int row = currentNode.getRow();
        Node nextNode = currentNode;
        switch (stepDirection) {
            case 0:     //east
                if (row + 1 < mapRow) {
                    nextNode = mapArea[col][row + 1];
                } else {
                    System.out.println("Cannot move current node, direction:" + stepDirection);
                }
                break;
            case 1:     //north- east
                if (col - 1 >= 0 && row + 1 < mapRow) {
                    nextNode = mapArea[col - 1][row + 1];
                } else if (col - 1 < 0 && row + 1 < mapRow) {
                    nextNode = mapArea[col][row + 1];
                } else if (col - 1 >= 0 && row + 1 >= mapRow) {
                    nextNode = mapArea[col - 1][row];
                } else {
                    System.out.println("Something wrong happened when move node, direction:" + stepDirection);
                }
                break;
            case 2:     //north
                if (col - 1 >= 0) {
                    nextNode = mapArea[col - 1][row];
                    nextNode = mapArea[col - 1][row];
                } else {
                    System.out.println("Cannot move current node, direction:" + stepDirection);
                }
                break;
            case 3:     //north-west
                if (col - 1 >= 0 && row - 1 >= 0) {
                    nextNode = mapArea[col - 1][row - 1];
                } else if (col - 1 < 0 && row - 1 >= 0) {
                    nextNode = mapArea[col][row - 1];
                } else if (col - 1 >= 0 && row - 1 < 0) {
                    nextNode = mapArea[col - 1][row];
                } else {
                    System.out.println("Something wrong happened when move node, direction:" + stepDirection);
                }
                break;
            case 4:     //west
                if (row - 1 >= 0) {
                    nextNode = mapArea[col][row - 1];
                } else {
                    System.out.println("Cannot move current node, direction:" + stepDirection);
                }
                break;
            case 5:     //south-west
                if (col + 1 < mapCol && row - 1 >= 0) {
                    nextNode = mapArea[col + 1][row - 1];
                } else if (col + 1 >= mapCol && row - 1 >= 0) {
                    nextNode = mapArea[col][row - 1];
                } else if (col + 1 < mapCol && row - 1 < 0) {
                    nextNode = mapArea[col + 1][row];
                } else {
                    System.out.println("Something wrong happened when move node, direction:" + stepDirection);
                }
                break;
            case 6:     //south
                if (col + 1 < mapCol) {
                    nextNode = mapArea[col + 1][row];
                } else {
                    System.out.println("Cannot move current node!!! direction:" + stepDirection);
                }
                break;
            case 7:     //south-east
                if (col + 1 < mapCol && row + 1 < mapRow) {
                    nextNode = mapArea[col + 1][row + 1];
                } else if (col + 1 > mapCol && row + 1 < mapRow) {
                    nextNode = mapArea[col][row + 1];
                } else if (col + 1 < mapCol && row + 1 > mapRow) {
                    nextNode = mapArea[col + 1][row];
                } else {
                    System.out.println("Something wrong happened when move node, direction:" + stepDirection);
                }
                break;
            default:    //default
                break;
        }
        return nextNode;
    }

    private int calculateStepDirection(double dir) {
        int stepDirection = -1;
        if (dir <= Math.PI / 8) {
            stepDirection = 0;
        } else if (dir <= Math.PI * 3 / 8) {
            stepDirection = 1;
        } else if (dir <= Math.PI * 5 / 8) {
            stepDirection = 2;
        } else if (dir <= Math.PI * 7 / 8) {
            stepDirection = 3;
        } else if (dir <= Math.PI * 9 / 8) {
            stepDirection = 4;
        } else if (dir <= Math.PI * 11 / 8) {
            stepDirection = 5;
        } else if (dir <= Math.PI * 13 / 8) {
            stepDirection = 6;
        } else if (dir <= Math.PI * 15 / 8) {
            stepDirection = 7;
        } else {
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
            setResultantForceY(-y);
            setSize(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
            setDirection(Math.atan2(-y, x));
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
        double dir = Math.atan2(-(currentNode.getCol() - node.getCol()), currentNode.getRow() - node.getRow());
        double direction = state == 1 ? dir : dir + Math.PI;
        double forceSize = coefficient * Math.pow(squDistance, index);

        force.setResultantForceX(force.getResultantForceX() + forceSize * Math.cos(direction));
        force.setResultantForceY(force.getResultantForceY() + forceSize * Math.sin(direction));
        force.setSize(force.getSize() + forceSize);
        force.setDirection(Math.atan2(force.getResultantForceY(), force.getResultantForceX()));
    }


}
