class Solution {
    public String solution(String s) {
        String str = s.toLowerCase();
        String[] strArr = str.split("");
        boolean upper = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr.length; i++){
            if(upper){
                sb.append(strArr[i].toUpperCase());
            } else{
                sb.append(strArr[i]);
            }
            upper = !upper;
            if(strArr[i].equals(" ")){
                upper = true;
            }
            
        }
        return sb.toString();
    }
}