package woo.goodjob.login.service;


import java.util.Map;

public interface LoginService {

	Map<String, Object> selectLoginDetail(Map<String, Object> map) throws Exception;
	
}
