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

        Parameters parameters = new Parameters();
        parameters.extract(args);
        
        MarkovChain markovChain = buildMarkovChain(parameters.getFileName());
        new Gabbleduck(markovChain, System.out).gabble(parameters.getMaximumLines());
    }

    private static MarkovChain buildMarkovChain(String fileName) throws FileNotFoundException {

        MarkovChainFactory markovChainFactory = new MarkovChainFactory(new TextualPiece(new FileInputStream(new File(fileName))), new MarkovChainStateFactory());

        return markovChainFactory.createMarkovChain();
    }
}
