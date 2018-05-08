package cn.mldn.microcloud.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;

@RestController
public class DeptRest {
   @Resource
   private IDeptService deptService;
   @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
   public Dept get(@PathVariable("id") long id){
	   return deptService.get(id);
   }
   @RequestMapping(value="/dept/add",method=RequestMethod.POST)
   public boolean add(@RequestBody Dept dept){
	   return deptService.add(dept);
   }
   @RequestMapping(value="/dept/list",method=RequestMethod.GET)
   public List<Dept> list(){
	   return deptService.list();
   }
}
