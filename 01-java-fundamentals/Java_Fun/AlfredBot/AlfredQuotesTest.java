public class AlfredQuotesTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();


        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "evening");
        String testDateAnnouncement = alfredBot.dateAnnouncement();


        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
}
}
