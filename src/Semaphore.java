public class Semaphore {
    public static int queue;

    Semaphore(int num) {
        queue = num;
    }

    public synchronized void C(Device D) {
        queue--;
        if (queue < 0) {
            System.out.println(D.getName()+" Arrived and waiting");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println(D.getName()+" Connected");

    }
    public synchronized void Dis() {
        queue++;
        if (queue <= 0) {
            this.notify();
        }
    }
}

