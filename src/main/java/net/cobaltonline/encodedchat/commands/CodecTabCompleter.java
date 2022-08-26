package net.cobaltonline.encodedchat.commands;

import net.cobaltonline.encodedchat.EncodedChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CodecTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return EncodedChat.INSTANCE.codecs;
        } else {
            return new ArrayList<String>();
        }
    }
}
