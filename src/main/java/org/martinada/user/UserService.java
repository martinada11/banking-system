package org.martinada.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User("Mark",
                        "Adara",
                        true,
                        "14 SHD",
                        "London",
                        "E2 2HD",
                        "07663982677",
                        "mark.adara@gmail.com")
        );
    }

}
