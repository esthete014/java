public class clock_seconds extends clock {
    protected int arrowSeconds;

    public clock_seconds(){
        this.name = "none";
        this.price = 0;
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinutes = java.time.LocalDateTime.now().getMinute();// % 12;
        this.arrowSeconds = java.time.LocalDateTime.now().getSecond();//
    }

    public clock_seconds(String _name, int _price) {
        this.name = _name;
        if (_price >= 0) {
            this.price = _price;
        }
        else{
            throw new NullPointerException("Exception: Price < 0!");
        }
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinutes = java.time.LocalDateTime.now().getMinute();// % 12;
        this.arrowSeconds = java.time.LocalDateTime.now().getSecond();//
    }

    public clock_seconds(String _name, int _price, int aH, int aM,int aS) {
        this.name = _name;
        if (_price >= 0) {
            this.price = _price;
        }
        else{
            throw new NullPointerException("Exception: Price < 0!");
        }
        if (aH >= 0 ) {
            this.arrowHours += aH;
            if (this.arrowHours > 12) {
                this.arrowHours %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Hours < 0!");
        }
        if (aM >= 0) {
            this.arrowMinutes += aM;
            if (this.arrowMinutes > 12) {
                this.arrowMinutes %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Minutes < 0");
        }
        if (aS >= 0) {
            this.arrowSeconds += aS;
            if (this.arrowSeconds > 60) {
                this.arrowSeconds %= 60;
            }
        }
        else {
            throw new NullPointerException("Exception: Seconds < 0");
        }
    }

    public int getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public int getHours(){
        return arrowHours;
    }

    public int getMinutes(){
        return arrowMinutes;
    }

    public int getSeconds() {
        return arrowSeconds;
    }


    public void plusTime(types_arrow type, int value) {
        if (value >= 0) {
            if (type == clock_interface.types_arrow.H) {
                this.arrowHours += value;
                if (this.arrowHours > 23) {
                    this.arrowHours %= 24;
                }
            }
            else if (type == clock_interface.types_arrow.M) {
                this.arrowMinutes += value;
                if (this.arrowMinutes > 59) {
                    this.arrowMinutes %= 60;
                }
            }
            else if (type == clock_interface.types_arrow.S) {
                this.arrowSeconds += value;
                if (this.arrowSeconds > 59) {
                    this.arrowSeconds %= 60;
                }
            }
        }
        else {
            throw new NullPointerException("Exception: set_time value < 0");
        }
    }

    @Override
    public String toString() {
        return "Clock{" +
                "name='" + name + '\'' +
                ", arrowHours=" + arrowHours +
                ", arrowMinutes=" + arrowMinutes +
                ", arrowSeconds=" + arrowSeconds +
                ", price=" + price +
                '}';
    }

    public void PrintDisplay(){
        System.out.println("Name: " + this.name);
        System.out.println("price: " + this.price);
        System.out.println("Hours: " + this.arrowHours);
        System.out.println("Minutes: " + this.arrowMinutes);
        System.out.println("Seconds: " + this.arrowSeconds);
    }

    public void set_time (clock_interface.types_arrow type, int value) {
        if (value >= 0) {
            if (type == clock_interface.types_arrow.H) {
                this.arrowHours = value;
                if (this.arrowHours > 23) {
                    this.arrowHours %= 24;
                }
            }
            else if (type == clock_interface.types_arrow.M) {
                this.arrowMinutes = value;
                if (this.arrowMinutes > 59) {
                    this.arrowMinutes %= 60;
                }
            }
            else if (type == clock_interface.types_arrow.S) {
                this.arrowSeconds = value;
                if (this.arrowSeconds > 59) {
                    this.arrowSeconds %= 60;
                }
            }
        }
        else {
            throw new NullPointerException("Exception: set_time value < 0");
        }
    }
}
