package project;

import java.util.ArrayList;
import java.math.*;
import java.util.Random;


public abstract class Teacher {
	
	protected ArrayList<String> elements;
	protected int iteration;
	protected double accuracy;
	protected double confidence;
	protected int conjecturesAnswered;
	
	public Teacher() {
		conjecturesAnswered = 0;
		accuracy = 0.99;
		confidence = 0.99;
	}
	
	public abstract boolean answerMembershipQuery(String s);
	
	public abstract boolean answerConjecture(DFA dfa);
	
	public void tickConjectures() {
		conjecturesAnswered++;
	}
	
	public void resetConjectures() {
		conjecturesAnswered = 0;
	}
	
	public int getConjecturesAnswered() {
		return conjecturesAnswered;
	}
	
	public int limitIterations() {
		double ri = (1/accuracy) * (Math.log(1/confidence)  + Math.log(2)*(getConjecturesAnswered() + 1));
		return (int) Math.ceil(ri);
	}
	
	public String generateString(ArrayList<Character> alphabet) {
		String output = "";
		int letterPos;
		Random rand = new Random();
		int size = rand.nextInt(15) + 1;
		
		for (int i=0; i<size; i++) {
			letterPos = rand.nextInt(alphabet.size());
			output = output + alphabet.get(letterPos);
		}
		return output;
	}
	
	
}
