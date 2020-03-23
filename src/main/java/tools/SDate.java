package tools;


/**
 * Describes a non-deprecated Date class
 * @author Sébastien HERT
 */
public class SDate{

    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer min;
    private Integer sec;

    //Put your own time zone delay
    private static Integer delay = +1;

    /**
     * Constructor
     * @author Sébastien HERT
     */
    public SDate(){
        this.year = 2020;
        this.month = 1;
        this.day = 1;
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
    }

    /**
     * Constructor
     * @param date in SDate
     * @author Sébastien HERT
     */
    public SDate(SDate date){
        this.year = date.getYear();
        this.month = date.getMonth();
        this.day = date.getDay();
        this.hour = date.getHour();
        this.min = date.getMin();
        this.sec = date.getSec();
    }

    /**
     * Constructor
     * @param y in Integer
     * @param mo in Integer
     * @param d in Integer
     * @author Sébastien HERT
     */
    public SDate(Integer y, Integer mo, Integer d){
        this.year = y;
        this.month = mo;
        this.day = d;
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
    }

    /**
     * Constructor
     * @param y in Integer
     * @param mo in Integer
     * @param d in Integer
     * @param h in Integer
     * @param mn in Integer
     * @param sc in Integer
     * @author Sébastien HERT
     */
    public SDate(Integer y, Integer mo, Integer d, Integer h, Integer mn, Integer sc){
        this.year = y;
        this.month = mo;
        this.day = d;
        this.hour = h;
        this.min = mn;
        this.sec = sc;
    }


    /**
     * Constructor
     * @param s the String with the appropriate format
     * @see #Date.toString()
     * @author Sébastien HERT
     */
    public SDate(String s){

        try{
            String[] sParse = s.split(" - ");
            String[] sParseDate = sParse[0].split("/");
            String[] sParseTime = sParse[1].split(":");

            this.year = Integer.parseInt(sParseDate[0]);
            this.month = Integer.parseInt(sParseDate[1]);
            this.day = Integer.parseInt(sParseDate[2]);
            this.hour = Integer.parseInt(sParseTime[0]);
            this.min = Integer.parseInt(sParseTime[1]);
            this.sec = Integer.parseInt(sParseTime[2]);
        }catch(NumberFormatException e){
            System.out.println("Error : Arguments arent valid numbers");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error : the Date given doesnt have the right format, please use the yyyy/mm/dd - hh/mm/ss format");
        }
    }

    /**
     * Gets the year
     * @return year in Integer
     * @author Sébastien HERT
     */
    public Integer getYear() {
        return this.year;
    }

    /**
     * Sets the year
     * @param y in Integer
     * @author Sébastien HERT
     */
    public void setYear(Integer y) {
        this.year = y;
    }

    /**
     * Gets the month
     * @return month in Integer
     * @author Sébastien HERT
     */
    public Integer getMonth() {
        return this.month;
    }

    /**
     * Sets the month
     * @param mo in Integer
     * @author Sébastien HERT
     */
    public void setMonth(Integer mo) {
        this.month = mo;
    }

    /**
     * Gets the day
     * @return day in Integer
     * @author Sébastien HERT
     */
    public Integer getDay() {
        return this.day;
    }

    /**
     * Sets the day
     * @param d in Integer
     * @author Sébastien HERT
     */
    public void setDay(Integer d) {
        this.day = d;
    }

    /**
     * Gets the hour
     * @return hour in Integer
     * @author Sébastien HERT
     */
    public Integer getHour() {
        return this.hour;
    }

    /**
     * Sets the hour
     * @param h in Integer
     * @author Sébastien HERT
     */
    public void setHour(Integer h) {
        this.hour = h;
    }

    /**
     * Gets the minute
     * @return min in Integer
     * @author Sébastien HERT
     */
    public Integer getMin() {
        return this.min;
    }

    /**
     * Sets the minute
     * @param mn in Integer
     * @author Sébastien HERT
     */
    public void setMin(Integer mn) {
        this.min = mn;
    }

    /**
     * Gets the seconde
     * @return sec in Integer
     * @author Sébastien HERT
     */
    public Integer getSec() {
        return this.sec;
    }

    /**
     * Sets the seconde
     * @param sc in Integer
     * @author Sébastien HERT
     */
    public void setSec(Integer sc) {
        this.sec = sc;
    }

    /**
     * ToString method with the format yyyy/mm/dd - hh/mm/ss
     * @return the date as a String
     * @author Sébastien HERT
     */
    @Override
    public String toString(){
        return this.year+"/"+feelZero(this.month)+"/"+feelZero(this.day)+" - "+feelZero(this.hour)+":"+feelZero(this.min)+":"+feelZero(this.sec);
    }

    /**
     * Creates a String with 
     * @param i in Integer
     * @return I as a String
     */
    private String feelZero(Integer i){
        if( i < 10 ){
            return "0"+i;
        }else{
            return Integer.toString(i);
        }
    }

