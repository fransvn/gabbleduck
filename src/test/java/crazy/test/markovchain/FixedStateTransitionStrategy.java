package crazy.test.markovchain;

import java.util.Collection;


class FixedStateTransitionStrategy implements StateTransitionStrategy {

    private String nextState;

    public FixedStateTransitionStrategy(String nextState) {

        this.nextState = nextState;
    }

    public State selectNextState(Collection<Transition> collection) {

        for (Transition transition : collection) {

            State targetState = transition.getTargetState();
            if (targetState.getValue().equals(nextState)) {

                return targetState;
            }
        }

        return null;
    }
}