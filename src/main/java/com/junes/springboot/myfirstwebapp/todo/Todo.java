package com.junes.springboot.myfirstwebapp.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.boot.convert.DataSizeUnit;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//@Entity(name="TodoABC") // database 이름 지정
@Entity // 데이터베이스 테이블에 매칭됨(자동으로 H2 데이터베이스에 생성됨)
public class Todo {

    // DB id 설정 및 자동 생성 설정
    @Id
    @GeneratedValue
    private int id;

    // 컬럼 이름 설정
    @Column(name = "Username")
    private String username;

    @Size(min=10, message="Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
