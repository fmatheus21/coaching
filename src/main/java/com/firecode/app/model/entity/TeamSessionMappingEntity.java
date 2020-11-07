/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "team_session_mapping", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamSessionMappingEntity.findAll", query = "SELECT t FROM TeamSessionMappingEntity t"),
    @NamedQuery(name = "TeamSessionMappingEntity.findById", query = "SELECT t FROM TeamSessionMappingEntity t WHERE t.id = :id"),
    @NamedQuery(name = "TeamSessionMappingEntity.findBySessionDate", query = "SELECT t FROM TeamSessionMappingEntity t WHERE t.sessionDate = :sessionDate"),
    @NamedQuery(name = "TeamSessionMappingEntity.findBySessionHour", query = "SELECT t FROM TeamSessionMappingEntity t WHERE t.sessionHour = :sessionHour")})
public class TeamSessionMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "session_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sessionDate;
    @Basic(optional = false)
    @Column(name = "session_hour", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date sessionHour;
    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;
    @JoinColumn(name = "id_team", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TeamEntity idTeam;

    public TeamSessionMappingEntity() {
    }

    public TeamSessionMappingEntity(Integer id) {
        this.id = id;
    }

    public TeamSessionMappingEntity(Integer id, Date sessionDate, Date sessionHour) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.sessionHour = sessionHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Date getSessionHour() {
        return sessionHour;
    }

    public void setSessionHour(Date sessionHour) {
        this.sessionHour = sessionHour;
    }

    public SessionEntity getIdSession() {
        return idSession;
    }

    public void setIdSession(SessionEntity idSession) {
        this.idSession = idSession;
    }

    public TeamEntity getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(TeamEntity idTeam) {
        this.idTeam = idTeam;
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
        if (!(object instanceof TeamSessionMappingEntity)) {
            return false;
        }
        TeamSessionMappingEntity other = (TeamSessionMappingEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.TeamSessionMappingEntity[ id=" + id + " ]";
    }
    
}
