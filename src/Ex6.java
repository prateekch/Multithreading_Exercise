public class Ex6 {
        public static void main(String[] args) {
            MaxArray maxArray = new MaxArray();
            Thread thread[] = new Thread[4];
            for (int i = 0; i < 4; i++)
                thread[i] = new Thread(() -> maxArray.max());

            for (int i = 0; i < 4; i++) {
                thread[i].start();
            }
            for (int i = 0; i < 4; i++)
                try {
                    thread[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println("Max : " + maxArray.max);
            System.out.println("Main Thread Ending....");

        }

    }

    class MaxArray {
        int arr[] = new int[]{1,2,1,7, 3, 4, 5, 6};
        int arrLength = arr.length;
        int max = 0;

        public void max() {


            while (arrLength > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    if (arrLength > 0) {
                        System.out.println(Thread.currentThread().getName());
                        arrLength--;
                        max=max<arr[arrLength]?arr[arrLength]:max;
                    }
                }
            }

        }


    }

