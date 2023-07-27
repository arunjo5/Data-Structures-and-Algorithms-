import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
    private LinkedList<Term> p = new LinkedList();

    public void addTerm(Term t)
    {
        addTerm(t.getCoeff(), t.getPower());
    }

    public void addTerm(int coefficient, int power)
    {
        Term term = new Term(coefficient, power);
        ListIterator<Term> iterator = this.p.listIterator();
        if (iterator.hasNext() && (iterator.next().getPower() == power))
        {
            Term term2 = iterator.previous().add(term);
            iterator.set(term2);
            return;
        }
        if (iterator.hasPrevious() && (iterator.previous().getPower() < power))
        {
            this.p.addFirst(term);
            return;
        }
        while (iterator.hasNext())
        {
            if (iterator.next().getPower() == power)
            {
                Term term2 = iterator.previous().add(term);
                iterator.set(term2);
                return;
            }
            iterator.previous();
            if (iterator.hasNext() && (iterator.next().getPower() < power))
            {
                iterator.previous();
                iterator.add(term);
                return;
            }
        }
        this.p.addLast(term);
    }

    public Polynomial add(Polynomial other)
    {
        ListIterator<Term> iter = this.p.listIterator();
        ListIterator<Term> iter2 = other.getIterator();
        Polynomial newP = new Polynomial();
        while (iter.hasNext()) {
            newP.addTerm((Term)iter.next());
        }
        while (iter2.hasNext()) {
            newP.addTerm((Term)iter2.next());
        }
        return newP;
    }

    public Polynomial derivative()
    {
        ListIterator<Term> iter = this.p.listIterator();
        Polynomial p = new Polynomial();
        while (iter.hasNext())
        {
            Term term = (Term)iter.next();
            p.addTerm(term.getPower() * term.getCoeff(), term.getPower() -1);
        }
        return p;
    }

    public Polynomial multiply(Polynomial other)
    {
        ListIterator<Term> ite = this.p.listIterator();
        ListIterator<Term> ite2 = other.getIterator();
        Polynomial p = new Polynomial();
        while (ite.hasNext())
        {
            Term term = (Term)ite.next();
            while (ite2.hasNext()) {
                p.addTerm(term.multiply((Term)ite2.next()));
            }
            ite2 = other.getIterator();
        }
        return p;
    }

    public ListIterator<Term> getIterator()
    {
        return this.p.listIterator();
    }

    public String toString()
    {
        String str = "";

        ListIterator<Term> iter = this.p.listIterator();
        while (iter.hasNext()) {
            Term t=iter.next();
            if(t.getCoeff()!=0)
                str = str +"+"+ t;
        }
        return str;
    }
}