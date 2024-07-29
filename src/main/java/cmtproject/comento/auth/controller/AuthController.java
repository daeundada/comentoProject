package cmtproject.comento.auth.controller;

import cmtproject.comento.auth.dto.AuthRequestDTO;
import cmtproject.comento.auth.service.AuthService;
import cmtproject.comento.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign")
    public ResponseEntity<ApiResponse<Void>> signUser(
            @RequestBody AuthRequestDTO authRequestDTO) {

        authService.signUser(authRequestDTO);

        return ResponseEntity.ok().body(new ApiResponse<>("회원가입 성공", null));
    }
}
