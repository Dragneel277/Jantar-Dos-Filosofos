public class Jantarfilosofos {

    public static void main(String[] args) throws Exception {

        Filosofos[] filosofos = new Filosofos[5];  //
        Object[] forks = new Object[filosofos.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < filosofos.length; i++) {

            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == filosofos.length - 1) {
                filosofos[i] = new Filosofos(rightFork, leftFork); // The last filosofos picks up the right fork first
            } else {
                filosofos[i] = new Filosofos(leftFork, rightFork);
            }

            Thread t = new Thread(filosofos[i], "filosofo " + (i + 1));
            t.start();
        }
    }
}