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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "cycle_generate", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cycle_coache"}),
    @UniqueConstraint(columnNames = {"id"})})

public class CycleGenerateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "cycle_coache", nullable = false)
    private int cycleCoache;

    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Basic(optional = false)
    @NotNull
    @Column(name = "done", nullable = false)
    private boolean done;

    @JoinColumn(name = "id_coachee", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CoacheeEntity idCoachee;

    @JoinColumn(name = "id_cycle", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CycleEntity idCycle;

    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;

    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCycleGenerate")
    private Collection<SessionGenerateEntity> sessionGenerateEntityCollection;

    public CycleGenerateEntity() {
    }

    public CycleGenerateEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCycleCoache() {
        return cycleCoache;
    }

    public void setCycleCoache(int cycleCoache) {
        this.cycleCoache = cycleCoache;
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

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public CoacheeEntity getIdCoachee() {
        return idCoachee;
    }

    public void setIdCoachee(CoacheeEntity idCoachee) {
        this.idCoachee = idCoachee;
    }

    public CycleEntity getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(CycleEntity idCycle) {
        this.idCycle = idCycle;
    }

    public UserEntity getIdCreatedUser() {
        return idCreatedUser;
    }

    public void setIdCreatedUser(UserEntity idCreatedUser) {
        this.idCreatedUser = idCreatedUser;
    }

    public UserEntity getIdUpdatedUser() {
        return idUpdatedUser;
    }

    public void setIdUpdatedUser(UserEntity idUpdatedUser) {
        this.idUpdatedUser = idUpdatedUser;
    }

    @XmlTransient
    public Collection<SessionGenerateEntity> getSessionGenerateEntityCollection() {
        return sessionGenerateEntityCollection;
    }

    public void setSessionGenerateEntityCollection(Collection<SessionGenerateEntity> sessionGenerateEntityCollection) {
        this.sessionGenerateEntityCollection = sessionGenerateEntityCollection;
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
        if (!(object instanceof CycleGenerateEntity)) {
            return false;
        }
        CycleGenerateEntity other = (CycleGenerateEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.CycleGenerateEntity[ id=" + id + " ]";
    }

}
