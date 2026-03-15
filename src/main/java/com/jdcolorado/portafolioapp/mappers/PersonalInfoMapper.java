package com.jdcolorado.portafolioapp.mappers;

import com.jdcolorado.portafolioapp.dto.PersonalInfoDto;
import com.jdcolorado.portafolioapp.model.PersonalInfo;

public class PersonalInfoMapper {

    public static PersonalInfoDto toDto(PersonalInfo personalInfo){

        PersonalInfoDto personalInfoDto = new PersonalInfoDto();

        personalInfoDto.setId(personalInfo.getId());
        personalInfoDto.setFirstName(personalInfo.getFirstName());
        personalInfoDto.setLastName(personalInfo.getLastName());
        personalInfoDto.setTitle(personalInfo.getTitle());
        personalInfoDto.setProfileDescription(personalInfo.getProfileDescription());
        personalInfoDto.setProfileImageUrl(personalInfo.getProfileImageUrl());
        personalInfoDto.setYearOfExperience(personalInfo.getYearOfExperience());
        personalInfoDto.setEmail(personalInfo.getEmail());
        personalInfoDto.setPhone(personalInfo.getPhone());
        personalInfoDto.setLinkedinUrl(personalInfo.getLinkedinUrl());
        personalInfoDto.setGithubUrl(personalInfo.getGithubUrl());

        return personalInfoDto;
    }

    public static PersonalInfo toEntity(PersonalInfoDto personalInfoDto){

        PersonalInfo personalInfo = new PersonalInfo();

        personalInfo.setId(personalInfoDto.getId());
        personalInfo.setFirstName(personalInfoDto.getFirstName());
        personalInfo.setLastName(personalInfoDto.getLastName());
        personalInfo.setTitle(personalInfoDto.getTitle());
        personalInfo.setProfileDescription(personalInfoDto.getProfileDescription());
        personalInfo.setProfileImageUrl(personalInfoDto.getProfileImageUrl());
        personalInfo.setYearOfExperience(personalInfoDto.getYearOfExperience());
        personalInfo.setEmail(personalInfoDto.getEmail());
        personalInfo.setPhone(personalInfoDto.getPhone());
        personalInfo.setLinkedinUrl(personalInfoDto.getLinkedinUrl());
        personalInfo.setGithubUrl(personalInfoDto.getGithubUrl());

        return personalInfo;
    }
}
