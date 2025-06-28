package com.sm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sm.dto.Admin;
import com.sm.dto.Student;
import com.sm.service.StudentService;

@Controller
public class StudentController {


	@Autowired
	private StudentService studentServiceImpl;

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	
	@GetMapping("/")
	public String homePage() {

		return "redirect:/login";
	}

	@GetMapping("/showStudent")
	public String getStudentsList(Model model) {
		List<Student> fetchStudents = studentServiceImpl.fetchStudents();
		model.addAttribute("students", fetchStudents);

		return "students-list";
	}

	@GetMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student student) {
		return "add-student";
	}

	@PostMapping("/processStudent")
	public String processStudent(@ModelAttribute("student") Student student) {
		int insertedData = studentServiceImpl.addStudent(student);
		if (insertedData == 1) {
			return "redirect:/showStudent";
		} else {
			return "redirect:/add-student";
		}
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int id, Model model) {
		Student myStudent = studentServiceImpl.fetchStudentById(id);
		model.addAttribute("student", myStudent);
		return "update-student";
	}

	@PostMapping("/processUpdate")
	public String processUpdate(@ModelAttribute("student") Student student) {
		int updatedStudent = studentServiceImpl.updateStudent(student);
		if (updatedStudent == 1) {
			return "redirect:/showStudent";
		} else {
			return "/update-student";
		}
	}

	@GetMapping("/removeStudent")
	public String deleteStudent(@RequestParam("studentId") int id, Model model) {
		studentServiceImpl.deleteStudent(id);
		return "redirect:/showStudent";
	}


//	@GetMapping("/loginType")
//	public String selectLoginType() {
//		return "loginOptions";
//	}

	@GetMapping("/login")
	public String goTologinPage(@ModelAttribute("admin") Admin admin) {

		return "login";
	}

	@PostMapping("/processLogin")
	public String processLogin(@ModelAttribute("admin") Admin admin) {

		Admin isValidLogin = studentServiceImpl.getEmailAndPassword(admin);

		if(isValidLogin!=null) {
			return "adminHome";
		}
		else {
			System.out.println(isValidLogin);
			return "redirect:/login";
		}
	}

	@GetMapping("/modifyStudent")
	public String modifyStudent(@ModelAttribute("student") Student student) {
		return "student-modify";
	}

	@GetMapping("/getStudent")
	public String fetchStudentById(@RequestParam("id") int id, Model model) {
		Student student = studentServiceImpl.fetchStudentById(id);
		model.addAttribute("student", student);
		return "student-modify";
	}
	
	@PostMapping("/processStudentAction")
	public String processStudentAction(@ModelAttribute("student") Student student,
	                                 @RequestParam("action") String action, Model model) {

		try {
			if ("update".equals(action)) {
		    	studentServiceImpl.updateStudent(student);
		        return "redirect:/showStudent";
		    }
		    else if ("delete".equals(action)) {
		    	studentServiceImpl.deleteStudent(student.getId());
		        return "redirect:/showStudent";
		    }
		    return "redirect:/updateAdmin?error";
		}
		catch (Exception e) {
			model.addAttribute("error", "invalid format");
			return "student-modify";
		}
		
	}


//	@GetMapping("/profile")
//	public String goToProfilePage() {
//		return "profile";
//	}






	// Admin Section

	@GetMapping("/addAdmin")
	public String addAdmin(@ModelAttribute("admin") Admin admin) {
		return "add-admin";
	}

	@PostMapping("/processAdmin")
	public String processAdmin(@ModelAttribute("admin") Admin admin) {
		int insertedData = studentServiceImpl.addAdmin(admin);
		if (insertedData == 1) {
			return "redirect:/showAdmins";
		} else {
			return "redirect:/addAdmin";
		}
	}

	@GetMapping("/modifyAdmin")
	public String modifyAdmin(@ModelAttribute("admin") Admin admin) {
		return "admin-modify";
	}

	@GetMapping("/getAdmin")
	public String fetchAdminById(@RequestParam("adminId") int adminId, Model model) {
		Admin admin = studentServiceImpl.fetchAdminById(adminId);
		model.addAttribute("admin", admin);
		return "admin-modify";
	}

	@PostMapping("/processAdminUpdate")
	public String processAdminUpdate(@ModelAttribute("admin") Admin admin) {
		int insertedData = studentServiceImpl.addAdmin(admin);
		if (insertedData == 1) {
			return "redirect:/add-admin";
		} else {
			return "redirect:/add-admin";
		}
	}

	@GetMapping("/showAdmins")
	public String getAdminsList(Model model) {
		List<Admin> fetchAdmins = studentServiceImpl.fetchAdmins();
		model.addAttribute("admins", fetchAdmins);

		return "admin-list";
	}

	@PostMapping("/processAdminAction")
	public String processAdminAction(@ModelAttribute("admin") Admin admin,
	                                 @RequestParam("action") String action) {

		if ("update".equals(action)) {
	    	studentServiceImpl.updateAdmin(admin);
	        return "redirect:/showAdmins";
	    }
	    else if ("delete".equals(action)) {
	    	studentServiceImpl.deleteAdmin(admin.getAdminId());
	        return "redirect:/showAdmins";
	    }
	    return "redirect:/updateAdmin?error";
	}

	@GetMapping("/adminHome")
	public String backToAdminHome() {
		return "adminHome";
	}







}
