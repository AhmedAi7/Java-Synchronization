import java.io.PrintStream;

public class Router {
    public boolean[] DevicesArr;
    public Semaphore Connection ;
    int nConnections;

    Router (int x) {
        this.nConnections = x;
        this.Connection = new Semaphore(this.nConnections);
        this.DevicesArr = new boolean[this.nConnections];
        for (int i =0 ; i <nConnections;i++)
        {
            DevicesArr[i]=false;
        }
    }
    public synchronized int occupy(Device D) throws InterruptedException {
        for(int i = 0; i < this.nConnections; ++i) {
            if (!this.DevicesArr[i]) {
                D.assignedConnect= i + 1;
                this.DevicesArr[i] = true;
                Thread.sleep(1000L);
                break;
            }
        }
        return D.assignedConnect;
    }
    public String Occupied() throws InterruptedException {
        Thread.sleep(1000L);
        return "Occupied";
    }

    public String performs() throws InterruptedException {
        Thread.sleep(1000L);
        return " performs online activity";
    }

    public synchronized String loggedout(Device D) {
        //this.nConnections--;
        this.DevicesArr[D.assignedConnect - 1] = false;
        this.notify();
        return "Logged out";
    }
}
