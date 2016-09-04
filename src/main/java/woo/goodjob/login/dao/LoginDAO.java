package woo.goodjob.login.dao;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO{

	protected Log log = LogFactory.getLog( this.getClass() );
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;	

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectLoginDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("login.selectLoginDetail", map);
	}
	
	
	
}
