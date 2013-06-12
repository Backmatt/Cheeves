package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.Achievement;
import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.cheeves.Achievements;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class FleshWound extends Achievement implements IPlayerDeathEvent
{
	public FleshWound(AchievementHandler achievementHandler)
	{
		super(achievementHandler);
	}

	@Override
	public String getAchievementName()
	{
		return "It's Just a Flesh Wound";
	}

	@Override
	public String getAchievementInfo()
	{
		return "Kill a player while you're on half a heart of health.";
	}

	@Override
	public int getAchievementID()
	{
		return Achievements.FLESH_WOUND.ordinal();
	}

	@Override
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event)
	{
		RunsafeEntity killer = event.getEntity().getLastDamageCause().getEntity();
		if (killer != null && killer instanceof RunsafePlayer)
		{
			RunsafePlayer killerPlayer = (RunsafePlayer) killer;
			if (killerPlayer.getHealth() == 1)
				this.award(killerPlayer);
		}
	}
}
