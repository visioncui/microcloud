package cn.mldn.microcloud.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.microcloud.dao.IDeptDAO;
import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;

@Service
public class DeptServiceImpl implements IDeptService{
    @Resource
    private IDeptDAO deptDAO;
	@Override
	public Dept get(long id) {
		// TODO Auto-generated method stub
		return this.deptDAO.findById(id);
	}

	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return this.deptDAO.doCreate(dept);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return this.deptDAO.findAll();
	}

	
   
}
