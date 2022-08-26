package net.cobaltonline.encodedchat;

import net.cobaltonline.encodedchat.codecs.BinaryCodec;
import net.cobaltonline.encodedchat.commands.CodecTabCompleter;
import net.cobaltonline.encodedchat.commands.DecodeCommand;
import net.cobaltonline.encodedchat.commands.EncodeCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import net.cobaltonline.encodedchat.codecs.Base64Codec;

public final class EncodedChat extends JavaPlugin {
    public static EncodedChat INSTANCE;
    public static List<String> codecs = new ArrayList<String>();
    @Override
    public void onEnable() {
        INSTANCE = this;
        codecs.add(Base64Codec.id);
        codecs.add(BinaryCodec.id);
        PluginCommand encode = this.getCommand("encode");
        PluginCommand decode = this.getCommand("decode");
        encode.setExecutor(new EncodeCommand());
        decode.setExecutor(new DecodeCommand());
        encode.setTabCompleter(new CodecTabCompleter());
        decode.setTabCompleter(new CodecTabCompleter());
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
        codecs.clear();
    }
}
