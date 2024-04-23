package com.example.soap_client.implementation;

import com.example.soap_client.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient countryClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = countryClient.getCountry(country);
            System.out.println("response.getCountry().getName() = " + response.getCountry().getName());
            System.out.println("response.getCountry().getCapital() = " + response.getCountry().getCapital());
            System.out.println("response.getCountry().getCurrency() = " + response.getCountry().getCurrency());
            System.out.println("response.getCountry().getPopulation() = " + response.getCountry().getPopulation());
        };
    }
}
