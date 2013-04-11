package de.minestar.bungee.bungeeinventories.data;

import java.util.HashMap;

import de.minestar.bungee.bungeeinventories.core.Core;
import de.minestar.bungee.library.utils.ConsoleUtils;

public class MineServerContainer {

    private HashMap<String, MineServer> serverList;

    public MineServerContainer() {
        this.serverList = new HashMap<String, MineServer>();
    }

    public void addServer(MineServer server) {
        this.serverList.put(server.getName(), server);
        ConsoleUtils.printInfo(Core.NAME, "registering server '" + server.getName() + "'");
    }

    public MineServer getServer(String serverName) {
        MineServer server = this.serverList.get(serverName);
        if (server == null) {
            for (MineServer other : this.serverList.values()) {
                if (other.getName().equalsIgnoreCase(serverName)) {
                    return other;
                }
            }
        }
        return server;
    }
}
