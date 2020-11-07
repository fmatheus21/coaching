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
@Table(name = "team", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamEntity.findAll", query = "SELECT t FROM TeamEntity t"),
    @NamedQuery(name = "TeamEntity.findById", query = "SELECT t FROM TeamEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TeamEntity.findByName", query = "SELECT t FROM TeamEntity t WHERE t.name = :name"),
    @NamedQuery(name = "TeamEntity.findByCreatedAt", query = "SELECT t FROM TeamEntity t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TeamEntity.findByUpdatedAt", query = "SELECT t FROM TeamEntity t WHERE t.updatedAt = :updatedAt")})
public class TeamEntity implements Serializable {

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
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<EstageCurrentStateEntity> estageCurrentStateEntityCollection;
    @JoinColumn(name = "id_coach", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CoachEntity idCoach;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<TeamSessionMappingEntity> teamSessionMappingEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<EstageContentWeekEntity> estageContentWeekEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<StageExerciseRoomEntity> stageExerciseRoomEntityCollection;

    public TeamEntity() {
    }

    public TeamEntity(Integer id) {
        this.id = id;
    }

    public TeamEntity(Integer id, String name, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    public Collection<TeamCoacheeMappingEntity> getTeamCoacheeMappingEntityCollection() {
        return teamCoacheeMappingEntityCollection;
    }

    public void setTeamCoacheeMappingEntityCollection(Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection) {
        this.teamCoacheeMappingEntityCollection = teamCoacheeMappingEntityCollection;
    }

    @XmlTransient
    public Collection<EstageCurrentStateEntity> getEstageCurrentStateEntityCollection() {
        return estageCurrentStateEntityCollection;
    }

    public void setEstageCurrentStateEntityCollection(Collection<EstageCurrentStateEntity> estageCurrentStateEntityCollection) {
        this.estageCurrentStateEntityCollection = estageCurrentStateEntityCollection;
    }

    public CoachEntity getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(CoachEntity idCoach) {
        this.idCoach = idCoach;
    }

    @XmlTransient
    public Collection<TeamSessionMappingEntity> getTeamSessionMappingEntityCollection() {
        return teamSessionMappingEntityCollection;
    }

    public void setTeamSessionMappingEntityCollection(Collection<TeamSessionMappingEntity> teamSessionMappingEntityCollection) {
        this.teamSessionMappingEntityCollection = teamSessionMappingEntityCollection;
    }

    @XmlTransient
    public Collection<EstageContentWeekEntity> getEstageContentWeekEntityCollection() {
        return estageContentWeekEntityCollection;
    }

    public void setEstageContentWeekEntityCollection(Collection<EstageContentWeekEntity> estageContentWeekEntityCollection) {
        this.estageContentWeekEntityCollection = estageContentWeekEntityCollection;
    }

    @XmlTransient
    public Collection<StageExerciseRoomEntity> getStageExerciseRoomEntityCollection() {
        return stageExerciseRoomEntityCollection;
    }

    public void setStageExerciseRoomEntityCollection(Collection<StageExerciseRoomEntity> stageExerciseRoomEntityCollection) {
        this.stageExerciseRoomEntityCollection = stageExerciseRoomEntityCollection;
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
        if (!(object instanceof TeamEntity)) {
            return false;
        }
        TeamEntity other = (TeamEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.TeamEntity[ id=" + id + " ]";
    }
    
}
