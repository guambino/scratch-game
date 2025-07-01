package ae.cyberspeed.scratch.game.service;

import ae.cyberspeed.scratch.game.domain.Configuration;

import java.io.File;

public class ScratchGameService {

    private final File configJsonFile;

    private Configuration configuration;

    public ScratchGameService(File configJsonFile) {
        this.configJsonFile = configJsonFile;
        
        this.configuration = new Configuration();
    }


}
