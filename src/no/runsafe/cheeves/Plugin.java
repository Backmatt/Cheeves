package no.runsafe.cheeves;

import no.runsafe.cheeves.achievements.*;
import no.runsafe.cheeves.commands.AchievementLookup;
import no.runsafe.cheeves.commands.AwardAchievement;
import no.runsafe.cheeves.commands.ViewAchievements;
import no.runsafe.cheeves.database.AchievementRepository;
import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.command.Command;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		this.addComponent(AchievementRepository.class);
		this.addComponent(AchievementHandler.class);

		// Achievements
		this.addComponent(Pimp.class);
		this.addComponent(EmeraldCity.class);
		this.addComponent(DefenseOfTheKingdom.class);
		this.addComponent(MyPrecious.class);
		this.addComponent(PvPTournamentJune.class);
		this.addComponent(ServerFirstEnderDragon.class);
		this.addComponent(TheTunnel.class);
		this.addComponent(WizardHead.class);

		this.addComponent(AchievementFinder.class);

		Command achievements = new Command("achievements", "Achievement related commands", null);
		achievements.addSubCommand(getInstance(AchievementLookup.class));
		achievements.addSubCommand(getInstance(ViewAchievements.class));
		this.addComponent(achievements);

		this.addComponent(AwardAchievement.class);
	}
}
