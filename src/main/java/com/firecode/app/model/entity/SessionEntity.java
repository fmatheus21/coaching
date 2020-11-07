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
@Table(name = "session", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SessionEntity.findAll", query = "SELECT s FROM SessionEntity s"),
    @NamedQuery(name = "SessionEntity.findById", query = "SELECT s FROM SessionEntity s WHERE s.id = :id"),
    @NamedQuery(name = "SessionEntity.findByName", query = "SELECT s FROM SessionEntity s WHERE s.name = :name")})
public class SessionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<EstageCurrentStateEntity> estageCurrentStateEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<TeamSessionMappingEntity> teamSessionMappingEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<EstageContentWeekEntity> estageContentWeekEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<StageExerciseRoomEntity> stageExerciseRoomEntityCollection;

    public SessionEntity() {
    }

    public SessionEntity(Integer id) {
        this.id = id;
    }

    public SessionEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public Collection<EstageCurrentStateEntity> getEstageCurrentStateEntityCollection() {
        return estageCurrentStateEntityCollection;
    }

    public void setEstageCurrentStateEntityCollection(Collection<EstageCurrentStateEntity> estageCurrentStateEntityCollection) {
        this.estageCurrentStateEntityCollection = estageCurrentStateEntityCollection;
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
        if (!(object instanceof SessionEntity)) {
            return false;
        }
        SessionEntity other = (SessionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SessionEntity[ id=" + id + " ]";
    }
    
}
