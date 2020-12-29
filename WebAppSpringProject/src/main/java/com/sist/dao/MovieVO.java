package com.sist.dao;

/*
		NO       NOT NULL NUMBER        
		CATENO            NUMBER        
		TITLE    NOT NULL VARCHAR2(200) 
		POSTER   NOT NULL VARCHAR2(300) 
		REGDATE           VARCHAR2(200) 
		GENRE    NOT NULL VARCHAR2(100) 
		GRADE    NOT NULL VARCHAR2(100) 
		ACTOR             VARCHAR2(100) 
		SCORE             VARCHAR2(20)  
		DIRECTOR NOT NULL VARCHAR2(100) 
		STORY             CLOB          
		KEY               VARCHAR2(50)  
		HIT               NUMBER      
 */
// 코틀린
// data class MovieVO
public class MovieVO {
	private int no, cateno, hit;
	private String title, poster, regdate, genre, grade, actor, score, driector, story, key;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDriector() {
		return driector;
	}

	public void setDriector(String driector) {
		this.driector = driector;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
