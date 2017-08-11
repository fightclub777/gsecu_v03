package net.gongple.gsecu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	/**
	 * v0.2 추가.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@RequestParam(value="fail", required=false) String fail, Model model) {
		if(fail != null) {
			model.addAttribute("failmsg", "아이디와 비밀번호가 올바르지 않습니다.");
		}
		
		return "auth/login";
	}
	
	/**
	 * v0.2 추가.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("msg", "HI~!HELLO~! Here is Home!");
		return "home";
	}
	
	/**
	 * v0.3 추가.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "mypage";
	}
	
	/**
	 * v0.3 추가.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/access_denied", method=RequestMethod.GET)
	public String accessDenied(Model model) {
		model.addAttribute("msg", "접근 권한이 없습니다.");
		return "access_denied";
	}
	
	/**
	 * v0.2 추가.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/goodbye", method=RequestMethod.GET)
	public String goodbye(Model model) {
		model.addAttribute("msg", "Good Bye! See you again~!");
		return "goodbye";
	}
	
	
	@RequestMapping(value="/admin/h", method=RequestMethod.GET)
	public String highAdmin(Model model) {
		model.addAttribute("msg", "최고");
		return "admin/admin";
	}

	@RequestMapping(value="/admin/m", method=RequestMethod.GET)
	public String middleAdmin(Model model) {
		model.addAttribute("msg", "중간");
		return "admin/admin";
	}

	@RequestMapping(value="/admin/l", method=RequestMethod.GET)
	public String lowAdmin(Model model) {
		model.addAttribute("msg", "실무");
		return "admin/admin";
	}
	
	@RequestMapping(value="/user/in", method=RequestMethod.GET)
	public String in(Model model) {
		model.addAttribute("msg", "IN");
		return "user";
	}
	
	@RequestMapping(value="/user/out", method=RequestMethod.GET)
	public String out(Model model) {
		model.addAttribute("msg", "OUT");
		return "user";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/goodbye"; // v0.2 추가.
	}

}