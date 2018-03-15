package cn.yinguowei.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinguowei@gmail.com 2018/3/14
 */
@SpringBootApplication
public class YinAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(YinAdminApplication.class, args);
	}
}

@RestController
class CurrentUser {
	@RequestMapping("/api/currentUser")
	public LoginUser currentUser() {
		return new LoginUser("Serati Ma",
				"https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png",
				"00000001",
				12);
	}
}

@Data
@AllArgsConstructor
class LoginUser {
	String name;
	String avatar;
	String userid;
	int notifyCount;
}