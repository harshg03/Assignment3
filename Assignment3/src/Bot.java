
import java.util.*;
public class Bot {
	String name;
	String currentInput;
	String currentOutput;
	float mood_score=0;
	float exchange_count=0;
	boolean keep_going=true;
	HashMap<String,String> responses=new HashMap<String,String>();
	ArrayList<String> endings=new ArrayList<String>();
	String[] bye_words= {"go","leave","bye","end"};
	String[] apologies={"I don't understand. Could you try phrasing it a different way?","I'm not sure what you mean by that.","Hmm. I'm not sure I can help with that. Anything else?","I'm sorry, I'm not smart enough to understand what you meant. Try saying something else?","I think I don't understand what you meant. Could you clarify?"};;
	String[] talk_to_me={"The silent treatment I see. Well I'm here if you need me.", "I can't help you if you don't talk to me!","You can tell me anything! Type in the text box when you feel ready"};
	Bot(){
		name="user";
	}
	
	public void start() {
		load();
		greet();
		talk();
		
	}
	public void talk() {
		while(keep_going) {
			getInput();
			exchange_count++;
			mood_score=mood_score+SentimentScorer.getScore(currentInput);
			if(check_goodbye()) {
				goodbye();
				break;
			}
			currentInput=Optimizer.getOptimized(currentInput);
			if(currentInput.trim().length()<1) {
				getOutput(talk_to_me[(int) (talk_to_me.length*Math.random())]);
				continue;
			}
			
			String response=getResponse();
			if(response=="ERR") {
				apologize();
				continue;
			}
			else
				getOutput(response);
			
			
			//TO DO randomly choose to ask user if they want affirmations, information or to leave using a random switch case
			int c=2;
			if(exchange_count>15) {
				c++;
				
			}
			switch((int) (c* Math.random())) {
			case 0:{
				
			}
				break;
			case 1:{
				;
				
			}
			break;
			case 2:{
				;
			}
			}
			
			if(exchange_count>10&&(mood_score/exchange_count)<2) {
				suggestHelp((int)(mood_score/exchange_count));
			}
			
		}
		
	}
	public void load() {
		responses.put("good", "I'm happy to hear that :D. Tell me more!");
		responses.put("fun", "Looks like things are going well! Tell me more!");
		responses.put("sad","I see you've been feeling a bit blue recently. Let's talk about it.");
		responses.put("hope","I want you to know it will get better");
		responses.put("afraid","I'm sure it feels scary, but you can get through this.");
		responses.put("sorry", "That's okay! Can I help you with anything else?");
		responses.put("yes", "Cool! What's next?");
		responses.put("suffering", "That sounds really difficult. I'm sorry you're going through that.");
		responses.put("die", "Hmm... That sounds really serious.");
		//TO DO load responses from text file instead of adding here
		
		
	}
	public void getInput() {
		// TO DO make it get input from GUI instead
		Scanner sc= new Scanner(System.in);
		setInput(sc.nextLine());
		
	}
	public void setInput(String input) {
		
		currentInput=input.toLowerCase();
	}
	public void getOutput(String s) {
		
		System.out.println(s);
		
	}
	public String getResponse() {
		for(String key:responses.keySet()) {
			if(exists_in_input(key)) {
				return(responses.get(key));
			}
		}
		return "ERR";
		
		
	}
	public boolean exists_in_input(String key) {
		StringTokenizer st=new StringTokenizer(currentInput);
		while(st.hasMoreTokens()) {
			String t=st.nextToken();
			if(LevenshteinDistance.getDistance(t, key)>0.75) {
				return true;
			}
		}
		return false;
	}
	
	public void apologize() {
		
		String resp=apologies[(int) (apologies.length*Math.random())];
		getOutput(resp);
		
	}
	public void greet() {
		getOutput("Hi! I'm Serenity! What's your name?");
		getInput();
		name=PoSTagger.getProperNoun(currentInput);
		getOutput("Nice to meet you "+(name.substring(0,1).toUpperCase()+name.substring(1))+" :) How's it going?");
		return;
		
	}
	public void inform() {
		switch((int)(mood_score/exchange_count)) {
		case 0:
			;
		case 1:
			;
		break;
		case 2:
			;
		break;
		case 3:
			;
		case 4:
			break;
			
		}
		
		
	}
	public void suggestHelp(int x) {
		//TO DO output help suggestions
		switch(x) {
		case 0: {
			//tell user to get urgent help
			;
		}
		break;
		case 1: {
			//tell user you are concerned and they should get help soon
		}
		}
	}
	public void affirm() {
		switch((int)(mood_score/exchange_count)) {
		case 0:
			;
		case 1:
			;
		break;
		case 2:
			;
		break;
		case 3:
			;
		case 4:
			break;
			
		}
		
		
	}
	public boolean check_goodbye() {
		for(String word: bye_words) {
			if(exists_in_input(word))
				return true;
		}
		return false;
		
		
		
	}
	public void goodbye() {
		keep_going=false;
		getOutput("It was great talking to you! Goodbye!");
		
		
	}
	

}
