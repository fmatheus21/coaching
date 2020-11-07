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
@Table(name = "user", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_person"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"user"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
    @NamedQuery(name = "UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UserEntity.findByUser", query = "SELECT u FROM UserEntity u WHERE u.user = :user"),
    @NamedQuery(name = "UserEntity.findByPassword", query = "SELECT u FROM UserEntity u WHERE u.password = :password"),
    @NamedQuery(name = "UserEntity.findByAvatar", query = "SELECT u FROM UserEntity u WHERE u.avatar = :avatar")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user", nullable = false, length = 45)
    private String user;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic(optional = false)
    @Column(name = "avatar", nullable = false, length = 30)
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<CoacheeEntity> coacheeEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<CoacheeEntity> coacheeEntityCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUser")
    private UserPermissionMappingEntity userPermissionMappingEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<CoachEntity> coachEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<CoachEntity> coachEntityCollection1;
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PersonEntity idPerson;
    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserStatusEntity idStatus;

    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public UserEntity(Integer id, String user, String password, String avatar) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<CoacheeEntity> getCoacheeEntityCollection() {
        return coacheeEntityCollection;
    }

    public void setCoacheeEntityCollection(Collection<CoacheeEntity> coacheeEntityCollection) {
        this.coacheeEntityCollection = coacheeEntityCollection;
    }

    @XmlTransient
    public Collection<CoacheeEntity> getCoacheeEntityCollection1() {
        return coacheeEntityCollection1;
    }

    public void setCoacheeEntityCollection1(Collection<CoacheeEntity> coacheeEntityCollection1) {
        this.coacheeEntityCollection1 = coacheeEntityCollection1;
    }

    public UserPermissionMappingEntity getUserPermissionMappingEntity() {
        return userPermissionMappingEntity;
    }

    public void setUserPermissionMappingEntity(UserPermissionMappingEntity userPermissionMappingEntity) {
        this.userPermissionMappingEntity = userPermissionMappingEntity;
    }

    @XmlTransient
    public Collection<CoachEntity> getCoachEntityCollection() {
        return coachEntityCollection;
    }

    public void setCoachEntityCollection(Collection<CoachEntity> coachEntityCollection) {
        this.coachEntityCollection = coachEntityCollection;
    }

    @XmlTransient
    public Collection<CoachEntity> getCoachEntityCollection1() {
        return coachEntityCollection1;
    }

    public void setCoachEntityCollection1(Collection<CoachEntity> coachEntityCollection1) {
        this.coachEntityCollection1 = coachEntityCollection1;
    }

    public PersonEntity getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(PersonEntity idPerson) {
        this.idPerson = idPerson;
    }

    public UserStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(UserStatusEntity idStatus) {
        this.idStatus = idStatus;
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
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UserEntity[ id=" + id + " ]";
    }
    
}
