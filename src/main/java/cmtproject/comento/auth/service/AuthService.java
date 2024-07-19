package cmtproject.comento.auth.service;

import cmtproject.comento.auth.dto.AuthRequestDTO;
import cmtproject.comento.auth.entity.User;
import cmtproject.comento.auth.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUser(AuthRequestDTO authRequestDTO) {

        User user = new User();

        if (userRepository.findByUsername(authRequestDTO.getUsername()) != null) {
            throw new IllegalAccessError("중복된 사용자가 존재합니다.");
        }

        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));

        return userRepository.save(user);
    }

    public void loginUser(AuthRequestDTO authRequestDTO, HttpServletResponse response) {

        User user = userRepository.findByUsername(authRequestDTO.getUsername());

        // 비밀번호 확인
        if (!passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
