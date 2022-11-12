package controller;

import java.util.Scanner;

public abstract class BaseController {
    public String showInputMenu(String menu) {
        System.out.println(menu);
        System.out.print("Your choice: ");
        return new Scanner(System.in).nextLine();
    }
}
