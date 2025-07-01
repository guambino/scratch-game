package ae.cyberspeed.scratch.game.service;

public class MenuService {

    private final String configJsonFile;

    private final Integer bettingAmount;

    public MenuService(String configJsonFile, Integer bettingAmount) {
        this.configJsonFile = configJsonFile;
        this.bettingAmount = bettingAmount;
    }

    public void runMenu(){

        System.out.println("******************************************************** ");
        System.out.println("           Welcome To Scratch Game ");
        System.out.println("******************************************************** ");
        System.out.println();
        System.out.println();
        System.out.println("Config File: " + configJsonFile);
        System.out.println("Betting Amount " + bettingAmount);
        System.out.println();
        System.out.println();

    }
}
