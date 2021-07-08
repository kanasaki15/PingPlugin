package xyz.n7mn.dev.pingplugin;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.List;

public final class PingPlugin extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getProxy().getPluginManager().registerCommand(this, new Command("ping") {
            @Override
            public void execute(CommandSender sender, String[] args) {

                TextComponent textComponent = new TextComponent();

                if (sender instanceof ProxiedPlayer && args.length == 0){

                    ProxiedPlayer player = (ProxiedPlayer) sender;

                    long start = System.currentTimeMillis();
                    player.getServer().getInfo().ping((result, error) -> {
                        long stop = System.currentTimeMillis();

                        textComponent.setText("----- Ping Result -----\n" +
                                player.getName() + "'s ping : " + (player.getPing() + (stop - start)) + " ms\n" +
                                "Player <---> Proxy  : " + player.getPing() + " ms\n" +
                                "Proxy  <---> Server : " + (stop - start) + " ms");
                        sender.sendMessage(textComponent);
                    });


                }
            }
        });

        getProxy().getPluginManager().registerListener(this, new EventListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
