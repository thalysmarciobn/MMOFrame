package mmo.core.session

import io.netty.channel.ChannelId
import mmo.core.netty.ChannelAdapter

interface Session {
    /**
     * Close the session
     */
    fun close()

    /**
     * Handle a received packet
     *
     * @param msg Packet to handle
     */
    fun receive(msg: Any?)

    /**
     * Call when connection is down
     */
    fun inactive()

    /**
     * Return channelId
     */
    fun id(): ChannelId

    /**
     * Return IO channel
     */
    fun channel(): ChannelAdapter
}