package woo.goodjob.jobs.service;





import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface JobService {

	void insertJob(Map<String, Object> map, HttpServletRequest request) throws Exception;

	List<Map<String, Object>> selectJobList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectJobDetail(Map<String, Object> map) throws Exception;
	
	public void updateJob(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	void deleteJob(Map<String, Object> map) throws Exception;
}
