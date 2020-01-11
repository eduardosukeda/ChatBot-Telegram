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

import br.com.fiap.constant.SystemCons;
import br.com.fiap.service.LeituraTextoService;

public class Main {

	public static void main(String[] args) throws IOException {

		TelegramBot bot = TelegramBotAdapter.build(SystemCons.TELEGRAM_TOKEN);
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

				switch (command) {

				case (SystemCons.CMD_AJUDA):

					List<String> commands = new ArrayList<String>();

					commands.add(SystemCons.CMD_LOCALIZACAO);
					commands.add(SystemCons.CMD_ALIMENTACAO);
					commands.add(SystemCons.CMD_SUPLEMENTOS_ALIMENTOS_ESPECIAIS);
					commands.add(SystemCons.CMD_ARTIGOS_ESPORTIVOS);
					commands.add(SystemCons.CMD_BRINQUEDOS_GAMES);
					commands.add(SystemCons.CMD_CALCADOS_BOLSAS_ACESSORIOS);
					commands.add(SystemCons.CMD_DECORACAO);
					commands.add(SystemCons.CMD_DROGARIA);
					commands.add(SystemCons.CMD_ELETROELETRONICOS);
					commands.add(SystemCons.CMD_JOIAS_BIJUTERIAS);
					commands.add(SystemCons.CMD_LIVRARIA_PAPELARIA);
					commands.add(SystemCons.CMD_LOJAS_DEPARTAMENTO);
					commands.add(SystemCons.CMD_MODA_FEMININA);
					commands.add(SystemCons.CMD_MODA_INFANTIL);
					commands.add(SystemCons.CMD_MODA_INTIMA);
					commands.add(SystemCons.CMD_MODA_MASCULINA);
					commands.add(SystemCons.CMD_MODA_PRAIA_FITNESS);
					commands.add(SystemCons.CMD_MODA_UNISSEX);
					commands.add(SystemCons.CMD_MOVEIS);
					commands.add(SystemCons.CMD_OTICAS_OCULOS);
					commands.add(SystemCons.CMD_PERFUMARIA_COSMETICOS);
					commands.add(SystemCons.CMD_PETSHOP);
					commands.add(SystemCons.CMD_PRESENTES_ARTIGOS_PARA_O_LAR);

					for (int i = 0; i < commands.size(); i++) {
						lista += commands.get(i) + "\n";
					}

					String emoji = SystemCons.EMOJI;

					sendResponse = bot.execute(new SendMessage(update.message().chat().id(),
							SystemCons.MSG_BOAS_VINDAS + emoji + " \n\n" + lista));

				case (SystemCons.CMD_LOCALIZACAO):
					baseResponse = bot.execute(new SendVenue(update.message().chat().id(), -23.506530f, -46.718483f,
							SystemCons.TIETE_PLAZA_SHOPPING, SystemCons.TIETE_PLAZA_SHOPPING_LOCALIZACAO));
					break;

				case (SystemCons.CMD_ALIMENTACAO):
					LeituraTextoService txtAlimentacao = new LeituraTextoService("ALIMENTACAO");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_SUPLEMENTOS_ALIMENTOS_ESPECIAIS):
					LeituraTextoService txtSuplementos = new LeituraTextoService("ALIMENTOS_ESPECIAIS_E_SUPLEMENTOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_ARTIGOS_ESPORTIVOS):

					LeituraTextoService txtEsporte = new LeituraTextoService("ARTIGOS_ESPORTIVOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_BRINQUEDOS_GAMES):

					LeituraTextoService txtGames = new LeituraTextoService("BRINQUEDOS_E_GAMES");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_CALCADOS_BOLSAS_ACESSORIOS):

					LeituraTextoService txtCalcados = new LeituraTextoService("CALCADOS_BOLSAS_E_ACESSORIOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_DECORACAO):

					LeituraTextoService txtDecoracao = new LeituraTextoService("DECORACAO");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_DROGARIA):

					LeituraTextoService txtDrogaria = new LeituraTextoService("DROGARIA");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_ELETROELETRONICOS):

					LeituraTextoService txtEletro = new LeituraTextoService("ELETROELETRONICOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_JOIAS_BIJUTERIAS):

					LeituraTextoService txtJoias = new LeituraTextoService("JOIAS_E_BIJUTERIAS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_LIVRARIA_PAPELARIA):

					LeituraTextoService txtLivraria = new LeituraTextoService("LIVRARIA_E_PAPELARIA");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_LOJAS_DEPARTAMENTO):

					LeituraTextoService txtLojas = new LeituraTextoService("LOJAS_DE_DEPARTAMENTO");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_FEMININA):

					LeituraTextoService txtModaF = new LeituraTextoService("MODA_FEMININA");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_INFANTIL):

					LeituraTextoService txtModaInf = new LeituraTextoService("MODA_INFANTIL");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_INTIMA):

					LeituraTextoService txtModaInt = new LeituraTextoService("MODA_INTIMA");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_MASCULINA):

					LeituraTextoService txtModaMasc = new LeituraTextoService("MODA_MASCULINA");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_PRAIA_FITNESS):

					LeituraTextoService txtModaPraia = new LeituraTextoService("MODA_PRAIA_E_FITNESS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MODA_UNISSEX):

					LeituraTextoService txtModaUni = new LeituraTextoService("MODA_UNISSEX");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_MOVEIS):

					LeituraTextoService txtMoveis = new LeituraTextoService("MOVEIS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_OTICAS_OCULOS):

					LeituraTextoService txtOticas = new LeituraTextoService("OTICAS_E_OCULOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_PERFUMARIA_COSMETICOS):

					LeituraTextoService txtPerfumaria = new LeituraTextoService("PERFUMARIA_E_COSMETICOS");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_PETSHOP):

					LeituraTextoService txtPetshop = new LeituraTextoService("PETSHOP");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				case (SystemCons.CMD_PRESENTES_ARTIGOS_PARA_O_LAR):

					LeituraTextoService txtPresentes = new LeituraTextoService("PRESENTES_E_ARTIGOS_PARA_O_LAR");
					sendResponse = bot
							.execute(new SendMessage(update.message().chat().id(), LeituraTextoService.getTexto()));
					break;

				default:
					break;
				}

			}
		}
	}
}