import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

    public static void main(String[] arsg) {

        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);


        try {
            server = new ServerSocket(52050);
            System.out.println("연결 대기중....");

            socket = server.accept();
            System.out.println("연결 되었습니다...");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true){
                String inMsg = in.readLine();
                if (inMsg.equalsIgnoreCase("bey")) {
                    System.out.println("클라이언트가 나갔습니다.");
                    break;
                }

                // 성장 메세지 경우
                System.out.println("클라이언트 : " + inMsg);

                System.out.print("보내기 >>");
                String outMag = sc.nextLine();
                out.write(outMag + "\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
                server.accept();

            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
