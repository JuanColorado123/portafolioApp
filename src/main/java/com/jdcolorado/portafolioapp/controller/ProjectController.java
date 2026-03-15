package com.jdcolorado.portafolioapp.controller;

import com.jdcolorado.portafolioapp.dto.ProjectDTO;
import com.jdcolorado.portafolioapp.mappers.ProjectMapper;
import com.jdcolorado.portafolioapp.model.Project;
import com.jdcolorado.portafolioapp.service.FileStorageService;
import com.jdcolorado.portafolioapp.service.IProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final IProjectService service;
    private final FileStorageService fileStorageService;

    @GetMapping()
    public String getAllProjects(Model model){

        List<ProjectDTO> projectDTOList = service.findAll()
                         .stream()
                         .map((ProjectMapper::toDTO))
                         .toList();

        model.addAttribute("projectDTOList", projectDTOList);


        return "projects/list";
    }


    @GetMapping("/new-project")
    public String showForm(Model model ){
        model.addAttribute(("projectDto"), new ProjectDTO());
        return "projects/form-project";
    }

    @PostMapping("/save")
    public String saveProject(@Valid @ModelAttribute("projectDto") ProjectDTO projectDTO,
                              BindingResult result,
                              @RequestParam("file") MultipartFile file


    ){

        if(file.isEmpty()){
            result.rejectValue("imageUrl", "file.required", "La imagen del proyecto es obligatorio.");
        }

        if(result.hasErrors()){
            return "projects/form-project";
        }
        try {
            String imageUrl = fileStorageService.storeFile(file);

            projectDTO.setImageUrl(imageUrl);

            Project project = ProjectMapper.toProject(projectDTO);

            service.save(project);

            return "redirect:/projects";
        } catch (IOException e) {
            log.error(e.getMessage());
            return "error-page";
        }
    }
}
