package mmo.core.netty

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelId
import mmo.core.network.Channel
import java.net.InetSocketAddress

class ChannelAdapter(private val channel: ChannelHandlerContext) : Channel {
    override fun id(): ChannelId {
        return this.channel.channel().id()
    }

    override fun write(message: Any?) {
        this.channel.writeAndFlush(message)
    }

    override fun close() {
        this.channel.close()
    }

    override val isAlive: Boolean
        get() = this.channel.channel().isActive

    override fun address(): InetSocketAddress {
        return this.channel.channel().remoteAddress() as InetSocketAddress
    }
}