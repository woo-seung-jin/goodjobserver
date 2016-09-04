package woo.goodjob.customer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.common.util.FileUtils;
import woo.goodjob.customer.dao.CustomerDAO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Resource(name="customerDAO")
	private CustomerDAO customerDAO;
	
	
	@Override
	public void insertCustemer(Map<String, Object> map, HttpServletRequest request) throws Exception {
		customerDAO.insertBoard(map);
		
		log.debug("CUSTOMER_ID  #################################### "  );
		log.debug("CUSTOMER_ID  => " +  map.get("CUSTOMER_ID")  );
		log.debug("CUSTOMER_ID  #################################### "  );
		map.put("IDX", map.get("CUSTOMER_ID"));
		log.debug("CUSTOMER_ID  #################################### "  );
		log.debug("IDX  => " +  map.get("IDX")  );
		
		
		
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for(int i=0, size=list.size(); i<size; i++){
			customerDAO.insertFile(list.get(i));
		}
		
	}

	@Override
	public List<Map<String, Object>> selectCustomerList(Map<String, Object> map) throws Exception {
		return customerDAO.selectCustomerList(map);
	}
	
	@Override
	public Map<String, Object> selectCustomerDetail(Map<String, Object> map) throws Exception {
		//customerDAO.updateHitCnt(map);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		
		log.debug("CUSTOMER_ID  #################################### "  );
		log.debug("CUSTOMER_ID  => " +  map.get("IDX")  );
		log.debug("CUSTOMER_ID  #################################### "  );
		
		Map<String, Object> tempMap = customerDAO.selectCustomerDetail(map);
		resultMap.put("map", tempMap);
		
		List<Map<String,Object>> list = customerDAO.selectFileList(map);
		resultMap.put("list", list);
		
		return resultMap;
	}
	
}
