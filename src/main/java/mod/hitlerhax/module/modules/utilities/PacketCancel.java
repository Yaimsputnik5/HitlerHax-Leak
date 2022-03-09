package mod.hitlerhax.module.modules.utilities;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import mod.hitlerhax.event.events.HtlrEventPacket;
import mod.hitlerhax.module.Category;
import mod.hitlerhax.module.Module;
import mod.hitlerhax.setting.settings.BooleanSetting;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketClientSettings;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketConfirmTransaction;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.play.client.CPacketEnchantItem;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlaceRecipe;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import net.minecraft.network.play.client.CPacketResourcePackStatus;
import net.minecraft.network.play.client.CPacketSeenAdvancements;
import net.minecraft.network.play.client.CPacketSpectate;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketCamera;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketCloseWindow;
import net.minecraft.network.play.server.SPacketCollectItem;
import net.minecraft.network.play.server.SPacketCombatEvent;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import net.minecraft.network.play.server.SPacketCooldown;
import net.minecraft.network.play.server.SPacketCustomPayload;
import net.minecraft.network.play.server.SPacketCustomSound;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityAttach;
import net.minecraft.network.play.server.SPacketEntityEffect;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.network.play.server.SPacketEntityHeadLook;
import net.minecraft.network.play.server.SPacketEntityMetadata;
import net.minecraft.network.play.server.SPacketEntityProperties;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketJoinGame;
import net.minecraft.network.play.server.SPacketKeepAlive;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.network.play.server.SPacketOpenWindow;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.network.play.server.SPacketPlaceGhostRecipe;
import net.minecraft.network.play.server.SPacketPlayerAbilities;
import net.minecraft.network.play.server.SPacketPlayerListHeaderFooter;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketRecipeBook;
import net.minecraft.network.play.server.SPacketRemoveEntityEffect;
import net.minecraft.network.play.server.SPacketResourcePackSend;
import net.minecraft.network.play.server.SPacketRespawn;
import net.minecraft.network.play.server.SPacketScoreboardObjective;
import net.minecraft.network.play.server.SPacketSelectAdvancementsTab;
import net.minecraft.network.play.server.SPacketServerDifficulty;
import net.minecraft.network.play.server.SPacketSetExperience;
import net.minecraft.network.play.server.SPacketSetPassengers;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.network.play.server.SPacketSignEditorOpen;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.network.play.server.SPacketSpawnPainting;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraft.network.play.server.SPacketSpawnPosition;
import net.minecraft.network.play.server.SPacketStatistics;
import net.minecraft.network.play.server.SPacketTabComplete;
import net.minecraft.network.play.server.SPacketTeams;
import net.minecraft.network.play.server.SPacketTimeUpdate;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.network.play.server.SPacketUpdateHealth;
import net.minecraft.network.play.server.SPacketUpdateScore;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.play.server.SPacketUseBed;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraft.network.play.server.SPacketWindowProperty;
import net.minecraft.network.play.server.SPacketWorldBorder;

