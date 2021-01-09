package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentMgmtServiceImpl implements StudentMgmtService {
	private StudentDAO dao;
	
    public StudentMgmtServiceImpl() {
		dao=new StudentDAOImpl();
	}
	
	@Override
	public String register(StudentDTO dto) throws Exception {
		int total=0;
		float avg=0.0f;	
		String result=null;
		int count=0;
		StudentBO bo=null;
		//calculate total average and generate result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(dto.getM1()<35 || dto.getM2()<35 || dto.getM3()<35)
			result="FAIL";
		else
			result="PASS";   
		//prepare BO class object having persistable data
		bo=new StudentBO();
		
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result); 
		
		//use DAO
		count=dao.insert(bo);
		
		
		return count==0?"Student registration failed-->total::"+total+"avg::"+avg+"result::"+result :"Student registration successfull-->total::"+total+"avg::"+avg+"result::"+result ;
	}

}
