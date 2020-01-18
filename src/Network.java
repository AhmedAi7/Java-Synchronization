import java.util.Scanner;

public class Network {
    public static void main(String[] args) throws InterruptedException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is number of WI-FI Connections?");
        int nConnections = input.nextInt();
        Router router = new Router(nConnections);
        System.out.println("What is number of devices Clients want to connect?");
        int nDevices = input.nextInt();
        Device[] Devices = new Device[nDevices];
        System.out.println("Enter the Devices' Names: ");
        input = new Scanner(System.in);

        for(int i = 0; i < nDevices; i++) {
            String a = input.nextLine();
            Devices[i] = new Device(a, router);
        }
        for(int i = 0; i < nDevices; i++) {
            Thread.sleep(1000L);
            Devices[i].start();
        }
    }
}

