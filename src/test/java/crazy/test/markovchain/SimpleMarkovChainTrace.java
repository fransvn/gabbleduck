package crazy.test.markovchain;


class SimpleMarkovChainTrace {

    private State state;

    public SimpleMarkovChainTrace(State state) {

        this.state = state;
    }

    public String reconstitute() {

        StringBuilder builder = new StringBuilder(32);
        FirstStateTransitionStrategy transitionStrategy = new FirstStateTransitionStrategy();

        while (state != null) {

            builder.append(state.getValue()).append(" ");
            state = state.nextState(transitionStrategy);
        }

        return builder.toString().trim();
    }
}