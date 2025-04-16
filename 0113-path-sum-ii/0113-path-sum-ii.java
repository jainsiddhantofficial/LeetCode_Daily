class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        generate(root,targetSum,res,new ArrayList());
        return res;
    }
    private void generate(TreeNode root, int targetSum,List<List<Integer>> res, List<Integer> list){
        if(null == root) return;
        if(null == root.left && null == root.right){
            if(targetSum == root.val){
                list.add(root.val);
                res.add(list);
            }
        }
        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        list1.add(root.val);
        list2.add(root.val);
        generate(root.left,targetSum-root.val,res,list1);
        generate(root.right,targetSum-root.val,res,list2);
    }
}