public class PacketCancel extends Module {
	public PacketCancel() {
		super("PacketCancel", "Cancels Packets", Category.UTILITIES);
		addSetting(cPacketAnimation);
		addSetting(cPacketChatMessage);
		addSetting(cPacketClickWindow);
		addSetting(cPacketClientSettings);
		addSetting(cPacketClientStatus);
		addSetting(cPacketCloseWindow);
		addSetting(cPacketConfirmTeleport);
		addSetting(cPacketConfirmTransaction);
		addSetting(cPacketCreativeInventoryAction);
		addSetting(cPacketCustomPayload);
		addSetting(cPacketEnchantItem);
		addSetting(cPacketEntityAction);
		addSetting(cPacketHeldItemChange);
		addSetting(cPacketInput);
		addSetting(cPacketKeepAlive);
		addSetting(cPacketPlaceRecipe);
		addSetting(cPacketPlayer);
		addSetting(cPacketPlayerPosition);
		addSetting(cPacketPlayerPositionRotation);
		addSetting(cPacketPlayerRotation);
		addSetting(cPacketPlayerAbilities);
		addSetting(cPacketPlayerDigging);
		addSetting(cPacketPlayerTryUseItem);
		addSetting(cPacketPlayerTryUseItemOnBlock);
		addSetting(cPacketRecipeInfo);
		addSetting(cPacketResourcePackStatus);
		addSetting(cPacketSeenAdvancements);
		addSetting(cPacketSpectate);
		addSetting(cPacketSteerBoat);
		addSetting(cPacketTabComplete);
		addSetting(cPacketUpdateSign);
		addSetting(cPacketUseEntity);
		addSetting(cPacketVehicleMove);
		addSetting(sPacketAdvancementInfo);
		addSetting(sPacketAnimation);
		addSetting(sPacketBlockAction);
		addSetting(sPacketBlockBreakAnim);
		addSetting(sPacketBlockChange);
		addSetting(sPacketCamera);
		addSetting(sPacketChangeGameState);
		addSetting(sPacketChat);
		addSetting(sPacketChunkData);
		addSetting(sPacketCloseWindow);
		addSetting(sPacketCollectItem);
		addSetting(sPacketCombatEvent);
		addSetting(sPacketConfirmTransaction);
		addSetting(sPacketCooldown);
		addSetting(sPacketCustomPayload);
		addSetting(sPacketCustomSound);
		addSetting(sPacketDestroyEntities);
		addSetting(sPacketDisconnect);
		addSetting(sPacketDisplayObjective);
		addSetting(sPacketEffect);
		addSetting(sPacketEntity);
		addSetting(sPacketEntityRelMove);
		addSetting(sPacketEntityLook);
		addSetting(sPacketEntityLookMove);
		addSetting(sPacketEntityAttach);
		addSetting(sPacketEntityEffect);
		addSetting(sPacketEntityEquipment);
		addSetting(sPacketEntityHeadLook);
		addSetting(sPacketEntityMetadata);
		addSetting(sPacketEntityProperties);
		addSetting(sPacketEntityStatus);
		addSetting(sPacketEntityTeleport);
		addSetting(sPacketEntityVelocity);
		addSetting(sPacketExplosion);
		addSetting(sPacketHeldItemChange);
		addSetting(sPacketJoinGame);
		addSetting(sPacketKeepAlive);
		addSetting(sPacketMaps);
		addSetting(sPacketMoveVehicle);
		addSetting(sPacketMultiBlockChange);
		addSetting(sPacketOpenWindow);
		addSetting(sPacketParticles);
		addSetting(sPacketPlaceGhostRecipe);
		addSetting(sPacketPlayerAbilities);
		addSetting(sPacketPlayerListHeaderFooter);
		addSetting(sPacketPlayerListItem);
		addSetting(sPacketPlayerPosLook);
		addSetting(sPacketRecipeBook);
		addSetting(sPacketRemoveEntityEffect);
		addSetting(sPacketResourcePackSend);
		addSetting(sPacketRespawn);
		addSetting(sPacketScoreboardObjective);
		addSetting(sPacketSelectAdvancementsTab);
		addSetting(sPacketServerDifficulty);
		addSetting(sPacketSetExperience);
		addSetting(sPacketSetPassengers);
		addSetting(sPacketSetSlot);
		addSetting(sPacketSignEditorOpen);
		addSetting(sPacketSoundEffect);
		addSetting(sPacketSpawnExperienceOrb);
		addSetting(sPacketSpawnGlobalEntity);
		addSetting(sPacketSpawnMob);
		addSetting(sPacketSpawnObject);
		addSetting(sPacketSpawnPainting);
		addSetting(sPacketSpawnPlayer);
		addSetting(sPacketSpawnPosition);
		addSetting(sPacketStatistics);
		addSetting(sPacketTabComplete);
		addSetting(sPacketTabComplete);
		addSetting(sPacketTeams);
		addSetting(sPacketTimeUpdate);
		addSetting(sPacketTitle);
		addSetting(sPacketUnloadChunk);
		addSetting(sPacketUpdateBossInfo);
		addSetting(sPacketUpdateHealth);
		addSetting(sPacketUpdateScore);
		addSetting(sPacketUpdateTileEntity);
	}

