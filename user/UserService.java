package user;

import java.util.Arrays;

public class UserService {

    private User users[] = new User[]{new User("Meltemsert", "123**", "meltem57@"),
            new User("Fadileavci", "456**", "fadileavci@")};
    public int userCount = 2;

    public User createUser(String userName, String userPassword, String email) {
        if (userName.isEmpty() || userPassword.isEmpty()) {
            System.out.println("Kullanıcı adı ve şifre boş olamaz! ");
            System.out.println("Kullanıcı isminizi ve şifrenizi girerek hesabınızı oluşturabilirsiniz.");
            return null;
        }
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(userName)) {
                return null;
            }
        }
        User createdUser = new User(userName, userPassword, email);

        if (userCount == users.length) {
            reInitializeArray();
        }
        users[userCount] = createdUser;
        userCount++;
        return createdUser;

    }

    private void reInitializeArray() {
        User[] newUserArray = new User[users.length + DomainConstant.USER_INCREASE_COUNT];
        System.arraycopy(users, 0, newUserArray, 0, users.length);
        System.out.println(newUserArray);
        users = newUserArray;
    }

    public void removeUser(String userName) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(userName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < userCount - 1; i++) {
                users[i] = users[i + 1];
            }
            users[userCount - 1] = null;
            userCount--;
            System.out.println("Kullanıcı hesabı silindi.");
        } else
            System.out.println("Kullanıcı hesabı bulunamadı.");
    }

    public void listUsers() {
        System.out.println("*********Users***********");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public User searchUser(String userName) {
        User searchedUser = null;
        for (User user : users) {
            if (user.getName().equals(userName)) {
                searchedUser = user;
                break;
            }
        }
        return searchedUser;
    }

    public User loginUser(String userName, String userPassword) {
        User loginUser = null;
        for (User user : users) {
            if (user != null) {
                if (user.getName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(userPassword)) {
                    loginUser = user;
                }
            }
        }
        return loginUser;
    }
}












