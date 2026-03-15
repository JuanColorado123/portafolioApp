package com.jdcolorado.portafolioapp.controller;


import com.jdcolorado.portafolioapp.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ISkillService skillService;
    private final IEducationService educationService;
    private final IExperienceService experienceService;
    private final IPersonalInfoService personalInfoService;
    private final IProjectService projectService;

    @GetMapping("/")
    public String showIndex(Model model){

        model.addAttribute("personalInfos", personalInfoService.findAll().getFirst());
        model.addAttribute("experiences", experienceService.findAll());
        model.addAttribute("educations", educationService.findAll());
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("projects", projectService.findAll());

        return "index";
    }
}
