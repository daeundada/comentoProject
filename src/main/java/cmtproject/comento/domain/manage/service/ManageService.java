package cmtproject.comento.domain.manage.service;

import cmtproject.comento.domain.manage.dto.*;
import cmtproject.comento.domain.manage.entity.Manage;
import cmtproject.comento.domain.manage.repository.ManageRepository;
import cmtproject.comento.global.response.CustomException;
import cmtproject.comento.global.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManageService {

    private final ManageRepository manageRepository;

    public ManageResponseDTO createManage(ManageRequestDTO manageRequestDTO) {

        Manage manage = new Manage();

        manage.setManageDate(manageRequestDTO.getManageDate());
        manage.setCategory(manageRequestDTO.getCategory());
        manage.setDistinction(manageRequestDTO.getDistinction());
        manage.setContent(manageRequestDTO.getContent());
        manage.setManageMoney(manageRequestDTO.getManageMoney());

        manageRepository.save(manage);

        return new ManageResponseDTO(manage);
    }

    public ManageListResponseDTO getImport(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Manage> managePage = manageRepository.findByDistinction("수입", pageable);

        List<ManageResponseDTO> manageResponseDTOS = managePage.stream()
                .map(ManageResponseDTO::new)
                .toList();

        return new ManageListResponseDTO(
                manageResponseDTOS,
                managePage.getTotalElements(),
                managePage.getNumber(),
                managePage.getTotalPages(),
                managePage.getSize());
    }

    public ManageListResponseDTO getExpenses(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Manage> managePage = manageRepository.findByDistinction("지출", pageable);

        List<ManageResponseDTO> manageResponseDTOS = managePage.stream()
                .map(ManageResponseDTO::new)
                .toList();

        return new ManageListResponseDTO(
                manageResponseDTOS,
                managePage.getTotalElements(),
                managePage.getNumber(),
                managePage.getTotalPages(),
                managePage.getSize());
    }

    public ManageListResponseDTO getManageFromDate(
            ManageDateRequestDTO manageDateRequestDTO,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Manage> managePage = manageRepository.findByManageDateBetween(
                manageDateRequestDTO.getStartDate(),
                manageDateRequestDTO.getEndDate(),
                pageable);

        List<ManageResponseDTO> manageResponseDTOS = managePage.stream()
                .map(ManageResponseDTO::new)
                .toList();

        return new ManageListResponseDTO(
                manageResponseDTOS,
                managePage.getTotalElements(),
                managePage.getNumber(),
                managePage.getTotalPages(),
                managePage.getSize());
    }

    public ManageListResponseDTO getManageFromCategory(
            ManageCategoryRequestDTO manageCategoryRequestDTO,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Manage> managePage = manageRepository.findByCategory(manageCategoryRequestDTO.getCategory(), pageable);

        List<ManageResponseDTO> manageResponseDTOS = managePage.stream()
                .map(ManageResponseDTO::new)
                .toList();

        return new ManageListResponseDTO(
                manageResponseDTOS,
                managePage.getTotalElements(),
                managePage.getNumber(),
                managePage.getTotalPages(),
                managePage.getSize());
    }

    public ManageResponseDTO updateManage(ManageUpdateRequestDTO manageUpdateRequestDTO, Long manageId) {

        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        if (manageUpdateRequestDTO.getManageDate() != null) {
            manage.setManageDate(manageUpdateRequestDTO.getManageDate());
        }
        if (manageUpdateRequestDTO.getCategory() != null) {
            manage.setCategory(manageUpdateRequestDTO.getCategory());
        }
        if (manageUpdateRequestDTO.getDistinction() != null) {
            manage.setDistinction(manageUpdateRequestDTO.getDistinction());
        }
        if (manageUpdateRequestDTO.getContent() != null) {
            manage.setContent(manageUpdateRequestDTO.getContent());
        }
        if (manageUpdateRequestDTO.getManageMoney() != null) {
            manage.setManageMoney(manageUpdateRequestDTO.getManageMoney());
        }

        manageRepository.save(manage);

        return new ManageResponseDTO(manage);
    }

    public void deleteManage(Long manageId) {

        Manage manage = manageRepository.findById(manageId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        manageRepository.delete(manage);
    }
}
