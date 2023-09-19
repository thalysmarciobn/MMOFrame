package network;

import io.netty.channel.ChannelId;
import mmo.core.netty.ChannelAdapter;
import mmo.core.network.Channel;
import mmo.core.session.Session;
import org.jetbrains.annotations.NotNull;

public class NetworkSession implements Session {
    private final ChannelAdapter channel;

    public NetworkSession(ChannelAdapter channel) {
        this.channel = channel;
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

    @NotNull
    @Override
    public ChannelId id() {
        return this.channel.id();
    }

    @NotNull
    @Override
    public ChannelAdapter channel() {
        return this.channel;
    }
}
