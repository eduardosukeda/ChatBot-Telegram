package br.com.java.java_bot_telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class JavaBotTelegram extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {

//            System.out.println(update.getMessage().getText());
//            System.out.println(update.getMessage().getFrom().getFirstName() );

		String command = update.getMessage().getText();

		SendMessage message = new SendMessage();

		if (command.equals("/myname")) {

			System.out.println(update.getMessage().getFrom().getFirstName());

			message.setText(update.getMessage().getFrom().getFirstName());
		}

		if (command.equals("/mylastname")) {

			System.out.println(update.getMessage().getFrom().getLastName());
			message.setText(update.getMessage().getFrom().getLastName());
		}

		if (command.equals("/myfullname")) {
			System.out.println(
					update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
			message.setText(
					update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
		}

		message.setChatId(update.getMessage().getChatId());

		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	public String getBotUsername() {
		return "java_bot_telegram";
	}

	public String getBotToken() {
		return "980607609:AAEGRd5uZ6OGbZhU9rdDnrjqaqHtgh5vkxI";
	}
}