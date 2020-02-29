package com.mysite.netconf;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FortinetDemo {
    public static <T> Object restfulMethodDispatcher(String url, T entity) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/text");
        String body = (String) entity;

        StringEntity stringEntity = new StringEntity(body, "UTF-8");
        post.setEntity(stringEntity);
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(response.toString());
            }
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
//                System.out.println("debug start");
//                System.out.println(line);
//                System.out.println("debug end");
            }
            if(String.valueOf(result.charAt(0)).equals("1")){
                System.out.println("login success!");
            }
            response.getEntity();
            Header[] allHeaders = response.getAllHeaders();
            HeaderIterator headerIterator = response.headerIterator();
            while(headerIterator.hasNext()){
                Header header = headerIterator.nextHeader();
                System.out.println("=====getElemants=====");
                System.out.println(header.getElements());
                System.out.println("=====getElemants=====");
                System.out.println("=====getName=====");
                System.out.println(header.getName());
                System.out.println("=====getName=====");
                System.out.println("=====getValue=====");
                System.out.println(header.getValue());
                System.out.println("=====getValue=====");
//                if(h.getName().equals("ccsrftoken")){
//                    System.out.println(h.getValue());
//                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        String url = "http://11.251.96.202:80/logincheck";
        String data = "username=admin&secretkey=admin&ajax=1";
        System.out.println(FortinetDemo.restfulMethodDispatcher(url,data));

    }
}
