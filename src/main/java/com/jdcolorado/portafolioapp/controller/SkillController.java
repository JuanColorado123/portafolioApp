package com.jdcolorado.portafolioapp.controller;

import com.jdcolorado.portafolioapp.mappers.SkillMapper;
import com.jdcolorado.portafolioapp.dto.SkillDto;
import com.jdcolorado.portafolioapp.model.Skill;
import com.jdcolorado.portafolioapp.service.ISkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping( "/skills")
public class SkillController {

    public static final String SKILLS_FORM_SKILL = "skills/form-skill";
    private final ISkillService skillService;


    @GetMapping()
    public String listSkill(Model model){

        List<Skill> skills = skillService.findAll();

        List<SkillDto> skillDtos = skills.stream().map(SkillMapper::toDto).toList();
                
        model.addAttribute("skills", skillDtos);

        return "skills/list-skills";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model ){
        model.addAttribute(("skillDto"), new SkillDto());

        return SKILLS_FORM_SKILL;
    }

    @PostMapping("/save")
    public String saveSKill(@Valid
                            @ModelAttribute("skillDto") SkillDto skillDto,
                            BindingResult result){

        if(result.hasErrors()){
            return SKILLS_FORM_SKILL;
        }

        try {
            Skill skill  = SkillMapper.toSkill(skillDto);

            skillService.save(skill);

            return "redirect:/skills";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){

        Optional<Skill> skill = skillService.findById(id);

        if(skill.isPresent()){
            SkillDto skillDto = SkillMapper.toDto(skill.get());
            model.addAttribute("skillDto", skillDto);
            return SKILLS_FORM_SKILL;
        }else {
            model.addAttribute("errorMessage", "Habilidad no encontrada con ID:");
            return "redirect:skills";
        }
    }


    @GetMapping("/personal/{personalInfoId}")
    public String listSkillsByPersonalInfoId(@PathVariable Long personalInfoId, Model model){

        List<Skill> skillList = skillService.findByPersonalId(personalInfoId);

        List<SkillDto> skillDtos = skillList.stream().map(SkillMapper::toDto).toList();

        model.addAttribute("skills", skillDtos);

        return "skills/list-skills";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){

        try {
            skillService.delete(id);
            redirectAttributes.addFlashAttribute("Habilidad Eliminada con existo");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("Error al eliminar habilidad: "+ e.getMessage());

        }

        return "redirect:/skills";
    }
}
