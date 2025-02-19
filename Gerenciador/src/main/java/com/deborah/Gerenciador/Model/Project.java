package com.deborah.Gerenciador.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projetos")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 80)
	private String name;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate start_date;
	
	@Column(name = "end_date")
	private LocalDate end_date;
	
	@Column(name = "hours", nullable = false)
    private int hours;

    @Column(name = "artifact", length = 100)
    private String artifact;
    
    public Project() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getArtifact() {
		return artifact;
	}

	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artifact, end_date, hours, id, name, start_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(artifact, other.artifact) && Objects.equals(end_date, other.end_date)
				&& hours == other.hours && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(start_date, other.start_date);
	}
}

