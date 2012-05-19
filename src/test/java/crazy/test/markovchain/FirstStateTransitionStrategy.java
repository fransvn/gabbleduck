package crazy.test.markovchain;

import java.util.Collection;


class FirstStateTransitionStrategy implements StateTransitionStrategy {

    public State selectNextState(Collection<Transition> collection) {

        if (collection.iterator().hasNext()) {

            return collection.iterator().next().getTargetState();
        } else {

            return null;
        }
    }
}