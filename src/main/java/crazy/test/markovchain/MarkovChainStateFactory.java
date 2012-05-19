package crazy.test.markovchain;

import java.util.HashMap;
import java.util.Map;

import crazy.test.io.TextualPiece;

public class MarkovChainStateFactory {

    private Map<String, State> knownStates = new HashMap<String, State>();
    private State previousState = null;

    public Map<String, State> compileStates(TextualPiece wordSource) {

        while (wordSource.hasNext()) {

            State newState = null;
            String nextWord = wordSource.nextWord();
            
            if(nextWord.isEmpty())
                continue;
            
            if (knownStates.containsKey(nextWord)) {

                newState = knownStates.get(nextWord);
            } else {

                newState = new State(nextWord);
                knownStates.put(nextWord, newState);
            }

            if (previousState != null) {

                previousState.addTransition(newState);
            }

            previousState = newState;
        }
        
        return knownStates;
    }
}
