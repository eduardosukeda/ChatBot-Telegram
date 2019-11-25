package br.com.fiap.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendSticker;
import com.pengrad.telegrambot.request.SendVenue;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import br.com.fiap.util.LeituraTexto;

public class Main {

	public static void main(String[] args) throws IOException {

		TelegramBot bot = TelegramBotAdapter.build("1059025270:AAHjSVCuyai4SGy0OLf8hwFoecLFbZiwwgY");
		GetUpdatesResponse updatesResponse;
		SendResponse sendResponse;
		BaseResponse baseResponse;
		int m = 0;
		while (true) {

			updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));
			List<Update> updates = updatesResponse.updates();

			for (Update update : updates) {

				String command = update.message().text();
				String lista = "";

				m = update.updateId() + 1;

				if (command.equals("/ajuda")) {

					List<String> commands = new ArrayList<String>();

					commands.add("1 - /localizacao");
					commands.add("2 - /alimentacao");
					commands.add("3 - /suplementosAlimentosEspeciais");
					commands.add("4 - /artigosEsportivos");
					commands.add("5 - /brinquedosGames");
					commands.add("6 - /calcadosBolsasAcessorios");
					commands.add("7 - /decoracao");
					commands.add("8 - /drogaria");
					commands.add("9 - /eletroeletronicos");
					commands.add("10 - /joiasBijuterias");
					commands.add("11 - /livrariaPapelaria");
					commands.add("12 - /lojasDepartamento");
					commands.add("13 - /modaFeminina");
					commands.add("14 - /modaInfantil");
					commands.add("15 - /modaIntima");
					commands.add("16 - /modaMasculina");
					commands.add("17 - /modaPraiaFitness");
					commands.add("18 - /modaUnissex");
					commands.add("19 - /moveis");
					commands.add("20 - /oticasOculos");
					commands.add("21 - /perfumariaCosmeticos");
					commands.add("22 - /petshop");
					commands.add("23 - /presentesArtigosParaOLar");

					for (int i = 0; i < commands.size(); i++) {
						lista += commands.get(i) + "\n";
					}

					String emoji = "\ud83d\ude03";

					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							"Olá Bem vindo ao Tietê Plaza Shopping ! \n\nSou a Carol e estarei por aqui o tempo todo para te ajudar. Abaixo tenho todas as lojas separadas por categoria, é só clicar que te passo dados como localização e contato. Por onde podemos começar ? "
									+ emoji + " \n\n" + lista));
				}

				if (command.equals("/localizacao")) {
					baseResponse = bot.execute(new SendVenue(update.message().chat().id(), -23.506530f, -46.718483f,
							"Tietê Plaza Shopping",
							"Av. Raimundo Pereira de Magalhães, 1465 - Jardim Iris, São Paulo - SP, 05145-000"));
				}

				if (command.equals("/alimentacao")) {
					LeituraTexto txt = new LeituraTexto("ALIMENTACAO");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/suplementosAlimentosEspeciais")) {

					LeituraTexto txt = new LeituraTexto("ALIMENTOS_ESPECIAIS_E_SUPLEMENTOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/artigosEsportivos")) {

					LeituraTexto txt = new LeituraTexto("ARTIGOS_ESPORTIVOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/brinquedosGames")) {

					LeituraTexto txt = new LeituraTexto("BRINQUEDOS_E_GAMES");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/calcadosBolsasAcessorios")) {

					LeituraTexto txt = new LeituraTexto("CALCADOS_BOLSAS_E_ACESSORIOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/decoracao")) {

					LeituraTexto txt = new LeituraTexto("DECORACAO");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/drogaria")) {

					LeituraTexto txt = new LeituraTexto("DROGARIA");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/eletroeletronicos")) {

					LeituraTexto txt = new LeituraTexto("ELETROELETRONICOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/joiasBijuterias")) {

					LeituraTexto txt = new LeituraTexto("JOIAS_E_BIJUTERIAS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/livrariaPapelaria")) {

					LeituraTexto txt = new LeituraTexto("LIVRARIA_E_PAPELARIA");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/lojasDepartamento")) {

					LeituraTexto txt = new LeituraTexto("LOJAS_DE_DEPARTAMENTO");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaFeminina")) {

					LeituraTexto txt = new LeituraTexto("MODA_FEMININA");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaInfantil")) {

					LeituraTexto txt = new LeituraTexto("MODA_INFANTIL");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaIntima")) {

					LeituraTexto txt = new LeituraTexto("MODA_INTIMA");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaMasculina")) {

					LeituraTexto txt = new LeituraTexto("MODA_MASCULINA");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaPraiaFitness")) {

					LeituraTexto txt = new LeituraTexto("MODA_PRAIA_E_FITNESS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/modaUnissex")) {

					LeituraTexto txt = new LeituraTexto("MODA_UNISSEX");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/moveis")) {

					LeituraTexto txt = new LeituraTexto("MOVEIS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/oticasOculos")) {

					LeituraTexto txt = new LeituraTexto("OTICAS_E_OCULOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/perfumariaCosmeticos")) {

					LeituraTexto txt = new LeituraTexto("PERFUMARIA_E_COSMETICOS");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/petshop")) {

					LeituraTexto txt = new LeituraTexto("PETSHOP");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}

				if (command.equals("/presentesArtigosParaOLar")) {

					LeituraTexto txt = new LeituraTexto("PRESENTES_E_ARTIGOS_PARA_O_LAR");
					sendResponse = bot.execute(new SendMessage(update.message().chat().id(), LeituraTexto.getTexto()));
				}
			}
		}
	}
}