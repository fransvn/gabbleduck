package crazy.test.markovchain;


class Transition {

	private State nextState;
	private long weighting;

	Transition(State nextState) {

		this.nextState = nextState;
		this.weighting = 1l;
	}

	public void increaseWeighting() {

		weighting++;
	}

	public long getWeighting() {

		return weighting;
	}

	public State getTargetState() {

		return nextState;
	}
}