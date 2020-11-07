/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "person", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"cpf_cnpj"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonEntity.findAll", query = "SELECT p FROM PersonEntity p"),
    @NamedQuery(name = "PersonEntity.findById", query = "SELECT p FROM PersonEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PersonEntity.findByNameCompanyname", query = "SELECT p FROM PersonEntity p WHERE p.nameCompanyname = :nameCompanyname"),
    @NamedQuery(name = "PersonEntity.findByCpfCnpj", query = "SELECT p FROM PersonEntity p WHERE p.cpfCnpj = :cpfCnpj")})
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name_companyname", nullable = false, length = 100)
    private String nameCompanyname;
    @Basic(optional = false)
    @Column(name = "cpf_cnpj", nullable = false, length = 20)
    private String cpfCnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private Collection<CoacheeEntity> coacheeEntityCollection;
    @JoinColumn(name = "id_person_type", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PersonTypeEntity idPersonType;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private ContactEntity contactEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private CoachEntity coachEntity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private UserEntity userEntity;

    public PersonEntity() {
    }

    public PersonEntity(Integer id) {
        this.id = id;
    }

    public PersonEntity(Integer id, String nameCompanyname, String cpfCnpj) {
        this.id = id;
        this.nameCompanyname = nameCompanyname;
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCompanyname() {
        return nameCompanyname;
    }

    public void setNameCompanyname(String nameCompanyname) {
        this.nameCompanyname = nameCompanyname;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @XmlTransient
    public Collection<CoacheeEntity> getCoacheeEntityCollection() {
        return coacheeEntityCollection;
    }

    public void setCoacheeEntityCollection(Collection<CoacheeEntity> coacheeEntityCollection) {
        this.coacheeEntityCollection = coacheeEntityCollection;
    }

    public PersonTypeEntity getIdPersonType() {
        return idPersonType;
    }

    public void setIdPersonType(PersonTypeEntity idPersonType) {
        this.idPersonType = idPersonType;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PersonEntity[ id=" + id + " ]";
    }
    
}
