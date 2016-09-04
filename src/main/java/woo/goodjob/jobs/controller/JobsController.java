package woo.goodjob.jobs.controller;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import woo.goodjob.jobs.service.JobService;

@Controller
public class JobsController {
	Logger log = Logger.getLogger(this.getClass());
	
	
	@Resource(name="jobService")
	private JobService jobService;	
	
	@RequestMapping(value="/goodjob/job/jobInsView.do")
    public ModelAndView openCusomerInsView(CommandMap commandMap, HttpServletRequest request ) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/job/jobIns");
    	return mv;
    }
	
	@RequestMapping(value="/goodjob/job/jobDetail.do")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/job/jobDetail");
		
		Map<String,Object> map = jobService.selectJobDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/goodjob/job/insertJob.do")
	public ModelAndView insertCusomer(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/goodjob/job/openJobList.do");
		log.error( "commandMap====> "  +      commandMap.getMap().toString()    );
		jobService.insertJob(commandMap.getMap(), request);
		return mv;
	}
	
	
	@RequestMapping(value="/goodjob/job/openJobUpdate.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/job/jobUpdate");
		
		Map<String,Object> map = jobService.selectJobDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/goodjob/job/openJobList.do")
    public ModelAndView openBoardList(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/goodjob/job/jobList");
    	return mv;
    }	
	
	@RequestMapping(value="/goodjob/job/selectJobList.do")
    public ModelAndView selectBoardList(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	List<Map<String,Object>> list = jobService.selectJobList(commandMap.getMap());
    	mv.addObject("list", list);
//    	if(list.size() > 0){
//    		mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
//    	}
//    	else{
//    		mv.addObject("TOTAL", 0);
//    	}
    	
    	return mv;
    }
	
	
	@RequestMapping(value="/goodjob/job/updateJob.do")
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/goodjob/job/jobDetail.do");
		
		jobService.updateJob(commandMap.getMap(), request);
		
		mv.addObject("SEQ", commandMap.get("SEQ"));
		return mv;
	}
	
	
	@RequestMapping(value="/goodjob/job/deleteJob.do")
	public ModelAndView deleteJob(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/goodjob/job/openJobList.do");
		
		jobService.deleteJob(commandMap.getMap());
		
		return mv;
	}
	
	
	
}
