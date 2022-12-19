public class Main {
    
    public static void main(String[] args) {
        CookieFile cookieFile = new CookieFile();

        System.out.println(cookieFile.GetRandomCookieFromFile("src/cookiefile.txt"));
    }
}
