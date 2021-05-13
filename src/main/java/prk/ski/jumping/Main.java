package prk.ski.jumping;

import prk.ski.jumping.controller.analyzer.CountryAnalyzer;
import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.controller.parser.ResultParser;
import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		CountryAnalyzer ctr = new CountryAnalyzer();

		TournamentJumperResult tjr1 = new TournamentJumperResult();
		TournamentJumperResult tjr2 = new TournamentJumperResult();

		tjr1.setId(1);
		tjr1.setAthleteName("Marek");
		tjr1.setOrigin("GER");
		tjr1.setRank(1);
		tjr1.setTotalPoints(200);
		tjr1.setTournamentId(1);

		tjr2.setId(2);
		tjr2.setAthleteName("Mareka");
		tjr2.setOrigin("JPN");
		tjr2.setRank(2);
		tjr2.setTotalPoints(201);
		tjr2.setTournamentId(1);

		List<TournamentJumperResult> list = new ArrayList<>();
		list.add(tjr1);
		list.add(tjr2);

		List<String> countries = new ArrayList<>();
		countries.add("GER");
		countries.add("JPN");

		List<Country> listOfCountries = ctr.getCountryAnalysis(list, countries);

		for (Country c : listOfCountries) {
			System.out.println(c.getName());
		}




	}

}
