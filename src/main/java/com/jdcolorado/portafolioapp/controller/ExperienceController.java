package com.jdcolorado.portafolioapp.controller;

import com.jdcolorado.portafolioapp.dto.ExperienceDto;
import com.jdcolorado.portafolioapp.mappers.ExperienceMapper;
import com.jdcolorado.portafolioapp.model.Experience;
import com.jdcolorado.portafolioapp.service.IExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/experiences")
@RequiredArgsConstructor
@Log4j2
public class ExperienceController {

    public static final String EXPERIENCES_FORM_EXPERIENCE = "experiences/form-experiences";
    private final IExperienceService service;

    @GetMapping()
    public String listExperience(Model model){

        List<Experience> experiences = service.findAll();
        List<ExperienceDto> experienceDtos = experiences.stream().map(ExperienceMapper::toDto).toList();

        model.addAttribute("experiences", experienceDtos);

        return "experiences/list-experiences";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){

        model.addAttribute("experienceDto", new ExperienceDto());

        return EXPERIENCES_FORM_EXPERIENCE;
    }

    @PostMapping("/save")
    public String saveExperience(@Valid
                                 @ModelAttribute("experienceDto") ExperienceDto experienceDto,
                                 BindingResult result){

        if(result.hasErrors()){
            return EXPERIENCES_FORM_EXPERIENCE;
        }

        try {
            Experience experience = ExperienceMapper.toEntity(experienceDto);

            service.save(experience);
            return "redirect:/experiences";
        }catch (Exception e){

            log.info("Error al guardar experiencia {}", e.getMessage());

            return "error-page";
        }
    }


    @GetMapping("/edit/{id}")
    public String editExperience(@PathVariable Long id, Model model){

        Optional<Experience> experience = service.findById(id);

        if (experience.isPresent()){
            ExperienceDto experienceDto = ExperienceMapper.toDto(experience.get());
            model.addAttribute("experienceDto", experienceDto);
            return EXPERIENCES_FORM_EXPERIENCE;
        }else{
            model.addAttribute("errorMessage", "Experiencia no encontrada con ID:");
            return "redirect:experiences";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteExperience(@PathVariable Long id, RedirectAttributes redirectAttributes){

        try {
            service.deleteById(id);
            redirectAttributes.addFlashAttribute("Habilidad Eliminada con existo");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("Error al eliminar habilidad: "+ e.getMessage());

        }
        return "redirect:/experiences";
    }
}
