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
@Table(name = "permission", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionEntity.findAll", query = "SELECT p FROM PermissionEntity p"),
    @NamedQuery(name = "PermissionEntity.findById", query = "SELECT p FROM PermissionEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PermissionEntity.findByName", query = "SELECT p FROM PermissionEntity p WHERE p.name = :name"),
    @NamedQuery(name = "PermissionEntity.findByDescription", query = "SELECT p FROM PermissionEntity p WHERE p.description = :description")})
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @Column(name = "description", nullable = false, length = 45)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPermission")
    private Collection<UserPermissionMappingEntity> userPermissionMappingEntityCollection;

    public PermissionEntity() {
    }

    public PermissionEntity(Integer id) {
        this.id = id;
    }

    public PermissionEntity(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<UserPermissionMappingEntity> getUserPermissionMappingEntityCollection() {
        return userPermissionMappingEntityCollection;
    }

    public void setUserPermissionMappingEntityCollection(Collection<UserPermissionMappingEntity> userPermissionMappingEntityCollection) {
        this.userPermissionMappingEntityCollection = userPermissionMappingEntityCollection;
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
        if (!(object instanceof PermissionEntity)) {
            return false;
        }
        PermissionEntity other = (PermissionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PermissionEntity[ id=" + id + " ]";
    }
    
}
