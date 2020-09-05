package com.lucent.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lucent.model.Products;
import com.lucent.service.ProductsService;

@RestController
public class ProductApiController {

  @Autowired
  private ProductsService service;

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(value = {"/syncProducts"}, method = RequestMethod.POST)
  public String syncProducts() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Shopify-Access-Token", "a87522cc2e2551e43549aceb52e5d141");
    headers.add("Content-Type", "application/json");
    HttpEntity<String> entity = new HttpEntity<String>(headers);
    String url = "https://securecod4.myshopify.com/admin/api/2020-07/collects.json";

    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    JSONObject obj = new JSONObject(response.getBody());
    JSONArray ja = obj.getJSONArray("collects");
    for (int i = 0; i < ja.length(); i++) {
      JSONObject jsonObject = ja.getJSONObject(i);
      Products products = new Products();
      products.setId(jsonObject.optLong("id"));
      products.setP_id(jsonObject.optLong("product_id"));
      products.setC_id(jsonObject.optLong("collection_id"));
      products.setPosition(jsonObject.optLong("position"));
      products.setSort_value(jsonObject.optString("sort_value"));
      products.setCreated_at(jsonObject.optString("created_at"));
      products.setUpdated_at(jsonObject.optString("updated_at"));
      service.saveProducts(products);
    }

    return "Successfully Saved Products";
  }


}
