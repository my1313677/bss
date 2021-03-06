package cn.bjtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.bjtc.annotation.SysPrivilege;

@Controller 
public class CustomerViewController {

	@RequestMapping(value="cstmls/show.html",method=RequestMethod.GET)
	@SysPrivilege(name="cstm:show")
	public String showCustomerView(){
		return "cust/list";
	}

	@RequestMapping(value="cstmchk/show.html",method=RequestMethod.GET)
	public String showCstmChkView(){
		return "cmchk/show";
	}
	
	@RequestMapping(value="cstmchk/cert/{cid}.html",method=RequestMethod.GET)
	public String showCstmChkCertView(@PathVariable Integer cid,@RequestParam(required=false) String cst,@RequestParam(required=false) String crslt, Model model){
		model.addAttribute("cid", cid);
		model.addAttribute("cst", cst);
		model.addAttribute("crslt", crslt);
		return "cmchk/cert";
	}
	
	@RequestMapping(value="cstmchk/cnfrm/{cid}.html",method=RequestMethod.GET)
	public String showCstmChkCnfrmView(@PathVariable Integer cid, @RequestParam String cst,@RequestParam String crslt, Model model){
		model.addAttribute("cid", cid);
		model.addAttribute("cst", cst);
		model.addAttribute("crslt", crslt);
		return "cmchk/cnfrm";
	}
	
	@RequestMapping(value="cstmchk/exec.html",method=RequestMethod.GET)
	public String showCstmExecView(@RequestParam String cst,@RequestParam String crslt, Model model){
		model.addAttribute("cst", cst);
		model.addAttribute("crslt", crslt);
		return "cmchk/exec";
	}
}
