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
        UserDaoImpl userDao = new UserDaoImpl();
        assertThat(userDao.getUsers(),
                hasItems(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999")

                ));

        assertThat(userDao.getUsers(),
                contains(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999"),

                        new User("Baibai", "5678", "Thanya",
                                LocalDate.of(1997, 5, 12), "0899994567"),
                        new User("Fernfern", "rrtg", "Tommy",
                                LocalDate.of(1990, 3, 8), "0892374567"),
                        new User("Neena", "love55", "Collept",
                                LocalDate.of(1999, 1, 30), "0899994567"),
                        new User("Sora", "horizon", "Aryami",
                                LocalDate.of(2001, 6, 4), "0899994567"),

                        new User("Gaanploo", "1111", "Myla",
                                LocalDate.of(1995, 10, 30), "0234567890"),
                        new User("Baifern", "5555", "Fern",
                                LocalDate.of(1996, 12, 25), "0111111111"),
                        new User("Bob", "qwerty", "Bob",
                                LocalDate.of(2055, 1, 16), "0004400000"),
                        new User("Hello", "none", "Oldman",
                                LocalDate.of(1915, 1, 10), "9992354999"),

                        new User("Nora", "nilnil", "Vicheka",
                                LocalDate.of(1995, 11, 01), "09367862666"),
                        new User("Jack", "jackpot001", "Jack The Giant Slayer",
                                LocalDate.of(1989, 03, 27), "00145739859"),
                        new User("Belle", "belly991", "Princess Belle",
                                LocalDate.of(1990, 01, 01), "00912323423"),
                        new User("Vathanaka", "3434V", "Chan",
                                LocalDate.of(1995, 04, 30), "01234348569")

                ));
        assertThat(userDao.getUsers(),
                containsInAnyOrder(new User("Prayuth", "1234", "Tu",
                                LocalDate.of(1979, 2, 14), "08612345678"),
                        new User("Tucky", "5675", "Tuckung",
                                LocalDate.of(1999, 8, 30), "08687654321"),
                        new User("Honey", "aabbcc", "Honey",
                                LocalDate.of(2012, 11, 13), "0000000000"),
                        new User("None", "none", "NoName",
                                LocalDate.of(2112, 1, 1), "9999999999"),

                        new User("Baibai", "5678", "Thanya",
                                LocalDate.of(1997, 5, 12), "0899994567"),
                        new User("Fernfern", "rrtg", "Tommy",
                                LocalDate.of(1990, 3, 8), "0892374567"),
                        new User("Neena", "love55", "Collept",
                                LocalDate.of(1999, 1, 30), "0899994567"),
                        new User("Sora", "horizon", "Aryami",
                                LocalDate.of(2001, 6, 4), "0899994567"),

                        new User("Gaanploo", "1111", "Myla",
                                LocalDate.of(1995, 10, 30), "0234567890"),
                        new User("Baifern", "5555", "Fern",
                                LocalDate.of(1996, 12, 25), "0111111111"),
                        new User("Bob", "qwerty", "Bob",
                                LocalDate.of(2055, 1, 16), "0004400000"),
                        new User("Hello", "none", "Oldman",
                                LocalDate.of(1915, 1, 10), "9992354999"),

                        new User("Nora", "nilnil", "Vicheka",
                                LocalDate.of(1995, 11, 01), "09367862666"),
                        new User("Jack", "jackpot001", "Jack The Giant Slayer",
                                LocalDate.of(1989, 03, 27), "00145739859"),
                        new User("Belle", "belly991", "Princess Belle",
                                LocalDate.of(1990, 01, 01), "00912323423"),
                        new User("Vathanaka", "3434V", "Chan",
                                LocalDate.of(1995, 04, 30), "01234348569")

                ));

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
