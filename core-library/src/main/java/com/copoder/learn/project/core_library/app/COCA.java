package com.copoder.learn.project.core_library.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by copoder on 2017/11/5.
 */

public class COCA {
    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());

        return Configurator.getInstance();
    }

    public static  WeakHashMap<String,Object> getConfigurations(){
       return Configurator.getInstance().getConfigs();
    }
}
