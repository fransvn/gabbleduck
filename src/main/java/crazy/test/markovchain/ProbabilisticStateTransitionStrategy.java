package crazy.test.markovchain;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProbabilisticStateTransitionStrategy implements StateTransitionStrategy {

    public ProbabilisticStateTransitionStrategy() {

    }

    public State selectNextState(Collection<Transition> collection) {

        List<Transition> expanded = expandTransitions(collection);
        
        Collections.shuffle(expanded);
        return expanded.get(0).getTargetState();
    }

    private List<Transition> expandTransitions(Collection<Transition> collection) {
        
        List<Transition> expanded = new LinkedList<Transition>();
        for (Transition transition : collection) {

            for (int i = 0; i < transition.getWeighting(); i++) {

                expanded.add(transition);
            }
        }
        
        return expanded;
    }
}
