package com.sparta.mini_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false,length = 200)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "boardsId")
    private Boards boards;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
