package cmtproject.comento.auth.controller;

import cmtproject.comento.auth.dto.AuthRequestDTO;
import cmtproject.comento.auth.entity.User;
import cmtproject.comento.auth.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign")
    public ResponseEntity<String> signUser(
            @RequestBody AuthRequestDTO authRequestDTO) {

        User user = authService.signUser(authRequestDTO);

        if (user != null) {
            return ResponseEntity.ok().body("회원가입 완료");
        }

        return ResponseEntity.badRequest().body("회원가입 실패");
    }

    @PostMapping("/login")
    public ResponseEntity<String> createAuthenticationToken(
            @RequestBody AuthRequestDTO authRequestDTO,
            HttpServletResponse response) {

        authService.loginUser(authRequestDTO, response);

        return ResponseEntity.ok().body("로그인 완료");
    }
}
