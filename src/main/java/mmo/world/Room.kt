package mmo.world

import io.netty.channel.ChannelId
import mmo.core.session.Session
import java.util.concurrent.ConcurrentHashMap

class Room(@JvmField var name: String) {
    private var max: Int = -1

    private var users: ConcurrentHashMap<ChannelId, Session> = ConcurrentHashMap()

    fun setMax(max: Int) {
        this.max = max;
    }

    fun addUser(session: Session): RoomCode {
        if (this.users.containsKey(session.id()))
            return RoomCode.ContainsUser

        if (max != -1 && this.users.count() >= this.max)
            return RoomCode.Full

        this.users.put(session.id(), session) ?: return RoomCode.Fail

        return RoomCode.Ok;
    }
}
