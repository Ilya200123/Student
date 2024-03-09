import java.util.*;

public class Cash {

    public static Map main(ArrayList<Score> scoreList) {
        ArrayList<Score> scoresSub =new ArrayList<>();
        Map<String, ArrayList<Score>> scoreMap = new HashMap<>();
        Map<String, Double> scoreMapRez = new HashMap<>();
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

        for (String subject:scoreMap.keySet()){
            double scor =0;
            int denominator =0;
            scoresSub = scoreMap.get(subject);
            for (Score f:scoresSub){
                scor = scor + f.score();
                denominator ++;
            }

            Double averageScore = scor/denominator ;
            scoreMapRez.put(subject,averageScore);

        }

        return scoreMapRez;
        }

    }




