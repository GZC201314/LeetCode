package org.gzc.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author GZC
 * @description 华为机试
 */
public class Solution202204 {

    static String[] NUMS = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };
    static String[] NUMSSHI = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };
    static String[] POWER = {"", "thousand", "million", "billion"};

    static Map<String, Integer> map = new HashMap<>();
    static List<String> l = new ArrayList<>(); //储存结果

    public static String[] ten = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] power = {"万", "亿"};
    public static String[] daiwei = {"元", "角", "分", "整"};

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int qusetionNum = input.nextInt();
        switch (qusetionNum) {
            case 1:
                getLastWordLength();
                break;
            case 2:
                countWord();
                break;
            case 3:
                randomNumber();
                break;
            case 4:
                stringSplit();
                break;
            case 5:
                hex2ten();
                break;
            case 6:
                primeFactor();
                break;
            case 7:
                myRound();
                break;
            case 8:
                mergeTable();
                break;
            case 9:
                getDistinctNum();
                break;
            case 10:
                wordCount();
                break;
            case 11:
                revertNumber();
                break;
            case 12:
                revertString();
                break;
            case 13:
                revertSentence();
                break;
            case 14:
                sortString();
                break;
            case 15:
                oneCountForInteger();
                break;
            case 16:
                buyOrder();
                break;
            case 17:
                movexy();
                break;
            case 18:
                validateIpAndMask();
                break;
            case 19:
                simpleErrorLog();
                break;
            case 20:
                validatePassword();
                break;
            case 21:
                simplePassword();
                break;
            case 22:
                waterBottle();
                break;
            case 23:
                deleteLessChar();
                break;
            case 24:
                chorus();
                break;
            case 25:
                dataHandle();
                break;
            case 26:
                stringSort();
                break;
            case 27:
                findBrotherWord();
                break;
            case 28:
                primeCp();
                break;
            case 29:
                stringEncodeAndDecode();
                break;
            case 30:
                stringMerge();
                break;
            case 31:
                wordAsc();
                break;
            case 32:
                passwordSplit();
                break;
            case 33:
                num2ip();
                break;
            case 34:
                picHandle();
                break;
            case 35:
                serpentineMatrix();
                break;
            case 36:
                stringEncode();
                break;
            case 37:
                rabbitNum();
                break;
            case 38:
                pelletHeight();
                break;
            case 39:
                isInSubnet();
                break;
            case 40:
                countChar();
                break;
            case 41:
                weighingWeight();
                break;
            case 42:
                learnEnglish();
                break;
            case 43:
                mazeProblem();
                break;
            case 44:
                sodoku();
                break;
            case 45:
                nameBeautiful();
                break;
            case 46:
                splitString();
                break;
            case 48:
                deleteNodeFromLinkedList();
                break;
            case 50:
                quaternionOperation();
                break;
            case 51:
                getKthFromLinkedList();
                break;
            case 52:
                editDistance();
                break;
            case 53:
                yanghuiTriangle();
                break;
            case 54:
                getExpressionValue();
                break;
            case 55:
                serven();
                break;
            case 56:
                completeNum();
                break;
            case 57:
                bigNumberAdd();
                break;
            case 58:
                getKLessNumber();
                break;
            case 59:
                getFirstSingleChar();
                break;
            case 60:
                getClosedPrime();
                break;
            case 61:
                putApple();
                break;
            case 62:
                findOneCount();
                break;
            case 63:
                DNAOrder();
                break;
            case 64:
                Mp3CursorPosition();
                break;
            case 65:
                longestCommonSubString();
                break;
            case 66:
                configReset();
                break;
            case 67:
                twentyFourPoint();
                break;
            case 68:
                scoreSort();
                break;
            case 69:
                matrixMultiplication();
                break;
            case 70:
                matrixMultiplicationCount();
                break;
            case 71:
                stringPatton();
                break;
            case 72:
                hundredHen();
                break;
            case 73:
                getDaysByDate();
                break;
            case 74:
                paramsAnalysis();
                break;
            case 75:
                commonSubString();
                break;
            case 76:
                nikochusTheorem();
                break;
            case 77:
                trainEnterCentor();
                break;
            case 80:
                mergeTwoArray();
                break;
            case 81:
                twoStringPatton();
                break;
            case 82:
                egyptScore();
                break;
            case 83:
                twoDArrayOperation();
                break;
            case 84:
                upperCaseLetterCount();
                break;
            case 85:
                longestPalindromeSubstring();
                break;
            case 86:
                bitCount();
                break;
            case 87:
                validatePasswordStrong();
                break;
            case 88:
                cardOrder();
                break;
            case 89:
                cardTwentyForePoint();
                break;
            case 90:
                validateIP();
                break;
            case 91:
                walkSquare();
                break;
            case 92:
                longestNumberString();
                break;
            case 93:
                arrayGroup();
                break;
            case 94:
                voteCount();
                break;
            case 95:
                rmbConvert();
                break;
            case 96:
                representNumber();
                break;
            case 97:
                recordingNegativeAndPositive();
                break;

            default:
                break;
        }

    }

    private static void recordingNegativeAndPositive() {
        Scanner sc = new Scanner(System.in);
        int negativeCount =0;
        int positiveCount = 0;
        float sum =0;
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if( num>0){
                sum+=num;
                positiveCount++;
            }else if(num<0){
                negativeCount++;
            }
        }
        System.out.print(negativeCount);
        float avg =0;
        if(positiveCount >0){
            avg = sum/positiveCount;
        }
        System.out.printf(" %.1f",avg);
    }

    private static void representNumber() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] strArr = str.toCharArray();
            char last ='a';
            StringBuilder sb = new StringBuilder();
            for(char chr : strArr){
                if(Character.isDigit(chr)&& !Character.isDigit(last)){
                    sb.append("*").append(chr);
                }else if(Character.isDigit(last)&& !Character.isDigit(chr)){
                    sb.append("*").append(chr);
                }else{
                    sb.append(chr);
                }
                last = chr;

            }
            if(Character.isDigit(str.charAt(str.length()-1))){
                sb.append("*");
            }
            System.out.println(sb);
        }
    }

    private static void rmbConvert() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            StringBuilder sb = new StringBuilder("人民币");
            String money = in.nextLine();
            String[] moneyArr = money.split("\\.");

            if ("00".equals(moneyArr[1])) {
                System.out.println(sb.append(solveZheng(moneyArr[0])).append("元整"));
            } else if ("0".equals(moneyArr[0])) {
                System.out.println(sb.append(solveXiao(moneyArr[1])));
            }else{
                System.out.println(sb.append(solveZheng(moneyArr[0])).append("元").append(solveXiao(moneyArr[1])));
            }
        }
    }

    private static String solveZheng(String str) {
        StringBuilder zhengSB = new StringBuilder();
        int pow = 0;
        long zheng = Long.parseLong(str);
        while(zheng !=0){
            if(pow !=0){
                zhengSB.append(power[pow-1]);
            }
            int jishu = (int)(zheng%10000);
            int gewei = jishu%10;
            int shiwei = (jishu/10)%10;
            int baiwei = (jishu/100)%10;
            int qianwei = (jishu/1000)%10;
            // 个位
            if(gewei !=0){
                zhengSB.append(ten[gewei]);
            }
            // 十位
            if(shiwei !=0){
                zhengSB.append("拾");
                if(shiwei !=1){
                    zhengSB.append(ten[shiwei]);
                }
            }else{
                //补零
                if(gewei !=0 && (jishu>99 || zheng >10000)){
                    zhengSB.append(ten[0]);
                }
            }
            // 百位
            if(baiwei !=0){
                zhengSB.append("佰").append(ten[baiwei]);
            }else{
                if(shiwei !=0 && (jishu>999||zheng >10000)){
                    zhengSB.append(ten[0]);
                }
            }
            //千位
            if(qianwei !=0){
                zhengSB.append("仟").append(ten[qianwei]);
            }else{
                if(baiwei !=0 &&(zheng>10000)){
                    zhengSB.append(ten[0]);
                }
            }

            zheng /=10000;
            pow++;
            if(pow>2){
                pow =1;
            }
        }

        return zhengSB.reverse().toString();
    }
    private static String solveXiao(String str) {
        StringBuilder xiaoSB = new StringBuilder();
        int jiao = Integer.parseInt(str.substring(0,1));
        int fen = Integer.parseInt(str.substring(1,2));
        if(jiao !=0){
            xiaoSB.append(ten[jiao]).append("角");
        }
        if(fen != 0){
            xiaoSB.append(ten[fen]).append("分");
        }



        return xiaoSB.toString();
    }

    /**
     * 94 记票统计
     */
    private static void voteCount() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            Map<String,Integer> map = new HashMap<>();
            int n =Integer.parseInt(in.nextLine());
            String candidate = in.nextLine();
            String[] candidates = candidate.split(" ");
            for(String can : candidates){
                map.put(can,0);
            }
            int invalid = 0;
            in.nextLine();
            String[] votes = in.nextLine().split(" ");
            for(String vote:votes){
                if(map.containsKey(vote)){
                    map.put(vote,map.get(vote)+1);
                }else{
                    invalid++;
                }
            }
            for(String can: candidates){
                System.out.println(can+" : "+map.get(can));
            }
            System.out.println("Invalid : "+invalid);
        }
    }

    private static void arrayGroup() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            List<Integer> list3 = new ArrayList<>();
            int sum = 0;
            int sum5 = 0;
            int sum3 = 0;
            for (int num : nums) {
                sum += num;
                if (num % 5 == 0) {
                    sum5 += num;
                } else if (num % 3 == 0) {
                    sum3 += num;
                } else {
                    list3.add(num);
                }
            }
            if (sum % 2 != 0) {
                System.out.println(false);
                return;
            }

            sum = sum / 2;
            // 需要组成的和
            int target = sum - sum5;
            // 判断是否可以组合成target
            System.out.println(helper(target, list3));
        }
    }

    private static boolean helper(int target, List<Integer> list) {
        if (list == null|| list.size()==0) {
            return target == 0;
        }
        if (list.contains(target)) {
            return true;
        }
        int size = list.size();
        return helper(target, size > 1 ? list.subList(1, size) : null ) ||
                helper(target - list.get(0), list.subList(1, size));
    }

    /**
     * 92 在字符串中找出连续最长的数字串
     */
    private static void longestNumberString() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int max = 0;
            int left = -1;
            int right = -1;
            for (int i = 0; i < length; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    if (right - left > max) {
                        sb = new StringBuilder();
                        sb.append(str, left + 1, right + 1);
                        max = right - left;
                    } else if (right - left == max) {
                        sb.append(str, left + 1, right + 1);
                    }
                    left = i;
                    right = i;
                } else {
                    right++;
                }
            }
            if (right - left > max) {
                sb = new StringBuilder();
                sb.append(str, left + 1, right + 1);
                max = right - left;
            } else if (right - left == max) {
                sb.append(str, left + 1, right + 1);
            }
            System.out.println(sb.toString() + "," + max);
        }
    }

    /**
     * 91 走方格的方案数
     */
    private static void walkSquare() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] dp = new int[n+2][m+2];
            for(int i=1;i<=n+1;i++){
                dp[i][1] =1;
            }
            for(int i=1;i<=m+1;i++){
                dp[1][i]=1;
            }
            for(int i=2;i<=n+1;i++){
                for(int j=2;j<=m+1;j++){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
            System.out.println(dp[n+1][m+1]);
        }
    }

    private static void validateIP() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String ip = sc.nextLine();
            System.out.println(isIP2(ip) ? "YES" : "NO");
        }
    }

    private static boolean isIP2(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            try {
                int ipInt = Integer.parseInt(ipArr[i]);
                if ((ipInt != 0 && ipArr[i].startsWith("0")) || ipArr[i].startsWith("+") ||
                        ipArr[i].startsWith("-")) {
                    return false;
                }
                if (ipInt < 0 || ipInt > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static void cardTwentyForePoint() {
        Scanner sc = new Scanner(System.in);

        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 1);
        map.put("2", 2);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.contains("joker") || str.contains("JOKER")) {
                System.out.println("ERROR");
                return;
            }
            // 转数字
            String[] card = str.split(" ");
            int[] nums = new int[4];
            int[] visit = new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i] = map.get(card[i]);
            }

            for (int i = 0; i < 4; i++) {
                visit[i] = 1;
                if (dfs(card, nums, visit, nums[i],1,""+card[i])) {
                    return;
                }
                //回溯
                visit[i] = 0;

            }
            System.out.println("NONE");

        }
    }

    private static boolean dfs(String[] card, int[] nums, int[] visit, int sum,int count,String exc) {
        if (sum == 24 && count ==4) {
            System.out.println(exc);
            return true;
        }
        for (int i = 0; i < 4; i++) {
            // 如果当前的数字没有使用过
            if (visit[i] == 0) {
                // 标记为当前数字已经使用
                visit[i] = 1;
                if (dfs(card, nums, visit, sum + nums[i],count+1,exc+"+"+card[i])||
                        dfs(card, nums, visit, sum - nums[i],count+1,exc+"-"+card[i])||
                        dfs(card, nums, visit, sum * nums[i],count+1,exc+"*"+card[i])||
                        dfs(card, nums, visit, sum / nums[i],count+1,exc+"/"+card[i])) {
                    return true;
                }else{
                    //回溯
                    visit[i] = 0;
                }

            }
        }
        return false;

    }

    /**
     * 88 扑克牌大小
     */
    private static void cardOrder() {
        Scanner sc = new Scanner(System.in);

        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("joker", 16);
        map.put("JOKER", 17);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strArr = str.split("-");
            // 判断牌型
            Card card1 = getCard(strArr[0]);
            Card card2 = getCard(strArr[1]);
            if(card1.cardType == card2.cardType){
                if(card1.order>card2.order){
                    System.out.println(strArr[0]);
                }else{
                    System.out.println(strArr[1]);
                }
            }else{ //两个牌型不同，如果是炸的话，炸大，否则输出错误
                if(card1.cardType ==4){
                    System.out.println(strArr[0]);
                }else if(card2.cardType ==4){
                    System.out.println(strArr[1]);
                }else{
                    System.out.println("ERROR");
                }
            }

        }
    }

    private static Card getCard(String str) {
        String[] card = str.split(" ");
        int length = card.length;
        if (length == 1) {
            return new Card(0, map.get(card[0]));
        } else if (length == 2) {
            // 两种情况 王炸和对子
            if ("joker".equals(card[0])) {
                return new Card(4, 16);
            } else {
                return new Card(1, map.get(card[0]));
            }
        } else if (length == 3) {
            return new Card(2, map.get(card[0]));
        } else if (length == 4) {
            return new Card(4, map.get(card[0]));
        } else {
            return new Card(3, map.get(card[0]));
        }
    }


    /**
     * 87 密码强度等级
     */
    private static void validatePasswordStrong() {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNext()) { // 注意 while 处理多个 case

            String password = sc.nextLine();
            boolean haveUpper = false;
            boolean haveLower = false;
            boolean haveNumber = false;
            boolean haveOtherChar = false;
            int[] sizeChr = new int[4];
            char[] pwdArr = password.toCharArray();
            for (char chr : pwdArr) {
                if (Character.isUpperCase(chr)) {
                    haveUpper = true;
                    sizeChr[1] = sizeChr[1] + 1;
                } else if (Character.isLowerCase(chr)) {
                    haveLower = true;
                    sizeChr[2] = sizeChr[2] + 1;
                } else if (Character.isDigit(chr)) {
                    haveNumber = true;
                    sizeChr[0] = sizeChr[0] + 1;
                } else {
                    haveOtherChar = true;
                    sizeChr[3] = sizeChr[3] + 1;
                }
            }
            int result = 0;
            int length = pwdArr.length;
            //长度校验
            if (length <= 4) {
                result += 5;
            } else if (length <= 7) {
                result += 10;
            } else {
                result += 25;
            }

            // 字母校验
            if (haveLower) {
                result += 10;
            }
            if (haveUpper) {
                result += 10;
            }
            //数字校验
            if (sizeChr[0] == 1) {
                result += 10;
            } else if (sizeChr[0] > 1) {
                result  += 20;
            }

            //其他符号教研
            if (sizeChr[3] == 1) {
                result += 10;
            } else if (sizeChr[3] > 1) {
                result  += 25;
            }

            // 奖励
            if (haveOtherChar && haveNumber && haveLower && haveUpper) {
                result += 5;
            } else if ((haveLower || haveUpper) && haveOtherChar && haveNumber) {
                result += 3;
            } else if ((haveLower || haveUpper) && haveNumber) {
                result += 2;
            }
            int score = result / 10;
            switch (score) {
                case 10:
                case 9:
                    System.out.println("VERY_SECURE");
                    break;
                case 8:
                    System.out.println("SECURE");
                    break;
                case 7:
                    System.out.println("VERY_STRONG");
                    break;
                case 6:
                    System.out.println("STRONG");
                    break;
                case 5:
                    System.out.println("AVERAGE");
                    break;
                default:
                    if(result>=25){
                        System.out.println("WEAK");
                    }else if(result>=0){
                        System.out.println("VERY_WEAK");
                    }
            }
        }
    }

    /**
     * 86 求最大连续bit数
     */
    private static void bitCount() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int max =0;
            int oneCount=0;
            while(n!=0){
                if((n%2) == 1){
                    oneCount++;
                    if(oneCount>max){
                        max = oneCount;
                    }
                }else{
                    oneCount=0;
                }
                n = n >>1;
            }
            System.out.println(max);
        }
    }

    /**
     * 85 最长回文子串
     */
    private static void longestPalindromeSubstring() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] strArr = str.toCharArray();
            int length = strArr.length;
            int count = 1;
            for (int i = 0; i < length; i++) {
                // 以i为中心，进行两边扩散
                count = Math.max(count, cal(strArr, count, i - 1, i + 1));

                count = Math.max(count, cal(strArr, count, i, i + 1));
            }
            System.out.println(count);
        }
    }

    private static int cal(char[] strArr, int count, int left, int right) {
        int length = strArr.length;
        while (left >= 0 && right < length) {
            if (strArr[left] == strArr[right]) {
                int len = right - left + 1;
                if (len > count) {
                    count = len;
                }
                left--;
                right++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 84 统计大写字母个数
     */
    private static void upperCaseLetterCount() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strArr = str.toCharArray();
        int count = 0;
        for(char chr : strArr){
            if(Character.isUpperCase(chr)){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 83 二维数组操作
     */
    private static void twoDArrayOperation() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m > 9 || n > 9) {
                System.out.println(-1);
                m = Math.min(m, 9);
                n = Math.min(n, 9);
            } else {
                System.out.println(0);
            }
            // 交换值
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            if (y1 < 0 || y2 < 0 || x1 < 0 || x2 < 0 || x1 > m - 1 || x2 > m - 1 ||
                    y1 > n - 1 || y2 > n - 1) {
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            //插入行
            int insertCol = sc.nextInt();
            if (m == 9|| insertCol<0|| insertCol>=m) {
                System.out.println(-1);
            }else{
                System.out.println(0);
            }
            //插入列
            int insertRow = sc.nextInt();
            if (n == 9|| insertRow<0|| insertRow>=n) {
                System.out.println(-1);
            }else{
                System.out.println(0);
            }
            //查询值
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x<0|| x>=m||y<0||y>=n){
                System.out.println(-1);
            }else{
                System.out.println(0);
            }

        }
    }

    /**
     * 82 将真分数分解为埃及分数
     */
    private static void egyptScore() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String fraction = sc.nextLine();
            String[] nums = fraction.split("/");
            long a = Long.parseLong(nums[0]);
            long b = Long.parseLong(nums[1]);
            long min = a;
            for (long i = min; i > 1; i--) {
                if (a % i == 0 && b % i == 0) {
                    a = a / i;
                    b = b / i;
                }
            }
            List<String> result = new ArrayList<>();
            // a 和 b 没有公约数
            while (a != 1) {
                long r = b % a;
                long q = b / a;
                result.add("1/" + (1 + q));
                a = a - r;
                b = b * (1 + q);
                //分数约分
                long min1 = a;
                for (long i = min1; i > 1; i--) {
                    if (a % i == 0 && b % i == 0) {
                        a = a / i;
                        b = b / i;
                    }
                }
            }
            result.add(a + "/" + b);
            System.out.println(String.join("+", result));
        }
    }

    private static void twoStringPatton() {
        Scanner sc = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] str2Arr = str2.toCharArray();
        for(char chr : str2Arr){
            set.add(chr);
        }

        char[] str1Arr = str1.toCharArray();
        for(char chr: str1Arr){
            if(!set.contains(chr)){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    /**
     * 80 整型数组合并
     */
    private static void mergeTwoArray() {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        while(sc.hasNextInt()){
            int size = sc.nextInt();
            for(int i=0;i<size;i++){
                set.add(sc.nextInt());
            }
        }
        List<Integer> resultList = new ArrayList<>(set);

        Collections.sort(resultList);
        for(int num : resultList){
            System.out.print(num);
        }
        System.out.println();
    }

    /**
     * 77 火车进站
     */
    private static void trainEnterCentor() {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            l.clear(); //静态变量，每次先清空
            int nums = in.nextInt();
            int[] id = new int[nums];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums; i++) {
                id[i] = in.nextInt();
            }
            trainOut(id, 0, stack, "", 0);
            //对结果集排序
            Collections.sort(l);
            for (String str : l) {
                System.out.println(str);
            }
        }
    }

    public static void trainOut(int[] id, int i, Stack<Integer> s, String str,
                                int n) {
        if (n == id.length) {
            l.add(str); //如果所有火车均出栈则将当前结果保存
        }

        if (!s.empty()) { //栈非空时出栈
            int temp = s.pop();
            trainOut(id, i, s, str + temp + " ", n + 1);
            s.push(temp); //恢复现场
        }

        if (i < id.length) {
            s.push(id[i]);
            trainOut(id, i + 1, s, str, n);
            s.pop(); //恢复现场

        }
    }

    /**
     * 76 尼科彻斯定理
     */
    private static void nikochusTheorem() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        double num = Math.pow(m, 3);
        Deque<Integer> deque = new LinkedList<>();
        if (num % 2 == 0) {
            int center = (int)num / m;
            int i = 1;
            while (deque.size() < m) {
                deque.offerFirst(center - i);
                deque.offerLast(center + i);
                i += 2;
            }
        } else {
            int center = (int) num / m;
            deque.offer(center);
            int i = 2;
            while (deque.size() < m) {
                deque.offerFirst(center - i);
                deque.offerLast(center + i);
                i += 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            if(sb.length() ==0){
                sb.append(deque.pollFirst());
            }else{
                sb.append("+").append(deque.pollFirst());
            }
        }
        System.out.println(sb);
    }

    /**
     * 75 公共子串计算
     */
    private static void commonSubString() {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int s1Len = str1.length();
        int s2Len = str2.length();

        int[][] dp = new int[s1Len+1][s2Len+1];

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        int max =0;
        for(int i=0;i<s1Len;i++){
            for(int j=0;j<s2Len;j++){
                if(str1Arr[i] == str2Arr[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = 0;
                }
                max = Math.max(max,dp[i+1][j+1]);
            }
        }
        System.out.println(max);
    }

    /**
     * 74 参数解析
     */
    private static void paramsAnalysis() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        char[] commandArr = command.toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char chr : commandArr) {
            if (chr == '"') {
                if (!stack.isEmpty()) {
                    result.add(sb.toString());
                    sb = new StringBuilder();
                    stack.pop();
                } else {
                    stack.push(chr);
                }
            } else if (chr == ' ') {
                if (stack.isEmpty()) {
                    if (sb.length() != 0) {
                        result.add(sb.toString());
                        sb = new StringBuilder();
                    }

                } else {
                    sb.append(chr);
                }
            } else {
                sb.append(chr);
            }
        }
        if (sb.length() != 0) {
            result.add(sb.toString());
        }
        System.out.println(result.size());
        for (String line : result) {
            System.out.println(line);
        }
    }

    /**
     * 73 计算日期到天数转换
     */
    private static void getDaysByDate() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int mouth = sc.nextInt();
        int day = sc.nextInt();
        int result = 0;
        int[] mouthDay = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<mouth-1;i++){
            result +=mouthDay[i];
        }
        if(mouth>2){
            //判断是否是闰年
            if(year%100 ==0){
                if(year%400 ==0){
                    result++;
                }
            }else{
                if(year%4 ==0){
                    result++;
                }
            }

        }
        result+=day;
        System.out.println(result);
    }

    /**
     * 72 百钱买百鸡问题
     */
    private static void hundredHen() {
        int cockNum = 100 / 5;
        for (int i = 0; i <= cockNum; i++) {
            //计算买过公鸡后最多可以买的母鸡数
            int rest = 100 - 5 * i;
            int henNum = rest / 3;
            for (int j = 0; j <= henNum; j++) {
                //计算购买过母鸡后剩余的钱
                int finalRest = rest - j * 3;
                //剩余的钱全部买小鸡
                int chickNum = finalRest * 3;
                if (i + j + chickNum == 100) {
                    System.out.println(i + " " + j + " " + chickNum);
                } else if (i + j + chickNum < 100) {
                    break;
                }
            }
        }
    }

    /**
     * 71 字符串通配符
     */
    private static void stringPatton() {
        Scanner sc = new Scanner(System.in);
        String patton = sc.nextLine().toLowerCase();
        String str = sc.nextLine().toLowerCase();
        char[] pattonArr = patton.toCharArray();
        char[] strArr = str.toCharArray();
        int pLen = pattonArr.length;
        int sLen = strArr.length;
        //动态规划
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        for(int i=1;i<=pLen;i++){
            if(pattonArr[i-1] == '*'){
                dp[i][0] = true;
            }else{
                break;
            }
        }
        for(int i=1;i<=pLen;i++){
            for(int j=1;j<=sLen;j++){
                if(pattonArr[i-1] == strArr[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(pattonArr[i-1] =='?' && Character.isLetterOrDigit(strArr[j-1])){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattonArr[i-1] == '*' && Character.isLetterOrDigit(strArr[j-1])){
                    dp[i][j]=dp[i-1][j]|dp[i][j-1]|dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[pLen][sLen]);
    }

    /**
     * 70 矩阵乘法计算量估算
     */
    private static void matrixMultiplicationCount() {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String[] nums = new String[size];

        int result =0;
        sc.nextLine();
        for(int i=0;i<size;i++){
            nums[i] = sc.nextLine();
        }
        String str = sc.nextLine();
        char[] strArr = str.toCharArray();
        for(char chr:strArr){
            if(chr=='('){
                stack.push(chr+"");
            }else if(chr == ')'){
                String num1 = stack.pop();
                String num2 = stack.pop();
                String[] num2XY = num2.split(" ");
                String[] num1XY = num1.split(" ");
                int x = Integer.parseInt(num2XY[0]);
                int y = Integer.parseInt(num2XY[1]);
                int z = Integer.parseInt(num1XY[1]);
                result +=(x*y*z);
                stack.pop();
                stack.push(x+" "+z);
            }else{
                // 如果是字母
                int index = chr-'A';
                stack.push(nums[index]);
            }
        }
        System.out.println(result);
    }


    /**
     * 69 矩阵乘法
     */
    private static void matrixMultiplication() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] result = new int[x][z];
            int[][] a = new int[x][y];
            int[][] b = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++) {
                        result[i][j] += (a[i][k] * b[k][j]);
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.printf("%d ", result[i][j]);
                }
                System.out.println();
            }
        }
    }

    /**
     * 68 成绩排序
     */
    private static void scoreSort() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int order = sc.nextInt();
        int flag = 1;
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String info = sc.nextLine();
            String[] infoArr = info.split(" ");
            students.add(new Student(infoArr[0], Integer.parseInt(infoArr[1]), i));
        }
        if (order == 0) {
            flag = -1;
        }
        if (flag == 1) {
            students.sort((Student s1, Student s2) -> {
                if (s1.score != s2.score) {
                    return (s1.score - s2.score);
                } else {
                    return (s1.index - s2.index);
                }
            });
        } else {
            students.sort((Student s1, Student s2) -> {
                if (s1.score != s2.score) {

                    return (s2.score - s1.score);
                } else {
                    return (s1.index - s2.index);
                }
            });
        }

        for (Student stu : students) {
            System.out.println(stu.name + " " + stu.score);
        }
    }

    /**
     * 67 24点游戏算法
     */
    private static void twentyFourPoint() {
        Scanner sc = new Scanner(System.in);
        int[] numArr = new int[4];
        // 数字是否使用标志位
        int[] visit = new int[4];
        for (int i = 0; i < 4; i++) {
            numArr[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++){
            visit[i] = 1;
            if(dfs(numArr,visit,numArr[i])){
                System.out.println(true);
                return;
            }
            visit[i] = 0;
        }
        System.out.println(false);
    }

    private static boolean dfs(int[] nums, int[] visit, int temp) {
        if (temp == 24) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            // 如果当前数字没有使用
            if (visit[i] == 0) {
                visit[i] = 1;
                if (dfs(nums, visit, temp + nums[i])
                        || dfs(nums, visit, temp - nums[i])
                        || dfs(nums, visit, temp * nums[i])
                        || (temp % nums[i] == 0 && dfs(nums, visit, temp / nums[i]))) {
                    return true;
                } else {
                    //回溯，不能
                    visit[i] = 0;
                }
            }
        }
        return false;
    }

    /**
     * 66 配置文件恢复
     */
    private static void configReset() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> command = new HashMap<>();
        command.put("reset", "reset what");
        command.put("reset board", "board fault");
        command.put("board add", "where to add");
        command.put("board delete", "no board at all");
        command.put("reboot backplane", "impossible");
        command.put("backplane abort", "install first");
        while (sc.hasNextLine()) {
            String commandLine = sc.nextLine();
            String[] commandArr = commandLine.split(" ");
            int length = commandArr.length;
            Set<String> keys = command.keySet();
            String execResult = "";
            for (String key : keys) {
                //记录执行结果

                String[] commandKey = key.split(" ");
                if (commandKey.length == length) {
                    int count = 0;
                    for (int i = 0; i < length; i++) {
                        if (commandKey[i].startsWith(commandArr[i])) {
                            count++;
                        }
                    }
                    if (count == length) {
                        if ("".equals(execResult)) {
                            execResult = command.get(key);
                        } else {
                            execResult = "unknown command";
                        }
                    }
                }
            }
            System.out.println("".equals(execResult)?"unknown command":execResult);
        }
    }

    /**
     * 65 查找两个字符串a,b中的最长公共子串
     */
    private static void longestCommonSubString() {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int maxLength =0;
        String subString = "";
        int minLen = Math.min(str1.length(), str2.length());
        String minLenStr = str1.length()>str2.length()?str2:str1;
        String maxLenStr = str1.length()<str2.length()?str2:str1;
        for(int i=0;i<minLen;i++){
            for(int j=i+1;j<=minLen;j++){
                String substr = minLenStr.substring(i,j);
                if(maxLenStr.contains(substr)){
                    if(maxLength<substr.length()){
                        maxLength= substr.length();
                        subString= substr;
                    }
                }
            }
        }
        System.out.println(subString);
    }

    /**
     * 64 MP3光标位置
     */
    private static void Mp3CursorPosition() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String opt = sc.nextLine();
        int[] song = new int[size];
        for(int i=1;i<=size;i++){
            song[i-1] = i;
        }
        int start = 0;
        int end = Math.min(start + 3, size - 1);
        // 初始化页数
        // 当前选中的歌曲数
        int index =0;
        char[] optArr = opt.toCharArray();
        for(char optchr:optArr){
            //向上翻页
            if(optchr == 'U'){
                //判断光标是否是第一首音乐
                if(index == 0){
                    index = size-1;
                    end = size-1;
                    start = Math.max(end - 3, 0);
                }else{
                    index--;
                    //需要翻页
                    if(index<start){
                        start = index;
                        end = end-1;
                    }
                }
                //向下翻页
            }else{
                //如果是最后一首音乐
                if(index == size-1){
                    index =0;
                    start = 0;
                    end = Math.min(start + 3, size - 1);
                }else{
                    index++;
                    //需要翻页
                    if(index>end){
                        end = index;
                        start++;
                    }
                }
            }
        }
        for(int i = start;i<=end;i++){
            System.out.printf("%d ",song[i]);
        }
        System.out.println();
        System.out.println(song[index]);
    }

    private static void DNAOrder() {
        Scanner sc = new Scanner(System.in);
        String geneStr = sc.nextLine();
        int length = geneStr.length();
        int size = sc.nextInt();
        int count = 0;
        for(int i=0;i<size;i++){
            if(geneStr.charAt(i) == 'C'|| geneStr.charAt(i) == 'G'){
                count++;
            }
        }
        String result = geneStr.substring(0,size);
        int max =count;
        int left = 0;
        int right = left+size;
        while(right<length){
            if(geneStr.charAt(left) == 'C'|| geneStr.charAt(left) == 'G'){
                count--;
            }
            if(geneStr.charAt(right) == 'C'|| geneStr.charAt(right) == 'G'){
                count++;
            }
            if(count>max){
                max = count;
                result = geneStr.substring(left+1,right+1);
            }
            left++;
            right++;
        }
        System.out.println(result);
    }

    /**
     * 62 查找输入整数二进制中1的个数
     */
    private static void findOneCount() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long number = sc.nextLong();
            int count = 0;
            while (number != 0) {
                if ((number & 1) == 1) {
                    count++;
                }
                number = number >> 1;
            }
            System.out.println(count);
        }
    }

    /**
     * 61 放苹果
     */
    private static void putApple() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] = dp[i][j-1] + dp[i-j][j];
        Arrays.fill(dp[0],1);
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j>i){
                    // 如果苹果的数小于盘子的数，那么必然存在空盘子，可以把新增的那个盘子作为空盘子
                    dp[i][j] = dp[i][j-1];
                }else{
                    // 如果苹果的数大于盘子的数，则存在两种情况，一种是所有的盘子都有苹果，一种是存在空盘子
                    // 如果存在空盘子，那么新增的那个作为空盘子
                    // 如果每个盘子都存在苹果，那么每个盘子先放一个苹果，然后剩余的苹果随机放到所有的盘子中
                    dp[i][j] = dp[i][j-1]+dp[i-j][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }

    /**
     * 60 查找组成一个偶数最接近的两个素数
     */
    private static void getClosedPrime() {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long first =0;
        long second =number;
        for(int i =2;i*2<=number;i++){
            if(isZhiShu(i) && isZhiShu(number-i)){
                first = i;
                second = number-i;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    private static boolean isZhiShu(long number){
        for(int i=2;i*i<=number;i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 59 找出字符串中第一个只出现一次的字符
     */
    private static void getFirstSingleChar() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //设置信号量
            int signal = 0;
            //读取输入内容
            String str = sc.nextLine();
            //遍历输入内容
            for(int i = 0; i < str.length(); i++){
                //判断每个字符是否出现第二次，如果存在，设置信号量signal为1；
                if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                    System.out.print(str.charAt(i));
                    signal = 1;
                    break;
                }
            }
            //如果信号量为零，证明不存在重复字符
            if(signal == 0){
                System.out.println(-1);
            }
            //每读取一行输出一个回车
            System.out.println();
        }
    }

    /**
     * 58 输入n个整数，输出其中最小的k个
     */
    private static void getKLessNumber() {
        Scanner sc = new Scanner(System.in);
        String mn = sc.nextLine();
        String[] arr = mn.split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        int[] arrNum = new int[m];
        for(int i=0;i<m;i++){
            arrNum[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m-i-1;j++){
                if(arrNum[j]<arrNum[j+1]){
                    int temp = arrNum[j];
                    arrNum[j] = arrNum[j+1];
                    arrNum[j+1] = temp;
                }
            }
            System.out.printf("%d ",arrNum[m-i-1]);
        }
    }

    private static void bigNumberAdd() {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder num1sb = new StringBuilder(num1);
        StringBuilder num2sb = new StringBuilder(num2);
        num1 = num1sb.reverse().toString();
        num2 = num2sb.reverse().toString();
        int max = Math.max(length1, length2);
        int carry =0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<max;i++){
            char nu1 = i<length1?num1.charAt(i):'0';
            char nu2 = i<length2?num2.charAt(i):'0';
            int number1 = Integer.parseInt(nu1+"");
            int number2 = Integer.parseInt(nu2+"");
            result.append((number1+number2+carry)%10);
            carry = (number1+number2+carry)/10;

        }
        if(carry == 1){
            result.append("1");
        }
        System.out.println(result.reverse().toString());
    }

    /**
     * 56 完全数计算
     */
    private static void completeNum() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = 0;
        for(int i=1;i<=number;i++){
            int sum =0;
            for(int k =1;k<i;k++){
                if(i%k ==0){
                    sum +=k;
                }
            }
            if(i == sum){
                result++;
            }
        }
        System.out.println(result);
    }

    /**
     * 55 挑7
     */
    private static void serven() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result =0;
        for(int i=1;i<=num;i++){
            if(i%7 ==0){
                result++;
            }else{
                if(String.valueOf(i).contains("7")){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * 54 表达式求值
     */
    private static void getExpressionValue() {
        Scanner sc = new Scanner(System.in);
        String evel = sc.nextLine();
        char[] evelArr = evel.toCharArray();
        Stack<Character> opt = new Stack<>();
        Stack<Integer> num = new Stack<>();

        char lastChar = ' ';
        int number = 0;
        int flag = 1;
        boolean isDigit = false;
        for (char chr : evelArr) {
            // 如果是数字字符，转换成数字
            if (Character.isDigit(chr)) {
                number = number * 10 + Integer.parseInt(chr + "");
                isDigit = true;
            } else {

                if (chr == '-' && !isDigit && lastChar != ')') {
                    flag = -1;
                    continue;
                }
                lastChar = chr;

                if (isDigit) {
                    number *= flag;
                    num.push(number);
                    flag = 1;
                    number = 0;
                    isDigit = false;
                }
                if (chr == '(') {
                    opt.push(chr);
                } else if (chr == ')') {
                    while (!(opt.peek() == '(')) {
                        int num1 = num.pop();
                        int num2 = num.pop();
                        char option = opt.pop();
                        num.push(cal(num1, num2, option));
                    }
                    //左括号出栈
                    opt.pop();

                } else {
                    while (!opt.isEmpty() && getOrder(chr) <= getOrder(opt.peek())) {
                        int num1 = num.pop();
                        int num2 = num.pop();
                        char option = opt.pop();
                        num.push(cal(num1, num2, option));
                    }
                    opt.push(chr);

                }

            }

        }
        if (isDigit) {
            num.push(number * flag);
        }
        while (!opt.isEmpty()) {
            int num1 = num.pop();
            int num2 = num.pop();
            char option = opt.pop();
            num.push(cal(num1, num2, option));
        }
        System.out.println(num.pop());
    }

    /**
     * 53 杨辉三角的变形
     */
    private static void yanghuiTriangle() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
            }else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
            }else if(num % 4 == 0){
                System.out.println(3);
            }else if(num % 4 == 2){
                System.out.println(4);
            }
        }
    }

    /**
     * 52 计算字符串的编辑距离
     */
    private static void editDistance() {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        int m = word1.length();
        int n = word2.length();
        // 表示A的前i个字符和B的前j个字符的编辑距离
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[m][n]);
    }

    /**
     * 51 输出单向链表中倒数第k个结点
     */
    private static void getKthFromLinkedList() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int size = sc.nextInt();
            ListNode root = new ListNode();
            root.m_nkey = sc.nextInt();
            root.m_pNext = null;
            ListNode start = root;
            for (int i = 1; i < size; i++) {
                ListNode node = new ListNode();
                node.m_nkey = sc.nextInt();
                node.m_pNext = null;
                start.m_pNext = node;
                start = start.m_pNext;
            }
            int k = sc.nextInt();


            ListNode startNode = root;
            ListNode endNode = root;

            for (int i = 0; i < k; i++) {
                endNode = endNode.m_pNext;
            }
            while (endNode != null) {
                startNode = startNode.m_pNext;
                endNode = endNode.m_pNext;
            }

            System.out.println(startNode.m_nkey);
        }
    }

    /**
     * 50 四则运算
     */
    private static void quaternionOperation() {
        Scanner sc = new Scanner(System.in);

        String exp = sc.nextLine();
        exp = exp.replaceAll("\\[", "(");
        exp = exp.replaceAll("]", ")");
        exp = exp.replaceAll("\\{", "(");
        exp = exp.replaceAll("}", ")");
        System.out.println(process(exp));
    }

    /**
     * 四则运算
     */
    private static int process(String exp) {

        // 数字栈
        Stack<Integer> numStack = new Stack<>();
        // 符号栈
        Stack<Character> opeStack = new Stack<>();

        char[] chs = exp.toCharArray();

        // 当前处理的是否为数字
        boolean isDigit = false;
        // 正负数标记
        int positiveFlag = 1;
        // 当前正在读取的数字
        int num = 0;
        // 记录当前字符的上一个字符
        char pre = '0';
        for (char c : chs) {

            // 如果当前字符是数字字符，则将其处理为数字，若有多个连续的数字字符，需要处理为一个整数
            if (Character.isDigit(c)) {
                num = num * 10 + Integer.parseInt(c + "");
                // 标记当前处理到了数字字符
                isDigit = true;
            } else {

                // 如果当前字符为减号，且上一个字符不是右括号或者数字字符，则当前字符一定表示负数符号
                if ('-' == c && !isDigit && pre != ')') {
                    positiveFlag = -1;
                    continue;
                }

                // 将当前字符记录
                pre = c;

                // 如果当前字符之前的为数字字符，则将之前处理的数字入数字栈
                if (isDigit) {
                    // 通过与positiveFlag相乘得到正负数结果
                    numStack.push(num * positiveFlag);
                    // 将相关标志重置
                    num = 0;
                    positiveFlag = 1;
                    isDigit = false;
                }

                // 如果当前字符为左括号字符，则直接入栈
                if (c == '(') {
                    opeStack.push(c);
                } else if (c == ')') {
                    // // 碰到右括号，符号栈不断出栈，并计算括号里面的表达式
                    while (!(opeStack.peek() ==  '(')) {
                        int r = cal(numStack.pop(), numStack.pop(), opeStack.pop());
                        // 将计算结果入数字栈
                        numStack.push(r);
                    }
                    // 将与当前右括号配对的左括号出栈
                    opeStack.pop();
                } else {
                    // 如果符号栈不为空，且符号栈顶端的符号优先级比当前符号高，符号栈不断出栈，计算结果并入数字栈
                    while (!opeStack.isEmpty() && (getOrder(opeStack.peek()) >= getOrder(c))) {
                        int r = cal(numStack.pop(), numStack.pop(), opeStack.pop());
                        numStack.push(r);
                    }

                    opeStack.push(c);
                }
            }
        }

        // 如果最后一个字符为数字字符，将其压入数字栈
        if (isDigit) {
            numStack.push(num * positiveFlag);
        }

        // 如果操作栈中还有符号，符号栈不断出栈并计算结果
        while (!opeStack.isEmpty()) {
            int r = cal(numStack.pop(), numStack.pop(), opeStack.pop());
            numStack.push(r);
        }

        // 最后数字栈中剩下的就是计算结果
        return numStack.pop();
    }

    /**
     * 判断运算符的优先级，优先级越高值越大
     * @param c 运算符
     * @return 优先级
     */
    private static int getOrder(char c) {

        if ('+' == c || '-' == c) {
            return 1;
        }
        if ('/' == c || '*' == c) {
            return 2;
        }

        return 0;
    }

    private static int cal(int right, int left, char c) {

        if ('+' == c) {
            return left + right;
        } else if ('-' == c) {
            return left - right;
        } else if ('*' == c) {
            return left * right;
        } else if ('/' == c) {
            return left / right;
        }

        return 0;
    }

    /**
     * 48 从单向链表中删除指定值的节点
     */
    private static void deleteNodeFromLinkedList() {
        List<Integer> link = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int startNode = sc.nextInt();
        link.add(startNode);
        for (int i = 0; i < count-1; i++) {
            int end = sc.nextInt();
            int start = sc.nextInt();
            int index = link.indexOf(start);
            link.add(index + 1, end);
        }
        int deleteNode = sc.nextInt();

        link.remove((Integer) deleteNode);
        for (int node : link) {
            System.out.print(node+" ");
        }
    }

    /**
     * 46 截取字符串
     */
    private static void splitString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res;
        int len;
        while ((res = br.readLine()) != null) {
            len = Integer.parseInt(br.readLine());
            System.out.println(res.substring(0, len));
        }
    }


    /**
     * 45 名字的漂亮度
     */
    private static void nameBeautiful() throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(sc.readLine());
        int[] countArr;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            countArr = new int[26];
            String str = sc.readLine();
            int length = str.length();
            for (int j = 0; j < length; j++) {
                countArr[(str.charAt(j) - 'a')]++;
            }
            Arrays.sort(countArr);
            int sum = 0;
            for (int j = 25; j >= 0; j--) {
                sum += countArr[j] * (j + 1);
            }
            result[i] = sum;
        }

        for(int sum: result){
            System.out.println(sum);
        }
    }

    /**
     * 44 Sudoku
     */
    private static void sodoku() {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = in.nextInt();
            }
        }
        solveSudoku(board);
        //输出二维矩阵
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j] + " ");
            }
            //换行，每一行的最后一个数字
            System.out.println(board[i][8]);
        }
    }

    private static boolean solveSudoku(int[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一***定下来之后，递归遍历这个位置放9个数字的可能性！」
        // 遍历行
        for (int i = 0; i < 9; i++){
            // 遍历列
            for (int j = 0; j < 9; j++){
                // 跳过原始数字
                if (board[i][j] != 0){ 
                    continue;
                }
                // (i, j) 这个位置放k是否合适
                for (int k = 1; k <= 9; k++){ 
                    if (isValidSudoku(i, j, k, board)){
                        //将k放在（i，j）
                        board[i][j] = k;
                        // 如果找到合适一组立刻返回
                        if (solveSudoku(board)){ 
                            return true;
                        }
                        //回溯
                        board[i][j] = 0;
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一***定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     *     同行是否重复
     *     同列是否重复
     *     9宫格里是否重复
     */
    private static boolean isValidSudoku(int row, int col, int val, int[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 43 迷宫问题
     */
    private static void mazeProblem() {
        //移动方向
        int[][] dict = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] migong = new int[m][n];
        int[][] userFlag = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                migong[i][j] = sc.nextInt();
            }
        }
        Deque<List<Integer>> stack = new ArrayDeque<>();

        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(0);
        stack.offer(start);
        userFlag[0][0] = 1;
        while (true) {
            List<Integer> xy = stack.peekLast();
            boolean isDeadWay = true;
            boolean isOut = false;
            for (int i = 0; i < 4; i++) {
                assert xy != null;
                int newX = xy.get(0) + dict[i][0];
                int newY = xy.get(1) + dict[i][1];
                //出界
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                // 如果不是墙壁，而且当前的道路没有走过
                if (migong[newX][newY] == 0 && userFlag[newX][newY] == 0) {
                    isDeadWay = false;
                    // 如果找到了出口
                    if (newX == m - 1 && newY == n - 1) {
                        List<Integer> end = new ArrayList<>();
                        end.add(newX);
                        end.add(newY);
                        stack.offer(end);
                        isOut = true;
                        break;
                    }
                    List<Integer> newXY = new ArrayList<>();
                    newXY.add(newX);
                    newXY.add(newY);
                    stack.offer(newXY);
                    userFlag[newX][newY] = 1;
                    break;
                }
            }
            //如果当前的路是一条死路
            if (isDeadWay) {
                stack.pollLast();
            }
            //如果走出来的话
            if(isOut){
                break;
            }

        }

        while (!stack.isEmpty()) {
            List<Integer> xy1 = stack.pollFirst();
            System.out.println("(" + xy1.get(0) + "," + xy1.get(1) + ")");
        }
    }

    /**
     * HJ42 学英语
     */
    private static void learnEnglish() {
        Scanner sc = new Scanner(System.in);

        List<String> result = new ArrayList<>();

        long num = sc.nextLong();
        int power = 0;
        while (num != 0) {
            int sum = 0;
            int pow = 1;
            for (int i = 0; num != 0 && i < 3; i++) {
                sum += (num % 10) * pow;
                pow *= 10;
                num /= 10;
            }
            List<String> res = getEnglishNumber(sum);

            if (power != 0) {
                res.add(POWER[power]);
            }
            result.addAll(0,res);
            power++;
        }
        System.out.println(String.join(" ",result));
    }

    /**
     * 数字转英文
     * @param num 数字
     * @return 英文
     */
    private static List<String> getEnglishNumber(int num) {
        List<String> res = new ArrayList<>();
        if (num == 0) {
            return res;
        }
        //大于100
        if (num >= 100) {
            int hundred = num / 100;
            res.add(NUMS[hundred]);
            res.add("hundred");
            //判断十位和个位
            int doubleB = num % 100;
            if (doubleB > 0 && doubleB < 20) {
                res.add("and");
                res.add(NUMS[doubleB]);
            } else if (doubleB >= 20) {
                int shi = doubleB / 10;
                res.add("and");
                res.add(NUMSSHI[shi]);
                int ge = doubleB % 10;
                if (ge != 0) {
                    res.add(NUMS[ge]);
                }
            }
        } else {//小于100
            //判断十位和个位
            int doubleB = num % 100;
            if (doubleB > 0 && doubleB < 20) {
                res.add(NUMS[doubleB]);
            } else if (doubleB >= 20) {
                int shi = doubleB / 10;
                res.add(NUMSSHI[shi]);
                int ge = doubleB % 10;
                if (ge != 0) {
                    res.add(NUMS[ge]);
                }
            }
        }

        return res;
    }

    /**
     * 41 称砝码
     */
    private static void weighingWeight() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] m = new int[size];
        int[] x = new int[size];
        for(int i=0;i<size;i++){
            m[i] = sc.nextInt();
        }
        for(int i=0;i<size;i++){
            x[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int sum = Arrays.stream(x).sum();
        int[] mx = new int[sum];
        int index =0;
        for(int i =0;i<size;i++){
            for(int j=0;j<x[i];j++){
                mx[index++] = m[i];
            }
        }
        for(int i =0;i<sum;i++){
            List<Integer> newM = new ArrayList<>();
            for(int m1:set){
                if(!set.contains(m1+mx[i])){
                    newM.add(m1+mx[i]);
                }
            }
            set.addAll(newM);
        }
        System.out.println(set.size());
    }

    /**
     * 40 统计字符
     */
    private static void countChar() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int[] result = new int[4];
        for(int i=0;i<length;i++){
            char chr = str.charAt(i);
            if(Character.isLetter(chr)){
                result[0]++;
            }else if(Character.isDigit(chr)){
                result[2]++;
            }else if(Character.isSpaceChar(chr)){
                result[1]++;
            }else {
                result[3]++;
            }
        }
        for(int i=0;i<4;i++){
            System.out.println(result[i]);
        }
    }

    /**
     * 39 判断两个IP是否属于同一子网
     */
    private static void isInSubnet() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            String mask = sc.nextLine();
            String ip1 = sc.nextLine();
            String ip2 = sc.nextLine();
            if (isMask(mask) && isIP(ip1) && isIP(ip2)) {
                //判断是否是同一个子网
                int i;
                for (i = 0; i < 4; i++) {
                    String[] maskArr = mask.split("\\.");
                    String[] ip1Arr = ip1.split("\\.");
                    String[] ip2Arr = ip2.split("\\.");
                    int maskNum = Integer.parseInt(maskArr[i]);
                    int ip1Num = Integer.parseInt(ip1Arr[i]);
                    int ip2Num = Integer.parseInt(ip2Arr[i]);
                    if ((ip1Num & maskNum) != (ip2Num & maskNum)) {
                        System.out.println(2);
                        break;
                    }
                }
                if (i == 4) {
                    System.out.println(0);
                }

            } else {
                System.out.println(1);
            }
        }
    }

    private static boolean isIP(String str) {
        String[] ipArr = str.split("\\.");
        if (ipArr.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            try {
                int ip = Integer.parseInt(ipArr[i]);
                if (ip > 255 || ip < 0) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    /**
     * 38 求小球落地5次后所经历的路程和第5次反弹的高度
     */
    private static void pelletHeight() {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        float sum =height;
        float lastHeight =height;
        for(int i=0;i<4;i++){
            sum += lastHeight;
            lastHeight /=2;
        }
        System.out.printf("%.6f\n",sum);
        System.out.printf("%.6f\n",lastHeight/2);
    }

    /**
     * 37 统计每个月兔子的总数
     */
    private static void rabbitNum() {
        Scanner  sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getRabbitNum(num));
    }

    private static int getRabbitNum(int mount){
        if(mount <=2){
            return 1;
        }
        return getRabbitNum(mount-1)+getRabbitNum(mount-2);
    }
    /**
     * 36 字符串加密
     */
    private static void stringEncode() {
        Scanner sc = new Scanner(System.in);
        String passwordKey = sc.nextLine();
        String decodeStr = sc.nextLine();

        Set<Character> set = new HashSet<>();
        char[] newChar = new char[26];
        passwordKey = passwordKey.toLowerCase();
        char[] keyArr = passwordKey.toCharArray();
        int index = 0;
        for (char chr : keyArr) {
            if (set.contains(chr)) {
                continue;
            }
            set.add(chr);
            newChar[index++] = chr;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (set.contains((char)i)) {
                continue;
            }
            set.add((char)i);
            newChar[index++] = (char)i;
        }
        int length = decodeStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char chr = decodeStr.charAt(i);
            if (Character.isLowerCase(chr)) {
                sb.append(newChar[chr - 'a']);
            } else if (Character.isUpperCase(chr)) {
                chr = Character.toLowerCase(chr);
                sb.append(newChar[chr - 'a']);
            } else {
                sb.append(chr);
            }
        }
        System.out.println(sb);
    }

    /**
     * 35 蛇形矩阵
     */
    private static void serpentineMatrix() {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        List<List<String>> listArr = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            listArr.add(new ArrayList<>());
        }


        int count = 1;
        for (int i = 1; i <= col; i++) {
            for (int j = i; j >= 1; j--) {
                listArr.get(j - 1).add(count + "");
                count++;
            }
        }
        for (int i = 0; i < col; i++) {
            System.out.println(String.join(" ", listArr.get(i)));
        }
    }

    /**
     * 34 图片整理
     */
    private static void picHandle() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        System.out.println(new String(strArr));
    }

    /**
     * 33 整数与IP地址间的转换
     */
    private static void num2ip() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            if(s.contains(".")){
                System.out.println(ip2num(s));
            }else{
                System.out.println(num2ip(Long.parseLong(s)));
            }
        }
    }

    /**
     * 32 密码截取
     */
    private static void passwordSplit() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int result =0;
        for(int i=0;i<length;i++){
            for(int j=i;j<=length;j++){
                if(result<j-i && isHws(str.substring(i,j))){
                    result = j-i;
                }
            }
        }
        System.out.println(result);
    }

    /**
     * 31 单词倒排
     */
    private static void wordAsc() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<String> stack = new Stack<>();
        char[] strArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char chr : strArr) {
            if (!Character.isLetter(chr)) {
                if (sb.length() != 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(chr);
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }


        int length = stack.size();
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                System.out.print(stack.pop() + " ");
            } else {
                System.out.print(stack.pop());
            }
        }
    }

    /**
     * 30 字符串合并处理
     */
    private static void stringMerge() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Character> oddChars = new ArrayList<>();
        List<Character> evenChars = new ArrayList<>();
        str = str.replace(" ", "");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenChars.add(str.charAt(i));
            } else {
                oddChars.add(str.charAt(i));
            }
        }
        Collections.sort(oddChars);
        Collections.sort(evenChars);
        int evenIndex =0;
        int oddIndex =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(i%2==0){
                sb.append(evenChars.get(evenIndex++));
            }else{
                sb.append(oddChars.get(oddIndex++));
            }
        }
        str = sb.toString();
        Map<Character,Integer> map = new HashMap<>(16);
        fillMap(map);
        StringBuilder result = new StringBuilder();
        for(int i =0;i<length;i++){
            char chr = str.charAt(i);
            if(Character.isDigit(chr)||('a'<=chr&&chr<='f')||('A'<=chr&&chr<='F')){
                chr = Character.toUpperCase(chr);
                int value = map.get(chr);
                StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(value));
                //如果长度小于4
                int binaryStringLen = binaryString.length();
                if(binaryStringLen<4){
                    for(int j=0;j<4-binaryStringLen;j++){
                        binaryString.insert(0, "0");
                    }
                }
                StringBuilder revertString = new StringBuilder(binaryString.toString());
                binaryString = new StringBuilder(revertString.reverse().toString());
                int pow =1;
                int sum =0;
                for(int k=3;k>=0;k--){
                    int num = Integer.parseInt(binaryString.charAt(k)+"");
                    sum +=num*pow;
                    pow *=2;
                }
                String hexString = Integer.toHexString(sum);
                hexString = hexString.toUpperCase();
                result.append(hexString);
            }else{
                result.append(chr);
            }
        }
        System.out.println(result);
    }

    private static void fillMap(Map<Character, Integer> map) {
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
    }

    /**
     * 29 字符串加解密
     */
    private static void stringEncodeAndDecode() {
        Scanner sc = new Scanner(System.in);
        String needEncodeStr = sc.nextLine();
        String needDecodeStr = sc.nextLine();

        //加密字符串
        char[] needEncodeStrArr = needEncodeStr.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        for(char chr : needEncodeStrArr){
            if(Character.isUpperCase(chr)){
                if(chr == 'Z'){
                    sb1.append("a");
                }else{
                    sb1.append(Character.toLowerCase((char)(chr+1)));
                }
            }else if(Character.isLowerCase(chr)){
                if(chr == 'z'){
                    sb1.append("A");
                }else{
                    sb1.append(Character.toUpperCase((char)(chr+1)));
                }
            }else if(Character.isDigit(chr)){
                int num = Integer.parseInt(chr+"");
                sb1.append((num + 1) % 10);
            }else{
                sb1.append(chr);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        char[] needDecodeStrArr = needDecodeStr.toCharArray();
        for(char chr : needDecodeStrArr){
            if(Character.isUpperCase(chr)){
                chr = Character.toLowerCase(chr);
                if(chr == 'a'){
                    sb2.append("z");
                }else{
                    sb2.append((char)(chr-1));
                }
            }else if(Character.isLowerCase(chr)){
                chr = Character.toUpperCase(chr);
                if(chr == 'A'){
                    sb2.append("Z");
                }else{
                    sb2.append((char)(chr-1));
                }
            }else if(Character.isDigit(chr)){
                int num = Integer.parseInt(chr+"");
                if(num ==0){
                    sb2.append(9);
                }else{
                    sb2.append((num-1)%10);
                }
            }else{
                sb2.append(chr);
            }
        }
        System.out.println(sb1);
        System.out.println(sb2);
    }

    private static void primeCp() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] tempArray = new int[n];
            for(int i = 0; i < n; i++){
                tempArray[i] = scan.nextInt();
            }
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if((tempArray[i] & 1) != 1) {
                    evens.add(tempArray[i]);
                }else {
                    odds.add(tempArray[i]);
                }
            }
            //下面开始才是重头戏
            //用于标记那个奇数匹配了偶数,直接记录奇数的值，而不是奇数在奇数数组中的下标
            int[] evensMatch =new int[evens.size()];
            int result = 0;
            //遍历奇数去匹配偶数
            for (Integer odd : odds) {
                //每一步重新创建，也就是相当于清空
                //used数组用于标记某个偶数位置是否
                int[] used = new int[evens.size()];
                //这里采用了匈牙利算法，先到先得
                if (find(odd, evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    /**
     * 27 查找兄弟单词
     */
    private static void findBrotherWord() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");

        int count = Integer.parseInt(strArr[0]);

        String[] words = new String[count];
        if (count >= 0) {
            System.arraycopy(strArr, 1, words, 0, count);
        }
        String self = strArr[count + 1];
        int selfLen = self.length();
        Map<Character, Integer> selfMap = new HashMap<>();
        for (int i = 0; i < selfLen; i++) {
            selfMap.put(self.charAt(i), selfMap.getOrDefault(self.charAt(i), 0) + 1);
        }

        int k = Integer.parseInt(strArr[count + 2]);
        int proCount = 0;
        String result = "";
        for (String word : words) {
            if (word.length() != selfLen || word.equals(self)) {
                continue;
            }
            if (mapEquals(selfMap, word)) {
                proCount++;
            }
            if (proCount == k) {
                result = word;
            }
        }
        System.out.println(proCount);
        if (!"".equals(result)) {
            System.out.println(result);
        }
    }

    /**
     * 26 字符串排序
     */
    private static void stringSort() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        char[] strArr = str.toCharArray();
        List<CharIndex> charIndex = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(str.charAt(i))) {
                CharIndex charindex1 = new CharIndex();
                charindex1.value = str.charAt(i);
                charindex1.index = i;
                charIndex.add(charindex1);
            }
        }
        charIndex.sort((CharIndex c1, CharIndex c2) -> {
            char char1 = Character.toUpperCase(c1.value);
            char char2 = Character.toUpperCase(c2.value);
            if (char1 == char2) {
                return c1.index - c2.index;
            } else {
                return (char1 - char2);
            }
        });


        int idx =0;
        for(int i =0;i<length;i++){
            if(Character.isLetter(strArr[i])){
                strArr[i] = charIndex.get(idx++).value;
            }
        }
        System.out.println(new String(strArr));
    }

    /**
     * 25 数据分类处理
     */
    private static void dataHandle() {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int iLength = sc.nextInt();
        int[] iArr = new int[iLength];
        for (int i = 0; i < iLength; i++) {
            iArr[i] = sc.nextInt();
        }
        int rLength = sc.nextInt();
        int[] rArr = new int[rLength];
        for (int i = 0; i < rLength; i++) {
            rArr[i] = sc.nextInt();
        }

        Arrays.sort(rArr);
        for (int i = 0; i < rLength; i++) {
            if (!set.contains(rArr[i])) {
                set.add(rArr[i]);
                List<Integer> list = new ArrayList<>();
                //判断I中是否有R的数
                for (int j = 0; j < iLength; j++) {
                    if (("" + iArr[j]).contains("" + rArr[i])) {
                        list.add(j);
                        list.add(iArr[j]);
                    }
                }
                if (list.size() > 0) {
                    result.add(rArr[i]);
                    result.add(list.size() / 2);
                    result.addAll(list);
                }
            }
        }
        System.out.print(result.size() + " ");
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                System.out.print(result.get(i) + " ");
            } else {
                System.out.print(result.get(i));
            }
        }
    }

    /**
     * 24 合唱队
     */
    private static void chorus() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int count = sc.nextInt();
        for(int i=0;i<count;i++){
            list.add(sc.nextInt());
        }
        int size = list.size();
        int[] dp = new int[list.size()];
        int[] dp1 = new int[list.size()];
        filldp(list, size, dp);
        Collections.reverse(list);
        filldp(list, size, dp1);
        int max1 =0;
        for(int i=0;i<size;i++){
            if(dp[i]+dp1[size-i-1]>max1){
                max1 = dp[i]+dp1[size-i-1];
            }
        }
        System.out.println(size-max1+1);
    }

    private static void filldp(List<Integer> list, int size, int[] dp) {
        dp[0] =1;

        for(int i=1;i<size;i++){
            int max =0;
            for(int j=0;j<i;j++){
                int num = list.get(i);
                if(list.get(j)<num){
                    if(max<dp[j]){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
        }
    }

    /**
     * 23 删除字符串中出现次数最少的字符
     */
    private static void deleteLessChar() {
        Map<Character,Integer> map = new HashMap<>(16);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        for(int i=0;i<length;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        Set<Character> keyset = map.keySet();
        int min = 20;
        for(Character key: keyset){
            if(map.get(key)<min){
                min = map.get(key);
            }
        }
        for(Character key: keyset){
            if(map.get(key) == min){
                str = str.replaceAll(key+"","");
            }
        }

        System.out.println(str);
    }

    /**
     * 22 汽水瓶
     */
    private static void waterBottle() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num == 0){
                return;
            }
            if(num<3){
                System.out.println(0);
            }
            int count = 0;
            while(num >=3){
                int rest = num%3;
                count +=num/3;
                num = num/3+rest;
            }
            if(num ==2){
                count++;
            }
            System.out.println(count);
        }
    }

    /**
     * 21 简单密码
     */
    private static void simplePassword() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',2);
        map.put('b',2);
        map.put('c',2);

        map.put('d',3);
        map.put('e',3);
        map.put('f',3);

        map.put('g',4);
        map.put('h',4);
        map.put('i',4);

        map.put('j',5);
        map.put('k',5);
        map.put('l',5);

        map.put('m',6);
        map.put('n',6);
        map.put('o',6);

        map.put('p',7);
        map.put('q',7);
        map.put('r',7);
        map.put('s',7);

        map.put('t',8);
        map.put('u',8);
        map.put('v',8);

        map.put('w',9);
        map.put('x',9);
        map.put('y',9);
        map.put('z',9);
        StringBuilder sb = new StringBuilder();
        char[] chrArr = str.toCharArray();
        for(char chr : chrArr){
            if(Character.isLowerCase(chr)){
                sb.append(map.get(chr));
            }else if(Character.isUpperCase(chr)){
                char upper = Character.toLowerCase(chr);
                sb.append(upper=='z'?'a':(char)(upper+1));
            }else {
                sb.append(chr);
            }
        }

        System.out.println(sb);
    }

    /**
     * 20 密码验证合格程序
     */
    private static void validatePassword() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            int length = str.length();
            //密码长度校验
            if(length<=8){
                System.out.println("NG");
                return;
            }
            //判断符号类型
            boolean isNumber = false;
            boolean isLower = false;
            boolean isUpper = false;
            boolean otherChar = false;
            char[] chrArr = str.toCharArray();
            for(char chr : chrArr){
                if(Character.isLowerCase(chr)){
                    isLower = true;
                    continue;
                }
                if(Character.isUpperCase(chr)){
                    isUpper = true;
                    continue;
                }
                if(Character.isDigit(chr)){
                    isNumber = true;
                    continue;
                }
                if(!Character.isSpaceChar(chr)){
                    otherChar = true;
                }
            }
            int count =0;
            if(isNumber){
                count++;
            }
            if(isUpper){
                count++;
            }
            if(isLower){
                count++;
            }
            if(otherChar){
                count++;
            }
            if(count<3){
                System.out.println("NG");
                continue;
            }
            //校验公共元素
            //窗口长度
            if(validateCommonElement(str)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }

    /**
     * 19 简单错误记录
     */
    private static void simpleErrorLog() {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>(16);
        while (sc.hasNextLine()) {
            String log = sc.nextLine();
            String[] lofArr = log.split(" ");
            String logLast = lofArr[0].substring(lofArr[0].lastIndexOf("\\") + 1);
            if (logLast.length() > 16) {
                logLast = logLast.substring(logLast.length() - 16);
            }
            logLast = logLast + " " + lofArr[1];
            //如果日志是出现过的
            if (map.containsKey(logLast)) {
                map.put(logLast, map.get(logLast) + 1);
            } else { //如果当前日志没有出现过
                //如果日志缓存区达到最大值
                if (queue.size() == 8) {
                    queue.poll();
                }
                queue.offer(logLast);
                map.put(logLast, 1);
            }
        }
        while (!queue.isEmpty()) {
            String log = queue.poll();
            System.out.println(log + " " + map.get(log));
        }
    }

    /**
     * 18 识别有效的IP地址和掩码并进行分类统计
     */
    private static void validateIpAndMask() {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[] {0, 0, 0, 0, 0, 0, 0};
        while (sc.hasNextLine()) {
            String[] ipAll = sc.nextLine().split("~");
            // 判断是否是合法ip
            String ip = ipAll[0];
            String mask = ipAll[1];
            String[] ipArr = ip.split("\\.");

            if ("0".equals(ipArr[0]) || "127".equals(ipArr[0])) {
                continue;//跳过
            }
            // 判断是否是非法ip
            if (isInvalidIp(ipArr)) {
                result[5]++;
                continue;
            }
            // 判断是否是非法掩码
            if (!isMask(mask)) {
                result[5]++;
                continue;
            }
            //判断是否是A类地址
            int ip1 = parseInt(ipArr[0]);
            if (1 <= ip1 && ip1 <= 126) {
                result[0]++;
            }
            //判断是否是B类地址
            if (128 <= ip1 && ip1 <= 191) {
                result[1]++;
            }
            //判断是否是C类地址
            if (192 <= ip1 && ip1 <= 223) {
                result[2]++;
            }
            //判断是否是D类地址
            if (224 <= ip1 && ip1 <= 239) {
                result[3]++;
            }
            //判断是否是E类地址
            if (240 <= ip1 && ip1 <= 255) {
                result[4]++;
            }
            // 判断是否是私有IP
            if (ip1 == 10) {
                result[6]++;
            }
            int ip2 = parseInt(ipArr[1]);
            if (ip1 == 172) {
                if (ip2 >= 16 && ip2 <= 31) {
                    result[6]++;
                }
            }
            if (ip1 == 192) {
                if (ip2 == 168) {
                    result[6]++;
                }
            }
        }
        int ipLen = 7;
        for (int i = 0; i < ipLen; i++) {
            if (i == 6) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + " ");
            }
        }
    }

    /**
     * 17 坐标移动
     */
    private static void movexy() {
        Scanner sc = new Scanner(System.in);
        int x=0,y=0;
        String locations = sc.nextLine();
        String[] locationArr = locations.split(";");
        for(String location:locationArr){

            if(location.length() <=1){
                continue;
            }
            char chr = location.charAt(0);
            if(chr != 'A' && chr != 'S' && chr != 'D' && chr != 'W'){
                continue;
            }
            String num = location.substring(1);
            if(isDigit(num)){
                int number = Integer.parseInt(num);
                switch (chr) {
                    case 'A':
                        x -=number;
                        break;
                    case 'S':
                        y -=number;
                        break;
                    case 'D':
                        x +=number;
                        break;
                    case 'W':
                        y +=number;
                        break;
                    default:
                }
            }

        }
        System.out.println(x+","+y);
    }

    /**
     * 16 购物单
     */
    private static void buyOrder() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Goods[] goods = new Goods[m];
        for(int i = 0; i < m; i++){
            goods[i] = new Goods();
        }
        for(int i = 0; i < m; i++){
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i].v = v;
            // 直接用p*v，方便后面计算
            goods[i].p = p * v;  
            if(q==0){
                goods[i].main = true;
            }else if(goods[q-1].a1 == -1){
                goods[q-1].a1 = i;
            }else{
                goods[q-1].a2 = i;
            }
        }

        int[] dp = new int[n+1];
        for(int i = 1; i <= m; i++){
            for(int j = n; j >= 0; j--){
                if(!goods[i-1].main){
                    continue;
                }
                if(j>=goods[i-1].v){
                    dp[j] = Math.max(dp[j], dp[j-goods[i-1].v] + goods[i-1].p);
                }
                if(goods[i-1].a1 != -1 && j >= goods[i-1].v + goods[goods[i-1].a1].v){
                    dp[j] = Math.max(dp[j], dp[j-goods[i-1].v - goods[goods[i-1].a1].v] + goods[i-1].p + goods[goods[i-1].a1].p);
                }
                if(goods[i-1].a2 != -1 && j >= goods[i-1].v + goods[goods[i-1].a2].v){
                    dp[j] = Math.max(dp[j], dp[j-goods[i-1].v - goods[goods[i-1].a2].v] + goods[i-1].p + goods[goods[i-1].a2].p);
                }
                if(goods[i-1].a1 != -1 && goods[i-1].a2 != -1 &&  j >= goods[i-1].v + goods[goods[i-1].a1].v + goods[goods[i-1].a2].v){
                    dp[j] = Math.max(dp[j], dp[j-goods[i-1].v - goods[goods[i-1].a1].v - goods[goods[i-1].a2].v] + goods[i-1].p + goods[goods[i-1].a1].p + goods[goods[i-1].a2].p);
                }
            }
        }
        System.out.println(dp[n]);
    }

    /**
     * 15 求int型正整数在内存中存储时1的个数
     */
    private static void oneCountForInteger() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count =0;
        while(num != 0){
            if((num&1) ==1){
                count++;
            }
            num = num >>1;
        }
        System.out.println(count);
    }

    /**
     * 14 字符串排序
     */
    private static void sortString() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        String[] strArr = new String[count];
        for(int i=0;i<count;i++){
            strArr[i] = sc.nextLine();
        }
        Arrays.sort(strArr);

        for(String str : strArr){
            System.out.println(str);
        }
    }

    /**
     * 13 句子逆序
     */
    private static void revertSentence() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length-1;i>=0;i--){
            if(i != 0){
                sb.append(strArr[i]).append(" ");
            }else{
                sb.append(strArr[i]);
            }
        }

        System.out.println(sb.toString());
    }

    /**
     * 12 字符串反转
     * @throws IOException 抛出异常
     */
    private static void revertString() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String string = bf.readLine();
        System.out.println(new StringBuffer(string).reverse());
    }

    /**
     * 11 数字颠倒
     */
    private static void revertNumber() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 10);
            num = num / 10;
        }
        System.out.println(sb.toString());
    }

    /**
     * 10 字符个数统计
     */
    private static void wordCount() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        Set<Character> set = new HashSet<>();
        int length = str.length();
        for(int i=0;i<length;i++){
            char chr = str.charAt(i);
            if((int) chr <= 127){
                if(!set.contains(chr)){
                    set.add(chr);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 9 提取不重复的整数
     */
    private static void getDistinctNum() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result =0;
        Set<Integer> set = new HashSet<>();
        while(num!=0){
            if(!set.contains(num%10)){
                set.add(num%10);
                result = result*10+(num%10);
            }
            num = num/10;
        }
        System.out.println(result);
    }

    /**
     * 8 合并表记录
     */
    private static void mergeTable() {
        Scanner sc = new Scanner(System.in);
        String count = sc.nextLine();
        int num = Integer.parseInt(count);
        Map<Integer,Integer> map = new HashMap<>(16);
        for(int i=0;i<num;i++){
            String pair = sc.nextLine();
            String[] arr = pair.split(" ");
            map.put(Integer.parseInt(arr[0]),map.getOrDefault(Integer.parseInt(arr[0]),0)+Integer.parseInt(arr[1]));
        }
        int[] keyset = new int[map.size()];
        int i=0;
        for(int key :map.keySet()){
            keyset[i++] = key;
        }
        Arrays.sort(keyset);


        for(int key : keyset){
            System.out.println(key+" "+map.get(key));
        }
    }

    /**
     * 7 取近似值
     */
    private static void myRound() {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();
        System.out.println(Math.round(num));
    }

    /**
     * 6 质数因子
     */
    private static void primeFactor() {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int num = sc.nextInt();
        int index = 2;
        while(num >1){
            double sqr = Math.sqrt(num);
            int i =index;
            for(;i<=sqr;i++){
                if(num % i == 0){
                    num = num/i;
                    result.add(i);
                    index = i;
                    break;
                }
            }
            if(i>sqr){
                result.add(num);
                break;
            }
        }
        int size = result.size();
        for(int i=0;i<size;i++){
            if(i == size-1){
                System.out.print(result.get(i));
            }else{
                System.out.print(result.get(i)+" ");
            }

        }
    }

    /**
     * 5 进制转换
     */
    private static void hex2ten() {
        Map<Character,Integer> map = new HashMap<>(16);
        fillMap(map);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace("0x","");
        int length = str.length();
        int result = 0;
        int pow = 1;
        for(int i = length-1;i>=0;i--){
            char chr = str.charAt(i);
            int num = map.get(chr);
            num = num * pow;
            pow = pow*16;
            result += num;
        }
        System.out.println(result);
    }

    /**
     * 4 字符串分隔
     */
    private static void stringSplit() {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        int len =8;
        int length = str.length();
        while(length>len){
            length -=len;
        }
        for(int i=0;i<len-length;i++){
            str.append("0");
        }
        int newLength = str.length();
        int index =0;
        while(index<newLength){
            System.out.println(str.substring(index,index+8));
            index +=8;
        }
    }

    /**
     * 3 明明的随机数
     */
    private static void randomNumber() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<count;i++){
            int num = sc.nextInt();
            if(!result.contains(num)){
                result.add(num);
            }
        }
        Collections.sort(result);
        for(int num : result){
            System.out.println(num);
        }
    }

    /**
     * 2.计算某字符出现次数
     */
    private static void countWord() {
        Scanner sc = new Scanner(System.in);
        String lowStr = sc.nextLine().toLowerCase();
        String chr = sc.nextLine().toLowerCase();
        char[] arr = lowStr.toCharArray();
        int count = 0;
        for(char char1 : arr){
            if(chr.equals(char1+"")){
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 1.字符串最后一个单词的长度
     */
    private static void getLastWordLength() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words =  str.split(" ");
        System.out.println(words[words.length-1].length());
    }

    private static boolean isDigit(String num){
        try{
            Integer.parseInt(num);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    private static boolean isInvalidIp(String[] ipArr) {
        int ipSize =4;
        if (ipArr.length != ipSize) {
            return true;
        }
        for (int i = 0; i < ipSize; i++) {
            int num = Integer.parseInt(ipArr[i]);
            if (num < 0 || num > 255) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMask(String mask) {
        String [] maskTable = mask.split("\\.");
        if (isInvalidIp(maskTable)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : maskTable) {
            String value = Integer.toBinaryString(Integer.parseInt(s));
            int length = value.length();
            if (length < 8) {
                //长度不足8位 则用0补齐
                for (int i = 0; i < 8 - length; i++) {
                    sb.append("0");
                }
            }
            //拼接到sb
            sb.append(value);
        }
        String res = sb.toString();
        return res.lastIndexOf("1") < res.indexOf("0");
    }
    private static int parseInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean validateCommonElement(String str){
        int length = str.length();
        for(int len =3;len<length-1;len++){
            for(int i =0;i<length-len;i++){
                for(int j=i+1;j<length-len+1;j++){
                    if(str.substring(i,i+len).equals(str.substring(j,j+len))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean mapEquals(Map<Character, Integer> m1,String word){

        Map<Character,Integer> newMap;
        newMap = m1;
        Set<Character> keyset = newMap.keySet();
        int length = word.length();
        for(int i=0;i<length;i++){
            if(!keyset.contains(word.charAt(i))){
                return false;
            }
            if(newMap.get(word.charAt(i))<1){
                return false;
            }
            newMap.put(word.charAt(i),newMap.get(word.charAt(i))-1);
        }
        return true;
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
//             if(num == 1) {
//                 return false;
//             }
        }
        return true;
    }

    public static boolean find(int x, List<Integer> evens,int[] used, int[] evensMatch) {
        //遍历偶数
        //去检查当前传入的奇数能否与偶数哪些数匹配
        for(int i = 0; i < evens.size(); i++) {
            //如果当前偶数与传入的奇数匹配，并且当前偶数位还没有匹配过奇数
            if(isPrime(x + evens.get(i)) && used[i] == 0) {
                //设置当前偶数位匹配为true，也就是 1
                used[i] = 1;
                //如果第i个偶数没有伴侣
                //或者第i个偶数原来有伴侣，并且该伴侣能够重新找到伴侣的话(这里有递归调用)
                //则奇数x可以设置为第i个偶数的伴侣
                //这里采用了匈牙利算法，能让则让
                if(evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {
                    evensMatch[i] = x;
                    return true;
                }
            }
        }
        //遍历完偶数都没有可以与传入奇数做伴侣的，该奇数只能孤独终老了
        return false;
    }

    /**
     * 判断一个字符串是否是回文字符串
     */
    private static boolean isHws(String str){
        int length = str.length();
        for(int i=0;i<length/2;i++){
            if(str.charAt(i)!=str.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    private static long ip2num(String ip){
        String[] iip = ip.split("\\.");
        long ans = 0;
        for(int i = 0; i<4; i++){
            ans = ans * 256 + Long.parseLong(iip[i]);
        }
        return ans;
    }

    private static String num2ip(long num){
        String[] ans = new String[4];
        for(int i=3; i>=0; i--){
            ans[i] = Long.toString(num % 256);
            num = num / 256;
        }
        return String.join(".", ans);
    }

}
class Goods {
    int v;
    int p;
    boolean main = false;
    /**
     * 定义附件1的编号
     */
    int a1 = -1;
    /**
     * 定义附件2的编号
     */
    int a2 = -1;
}
class CharIndex{
    char value;
    int index;
}
class ListNode {
    int m_nkey;
    ListNode m_pNext;
}
class Student {
    String name;
    int score;
    int index;
    Student(String name, int score, int index) {
        this.name = name;
        this.score = score;
        this.index = index;
    }
}
class Card {
    int cardType;
    int order;
    public Card(int cardType, int order) {
        // 0 单 1 对 2 三 3 顺子 4 炸
        this.cardType = cardType;
        this.order = order;
    }
}