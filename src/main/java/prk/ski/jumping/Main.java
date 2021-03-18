package prk.ski.jumping;

import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;

public class Main {

	public static void main(String[] args) {
		String testLinkTournamentResult = "https://www.fis-ski.com/DB/general/statistics.html?statistictype=positions&positionstype=position&offset=50&sectorcode=JP&seasoncode=&categorycode=WC&gendercode=&competitornationcode=&place=&nationcode=&position=4&disciplinecode=";
		System.out.println("Wszystkie turnamenty:");
		ParserService parserService = new ParserService();
		parserService.setTournamentWorldCupDao(new TournamentWorldCupDaoDefault());

		parserService.addTournamentListByURL(testLinkTournamentResult);
	}

}
