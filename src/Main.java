import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\output.txt");
        PrintStream out = new PrintStream(new FileOutputStream(file));
        System.setOut(out);
        Painter painter = new Painter();
        String input = new String(Files.readAllBytes(Paths.get("D:/input.txt")));
        String strings[] = input.split("\\n");
        int x2 = 0;
        int y2 = 0;
        int x1 = 0;
        int y1 = 0;
        char color = ' ';
        for (int i = 0; i < strings.length; i++){
            String s1[] = strings[i].split(" ");
            if (s1.length < 4) {
                x1 = Integer.parseInt(s1[1]);
                y1 = Integer.parseInt(s1[2]);
            }
            if(s1.length == 4){
                x1 = Integer.parseInt(s1[1]);
                y1 = Integer.parseInt(s1[2]);
                color = s1[3].charAt(0);
            }
            if(s1.length > 4){
                x1 = Integer.parseInt(s1[1]);
                y1 = Integer.parseInt(s1[2]);
                x2 = Integer.parseInt(s1[3]);
                y2 = Integer.parseInt(s1[4]);
            }

            switch (s1[0]){
                case  "C":
                    painter.createCanvas(x1,y1);
                    break;
                case "L":
                    painter.createFigure(x1,y1,x2,y2);
                    break;
                case "R":
                    painter.createFigure(x1,y1,x2,y2);
                    break;
                case "B":
                    painter.fill(x1,y1,color);
                    break;
            }
        }
    }

}

