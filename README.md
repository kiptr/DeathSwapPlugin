# DeathSwap Minigame Plugin

This is a **Minecraft Spigot plugin** for the **DeathSwap** minigame, inspired by Dream's famous DeathSwap challenges. In this minigame, two players join, and every 15 minutes, their positions are swapped. The player need a strategy how to kill the other player when they swapped position each other. The game ends when one player dies, and the remaining player wins!

---

## Features

- **Join the Game**: Two players can join the game using the `/deathswap join` command.
- **Start the Game**: Once both players have joined, the game can be started using the `/deathswap start` command.
- **Position Swap**: Every 15 minutes, the players' positions will be swapped.
- **Countdown**: A 10-second countdown appears in chat before each position swap.
- **Game End**: The game ends when one of the players dies, and the surviving player wins.

---

## Requirements

- **Minecraft Server**: A Minecraft server running Spigot (1.18 or higher).
- **Java**: Java 17 or higher is required for compiling and running the plugin.

---

## Installation

1. **Download the Plugin**:

   - Clone or download this repository.
   - Run `mvn clean package` to build the `.jar` file.
   - Alternatively, you can find the latest release in the [Releases](#) section.

2. **Install on Your Server**:

   - Place the compiled `.jar` file in the `plugins` folder of your Spigot server.

3. **Start Your Server**:

   - Run your Spigot server by executing the following command:
     ```bash
     java -Xmx1G -jar spigot.jar
     ```

4. **Test the Plugin**:
   - Join your server as two players and use the `/deathswap join` command.
   - Once both players have joined, use the `/deathswap start` command to start the game.

---

## Commands

- `/deathswap join`: Used by players to join the game. Only two players are allowed to join.
- `/deathswap start`: Starts the DeathSwap game after two players have joined.

---

## How It Works

1. **Joining the Game**:

   - Players use the `/deathswap join` command to join the game.
   - Only two players can join the game. Once two players are in, no more players can join until the game finishes.

2. **Starting the Game**:

   - Once two players have joined, the game can be started with `/deathswap start`.

3. **Position Swaps**:

   - Every 15 minutes, the players’ positions are swapped.
   - A countdown (10 seconds) is displayed in chat before each swap.

4. **Game End**:
   - The game ends when one of the players dies, and the other player is declared the winner.

---

## Customization

Feel free to modify the following parameters in the plugin code to suit your server's needs:

- **Time Between Swaps**: Change the swap interval by modifying the `startDeathSwapTimer()` method in the plugin code.
- **Messages**: You can customize the countdown and swap messages to add more flair or change them as needed.

---

## Inspiration

This plugin is inspired by **Dream**, the famous Minecraft YouTuber, and his **DeathSwap** challenge videos. You can recreate the excitement and competitive spirit of Dream's challenges on your own Minecraft server!

---

## Contributing

Feel free to fork this repository, create pull requests, and contribute to improving the plugin. If you find any bugs or have suggestions for new features, please open an issue!

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
