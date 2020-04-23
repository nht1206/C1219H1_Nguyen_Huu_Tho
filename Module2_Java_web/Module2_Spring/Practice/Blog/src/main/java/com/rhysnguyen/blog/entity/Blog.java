package com.rhysnguyen.blog.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "content", columnDefinition = "text")
    private String content;
    @Column(name = "post_date")
    private Date PostDate;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return PostDate;
    }

    public void setPostDate(Date postDate) {
        PostDate = postDate;
    }
}
