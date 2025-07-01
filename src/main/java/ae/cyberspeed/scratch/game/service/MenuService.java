package ae.cyberspeed.scratch.game.service;

import ae.cyberspeed.scratch.game.domain.Configuration;

import java.util.Scanner;

public class MenuService {

    private final Configuration configuration;

    private final Integer bettingAmount;

    private static final String ASTERISK_LINE = "********************************************************";

    public MenuService(Configuration configuration, Integer bettingAmount) {
        this.configuration = configuration;
        this.bettingAmount = bettingAmount;
    }

    public void runMenu(){
        menuIntro();
        buildMenu();
    }

    private void menuIntro(){
        System.out.println(ASTERISK_LINE);
        System.out.println("           Welcome To Scratch Game                       ");
        System.out.println(ASTERISK_LINE);
        System.out.println();
        System.out.println();
        System.out.println("Betting Amount: " + bettingAmount);
        System.out.println();
        System.out.println();
    }

    private void buildMenu(){
        Scanner choice = new Scanner(System.in);

        String menuChoice = "";

        while (!menuChoice.equalsIgnoreCase("0")){
            System.out.println(ASTERISK_LINE);
            System.out.println("                     Menu                                ");
            System.out.println(ASTERISK_LINE);
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
