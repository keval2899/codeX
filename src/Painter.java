import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Painter {

    private char[][] canvas;
    private int height = 0;
    private int wight = 0;

    public void createCanvas(int w, int h) {
        h += 2;
        w += 2;
        height = h;
        wight = w;
        canvas = new char[w][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || i == (h - 1)) {
                    canvas[j][i] = '-';
                } else if (j == 0 || j == (w - 1)) {
                    canvas[j][i] = '|';
                } else {
                    canvas[j][i] = ' ';
                }
            }
        }
        showCanvas();
    }

    public void createFigure(int x1, int y1, int x2, int y2) {
        if (canvas == null) {
            System.out.println("please create a canvas");
        } else {

            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
            }

            if (y1 > y2) {
                int t = y1;
                y1 = y2;
                y2 = t;
            }

            if (x1 <= 0 || y1 <= 0 || x2 >= wight - 1 || y2 >= height - 1) {
                System.out.println("please indicate correct coordinates");
            } else {

                int d1 = x2 - x1;
                int d2 = y2 - y1;

                for (int i = y1; i <= y1 + d2; i++) {
                    for (int j = x1; j <= x1 + d1; j++) {
                        if (i == y1 || i == (y1 + d2) || j == x1 || j == (x1 + d1)) {
                            canvas[j][i] = 'x';
                        } else {
                            canvas[j][i] = ' ';
                        }
                    }
                }
                showCanvas();
            }
        }
    }


    public void fill(Integer x, Integer y, char color) {

        if (canvas == null) {
            System.out.println("please create a canvas");
        } else {

            {
                if (x <= 0 || x >= wight - 1 || y <= 0 || y >= height - 1) {
                    System.out.println("please indicate correct coordinates");
                } else {
                    LinkedList<Integer> point = new LinkedList<Integer>();
                    point.addFirst(x);
                    point.addLast(y);
                    Deque<LinkedList<Integer>> stack = new ArrayDeque<LinkedList<Integer>>();
                    stack.push(point);

                    Integer x1 = 0;
                    Integer y1 = 0;

                    if (canvas[x][y] == 'x') {
                        while (!stack.isEmpty()) {
                            point = stack.pop();

                            x1 = point.getFirst();
                            y1 = point.getLast();

                            if (canvas[x1 + 1][y1] == 'x') {
                                canvas[x1 + 1][y1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1 + 1);
                                p.addLast(y1);
                                stack.push(p);
                            }

                            if (canvas[x1 - 1][y1] == 'x') {
                                canvas[x1 - 1][y1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1 - 1);
                                p.addLast(y1);
                                stack.push(p);
                            }

                            if (canvas[x1][y1 + 1] == 'x') {
                                canvas[x1][y1 + 1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1);
                                p.addLast(y1 + 1);
                                stack.push(p);
                            }

                            if (canvas[x1][y1 - 1] == 'x') {
                                canvas[x1][y1 - 1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1);
                                p.addLast(y1 - 1);
                                stack.push(p);
                            }
                        }
                    } else {
                        while (!stack.isEmpty()) {

                            point = stack.pop();

                            x1 = point.getFirst();
                            y1 = point.getLast();

                            if (canvas[x1 + 1][y1] == ' ') {
                                canvas[x1 + 1][y1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1 + 1);
                                p.addLast(y1);
                                stack.push(p);
                            }

                            if (canvas[x1 - 1][y1] == ' ') {
                                canvas[x1 - 1][y1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1 - 1);
                                p.addLast(y1);
                                stack.push(p);
                            }

                            if (canvas[x1][y1 + 1] == ' ') {
                                canvas[x1][y1 + 1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1);
                                p.addLast(y1 + 1);
                                stack.push(p);
                            }

                            if (canvas[x1][y1 - 1] == ' ') {
                                canvas[x1][y1 - 1] = color;
                                LinkedList<Integer> p = new LinkedList<>();
                                p.addFirst(x1);
                                p.addLast(y1 - 1);
                                stack.push(p);
                            }
                        }

                    }
                    showCanvas();
                }
            }
        }
    }

    public void showCanvas() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wight; j++) {
                System.out.print(canvas[j][i]);
            }
            System.out.println();
        }
    }
}