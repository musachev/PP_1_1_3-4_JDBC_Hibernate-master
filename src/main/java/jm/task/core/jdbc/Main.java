package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Петя", "Иванов", (byte) 18);
        userService.saveUser("Вася", "Петров", (byte) 25);
        userService.saveUser("Коля", "Сидоров", (byte) 33);
        userService.saveUser("Соня", "Димидова", (byte) 12);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
