package com.deborah.Gerenciador.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate start_date;
	
	@Column(name = "end_date")
	private LocalDate end_date;
	
	@Column(name = "status", nullable = false, length = 50)
    private String status;
	
	@Column(name = "hours", nullable = false)
    private int hours;
	
	@ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
	private Long project_id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private Long user_id;
    
    public Task() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Long getProject() {
		return project_id;
	}

	public void setProject(Long project_id) {
		this.project_id = project_id;
	}

	public Long getUser() {
		return user_id;
	}

	public void setUser(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(end_date, hours, id, project_id, start_date, status, title, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(end_date, other.end_date) && hours == other.hours && Objects.equals(id, other.id)
				&& Objects.equals(project_id, other.project_id) && Objects.equals(start_date, other.start_date)
				&& Objects.equals(status, other.status) && Objects.equals(title, other.title)
				&& Objects.equals(user_id, other.user_id);
	} 
}

