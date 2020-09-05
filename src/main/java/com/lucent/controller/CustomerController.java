package com.lucent.controller;

import org.json.JSONArray;
import org.json.JSONException;
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

import com.lucent.model.Addresses;
import com.lucent.model.Customers;
import com.lucent.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = { "/fetchCustomers" }, method = RequestMethod.POST)
	public String syncUserData() throws JSONException {

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Shopify-Access-Token", "a87522cc2e2551e43549aceb52e5d141");
		headers.add("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = "https://e3519ce8d2b72750210800f3ba7115f2:a87522cc2e2551e43549aceb52e5d141@securecod4.myshopify.com/admin/api/2020-01/customers.json";

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		JSONObject jsonObject = new JSONObject(response.getBody());
		JSONArray array = jsonObject.getJSONArray("customers");
		for (int i = 0; i < array.length(); i++) {
			JSONObject cusObj = array.getJSONObject(i);
			Customers customer = new Customers();
			customer.setId(cusObj.optLong("id"));
			customer.setEmail(cusObj.optString("email"));
			customer.setFirst_name(cusObj.optString("first_name"));
			customer.setPhone(cusObj.optString("phone"));
			customer.setState(cusObj.optString("state"));
			customer.setLast_order_id(cusObj.optLong("last_order_id"));
			Addresses address = new Addresses();
			JSONArray jsonArray = cusObj.getJSONArray("addresses");
			for (int j = 0; j < jsonArray.length(); j++) {
				JSONObject object = jsonArray.getJSONObject(j);
				address.setId(object.optLong("id"));
				address.setAddress1(object.optString("address1"));
				address.setCustomer_id(customer);
				address.setCity(object.optString("city"));
				address.setProvince(object.optString("province"));
				address.setZip(object.optString("zip"));

			}
			customerService.saveCustomer(customer);
		}

		return "successfully saved customer";
	}

}
