package com.firecode.app.model.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "team", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class TeamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection;

    @JoinColumn(name = "id_coach", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CoachEntity idCoach;

    public TeamEntity() {
    }

    public TeamEntity(Integer id) {
        this.id = id;
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

    @XmlTransient
    public Collection<TeamCoacheeMappingEntity> getTeamCoacheeMappingEntityCollection() {
        return teamCoacheeMappingEntityCollection;
    }

    public void setTeamCoacheeMappingEntityCollection(Collection<TeamCoacheeMappingEntity> teamCoacheeMappingEntityCollection) {
        this.teamCoacheeMappingEntityCollection = teamCoacheeMappingEntityCollection;
    }

    public CoachEntity getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(CoachEntity idCoach) {
        this.idCoach = idCoach;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.TeamEntity[ id=" + id + " ]";
    }

}
