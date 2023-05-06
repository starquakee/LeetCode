public class num14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs[0].length()==0) return "";
        String prefix = strs[0].substring(0,1);
        int len = 1;
        while (true){
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    if (prefix.length() == 1) return "";
                    else return prefix.substring(0, prefix.length() - 1);
                }
            }
            len++;
            if(len> strs[0].length()){
                return strs[0];
            }
            prefix =  strs[0].substring(0,len);
        }
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));

    }
}
