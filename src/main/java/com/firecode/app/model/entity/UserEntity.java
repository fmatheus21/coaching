package com.firecode.app.model.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "user", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_person"}),
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"username"})})

public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "avatar", nullable = false, length = 30)
    private String avatar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<CoacheeEntity> coacheeEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<CoacheeEntity> coacheeEntityCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<CycleGenerateEntity> cycleGenerateEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<CycleGenerateEntity> cycleGenerateEntityCollection1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreatedUser")
    private Collection<SessionGenerateEntity> sessionGenerateEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUpdatedUser")
    private Collection<SessionGenerateEntity> sessionGenerateEntityCollection1;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission_mapping", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_permission"))
    private List<PermissionEntity> permissions;

    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @XmlTransient
    public Collection<CycleGenerateEntity> getCycleGenerateEntityCollection() {
        return cycleGenerateEntityCollection;
    }

    public void setCycleGenerateEntityCollection(Collection<CycleGenerateEntity> cycleGenerateEntityCollection) {
        this.cycleGenerateEntityCollection = cycleGenerateEntityCollection;
    }

    @XmlTransient
    public Collection<CycleGenerateEntity> getCycleGenerateEntityCollection1() {
        return cycleGenerateEntityCollection1;
    }

    public void setCycleGenerateEntityCollection1(Collection<CycleGenerateEntity> cycleGenerateEntityCollection1) {
        this.cycleGenerateEntityCollection1 = cycleGenerateEntityCollection1;
    }

    @XmlTransient
    public Collection<SessionGenerateEntity> getSessionGenerateEntityCollection() {
        return sessionGenerateEntityCollection;
    }

    public void setSessionGenerateEntityCollection(Collection<SessionGenerateEntity> sessionGenerateEntityCollection) {
        this.sessionGenerateEntityCollection = sessionGenerateEntityCollection;
    }

    @XmlTransient
    public Collection<SessionGenerateEntity> getSessionGenerateEntityCollection1() {
        return sessionGenerateEntityCollection1;
    }

    public void setSessionGenerateEntityCollection1(Collection<SessionGenerateEntity> sessionGenerateEntityCollection1) {
        this.sessionGenerateEntityCollection1 = sessionGenerateEntityCollection1;
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

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UserEntity[ id=" + id + " ]";
    }

}
