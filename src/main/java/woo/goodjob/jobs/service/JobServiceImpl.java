package woo.goodjob.jobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.FileUtils;
import woo.goodjob.jobs.dao.JobDAO;

@Service("jobService")
public class JobServiceImpl implements JobService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="jobDAO")
	private JobDAO jobDAO;
	
	
	@Override
	public void insertJob(Map<String, Object> map, HttpServletRequest request) throws Exception {
		jobDAO.insertJob(map);
	}

	@Override
	public List<Map<String, Object>> selectJobList(Map<String, Object> map) throws Exception {
		return jobDAO.selectJobList(map);
	}
	
	
	
	@Override
	public Map<String, Object> selectJobDetail(Map<String, Object> map) throws Exception {
		//jobDAO.updateHitCnt(map);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Map<String, Object> tempMap = jobDAO.selectJobDetail(map);
		resultMap.put("map", tempMap);
		
//		List<Map<String,Object>> list = jobDAO.selectFileList(map);
//		resultMap.put("list", list);
		
		return resultMap;
	}
	
	@Override
	public void updateJob(Map<String, Object> map, HttpServletRequest request) throws Exception{
		jobDAO.updateJob(map);
		
//		jobDAO.deleteFileList(map);
//		List<Map<String,Object>> list = fileUtils.parseUpdateFileInfo(map, request);
//		Map<String,Object> tempMap = null;
//		for(int i=0, size=list.size(); i<size; i++){
//			tempMap = list.get(i);
//			if(tempMap.get("IS_NEW").equals("Y")){
//				sampleDAO.insertFile(tempMap);
//			}
//			else{
//				sampleDAO.updateFile(tempMap);
//			}
//		}
	}
	
	@Override
	public void deleteJob(Map<String, Object> map) throws Exception {
		jobDAO.deleteJob(map);
	}
	
}
