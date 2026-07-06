class reversewords{
    public static void main(String[] args) {
        String s = "the sky is blue";
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i>=0){
            while (i>=0 && s.charAt(i) == ' '){
                i--;
            }
            if (i<0) break;
             
            int start =i;
            while(i>=0 && s.charAt(i) != ' '){
                i--;
            }
            if(sb.length()>0){
                sb.append(" "); //ADDING SPACES AFTER THE WORD
            }
            sb.append(s.substring(i+1,start+1));
        }
        System.out.println(sb.toString());
    }
    
}