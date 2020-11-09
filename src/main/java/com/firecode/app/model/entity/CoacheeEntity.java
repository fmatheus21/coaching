package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "coachee", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class CoacheeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "casual_name", nullable = false, length = 50)
    private String casualName;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at", nullable = false)   
    private LocalDateTime updatedAt;

    @JoinColumn(name = "id_gender", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private GenderEntity idGender;

    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;

    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PersonEntity idPerson;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoachee")
    private Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection;

    public CoacheeEntity() {
    }

    public CoacheeEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasualName() {
        if(casualName!=null){
            return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(casualName));
        }
        return casualName;
    }

    public void setCasualName(String casualName) {
        this.casualName = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(casualName));
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public GenderEntity getIdGender() {
        return idGender;
    }

    public void setIdGender(GenderEntity idGender) {
        this.idGender = idGender;
    }

    public PersonEntity getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(PersonEntity idPerson) {
        this.idPerson = idPerson;
    }

    public UserEntity getIdCreatedUser() {
        return idCreatedUser;
    }

    public void setIdCreatedUser(UserEntity idCreatedUser) {
        this.idCreatedUser = idCreatedUser;
    }

    public UserEntity getIdUpdatedUser() {
        return idUpdatedUser;
    }

    public void setIdUpdatedUser(UserEntity idUpdatedUser) {
        this.idUpdatedUser = idUpdatedUser;
    }

    @XmlTransient
    public Collection<TeamCoacheeMappingEntity> getTeamCoacheeMappingEntityCollection() {
        return teamCoacheeMappingEntityCollection;
    }

    public void setTeamCoacheeMappingEntityCollection(Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection) {
        this.teamCoacheeMappingEntityCollection = teamCoacheeMappingEntityCollection;
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
        if (!(object instanceof CoacheeEntity)) {
            return false;
        }
        CoacheeEntity other = (CoacheeEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.CoacheeEntity[ id=" + id + " ]";
    }

}
