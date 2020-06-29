package yoga.kulatantra;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Main {

	public static void main(String[] args) {
		// Example taken from https://github.com/rubenlagus/TelegramBotsExample
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new ShalaRelaxBot());
//			telegramBotsApi.registerBot(new ChannelHandlers());
//			telegramBotsApi.registerBot(new DirectionsHandlers());
//			telegramBotsApi.registerBot(new RaeHandlers());
//			telegramBotsApi.registerBot(new WeatherHandlers());
//			telegramBotsApi.registerBot(new TransifexHandlers());
//			telegramBotsApi.registerBot(new FilesHandlers());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}