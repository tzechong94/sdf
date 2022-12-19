package rating;

public class App {
    private String name;
    private String genre;
    private Double rating;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    
    @Override
    public String toString() { 
        return "App [name = " + this.name + ", genre = " + this.genre + ", rating = " + this.rating + "]";
    }

}
