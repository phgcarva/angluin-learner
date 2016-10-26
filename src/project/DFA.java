package project;

import java.util.ArrayList;

public class DFA {
	
	/*These are the five elements that compose a DFA*/
	
	protected ArrayList<State> states;
	protected ArrayList<State> acceptingStates;
	protected State initialState;
	protected ArrayList<Character> alphabet;
	protected ArrayList<Transition> delta;
	
	
	//------------------------ CONSTRUCTORS ------------------------//
	public DFA() {
		
		this.states = new ArrayList<>();
		this.acceptingStates = new ArrayList<>();
		this.alphabet = new ArrayList<>();
		this.delta = new ArrayList<>();
	
	}
	
	public DFA(ArrayList<State> states, ArrayList<State> acceptingStates, State initialState,
			ArrayList<Character> alphabet, ArrayList<Transition> delta) {

		this.states = states;
		this.acceptingStates = acceptingStates;
		this.initialState = initialState;
		this.alphabet = alphabet;
		this.delta = delta;
		
	}
	
	//------------------------ METHODS ------------------------//
	
	public State readChar(State currentState, char letter) {
		
		State output = new State(-1);
		for (Transition t : delta) {
			if (t.getSource().equals(currentState) && t.getLetter() == letter) {
				output = t.getDestination();
			}
		}
		
		return output;
		
	}
	
	public State readString(State currentState, String s) {
		
		State runningState = new State(currentState.id);
		
		for (char c : s.toCharArray()) {
			runningState = readChar(runningState, c);
		}
		
		return runningState;
		
	}
	
	public boolean isAccepted(State state) {
		
		boolean output = false;
		
		for (State acc : acceptingStates)
			if (acc.equals(state))
				output = true;
		
		return output;
	}

	public void addState(State s) {
		if (!states.contains(s))
			states.add(s);
	}
	
	public void addTransition(Transition t) {
		if (!delta.contains(t))
			delta.add(t);
	}


	//------------------------ GETTERS AND SETTERS ------------------------//

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public ArrayList<State> getAcceptingStates() {
		return acceptingStates;
	}

	public void setAcceptingStates(ArrayList<State> acceptingStates) {
		this.acceptingStates = acceptingStates;
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public ArrayList<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(ArrayList<Character> alphabet) {
		this.alphabet = alphabet;
	}

	public ArrayList<Transition> getDelta() {
		return delta;
	}

	public void setDelta(ArrayList<Transition> delta) {
		this.delta = delta;
	}
}