package restTemplate.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import restTemplate.model.PolicyRequestDto;
import restTemplate.model.PolicyResponseDto;

@Service
public class ServiceImpl {
      
	 RestTemplate restTemplate= new  RestTemplate ();
	
   public PolicyResponseDto getCall()
   {
	   //with no parameter
	  PolicyResponseDto response1= restTemplate.getForObject("http://localhost:8082/policies/policies/1", PolicyResponseDto.class);
	  //with direct prameter
	  PolicyResponseDto response2=restTemplate.getForObject("http://localhost:8082/policies/policies/{id}", PolicyResponseDto.class, "1");
	  //with parameter in map
	   Map<String ,String> input=new HashMap<>();
	   input.put("id", "1");
	   
	   PolicyResponseDto response=restTemplate.getForObject("http://localhost:8082/policies/policies/{id}", PolicyResponseDto.class, input);
	return response;
   }
   
	public PolicyResponseDto postCall(PolicyRequestDto policyRequestDto)
	{
		//with post method
	 PolicyResponseDto response1=restTemplate.postForObject("http://localhost:8082/policies", policyRequestDto, PolicyResponseDto.class);
		//with exchange method which return response entity
		HttpEntity<PolicyRequestDto> request = new HttpEntity<>(policyRequestDto);
		ResponseEntity<PolicyResponseDto> response=restTemplate.exchange("http://localhost:8082/policies", HttpMethod.POST, request, PolicyResponseDto.class);
		   return response.getBody();
	}
	
	public PolicyResponseDto patchCall(PolicyRequestDto policyRequestDto,int id)
	{
		//as default jdk does not support patch request so we need to use  HttpComponentsClientHttpRequestFactory() which is apache type
		 RestTemplate restTemplate1=new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		 
		 //by using requestfactory
		 RestTemplate restTemplate2 = new RestTemplate();

		 HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		 requestFactory.setConnectTimeout(2000);
		 requestFactory.setReadTimeout(2000);

		 restTemplate1.setRequestFactory(requestFactory);

	HttpEntity<PolicyRequestDto> request = new HttpEntity<>(policyRequestDto);
		
		
		ResponseEntity<PolicyResponseDto> response=restTemplate1.exchange("http://localhost:8082/policies/policies/{id}", HttpMethod.PATCH, request, PolicyResponseDto.class,"1");
		   return response.getBody();
	}
	
	public String deleteCall()
	{
		//with delete method
		restTemplate.delete("http://localhost:8082/policies/policies/{id}", "2");
		//with exchange method
		HttpEntity<PolicyResponseDto> request = new HttpEntity<>(new PolicyResponseDto());
		ResponseEntity<String> response=restTemplate.exchange("http://localhost:8082/policies/policies/3", HttpMethod.DELETE, request, String.class);
		return response.getBody();
	}
}
