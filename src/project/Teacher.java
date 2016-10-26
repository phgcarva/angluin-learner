package project;

import java.util.ArrayList;

public abstract class Teacher {
	
	protected ArrayList<String> elements;
	protected int iteration;
	
	public abstract boolean answerMembershipQuery(String s);
	
	public boolean answerConjecture(DFA dfa) {
		
	}
	
	public void generateNewItems() {
		
		if (iteration == 0) {
			elements.add("aa");
		} else {
			elements.add("aa" + elements.get(elements.size() - 1));
		}
		
		iteration++;
	}
	
	public void generateMoreIterations(int numberOfIterations) {
		for (int i=0; i<numberOfIterations; i++)
			generateNewItems();		
	}
	
	public String getLastElement() {
		if (elements.size() > 0)
			return elements.get(elements.size() - 1);
		else
			return "";
	}
	
	
}
