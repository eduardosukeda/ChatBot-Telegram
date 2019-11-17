package br.com.java.java_bot_telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class JavaBotTelegram extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {

		String command = update.getMessage().getText();

		SendMessage message = new SendMessage();
		message.setChatId(update.getMessage().getChatId());

		if (command.equals("/ajuda")) {

			message.setText("Bem vindo a loja virtual, digite /comprar para começar !");
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		if (command.equals("/comprar")) {

			message.setText("Qual tipo de produto gostaria de comprar ? ?");

			String[] arrayProdutos = { "1 - Notebook", "2 - Desktop" };

			for (int i = 0; i < arrayProdutos.length; i++) {
				message.setText(arrayProdutos[i]);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}

		if (command.equals("1")) {

			message.setText("Qual marca de notebook gostaria de comprar ?");
			Notebook marca1 = new Notebook("Dell");
			Notebook marca2 = new Notebook("Samsung");

			String[] arrayNotebook = { marca1.getDescricao(), marca2.getDescricao() };

			for (int i = 0; i < arrayNotebook.length; i++) {
				message.setText(arrayNotebook[i]);
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getBotUsername() {
		return "java_bot_telegram";
	}

	public String getBotToken() {
		return "980607609:AAEGRd5uZ6OGbZhU9rdDnrjqaqHtgh5vkxI";
	}
}