package crazy.test.markovchain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MarkovChainTestCase {

    private MarkovChain chain;
    private State state1;
    private State state2;

    @Before
    public void setup() throws Exception {

        setupSimpleStates();
        chain = new MarkovChain(state1, new FirstStateTransitionStrategy());
    }

    private void setupSimpleStates() {

        state1 = new State("One");
        state2 = new State("Two");
        state1.addTransition(state2);
        state2.addTransition(state1);
    }

    @Test
    public void markov_state_progression_is_combination_of_states_and_strategy() throws Exception {

        assertEquals("in this simplified setup it should progress predictably by going to state 2", "Two", chain.progressState());
        assertEquals("in this simplified setup it should progress predictably by going back to state 1", "One", chain.progressState());
    }
}
