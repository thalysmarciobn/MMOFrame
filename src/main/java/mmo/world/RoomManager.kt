package mmo.world

import mmo.core.session.Session
import org.apache.logging.log4j.LogManager
import java.util.concurrent.ConcurrentHashMap

class RoomManager {
    private var rooms: ConcurrentHashMap<String, Room>? = null

    private val logger = LogManager.getLogger(javaClass)

    fun addRoom(name: String): Room? {
        if (this.rooms!!.containsKey(name)) {
            val room = Room(name);
            this.rooms!![name] = room
            return room
        }
        return null;
    }

    fun removeRoom(room: Room): RoomCode {
        if (!this.rooms!!.containsKey(room.name)) return RoomCode.NotExists
        return if (this.rooms!!.remove(room.name, room)) RoomCode.Ok else RoomCode.Fail
    }

    fun addUserToRoom(room: Room, user: Session): RoomCode {
        if (this.rooms!!.containsKey(room.name)) {
            return room.addUser(user)
        }
        return RoomCode.NotExists;
    }

    companion object {
        var instance: RoomManager? = null
            get() {
                if (field == null) {
                    field = build()
                }
                return field
            }
            private set

        private fun build(): RoomManager {
            val roomManager = RoomManager()
            roomManager.rooms = ConcurrentHashMap()
            return roomManager
        }
    }
}
