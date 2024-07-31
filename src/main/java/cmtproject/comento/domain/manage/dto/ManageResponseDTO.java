package cmtproject.comento.domain.manage.dto;

import cmtproject.comento.domain.manage.entity.Manage;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ManageResponseDTO {

    private Long manageId;

    private LocalDate manageDate;

    private String category;

    private String distinction;

    private String content;

    private int manageMoney;

    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    public ManageResponseDTO(Manage manage) {
        this.manageId = manage.getManageId();
        this.manageMoney = manage.getManageMoney();
        this.content = manage.getContent();
        this.distinction = manage.getDistinction();
        this.category = manage.getCategory();
        this.manageDate = manage.getManageDate();
        this.createAt = manage.getCreatedAt();
        this.modifiedAt = manage.getModifiedAt();
    }
}
