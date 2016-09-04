package woo.goodjob.login.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.FileUtils;
import woo.goodjob.jobs.dao.JobDAO;
import woo.goodjob.login.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO;
	
	
	@Override
	public Map<String, Object> selectLoginDetail(Map<String, Object> map) throws Exception {

		Map<String, Object> resultMap = new HashMap<String,Object>();
		Map<String, Object> tempMap = loginDAO.selectLoginDetail(map);
		//resultMap.put("map", tempMap);
		
		return tempMap;
	}
	
	
}
