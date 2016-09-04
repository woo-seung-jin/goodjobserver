package woo.goodjob.customer.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("customerDAO")
public class CustomerDAO extends AbstractDAO{

	protected Log log = LogFactory.getLog( this.getClass() );
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Object insertBoard(Map<String, Object> map) throws Exception{
		//insert("customer.insertCustomer", map);
		String queryId = "customer.insertCustomer";
		
		printQueryId(queryId);
		return sqlSession.insert(queryId, map);
	}


	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectCustomerList(Map<String, Object> map) throws Exception{
		
		return (List<Map<String, Object>>)selectPagingList("customer.selectCustomerList", map);
	}
	
	public void insertFile(Map<String, Object> map) throws Exception{
		insert("customer.insertFile", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectCustomerDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("customer.selectCustomerDetail", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("customer.selectFileList", map);
	}
	
	
}
