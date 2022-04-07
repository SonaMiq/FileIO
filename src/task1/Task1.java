package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {

    public static void count(String word) {
        BufferedReader bufferedReader=null;
        String s = "";
        int count = 0;
        int line=1;
        try {
            bufferedReader  =new BufferedReader(new FileReader("task1.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
             count=0;
            try {

                s = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(s==null)
                break;
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
               if(words[i].toLowerCase().equals(word)) {
                   count++;
               }
            }
            if(count>0){
                System.out.println("Line"+line+" - "+ count);
            }
            line++;
        }
        try {
            bufferedReader.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
