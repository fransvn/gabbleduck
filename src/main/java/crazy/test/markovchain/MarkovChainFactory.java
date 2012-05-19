package crazy.test.markovchain;

import java.util.Map;

import crazy.test.io.TextualPiece;

public class MarkovChainFactory {

    private MarkovChainStateFactory stateFactory;
    private TextualPiece wordSource;

    public MarkovChainFactory(TextualPiece wordSource, MarkovChainStateFactory stateFactory) {

        this.stateFactory = stateFactory;
        this.wordSource = wordSource;
    }

    public MarkovChain createMarkovChain() {

        Map<String, State> states = stateFactory.compileStates(wordSource);

        State currentState = findStartOfSentence(states);
        return new MarkovChain(currentState, new ProbabilisticStateTransitionStrategy());
    }

    private State findStartOfSentence(Map<String, State> states) {

        for (State state : states.values()) {

            if (state.canBeStartOfSentence()) {

                return state;
            }
        }

        return states.values().iterator().next();
    }
}