    /**
     * Are 2 SDates equals
     * @param date the SDate to compare with
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean equals(SDate date){

        return  this.year.equals(date.getYear())
                && this.month.equals(date.getMonth())
                && this.day.equals(date.getDay())
                && this.hour.equals(date.getHour())
                && this.min.equals(date.getMin())
                && this.sec.equals(date.getSec());

    }

    /**
     * Is a SDate superior to another one
     * @param date the SDate to compare with
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isSup(SDate date){
        if (this.year > date.getYear()){return true;}
        else if(this.year < date.getYear()){return false;}
        else{
            if (this.month > date.getMonth()){return true;}
            else if(this.month < date.getMonth()){return false;}
            else{
                if (this.day > date.getDay()){return true;}
                else if(this.day < date.getDay()){return false;}
                else{
                    if (this.hour > date.getHour()){return true;}
                    else if(this.hour < date.getHour()){return false;}
                    else{
                        if (this.min > date.getMin()){return true;}
                        else if(this.min < date.getMin()){return false;}
                        else{
                            if (this.sec > date.getSec()){return true;}
                            else{return false;}
                        }
                    }
                }                            
            }   
        }
    }

    /**
     * Is a SDate inferior to another one
     * @param date the SDate to compare with
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isInf(SDate date){
        return !this.equals(date) && !this.isSup(date);
    }

    /**
     * Checks if the SDate is valid or not
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValid(){
        return  this.isValidMonth()
                && this.isValidDay()
                && this.isValidHour()
                && this.isValidMin()
                && this.isValidSec();
    }

    /**
     * Checks if the month is valid
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValidMonth(){
        return this.month <= 12 && this.month > 0;
    }

    /**
     * Checks if the day is valid depeding on the month and the year
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValidDay(){
        return this.day > 0 && this.day <= this.getDaysPerMonth();
    }

    /**
     * Checks if the hour is valid (24-h clock)
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValidHour(){
        return this.hour >= 0 && this.hour < 24;
    }

    /**
     * Checks if the minutes are valid
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValidMin(){
        return this.min >=0 && this.min < 60;
    }

    /**
     * Checks if the seconds are valid
     * @return a Boolean
     * @author Sébastien HERT
     */
    public Boolean isValidSec(){
        return this.sec >=0 && this.sec < 60;
    }

    /**
     * Gives the number of days in the month of the SDate
     * @return the number of days
     * @author Sébastien HERT
     */
    private int getDaysPerMonth(){
        if (this.month<8){
            if(this.month%2==1){return 31;}
            else if (this.month == 2){
                if (this.year%4 == 0){return 29;}
                else{return 28;}
            }else{return 30;}
        }else{
            if(this.month%2==0){return 31;}
            else{return 30;}
        }
    }

    /**
     * Adds a time to the SDate
     * @param y the number (positive) of years to add
     * @param mo the number (positive) of months to add
     * @param d the number (positive) of days to add
     * @param h the number (positive) of hs to add
     * @param mn the number (positive) of minutes to add
     * @param sc the number (positive) of secondes to add
     * @author Sébastien HERT
     */
    public void addTime(Integer y, Integer mo, Integer d, Integer h, Integer mn, Integer sc){
        this.addSec(sc);
        this.addMin(mn);
        this.addHour(h);
        this.addDay(d);
        this.addMonth(mo);
        this.addYear(y);
    }

    /**
     * Adds a time to the SDate
     * @param y the number (positive) of years to add
     * @param mo the number (positive) of months to add
     * @param d the number (positive) of days to add
     * @author Sébastien HERT
     */
    public void addTime(Integer y, Integer mo, Integer d){
        this.addDay(d);
        this.addMonth(mo);
        this.addYear(y);
    }

    /**
     * Adds a number (positive) of years to the SDate
     * @param y the number of years to add
     * @author Sébastien HERT
     */
    public void addYear(Integer y){
        y = Math.abs(y.intValue());
        this.year += y;
    }

    /**
     * Adds the number (positive) of months to the SDate
     * @param mo the number of months to add
     * @author Sébastien HERT
     */
    public void addMonth(Integer mo){
        mo = Math.abs(mo.intValue());
        this.month += mo;
        int q = 0;
        while (this.month>12){
            this.month -= 12;
            q = q+1;
        }
        this.addYear(q);
    }

    /**
     * Adds the number (positive) of days to the SDate
     * @param d the number of days to add
     * @author Sébastien HERT
     */
    public void addDay(Integer d){
        d = Math.abs(d.intValue());
        this.day += d;
        while (this.day>this.getDaysPerMonth()){
            this.day -= this.getDaysPerMonth();
            this.addMonth(1);
        }
    }

    /**
     * Adds the number (positive) of hs to the SDate
     * @param h the number of hs to add
     * @author Sébastien HERT
     */
    public void addHour(Integer h){
        h = Math.abs(h.intValue());
        this.hour += h;
        int q = 0;
        while (this.hour>=24){
            this.hour -= 24;
            q = q+1;
        }
        this.addDay(q);
    }

