import java.util.*;

public class num838 {
    // out of time
//    public String pushDominoes(String dominoes) {
//        if(dominoes.length()==1)return dominoes;
//        List<Integer> list = new ArrayList<>();
//        int n=dominoes.length();
//        char[] chars = dominoes.toCharArray();
//        for(int i=0;i<n;i++){
//            if(chars[i]=='.')list.add(i);
//        }
//        while (!list.isEmpty()){
//            List<Integer> remove = new ArrayList<>();
//            char[] copy = Arrays.copyOf(chars, chars.length);
//            for(int i=0;i<list.size();i++){
//                int index=list.get(i);
//                if(index==0){
//                    if(chars[1]=='L'){copy[0]='L';remove.add(index);}
//                    if(chars[1]=='R')remove.add(index);
//                }else if(index==n-1){
//                    if(chars[n-2]=='R'){copy[n-1]='R';remove.add(index);}
//                    if(chars[n-2]=='L')remove.add(index);
//                }else {
//                    char left=chars[index-1];
//                    char right=chars[index+1];
//                    if(left=='L'&&right=='R')remove.add(index);
//                    if(left=='L'&&right=='L'){copy[index]='L';remove.add(index);}
//                    if(left=='R'&&right=='R'){copy[index]='R';remove.add(index);}
//                    if(left=='.'&&right=='L'){copy[index]='L';remove.add(index);}
//                    if(left=='R'&&right=='.'){copy[index]='R';remove.add(index);}
//                }
//            }
//            chars = copy;
//            if(remove.isEmpty())return new String(chars);
//            list.removeAll(remove);
//        }
//        return new String(chars);
//    }

    //Calculate the nearest R on the left and the nearest L on the right of each card. Whichever is closer is the one.
    //If the distances are the same, do not move.
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();

        int[] distToR = new int[n];
        int[] distToL = new int[n];
        final int INF = n + 5;          // 足够大的值代表“无穷远”

        /* 1. 左→右：计算每个位置到左侧最近 R 的距离 */
        int lastR = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                lastR = i;
            } else if (arr[i] == 'L') {
                lastR = -1;             // L 会阻断 R 的影响
            }
            distToR[i] = (lastR == -1) ? INF : i - lastR;
        }

        /* 2. 右→左：计算每个位置到右侧最近 L 的距离 */
        int lastL = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                lastL = i;
            } else if (arr[i] == 'R') {
                lastL = -1;             // R 会阻断 L 的影响
            }
            distToL[i] = (lastL == -1) ? INF : lastL - i;
        }

        /* 3. 生成最终状态 */
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '.') {                 // 仅对竖直牌做判断
                if (distToR[i] < distToL[i]) {
                    c = 'R';
                } else if (distToL[i] < distToR[i]) {
                    c = 'L';
                } // 相等或都是 INF 时保持 '.'
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
