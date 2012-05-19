package crazy.test.markovchain;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import crazy.test.io.TextualPiece;

public class MarkovChainStateFactoryTestCase {

    private MarkovChainStateFactory factory;

    @Before
    public void setup() throws Exception {

        factory = new MarkovChainStateFactory();
    }

    private TextualPiece createTextualPiece() {

        return new TextualPiece(new ByteArrayInputStream("How now brown cow".getBytes()));
    }

    @Test
    public void builds_a_markov_chain_from_textual_piece() {

        Map<String, State> states = factory.compileStates(createTextualPiece());

        assertEquals("reconstituting the simple markov chain should give original string", "How now brown cow",
                new SimpleMarkovChainTrace(states.get("How")).reconstitute());
    }
}