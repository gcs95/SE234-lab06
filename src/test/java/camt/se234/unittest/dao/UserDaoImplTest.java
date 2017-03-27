package camt.se234.unittest.dao;

import camt.se234.unittest.entity.User;
import camt.se234.unittest.exception.OldDateException;
import camt.se234.unittest.exception.OldManException;
import camt.se234.unittest.service.UserServiceImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserDaoImplTest {
    @Test
    public void testGetUsers() {
        UserDao userDao = mock(UserDao.class);

        when(userDao.getUser())
                .thenReturn(Arrays.asList(
                        new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999")
                ));

        assertThat(userDao.getUser(),
                hasItems(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999")
                ));

        assertThat(userDao.getUser(),
                contains(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999")
                ));

        assertThat(userDao.getUser(),
                containsInAnyOrder(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000")
                ));

        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
    }

    @Test
    public void testPubAllow() {
        List<User> list = new ArrayList<>();
        list.add(new User("Prayuth", "1234", "Tu",
                LocalDate.of(1979, 2, 14), "08612345678"));

        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);

        thrown.expect(OldManException.class);
        assertThat(userService.getPubAllowanceUser(LocalDate.of(2017, 3, 20)), is(list));
    }

    @Test
    public void testLogin() {
        UserDao userDao = mock(UserDao.class);
        when(userDao.getUser())
                .thenReturn(Arrays.asList(
                        new User("Prayuth","1234","Tu",
                                LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung",
                                LocalDate.of(1999,8,30),"08687654321")
                ));
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
    }

    @Test
    public void testAbleToGoToPub() {
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);

        assertThat(userService.isAbleToGoToPub(new User("Gaanploo", "1111", "Myla",
                LocalDate.of(1995, 10, 30), "0234567890"), LocalDate.now()), is(true));

        thrown.expect(OldDateException.class);
        assertThat(userService.isAbleToGoToPub(new User("Bob", "qwerty", "Bob",
                LocalDate.of(2055, 1, 16), "0004400000"), LocalDate.now()), is(false));

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLoginException() {
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        userService.setUserDao(userDao);

        // check for the exception we expect
        thrown.expect(NullPointerException.class);
        userService.login("", "");

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User name must not contain special characters");
        userService.login("abcd*", "1234");


    }


}
