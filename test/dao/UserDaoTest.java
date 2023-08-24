package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.UserVO;

class UserDaoTest {
	UserDao dao = UserDaoImpl.getInstance();

	@Test
	void testInsertUser() {
		UserVO user = new UserVO("test", "1359", "테스트", "USER");
		dao.insertUser(user);

		user = dao.getUser("test");
		assertNotNull(user);
		assertEquals("test", user.getId());

	}

//	@Test
//	void testGetUserList() {
//		List<UserVO> list = dao.getUserList();
//		assertEquals(5, list.size(), "빠밤");
//
//		for (UserVO user : list) {
//			System.out.println(user);
//		}
//	}
//
//	@Test
//	void testGetUser() {
//		UserVO user = dao.getUser("admin");
//		assertNotNull(user); // null 아닌지 체크
//		assertEquals("admin", user.getId());
//	}
//
//	@Test
//	void testUpdateUser() {
//		UserVO user = dao.getUser("ssamz2");
//		user.setName("와쌘즈44");
//
//		dao.updateUser(user);
//		user = dao.getUser("ssamz2");
//
//		assertNotNull(user);
//		assertEquals("와쌘즈44", user.getName());
//	}

	@Test
	void testDeleteUser() {
		dao.deleteUser("test");

		UserVO user = dao.getUser("test");
		assertNull(user);
	}

}
