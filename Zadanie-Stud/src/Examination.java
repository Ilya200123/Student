
import java.util.*;

public interface Examination {

    Map<String,Score> item = new HashMap<>();
    Map<String,Score> item2 = new HashMap<>();
    Map<String, Integer> people = new HashMap<>();

    Map<String,Map<String,Integer>> Popitka = new HashMap<>();

    void addScore(Score score);

    Score getScore(String name, String subject) throws ItemNotFaundExeption;

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();

    void allGetList(List<Score> score1);
}
