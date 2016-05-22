
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
* */
public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        BufferedReader Reader = null;

        String query = "";
        try {
            Reader = new BufferedReader(new InputStreamReader(System.in));
            query = Reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Reader!=null) Reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(semaphore.getColor(Integer.parseInt(query)));
    }

    public static class Semaphore {
        int[] interval = {2, 3, 5};
        String[] color = {"Зеленый", "Желтый", "Красный"};

        String getColor(int minutes) {
            int summInterval = interval[0] + interval[1] + interval[2];
            int ostatok = minutes % summInterval;
            if (ostatok <= interval[0]) return color[0];
            if (ostatok >= interval[1] + interval[2]) return color[2];
            return color[1];
        }
    }

}

