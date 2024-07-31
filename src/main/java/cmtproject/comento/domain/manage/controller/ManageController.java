package cmtproject.comento.domain.manage.controller;

import cmtproject.comento.domain.manage.dto.*;
import cmtproject.comento.domain.manage.service.ManageService;
import cmtproject.comento.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manages")
@RequiredArgsConstructor
public class ManageController {

    private final ManageService manageService;

    @PostMapping("/import")
    public ResponseEntity<ApiResponse<ManageResponseDTO>> createImport(
            @RequestBody @Valid ManageRequestDTO manageRequestDTO) {

        ManageResponseDTO manageResponseDTO = manageService.createManage(manageRequestDTO);

        return ResponseEntity.ok().body(new ApiResponse<>("수입 추가 성공", manageResponseDTO));
    }

    @GetMapping("/import")
    public ResponseEntity<ApiResponse<ManageListResponseDTO>> getImport(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "9") int size) {

        ManageListResponseDTO manageListResponseDTO = manageService.getImport(page, size);

        return ResponseEntity.ok().body(new ApiResponse<>("수입 전체 조회 성공", manageListResponseDTO));
    }

    @PostMapping("/expenses")
    public ResponseEntity<ApiResponse<ManageResponseDTO>> createExpenses(
            @RequestBody @Valid ManageRequestDTO manageRequestDTO) {

        ManageResponseDTO manageResponseDTO = manageService.createManage(manageRequestDTO);

        return ResponseEntity.ok().body(new ApiResponse<>("지출 추가 성공", manageResponseDTO));
    }

    @GetMapping("/expenses")
    public ResponseEntity<ApiResponse<ManageListResponseDTO>> getExpenses(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "9") int size) {

        ManageListResponseDTO manageListResponseDTO = manageService.getExpenses(page, size);

        return ResponseEntity.ok().body(new ApiResponse<>("지출 전체 조회 성공", manageListResponseDTO));
    }

    @GetMapping("/date")
    public ResponseEntity<ApiResponse<ManageListResponseDTO>> getManageFromDate(
            @RequestBody ManageDateRequestDTO manageDateRequestDTO,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "9") int size) {

        ManageListResponseDTO manageListResponseDTO = manageService.getManageFromDate(manageDateRequestDTO, page, size);

        return ResponseEntity.ok().body(new ApiResponse<>("날짜별 전체 조회 성공", manageListResponseDTO));
    }

    @GetMapping("/category")
    public ResponseEntity<ApiResponse<ManageListResponseDTO>> getManageFromCategory(
            @RequestBody ManageCategoryRequestDTO manageCategoryRequestDTO,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "9") int size) {

        ManageListResponseDTO manageListResponseDTO =
                manageService.getManageFromCategory(manageCategoryRequestDTO, page, size);

        return ResponseEntity.ok().body(new ApiResponse<>("카테고리별 전체 조회 성공", manageListResponseDTO));
    }

    @PostMapping("/{manageId}")
    public ResponseEntity<ApiResponse<ManageResponseDTO>> updateManage(
            @RequestBody ManageUpdateRequestDTO manageUpdateRequestDTO,
            @PathVariable("manageId") Long manageId) {

        ManageResponseDTO manageResponseDTO = manageService.updateManage(manageUpdateRequestDTO, manageId);

        return ResponseEntity.ok().body(new ApiResponse<>("수입/지출 관리 수정 성공", manageResponseDTO));
    }

    @DeleteMapping("/{manageId}")
    public ResponseEntity<ApiResponse<Void>> deleteManage(
            @PathVariable("manageId") Long manageId) {

        manageService.deleteManage(manageId);

        return ResponseEntity.ok().body(new ApiResponse<>("수입/지출 삭제 성공", null));
    }
}
