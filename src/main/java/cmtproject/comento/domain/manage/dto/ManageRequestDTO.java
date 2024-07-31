package cmtproject.comento.domain.manage.dto;

import cmtproject.comento.global.entity.BaseTimeEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ManageRequestDTO extends BaseTimeEntity {

    @NotNull
    private LocalDate manageDate;

    @NotNull
    private String category;

    @NotNull
    private String distinction;

    @NotNull
    private String content;

    @NotNull
    private int manageMoney;
}
