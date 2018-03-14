package cn.yinguowei.admin.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author yinguowei 2018/3/5.
 */
@Component
class UserData implements CommandLineRunner {
    private static final String MAIL_SUFFIX = "@example.com";
    private static final String PASSWORD = "111111";
    private static final String[] TEST_USER_NAMES = {"Anna", "Jojo", "Gary"};

    private final UserRepository userRepository;

    UserData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of(TEST_USER_NAMES).forEach(name -> userRepository.save(new User(name.toLowerCase(), PASSWORD, name, name.toLowerCase() + MAIL_SUFFIX)));
        userRepository.findAll().forEach(System.out::println);
    }
}
