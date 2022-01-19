package com.subhakar.spring.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
@Table(name = "tbl_posts")
public class Post {
    @SequenceGenerator(
            name = "posts_generator",
            sequenceName = "posts_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "posts_generator",
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}
