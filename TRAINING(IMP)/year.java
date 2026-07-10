// DATE AND NUMBER OF DAYS ARE GIVEN AS INPUT WE NEED TO FIND THE DATE AFTER ADDING THE DAYS TO THE DATE
class year{
    public static void main (String[] args){
        String s1 = "10-07-2026";
        int input1 = 3;     //OUTPUT - 13-07-2026;
        int day =0;
        int month = 0;
        int year =0;
        // STORING THE DAY MONTH AND YEAR
        for(int i =0;i<s1.length();i++){
             day = (s1.charAt(0)-'0')*10 +(s1.charAt(1)-'0');
             month = (s1.charAt(3) - '0')*10+(s1.charAt(4)-'0');
             year = (s1.charAt(6) -'0')*1000 +(s1.charAt(7)-'0')*100+(s1.charAt(8)-'0')*10+(s1.charAt(9)-'0');
        }
        int [] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        // CHECKING LEAP YEAR
        boolean isleap = false;
        if(year%400 ==0 ||(year%4 == 0 && year%100 != 0)){
            isleap = true;
        }
        if(isleap){
            days[1] = 29;
        }
        day+=input1;
        while(day>days[month-1]){
            day-=days[month-1];
            month++;
            if(month>12){
                month=1;
                year++;
                days[1]=28;
                if((year%400==0) ||(year%4 == 0 && year%100!=0) ){
                    days[1]= 29;
                }
            }
        }
        String d;
        if(day<10){
            d="0"+day;       
        }else{
            d=""+day;
        }
        String m;
        if(month<10){
            m="0"+month;
        }else{
            m=""+month;
        }
        String ans = d+'-'+m+'-'+year;
        System.out.println(ans);

    }
}