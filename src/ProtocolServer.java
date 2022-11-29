import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ProtocolServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(52050); // 포트번호를 52050번으로 지정

            while (true) {
                System.out.println("연결을 기다리는 중...");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결 수락됨" + isa.getHostName());
            }
        } catch (IOException e) {
        }
    }
}