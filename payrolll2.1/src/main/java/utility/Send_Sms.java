package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send_Sms {
public static void main(String[] agrs)
{
	try {
        // Construct data
        String apiKey = "apikey=" + "	NTAzNTcwMzQ0YzRiMzQ3NjY1NzU0NDcyNGU2NjY4NDM=";
        String message = "&message=" + "My Name is Madhav Msg Using Java";
       // String sender = "&sender=" + "TXTLCL";
        String numbers = "&numbers=" + "919370548600";

        // Send data
        HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
        String data = apiKey + numbers + message ; //+ sender;
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
        conn.getOutputStream().write(data.getBytes("UTF-8"));
         
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }
        System.out.println(stringBuffer.toString());
        rd.close();


    } catch (Exception e) {
       e.printStackTrace();
    }
}
}
