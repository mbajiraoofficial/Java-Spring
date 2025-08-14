package com.sample.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sample.MiniProjectApplication;
import com.sample.Models.User;
import com.sample.Repos.UsersRepo;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private final MiniProjectApplication miniProjectApplication;

	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@Autowired
	private UsersRepo repo;

    AccountsController(MiniProjectApplication miniProjectApplication) {
        this.miniProjectApplication = miniProjectApplication;
    }
	
	@GetMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("user", model);
		return "signup";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user,
			@RequestParam MultipartFile file,
			RedirectAttributes redirectAttribs)
	{
		try {
			Path uploadPath=Paths.get(uploadDir);
			if(!Files.exists(uploadPath))
			{
				Files.createDirectories(uploadPath);
			}
			String OriginalFileName=file.getOriginalFilename();
			if(OriginalFileName !=null && !OriginalFileName.isEmpty())
			{
				String ext=OriginalFileName.substring(OriginalFileName.lastIndexOf("."));
				String NewFilename=System.currentTimeMillis()+ext; //generating current datetime for giving name to file
				Path filePath=uploadPath.resolve(NewFilename);
				file.transferTo(filePath.toFile());
				user.setProfilePic(NewFilename);				
			}
			
			user.setRole("USER");
			user.setIsactive(false);
			user.setPasswordLastUpdated(LocalDateTime.now());
			repo.save(user);
			
			redirectAttribs.addFlashAttribute("message", "Registered Successfully! Please wait for Admin Approval!");
			
			return "redirect:/accounts/login";
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			redirectAttribs.addFlashAttribute("message","Registration failed");
			return "redirect:/accounts/signup";
		}
	}
}
