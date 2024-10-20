package Service;

import Registraton.RegistrationRequest;
import com.auctionDemo.Auction.Entities.User;

import java.io.StringReader;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theuser, String verificationTokken);
}
