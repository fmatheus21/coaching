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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "estage_current_state", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class EstageCurrentStateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;

    @JoinColumn(name = "id_class", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClassEntity idClass;

    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;

    public EstageCurrentStateEntity() {
    }

    public EstageCurrentStateEntity(Integer id) {
        this.id = id;
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
        if (!(object instanceof EstageCurrentStateEntity)) {
            return false;
        }
        EstageCurrentStateEntity other = (EstageCurrentStateEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.EstageCurrentStateEntity[ id=" + id + " ]";
    }

}
