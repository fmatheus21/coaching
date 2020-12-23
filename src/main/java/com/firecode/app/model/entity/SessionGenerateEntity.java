package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "session_generate", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class SessionGenerateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

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

    @JoinColumn(name = "id_cycle_generate", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CycleGenerateEntity idCycleGenerate;

    @JoinColumn(name = "id_session_step_mapping", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionStepMappingEntity idSessionStepMapping;

    @JoinColumn(name = "id_created_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idCreatedUser;

    @JoinColumn(name = "id_updated_user", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UserEntity idUpdatedUser;

    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;

    public SessionGenerateEntity() {
    }

    public SessionGenerateEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CycleGenerateEntity getIdCycleGenerate() {
        return idCycleGenerate;
    }

    public void setIdCycleGenerate(CycleGenerateEntity idCycleGenerate) {
        this.idCycleGenerate = idCycleGenerate;
    }

    public SessionStepMappingEntity getIdSessionStepMapping() {
        return idSessionStepMapping;
    }

    public void setIdSessionStepMapping(SessionStepMappingEntity idSessionStepMapping) {
        this.idSessionStepMapping = idSessionStepMapping;
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

    public SessionEntity getIdSession() {
        return idSession;
    }

    public void setIdSession(SessionEntity idSession) {
        this.idSession = idSession;
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
        if (!(object instanceof SessionGenerateEntity)) {
            return false;
        }
        SessionGenerateEntity other = (SessionGenerateEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SessionGenerateEntity[ id=" + id + " ]";
    }

}
