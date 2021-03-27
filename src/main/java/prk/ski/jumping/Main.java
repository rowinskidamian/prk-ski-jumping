package prk.ski.jumping;

import prk.ski.jumping.controller.analyzer.CountryAnalyzer;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.controller.parser.ResultParser;
import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParsingException {
		String url = "https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5837";
		System.out.println("Wyniki jednego:");

		ResultParser resultParser = new ResultParser();
		CountryAnalyzer analyzer = new CountryAnalyzer();

		List<TournamentJumperResult> testingList = resultParser.getResultListFor(url);

		List<Country> listOfCountries = analyzer.getCountryAnalysis(testingList);

		for (Country c : listOfCountries) {
			System.out.println(c.getName() + " jest null bo nie ma pola \"origin\" w TournamentJumperResult, trzeba też zrobić żeby ustawiło ten origin w ResultParserze");
			System.out.print(c.getGoldMedals() + " ");
			System.out.print(c.getSilverMedals() + " ");
			System.out.print(c.getBronzeMedals() + " ");
			System.out.print(c.getTotalPoints() + " ");
		}



	}

}
