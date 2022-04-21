package gudthing.serializability;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    static String fileName = "t1t2.txt";
    static String testString = fileName.equals("t2t1.txt") ? "2->1\n" : "1->2\n";
    public static void main(String[] args) {
        try {
            var scheduleArrayList = readLine();

            for (int i = 0; i < scheduleArrayList.size(); i++) {
                String scheduleSTR = scheduleArrayList.get(i).replace("(","");
                scheduleSTR = scheduleSTR.replace(")","");
                String[] schedule = scheduleSTR.split(" ");
                Schedule s = new Schedule(schedule);

                String answer = s.precedenceGraph();

                if(answer.equals(testString)) {
                    System.out.println("-------------------------------");
                    String[] printSchedule = sanitizeschedule(schedule);
                    String printString = Arrays.toString(printSchedule);
                    System.out.println(printString + ":   "+answer);
                    System.out.println("-------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading");
        }


    }

    public static ArrayList<String> readLine() throws Exception {
        List<String> lines = Collections.emptyList();

        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // reading text file into ArrayList in Java 6
        BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> listOfLines = new ArrayList<>();

        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }

        bufReader.close();
        return listOfLines;
    }

    public static String[] sanitizeschedule(String[] schedule) {
        String[] res = new String[schedule.length];

        for (int i=0; i<schedule.length; i++) {
            String ans = schedule[i].replace("X", "(X)");
            ans = ans.replace("Y", "(Y)");
            ans = ans.replace("x", "(x)");
            ans = ans.replace("y", "(y)");

            res[i] = ans;
        }

        return res;
    }
}
