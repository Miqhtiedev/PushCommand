package miqhtie.push;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;


public class Main extends JavaPlugin {

    private File dataFile = new File(getDataFolder(), "data.yml");
    private FileConfiguration dataConfig = YamlConfiguration.loadConfiguration(dataFile);


    @Override
    public void onEnable() {
        getCommand("push").setExecutor(new PushCommand(this));
        getCommand("pushitem").setExecutor(new PushItemCommand());

        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);

        if(!dataFile.exists()){
            saveResource("data.yml", false);
        }
    }


    public FileConfiguration getDataConfig(){
        return dataConfig;
    }

    public File getDataFile(){
        return dataFile;
    }
}
