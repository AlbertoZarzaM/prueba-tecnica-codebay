package com.codebay.goldeneye.adapter.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiIntegration {

      /**
     * Envía una solicitud a una API con el correo electrónico especificado y devuelve el estado de la respuesta.
     * @param email El correo electrónico para enviar a la API.
     * @return El estado de la respuesta de la API.
     * @throws JsonMappingException Si hay un error al mapear JSON.
     * @throws JsonProcessingException Si hay un error al procesar JSON.
     */
  public static String getApiData(String email) throws JsonMappingException, JsonProcessingException {
               // Crear la solicitud para la API

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    String requestBody = "{\"email\":\"" + email + "\"}";
    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

    RestTemplate restTemplate = new RestTemplate();
    String apiUrl = "https://dummy.restapiexample.com/api/v1/employee/1"; // Reemplaza esto con la URL real de tu API
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
    
    // Procesar la respuesta de la API
    ObjectMapper objectMapper = new ObjectMapper();
    String responseBody = responseEntity.getBody();
    JsonNode responseJson = objectMapper.readTree(responseBody);

    JsonNode statusNode = responseJson.get("status");
    String status;
    if (statusNode != null) {
      status = statusNode.asText();
    } else {
      status = "Error";
    }
    return status;
  }
}
