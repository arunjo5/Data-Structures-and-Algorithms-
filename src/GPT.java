import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import java.net.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class GPT {
    public static String sendRequest(String prompt) throws IOException {
        URL url = new URL("https://api.openai.com/v1/completions");
        String postData = "{\"model\":\"text-davinci-003\",\"prompt\":\""+prompt+"\",\"temperature\":0.5,\"max_tokens\":2000}";

        HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer token");

        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            System.out.println(postData);
            dos.writeBytes(postData);
        }
        System.out.println(conn.getResponseCode());
        String lines = "";
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
            String line;
            while ((line = bf.readLine()) != null) {
                lines += line;
            }
        } catch (Error e){
            System.out.println(conn.getErrorStream());
        }
        return lines;

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        String string = sendRequest("");
        string = string.substring(139, string.indexOf("logprobs")-13);
        for(String s : string.split("\\\\n")) {
            s = s.replaceAll("\\\\t", "\t");
            System.out.println(string);
        }
    }
}
