package gulas.saveli.library4.UserPackage.User;

import gulas.saveli.library4.UserPackage.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String saveUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.getUserByEmail(userDto.getEmail());
        if(userOptional.isPresent()) {
            return "user with email + " + userDto.getEmail() + " already exists";
        }
        Optional<User> userOptional1 = userRepository.getUserByNameAndDob(userDto.getFirstName(),userDto.getLastName(),userDto.getDob(), userDto.getDob());
        if(userOptional1.isPresent()) {
            return "user with same name and date of birth exists";
        }
        User user = new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getDob(),
                roleRepository.findByName("user").orElseThrow(() -> new IllegalStateException("role user does not exist")));
        userRepository.save(user);
        return "user saved successfully";
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
