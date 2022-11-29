import java.net.Socket;

public class ProtocolClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.30.1.28", 9500);
            System.out.println("연결성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}