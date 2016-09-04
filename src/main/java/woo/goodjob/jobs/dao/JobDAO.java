package woo.goodjob.jobs.dao;



import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("jobDAO")
public class JobDAO extends AbstractDAO{

	protected Log log = LogFactory.getLog( this.getClass() );
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Object insertJob(Map<String, Object> map) throws Exception{
		//insert("customer.insertCustomer", map);
		String queryId = "job.insertJob";
		
		printQueryId(queryId);
		return sqlSession.insert(queryId, map);
	}


	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectJobList(Map<String, Object> map) throws Exception{
		
		return (List<Map<String, Object>>)selectPagingList("job.selectJobList", map);
		
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectJobDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("job.selectJobDetail", map);
	}
	
	public void updateJob(Map<String, Object> map) throws Exception{
		update("job.updateJob", map);
	}
	
	public void deleteJob(Map<String, Object> map) throws Exception{
		
		//log.debug("map" + map.toString() );
		
		delete("job.deleteJob", map);
	}
	
	
}
