package yoga.kulatantra;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ShalaRelaxBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {

//		System.out.println("*************************   " + update + "   *************************");

		
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
					String apu = update.getMessage().getText();
					if (apu.equals("/start")) {
					message
					.setChatId(update.getMessage().getChatId())
					.setText("Nyt voit kuvata minulle yhdellä sanalla sitä, mikä kuvastaa tätä kuluvaa hetkeä mielestäsi osuvimmin juuri nyt 🕉");			
					} else {
							message
							.setChatId(update.getMessage().getChatId())
							.setText("Kukkuluuruu, täällä ollaan! T: " + getBotUsername());
//			        		.setText(update.getMessage().getText());
					}
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			apu=null;
		}
		
		
		// We check if the update has a message and onko kyseessä kuvaviesti
		if (update.hasMessage() && update.getMessage().hasPhoto()) {
			SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields

					if (update.getMessage().getCaption() != null) {
					message		
					.setChatId(update.getMessage().getChatId())
					.setText("Ai sä lähetit mulle kuvan, kivaa! (paitsi, että toi sun laittama kuvaus '"
					+ update.getMessage().getCaption()
					+ "' oli vähän outo)");
					} else {
							message
							.setChatId(update.getMessage().getChatId())
							.setText("Ai sä lähetit mulle kuvan, kivaa!)");
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
					.setChatId(update.getMessage().getChatId())
					.setText("Mä en kattele videoita");
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}


		// We check if the update has a message and onko kyseessä tiedosto
		if (update.hasMessage() && update.getMessage().hasDocument()) {
			SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
					.setChatId(update.getMessage().getChatId())
					.setText("Älä lähettele mulle tiedostoja");
			try {
				execute(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	
	}


	@Override
	public String getBotUsername() {
		return "Shala Relax";
	}

	@Override
	public String getBotToken() {
		return "tantraOnAgamanEsoteerinenPuoli";
	}
}