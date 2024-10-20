package ServiceImplementaion;

import Registraton.RegistrationRequest;
import Service.UserService;
import com.auctionDemo.Auction.Entities.User;
import com.auctionDemo.Auction.Entities.VerificationToken;
import com.auctionDemo.Auction.Repository.UserRepo;
import com.auctionDemo.Auction.Repository.VerificationTokkenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImplementaion implements UserService {
    @Autowired
    private VerificationTokkenRepo verificationTokkenRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user=this.findByEmail(request.email());
        if(user.isPresent()){
            throw new com.auctionDemo.Auction.Exceptiom.UserAlreadyExistException(
                    "user already present with "+request.email());
        }
        var newUser=new User();
        newUser.setUserName(request.UserName());
        newUser.setEmail(request.email());
        newUser.setFirstname(request.Firstname());
        newUser.setLastname(request.Lastname());
        newUser.setAge(request.age());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        return userRepo.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User theuser, String verificationTokken) {
        var verificationToken=new VerificationToken(verificationTokken, theuser);
        verificationTokkenRepo.save(verificationToken);
    }
}
