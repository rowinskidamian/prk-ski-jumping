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

    public List<TournamentWorldCup> getSmallTournamentList(String URL, int maxResults) throws IOException {
        List<TournamentWorldCup> listOfTournaments = new ArrayList<>();

        Document document = Jsoup.connect(URL).get();
        Elements cupElements = document.getElementsByClass("table-row table-row_theme_small");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        for (int i = 0; i < maxResults; i++) {
            getTournamentAndAddToList(listOfTournaments, formatter, cupElements.get(i));
        }
        return listOfTournaments;
    }


    public List<TournamentWorldCup> getTournamentList(String URL) throws IOException {
        /**
         * Declared a List of TournamentWorldCup which will be returned at the end of method
         */
        List<TournamentWorldCup> listOfTournaments = new ArrayList<>();

        /**
         * Declared a Document class object which connects to a given URL with the use of Jsoup library
         */
        Document document = Jsoup.connect(URL).get();

        /**
         * Declared a Element class object which extracts every element with a given class from the document connected to a website
         */
        Elements cupElements = document.getElementsByClass("table-row table-row_theme_small");

        /**
         * Declared a date formatter which will be used in transforming string that contains data to a LocalDate class object
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");

        /**
         * Looped over every element in the cupElements object
         */
        for (Element e : cupElements) {
            /**
             * Created smaller Document class object from list of Elements
             */
            Document cupElement = Jsoup.parse(e.toString());
            getTournamentAndAddToList(listOfTournaments, formatter, e);

        }
        return listOfTournaments;
    }

    private void getTournamentAndAddToList(List<TournamentWorldCup> listOfTournaments, DateTimeFormatter formatter,
                                           Element element) throws IOException {
        Document cupElement = Jsoup.parse(element.toString());

            /**
             * Extracted a date, place and gender element by selecting given element with following classes
             */
            Elements dateElement = cupElement.getElementsByClass("bb-xs pb-xs-1_1 pl-xs-1 g-xs-6 g-sm-3 g-md-2 g-lg-2 justify-left");
            Elements placeElement = cupElement.getElementsByClass("bb-xs pb-xs-1_1 g-xs-11 g-sm-6 g-md-4 g-lg-4 justify-left bold");
            Elements genderElement = cupElement.getElementsByClass("split-row__item split-row__item_text_medium justify-center reset-padding bold");

            /**
             * Declared LocalDate object and initialised by parsing date from String object with the use of date formatter
             */
            LocalDate date = LocalDate.parse(dateElement.text(), formatter);

            /**
             * Declared a place String object and initialised with the text from placeElement for a given cupElement
             */
            String place = placeElement.text();
            /**
             * Declared a gender String object and initialised with the text from genderElement for a given cupElement
             */
            String gender = genderElement.text();
            /**
             * Declared a link String object and initialised with the href attribute from genderElement for a given cupElement
             */
            String link = placeElement.attr("href");

            /**
             * Checked if the given cupElement represent a group tournament
             */
            if(checkIfTournamentIsGroup(link)) {
                /**
                 * Declared a TournamentWorldCup class object and initialised with previously gathered data
                 */
                TournamentWorldCup cup = new TournamentWorldCup(123, date, place, gender, link);
                System.out.println("Parsed: " + cup);
                /**
                 * Added tournament to the list of tournaments
                 */
                listOfTournaments.add(cup);
            };

    }

    /**
     * This is a helper method that checks if the tournament is a group tournament
     * @param link This link represents the url to a tournament world cup details on a website
     * @return boolean Whether the tournament is or is not a group tournament
     * @throws IOException
     */
    public boolean checkIfTournamentIsGroup(String link) throws IOException {
        /**
         * Declared a Document class object which connects with a given url which represents tournament world cup details
         */
        Document cupDocument = Jsoup.connect(link).get();
        /**
         * Declared a Element class object which holds the text describing type of the tournament
         */
        Elements cupElements = cupDocument.getElementsByClass("event-header__kind");

        /**
         * Checking if the Element contains text "Team" and returning false if it doesnt
         */
        if (cupElements.text().contains("Team")) {
            return false;
        }
        /**
         * Returning true if given Element contain "Team" text
         */
        return true;
    }
}
