import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

    public static void main(String[] arsg) {

        // 열어준다.
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);


        try {
            socket = new Socket("localhost", 52050);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true){
                System.out.print("보내기 >>");
                String outMag = sc.nextLine();

                if (outMag.equalsIgnoreCase("bye")) {
                    out.write(outMag + "\n");
                    out.flush();
                    break;
                }

                // 정상 메세지 경우
                out.write(outMag + "\n");
                out.flush();

                String inMsg = in.readLine();
                System.out.println("서버 >> " + inMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            // 작성한 역순으로 close 닫아준다.
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
