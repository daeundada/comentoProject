package cmtproject.comento.domain.manage.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ManageUpdateRequestDTO {

    private LocalDate manageDate;

    private String category;

    private String distinction;

    private String content;

    private Integer manageMoney;
}
