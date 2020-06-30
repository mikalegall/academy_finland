package yoga.kulatantra;

import java.util.List;
//import java.util.Collections;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ShalaRelaxBot extends TelegramLongPollingBot {

	List<ReplieAnswer> response = InitResponse.createReplies();

	int i = 0;

	@Override
	public void onUpdateReceived(Update update) {
//		Collections.shuffle(response);

//		System.out.println("*************************   " + update + "   *************************");

		String replieForString;
		String replieForPhoto;
		String replieForVideo;
		String replieForDocument;
		
		if (i < response.size()) {
			ReplieAnswer tempVariable = response.get(i);
			i++;
			replieForString = tempVariable.getResponseForString().replace("TELEGRAM_FirstName", update.getMessage().getFrom().getFirstName());
			replieForPhoto  = tempVariable.getResponseForPhoto();
			replieForVideo = tempVariable.getResponseForVideo();
			replieForDocument = tempVariable.getResponseForDocument();
		} else {
			i = 0;
			ReplieAnswer tempVariable = response.get(i);
			i++;
			replieForString = tempVariable.getResponseForString().replace("TELEGRAM_FirstName", update.getMessage().getFrom().getFirstName());
			replieForPhoto  = tempVariable.getResponseForPhoto();
			replieForVideo = tempVariable.getResponseForVideo();
			replieForDocument = tempVariable.getResponseForDocument();
			}

		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
			String tempVariable = update.getMessage().getText();
			String tempVariableForName = update.getMessage().getFrom().getFirstName();
			if (tempVariable.equals("/start")) {
				message.setChatId(update.getMessage().getChatId()).setText(
						"Nyt voit " + tempVariableForName + " kuvata minulle yhdellä sanalla sitä, mikä kuvastaa tätä kuluvaa hetkeä mielestäsi osuvimmin juuri nyt 🕉");
			} else {
				message.setChatId(update.getMessage().getChatId()).setText(replieForString);
			}

			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			tempVariable = null;
			tempVariableForName = "";
		}

		// We check if the update has a message and onko kyseessä kuvaviesti
		if (update.hasMessage() && update.getMessage().hasPhoto()) {
			SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields

			if (update.getMessage().getCaption() != null) {
				message.setChatId(update.getMessage().getChatId())
						.setText("Lorem (foo '"
								+ update.getMessage().getCaption() + "' bar)");
			} else {
				message.setChatId(update.getMessage().getChatId()).setText(replieForPhoto);
			}
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		// We check if the update has a message and onko kyseessä video
		if (update.hasMessage() && update.getMessage().hasVideo()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId()).setText(replieForVideo);
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		// We check if the update has a message and onko kyseessä tiedosto
		if (update.hasMessage() && update.getMessage().hasDocument()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId()).setText(replieForDocument);
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String getBotUsername() {
		return "@ShalaRelaxBot";
	}

	@Override
	public String getBotToken() {
		return "TantraOnAgamanEsoteerinenPuoli";
	}
}