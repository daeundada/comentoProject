package cmtproject.comento.domain.manage.entity;


import cmtproject.comento.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Entity
public class Manage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long manageId;

    @Setter
    @Column(nullable = false)
    private LocalDate manageDate;

    @Setter
    @Column(nullable = false)

    private String category;

    @Setter
    @Column(nullable = false)

    private String distinction;

    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    @Column(nullable = false)
    private int manageMoney;
}
