package indi.liujunchen.admin.modules.sys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import indi.liujunchen.admin.modules.sys.entity.SysMenuEntity;
import indi.liujunchen.admin.modules.sys.service.SysMenuService;

@Controller
@RequestMapping("/jsp")
public class SysIndexJspController extends AbstractController {

	/**
	 * 导航菜单
	 */
	 @RequestMapping("/index")
		public ModelAndView user_center(HttpSession session){
			ModelAndView mav = new ModelAndView("desktop");
			List<SysMenuEntity> menuList = sysMenuService.getUserMenuListDestop(getUserId());
			mav.addObject("menu", menuList);
			return mav;
		}
	 
		@Autowired
		private SysMenuService sysMenuService;

	
		
		
	    
}
