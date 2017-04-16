public class Ex9 {
    public static void main(String[] args) {

        execute(4, 10);
    }

    public static void execute(int thread, int max) {
        for (int i= 1; i <= thread; i++) {
            int finalX = i;
            new Thread(() -> print(finalX, thread, max)).start();
        }
    }

    public static void print(int x, int thread, int max) {
        for (int i = x; i < max; i = i + thread) {
            System.out.println("Thread " + x + " " + i);
        }
    }

}
