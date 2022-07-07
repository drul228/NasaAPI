package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.List;

public class Main {
    public static final String API = "https://api.nasa.gov/planetary/apod?api_key=wCLC1GA6uOZe9tkFmQRVAsI7erKBsWfFtr36E9yk";

    public static void main(String[] args) {
        HttpGet request = new HttpGet(API);
        ObjectMapper objectMapper = new ObjectMapper();
        try (CloseableHttpClient closeableHttpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.DEFAULT)
                .build();
             CloseableHttpResponse response = closeableHttpClient.execute(request);) {
            var facts = objectMapper.readValue(response.getEntity().getContent(), NasaInfo.class);
            HttpGet request1 = new HttpGet(facts.url);
            CloseableHttpResponse response1 = closeableHttpClient.execute(request1);
            var nasaObj = response1.getEntity().getContent().readAllBytes();
            var urlNasaForName = facts.url.split("/");
            var fileName = urlNasaForName[urlNasaForName.length - 1];
            File file = new File(fileName);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(nasaObj);
            outputStream.close();
            response1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}