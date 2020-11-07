/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "coach", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_person"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoachEntity.findAll", query = "SELECT c FROM CoachEntity c"),
    @NamedQuery(name = "CoachEntity.findById", query = "SELECT c FROM CoachEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CoachEntity.findByCreatedAt", query = "SELECT c FROM CoachEntity c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CoachEntity.findByUpdatedAt", query = "SELECT c FROM CoachEntity c WHERE c.updatedAt = :updatedAt")})
public class CoachEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoach")
    private Collection<TeamEntity> teamEntityCollection;
    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;
    @JoinColumn(name = "id_person", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PersonEntity idPerson;
    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    public CoachEntity() {
    }

    public CoachEntity(Integer id) {
        this.id = id;
    }

    public CoachEntity(Integer id, Date createdAt, Date updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<TeamEntity> getTeamEntityCollection() {
        return teamEntityCollection;
    }

    public void setTeamEntityCollection(Collection<TeamEntity> teamEntityCollection) {
        this.teamEntityCollection = teamEntityCollection;
    }

    public UserEntity getIdCreatedUser() {
        return idCreatedUser;
    }

    public void setIdCreatedUser(UserEntity idCreatedUser) {
        this.idCreatedUser = idCreatedUser;
    }

    public PersonEntity getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(PersonEntity idPerson) {
        this.idPerson = idPerson;
    }

    public UserEntity getIdUpdatedUser() {
        return idUpdatedUser;
    }

    public void setIdUpdatedUser(UserEntity idUpdatedUser) {
        this.idUpdatedUser = idUpdatedUser;
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
        if (!(object instanceof CoachEntity)) {
            return false;
        }
        CoachEntity other = (CoachEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.CoachEntity[ id=" + id + " ]";
    }
    
}
