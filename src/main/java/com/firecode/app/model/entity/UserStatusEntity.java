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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "user_status", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"status"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStatusEntity.findAll", query = "SELECT u FROM UserStatusEntity u"),
    @NamedQuery(name = "UserStatusEntity.findById", query = "SELECT u FROM UserStatusEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UserStatusEntity.findByStatus", query = "SELECT u FROM UserStatusEntity u WHERE u.status = :status")})
public class UserStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 45)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatus")
    private Collection<UserEntity> userEntityCollection;

    public UserStatusEntity() {
    }

    public UserStatusEntity(Integer id) {
        this.id = id;
    }

    public UserStatusEntity(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<UserEntity> getUserEntityCollection() {
        return userEntityCollection;
    }

    public void setUserEntityCollection(Collection<UserEntity> userEntityCollection) {
        this.userEntityCollection = userEntityCollection;
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
        if (!(object instanceof UserStatusEntity)) {
            return false;
        }
        UserStatusEntity other = (UserStatusEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UserStatusEntity[ id=" + id + " ]";
    }
    
}
