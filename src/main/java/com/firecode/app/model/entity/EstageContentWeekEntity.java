/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "estage_content_week", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstageContentWeekEntity.findAll", query = "SELECT e FROM EstageContentWeekEntity e"),
    @NamedQuery(name = "EstageContentWeekEntity.findById", query = "SELECT e FROM EstageContentWeekEntity e WHERE e.id = :id")})
public class EstageContentWeekEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;
    @JoinColumn(name = "id_team", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TeamEntity idTeam;

    public EstageContentWeekEntity() {
    }

    public EstageContentWeekEntity(Integer id) {
        this.id = id;
    }

    public EstageContentWeekEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof EstageContentWeekEntity)) {
            return false;
        }
        EstageContentWeekEntity other = (EstageContentWeekEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.EstageContentWeekEntity[ id=" + id + " ]";
    }
    
}
