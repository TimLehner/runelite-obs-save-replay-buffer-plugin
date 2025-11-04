# Runelite OBS Replay Buffer Plugin

This plugin is designed to automatically save any existing OBS Replay Buffer.

## Usage

Apart from installing from the Runelite Plugin Hub, this plugin requires:

- [Open Broadcaster Software (OBS) v26+](https://obsproject.com/).
- OBS configured with an active Replay Buffer (File -> Settings -> Output -> [Setup Replay Buffer as desired])
- OBS WebSocket server running with auth (Tools -> WebSocket Server Settings -> [Enable Server] and [Generate Password])

Once configured, add the credentials in the RuneLite settings and turn on the plugin. 

Once enabled, the plugin will immediately attempt to open a connection to the OBS WebSocket Server, 
you can see the session listed in OBS in the "WebSocket Server Settings".

