import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class WebScrapper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int computeNumWords(String contents) {
        String[] words;
        words = contents.split(" ");

        return words.length;
    }

    public static int computeWordOccurrences(String contents, String word) {
        String[] words;
        words = contents.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].toLowerCase().contains(word))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String url1 = "http://erdani.com/tdpl/hamlet.txt";
        String url2 = "https://www.bls.gov/tus/charts/chart9.txt";
        String url3 = "http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt";

//        System.out.println(urlToString(url1));
        System.out.println("Number of words in URL 1: " + computeNumWords(urlToString(url1)));
        System.out.println("Number of words in URL 2: " + computeNumWords(urlToString(url2)));
        System.out.println("Number of words in URL 3: " + computeNumWords(urlToString(url3)));

        System.out.println("\nNumber of occurrences of prince in URL 1: " + computeWordOccurrences(urlToString(url1), "prince"));

    }
}
