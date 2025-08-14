package com.sm.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sm.dto.Admin;
import com.sm.dto.Student;
import com.sm.service.StudentService;

import jakarta.validation.Valid;

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
	public String processStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
            return "add-student";
        }
		else {
			int insertedData = studentServiceImpl.addStudent(student);
			if (insertedData == 1) {
				return "redirect:/showStudent";
			} else {
				return "redirect:/add-student";
			}			
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
	public String processLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result) {

		if (result.hasErrors()) {
            return "login"; 
        }
		else {
			Admin isValidLogin = studentServiceImpl.getEmailAndPassword(admin);

			if(isValidLogin!=null) {
				return "adminHome";
			}
			else {
				return "redirect:/login";
			}
		}
		
	}

	@GetMapping("/modifyStudent")
	public String modifyStudent(@ModelAttribute("student") Student student) {
		return "student-modify";
	}

	@GetMapping("/getStudent")
	public String fetchStudentById(@RequestParam("id") int id, Model model) {
		try {
			Student student = studentServiceImpl.fetchStudentById(id);
			model.addAttribute("student", student);
	    } catch (EmptyResultDataAccessException e) {
	        model.addAttribute("error", "Invalid ID..!");
	        model.addAttribute("student", new Student()); 
	    }
	    return "student-modify";
	}
	
	@PostMapping("/processStudentAction")
	public String processStudentAction(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model,
            @RequestParam("action") String action) {

		try {
			if (result.hasErrors()) {
	            return "student-modify"; 
	        }
			else {
				if ("update".equals(action)) {
					studentServiceImpl.updateStudent(student);
					return "redirect:/showStudent";
				}
				else if ("delete".equals(action)) {
					studentServiceImpl.deleteStudent(student.getId());
					return "redirect:/showStudent";
				}				
			}
		    return "redirect:/updateAdmin?error";
		}
		catch (Exception e) {
			model.addAttribute("error", "invalid format");
			return "student-modify";
		}
		
	}
	
	@ModelAttribute("countryList")
    public List<String> getCountries() {
        String[] countryCodes = Locale.getISOCountries();
        List<String> countries = new ArrayList<>();
        for (String code : countryCodes) {
            Locale locale = new Locale("", code);
            countries.add(locale.getDisplayCountry());
        }
        Collections.sort(countries);
        return countries;
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
	public String processAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result) {
		if(result.hasErrors()) {
			return "add-admin";
		}
		else {
			int insertedData = studentServiceImpl.addAdmin(admin);
			if (insertedData == 1) {
				return "redirect:/showAdmins";
			} else {
				return "redirect:/addAdmin";
			}			
		}
	}

	@GetMapping("/modifyAdmin")
	public String modifyAdmin(@ModelAttribute("admin") Admin admin) {
		return "admin-modify";
	}

	@GetMapping("/getAdmin")
	public String fetchAdminById(@RequestParam("adminId") int adminId, Model model) {
		try {
	        Admin admin = studentServiceImpl.fetchAdminById(adminId);
	        model.addAttribute("admin", admin);
	    } catch (EmptyResultDataAccessException e) {
	        model.addAttribute("error", "Invalid ID..!");
	        model.addAttribute("admin", new Admin()); 
	    }
	    return "admin-modify";
	}

	@GetMapping("/showAdmins")
	public String getAdminsList(Model model) {
//		List<Admin> fetchAdmins = studentServiceImpl.fetchAdmins();
//		model.addAttribute("admins", fetchAdmins);
		
		List<Admin> fetchAdmins = studentServiceImpl.fetchAdmins();
	    for (Admin admin : fetchAdmins) {
	        if (admin.getAdminPassword() != null && !admin.getAdminPassword().isEmpty()) {
	            admin.setAdminPassword("******");
	        }
	    }

	    model.addAttribute("admins", fetchAdmins);

		return "admin-list";
	}

	@PostMapping("/processAdminAction")
	public String processAdminAction(@Valid @ModelAttribute("admin") Admin admin, BindingResult result,
	                                 @RequestParam("action") String action, Model model) {
//		if(result.hasErrors()) {
//			return "admin-modify";
//		}
//		else {
//			if ("update".equals(action)) {
//				studentServiceImpl.updateAdmin(admin);
//				return "redirect:/showAdmins";
//			}
//			else if ("delete".equals(action)) {
//				studentServiceImpl.deleteAdmin(admin.getAdminId());
//				return "redirect:/showAdmins";
//			}
//			return "redirect:/updateAdmin?error";			
//		}
		
		if ("delete".equals(action)) {
	        // Skip validation for delete
	        studentServiceImpl.deleteAdmin(admin.getAdminId());
	        return "redirect:/showAdmins";
	    }
		
		if (admin.getAdminName() == null || admin.getAdminName().trim().isEmpty()) {
	        result.rejectValue("adminName", "NotBlank", "Name is required");
	    }
	    if (admin.getAdminEmail() == null || admin.getAdminEmail().trim().isEmpty()) {
	        result.rejectValue("adminEmail", "NotBlank", "Email is required");
	    }

	    // Password handling
	    if (admin.getNewPassword() != null && !admin.getNewPassword().isEmpty()) {
	        if (admin.getNewPassword().length() < 6) {
	            result.rejectValue("newPassword", "Size", "Password must be at least 6 characters long");
	        } else {
	            PasswordEncoder encoder = new BCryptPasswordEncoder();
	            admin.setAdminPassword(encoder.encode(admin.getNewPassword()));
	        }
	    } else {
	        // Keep old password if new password not entered
	        Admin existing = studentServiceImpl.fetchAdminById(admin.getAdminId());
	        admin.setAdminPassword(existing.getAdminPassword());
	    }

	    if (result.hasErrors()) {
	        return "admin-modify";
	    }

	    studentServiceImpl.updateAdmin(admin);
	    return "redirect:/showAdmins";
	}

	@GetMapping("/adminHome")
	public String backToAdminHome() {
		return "adminHome";
	}







}
