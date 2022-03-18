
public class BotTest {
	public static void main(String[] args) {
		Bot bot=new Bot();
		//bot.greet();
		bot.setInput("leaving");
		bot.optimizeInput();
		System.out.println(bot.check_goodbye());
		}

}
