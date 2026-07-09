class flames{
    public static void main(String[] args) {
        // FLAMES GAME QUESTIONN
        String s1 = "Sayan";
        String s2 = "Alexander";
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder flames = new StringBuilder("FLAMES");
        for(int i =0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
             if(ch1>='A'&& ch1<='Z'){
                ch1 =(char)(ch1+32);
            }
            sb1.append(ch1);
             
        }
        for(int j = 0;j<s2.length();j++){
            char ch2 = s2.charAt(j);
            if(ch2>='A'&& ch2<='Z'){
            ch2 =(char)(ch2+32);
            }
            sb2.append(ch2);
            }
        for(int i = 0;i<sb1.length();i++){
            char ch_1 = sb1.charAt(i);
            for(int j = 0;j<sb2.length();j++){
                char ch_2 =sb2.charAt(j);
                if(ch_1 == ch_2){
                    sb1.deleteCharAt(i);
                    sb2.deleteCharAt(j);
                    i--;
                    break;
                }
                
            }
        }
        int count = sb1.length()+sb2.length();
        int i = 0;
        while (flames.length()>1){
            i=(i+count-1)%flames.length();
            flames.deleteCharAt(i);
        }
        char ans = flames.charAt(0);

    switch (ans) {
    case 'F':
        System.out.println("Friends");
        break;
    case 'L':
        System.out.println("Love");
        break;
    case 'A':
        System.out.println("Affection");
        break;
    case 'M':
        System.out.println("Marriage");
        break;
    case 'E':
        System.out.println("Enemies");
        break;
    case 'S':
        System.out.println("Siblings");
        break;
}

        
            
    }
        
}
