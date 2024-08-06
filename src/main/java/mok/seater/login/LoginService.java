package mok.seater.login;

import lombok.RequiredArgsConstructor;
import mok.seater.login.dto.LoginRequest;
import mok.seater.login.dto.LoginResponse;
import mok.seater.login.entity.Login;
import mok.seater.store.StoreRepository;
import mok.seater.store.dto.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public boolean login(LoginRequest loginRequest) throws Exception {
        Login login = loginRepository.findByUserId(loginRequest.getUserId())
                .orElseThrow(() -> {
                    return new Exception("");
                });
        return login.getPassword().equals(loginRequest.getPassword());
    }

}
