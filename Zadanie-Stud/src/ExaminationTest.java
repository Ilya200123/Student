import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExaminationTest  {
    Examination examination;

    @BeforeEach
    void setUp() {

        examination = new ExaminationImpl();
    }

    @org.junit.jupiter.api.Test
    void addScore() throws ItemNotFaundExeption {

        Score score = new Score("Iyal","matan",4);
        examination.addScore(score);
        Score actual = examination.getScore(score.name(),score.subject());
        Assertions.assertEquals(actual,score);

    }

    @org.junit.jupiter.api.Test
    void getScore() throws ItemNotFaundExeption {
        Assertions.assertThrows(ItemNotFaundExeption.class,() -> examination.getScore("6d","j"));
    }

    @org.junit.jupiter.api.Test
    void getAverageForSubject() throws ItemNotFaundExeption { //• вывод средней оценки по предмету, вывод тех студентов, кто сдавал более одного раза

        Score score0 = new Score("Ilya", "math", 2);
        Score score1 = new Score("Ivan", "physics", 2);
        Score score2 = new Score("Vlad", "math", 3);
        Score score3 = new Score("George", "physics", 4);
        Score score4 = new Score("Julie", "russian", 5);
        Score score5 = new Score("Ira", "english", 5);
        Score score6 = new Score("Ira", "russian", 3);
        Score score7 = new Score("Vlad", "english", 5);
        Score score8 = new Score("Vlad", "physics", 3);
        Score score9 = new Score("Vlad", "math", 5);
        Score score10 = new Score("Ilya", "math", 8);
        Score score11 = new Score("Julie", "russian", 3);
        Score score12 = new Score("Ivan", "physics", 5);
        Score score13 = new Score("George", "physics", 2);
        Score score14 = new Score("George", "physics", 5);

        ArrayList<Score> scoreList = new ArrayList<>();
        scoreList.add(score0);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        scoreList.add(score5);
        scoreList.add(score6);
        scoreList.add(score7);
        scoreList.add(score8);
        scoreList.add(score9);
        scoreList.add(score10);
        scoreList.add(score11);
        scoreList.add(score12);
        scoreList.add(score13);
        scoreList.add(score14);

        Map<String, ArrayList<Score>> scoreMap = new HashMap<>();
        for (Score score : scoreList) {
            if (!scoreMap.containsKey(score.subject())) {
                ArrayList<Score> currentScoreList = new ArrayList<>();
                currentScoreList.add(score);
                scoreMap.put(score.subject(), currentScoreList);
            } else {
                ArrayList<Score> example;
                example=scoreMap.get(score.subject());
                example.add(score);
                scoreMap.put(score.subject(),example);
            }
        }

        ArrayList<String> listOfSubjects = new ArrayList<>();
        for (String subdgekt:scoreMap.keySet()){

            listOfSubjects.add(subdgekt);

        }

        Map<String, Integer> answerHashMap = new HashMap<>();

        for (String subject : listOfSubjects) {
            Map<String, Integer> counterHashMap = new HashMap<>();
            ArrayList<Score> scoreList1 = scoreMap.get(subject);
            for (Score score : scoreList1) {
                if (!counterHashMap.containsKey(score.name())) {
                    counterHashMap.put(score.name(), 1);
                } else {
                    Integer val = counterHashMap.get(score.name());
                    val++;
                    counterHashMap.put(score.name(), val);
                }
            }

            Integer summ_of_score =0;
            Integer num_of_students = 0;

            for (Score score : scoreList1) {
                if (counterHashMap.get(score.name()) > 1) {
                    summ_of_score += score.score();
                    num_of_students++;
                } else if (counterHashMap.get(score.name()) == 1) {
                    System.out.println("The student named - "+ score.name() + " did not retake this course -  " + score.subject());
                    num_of_students =1;
                }
            }
            summ_of_score = summ_of_score  / num_of_students;

            answerHashMap.put(subject, summ_of_score);
        }
        System.out.println(answerHashMap);
    }


    @org.junit.jupiter.api.Test
    void multipleSubmissionsStudentNames() {


        Score score0 = new Score("Ilya", "math", 2);
        Score score1 = new Score("Ivan", "physics", 2);
        Score score2 = new Score("Vlad", "math", 3);
        Score score3 = new Score("George", "physics", 4);
        Score score4 = new Score("Julie", "russian", 5);
        Score score5 = new Score("Ira", "english", 5);
        Score score6 = new Score("Ira", "russian", 3);
        Score score7 = new Score("Vlad", "english", 5);
        Score score8 = new Score("Vlad", "physics", 3);
        Score score9 = new Score("Vlad", "math", 5);
        Score score10 = new Score("Ilya", "math", 8);
        Score score11 = new Score("Julie", "russian", 3);
        Score score12 = new Score("Ivan", "physics", 5);
        Score score13 = new Score("George", "physics", 2);
        Score score14 = new Score("George", "physics", 5);


        ArrayList<Score> scoreList = new ArrayList<>();
        scoreList.add(score0);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        scoreList.add(score5);
        scoreList.add(score6);
        scoreList.add(score7);
        scoreList.add(score8);
        scoreList.add(score9);
        scoreList.add(score10);
        scoreList.add(score11);
        scoreList.add(score12);
        scoreList.add(score13);
        scoreList.add(score14);

        System.out.println(Cash.main(scoreList));

    }

    @org.junit.jupiter.api.Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() { //• вывод последних пяти студентов, сдавших на отлично

        Score score0 = new Score("Ilya", "math", 2);
        Score score1 = new Score("Ivan", "physics", 2);
        Score score2 = new Score("Vlad", "math", 3);
        Score score3 = new Score("George", "physics", 4);
        Score score4 = new Score("Julie", "russian", 5);
        Score score5 = new Score("Ira", "english", 5);
        Score score6 = new Score("Ira", "russian", 3);
        Score score7 = new Score("Vlad", "english", 5);
        Score score8 = new Score("Vlad", "physics", 3);
        Score score9 = new Score("Vlad", "math", 5);
        Score score10 = new Score("Ilya", "math", 5);
        Score score11 = new Score("Julie", "russian", 3);
        Score score12 = new Score("Ivan", "physics", 5);
        Score score13 = new Score("George", "physics", 2);
        Score score14 = new Score("George", "physics", 5);

        ArrayList<Score> scoreList = new ArrayList<>();
        scoreList.add(score0);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        scoreList.add(score5);
        scoreList.add(score6);
        scoreList.add(score7);
        scoreList.add(score8);
        scoreList.add(score9);
        scoreList.add(score10);
        scoreList.add(score11);
        scoreList.add(score12);
        scoreList.add(score13);
        scoreList.add(score14);

        Set<String> uniqueElements = new LinkedHashSet<>();

        for (Score score:scoreList){
            if (score.score()==5){
                uniqueElements.add(score.name());
            }
        }
        int a = uniqueElements.size();
        for (String stud:uniqueElements){
            a--;
            if (a<5){
                System.out.println(stud);
            }

        }

    }

    @org.junit.jupiter.api.Test
    void getAllScores() {
        Score score0 = new Score("Ilya", "math", 2);
        Score score1 = new Score("Ivan", "physics", 2);
        Score score2 = new Score("Vlad", "math", 3);
        Score score3 = new Score("George", "physics", 4);
        Score score4 = new Score("Julie", "russian", 5);
        Score score5 = new Score("Ira", "english", 5);
        Score score6 = new Score("Ira", "russian", 3);
        Score score7 = new Score("Vlad", "english", 5);
        Score score8 = new Score("Vlad", "physics", 3);
        Score score9 = new Score("Vlad", "math", 5);
        Score score10 = new Score("Ilya", "math", 5);
        Score score11 = new Score("Julie", "russian", 3);
        Score score12 = new Score("Ivan", "physics", 5);
        Score score13 = new Score("George", "physics", 2);
        Score score14 = new Score("George", "physics", 5);

        ArrayList<Score> scoreList = new ArrayList<>();
        scoreList.add(score0);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);
        scoreList.add(score4);
        scoreList.add(score5);
        scoreList.add(score6);
        scoreList.add(score7);
        scoreList.add(score8);
        scoreList.add(score9);
        scoreList.add(score10);
        scoreList.add(score11);
        scoreList.add(score12);
        scoreList.add(score13);
        scoreList.add(score14);

        Set<String> ScorSubject = new HashSet<>();

        for (Score score:scoreList){

            ScorSubject.add(score.subject());

        }

        System.out.println(ScorSubject);

    }

    
}