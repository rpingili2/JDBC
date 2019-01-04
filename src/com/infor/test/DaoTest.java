package com.infor.test;

import com.infor.dao.DeptDao;
import com.infor.dao.impl.DeptDaoImpl;

public class DaoTest {
	public static void main(String[] args) {
		DeptDao dao = new DeptDaoImpl();
		System.out.println(dao.getDeptById(10));;
	}
}
