package prk.ski.jumping.controller.parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultParser {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36";

    public List<TournamentJumperResult> getResultListFor(TournamentWorldCup tournamentWorldCup) throws ParsingException {
//        String link = tournamentWorldCup.getLink();
        return getResultListFor("link");
    }

    public List<TournamentJumperResult> getResultListFor(String resultURL) throws ParsingException {
        List<TournamentJumperResult> tjrList = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(resultURL)
                    .userAgent(USER_AGENT);

            Document document = connection.get();
            Element resultContainer = document.getElementById("events-info-results");
            Elements elementResultList = resultContainer.getElementsByClass("g-row container");

            for (Element element : elementResultList) {
                String athleteName = element.getElementsByClass("g-lg g-md g-sm g-xs justify-left bold").text();
                String rank = element.getElementsByClass
                        ("g-lg-1 g-md-1 g-sm-1 g-xs-2 justify-right pr-1 gray bold").text();
                String totalPoints = element.getElementsByClass
                        ("g-lg-2 g-md-2 g-sm-3 g-xs-5 justify-right blue bold ").text();
                TournamentJumperResult tjr = new TournamentJumperResult();
                tjr.setRank(Integer.parseInt(rank));
                tjr.setAthleteName(athleteName);
                tjr.setTotalPoints(Double.parseDouble(totalPoints));
                tjrList.add(tjr);
            }
            return tjrList;


        } catch (IOException ex) {
            ex.getStackTrace();
            throw new ParsingException("Błąd podczas wczytywania danych.");
        }


    }
}
