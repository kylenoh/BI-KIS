package com.northstar.bi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.northstar.bi.dto.Category;
import com.northstar.bi.dto.Criteria;
import com.northstar.bi.dto.Customer;
import com.northstar.bi.dto.Emp;
import com.northstar.bi.dto.Pagination;
import com.northstar.bi.dto.Project;
import com.northstar.bi.dto.Request;
import com.northstar.bi.service.CategoryService;
import com.northstar.bi.service.CompanyService;
import com.northstar.bi.service.EmpService;
import com.northstar.bi.service.ProjectService;
import com.northstar.bi.service.RequestService;

@Controller
public class RequestController {

	@Autowired
	RequestService requestService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProjectService projectservice;
	@Autowired
	EmpService empService;
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/request")
	public String request(@RequestParam(name="cp", required=false,defaultValue="1")int cp,
						@RequestParam(name="cateNo",required=false,defaultValue="0")int cateNo,
			  			@RequestParam(name="companyName",required=false)String companyName,
			  			@RequestParam(name="flag", required=false)String flag,
			  			@RequestParam(name="suggest", required=false)String suggest,
			  				Model model, Criteria criteria) {
		int rows= 10;
		criteria.setBeginIndex((cp-1) * rows + 1);
		criteria.setEndIndex(cp * rows);
		criteria.setCateNo(cateNo);
		criteria.setCompanyName(companyName);
		criteria.setFlag(flag);
		criteria.setSuggest(suggest);
		 
		int totalRows = requestService.getRequestCount(criteria);
		Pagination pagination = new Pagination(totalRows, cp, rows);
		
		List<Request> requestList = requestService.getRequestByCriteria(criteria);
		List<Category> categoryList = categoryService.getRequestCategoryList();
		
		model.addAttribute("requestList",requestList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("pagination",pagination);
		return "request/request";
	}
	
	@RequestMapping(value="addRequest", method=RequestMethod.GET)
	public String addRequestForm(Model model) {
		List<Category> categoryList = categoryService.getRequestCategoryList();
		List<Project> projectList = projectservice.getProjectList();
		
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("projectList",projectList);
		return "request/requestAddForm";
	}
	@RequestMapping(value="requestDetail")
	public String requestDetail(Model model, int requestNo) {
		Request request = requestService.getRequestByNo(requestNo);
		model.addAttribute("request",request);
		return "request/requestDetail";
	}
	@RequestMapping(value="addRequest", method=RequestMethod.POST)
	public String addRequest(@RequestParam(name="categoryNo")int categoryNo,
							@RequestParam(name="pjtNo")int pjtNo,
							@RequestParam(name="customerNo")int customerNo,
							@RequestParam(name="startDate")String startDate,
							@RequestParam(name="endDate", required=false,defaultValue="nodate")String endDate,
							@RequestParam(name="flag")String flag,
							@RequestParam(name="suggest")String suggest,
							@RequestParam(name="handle", required=false)String handle,
								HttpSession session)throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Request request = new Request();
		int requestNo = requestService.getRequestNo();
		Category category = categoryService.getCategoryByCategoryNo(categoryNo);
		Project project = projectservice.getProjectByNo(pjtNo);
		Customer customer = companyService.getCustomerByNo(customerNo);
		Emp emp = (Emp) session.getAttribute("LOGIN_EMP");
		
		request.setNo(requestNo);
		request.setCustomer(customer);
		request.setProject(project);
		request.setEmp(emp);
		request.setCategory(category);
		request.setSuggest(suggest);
		request.setHandle(handle);
		request.setStartDate(formatter.parse(startDate));
		request.setEndDate(formatter.parse(endDate));
		request.setFlag(flag);
		if ("Y".equals(flag)) {
			request.setMsg("진행예정");
		}
		if ("P".equals(flag)) {
			request.setMsg("진행중");
		}
		if ("N".equals(flag)) {
			request.setMsg("종료");
		}
		
		requestService.addRequest(request);
		return "redirect:/request";
	}
	@RequestMapping(value="requestDelete")
	public String requestDelete(int requestNo) {
		requestService.deleteRequest(requestNo);
		return "redirect:/request";
	}
	@RequestMapping(value="requestModify", method=RequestMethod.GET)
	public String requestModifyForm(Model model, int requestNo) {
		Request request = requestService.getRequestByNo(requestNo);
		List<Category> categoryList = categoryService.getRequestCategoryList();
		List<Customer> customerList = companyService.getCustomerListByCompanyNo(request.getProject().getCompany().getNo());
		
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("customerList",customerList);
		model.addAttribute("request",request);
		return "request/requestModifyForm";
	}
	@RequestMapping(value="requestModify", method=RequestMethod.POST)
	public String requestModify(@RequestParam("requestNo")int requestNo,
								@RequestParam(name="categoryNo")int categoryNo,
								@RequestParam(name="pjtNo")int pjtNo,
								@RequestParam(name="customerNo")int customerNo,
								@RequestParam(name="startDate")String startDate,
								@RequestParam(name="endDate", required=false,defaultValue="nodate")String endDate,
								@RequestParam(name="flag")String flag,
								@RequestParam(name="suggest")String suggest,
								@RequestParam(name="handle", required=false)String handle)throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Request request = requestService.getRequestByNo(requestNo);
		Category category = categoryService.getCategoryByCategoryNo(categoryNo);
		Project project = projectservice.getProjectByNo(pjtNo);
		Customer customer = companyService.getCustomerByNo(customerNo);
		
		request.setCustomer(customer);
		request.setProject(project);
		request.setCategory(category);
		request.setSuggest(suggest);
		request.setHandle(handle);
		request.setStartDate(formatter.parse(startDate));
		request.setEndDate(formatter.parse(endDate));
		request.setFlag(flag);
		if ("Y".equals(flag)) {
			request.setMsg("진행예정");
		}
		if ("P".equals(flag)) {
			request.setMsg("진행중");
		}
		if ("N".equals(flag)) {
			request.setMsg("종료");
		}
		
		requestService.modifyRequest(request);
		return "redirect:/requestDetail?requestNo=" + requestNo;
	}
}
