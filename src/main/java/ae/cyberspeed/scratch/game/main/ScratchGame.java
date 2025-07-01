package ae.cyberspeed.scratch.game.main;


import ae.cyberspeed.scratch.game.domain.Configuration;
import ae.cyberspeed.scratch.game.service.MenuService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ScratchGame {

    public static void main(String[] args) {
        //validate input params are fine

        //1. Config file
        String configJsonFilePath = null;

        //2. Betting Amount
        Integer bettingAmount = 0;

        //3. Validate
        //3.1 any arguments
       if (args.length == 0 || args.length < 2) {
           System.err.println("No parameters given. Correct usage: [java -jar target/scratch-game-1.0.0-SNAPSHOT-jar-with-dependencies.jar --config config.json --betting-amount 100]");
           System.exit(1);
       }

       //3.3 read the arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--config")) {
                configJsonFilePath = args[++i];
            }
            else if (args[i].equals("--betting-amount")) {
                bettingAmount = Integer.valueOf(args[++i]);
            }
        }


       if (configJsonFilePath == null) {
           System.err.println("Config file not found.");
           System.exit(1);
       }

       if(bettingAmount == 0){
           System.err.println("No betting amount specified.");
           System.exit(1);
       }

       //create the json file if possible
       File configJsonFile = new File(configJsonFilePath);
       ObjectMapper objectMapper = new ObjectMapper();

       //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       Configuration configuration = null;

       try{
           configuration = objectMapper.readValue(configJsonFile, Configuration.class);
       }catch (Exception ex){
           System.err.println("Error reading configuration file. " + ex.getMessage());
           System.exit(1);
       }


       clearScreen();

       //run the menu
        MenuService menu = new MenuService(configuration, bettingAmount);
        menu.runMenu();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
