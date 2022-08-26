package com.project.library;

import com.project.library.Db.BookRepository;
import com.project.library.Db.OrderRepository;
import com.project.library.Db.SubscriptionRepository;
import com.project.library.Db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.library.model.Book;
import com.project.library.model.Order;
import com.project.library.model.Subscription;
import com.project.library.model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User(1, "Janesita1234", "Jane", "Doe", "12321", "ROLE_READER",false, new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Johnsito12","John", "Gomez", "12321", "ROLE_READER",false, new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Lucho65", "Luis", "Perez", "13", "ROLE_ADMIN",false, new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "Andres134","Andres", "Gomez", "42145", "ROLE_LIBRARIAN",false, new ArrayList<>(), new ArrayList<>());

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        Book book = new Book(7, "Harry Potter", "AJK Rowling", LocalDate.of(1997, 12, 31), 1, "Bloomsbury");
        Book book2 = new Book(8, "The Lord of the Rings", "BJRR Tolkien", LocalDate.of(1954, 12, 31), 1, "Bloomsbury");
        Book book3 = new Book(9, "The Hobbit", "DJRR Tolkien", LocalDate.of(1937, 12, 31), 1, "Bloomsbury");
        Book book4 = new Book(10, "The Catcher in the Rye", "EJK Rowling", LocalDate.of(1951, 12, 31), 1, "Bloomsbury");
        Book book5 = new Book(11, "The Giver", "CLois Lowry", LocalDate.of(1936, 12, 31), 1, "Bloomsbury");

        bookRepository.save(book);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);

        Order order = new Order(22, user1, book, LocalDate.of(2019, 12, 31));
        Order order2 = new Order(23, user2, book2, LocalDate.of(2019, 12, 31));
        Order order3 = new Order(24, user2, book3, LocalDate.of(2019, 12, 31));

        orderRepository.save(order);
        orderRepository.save(order2);
        orderRepository.save(order3);

        Subscription subscription = new Subscription(25, user2, book4, LocalDate.of(2019, 12, 31), LocalDate.of(2019, 12, 31), 0);
        Subscription subscription2 = new Subscription(26, user2, book5, LocalDate.of(2019, 12, 31), LocalDate.of(2019, 12, 31), 0);

        subscriptionRepository.save(subscription);
        subscriptionRepository.save(subscription2);

    }
}
