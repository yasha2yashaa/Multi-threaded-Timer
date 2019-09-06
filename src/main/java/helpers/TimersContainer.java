package helpers;

import java.util.HashMap;
import java.util.Set;

public class TimersContainer {
    private HashMap<String, Timer> timers;

    public TimersContainer() {
        timers = new HashMap<>();
    }

    public void add(String name, Timer timer) {
        timers.put(name, timer);
    }

    public Timer get(String name) {
        return timers.get(name);
    }

    public boolean exists(String name) {
        return timers.containsKey(name);
    }

    public Set<String> getTimerNames() {
        return timers.keySet();
    }
}
