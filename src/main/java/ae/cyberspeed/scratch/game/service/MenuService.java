package ae.cyberspeed.scratch.game.service;

public class MenuService {

    private final String configJsonFile;

    private final String configFileName;

    public MenuService(String configJsonFile, String configFileName) {
        this.configJsonFile = configJsonFile;
        this.configFileName = configFileName;

        System.out.println("******************************************************** ");
        System.out.println("           Welcome To Scratch Game ");
        System.out.println("******************************************************** ");


    }
}
