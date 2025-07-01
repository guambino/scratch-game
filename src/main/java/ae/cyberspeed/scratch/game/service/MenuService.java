package ae.cyberspeed.scratch.game.service;

import java.util.Scanner;

public class MenuService {

    private final String configJsonFile;

    private final Integer bettingAmount;

    private static final String ASTERICK_LINE = "********************************************************";

    public MenuService(String configJsonFile, Integer bettingAmount) {
        this.configJsonFile = configJsonFile;
        this.bettingAmount = bettingAmount;
    }

    public void runMenu(){
        menuIntro();
        buildMenu();
    }

    private void menuIntro(){
        System.out.println(ASTERICK_LINE);
        System.out.println("           Welcome To Scratch Game                       ");
        System.out.println(ASTERICK_LINE);
        System.out.println();
        System.out.println();
        System.out.println("Config File: " + configJsonFile);
        System.out.println("Betting Amount: " + bettingAmount);
        System.out.println();
        System.out.println();
    }

    private void buildMenu(){
        Scanner choice = new Scanner(System.in);

        String menuChoice = "";

        while (!menuChoice.equalsIgnoreCase("0")){
            System.out.println(ASTERICK_LINE);
            System.out.println("                     Menu                                ");
            System.out.println(ASTERICK_LINE);
            System.out.println(" 1. Run Game ");
            System.out.println(" 0. Exit ");
            menuChoice = choice.nextLine();

            //Options
            switch (menuChoice){
                case "1": System.out.println(" You about to run the game. "); break;
                case "0": System.exit(0); break;
            }
        }
    }
}
