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
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {



		TournamentWorldCupDao twcDao = new TournamentWorldCupDaoDefault();

		TournamentWorldCup twc = new TournamentWorldCup();

		System.out.println("Tworze twc: ");
		twc.setDate(LocalDate.parse("24-04-2002", DateTimeFormatter.ofPattern("dd-MM-uuuu")));
		twc.setPlace("Zakopane");
		twc.setGender("M");
		twc.setLink("link");
		System.out.println(twc.getDate());

		System.out.println("Do bazy: ");
		twcDao.create(twc);

	}

}
