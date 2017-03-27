package camt.se234.unittest.dao;

import camt.se234.unittest.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    List<User> users;

    public UserDaoImpl() {
        users = new ArrayList<>();
        users.add(new User("Prayuth","1234","Tu",
                LocalDate.of(1979,2,14),"08612345678"));
        users.add(new User("Tucky","5675","Tuckung",
                LocalDate.of(1999,8,30),"08687654321"));
        users.add(new User("Honey", "aabbcc", "Honey",
                LocalDate.of(2012,11,13), "0000000000"));
        users.add(new User("None", "none", "NoName",
                LocalDate.of(2112,1,1), "9999999999"));
        //Phornthep//
        users.add(new User("Baibai", "5678", "Thanya",
                LocalDate.of(1997, 5, 12), "0899994567"));
        users.add(new User("Fernfern", "rrtg", "Tommy",
                LocalDate.of(1990, 3, 8), "0892374567"));
        users.add(new User("Neena", "love55", "Collept",
                LocalDate.of(1999, 1, 30), "0899994567"));
        users.add(new User("Sora", "horizon", "Aryami",
                LocalDate.of(2001, 6, 4), "0899994567"));
        //Phornthep//

        users.add(new User("Gaanploo","1111","Myla",
                LocalDate.of(1995,10,30),"0234567890"));
        users.add(new User("Baifern","5555","Fern",
                LocalDate.of(1996,12,25),"0111111111"));
        users.add(new User("Bob", "qwerty", "Bob",
                LocalDate.of(2055,1,16), "0004400000"));
        users.add(new User("Hello", "none", "Oldman",
                LocalDate.of(1915,1,10), "9992354999"));

        users.add(new User("Nora", "nilnil", "Vicheka",
                LocalDate.of(1995, 11,01), "09367862666"));
        users.add(new User("Jack", "jackpot001", "Jack The Giant Slayer",
                LocalDate.of(1989, 03, 27), "00145739859"));
        users.add(new User("Belle", "belly991", "Princess Belle",
                LocalDate.of(1990, 01, 01), "00912323423"));
        users.add(new User("Vathanaka", "3434V", "Chan",
                LocalDate.of(1995, 04,30), "01234348569"));
    }

    public List<User> getUsers(){
        return users;
    }

    @Override
    public List<User> getUser() {
        return null;
    }
}
