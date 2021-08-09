import Java.Util.Date;
public class AlfredQuotes{

public String guestGreeting(String name, String dayPeriod) {

        return String.format("Good %s, %s. Lovely to see you.", dayPeriod, name);
    }

    public String dateAnnouncement() {

        return String.format("It is currently %s", new Date());
    }

    public String respondBeforeAlexis(String conversation) {

        return "";
    }
}
