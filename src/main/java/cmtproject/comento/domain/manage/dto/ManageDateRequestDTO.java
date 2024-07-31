package cmtproject.comento.domain.manage.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ManageDateRequestDTO {

    private LocalDate startDate;

    private LocalDate endDate;
}
