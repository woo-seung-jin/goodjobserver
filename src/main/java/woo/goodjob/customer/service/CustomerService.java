package woo.goodjob.customer.service;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CustomerService {

	void insertCustemer(Map<String, Object> map, HttpServletRequest request) throws Exception;

	List<Map<String, Object>> selectCustomerList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectCustomerDetail(Map<String, Object> map) throws Exception;
	
}
