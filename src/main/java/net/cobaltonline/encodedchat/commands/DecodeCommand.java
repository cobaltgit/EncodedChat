package net.cobaltonline.encodedchat.commands;

import net.cobaltonline.encodedchat.EncodedChat;
import net.cobaltonline.encodedchat.codecs.Base64Codec;
import net.cobaltonline.encodedchat.codecs.BinaryCodec;
import net.cobaltonline.encodedchat.codecs.Codec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class DecodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String codecId = args[0];
        String[] message = Arrays.copyOfRange(args, 1, args.length);
        if (!EncodedChat.INSTANCE.codecs.contains(codecId)) {
            sender.sendMessage("Unknown codec " + codecId);
            return false;
        }
        Codec codec = null;
        switch (codecId) {
            case "base64":
                codec = new Base64Codec();
                break;
            case "binary":
                codec = new BinaryCodec();
                break;
        }
        String decodedMessage;
        try {
            decodedMessage = codec.decode(String.join(" ", message));
        } catch (Exception e) {
            sender.sendMessage("Error decoding message: " + e.getMessage());
            return false;
        }
        sender.sendMessage(decodedMessage);
        return true;
    }
}
