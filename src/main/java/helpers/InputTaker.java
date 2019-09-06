package helpers;

import models.UserInput;

import java.util.Scanner;

public class InputTaker {
    private Scanner scanner;

    public InputTaker() {
        this.scanner = new Scanner(System.in);
    }

    public UserInput getUserInput() {
        return new UserInput(scanner.nextLine());
    }
}
