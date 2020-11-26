package com.firecode.app.controller.dto;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.model.entity.CoacheeEntity;
import com.firecode.app.model.entity.ContactEntity;
import com.firecode.app.model.entity.GenderEntity;
import com.firecode.app.model.entity.PersonEntity;
import com.firecode.app.model.entity.PersonTypeEntity;
import com.firecode.app.model.entity.UserEntity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

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

    public PersonEntity create(CoacheeDto dto, UserEntity user, String image) {

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
        coachee.setImage(image);
        coachee.setSearch(
                CoacheeDto.converterJson(
                        dto.getName(),
                        dto.getCpf(),
                        dto.getEmail(),
                        dto.getPhone()
                )
        );
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

    public PersonEntity update(PersonEntity person, CoacheeDto dto, UserEntity user) {

        person.setIdPersonType(new PersonTypeEntity(1));
        person.setNameCompanyname(dto.getName());
        person.setCpfCnpj(dto.getCpf());

        person.getCoacheeEntity().setIdGender(new GenderEntity(dto.getIdGender()));
        person.getCoacheeEntity().setCasualName(dto.getCasualName());
        person.getCoacheeEntity().setDateBirth(FormatLocalDatetUtil.converterStringToLocalDate(dto.getDateBirth()));
        person.getCoacheeEntity().setCreatedAt(FormatLocalDatetUtil.currentDateTime());
        person.getCoacheeEntity().setUpdatedAt(FormatLocalDatetUtil.currentDateTime());
        person.getCoacheeEntity().setIdCreatedUser(user);
        person.getCoacheeEntity().setIdUpdatedUser(user);
        person.getCoacheeEntity().setSearch(
                CoacheeDto.converterJson(
                        dto.getName(),
                        dto.getCpf(),
                        dto.getEmail(),
                        dto.getPhone()
                )
        );

        person.getContactEntity().setEmail(dto.getEmail());
        person.getContactEntity().setPhone(dto.getPhone());
        person.getContactEntity().setFacebook(dto.getFacebook());
        person.getContactEntity().setInstagram(dto.getInstagram());
        person.getContactEntity().setTwitter(dto.getTwitter());

        return person;
    }

    public static CoacheeDto converterObject(CoacheeEntity coachee) {
        CoacheeDto dto = new CoacheeDto();
        String avatar = "/app/upload/avatar/coachee/" + coachee.getImage();
        dto.setId(coachee.getId());
        dto.setName(coachee.getIdPerson().getNameCompanyname());
        dto.setCpf(coachee.getIdPerson().getCpfCnpj());
        dto.setCasualName(coachee.getCasualName());
        dto.setGender(coachee.getIdGender().getName());
        dto.setDateBirth(FormatLocalDatetUtil.converterToLocalDate(coachee.getDateBirth()));
        dto.setEmail(coachee.getIdPerson().getContactEntity().getEmail());
        dto.setPhone(coachee.getIdPerson().getContactEntity().getPhone());
        dto.setCreatedAt(FormatLocalDatetUtil.converterLocalDateTimeToString(coachee.getCreatedAt()));
        dto.setCreatedUser(coachee.getIdCreatedUser().getIdPerson().getNameCompanyname());
        dto.setAvatar(avatar);
        dto.setIdGender(coachee.getIdGender().getId());
        dto.setFacebook(coachee.getIdPerson().getContactEntity().getFacebook());
        dto.setInstagram(coachee.getIdPerson().getContactEntity().getInstagram());
        dto.setTwitter(coachee.getIdPerson().getContactEntity().getTwitter());
        return dto;
    }

    public CoacheeDto find(CoacheeEntity coachee, String avatar) {

        CoacheeDto dto = new CoacheeDto();

        dto.setId(coachee.getId());
        dto.setName(coachee.getIdPerson().getNameCompanyname());
        dto.setCpf(coachee.getIdPerson().getCpfCnpj());
        dto.setCasualName(coachee.getCasualName());
        dto.setGender(coachee.getIdGender().getName());
        dto.setDateBirth(FormatLocalDatetUtil.converterToLocalDate(coachee.getDateBirth()));
        dto.setEmail(coachee.getIdPerson().getContactEntity().getEmail());
        dto.setPhone(coachee.getIdPerson().getContactEntity().getPhone());
        dto.setAvatar(avatar + coachee.getImage());
        dto.setIdGender(coachee.getIdGender().getId());
        dto.setFacebook(coachee.getIdPerson().getContactEntity().getFacebook());
        dto.setInstagram(coachee.getIdPerson().getContactEntity().getInstagram());
        dto.setTwitter(coachee.getIdPerson().getContactEntity().getTwitter());

        return dto;
    }

    public static String converterJson(String name, String document, String email, String phone) {
        JSONObject obj = new JSONObject();
        obj.put("name", AppUtil.convertAllLowercaseCharacters(name));
        obj.put("document", AppUtil.removeSpecialCharacters(document));
        obj.put("email", AppUtil.convertAllLowercaseCharacters(email));
        obj.put("phone", AppUtil.convertAllLowercaseCharacters(phone));
        return obj.toString();
    }

}
