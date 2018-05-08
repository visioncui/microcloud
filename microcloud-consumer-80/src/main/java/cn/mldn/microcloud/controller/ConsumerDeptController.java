package cn.mldn.microcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.mldn.vo.Dept;

@RestController
public class ConsumerDeptController {
   public static final String DEPT_GET_URL="http://dept-8001:8001/dept/get/";
   public static final String DEPT_LIST_URL="http://dept-8001:8001/dept/list/";
   public static final String DEPT_ADD_URL="http://dept-8001:8001/dept/add/";
   @Resource
   private RestTemplate restTemplate;
   @Resource
	private HttpHeaders headers;
   @RequestMapping(value="/consumer/dept/get/{id}")
   public Object getDept(@PathVariable("id")long id){
	   //Dept dept = restTemplate.getForObject(DEPT_GET_URL+id, Dept.class);
	   Dept dept = restTemplate.exchange(DEPT_GET_URL+id,HttpMethod.GET,
			   new HttpEntity<Object>(headers),Dept.class).getBody();
	   return dept;
   }
   @RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		/*List<Dept> allDepts = restTemplate.getForObject(DEPT_LIST_URL,
				List.class);*/ 
	   List<Dept> allDepts = restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,new HttpEntity<Object>(headers),
			   List.class).getBody();
		return allDepts;
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) {
		/*Boolean flag = restTemplate.postForObject(DEPT_ADD_URL, dept,
				Boolean.class);
		return flag;*/
		Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers), Boolean.class)
				.getBody();
		return flag;
	}
}
