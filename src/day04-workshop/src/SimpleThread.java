public class SimpleThread extends Thread{
    
        public static void main(String[] args) {
            
        }
        @Override
        public void run() {
            System.out.println("Thread started execution + " + Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread stopped execution + " + Thread.currentThread().getName());
        }
    }