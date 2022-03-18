import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GUItest {
	private final Bot test_Bot = new Bot();

	@Test
	void test_events() {
		test_Bot.name = "";
		String expected = "Serenity: I'm going to need your name before we continue!";
		String actual = test_Bot.currentOutput;
		assertEquals(expected, actual);

		test_Bot.name = "latisha";
		expected = "Serenity: Nice to meet you latisha :) How's it going?";
		actual = test_Bot.currentOutput;
		assertEquals(expected, actual);

	}
}