package woo.goodjob.login.controller;



import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import woo.goodjob.login.service.LoginService;

@Controller
public class LoginController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name="loginService")
	private LoginService loginService;	
	
	@RequestMapping(value="/goodjob/login/loginView.do")
    public ModelAndView openCusomerInsView(CommandMap commandMap, HttpServletRequest request ) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/login/login");
    	return mv;
    }
	
	@RequestMapping(value="/goodjob/login/loginProcess.do")
	public ModelAndView loginProcess(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/goodjob/job/openJobList.do");
		log.debug( "commandMap====> "  +      commandMap.getMap().toString()    );

		Map<String,Object> resultMap = loginService.selectLoginDetail(commandMap.getMap());
		if(  resultMap == null  ){
			mv = new ModelAndView("/goodjob/login/login");
			mv.addObject("map", commandMap.getMap() );
			return mv;
		}
		log.debug( " return map====> "  +      resultMap.toString()    );
		String selectId = (String)resultMap.get("LOGIN_ID");
		
		request.getSession(true); 
		request.getSession().setAttribute("id", selectId );
		
		return mv;
	}
	
}