	BooleanSetting cPacketAnimation = new BooleanSetting("CPacketAnimation", this, false);
	BooleanSetting cPacketChatMessage = new BooleanSetting("CPacketChatMessage", this, false);
	BooleanSetting cPacketClickWindow = new BooleanSetting("CPacketClickWindow", this, false);
	BooleanSetting cPacketClientSettings = new BooleanSetting("CPacketClientSettings", this, false);
	BooleanSetting cPacketClientStatus = new BooleanSetting("CPacketClientStatus", this, false);
	BooleanSetting cPacketCloseWindow = new BooleanSetting("CPacketCloseWindow", this, false);
	BooleanSetting cPacketConfirmTeleport = new BooleanSetting("CPacketConfirmTeleport", this, false);
	BooleanSetting cPacketConfirmTransaction = new BooleanSetting("CPacketConfirmTransaction", this, false);
	BooleanSetting cPacketCreativeInventoryAction = new BooleanSetting("CPacketCreativeInventoryAction", this, false);
	BooleanSetting cPacketCustomPayload = new BooleanSetting("CPacketCustomPayload", this, false);
	BooleanSetting cPacketEnchantItem = new BooleanSetting("CPacketEnchantItem", this, false);
	BooleanSetting cPacketEntityAction = new BooleanSetting("CPacketEntityAction", this, false);
	BooleanSetting cPacketHeldItemChange = new BooleanSetting("CPacketHeldItemChange", this, false);
	BooleanSetting cPacketInput = new BooleanSetting("CPacketInput", this, false);
	BooleanSetting cPacketKeepAlive = new BooleanSetting("CPacketKeepAlive", this, false);
	BooleanSetting cPacketPlaceRecipe = new BooleanSetting("CPacketPlaceRecipe", this, false);
	BooleanSetting cPacketPlayer = new BooleanSetting("CPacketPlayer", this, false);
	BooleanSetting cPacketPlayerPosition = new BooleanSetting("CPacketPlayer.Position", this, false);
	BooleanSetting cPacketPlayerPositionRotation = new BooleanSetting("CPacketPlayer.PositionRotation", this, false);
	BooleanSetting cPacketPlayerRotation = new BooleanSetting("CPacketPlayer.Rotation", this, false);
	BooleanSetting cPacketPlayerAbilities = new BooleanSetting("CPacketPlayerAbilities", this, false);
	BooleanSetting cPacketPlayerDigging = new BooleanSetting("CPacketPlayerDigging", this, false);
	BooleanSetting cPacketPlayerTryUseItem = new BooleanSetting("CPacketPlayerTryUseItem", this, false);
	BooleanSetting cPacketPlayerTryUseItemOnBlock = new BooleanSetting("CPacketPlayerTryUseItemOnBlock", this, false);
	BooleanSetting cPacketRecipeInfo = new BooleanSetting("CPacketRecipeInfo", this, false);
	BooleanSetting cPacketResourcePackStatus = new BooleanSetting("CPacketResourcePackStatus", this, false);
	BooleanSetting cPacketSeenAdvancements = new BooleanSetting("CPacketSeenAdvancements", this, false);
	BooleanSetting cPacketSpectate = new BooleanSetting("CPacketSpectate", this, false);
	BooleanSetting cPacketSteerBoat = new BooleanSetting("CPacketSteerBoat", this, false);
	BooleanSetting cPacketTabComplete = new BooleanSetting("CPacketTabComplete", this, false);
	BooleanSetting cPacketUpdateSign = new BooleanSetting("CPacketUpdateSign", this, false);
	BooleanSetting cPacketUseEntity = new BooleanSetting("CPacketUseEntity", this, false);
	BooleanSetting cPacketVehicleMove = new BooleanSetting("CPacketVehicleMove", this, false);
	BooleanSetting sPacketAdvancementInfo = new BooleanSetting("SPacketAdvancementInfo", this, false);
	BooleanSetting sPacketAnimation = new BooleanSetting("SPacketAnimation", this, false);
	BooleanSetting sPacketBlockAction = new BooleanSetting("SPacketBlockAction", this, false);
	BooleanSetting sPacketBlockBreakAnim = new BooleanSetting("SPacketBlockBreakAnim", this, false);
	BooleanSetting sPacketBlockChange = new BooleanSetting("SPacketBlockChange", this, false);
	BooleanSetting sPacketCamera = new BooleanSetting("SPacketCamera", this, false);
	BooleanSetting sPacketChangeGameState = new BooleanSetting("SPacketChangeGameState", this, false);
	BooleanSetting sPacketChat = new BooleanSetting("SPacketChat", this, false);
	BooleanSetting sPacketChunkData = new BooleanSetting("SPacketChunkData", this, false);
	BooleanSetting sPacketCloseWindow = new BooleanSetting("SPacketCloseWindow", this, false);
	BooleanSetting sPacketCollectItem = new BooleanSetting("SPacketCollectItem", this, false);
	BooleanSetting sPacketCombatEvent = new BooleanSetting("SPacketCombatEvent", this, false);
	BooleanSetting sPacketConfirmTransaction = new BooleanSetting("SPacketConfirmTransaction", this, false);
	BooleanSetting sPacketCooldown = new BooleanSetting("SPacketCooldown", this, false);
	BooleanSetting sPacketCustomPayload = new BooleanSetting("SPacketCustomPayload", this, false);
	BooleanSetting sPacketCustomSound = new BooleanSetting("SPacketCustomSound", this, false);
	BooleanSetting sPacketDestroyEntities = new BooleanSetting("SPacketDestroyEntities", this, false);
	BooleanSetting sPacketDisconnect = new BooleanSetting("SPacketDisconnect", this, false);
	BooleanSetting sPacketDisplayObjective = new BooleanSetting("SPacketDisplayObjective", this, false);
	BooleanSetting sPacketEffect = new BooleanSetting("SPacketEffect", this, false);
	BooleanSetting sPacketEntity = new BooleanSetting("SPacketEntity", this, false);
	BooleanSetting sPacketEntityRelMove = new BooleanSetting("SPacketEntityRelMove", this, false);
	BooleanSetting sPacketEntityLook = new BooleanSetting("SPacketEntityLook", this, false);
	BooleanSetting sPacketEntityLookMove = new BooleanSetting("SPacketEntityLookMove", this, false);
	BooleanSetting sPacketEntityAttach = new BooleanSetting("SPacketEntityAttach", this, false);
	BooleanSetting sPacketEntityEffect = new BooleanSetting("SPacketEntityEffect", this, false);
	BooleanSetting sPacketEntityEquipment = new BooleanSetting("SPacketEntityEquipment", this, false);
	BooleanSetting sPacketEntityHeadLook = new BooleanSetting("SPacketEntityHeadLook", this, false);
	BooleanSetting sPacketEntityMetadata = new BooleanSetting("SPacketEntityMetadata", this, false);
	BooleanSetting sPacketEntityProperties = new BooleanSetting("SPacketEntityProperties", this, false);
	BooleanSetting sPacketEntityStatus = new BooleanSetting("SPacketEntityStatus", this, false);
	BooleanSetting sPacketEntityTeleport = new BooleanSetting("SPacketEntityTeleport", this, false);
	BooleanSetting sPacketEntityVelocity = new BooleanSetting("SPacketEntityVelocity", this, false);
	BooleanSetting sPacketExplosion = new BooleanSetting("SPacketExplosion", this, false);
	BooleanSetting sPacketHeldItemChange = new BooleanSetting("SPacketHeldItemChange", this, false);
	BooleanSetting sPacketJoinGame = new BooleanSetting("SPacketJoinGame", this, false);
	BooleanSetting sPacketKeepAlive = new BooleanSetting("SPacketKeepAlive", this, false);
	BooleanSetting sPacketMaps = new BooleanSetting("SPacketMaps", this, false);
	BooleanSetting sPacketMoveVehicle = new BooleanSetting("SPacketMoveVehicle", this, false);
	BooleanSetting sPacketMultiBlockChange = new BooleanSetting("SPacketMultiBlockChange", this, false);
	BooleanSetting sPacketOpenWindow = new BooleanSetting("SPacketOpenWindow", this, false);
	BooleanSetting sPacketParticles = new BooleanSetting("SPacketParticles", this, false);
	BooleanSetting sPacketPlaceGhostRecipe = new BooleanSetting("SPacketPlaceGhostRecipe", this, false);
	BooleanSetting sPacketPlayerAbilities = new BooleanSetting("SPacketPlayerAbilities", this, false);
	BooleanSetting sPacketPlayerListHeaderFooter = new BooleanSetting("SPacketPlayerListHeaderFooter", this, false);
	BooleanSetting sPacketPlayerListItem = new BooleanSetting("SPacketPlayerListItem", this, false);
	BooleanSetting sPacketPlayerPosLook = new BooleanSetting("SPacketPlayerPosLook", this, false);
	BooleanSetting sPacketRecipeBook = new BooleanSetting("SPacketRecipeBook", this, false);
	BooleanSetting sPacketRemoveEntityEffect = new BooleanSetting("SPacketRemoveEntityEffect", this, false);
	BooleanSetting sPacketResourcePackSend = new BooleanSetting("SPacketResourcePackSend", this, false);
	BooleanSetting sPacketRespawn = new BooleanSetting("SPacketRespawn", this, false);
	BooleanSetting sPacketScoreboardObjective = new BooleanSetting("SPacketScoreboardObjective", this, false);
	BooleanSetting sPacketSelectAdvancementsTab = new BooleanSetting("SPacketSelectAdvancementsTab", this, false);
	BooleanSetting sPacketServerDifficulty = new BooleanSetting("SPacketServerDifficulty", this, false);
	BooleanSetting sPacketSetExperience = new BooleanSetting("SPacketSetExperience", this, false);
	BooleanSetting sPacketSetPassengers = new BooleanSetting("SPacketSetPassengers", this, false);
	BooleanSetting sPacketSetSlot = new BooleanSetting("SPacketSetSlot", this, false);
	BooleanSetting sPacketSignEditorOpen = new BooleanSetting("SPacketSignEditorOpen", this, false);
	BooleanSetting sPacketSoundEffect = new BooleanSetting("SPacketSoundEffect", this, false);
	BooleanSetting sPacketSpawnExperienceOrb = new BooleanSetting("SPacketSpawnExperienceOrb", this, false);
	BooleanSetting sPacketSpawnGlobalEntity = new BooleanSetting("SPacketSpawnGlobalEntity", this, false);
	BooleanSetting sPacketSpawnMob = new BooleanSetting("SPacketSpawnMob", this, false);
	BooleanSetting sPacketSpawnObject = new BooleanSetting("SPacketSpawnObject", this, false);
	BooleanSetting sPacketSpawnPainting = new BooleanSetting("SPacketSpawnPainting", this, false);
	BooleanSetting sPacketSpawnPlayer = new BooleanSetting("SPacketSpawnPlayer", this, false);
	BooleanSetting sPacketSpawnPosition = new BooleanSetting("SPacketSpawnPosition", this, false);
	BooleanSetting sPacketStatistics = new BooleanSetting("SPacketStatistics", this, false);
	BooleanSetting sPacketTabComplete = new BooleanSetting("SPacketTabComplete", this, false);
	BooleanSetting sPacketTeams = new BooleanSetting("SPacketTeams", this, false);
	BooleanSetting sPacketTimeUpdate = new BooleanSetting("SPacketTimeUpdate", this, false);
	BooleanSetting sPacketTitle = new BooleanSetting("SPacketTitle", this, false);
	BooleanSetting sPacketUnloadChunk = new BooleanSetting("SPacketUnloadChunk", this, false);
	BooleanSetting sPacketUpdateBossInfo = new BooleanSetting("SPacketUpdateBossInfo", this, false);
	BooleanSetting sPacketUpdateHealth = new BooleanSetting("SPacketUpdateHealth", this, false);
	BooleanSetting sPacketUpdateScore = new BooleanSetting("SPacketUpdateScore", this, false);
	BooleanSetting sPacketUpdateTileEntity = new BooleanSetting("SPacketUpdateTileEntity", this, false);
	BooleanSetting sPacketUseBed = new BooleanSetting("SPacketUseBed", this, false);
	BooleanSetting sPacketWindowItems = new BooleanSetting("SPacketWindowItems", this, false);
	BooleanSetting sPacketWindowProperty = new BooleanSetting("SPacketWindowProperty", this, false);
	BooleanSetting sPacketWorldBorder = new BooleanSetting("SPacketWorldBorder", this, false);

