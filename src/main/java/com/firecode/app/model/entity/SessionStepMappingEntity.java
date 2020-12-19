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
@Table(name = "session_step_mapping", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class SessionStepMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "order", nullable = false)
    private int order;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSessionStepMapping")
    private Collection<CycleSessionEntity> cycleSessionEntityCollection;

    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;

    @JoinColumn(name = "id_step", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private StepEntity idStep;

    public SessionStepMappingEntity() {
    }

    public SessionStepMappingEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @XmlTransient
    public Collection<CycleSessionEntity> getCycleSessionEntityCollection() {
        return cycleSessionEntityCollection;
    }

    public void setCycleSessionEntityCollection(Collection<CycleSessionEntity> cycleSessionEntityCollection) {
        this.cycleSessionEntityCollection = cycleSessionEntityCollection;
    }

    public SessionEntity getIdSession() {
        return idSession;
    }

    public void setIdSession(SessionEntity idSession) {
        this.idSession = idSession;
    }

    public StepEntity getIdStep() {
        return idStep;
    }

    public void setIdStep(StepEntity idStep) {
        this.idStep = idStep;
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
        if (!(object instanceof SessionStepMappingEntity)) {
            return false;
        }
        SessionStepMappingEntity other = (SessionStepMappingEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SessionStepMappingEntity[ id=" + id + " ]";
    }

}
