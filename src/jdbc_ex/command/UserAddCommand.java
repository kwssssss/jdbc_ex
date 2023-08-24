package jdbc_ex.command;

import org.galapagos.common.cli.input;
import org.galapagos.common.cli.command.Command;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.UserVO;

public class UserAddCommand implements Command {
	UserDao dao = UserDaoImpl.getInstance();

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("[사용자 추가]");

		String userid = input.read("사용자 ID: ");
		// id 중복 체크
		UserVO user = dao.getUser(userid);
		if (user != null) { // 이미 존재하는 ID
			System.out.println("이미 사용 중인 ID입니다.");
			return;
		}
		String password = input.read("비밀번호: ");
		String name = input.read("이름: ");
		String role = input.read("역할: ");

		user = new UserVO(userid, password, name, role);
		dao.insertUser(user);
		System.out.println("------------------------");
	}

}
