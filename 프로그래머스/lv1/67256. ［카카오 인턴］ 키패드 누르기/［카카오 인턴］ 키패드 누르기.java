class Solution {
    
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        boolean isLeftHand = hand.equals("left");
        Node left = new Node(3, 0);
        Node right = new Node(3, 2);
        int leftMove, rightMove;
        
        for(int number : numbers){
            switch(number){
                case 1:
                    answer += "L";
                    left = new Node(0, 0);
                    break;
                case 4:
                    answer += "L";
                    left = new Node(1, 0);
                    break;
                case 7:
                    answer += "L";
                    left = new Node(2, 0);
                    break;
                case 3:
                    answer += "R";
                    right = new Node(0, 2);
                    break;
                case 6:
                    answer += "R";
                    right = new Node(1, 2);
                    break;
                case 9:
                    answer += "R";
                    right = new Node(2, 2);
                    break;
                case 2:
                    leftMove = Math.abs(left.x - 0) + Math.abs(left.y - 1);
                    rightMove = Math.abs(right.x - 0) + Math.abs(right.y - 1);
                    if(leftMove > rightMove || leftMove == rightMove && !isLeftHand){
                        answer += "R";
                        right = new Node(0, 1);
                    }
                    else if(leftMove < rightMove || leftMove == rightMove && isLeftHand){
                        answer += "L";
                        left = new Node(0, 1);
                    }
                    break;
                case 5:
                    leftMove = Math.abs(left.x - 1) + Math.abs(left.y - 1);
                    rightMove = Math.abs(right.x - 1) + Math.abs(right.y - 1);
                    if(leftMove > rightMove || leftMove == rightMove && !isLeftHand){
                        answer += "R";
                        right = new Node(1, 1);
                    }
                    else if(leftMove < rightMove || leftMove == rightMove && isLeftHand){
                        answer += "L";
                        left = new Node(1, 1);
                    }
                    break;
                case 8:
                    leftMove = Math.abs(left.x - 2) + Math.abs(left.y - 1);
                    rightMove = Math.abs(right.x - 2) + Math.abs(right.y - 1);
                    if(leftMove > rightMove || leftMove == rightMove && !isLeftHand){
                        answer += "R";
                        right = new Node(2, 1);
                    }
                    else if(leftMove < rightMove || leftMove == rightMove && isLeftHand){
                        answer += "L";
                        left = new Node(2, 1);
                    }
                    break;
                case 0:
                    leftMove = Math.abs(left.x - 3) + Math.abs(left.y - 1);
                    rightMove = Math.abs(right.x - 3) + Math.abs(right.y - 1);
                    if(leftMove > rightMove || leftMove == rightMove && !isLeftHand){
                        answer += "R";
                        right = new Node(3, 1);
                    }
                    else if(leftMove < rightMove || leftMove == rightMove && isLeftHand){
                        answer += "L";
                        left = new Node(3, 1);
                    }
                    break;
            }
        }
        return answer;
    }
}