package no.runsafe.cheeves.achievements;

import no.runsafe.cheeves.AchievementHandler;
import no.runsafe.framework.server.player.RunsafePlayer;

public abstract class Achievement implements IAchievement
{
	public Achievement(AchievementHandler achievementHandler)
	{
		this.achievementHandler = achievementHandler;
	}

	protected void award(RunsafePlayer player)
	{
		this.achievementHandler.awardAchievement(this, player);
	}

	protected AchievementHandler achievementHandler;
}
