package com.ojas.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exams")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Course course;
	@OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExamResult> examResults = new ArrayList<>();
	public Exam() {
		
	}
	public Exam(String title, String description, LocalDateTime dateTime, Course course, List<ExamResult> examResults) {
		super();
		this.title = title;
		this.description = description;
		this.dateTime = dateTime;
		this.course = course;
		this.examResults = examResults;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<ExamResult> getExamResults() {
		return examResults;
	}
	public void setExamResults(List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	
}
