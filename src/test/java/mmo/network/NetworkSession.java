package mmo.network;

import io.netty.channel.ChannelId;
import mmo.core.netty.ChannelAdapter;
import mmo.core.session.Session;
import org.jetbrains.annotations.NotNull;

public class NetworkSession implements Session {

    public NetworkSession(ChannelAdapter channel) {

    }

    @Override
    public void close() {

    }

    @Override
    public void receive(Object msg) {

    }

    @Override
    public void inactive() {

    }

    @Override
    public ChannelAdapter channel() {
        return null;
    }

    @NotNull
    @Override
    public ChannelId id() {
        return null;
    }
}
