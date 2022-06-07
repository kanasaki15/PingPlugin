package xyz.n7mn.dev.pingplugin;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class EventListener implements Listener {

    @EventHandler
    public void ProxyPingEvent (ProxyPingEvent e){
        ServerPing.Protocol version = e.getResponse().getVersion();

        // minecraft.jp対策
        int mine1_19 = 759;
        if (!(version.getProtocol() >= 47 && version.getProtocol() <= mine1_19)){
            version.setProtocol(mine1_19);
        }

        version.setName("7mi-sys 1.8-1.19");
        e.getResponse().setVersion(version);
    }
    
}
