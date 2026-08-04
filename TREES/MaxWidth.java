import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
class pair{
    TreeNode node;
    int data;
    pair(TreeNode node , int data){
        this.node = node;
        this.data = data;
    }
}
class MaxWidth{
    public static void main(String[] args) {
    TreeNode root = new TreeNode(1);

    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(7);

    MaxWidth obj = new MaxWidth();

    int ans = obj.widthOfBinaryTree(root);

    System.out.println("Maximum Width = " + ans);
    }
    public int widthOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        Queue<pair> q = new LinkedList<>();  
        q.offer(new pair(root , 0)); 
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().data;
            int first = 0;
            int last = 0;
            for(int i = 0 ; i <size;i++){
                int currInd = q.peek().data - minIndex;
                TreeNode node = q.peek().node;
                q.poll();
                if(i ==0) first = currInd;
                if(i == size-1) last = currInd;

                if(node.left !=null){
                    q.offer(new pair(node.left , 2*currInd+1));
                }
                if(node.right != null){
                    q.offer(new pair(node.right , 2*currInd+2));
                }
            }
            maxWidth = Math.max(maxWidth , last-first+1);

        } 
        return maxWidth;
    }
}