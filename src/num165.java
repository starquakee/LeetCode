public class num165 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len1 = split1.length;
        int len2 = split2.length;
        for(int i=0;i<Math.min(len1,len2);i++){
            if(Integer.parseInt(split1[i])<Integer.parseInt(split2[i])){
                return -1;
            } else if(Integer.parseInt(split1[i])>Integer.parseInt(split2[i])){
                return 1;
            }
        }
        if(len1<len2){
            for(int i=len1;i<len2;i++){
                if(Integer.parseInt(split2[i])>0)return -1;
            }
        }
        if(len1>len2){
            for(int i=len2;i<len1;i++){
                if(Integer.parseInt(split1[i])>0)return 1;
            }
        }
        return 0;
    }
}
