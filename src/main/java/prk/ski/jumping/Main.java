package prk.ski.jumping;

import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;

public class Main {

	public static void main(String[] args) {
		String testLinkJumperResult = "https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5809";
		System.out.println("Testowy start aplikacji");
		ParserService parserService = new ParserService();
		parserService.setTournamentJumperResultDao(new TournamentJumperResultDaoDefault());

		parserService.addResultListByTournamentURL(testLinkJumperResult);
	}

}
