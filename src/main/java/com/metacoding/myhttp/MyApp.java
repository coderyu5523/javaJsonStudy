package com.metacoding.myhttp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class MyApp {


    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");  // 객체를 만듬
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  // conn 은 소켓 ,  openConnection 서브소켓 . http 형식이 적용된.  HTTP 프로토콜이 설정된 소켓이 만들어짐.

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String download = "";
            while(true){

                String line = br.readLine();
                if(line == null)break;

                download = download +line;

            }
            //System.out.println(download);

            ObjectMapper om = new ObjectMapper();                   //download 는 외부로부터 받은 데이터 문자열
            Todo todo = om.readValue(download,Todo.class);    // 외부에서 받은 데이터 문자열을 클래스로 변환해줌.
                                                            // 제이슨 데이터를 자바데이터로 변환할 때 빈 생성자가 하나 필요함.
            System.out.println(todo.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
