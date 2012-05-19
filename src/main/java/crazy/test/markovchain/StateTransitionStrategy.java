package crazy.test.markovchain;

import java.util.Collection;


interface StateTransitionStrategy{

    State selectNextState(Collection<Transition> collection);
}