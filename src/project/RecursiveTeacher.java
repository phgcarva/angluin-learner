package project;

import java.util.ArrayList;

public class RecursiveTeacher extends Teacher{

	public RecursiveTeacher() {
		super();
		elements = new ArrayList<>();
	}
	
	public boolean answerMembershipQuery(String s) {
		
		if (s.length() > getLastElement().length())
			generateMoreIterations((s.length() - getLastElement().length())/2);
		
		if (elements.contains(s))
			return true;
		
		return false;
		
	}
	
	@Override
	public boolean answerConjecture(DFA dfa) {
		String test = "";
		boolean output = true;
		this.tickConjectures();
		int limit = limitIterations();
		System.out.println(limit);
		for (int i=0; i<limit; i++) {
			test = generateString(dfa.getAlphabet());
			
			if (dfa.isAccepted(dfa.readString(dfa.getInitialState(), test)) != answerMembershipQuery(test))
				output = false;
		}
		
		
		return output;
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
