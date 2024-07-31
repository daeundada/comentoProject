package cmtproject.comento.global.detail;

import cmtproject.comento.domain.auth.entity.User;
import cmtproject.comento.domain.auth.repository.UserRepository;
import cmtproject.comento.global.response.CustomException;
import cmtproject.comento.global.response.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        return new UserDetailsImpl(user);
    }
}