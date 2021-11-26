package com.sparta.mini_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor  //기본 생성자를 만듬
@Builder
@AllArgsConstructor
@Entity  //테이블과 연계됨을 스피링에게 알려줌
public class Boards extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
//
//    @OneToMany(mappedBy ="board",fetch = FetchType.EAGER)//
//    private List<Comment>comment ;

}

