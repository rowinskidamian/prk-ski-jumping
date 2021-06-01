package prk.ski.jumping.controller.database;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.DBOperationsDao;
import prk.ski.jumping.model.dao.impl.DBOperationsDaoDefault;

import java.io.IOException;

/**
 * @author RadosławParol
 */

@WebServlet(name = "DatabaseAdminController", value = "/database_admin")
public class DatabaseAdminController extends HttpServlet {

    private DBOperationsDao dbOperations = new DBOperationsDaoDefault();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int resultsNumber = dbOperations.getTotalTournamentNumber();
            request.setAttribute("nazwa", resultsNumber);
        } catch (DataBaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("database_admin.jsp").forward(request, response);
    }
    // jak możesz to zrób stronkę - widok, z tabelką opcji do wyboru:

    // opcje w menu:
    // Wgraj dużo danych - endpoint /database_init
    // Wgraj małą partię - endpoint /database_load_small?maxTournaments=10 /wgra dziesięć
    // Wgraj minimalną partię - endpoint /database_load_small / bez żadnego parametru wgra 5 turniejów i wyniki
    // Wyczyść bazę danych - endpoint /database_clean (przenosi na stronę z pytaniem o potwierdzenie, a później kasuje)

    // ten kontroller też trzeba dokończyć, tak aby dodatkowo wyświetlał liczbę wszystkich wyników skoczków w bazie
    // oraz łączną liczbę turniejów, np. 10 turniejów to ok 800 wyników w bazie (po 80 na turniej)
    //metody do pobierania z bazy wyników są tutaj:
//     DBOperationsDao dbOperations = new DBOperationsDaoDefault();
    // int getTotalJumperResultsNumber() throws DataBaseException;
    //    int getTotalTournamentNumber() throws DataBaseException;
}
