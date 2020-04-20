package com.claimchunk.config;

import cn.nukkit.utils.Config;
import com.claimchunk.Loader;

public class PluginConfig {

    public static void init()
    {
        if(Loader.config.getAll().size() == 0)
        {
            Loader.config.set("database.name", "none");
            Loader.config.set("database.host", "none");
            Loader.config.set("database.password", "none");
            Loader.config.set("database.username", "none");
            Loader.config.set("cryptoconomyapi.isActive", false);
            Loader.config.set("cryptoconomyapi.price", "1.00000000");
            Loader.config.set("claimExpiration.isActive", false);
            Loader.config.set("claimExpiration.timeInSecond", -1);
            Loader.config.save(true);
        }
    }

}
