/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid,0,grid.length-1,0,grid.length-1);
    }
    private Node helper(int[][] grid,int rowStart,int rowEnd, int colStart, int colEnd){
        int value=grid[rowStart][colStart];
        boolean same=true;
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                if(grid[i][j]!=value){
                    same=false;
                }
            }
        }
                if(same){
                    return new Node(value==1,true);
                }
                int midRow=(rowStart+rowEnd)/2;
                int midCol=(colStart+colEnd)/2;
                Node root=new Node(false,false);
                root.topLeft=helper(grid,rowStart,midRow,colStart,midCol);
                root.topRight=helper(grid,rowStart,midRow,midCol+1,colEnd);
                root.bottomLeft = helper(
    grid, midRow + 1, rowEnd,
    colStart, midCol
);
root.bottomRight = helper(
    grid, midRow + 1, rowEnd,
    midCol + 1, colEnd
);
return root;
            }
        }