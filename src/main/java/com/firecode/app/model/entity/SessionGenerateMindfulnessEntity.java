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

/**
 *
 * @author fmatheus
 */
@Entity
@Table(name = "session_generate_mindfulness", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class SessionGenerateMindfulnessEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Lob
    @Column(name = "learning", nullable = false, length = 2147483647)
    private String learning;

    @JoinColumn(name = "id_exercise_mindfulness", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ExerciseMindfulnessEntity idExerciseMindfulness;

    @JoinColumn(name = "id_session_generate", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionGenerateEntity idSessionGenerate;

    public SessionGenerateMindfulnessEntity() {
    }

    public SessionGenerateMindfulnessEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning;
    }

    public ExerciseMindfulnessEntity getIdExerciseMindfulness() {
        return idExerciseMindfulness;
    }

    public void setIdExerciseMindfulness(ExerciseMindfulnessEntity idExerciseMindfulness) {
        this.idExerciseMindfulness = idExerciseMindfulness;
    }

    public SessionGenerateEntity getIdSessionGenerate() {
        return idSessionGenerate;
    }

    public void setIdSessionGenerate(SessionGenerateEntity idSessionGenerate) {
        this.idSessionGenerate = idSessionGenerate;
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
        if (!(object instanceof SessionGenerateMindfulnessEntity)) {
            return false;
        }
        SessionGenerateMindfulnessEntity other = (SessionGenerateMindfulnessEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.SessionGenerateMindfulnessEntity[ id=" + id + " ]";
    }

}
