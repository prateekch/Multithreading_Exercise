public class Ex5 {
    public static void main(String[] args) {
            SumArray sumArray = new SumArray();
            Thread thread[] = new Thread[4];
            for (int i = 0; i < 4; i++)
                thread[i] = new Thread(() -> sumArray.sum());

            for (int i = 0; i < 4; i++) {
                thread[i].start();
            }
            for (int i = 0; i < 4; i++)
                try {
                    thread[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Sum : " + sumArray.sum);
            System.out.println("Main Thread Ending....");

        }

    }

    class SumArray {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        int arrLength = arr.length;
        int sum = 0;
        public void sum() {
            while (arrLength > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    if (arrLength > 0) {
                        System.out.println(Thread.currentThread().getName());
                        sum += arr[--arrLength];
                    }
                }
            }

        }
    }
