package crazy.test.markovchain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class StateTestCase {

    private State state;

    @Before
    public void setup() throws Exception {

        state = new State("How");
    }

    @Test
    public void can_add_a_new_transition() throws Exception {

        State nextState = new State("now");
        state.addTransition(nextState);

        assertEquals("should have added new transition to state", nextState, state.possibleTransitions().iterator().next().getTargetState());
    }

    @Test
    public void adding_the_same_transition_does_not_produce_additional_transitions() throws Exception {

        state.addTransition(new State("now"));
        state.addTransition(new State("now"));

        assertEquals("should not add the same transition twice", 1, state.possibleTransitions().size());
    }

    @Test
    public void adding_the_same_transition_increases_transition_weight() throws Exception {

        state.addTransition(new State("now"));
        state.addTransition(new State("now"));

        assertEquals("should have increased the weighting of existing transition", 2l, state.possibleTransitions().iterator().next().getWeighting());
    }

    @Test
    public void next_state_selection_is_done_by_visitor() throws Exception {

        if_a_state_has_valid_transitions();

        State next = state.nextState(new FixedStateTransitionStrategy("then"));

        assertEquals("the next state should be dependent on the transition strategy.", "then", next.getValue());
    }

    private void if_a_state_has_valid_transitions() {

        state.addTransition(new State("now"));
        state.addTransition(new State("then"));
    }
}