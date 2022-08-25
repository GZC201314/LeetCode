package org.gzc.leetcode;

import org.gzc.leetcode.model.*;
import org.gzc.leetcode.model.Node;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author GZC
 */
public class Solution202208 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int questionNum = input.nextInt();
        switch (questionNum) {
            case 503:
                System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 3, 4, 3})));
                break;
            case 1403:
                System.out.println(minSubsequence(new int[] {4, 4, 6, 7, 7}));
                break;
            case 623:
                System.out.println(addOneRow(new TreeNode(4), 1, 3));
                break;
            case 123:
                morris(new Node(5, new Node(4), new Node(2)));
                break;
            case 124:
                preOrderMorris(new Node(5, null, new Node(2)));
                break;
            case 507:
                System.out.println(checkPerfectNumber(28));
                break;
            case 517:
                System.out.println(findMinMoves(new int[] {3, 4, 5}));
                break;
            case 666:
                goodNote(new int[] {3, 4, 5});
                break;
            case 888:
                System.out.println(getValue("-1+4*(-2*3)"));
                break;
            case 640:
                System.out.println(solveEquation("3x+6=2x"));
                break;
            case 1302:
                System.out.println(deepestLeavesSum(new TreeNode(1)));
                break;
            case 33:
                System.out.println(verifyPostorder(new int[] {4, 6, 7, 5}));
                break;
            case 1450:
                System.out.println(busyStudent(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}, 4));
                break;
            case 2344:
                System.out.println(minOperations(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;
            case 1818:
                System.out.println(minAbsoluteSumDiff(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;
            case 1460:
                System.out.println(canBeEqual(new int[] {4, 6, 7, 5}, new int[] {4, 6, 7, 5}));
                break;

            case 508:
                System.out.println(Arrays.toString(findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
                break;
            case 655:
                System.out.println(printTree(new TreeNode(1,new TreeNode(2),null)));
                break;
            case 1569:
                System.out.println(numOfWays(new int[] {4, 6, 7, 5}));
                break;
            case 1042:
                System.out.println(Arrays.toString(gardenNoAdj(4,new int[][]{{1,2},{3,4},{3,2},{4,2},{1,4}})));
                break;
            default:
                break;
        }

    }

    /**
     * 1569. 将子数组重排序得到同一个二叉查找树的方案数
     */
    public static int[][] C;
    public static int mod = 1000000007;
    public static int numOfWays(int[] nums) {
        int n = nums.length;
        // 预处理先计算组合数
        C =  new int[n+1][n+1];
        getC(n);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return dfsNumOfWays(res)-1;
    }

    public static int dfsNumOfWays(List<Integer> nums){
        int n = nums.size();
        if(n == 0){
            return 1;
        }
        //答案只有在头结点相同的重排中
        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if(nums.get(i) < root){
                left.add(nums.get(i));
            }else {
                right.add(nums.get(i));
            }
        }
        int leftCount = dfsNumOfWays(left);
        int rightCount = dfsNumOfWays(right);

        return (int)((long)C[n - 1][left.size()] * leftCount % mod * rightCount % mod);

    }

    /**
     * 计算组合数
     */
    public static void getC(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=i ; j++) {
                if (j ==0){
                    C[i][j] =1;
                }else {
                    C[i][j] = (C[i-1][j]+C[i-1][j-1])%mod;
                }
            }
        }
    }

    /**
     * 1460. 通过反转子数组使两个数组相等
     */
    public static boolean canBeEqual(int[] target, int[] arr) {

        int m = target.length;
        int n = arr.length;
        if(m !=n){
            return false;
        }
        HashMap<Integer,Integer> targetSet = new HashMap<>();
        HashMap<Integer,Integer> arrSet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            targetSet.put(target[i], targetSet.getOrDefault(target[i],0)+1);
            arrSet.put(arr[i], arrSet.getOrDefault(arr[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> targerEntry : targetSet.entrySet()) {
            if(!targerEntry.getValue().equals(arrSet.get(targerEntry.getKey()))){
                return false;
            }else {
                arrSet.remove(targerEntry.getKey());
            }
        }
        return arrSet.isEmpty();
    }

    /**
     * 655. 输出二叉树
     */
    public static List<List<String>> printTree(TreeNode root) {
        Queue<Info1> queue = new LinkedList<>();
        // 获取二叉树的深度
        int height = printTreeHandler(root);
        int n = (1<< height)-1;
        String[][] res = new String[height][n];
        res[0][(n-1)/2] = String.valueOf(root.val);
        queue.offer(new Info1(root, 0, (n - 1) / 2));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info1 node = queue.poll();
                assert node != null;
                int r = node.r;
                int c = node.c;
                //获取它的左右孩子结点
                if (node.node.left != null){
                    int nextR = r+1;
                    int nextC = c-(1<<(height-r-2));
                    res[nextR][nextC] = String.valueOf(node.node.left.val);
                    queue.offer(new Info1(node.node.left, nextR, nextC));
                }
                if(node.node.right != null){
                    int nextR = r+1;
                    int nextC = c+(1<<(height-r-2));
                    res[nextR][nextC] = String.valueOf(node.node.right.val);
                    queue.offer(new Info1(node.node.right, nextR, nextC));
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (res[i][j] == null){
                    list.add("");
                }else {
                    list.add(res[i][j]);
                }
            }
            result.add(list);
        }
        return result;



    }
    static class Info1{
        TreeNode node;
        int r;
        int c;
        public Info1(TreeNode node,int r,int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public static int printTreeHandler(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int leftHeight = printTreeHandler(root.left);
        int rightHeight = printTreeHandler(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    /**
     * 1818. 绝对差值和
     */
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int mod = 1000000007;
        long ans = 0;
        int n = nums1.length;
        for (int i : nums1) {
            treeSet.add(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num1 = nums1[i];
            int num2 = nums2[i];
            int curAns = Math.abs(num1 - num2);
            Integer floor = treeSet.floor(num2);
            if (floor != null) {
                max = Math.max(max, curAns - Math.abs(floor - num2));
            }
            Integer ceiling = treeSet.ceiling(num2);
            if (ceiling != null) {
                max = Math.max(max, curAns - Math.abs(ceiling - num2));
            }
            ans += curAns;
            ans %= mod;
        }

        return (int)(ans - max + mod) % mod;
    }

    /**
     * 2344. 使数组可以被整除的最少删除次数
     */
    public static int minOperations(int[] nums, int[] numsDivide) {
        int g =0;
        for (int j : numsDivide) {
            g = gcd(g, j);
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();

        int result =0;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if(g%key ==0){
                return result;
            }else {
                result+= map.get(key);
            }
        }
        return -1;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    /**
     * 剑指 Offer 33. 二叉搜索树的后序遍历序列
     */
    public static boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        int[] inorder = Arrays.copyOf(postorder, n);
        Arrays.sort(inorder);
        return verifyPostorderHandle(postorder, inorder, 0, n - 1, 0, n - 1);

    }

    public static boolean verifyPostorderHandle(int[] postorder, int[] inorder, int posti, int postj, int ini,
        int inj) {
        if (posti == postj && ini == inj) {
            return postorder[posti] == inorder[ini];
        }
        // 遍历完毕 返回true
        if (posti > postj || ini > inj) {
            return true;
        }

        // 获取根结点
        int root = postorder[postj];
        // 获取根结点在中序遍历中的位置
        int rootInorderIndex = -1;
        for (int i = ini; i <= inj; i++) {
            if (inorder[i] == root) {
                rootInorderIndex = i;
                break;
            }
        }
        if (rootInorderIndex == -1) {
            return false;
        }
        int[] subPostOrderLeft;
        if (posti > posti + rootInorderIndex - ini) {
            return true;
        } else {
            subPostOrderLeft = Arrays.copyOfRange(postorder, posti, posti + rootInorderIndex - ini);
        }
        int[] subPostOrderRight;
        if (posti + rootInorderIndex - ini > postj) {
            return true;
        } else {
            subPostOrderRight = Arrays.copyOfRange(postorder, posti + rootInorderIndex - ini, postj);
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMin = Integer.MAX_VALUE;

        if (subPostOrderLeft.length > 0) {
            for (int node : subPostOrderLeft) {
                leftMax = Math.max(leftMax, node);
            }
        }
        if (subPostOrderRight.length > 0) {
            for (int node : subPostOrderRight) {
                rightMin = Math.min(rightMin, node);
            }
        }

        return verifyPostorderHandle(postorder, inorder, posti, posti + rootInorderIndex - ini - 1, ini,
            rootInorderIndex - 1)
            && verifyPostorderHandle(postorder, inorder, posti + rootInorderIndex - ini, postj - 1,
                rootInorderIndex + 1, inj)
            && root > leftMax && root < rightMin;

    }

    /**
     * 1042. 不邻接植花
     */
    public static int[] gardenNoAdj(int n, int[][] paths) {

        Map<Integer, List<Integer>> s2e = new HashMap<>();
        Map<Integer, List<Integer>> e2s = new HashMap<>();
        for (int[] path : paths) {
            List<Integer> s2eList = s2e.getOrDefault(path[0], new ArrayList<>());
            List<Integer> e2sList = e2s.getOrDefault(path[1], new ArrayList<>());
            s2eList.add(path[1]);
            e2sList.add(path[0]);
            s2e.put(path[0], s2eList);
            e2s.put(path[1], e2sList);
        }
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            // 先求出当前节点所有的邻接节点

            //1. 获取所有的出度
            List<Integer> s2eList = s2e.get(i);
            List<Integer> e2sList = e2s.get(i);
            int[] flowers = new int[(s2eList ==null?0:s2eList.size())+(e2sList == null?0:e2sList.size())];
            int index = 0;
            if(s2eList != null){
                for (Integer flower : s2eList) {
                    flowers[index++] = flower;
                }
            }
            if(e2sList != null){
                for (Integer flower : e2sList) {
                    flowers[index++] = flower;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int flower : flowers) {
                if (result[flower-1] !=0){
                    set.add(result[flower-1]);
                }
            }
            if(set.size() ==0){
                result[i-1] = 1;
            }else {
                for (int j = 1; j <=4 ; j++) {
                    if(!set.contains(j)){
                        result[i-1] = j;
                        break;
                    }
                }
            }
        }

        return result;


    }

    /**
     * 1302. 层数最深叶子节点的和
     */
    public static int deepestLeavesSum(TreeNode root) {

        return handleDeepestLeavesSum(root, 0).sum;
    }

    public static Info handleDeepestLeavesSum(TreeNode node, int deep) {
        if (node == null) {
            return new Info(deep, 0);
        }
        if (node.left == null && node.right == null) {
            return new Info(deep, node.val);
        }
        Info leftInfo = handleDeepestLeavesSum(node.left, deep + 1);
        Info rightInfo = handleDeepestLeavesSum(node.right, deep + 1);
        int sum;
        int maxDeep = leftInfo.deep;
        if (leftInfo.deep > rightInfo.deep) {
            sum = leftInfo.sum;
        } else if (leftInfo.deep < rightInfo.deep) {
            maxDeep = rightInfo.deep;
            sum = rightInfo.sum;
        } else {
            sum = leftInfo.sum + rightInfo.sum;
        }
        return new Info(maxDeep, sum);
    }

    static class Info {
        int deep;
        int sum;

        public Info(int deep, int sum) {
            this.deep = deep;
            this.sum = sum;
        }
    }

    /**
     * 503. 下一个更大元素||
     */
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > num) {
                    result[i] = nums[j % n];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 1403. 非递增顺序的最小子序列
     */
    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        // 对数组进行排序
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int leftNum = 0;
        result.add(nums[right]);
        int rightNum = nums[right--];

        while (left <= right) {
            if (leftNum + nums[left] < rightNum) {
                leftNum += nums[left++];
            } else {
                result.add(nums[right]);
                rightNum += nums[right--];
            }
        }
        return result;
    }

    /**
     * 623. 在二叉树中增加一行
     */
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curDepth == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val, left, null);
                    node.right = new TreeNode(val, null, right);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            curDepth++;
        }

        return root;
    }

    /**
     * 507. 完美数
     */
    public static boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i <= num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

    /**
     * 508. 出现次数最多的子树元素和
     */
    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        dfsCheckPerfectNumber(root, sumMap);

        sumMap.forEach((key, value) -> countMap.put(value, countMap.getOrDefault(value, 0) + 1));
        Stream<Integer> stream = countMap.values().stream();
        int max = 0;
        Optional<Integer> max1 = stream.max(Integer::compareTo);
        if (max1.isPresent()) {
            max = max1.get();
        }
        List<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        int finalMax = max;
        entries.forEach((entry) -> {
            if (entry.getValue() == finalMax) {
                list.add(entry.getKey());
            }
        });
        int[] result = new int[list.size()];

        int index = 0;
        for (Integer key : list) {
            result[index++] = key;
        }
        return result;

    }

    public static int dfsCheckPerfectNumber(TreeNode node, Map<TreeNode, Integer> sumMap) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            sumMap.put(node, node.val);
            return node.val;
        }
        if (sumMap.containsKey(node)) {
            return sumMap.get(node);
        }
        int sum = node.val + dfsCheckPerfectNumber(node.left, sumMap) + dfsCheckPerfectNumber(node.right, sumMap);
        sumMap.put(node, sum);
        return sum;
    }

    /**
     * 二叉树 morris 遍历
     */
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次访问cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    /**
     * mirris 先序遍历
     */
    public static void preOrderMorris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight;
        while (cur != null) {
            // mostRight 变成了cur左子树的最右的节点
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 第一次访问cur
                if (mostRight.right == null) {
                    System.out.println(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // 第二次访问cur
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    /**
     * 640. 求解方程
     */
    private static final String CHARS = "-+x=";

    public static String solveEquation(String equation) {
        equation += "=";
        int sign = 1, cur = 0, num = 0, k = 0;
        boolean hasVal = false, left = true;
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (CHARS.contains(String.valueOf(c))) {
                if (c == 'x') {
                    if (!hasVal && cur == 0) {
                        cur = 1;
                    }
                    k += left ? sign * cur : -sign * cur;
                } else {
                    num -= left ? sign * cur : -sign * cur;
                }
                cur = 0;
                hasVal = false;
            }

            switch (c) {
                case '-':
                    sign = -1;
                    break;
                case '+':
                    sign = 1;
                    break;
                case '=':
                    sign = 1;
                    left = false;
                    break;
                case 'x':
                    break;
                default:
                    cur = cur * 10 + (c - '0');
                    hasVal = true;
            }

        }
        if (k == 0) {
            return num != 0 ? "No solution" : "Infinite solutions";
        }
        return num % k == 0 ? String.format("x=%d", num / k) : "No solution";
    }

    /**
     * 517. 超级洗衣机
     */
    public static int findMinMoves(int[] machines) {
        int sum = 0;
        int n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) {
            return -1;
        }
        int ans = Integer.MIN_VALUE;
        int avg = sum / n;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = sum - leftSum - machines[i] - (n - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return ans;
    }

    public static int[] dp;
    public static int[] used;

    public static void goodNote(int[] nices) {
        int n = nices.length;
        dp = new int[n + 1];
        used = new int[n];
        System.out.println(handle(nices, 0));
        System.out.println(Arrays.toString(dp));
    }

    public static int handle(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        if (index == nums.length - 1) {
            return dp[index];
        }
        if (index == nums.length - 2) {
            dp[index] = Math.max(nums[index], nums[index + 1]);
            return dp[index];
        }
        dp[index] = Math.max(handle(nums, index + 2) + nums[index], handle(nums, index + 1));
        return dp[index];
    }

    /**
     * 1450. 在既定时间做作业的学生人数
     */
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int result = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                result++;
            }
        }

        return result;
    }


    /**
     * 888. 运算符计算
     */
    public static int getValue(String str){
        return value(str.toCharArray(),0)[0];
    }

    public static int[] value(char[] str, int i){
        Deque<String> que = new ArrayDeque<>();
        int num = 0;
        int[] bra;
        // 当前数组不越界
        while (i<str.length && str[i] != ')'){
            if (Character.isDigit(str[i])){
                num += num*10+str[i++]-'0';
            }else if(str[i] != '('){
                // 遇到的是运算符号
                addNum(que, num);
                que.addLast(String.valueOf(str[i++]));
                num = 0;
            }else {
                // 如果遇到的是（
                bra = value(str, i+1);
                num = bra[0];
                i = bra[1]+1;
            }
        }
        addNum(que,num);
        return new int[]{getNum(que),i};
    }

    /**
     * 计算只有+-的表达式的最终结果
     */
    private static int getNum(Deque<String> que) {
        while (que.size() >1){
            int firstNum = Integer.parseInt(que.pollFirst());
            String opt = que.pollFirst();
            int secend = Integer.parseInt(Objects.requireNonNull(que.pollFirst()));
            que.offerFirst(String.valueOf("+".equals(opt)?firstNum+secend:firstNum-secend));
        }
        return Integer.parseInt(Objects.requireNonNull(que.poll()));
    }

    private static void addNum(Deque<String> que, int num) {
        if(que.isEmpty()){
            que.addLast(String.valueOf(num));
            return;
        }
        // 如果栈顶元素是 * /
        if("*".equals(que.peekLast()) || "/".equals(que.peekLast())){
            String opt = que.pollLast();
            int firstNum = Integer.parseInt(Objects.requireNonNull(que.pollLast()));
            if("*".equals(opt)){
                que.offerLast(String.valueOf(firstNum*num));
            }else {
                que.offerLast(String.valueOf(firstNum/num));
            }
        }else {
            que.offerLast(String.valueOf(num));
        }
    }

}
