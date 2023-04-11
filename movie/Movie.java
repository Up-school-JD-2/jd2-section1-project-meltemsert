package movie;

import java.util.Arrays;
import java.util.UUID;

public class Movie {
    private final String id;
    private final String name;
    private final String directorName;
    private final String[] actorsAndActressName;
    private final String date;
    private final String explanation;
    private boolean isSpecial;
    private final MovieType movieType;

    public Movie(String name, String directorName, String[] actorsAndActressName, String date, String explanation, boolean isSpecial, MovieType movieType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.directorName = directorName;
        this.actorsAndActressName = actorsAndActressName;
        this.date = date;
        this.explanation = explanation;
        this.isSpecial = isSpecial;
        this.movieType = movieType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String[] getActorsAndActressName() {
        return actorsAndActressName;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public MovieType getFilmType() {
        return movieType;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actorsAndActressName=" + Arrays.toString(actorsAndActressName) +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", isSpecial=" + isSpecial +
                ", movieType=" + movieType +
                '}';
    }
}
