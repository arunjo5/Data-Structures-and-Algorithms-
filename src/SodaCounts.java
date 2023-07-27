public class SodaCounts {
    public String soda1, soda2, soda3;
    public int sodCt1, sodCt2, sodCt3;

    public SodaCounts() {
        this.soda1 = "Coke";
        this.soda2 = "Pepsi";
        this.soda3 = "7Up";
        this.sodCt1 = 0;
        this.sodCt2 = 0;
        this.sodCt3 = 0;
    }

    public String getSoda1() {
        return soda1;
    }
    public void setSoda1(String soda1) {
        this.soda1 = soda1;
    }
    public String getSoda2() {
        return soda2;
    }
    public void setSoda2(String soda2) {
        this.soda2 = soda2;
    }
    public String getSoda3() {
        return soda3;
    }
    public void setSoda3(String soda3) {
        this.soda3 = soda3;
    }
    public int getSodCt1() {
        return sodCt1;
    }
    public void setSodCt1(int sodCt1) {
        this.sodCt1 = sodCt1;
    }
    public int getSodCt2() {
        return sodCt2;
    }
    public void setSodCt2(int sodCt2) {
        this.sodCt2 = sodCt2;
    }
    public int getSodCt3() {
        return sodCt3;
    }
    public void setSodCt3(int sodCt3) {
        this.sodCt3 = sodCt3;
    }

    public String toString() {
        return "   " + soda1 + "- " + sodCt1 + "\n"
                + "   " + soda2 + "- " + sodCt2 + "\n"
                + "   " + soda3 + "- " + sodCt3 + "\n";
    }


}