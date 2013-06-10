package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.event.inventory.IInventoryClick;
import no.runsafe.framework.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public class Pimp extends Achievement implements IInventoryClick, IPlayerPickupItemEvent
{
	public Pimp(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "Pimp";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Obtain 64 blocks of diamond.";
	}

	@Override
	public int getAchievementID()
	{
		return 1;
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		this.checkInventory(event.getWhoClicked());
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		this.checkInventory(event.getPlayer());
	}

	private void checkInventory(RunsafePlayer player)
	{
		if (player.getInventory().contains(Item.BuildingBlock.Diamond, 64))
			this.award(player);
	}
}
