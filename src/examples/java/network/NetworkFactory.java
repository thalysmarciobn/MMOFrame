package network;

import mmo.core.netty.ChannelAdapter;
import mmo.core.session.Session;
import mmo.core.session.SessionFactory;
import org.jetbrains.annotations.NotNull;

public class NetworkFactory implements SessionFactory {
    @Override
    public Session create(@NotNull ChannelAdapter channel) {
        return new NetworkSession(channel);
    }
}
