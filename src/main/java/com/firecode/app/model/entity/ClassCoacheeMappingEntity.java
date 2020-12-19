package com.firecode.app.model.entity;

import java.io.Serializable;
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

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "class_coachee_mapping", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class ClassCoacheeMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "id_class", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClassEntity idClass;

    @JoinColumn(name = "id_coachee", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private CoacheeEntity idCoachee;

    public ClassCoacheeMappingEntity() {
    }

    public ClassCoacheeMappingEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClassEntity getIdClass() {
        return idClass;
    }

    public void setIdClass(ClassEntity idClass) {
        this.idClass = idClass;
    }

    public CoacheeEntity getIdCoachee() {
        return idCoachee;
    }

    public void setIdCoachee(CoacheeEntity idCoachee) {
        this.idCoachee = idCoachee;
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
        if (!(object instanceof ClassCoacheeMappingEntity)) {
            return false;
        }
        ClassCoacheeMappingEntity other = (ClassCoacheeMappingEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ClassCoacheeMappingEntity[ id=" + id + " ]";
    }

}
