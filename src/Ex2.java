public class Ex2 {
    private String message = "";
    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        new Thread( () -> ex2.prime()).start();
        new Thread( () -> ex2.nonprime()).start();
    }

    public void nonprime() {
        for (int i = 2; i <= 20; i ++) {

                synchronized (this) {
                    try {
                        while (!message.isEmpty()) {
                            this.wait();
                        }
                        message = "1";
                        if (!isprime(i)) {
                            System.out.println(i+ " : Non prime  ");
                        }
                        this.notify();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

    public void prime() {
        for (int i = 2; i <= 20; i ++) {

                synchronized (this) {
                    try {
                        while (message.equals("")) {
                            this.wait();
                        }
                        if (isprime(i)) {
                            System.out.println(i+ " : prime ");
                        }
                        message = "";
                        this.notify();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

    public static boolean isprime(int n){
        boolean flag=true;
          for(int j=2;j<n;j++){
                if(n%j==0){
                    flag=false;
                }
            }

        return flag;
    }

}