    /**
     * Adds the number (positive) of minutes to the SDate
     * @param mn the number of minutes to add
     * @author Sébastien HERT
     */
    public void addMin(Integer mn){
        mn = Math.abs(mn.intValue());
        this.min += mn;
        int q = 0;
        while (this.min>=60){
            this.min -= 60;
            q = q+1;
        }
        this.addHour(q);
    }

    /**
     * Adds the number (positive) of seconds to the SDate
     * @param sc the number of seconds to add
     * @author Sébastien HERT
     */
    public void addSec(Integer sc){
        sc = Math.abs(sc.intValue());
        this.sec += sc;
        int q = 0;
        while (this.sec>=60){
            this.sec -= 60;
            q = q+1;
        }
        this.addMin(q);
    }

    /**
     * Removes a time of the SDate
     * @param y the number (positive) of years to remove
     * @param mo the number (positive) of month to remove
     * @param d the number (positive) of days to remove
     * @param h the number (positive) of hours to remove
     * @param mn the number (positive) of minutes to remove
     * @param sc the number (positive) of secondes to remove
     * @author Sébastien HERT
     */
    public void removeTime(Integer y, Integer mo, Integer d, Integer h, Integer mn, Integer sc){
        this.removeSec(sc);
        this.removeMin(mn);
        this.removeHour(h);
        this.removeDay(d);
        this.removeMonth(mo);
        this.removeYear(y);
    }

    /**
     * Removes a time of the SDate
     * @param y the number (positive) of years to remove
     * @param mo the number (positive) of month to remove
     * @param d the number (positive) of days to remove
     * @author Sébastien HERT
     */
    public void removeTime(Integer y, Integer mo, Integer d){
        this.removeDay(d);
        this.removeMonth(mo);
        this.removeYear(y);
    }

    /**
     * Removes the number (positive) of years to the SDate
     * @param y the number of years to remove
     * @author Sébastien HERT
     */
    public void removeYear(Integer y){
        this.year -= y;
    }

    /**
     * Removes the number (positiv) of months to the SDate
     * @param mo the number of months to remove
     * @author Sébastien HERT
     */
    public void removeMonth(Integer mo){
        mo = Math.abs(mo.intValue());
        this.month -= mo;
        int q = 0;
        while (this.month<=0){
            this.month += 12;
            q = q+1;
        }
        this.removeYear(q);
    }

    /**
     * Removes the number (positive) of days to the SDate
     * @param d the number of days to remove
     * @author Sébastien HERT
     */
    public void removeDay(Integer d){
        d = Math.abs(d.intValue());
        this.day -= d;
        while (this.day<=0){
            this.removeMonth(1);
            this.day += this.getDaysPerMonth();
        }
    }

    /**
     * Removes the number (positive) of hours to the SDate
     * @param h the number of hours to remove
     * @author Sébastien HERT
     */
    public void removeHour(Integer h){
        h = Math.abs(h.intValue());
        this.hour -= h;
        int q = 0;
        while (this.hour<0){
            this.hour += 24;
            q = q+1;
        }
        this.removeDay(q);
    }

    /**
     * Removes the number (positive) of minutes to the SDate
     * @param mn the number of minutes to remove
     * @author Sébastien HERT
     */
    public void removeMin(Integer mn){
        mn = Math.abs(mn.intValue());
        this.min -= mn;
        int q = 0;
        while (this.min<0){
            this.min += 60;
            q = q+1;
        }
        this.removeHour(q);
    }

    /**
     * Removes the number (positive) of seconds to the SDate
     * @param sc the number of seconds to remove
     * @author Sébastien HERT
     */
    public void removeSec(Integer sc){
        sc = Math.abs(sc.intValue());
        this.sec -= sc;
        int q = 0;
        while (this.sec<0){
            this.sec += 60;
            q = q+1;
        }
        this.removeMin(q);
    }
    
    /**
     * Creates a SDate with the current time
     * @return the current date
     * @see #delay the class variable delay
     * @author Sébastien HERT
     */
    public static SDate now(){
        SDate date = new SDate(1970, 1, 1);
        long l = System.currentTimeMillis();
        l /= 1000;
        while (l>Integer.MAX_VALUE/2){
            date.addSec(Integer.MAX_VALUE/2);
            l -= Integer.MAX_VALUE/2;
        }
        date.addSec((int) l);

        //Add your TimeZone delay
        if (delay>0){date.addHour(delay);}
        else { date.removeHour(delay);}

        return date;
    }


    /**
     * Convert a string date from html to Sdate
     * @param htmlDate the date to convert
     * @return sDate the date converted
     * @author Sébastien HERT
     */
    public static SDate htmlToSdate(String htmlDate){
        String[] parsingDate = htmlDate.split("-");
        SDate sDate = null;
        try{
            sDate = new SDate(Integer.parseInt(parsingDate[0]),Integer.parseInt(parsingDate[1]),Integer.parseInt(parsingDate[2]));
        }catch(NumberFormatException e){
            System.out.println("Error : Arguments arent valid numbers");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error : the Date given doesnt have the right format, please use the dd-mm-yyyy format");
        }

        return sDate;

    }
    
}