package com.benneighbour.CloneBnb.listingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ListingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ListingServiceApplication.class, args);
  }
}