	@EventHandler
	private final Listener<HtlrEventPacket.SendPacket> PacketSendEvent = new Listener<>(event -> {
		// c-packets
		if (event.get_packet() instanceof CPacketAnimation) {
			if (this.cPacketAnimation.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketChatMessage) {
			if (this.cPacketChatMessage.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketClickWindow) {
			if (this.cPacketClickWindow.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketClientSettings) {
			if (this.cPacketClientSettings.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketClientStatus) {
			if (this.cPacketClientStatus.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketCloseWindow) {
			if (this.cPacketCloseWindow.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketConfirmTeleport) {
			if (this.cPacketConfirmTeleport.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketConfirmTransaction) {
			if (this.cPacketConfirmTransaction.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketCreativeInventoryAction) {
			if (this.cPacketCreativeInventoryAction.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketCustomPayload) {
			if (this.cPacketCustomPayload.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketEnchantItem) {
			if (this.cPacketEnchantItem.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketEntityAction) {
			if (this.cPacketEntityAction.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketHeldItemChange) {
			if (this.cPacketHeldItemChange.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketInput) {
			if (this.cPacketInput.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketKeepAlive) {
			if (this.cPacketKeepAlive.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlaceRecipe) {
			if (this.cPacketPlaceRecipe.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayer) {
			if (this.cPacketPlayer.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayer.Rotation) {
			if (this.cPacketPlayerRotation.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayer.Position) {
			if (this.cPacketPlayerPosition.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayer.PositionRotation) {
			if (this.cPacketPlayerPositionRotation.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayerAbilities) {
			if (this.cPacketPlayerAbilities.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayerDigging) {
			if (this.cPacketPlayerDigging.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketPlayerTryUseItem) {
			if (this.cPacketPlayerTryUseItem.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketRecipeInfo) {
			if (this.cPacketRecipeInfo.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketResourcePackStatus) {
			if (this.cPacketResourcePackStatus.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketSeenAdvancements) {
			if (this.cPacketSeenAdvancements.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketSpectate) {
			if (this.cPacketSpectate.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketSteerBoat) {
			if (this.cPacketSteerBoat.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketTabComplete) {
			if (this.cPacketTabComplete.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketUpdateSign) {
			if (this.cPacketUpdateSign.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketUseEntity) {
			if (this.cPacketUseEntity.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof CPacketVehicleMove) {
			if (this.cPacketVehicleMove.enabled)
				event.cancel();
		}
	});

	@EventHandler
	private final Listener<HtlrEventPacket.ReceivePacket> PacketRecieveEvent = new Listener<>(event -> {
		// s-packets

		if (event.get_packet() instanceof SPacketAdvancementInfo) {
			if (this.sPacketAdvancementInfo.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketAnimation) {
			if (this.sPacketAnimation.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketBlockAction) {
			if (this.sPacketBlockAction.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketBlockBreakAnim) {
			if (this.sPacketBlockBreakAnim.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketBlockChange) {
			if (this.sPacketBlockChange.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCamera) {
			if (this.sPacketCamera.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketChangeGameState) {
			if (this.sPacketChangeGameState.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketChat) {
			if (this.sPacketChat.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketChunkData) {
			if (this.sPacketChunkData.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCloseWindow) {
			if (this.sPacketCloseWindow.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCollectItem) {
			if (this.sPacketCollectItem.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCombatEvent) {
			if (this.sPacketCombatEvent.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketConfirmTransaction) {
			if (this.sPacketConfirmTransaction.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCooldown) {
			if (this.sPacketCooldown.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCustomPayload) {
			if (this.sPacketCustomPayload.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketCustomSound) {
			if (this.sPacketCustomSound.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketDestroyEntities) {
			if (this.sPacketDestroyEntities.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketDisconnect) {
			if (this.sPacketDisconnect.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketDisplayObjective) {
			if (this.sPacketDisplayObjective.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEffect) {
			if (this.sPacketEffect.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntity) {
			if (this.sPacketEntity.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntity.S15PacketEntityRelMove) {
			if (this.sPacketEntityRelMove.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntity.S16PacketEntityLook) {
			if (this.sPacketEntityLook.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntity.S17PacketEntityLookMove) {
			if (this.sPacketEntityLookMove.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityAttach) {
			if (this.sPacketEntityAttach.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityEffect) {
			if (this.sPacketEntityEffect.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityEquipment) {
			if (this.sPacketEntityEquipment.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityHeadLook) {
			if (this.sPacketEntityHeadLook.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityMetadata) {
			if (this.sPacketEntityMetadata.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityProperties) {
			if (this.sPacketEntityProperties.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityStatus) {
			if (this.sPacketEntityStatus.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityTeleport) {
			if (this.sPacketEntityTeleport.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketEntityVelocity) {
			if (this.sPacketEntityVelocity.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketExplosion) {
			if (this.sPacketExplosion.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketHeldItemChange) {
			if (this.sPacketHeldItemChange.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketJoinGame) {
			if (this.sPacketJoinGame.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketKeepAlive) {
			if (this.sPacketKeepAlive.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketMaps) {
			if (this.sPacketMaps.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketMoveVehicle) {
			if (this.sPacketMoveVehicle.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketMultiBlockChange) {
			if (this.sPacketMultiBlockChange.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketOpenWindow) {
			if (this.sPacketOpenWindow.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketParticles) {
			if (this.sPacketParticles.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketPlaceGhostRecipe) {
			if (this.sPacketPlaceGhostRecipe.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketPlayerAbilities) {
			if (this.sPacketPlayerAbilities.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketPlayerListHeaderFooter) {
			if (this.sPacketPlayerListHeaderFooter.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketPlayerListItem) {
			if (this.sPacketPlayerListItem.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketPlayerPosLook) {
			if (this.sPacketPlayerPosLook.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketRecipeBook) {
			if (this.sPacketRecipeBook.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketRemoveEntityEffect) {
			if (this.sPacketRemoveEntityEffect.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketResourcePackSend) {
			if (this.sPacketResourcePackSend.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketRespawn) {
			if (this.sPacketRespawn.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketScoreboardObjective) {
			if (this.sPacketScoreboardObjective.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSelectAdvancementsTab) {
			if (this.sPacketSelectAdvancementsTab.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketServerDifficulty) {
			if (this.sPacketServerDifficulty.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSetExperience) {
			if (this.sPacketSetExperience.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSetPassengers) {
			if (this.sPacketSetPassengers.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSetSlot) {
			if (this.sPacketSetSlot.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSignEditorOpen) {
			if (this.sPacketSignEditorOpen.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSoundEffect) {
			if (this.sPacketSoundEffect.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnExperienceOrb) {
			if (this.sPacketSpawnExperienceOrb.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnGlobalEntity) {
			if (this.sPacketSpawnGlobalEntity.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnMob) {
			if (this.sPacketSpawnMob.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnObject) {
			if (this.sPacketSpawnObject.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnPainting) {
			if (this.sPacketSpawnPainting.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnPlayer) {
			if (this.sPacketSpawnPlayer.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketSpawnPosition) {
			if (this.sPacketSpawnPosition.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketStatistics) {
			if (this.sPacketStatistics.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketTabComplete) {
			if (this.sPacketTabComplete.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketTeams) {
			if (this.sPacketTeams.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketTimeUpdate) {
			if (this.sPacketTimeUpdate.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketTitle) {
			if (this.sPacketTitle.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUnloadChunk) {
			if (this.sPacketUnloadChunk.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUpdateBossInfo) {
			if (this.sPacketUpdateBossInfo.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUpdateHealth) {
			if (this.sPacketUpdateHealth.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUpdateScore) {
			if (this.sPacketUpdateScore.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUpdateTileEntity) {
			if (this.sPacketUpdateTileEntity.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketUseBed) {
			if (this.sPacketUseBed.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketWindowItems) {
			if (this.sPacketWindowItems.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketWindowProperty) {
			if (this.sPacketWindowProperty.enabled)
				event.cancel();
		} else if (event.get_packet() instanceof SPacketWorldBorder) {
			if (this.sPacketWorldBorder.enabled)
				event.cancel();
		}
	});
}
