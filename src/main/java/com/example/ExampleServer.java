package com.example;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.block.Block;

public class ExampleServer {

    public static void main(String[] args) {
        var server = MinecraftServer.init();

        var instance = MinecraftServer.getInstanceManager()
                .createInstanceContainer();
        instance.setBlock(Pos.ZERO, Block.STONE);

        MinecraftServer.getGlobalEventHandler()
                .addListener(AsyncPlayerConfigurationEvent.class, event -> {
                    event.setSpawningInstance(instance);
                    event.getPlayer().setRespawnPoint(new Pos(0.5, 1, 0.5));
                });

        MojangAuth.init();
        server.start("127.0.0.1", 25565);
    }

}
