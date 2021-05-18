package prk.ski.jumping.controller.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// link "https://www.fis-ski.com/DB/general/statistics.html?statistictype=positions&positionstype=position&offset=250&sectorcode=JP&seasoncode=&categorycode=WC&gendercode=&competitornationcode=&place=&nationcode=&position=4&disciplinecode="

/**
 * @author RadosławParol
 */

public class TournamentParser {

    public List<TournamentWorldCup> getAll() {
        return null;
    }

    public List<TournamentWorldCup> getTournamentList(String URL) throws IOException {
        List<TournamentWorldCup> listOfTournaments = new ArrayList<>();

        Document document = Jsoup.connect(URL).get();
        Elements cupElements = document.getElementsByClass("table-row table-row_theme_small");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        for (Element e : cupElements) {

            Document cupElement = Jsoup.parse(e.toString());

            Elements dateElement = cupElement.getElementsByClass("bb-xs pb-xs-1_1 pl-xs-1 g-xs-6 g-sm-3 g-md-2 g-lg-2 justify-left");
            Elements placeElement = cupElement.getElementsByClass("bb-xs pb-xs-1_1 g-xs-11 g-sm-6 g-md-4 g-lg-4 justify-left bold");
            Elements genderElement = cupElement.getElementsByClass("split-row__item split-row__item_text_medium justify-center reset-padding bold");


            LocalDate date = LocalDate.parse(dateElement.text(), formatter);
            String place = placeElement.text();
            String gender = genderElement.text();
            String link = placeElement.attr("href");


            if(checkIfTournamentIsGroup(link)) {
                TournamentWorldCup cup = new TournamentWorldCup(123, date, place, gender, link);
                listOfTournaments.add(cup);
            };

        }
        return listOfTournaments;
    }

    public boolean checkIfTournamentIsGroup(String link) throws IOException {
        Document cupDocument = Jsoup.connect(link).get();
        Elements cupElements = cupDocument.getElementsByClass("event-header__kind");

        if (cupElements.text().contains("Team")) {
            return false;
        }
        return true;
    }
}
