import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BotTest {
	private final Bot test_Bot = new Bot();
	@Test
	void test_getInput() {
		test_Bot.setInput("HOW IS YOUR DAY GOING.");
		String output = test_Bot.currentInput;
		String expected_output = "how is your day going.";
		assertEquals(expected_output,output);
		fail("Not yet implemented");
	}
	
	// 
	@Test
	void test_getResponse() {
		String output = test_Bot.getResponse();
		String expected_output = "ERR";
		assertEquals(expected_output,output);
		fail("Not yet implemented");
	}
	
	@Test
	void test_check_goodbye() {
		test_Bot.currentInput = "bye";
		boolean output = test_Bot.check_goodbye();
		boolean expected_output = true;
		assertEquals(expected_output,output);
		fail("Not yet implemented");
	}
	@Test
	void test_goodbye() {
		test_Bot.goodbye();
		String output = test_Bot.currentOutput;
		String expected_output = "It was great talking to you! Goodbye!";
		assertEquals(expected_output,output);
		fail("Not yet implemented");
	}
	
	@

}
