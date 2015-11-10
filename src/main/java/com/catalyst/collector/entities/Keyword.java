package com.catalyst.collector.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Keyword {

    @Transient
    private static final String regex = "[^a-zA-Z\\d]";
    @Transient
    private static final Pattern pattern = Pattern.compile(regex);
    @Transient
    private Matcher matcher;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 255)
    private String keyword;

    public Keyword(String key) {
        keyword = key;
    }

    public Keyword() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @JsonIgnore
    public boolean isValid() {
        if (keyword == null)
            return false;
        matcher = pattern.matcher(keyword);
        return !keyword.equals("") && keyword.length() < 256 && !matcher.find();

    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
