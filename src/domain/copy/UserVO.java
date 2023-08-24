package domain.copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok식 마스터적용법
@NoArgsConstructor //
@AllArgsConstructor //
public class UserVO {
	// private 멤버 변수 선언
	private String id;
	private String password;
	private String name;
	private String role;

	// 생성자 -> lombok으로 만드래

	// Getter/Setter 메소드

	// toString 메소드
}
