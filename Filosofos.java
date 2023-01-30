import java.util.Random;

public class Filosofos implements Runnable {

    private Object leftFork;
    private Object rightFork;
    Random random = new Random();


    Filosofos(Object left, Object right) {
        this.leftFork = left;
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(3000); //
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(": Thinking"); // Thinking
                synchronized (leftFork) {
                    doAction(": Picks up left fork");
                    synchronized (rightFork) {
                        doAction(": Picks up right fork");
                        doAction(": Is eating");
                        doAction(": Finished eating");
                        doAction(": Drops right fork");
                    }
                    doAction(": Drops left fork. Goes back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}