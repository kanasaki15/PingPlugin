package xyz.n7mn.dev.pingplugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

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

                    textComponent.setText(player.getName() + "'s ping : " + player.getPing() + " ms");
                    sender.sendMessage(textComponent);
                    return;
                }

                if (args.length == 0){
                    textComponent.setText(ChatColor.RED + "Error!\n/ping <PlayerName>");
                    sender.sendMessage(textComponent);
                    return;
                }

                if (args.length == 1){
                    ProxiedPlayer player = getProxy().getPlayer(args[0]);

                    textComponent.setText(player.getName() + "'s ping : " + player.getPing() + " ms");
                    sender.sendMessage(textComponent);
                }

            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
