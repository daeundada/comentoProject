package cmtproject.comento.domain.auth.service;

import cmtproject.comento.domain.auth.dto.AuthRequestDTO;
import cmtproject.comento.domain.auth.entity.User;
import cmtproject.comento.domain.auth.repository.UserRepository;
import cmtproject.comento.global.response.CustomException;
import cmtproject.comento.global.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUser(AuthRequestDTO authRequestDTO) {

        User user = new User();

        if (userRepository.findByUsername(authRequestDTO.getUsername()).isPresent()) {
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));

        userRepository.save(user);
    }
}
