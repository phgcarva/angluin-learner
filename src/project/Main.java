package project;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		DFA dfa = new DFA();
		RecursiveTeacher teacher = new RecursiveTeacher();
		
		State s0 = new State(0); State s1 = new State(1); 
		State s2 = new State(2); State s3 = new State(3);
		
		dfa.addState(s0); dfa.addState(s1); 
		dfa.addState(s2); dfa.addState(s3); 
		
		dfa.addTransition(new Transition(s0, s1, 'a'));
		dfa.addTransition(new Transition(s0, s2, 'b'));
		dfa.addTransition(new Transition(s1, s2, 'a'));
		dfa.addTransition(new Transition(s1, s3, 'b'));
		dfa.addTransition(new Transition(s2, s2, 'a'));
		dfa.addTransition(new Transition(s2, s2, 'b'));
		dfa.addTransition(new Transition(s3, s3, 'a'));
		dfa.addTransition(new Transition(s3, s3, 'b'));
		
		ArrayList<State> acceptingStates = new ArrayList<>();
		acceptingStates.add(s3);
		dfa.setAcceptingStates(acceptingStates);
		
		ArrayList<Character> alphabet = new ArrayList<>();
		alphabet.add('a'); alphabet.add('b');
		dfa.setAlphabet(alphabet);
		
		dfa.setInitialState(s0);
		
		System.out.println(teacher.answerMembershipQuery("aaaaa"));
		
	}
}
