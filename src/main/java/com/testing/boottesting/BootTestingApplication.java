package com.testing.boottesting;

import com.testing.boottesting.post.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
@EnableAsync
public class BootTestingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootTestingApplication.class, args);

        System.out.println(run.getBean("postController"));
    }

    @Bean
    JsonPlaceholderService jsonPlaceholderService() {
        RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(client))
                .build();
        return factory.createClient(JsonPlaceholderService.class);
    }


    //verifyNoMoreInteractions(замоканый объект);
}
