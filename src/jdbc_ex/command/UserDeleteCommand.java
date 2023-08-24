package jdbc_ex.command;

import org.galapagos.common.cli.input;
import org.galapagos.common.cli.command.Command;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.UserVO;

public class UserDeleteCommand implements Command {
	UserDao dao = UserDaoImpl.getInstance();

	@Override
	public void execute() {
		System.out.println("[사용자 정보 수정]");

		String userid = input.read("사용자 ID: ");
		UserVO user = dao.getUser(userid);
		if (user == null) {
			System.out.println("존재 하지 않는 ID입니다.");
			return;
		}

		// 정말 삭제할가요? (Y/n): << y n 작성없이 엔터 쳤을때 Y로 간주함(default값)
		boolean answer = input.confirm("정말 삭제할깝쇼?", true);
		if (answer) {

			dao.deleteUser(user.getId());
			System.out.println(userid + "를 삭제했습니다.");
		}

	}

}
