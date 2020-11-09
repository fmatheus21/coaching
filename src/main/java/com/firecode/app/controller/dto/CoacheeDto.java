package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.GenderEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.entity.PersonTypeEntity;
import com.firecode.app.model.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CoacheeDto {

    @Getter
    @Setter
    @NotNull
    private int idGender;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String casualName;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String dateBirth;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String name;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String cpf;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Email
    private String email;
    @Getter
    @Setter
    @NotNull
    @NotBlank
    private String phone;

    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String createdAt;
    @Getter
    @Setter
    private String updatedAt;
    @Getter
    @Setter
    private int idCreatedUser;
    @Getter
    @Setter
    private int idUpdateUser;
    @Getter
    @Setter
    private String createdUser;
    @Getter
    @Setter
    private String updateUser;
    @Getter
    @Setter
    private String facebook;
    @Getter
    @Setter
    private String instagram;
    @Getter
    @Setter
    private String twitter;
    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    private String avatar;

    public PersonEntity create(CoacheeDto dto, UserEntity user) {

        PersonEntity person = new PersonEntity();
        CoacheeEntity coachee = new CoacheeEntity();
        ContactEntity contact = new ContactEntity();

        person.setIdPersonType(new PersonTypeEntity(1));
        person.setNameCompanyname(dto.getName());
        person.setCpfCnpj(dto.getCpf());

        coachee.setIdPerson(person);
        coachee.setIdGender(new GenderEntity(dto.getIdGender()));
        coachee.setCasualName(dto.getCasualName());
        coachee.setDateBirth(FormatLocalDatetUtil.converterStringToLocalDate(dto.getDateBirth()));
        coachee.setCreatedAt(FormatLocalDatetUtil.currentDateTime());
        coachee.setUpdatedAt(FormatLocalDatetUtil.currentDateTime());
        coachee.setIdCreatedUser(user);
        coachee.setIdUpdatedUser(user);
        person.setCoacheeEntity(coachee);

        contact.setIdPerson(person);
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        contact.setFacebook(dto.getFacebook());
        contact.setInstagram(dto.getInstagram());
        contact.setTwitter(dto.getTwitter());
        person.setContactEntity(contact);

        return person;
    }

    public List<CoacheeDto> reader(Iterable<CoacheeEntity> listCoachees, String avatar) {
        List<CoacheeDto> list = new ArrayList<>();
        for (CoacheeEntity coachee : listCoachees) {
            CoacheeDto dto = new CoacheeDto();
            dto.setId(coachee.getId());
            dto.setName(coachee.getIdPerson().getNameCompanyname());
            dto.setDateBirth(FormatLocalDatetUtil.converterToLocalDate(coachee.getDateBirth()));
            dto.setEmail(coachee.getIdPerson().getContactEntity().getEmail());
            dto.setPhone(coachee.getIdPerson().getContactEntity().getPhone());
            dto.setCreatedAt(FormatLocalDatetUtil.converterLocalDateTimeToString(coachee.getCreatedAt()));
            dto.setCreatedUser(coachee.getIdCreatedUser().getIdPerson().getNameCompanyname());
            dto.setAvatar(avatar);
            list.add(dto);
        }

        return list;
    }

    public CoacheeDto find(CoacheeEntity coachee) {

        CoacheeDto dto = new CoacheeDto();

        dto.setName(coachee.getIdPerson().getNameCompanyname());
        dto.setCpf(coachee.getIdPerson().getCpfCnpj());
        dto.setCasualName(coachee.getCasualName());
        dto.setGender(coachee.getIdGender().getName());
        dto.setDateBirth(FormatLocalDatetUtil.converterToLocalDate(coachee.getDateBirth()));
        dto.setEmail(coachee.getIdPerson().getContactEntity().getEmail());
        dto.setPhone(coachee.getIdPerson().getContactEntity().getPhone());

        return dto;
    }

}
