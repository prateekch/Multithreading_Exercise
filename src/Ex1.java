public class Ex1 {
    private String message = "";

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        new Thread( () -> ex1.prime()).start();
        new Thread( () -> ex1.Odd()).start();
    }
    public void prime() {
        for(int i = 0; i <=20; i+=2){
            synchronized (this) {
                try {
                    while(!message.isEmpty()){
                        this.wait();
                    }
                    message= "1";
                    System.out.println("Even : "+i);
                    this.notify();
                } catch (InterruptedException e) {}
            }
        }
    }
    public void Odd() {
        for(int i = 1; i <= 20; i= i+2){
            synchronized (this) {
                try {
                    while(message.equals("")){
                        this.wait();
                    }
                    System.out.println("Odd :  "+i);
                    message="";
                    this.notify();
                } catch (InterruptedException e) {}
            }
        }
    }
}

