package crazy.test.markovchain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


class State {

    private String value;
    private Map<Object, Transition> transitions;

    public State(String value) {

        this.value = value;
        transitions = new HashMap<Object, Transition>();
    }

    Collection<Transition> possibleTransitions() {

        return Collections.unmodifiableCollection(transitions.values());
    }

    public void addTransition(State state) {

        addNewOrIncreaseWeightingOfExisting(state);
    }

    private <S> void addNewOrIncreaseWeightingOfExisting(State state) {

        if (transitions.containsKey(state.getValue())) {

            transitions.get(state.getValue()).increaseWeighting();
        } else {

            transitions.put(state.getValue(), new Transition(state));
        }
    }

    public String getValue() {

        return value;
    }

    public State nextState(StateTransitionStrategy transitionStrategy) {

        return transitionStrategy.selectNextState(transitions.values());
    }

    public boolean canBeStartOfSentence() {

        return Character.isUpperCase(value.charAt(0));
    }
}