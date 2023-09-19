package mmo;

import mmo.world.Room;
import mmo.world.RoomManager;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestRoom {


    @Test
    public void build() {
        Room room = Objects.requireNonNull(RoomManager.Companion.getInstance()).addRoom("test");
    }
}
