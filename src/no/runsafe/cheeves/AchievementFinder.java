package no.runsafe.cheeves;

import java.util.HashMap;
import java.util.Map;

public class AchievementFinder
{
	public AchievementFinder(Achievement[] achievements)
	{
		for (Achievement achievement : achievements)
			this.achievementHashMap.put(achievement.getAchievementID(), achievement);
	}

	public IAchievement getAchievementByID(int achievementID)
	{
		return (this.achievementHashMap.containsKey(achievementID) ? this.achievementHashMap.get(achievementID) : null);
	}

	public IAchievement getAchievementByTitle(String title)
	{
		IAchievement possibleMatch = null;
		for (Map.Entry<Integer, Achievement> entry : this.achievementHashMap.entrySet())
		{
			IAchievement achievement = entry.getValue();
			if (achievement.getAchievementName().equalsIgnoreCase(title))
				return achievement;

			if (achievement.getAchievementName().toLowerCase().startsWith(title.toLowerCase()))
				possibleMatch = achievement;
		}

		if (possibleMatch != null)
			return possibleMatch;

		return null;
	}

	private HashMap<Integer, Achievement> achievementHashMap = new HashMap<Integer, Achievement>();
}
