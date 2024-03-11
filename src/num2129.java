public class num2129 {
    public String capitalizeTitle(String title) {
        title = title.toLowerCase();
        String[] words = title.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i=0;i< words.length;i++){
            if(words[i].length()>2){
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
            ans.append(words[i]).append(" ");
        }
        String titled = ans.toString();
        return titled.substring(0,titled.length()-1);
    }
}
