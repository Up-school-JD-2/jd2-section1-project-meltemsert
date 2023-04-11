package movie;

import user.UserService;

public class MovieService {
    UserService userService = new UserService();
    public Movie movie1 = new Movie("Labirent", "Wess Ball", new String[]{" Dylan O'Brien", "Aml Ameen"}, "2014", "James Dashner'ın 2009'da yayımlanan aynı adlı romanından uyarlanmıştır", true, MovieType.FICTION);
    public Movie movie2 = new Movie("A Beautiful Mind", " Ron Howard", new String[]{"Russell Crowe", "Jennifer Connelly"}, "2001", "Amerikalı matematikçi John Nash'in hayatına dayanan bir Amerikan filmidir", false, MovieType.BIOGRAPHY);
    public Movie movie3 = new Movie("Aşk ve Gurur", "Joe Wright", new String[]{" Keira Knightley", " Matthew Macfadyen"}, "2006", "Film toprak sahibi seçkinlerinden olan bir İngiliz ailesindeki beş kız kardeşin evlilik, ahlak ve kavram yanılgılarının sorunları ile uğraşmasını konu alıyor", false, MovieType.LOVE);
    public Movie movie4 = new Movie("Ajan Salt", "Phillip Noyce", new String[]{"Angelina Jolie", "Liev Schreiber"}, "2010", "Angelina Jolie'nin federal ajanı canlandırdığı, kumpasa getirilen bir CIA mensubunun hikayesini anlatıyor.", false, MovieType.ACTION);
    public Movie movie5 = new Movie("Sonsuz Aşk", "Ahmet Katıksız", new String[]{"Fahriye Evcen,Murat Yıldırım"}, "2017", "Hiçbir ortak yönü olmayan ikili beklenmedik bir anda tanışır.", true, MovieType.LOVE);
    public Movie[] movies = new Movie[]{movie1, movie2, movie3, movie4, movie5};
    int moviesCount = 5;

    public void addMovie(String movieName, String movieDirectorName, String[] actorAndActressName, String movieDate, String movieExplanation, boolean isSpecial, String movieType) {
        for (int i = 0; i < moviesCount; i++) {
            if (movies[i].getName().equals(movieName)) {
                System.out.println("Film sistemde mevcut. Eklenemedi.");
                break;
            }
        }
        if (moviesCount == movies.length) {
            reInitializeArray();
        }
        Movie movie = new Movie(movieName, movieDirectorName, actorAndActressName, movieDate, movieExplanation, isSpecial, MovieType.valueOf(movieType));
        movies[moviesCount] = movie;
        moviesCount++;
        System.out.println("Film sisteme eklendi. " + movie.toString());
    }

    public void reInitializeArray() {
        Movie[] newMovieArray = new Movie[movies.length + DomainConstant.MOVIE_INCREASE_COUNT];
        System.arraycopy(movies, 0, newMovieArray, 0, movies.length);
        movies = newMovieArray;
    }

    public void listMovies() {
        System.out.println("*********Movies***********");
        for (Movie movie : movies) {
            if ((movie != null) && (movie.isSpecial() == false)) {
                System.out.println(movie);
            }
        }
    }

    public void listAllMovies() {
        System.out.println("*********Movies***********");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void removeAllMovie(String movieName) {
        int index = -1;
        for (int i = 0; i < moviesCount; i++) {
            if (movies[i].getName().equals(movieName) && movies[i].isSpecial() == false) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < moviesCount - 1; i++) {
                movies[i] = movies[i + 1];
            }
            movies[moviesCount - 1] = null;
            moviesCount--;
            System.out.println("Film silindi. ");
        } else
            System.out.println("Film bulunamadı");
    }

    public void removeMovie(String movieName) {
        int index = -1;
        for (int i = 0; i < moviesCount; i++) {
            if (movies[i].getName().equals(movieName) && movies[i].isSpecial() == true) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < moviesCount - 1; i++) {
                movies[i] = movies[i + 1];
            }
            movies[moviesCount - 1] = null;
            moviesCount--;
            System.out.println("Film listenizden silindi.");
        } else {
            System.out.println("Silmek istediğiniz film bulunamadı.");
        }
    }

    public Movie searchMovie(String movieName) {
        Movie searchedMovie = null;
        for (Movie movie : movies) {
            if ((movie != null) && (movie.getName().equalsIgnoreCase(movieName))) {
                searchedMovie = movie;
                break;
            }
        }
        return searchedMovie;
    }
}


