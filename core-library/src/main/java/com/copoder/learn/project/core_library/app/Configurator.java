package com.copoder.learn.project.core_library.app;

import java.util.WeakHashMap;

/**
 * Created by copoder on 2017/11/5.
 */

public class Configurator {
    public static final WeakHashMap<String,Object> CONFIGS = new WeakHashMap<String,Object>();

    private Configurator(){
        CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public final void configFinish(){
        CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    final WeakHashMap<String,Object> getConfigs(){
        return CONFIGS;
    }

    public static class Holder{
        public static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    public final Configurator withApiHost(String host){
        CONFIGS.put(ConfigType.APP_HOST.name(),host);
        return this;
    }

    private void checkConfigFinish(){
        boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY);
        if (!isReady){
            throw new RuntimeException("APP IS NOT CONFIG READY!");
        }
    }

    //没看懂
    @SuppressWarnings("unchecked")
    final <T> T getConfigFinish(Enum<ConfigType> key){
        checkConfigFinish();
        return (T) CONFIGS.get(key);
    }
}
