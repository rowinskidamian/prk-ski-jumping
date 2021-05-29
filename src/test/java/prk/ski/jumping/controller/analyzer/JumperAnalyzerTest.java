package prk.ski.jumping.controller.analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prk.ski.jumping.model.domain.Jumper;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DamianRowinski
 */

class JumperAnalyzerTest {
    private JumperAnalyzer jumperAnalyzer;
    private Jumper givenJumper;
    private String athleteName;

    @BeforeEach
    void init() {
        jumperAnalyzer = new JumperAnalyzer();
        givenJumper = new Jumper();
        athleteName = "Kamil Stoch";
        givenJumper.setAthleteName(athleteName);
    }

    @Nested
    class GetJumperNamesListForTournament {

    }

    @Nested
    class GetJumperAnalysisFor {

    }

    @Nested
    class GetCurrentJumperTests {

    }

    @Nested
    class AddJumperToMapIfNotPresentTests {

        @Test
        void givenMapAndAthleteNameShouldReturnMapWithJumper() {
            Map<String, Jumper> jumperMap = new HashMap<>();

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            Jumper jumperAdded = jumperMap.get(athleteName);

            assertEquals(givenJumper, jumperAdded);
        }

        @Test
        void givenEmptyMapShouldReturnMapWithOneJumper() {
            Map<String, Jumper> jumperMap = new HashMap<>();
            int expectedSize = 1;

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int returnedMapSize = jumperMap.size();

            assertEquals(expectedSize, returnedMapSize);
        }

        @ParameterizedTest(name = "Given jumperMap size = {0} adding Jumper NOT present in map should return map size: {1}")
        @CsvSource({"2,3",
                "5,6",
                "10,11",
                "20,21"})
        void settingStartSizeJumperMapWhenAddingJumperShouldReturnIncrementedMap(int mapSize, int expectedMapSize) {
            Map<String, Jumper> jumperMap = new HashMap<>();
            for(int i=0; i<mapSize; i++) {
                Jumper j = new Jumper();
                String currentKeyName = String.valueOf(i);
                j.setAthleteName(currentKeyName);
                jumperMap.put(currentKeyName,j);
            }

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int outcomeSize = jumperMap.size();
            assertEquals(expectedMapSize, outcomeSize);
        }

        @ParameterizedTest(name = "Given jumperMap size = {0} adding Jumper present in map should return map size: {0}")
        @CsvSource({"3", "9", "7", "10"})
        void addingJumperPresentInPopulatedMapShouldNotAddJumper(int mapSize) {
            Map<String, Jumper> jumperMap = new HashMap<>();
            for(int i=0; i<mapSize-1; i++) {
                Jumper j = new Jumper();
                String currentKeyName = String.valueOf(i);
                j.setAthleteName(currentKeyName);
                jumperMap.put(currentKeyName,j);
            }
            jumperMap.put(athleteName, givenJumper);

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int outcomeSize = jumperMap.size();
            assertEquals(mapSize, outcomeSize);
        }

        @Test
        void givenMapWithSameJumperNameShouldNotReplaceCurrentJumper() {
            Map<String, Jumper> jumperMap = new HashMap<>();
            jumperMap.put(athleteName, givenJumper);
            Jumper addedJumper = new Jumper();
            addedJumper.setOrigin("TEST ORIGIN");
            addedJumper.setAthleteName(athleteName);

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);

            Jumper jumperPresentInMap = jumperMap.get(athleteName);

            assertNotEquals(addedJumper, jumperPresentInMap);
        }



    }
}