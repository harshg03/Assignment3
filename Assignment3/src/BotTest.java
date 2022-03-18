import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BotTest {
	private final Bot test_Bot = new Bot();

	@Test
	void test_getInput() {
		test_Bot.setInput("HOW IS YOUR DAY GOING.");
		String output = test_Bot.currentInput;
		String expected_output = "how is your day going.";
		assertEquals(expected_output, output);
		fail("Not yet implemented");
	}

	//
	@Test
	void test_getResponse() {
		String output = test_Bot.currentOutput;
		String expected_output = "ERR";
		assertEquals(expected_output, output);
		fail("Not yet implemented");
	}

	@Test
	void test_check_goodbye() {
		test_Bot.currentInput = "bye";
		boolean output = test_Bot.check_goodbye();
		boolean expected_output = true;
		assertEquals(expected_output, output);
		fail("Not yet implemented");
	}

	@Test
	void test_goodbye() {
		test_Bot.goodbye();
		String output = test_Bot.currentOutput;
		String expected_output = "It was great talking to you! Goodbye!";
		assertEquals(expected_output, output);
		fail("Not yet implemented");
	}

	@Test
	void test_greet() {
		test_Bot.greet();
		String output = test_Bot.currentOutput;
		String expected_output = "Hi! I'm Serenity! What's your name?";
		assertEquals(expected_output, output);

	}

	@Test
	void test_exists_in_input() {
		String key = "depr"; // will try to match with depression
		test_Bot.currentInput = "depression";
		boolean expected_output = true;
		boolean output = test_Bot.exists_in_input(key);
		assertEquals(expected_output, output);
	}


}
