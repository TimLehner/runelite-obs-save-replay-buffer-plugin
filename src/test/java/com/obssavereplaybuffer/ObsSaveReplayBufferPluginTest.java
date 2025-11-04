package com.obssavereplaybuffer;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ObsSaveReplayBufferPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ObsSaveReplayBufferPlugin.class);
		RuneLite.main(args);
	}
}