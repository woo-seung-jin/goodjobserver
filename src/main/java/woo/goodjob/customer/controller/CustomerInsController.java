package woo.goodjob.customer.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import woo.goodjob.customer.service.CustomerService;

@Controller
public class CustomerInsController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name="customerService")
	private CustomerService customerService;	
	
	@RequestMapping(value="/goodjob/customer/customerInsView.do")
    public ModelAndView openCusomerInsView(CommandMap commandMap, HttpServletRequest request ) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/customer/customer_ins");
    	return mv;
    }
	
	
	@RequestMapping(value="/goodjob/customer/insertCustomer.do")
	public ModelAndView insertCusomer(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/goodjob/customer/openCustomerList.do");
		log.error( "commandMap====> "  +      commandMap.getMap().toString()    );
		customerService.insertCustemer(commandMap.getMap(), request);
		return mv;
	}
	
	@RequestMapping(value="/goodjob/customer/openCustomerList.do")
    public ModelAndView openCustomerList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/customer/customerList");
    	return mv;
    }	
	
	@RequestMapping(value="/goodjob/customer/selectCustomerList.do")
    public ModelAndView selectCustomerList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	List<Map<String,Object>> list = customerService.selectCustomerList(commandMap.getMap());
    	mv.addObject("list", list);
//    	if(list.size() > 0){
//    		mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
//    	}
//    	else{
//    		mv.addObject("TOTAL", 0);
//    	}
    	
    	return mv;
    }
	
	
	@RequestMapping(value="/goodjob/customer/openCustomerDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/customer/customerDetail");
		
		Map<String,Object> map = customerService.selectCustomerDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
}
