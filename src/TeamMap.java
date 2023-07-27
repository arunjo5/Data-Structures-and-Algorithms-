import java.util.HashMap;
import java.util.Map;

public class TeamMap {
    private Map<Integer, TeamSet> map;

    public TeamMap() {
        map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            map.put(i, new TeamSet());
        }
    }

    public void addWrestler(Wrestler w) {
        int weightGroup = (w.getWeight() - 100) / 10 + 1;
        if (weightGroup < 1 || weightGroup > 10) {
            throw new IllegalArgumentException("Weight out of range");
        }
        for (Map.Entry<Integer, TeamSet> entry : map.entrySet()) {
            int key = entry.getKey();
            TeamSet value = entry.getValue();
            if (value.getWrestSet().contains(w)) {
                value.getWrestSet().remove(w);
                break;
            }
        }
        map.get(weightGroup).addWrestler(w);
    }

    public void changeWeightGroup(Wrestler w, int newGroup) {
        if (newGroup < 1 || newGroup > 10) {
            throw new IllegalArgumentException("Weight group out of range");
        }
        int oldGroup = (w.getWeight() - 100) / 10 + 1;
        if (newGroup >= oldGroup) {
            map.get(oldGroup).getWrestSet().remove(w);
            map.get(newGroup).addWrestler(w);
        } else {
            throw new IllegalArgumentException("Cannot move wrestler to a lower weight group");
        }
    }

    public int getWeightGroup(Wrestler w) {
        for (Map.Entry<Integer, TeamSet> entry : map.entrySet()) {
            int key = entry.getKey();
            TeamSet value = entry.getValue();
            if (value.getWrestSet().contains(w)) {
                return key;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("Weight Group " + i + ": ");
            TeamSet teamSet = map.get(i);
            if (teamSet != null) {
                sb.append(teamSet.getWrestSet().toString());
            } else {
                sb.append("empty");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}