package xyz.n7mn.dev.pingplugin;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;


public class EventListener implements Listener {

    @EventHandler
    public void ProxyPingEvent (ProxyPingEvent e){
        ServerPing.Protocol version = e.getResponse().getVersion();
        version.setName("7mi-sys 1.8-1.18");
        e.getResponse().setVersion(version);
    }

}
