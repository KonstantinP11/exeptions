public class Main {
    public static void main(String[] args) {
        try {

            AuthenticationValidator.checkAuthentication("login", "password", "password1");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}