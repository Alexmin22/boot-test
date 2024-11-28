package com.testing.boottesting.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class HttpService {

//    public List<String> fetchDataFromSources(List<URI> uris) {
//
//        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//            HttpClient httpClient = HttpClient.newBuilder()
//                .connectTimeout(Duration.ofSeconds(10)) // Конфигурация таймаута соединения
//                .executor(executor)
//                .version(HttpClient.Version.HTTP_1_1)    // Использование версии HTTP/2
//                .build()) {
//            List<Future<String>> futures = uris.stream()
//                .map(uri -> executor.submit(() -> {
//                    HttpRequest request = HttpRequest.newBuilder()
//                        .uri(uri)
//                        .GET()
//                        .build();
//
//                    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//                    return response.body();
//                }))
//                .toList();
//
//            // Собираем результаты
//            return futures.stream()
//                .map(future -> {
//                    try {
//                        return future.get();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        return null;
//                    }
//                })
//                .collect(Collectors.toList());
//        }
//    }
}