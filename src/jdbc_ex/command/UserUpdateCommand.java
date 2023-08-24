package jdbc_ex.command;

import org.galapagos.common.cli.input;
import org.galapagos.common.cli.command.Command;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.UserVO;

public class UserUpdateCommand implements Command {
	UserDao dao = UserDaoImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 정보 수정]");

		// 1. 수정할 userid 입력
		// 2. 기존 데이터 받기
		// 3. 기존 데이터 보여주면서 업데이트할 내용 입력받기
		// 4. 업데이트

		String userid = input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);
		if (user == null) {
			System.out.println("존재 하지 않는 ID입니다.");
			return;
		}

		// 이름 파트
		// 이름(김철수): << 괄호안에 기존 데이터가 출력되게끔
		String name = input.read("이름", user.getName());
		String role = input.read("역할", user.getRole());

		user.setName(name);
		user.setRole(role);

		dao.updateUser(user);
	}

}
