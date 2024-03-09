import java.util.*;

public class ExaminationImpl implements Examination {

    @Override
    public void addScore(Score score) { //• добавить сдачу студента (в зачет идет только последняя сдача, хранить все сдачи студента по одному и тому же предмету не нужно)

        item.put(score.name(),score);
        item2.put(score.name(),score);

    }

    @Override
    public Score getScore(String name, String subject) throws ItemNotFaundExeption  {//• получить сдачу студента по имени, фамилии и предмету
        Score score = item.get(name);
        if (score == null){
            throw new  ItemNotFaundExeption(name);
        }
        System.out.println(score.score());
        int score1 = score.score();
        return score;

    }

    @Override
    public double getAverageForSubject(String subject) {//• вывод средней оценки по предмету  тех студентов, кто сдавал более одного раза
        return 0;
    }

    @Override
    public Set<String> multipleSubmissionsStudentNames() {
        return null;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() { //• вывод последних пяти студентов, сдавших на отлично


        return null;
    }

    @Override
    public Collection<Score> getAllScores() { //• вывод всех сданных предметов
        return null;
    }

    @Override
    public void allGetList(List<Score> items) {
        item.clear();
        for (Score score:items){
            
            addScore(score);

            getAverageForSubject(score.subject());
            piplAll(people);
        }

    }

    private void piplAll(Map<String, Integer> people) {

        System.out.println(people);

    }

}