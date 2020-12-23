package com.firecode.app.model.entity;

import com.firecode.app.controller.util.AppUtil;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "session", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})

public class SessionEntity implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<EstageCurrentStateEntity> estageCurrentStateEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<SessionStepMappingEntity> sessionStepMappingEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<StageExerciseRoomEntity> stageExerciseRoomEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<ClassSessionMappingEntity> classSessionMappingEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<EstageContentWeekEntity> estageContentWeekEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSession")
    private Collection<SessionGenerateEntity> sessionGenerateEntityCollection;

    public SessionEntity() {
    }

    public SessionEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        if (name != null) {
            return AppUtil.convertFirstUppercaseCharacter(name);
        }
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
    public Collection<SessionStepMappingEntity> getSessionStepMappingEntityCollection() {
        return sessionStepMappingEntityCollection;
    }

    public void setSessionStepMappingEntityCollection(Collection<SessionStepMappingEntity> sessionStepMappingEntityCollection) {
        this.sessionStepMappingEntityCollection = sessionStepMappingEntityCollection;
    }

    @XmlTransient
    public Collection<StageExerciseRoomEntity> getStageExerciseRoomEntityCollection() {
        return stageExerciseRoomEntityCollection;
    }

    public void setStageExerciseRoomEntityCollection(Collection<StageExerciseRoomEntity> stageExerciseRoomEntityCollection) {
        this.stageExerciseRoomEntityCollection = stageExerciseRoomEntityCollection;
    }

    @XmlTransient
    public Collection<ClassSessionMappingEntity> getClassSessionMappingEntityCollection() {
        return classSessionMappingEntityCollection;
    }

    public void setClassSessionMappingEntityCollection(Collection<ClassSessionMappingEntity> classSessionMappingEntityCollection) {
        this.classSessionMappingEntityCollection = classSessionMappingEntityCollection;
    }

    @XmlTransient
    public Collection<EstageContentWeekEntity> getEstageContentWeekEntityCollection() {
        return estageContentWeekEntityCollection;
    }

    public void setEstageContentWeekEntityCollection(Collection<EstageContentWeekEntity> estageContentWeekEntityCollection) {
        this.estageContentWeekEntityCollection = estageContentWeekEntityCollection;
    }

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
        if (!(object instanceof SessionEntity)) {
            return false;
        }
        SessionEntity other = (SessionEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SessionEntity[ id=" + id + " ]";
    }

}
