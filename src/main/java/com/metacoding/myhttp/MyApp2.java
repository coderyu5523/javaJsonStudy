package com.metacoding.myhttp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyApp2 {
    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String download = "";

            while (true) {
                String line = br.readLine();
                if (line == null) break;
                download = download + line;
            }
            ObjectMapper om = new ObjectMapper();
            Post post = om.readValue(download, Post.class);

            System.out.println(post.toString());

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
