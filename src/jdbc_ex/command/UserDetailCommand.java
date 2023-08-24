package jdbc_ex.command;

import org.galapagos.common.cli.input;
import org.galapagos.common.cli.command.Command;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.UserVO;

public class UserDetailCommand implements Command {
	UserDao dao = UserDaoImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[User 상세보기]");

		String userid = input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);
		System.out.println(userid);

		if (user == null) {
			System.out.println("존재 하지 않는 ID입니다.");
			return;
		}

		System.out.println("이름: " + user.getName());
		System.out.println("비밀번호: " + user.getPassword());
		System.out.println("역할: " + user.getRole());
		System.out.println("-------------------------");

	}

}
