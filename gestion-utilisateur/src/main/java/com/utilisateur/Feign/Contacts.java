package com.utilisateur.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "book-rest-api", url = "http://localhost:8081/Utilisateur/")
public interface Contacts {

}
