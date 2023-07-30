import java.util.regex.Pattern;

public class AuthenticationValidator {
    private static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkAuthentication(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        checkConfirmPassword(password, confirmPassword);
    }

    private static void checkLogin(String login) {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException("Login должен быть равен или меньше " +
                    "20 символов и содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
    }

    private static void checkPassword(String password) {
        if (!password.matches(regex.pattern())) {
            throw new WrongPasswordException("Password должен быть равен или меньше " +
                    "20 символов и содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
    }

    private static void checkConfirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
    }
}
