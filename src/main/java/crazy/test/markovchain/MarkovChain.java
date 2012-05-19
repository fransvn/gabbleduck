package crazy.test.markovchain;

public class MarkovChain {

    private State currentState;
    private StateTransitionStrategy transitionStrategy;

    public MarkovChain(State currentState, StateTransitionStrategy transitionStrategy) {

        this.currentState = currentState;
        this.transitionStrategy = transitionStrategy;
    }

    public String progressState() {

        currentState = currentState.nextState(transitionStrategy);
        return currentState.getValue();
    }
}
