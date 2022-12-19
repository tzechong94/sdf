public class MultiThread implements Runnable{
    
    @Override
    public void run() {
        for (Integer i = 0; i < 1; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        }
        
    }
}
