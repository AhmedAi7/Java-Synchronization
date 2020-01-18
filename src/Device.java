public class Device extends Thread {
    public static Router router;
    public boolean enter = false;
    public int assignedConnect;
    public String Dname;
Device (String Name, Router R) {
        super(Name);
        router = R;
    }
    public void run() {
    router.Connection.C(this);

        try {
            this.assignedConnect = router.occupy(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Connection " + assignedConnect+": "+this.getName()+" " + router.Occupied());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Connection " + assignedConnect+": "+this.getName()+" "+router.performs());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection " + assignedConnect+": "+ this.getName()+" "+router.loggedout(this));
        router.Connection.Dis();
    }
}
