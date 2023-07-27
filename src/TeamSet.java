
import java.util.HashSet;
import java.util.Set;

public class TeamSet {
    private HashSet<Wrestler> wrestSet;

    public TeamSet() {
        wrestSet = new HashSet<>();
    }

    public int avgWeight() {
    int ct=0;
    for (Wrestler w : wrestSet) {
        ct += w.getWeight();
    }
    return ct / wrestSet.size();
    }

    public Set<String> lightweight() {
        Set<String> set = new HashSet<>();
        for (Wrestler w : wrestSet) {
            if (w.getWeight() < 120) {
                set.add(w.toString());
            }
        }
        return set;
    }

    public void addWrestler(Wrestler bob) {
        wrestSet.add(bob);
    }


    public HashSet<Wrestler> getWrestSet() {
        return wrestSet;
    }


}