package codedesign;

public class RestrictSpoofingUserTest {

    public static void main(String[] args) throws InterruptedException {
        int customerId = 12345;
        RestrictSpoofingUser restrictSpoofingUser = new RestrictSpoofingUser();
        for (int i = 0; i < 5; i++) {
            System.out.println(restrictSpoofingUser.rateLimit(customerId));
        }

        Thread.sleep(2000);

        for (int i = 0; i < 5; i++) {
            System.out.println(restrictSpoofingUser.rateLimit(customerId));
        }

    }
}
