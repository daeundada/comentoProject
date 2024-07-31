package cmtproject.comento.domain.manage.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ManageListResponseDTO {

    private Long totalManageCount;

    private int currentPage;

    private int totalPage;

    private int pageSize;

    private List<ManageResponseDTO> manages;

    public ManageListResponseDTO(
            List<ManageResponseDTO> manages,
            Long totalManageCount,
            int currentPage,
            int totalPage,
            int pageSize) {

        this.totalManageCount = totalManageCount;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.manages = manages;
    }
}
