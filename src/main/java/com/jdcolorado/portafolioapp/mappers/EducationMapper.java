package com.jdcolorado.portafolioapp.mappers;

import com.jdcolorado.portafolioapp.dto.EducationDto;
import com.jdcolorado.portafolioapp.model.Education;

public class EducationMapper {

    public static EducationDto toDto(Education education){

        EducationDto educationDto = new EducationDto();

        educationDto.setId(education.getId());
        educationDto.setDegree(education.getDegree());
        educationDto.setInstitution(education.getInstitution());
        educationDto.setStartDate(education.getStartDate());
        educationDto.setEndDate(education.getEndDate());
        educationDto.setDescription(education.getDescription());
        educationDto.setPersonalInfoId(education.getPersonalInfoId());

        return educationDto;
    }

    public static Education toEntity(EducationDto educationDto){

        Education education = new Education();

        education.setId(educationDto.getId());
        education.setDegree(educationDto.getDegree());
        education.setInstitution(educationDto.getInstitution());
        education.setStartDate(educationDto.getStartDate());
        education.setEndDate(educationDto.getEndDate());
        education.setDescription(educationDto.getDescription());
        education.setPersonalInfoId(educationDto.getPersonalInfoId());

        return education;
    }
}
