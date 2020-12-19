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
@Table(name = "stage_exercise_room", catalog = "coaching", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Id"})})

public class StageExerciseRoomEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "learning", nullable = false, length = 2147483647)
    private String learning;

    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "decision", nullable = false, length = 2147483647)
    private String decision;

    @Lob
    @Size(max = 2147483647)
    @Column(name = "observation", length = 2147483647)
    private String observation;

    @JoinColumn(name = "id_class", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private ClassEntity idClass;

    @JoinColumn(name = "id_session", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SessionEntity idSession;

    public StageExerciseRoomEntity() {
    }

    public StageExerciseRoomEntity(Integer id) {
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

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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
        if (!(object instanceof StageExerciseRoomEntity)) {
            return false;
        }
        StageExerciseRoomEntity other = (StageExerciseRoomEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.StageExerciseRoomEntity[ id=" + id + " ]";
    }

}
