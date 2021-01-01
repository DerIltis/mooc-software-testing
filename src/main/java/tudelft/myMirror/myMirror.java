package tudelft.myMirror;

public class myMirror {
    public String mirrorEnds(String string){
        String mirror = "";
        int begin = 0;
        int end =  string.length() -1;
        // int length = string.length();
        for (; begin  < end; begin++, end--){
            if(string.charAt(begin) == string.charAt(end)){
                mirror += String.valueOf(string.charAt(end));
            }
            else {
                break;
            }
        }
        return begin >= end ? string : mirror;
    }

}
