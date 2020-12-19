package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "person", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"cpf_cnpj"})})

public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name_companyname", nullable = false, length = 100)
    private String nameCompanyname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpf_cnpj", nullable = false, length = 20)
    private String cpfCnpj;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private CoacheeEntity coacheeEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private ContactEntity contactEntity;

    @JoinColumn(name = "id_person_type", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PersonTypeEntity idPersonType;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private CoachEntity coachEntity;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private UserEntity userEntity;

    public PersonEntity() {
    }

    public PersonEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCompanyname() {
        if (nameCompanyname != null) {
            return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(nameCompanyname));
        }
        return nameCompanyname;
    }

    public void setNameCompanyname(String nameCompanyname) {
        this.nameCompanyname = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(nameCompanyname));
    }

    public String getCpfCnpj() {
        if (cpfCnpj != null) {
            if (idPersonType.getId() == 1) {
                return AppUtil.formatCPF(cpfCnpj);
            } else if (idPersonType.getId() == 2) {
                return AppUtil.formatCNPJ(cpfCnpj);
            }
        }
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = AppUtil.removeSpecialCharacters(cpfCnpj);
    }

    public CoacheeEntity getCoacheeEntity() {
        return coacheeEntity;
    }

    public void setCoacheeEntity(CoacheeEntity coacheeEntity) {
        this.coacheeEntity = coacheeEntity;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }

    public PersonTypeEntity getIdPersonType() {
        return idPersonType;
    }

    public void setIdPersonType(PersonTypeEntity idPersonType) {
        this.idPersonType = idPersonType;
    }

    public CoachEntity getCoachEntity() {
        return coachEntity;
    }

    public void setCoachEntity(CoachEntity coachEntity) {
        this.coachEntity = coachEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonEntity)) {
            return false;
        }
        PersonEntity other = (PersonEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PersonEntity[ id=" + id + " ]";
    }

}
