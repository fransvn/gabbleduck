package crazy.test;

import java.io.PrintStream;

import crazy.test.markovchain.MarkovChain;

/**
 * The resulting sentence structure made me think of the Gabbleduck a creature
 * in Neal Asher's novels.
 * 
 */
public class Gabbleduck {

    private MarkovChain markovChain;
    private PrintStream outputTarget;

    public Gabbleduck(MarkovChain markovChain, PrintStream outputTarget) {

        this.markovChain = markovChain;
        this.outputTarget = outputTarget;
    }

    public void gabble(Long maximumLines) {

        for (int line = 0; line < maximumLines; line++)
            for (int word = 0; word < 20; word++) {

                outputTarget.print(markovChain.progressState() + " ");
            }

        outputTarget.println();
    }
}
