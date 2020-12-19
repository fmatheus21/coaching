package com.firecode.app.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "class_session_mapping", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class ClassSessionMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "session_date", nullable = false)
    private LocalDate sessionDate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "session_hour", nullable = false)
    private LocalDateTime sessionHour;

    @JoinColumn(name = "id_class", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClassEntity idClass;

    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;

    public ClassSessionMappingEntity() {
    }

    public ClassSessionMappingEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public LocalDateTime getSessionHour() {
        return sessionHour;
    }

    public void setSessionHour(LocalDateTime sessionHour) {
        this.sessionHour = sessionHour;
    }

    public ClassEntity getIdClass() {
        return idClass;
    }

    public void setIdClass(ClassEntity idClass) {
        this.idClass = idClass;
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
        if (!(object instanceof ClassSessionMappingEntity)) {
            return false;
        }
        ClassSessionMappingEntity other = (ClassSessionMappingEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ClassSessionMappingEntity[ id=" + id + " ]";
    }

}
