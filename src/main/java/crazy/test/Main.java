package crazy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import crazy.test.io.TextualPiece;
import crazy.test.markovchain.MarkovChain;
import crazy.test.markovchain.MarkovChainFactory;
import crazy.test.markovchain.MarkovChainStateFactory;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        MarkovChain markovChain = buildMarkovChain(args);
        new Gabbleduck(markovChain, System.out).gabble();
    }

    private static MarkovChain buildMarkovChain(String[] args) throws FileNotFoundException {

        MarkovChainFactory markovChainFactory = new MarkovChainFactory(new TextualPiece(new FileInputStream(new File(args[0]))), new MarkovChainStateFactory());

        return markovChainFactory.createMarkovChain();
    }
}
