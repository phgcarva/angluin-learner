package project;

import java.util.ArrayList;

public class RecursiveTeacher extends Teacher{

	public RecursiveTeacher() {
		elements = new ArrayList<>();
	}
	
	public boolean answerMembershipQuery(String s) {
		
		if (s.length() > getLastElement().length())
			generateMoreIterations((s.length() - getLastElement().length())/2);
		
		if (elements.contains(s))
			return true;
		
		return false;
		
	}
	
	
}
