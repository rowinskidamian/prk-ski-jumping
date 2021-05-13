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
		CountryAnalyzer ctr = new CountryAnalyzer();

		TournamentJumperResult tjr1 = new TournamentJumperResult();

		tjr1.setId(1);
		tjr1.setAthleteName("Marek");

	}

}
