public class Ex3 {
        int n=3;
        public static void main(String[] args) {

            Ex3 ex3=new Ex3();
            new Thread( () -> ex3.thread1()).start();
            new Thread( () -> ex3.thread2()).start();
            new Thread( () -> ex3.thread3()).start();
        }

        int message=0;

        public void thread1() {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    try {
                        while (message<0 ||message>0) {
                            this.wait();
                        }
                        System.out.println("1");
                        message = -1;
                        this.notifyAll();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        public void thread2() {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    try {
                        while (message >=0) {
                            this.wait();
                        }
                        System.out.println("2 ");
                        message =1 ;
                        this.notifyAll();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        public void thread3() {
            for(int i=0;i<n;i++){
                synchronized (this) {
                    try {
                        while(message <=0){
                            this.wait();
                        }

                        System.out.println("3");
                        message= 0;
                        this.notifyAll();
                    } catch (InterruptedException e) {}
                }
            }
        }

    }
