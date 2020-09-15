/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        travelAndConvert(root, builder);
        
        //System.out.println(builder);
        
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return buildTree(data);
        
    }
    
    // 1(2)(3(4)(5))

    private TreeNode buildTree(String str){
        if (str.length()==0) return null;
        
        int index = str.indexOf("(");
        int val = index == -1 ? Integer.parseInt(str) : Integer.parseInt(str.substring(0,index));
        TreeNode root = new TreeNode(val);
        
        if (index == -1) return root;
        
        int count = 1, secondIndex = 0;
        
        for (int i=index+1; i<str.length(); i++){
            char c = str.charAt(i);
            if (c=='(') count++;
            else if (c==')') count--;
            
            if (count==0 && secondIndex==0){
                root.left = buildTree(str.substring(index+1, i));
                secondIndex = i+1;
            }
            else if (count == 0){
                root.right = buildTree(str.substring(secondIndex+1, i));
            }
        }
        
        return root;
    }
    
    // TreeNode to String
    private void travelAndConvert(TreeNode root, StringBuilder builder){
        if (root == null) return;
        
        builder.append(root.val);
        
        if (root.left==null && root.right==null) return;
        
        builder.append("(");
        travelAndConvert(root.left, builder);
        builder.append(")");
        
        if (root.right!=null){
            builder.append("(");
            travelAndConvert(root.right, builder);
            builder.append(")");
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
