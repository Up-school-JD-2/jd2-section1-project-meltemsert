import movie.MovieService;
import user.User;
import user.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        MovieService movieService = new MovieService();
        UserService userService = new UserService();
        User currentUser = null;
        do {
            while (currentUser == null) {
                printMenu();
                System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("--------------------------------");
                        System.out.println("Kullanıcı adınızı giriniz: ");
                        sc.nextLine();
                        var userName = sc.nextLine();
                        System.out.println("Kullanıcı şifrenizi giriniz: ");
                        String userPassword = sc.nextLine();
                        System.out.println("Kullanıcı mailinizi giriniz: ");
                        String email = sc.nextLine();
                        var createdUser = userService.createUser(userName, userPassword, email);
                        if (createdUser == null) {
                            System.out.println("KUllanıcı sistemde kayıtlı");
                            System.out.println("Farklı bir kullanıcı adı deneyiniz! ");
                        } else {
                            System.out.println("Kullanıcı başarıyla kaydedildi." + createdUser);
                            currentUser = createdUser;
                            System.out.println("Sisteme başarıyla giriş yapıldı. ");
                            System.out.println("Hoşgeldiniz :) " + createdUser.getName());
                        }
                        System.out.println("--------------------------------");
                    }
                    case 2 -> {
                        System.out.println("--------------------------------");
                        userService.listUsers();
                        System.out.println("--------------------------------");
                    }
                    case 3 -> {
                        System.out.println("--------------------------------");
                        sc.nextLine();
                        System.out.println("Kullanıcı adınızı girin: ");
                        var userName = sc.nextLine();
                        System.out.println("Kullanıcı şifrenizi girin: ");
                        var userPassword = sc.nextLine();
                        var loginUser = userService.loginUser(userName, userPassword);
                        if (loginUser == null) {
                            System.out.println("Kullanıcı adı veya şifre yanlış. Kontrol ederek tekrar deneyiniz! ");
                            break;
                        } else if (loginUser != null) {
                            System.out.println("Sisteme başarıyla giriş yapıldı. ");
                            System.out.println("Hoşgeldiniz :) " + loginUser.getName());
                            currentUser = loginUser;
                        }
                        System.out.println("--------------------------------");
                    }
                    case 4 -> {
                        choice = -1;
                        System.out.println("Hoşçakalın yine bekleriz.");
                    }
                    default -> printMenu();
                }
            }
            printUserMenu();
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("--------------------------------");
                    if (currentUser.getName().equals("Meltemsert")) {
                        movieService.listAllMovies();
                    } else
                        movieService.listMovies();
                    System.out.println("--------------------------------");

                }
                case 2 -> {
                    System.out.println("--------------------------------");
                    sc.nextLine();
                    System.out.println("Film ismini girin.");
                    var movieName = sc.nextLine();
                    System.out.println("Filmin yönetmen ismini girin.");
                    String movieDirectorName = sc.nextLine();
                    System.out.println("Filmin oyuncu ismini girin: ");
                    String actorName = sc.nextLine();
                    System.out.println("Filmin oyuncu ismini girin: ");
                    String actressName = sc.nextLine();
                    String[] actorAndActressName = new String[]{actressName, actorName};
                    System.out.println("Filmin çıkış tarihini girin: ");
                    String movieDate = sc.nextLine();
                    System.out.println("Filmin hakkında açıklama girin: ");
                    String movieExplanation = sc.nextLine();
                    System.out.println("Filmin türünü girin: " + ' ' + "LOVE,ACTION,BIOGRAPHY,FICTION");
                    String movieType = sc.nextLine();
                    movieService.addMovie(movieName, movieDirectorName, actorAndActressName, movieDate, movieExplanation, false, movieType);
                    System.out.println("--------------------------------");
                }
                case 3 -> {
                    System.out.println("--------------------------------");
                    sc.nextLine();
                    System.out.println("Görüntülemek istediğiniz filmin ismini giriniz: ");
                    String movieName = sc.nextLine();
                    var searchedMovie = movieService.searchMovie(movieName);
                    if (searchedMovie == null) {
                        System.out.println("Aradığınız film bulunamadı.Başka bir film aratabilir" + ' ' +
                                "ya da film listenize aradığınız filmi ekleyebilirsiniz.");

                    } else {
                        System.out.println("Aradığınız film: " + searchedMovie);
                    }
                    System.out.println("--------------------------------");
                }
                case 4 -> {
                    System.out.println("--------------------------------");
                    sc.nextLine();
                    System.out.println("Silmek istediğinizin filmin adını giriniz: ");
                    String movieName = sc.nextLine();
                    if (currentUser.getName().equals("Meltemsert")) {
                        movieService.removeMovie(movieName);
                    } else {
                        movieService.removeAllMovie(movieName);
                    }
                    System.out.println("--------------------------------");
                }
                case 5 -> {
                    System.out.println("--------------------------------");
                    sc.nextLine();
                    System.out.println("Silmek istediğiniz kullanıcı adını giriniz: ");
                    var userName = sc.nextLine();
                    userService.removeUser(userName);
                    System.out.println("--------------------------------");
                }
                case 6 -> {
                    System.out.println("--------------------------------");
                    sc.nextLine();
                    System.out.println("Görüntülemek istediğiniz kullanıcının adını giriniz:");
                    String userName = sc.nextLine();
                    var searchedUser = userService.searchUser(userName);
                    if (searchedUser == null) {
                        System.out.println("Aradığınız kullanıcı bulunamadı.");
                    } else {
                        System.out.println("Aradığınız kullanıcı: " + searchedUser);
                    }
                    System.out.println("--------------------------------");
                }
                case 7 -> {
                    System.out.println("--------------------------------");
                    currentUser = null;
                    System.out.println("Başarıyla çıkış yapıldı. Hoşçakalın ");
                    System.out.println("--------------------------------");
                }
                default -> printUserMenu();
            }
        } while (choice != -1);
    }

    private static void printMenu() {
        System.out.println("##### Menu #####");
        System.out.println("***Giriş yapabilmek için kullanıcı hesabı oluşturmanız gerekli.***");
        System.out.println("***Kullanıcı giriş bilgilerinizi girerek sisteme giriş yapabilirsiniz.***");
        System.out.println("1: Kullanıcı hesabı oluştur: ");
        System.out.println("2: Kullanıcı hesaplarını listele: ");
        System.out.println("3: Giriş için: ");
        System.out.println("4: Çıkış için: ");
    }

    private static void printUserMenu() {
        System.out.println("*** Aşağıdaki adımları takip ederek istediğiniz işlemi yapabilirsiniz.***");
        System.out.println("1: Filmleri listele: ");
        System.out.println("2: Film ekle: ");
        System.out.println("3: Film ara ");
        System.out.println("4: Film sil ");
        System.out.println("5: Kullanıcı hesabını sil: ");
        System.out.println("6: Kullanıcı hesabını arama: ");
        System.out.println("7: Çıkış için");
    }
}

