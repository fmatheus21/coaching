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

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "exercise_mindfulness", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"file_name"}),
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"id"})})

public class ExerciseMindfulnessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Basic(optional = false)
    @Column(name = "file_name", nullable = false, length = 50)
    private String fileName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExerciseMindfulness")
    private Collection<SessionGenerateMindfulnessEntity> sessionGenerateMindfulnessEntityCollection;

    public ExerciseMindfulnessEntity() {
    }

    public ExerciseMindfulnessEntity(Integer id) {
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
            return AppUtil.convertFirstUppercaseCharacter(AppUtil.removeDuplicateSpace(name));
        }
        return name;
    }

    public void setName(String name) {
        this.name = AppUtil.convertAllUppercaseCharacters(AppUtil.removeDuplicateSpace(name));
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Collection<SessionGenerateMindfulnessEntity> getSessionGenerateMindfulnessEntityCollection() {
        return sessionGenerateMindfulnessEntityCollection;
    }

    public void setSessionGenerateMindfulnessEntityCollection(Collection<SessionGenerateMindfulnessEntity> sessionGenerateMindfulnessEntityCollection) {
        this.sessionGenerateMindfulnessEntityCollection = sessionGenerateMindfulnessEntityCollection;
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
        if (!(object instanceof ExerciseMindfulnessEntity)) {
            return false;
        }
        ExerciseMindfulnessEntity other = (ExerciseMindfulnessEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.ExerciseMindfulnessEntity[ id=" + id + " ]";
    }

}
