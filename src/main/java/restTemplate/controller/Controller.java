package restTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import restTemplate.model.PolicyRequestDto;
import restTemplate.model.PolicyResponseDto;
import restTemplate.serviceImpl.ServiceImpl;

@RestController
public class Controller {
      @Autowired 
	ServiceImpl serviceImpl;
      
     @GetMapping("/get")     
	public PolicyResponseDto getCall()
	{
		return serviceImpl.getCall();
		
	}
     
     @PostMapping("/postMapping")
     public PolicyResponseDto  postCall(@RequestBody PolicyRequestDto  policyRequestDto)
     {
    	 return serviceImpl.postCall(policyRequestDto); 
    			 }
	
     
     @PatchMapping("/patchMapping/{id}")
     public PolicyResponseDto  patchCall(@RequestBody PolicyRequestDto  policyRequestDto,@PathVariable  Integer id)
     {
    	 return serviceImpl.patchCall(policyRequestDto, id);
    			 }
     
     
     @DeleteMapping("/delete")
     public String deleteCall()
     {
    	 return serviceImpl.deleteCall();
     }
	
}
