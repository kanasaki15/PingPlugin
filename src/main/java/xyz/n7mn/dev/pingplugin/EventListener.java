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

        // minecraft.jp対策
        int mine1_18 = 756; //TODO: 正式リリース後確認
        if (!(version.getProtocol() >= 47 && version.getProtocol() <= mine1_18)){
            version.setProtocol(mine1_18);
        }
        e.getResponse().setVersion(version);
    }

}
