public class Term {

    private int c,p;

    Term(int coeff,int pwr){
        c=coeff;
        p=pwr;
    }

    public Term add(Term t){

        if(t.getPower()==p)
            c+=t.getCoeff();
        Term o= new Term(c,p);
        return o;
    }

    public Term multiply(Term t){
        return new Term(this.getCoeff()*t.getCoeff(),this.getPower()+t.getPower());
    }

    public boolean before(Term t){
        if(t.getPower()<=p)
            return true;
        return false;
    }

    public int getCoeff() {
        return c;
    }

    public int getPower() {
        return p;
    }

    public String toString(){
        return c+"x^"+p+" ";
    }

}