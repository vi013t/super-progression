package violet.apeiron.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import violet.apeiron.Apeiron;
import violet.apeiron.data.Modifier;
import violet.apeiron.item.boss.UnicornHorn;
import violet.apeiron.item.exploration.LootItem;
import violet.apeiron.item.general.ArmorPlate;
import violet.apeiron.item.general.BaseSword;
import violet.apeiron.item.general.ContinuumPortal;
import violet.apeiron.item.general.InfiniteVoid;
import violet.apeiron.item.general.TieredArmorItem;
import violet.apeiron.item.general.TieredItem;
import violet.apeiron.item.magic.Electrio;
import violet.apeiron.item.magic.Infinio;
import violet.apeiron.item.magic.InfinioBackpack;
import violet.apeiron.item.magic.KrakenTentacles;
import violet.apeiron.item.magic.Vitalio;
import violet.apeiron.item.mining.opal.armor.OpalBoots;
import violet.apeiron.item.mining.opal.armor.OpalChestplate;
import violet.apeiron.item.mining.opal.armor.OpalHelmet;
import violet.apeiron.item.mining.opal.armor.OpalLeggings;
import violet.apeiron.item.mining.opal.material.OpalDust;
import violet.apeiron.item.mining.opal.material.OpalDustClump;

/**
 * Utility class for handling items in the Apeiron mod. This class handles the instantiation of all items, all of which can be
 * retrieved as fields of this class, as well as registering all the items via the {@link #register(IEventBus)} method which
 * should be called in the {@link Apeiron main} class's constructor with the given {@link IEventBus} from NeoForge.
 */
public class ApeironItems {

	/** The registry of all items in the Apeiron mod. */
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Apeiron.MODID);

	/** 
	 * A map of all creative tabs in the mod and the items contained within them. This is used when initializing the creative tabs to select which items
	 * to put into which tab. The keys of this map are the creative tabs, and the values are a list of items that belong in that creative tab.
	 */
	private static final Map<ApeironCreativeTab, List<DeferredItem<? extends Item>>> CREATIVE_TAB_ITEMS = new HashMap<>();

	// Exploration
	public static final DeferredItem<LootItem> BLENDER = item("blender", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> CHEW_TOY = item("chew_toy", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> COBBLESTONE_GENERATOR = item("cobblestone_generator", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> COLLEGE_TEXTBOOK = item("college_textbook", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> EMERALD_AWARD = item("emerald_award", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> FLIPPERS = item("flippers", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> FRYING_PAN = item("frying_pan", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> GREEN_THUMB = item("green_thumb", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> LOVE_POTION = item("love_potion", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> MINERS_HELMET = item("miners_helmet", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> OXYGEN_TANK = item("oxygen_tank", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> PANIC_BUTTON = item("panic_button", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_ANVIL = item("pocket_anvil", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_CRAFTING_TABLE = item("pocket_crafting_table", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_ENCHANTMENT_TABLE = item("pocket_enchantment_table", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_END_PORTAL = item("pocket_end_portal", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_ENDER_CHEST = item("pocket_ender_chest", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_FURNACE = item("pocket_furnace", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_GRINDSTONE = item("pocket_grindstone", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POCKET_NETHER_PORTAL = item("pocket_nether_portal", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> POSEIDONS_CHALICE = item("poseidons_chalice", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> SLEEPING_BAG = item("sleeping_bag", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);
	public static final DeferredItem<LootItem> WORM_ON_A_HOOK = item("worm_on_a_hook", () -> new LootItem(LootItem.Rarity.COMMON), ApeironCreativeTab.EXPLORATION);

	// General
	public static final DeferredItem<KrakenTentacles> KRAKEN_TENTACLES = ITEMS.register("kraken_tentacles", KrakenTentacles::new);
	public static final DeferredItem<InfinioBackpack> INFINIO_BACKPACK = ITEMS.register("infinio_backpack", InfinioBackpack::new);
	public static final DeferredItem<ContinuumPortal> CONTINUUM_PORTAL = ITEMS.register("continuum_portal", ContinuumPortal::new);
	public static final DeferredItem<InfiniteVoid> LIMITLESS = ITEMS.register("limitless", InfiniteVoid::new);

	// Tier 0
	public static final DeferredItem<TieredItem> ARMOR_PLATE = item("armor_plate", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> AXE_HEAD = item("base_axe_head", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> HOE_HEAD = item("hoe_head", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> PICKAXE_HEAD = item("pickaxe_head", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> SHOVEL_HEAD = item("shovel_head", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BLADE = item("blade", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BASE_HELMET = item("base_helmet", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BASE_CHESTPLATE = item("base_chestplate", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BASE_LEGGINGS = item("base_leggings", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BASE_BOOTS = item("base_boots", () -> new TieredItem(0), ApeironCreativeTab.GEAR);
	public static final DeferredItem<BaseSword> BASE_SWORD = item("base_sword", BaseSword::new, ApeironCreativeTab.GEAR);

	// Tier 1

	/**
	 * The "Terrio" Item. This is the Tier 1 item in the Magic path. It's a brown dirt-like essence that represents earth. Right clicking Terrio on blocks acts
	 * as bonemeal. Terrio has the {@link violet.apeiron.data.Modifier#TILLING Tilling} modifier, which can be used on tools to till dirt into farmland. This
	 * can be applied to tools, meaning any tool modified with Terrio can be used as a hoe (in terms of tilling, not breaking).
	 */
	public static final DeferredItem<ArmorPlate> TERRIO = item("terrio", () -> new ArmorPlate(Modifier.TILLING), ApeironCreativeTab.MAGIC);

	public static final DeferredItem<TieredItem> RHENIUM_PLATE = item("rhenium_plate", () -> new TieredItem(1), ApeironCreativeTab.TECH);

	/**
	 * The "Jackalope Antler" item. This is the Tier 1 item in the Boss path. It's an antler obtained by killing a Jackalope, the lowest tier boss. The modifier
	 * of this item is {@link violet.apeiron.data.Modifier#STEP_ASSIST Step Assist}, which allows the player to walk up blocks without jumping. This modifier
	 * can only be applied to boots.
	 */
	public static final DeferredItem<ArmorPlate> JACKALOPE_ANTLER = item("jackalope_antler", () -> new ArmorPlate(Modifier.STEP_ASSIST), ApeironCreativeTab.BOSS);

	public static final DeferredItem<TieredItem> ANDALUSITE_INGOT = item("andalusite_ingot", () -> new TieredItem(1), ApeironCreativeTab.MINING);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_1 = item("armor_plate_tier_1", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> BLADE_TIER_1 = item("blade_tier_1", () -> new TieredItem(1), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> PICKAXE_HEAD_TIER_1 = item("pickaxe_head_tier_1", () -> new TieredItem(1), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> SHOVEL_HEAD_TIER_1 = item("shovel_head_tier_1", () -> new TieredItem(1), ApeironCreativeTab.GEAR);
	public static final DeferredItem<TieredItem> AXE_HEAD_TIER_1 = item("axe_head_tier_1", () -> new TieredItem(1), ApeironCreativeTab.GEAR);

	// Tier 2
	public static final DeferredItem<Electrio> ELECTRIO = item("electrio", Electrio::new, ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> DANBURITE_DUST = item("danburite_dust", () -> new TieredItem(2), ApeironCreativeTab.MINING);
	public static final DeferredItem<TieredItem> DANBURITE_INGOT = item("danburite_ingot", () -> new TieredItem(2), ApeironCreativeTab.MINING);
	public static final DeferredItem<TieredItem> YTTRIUM_PLATE = item("yttrium_plate", () -> new TieredItem(2), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_2 = item("armor_plate_tier_2", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);
	// public static final DeferredItem<ArmorPlate> REINFORCED_PLATE_TIER_2 = item("reinforced_plate_tier_2", () -> new ArmorPlate(Modifier.DURABILITY), ApeironCreativeTab.GEAR);
	public static final DeferredItem<ArmorPlate> RAZOR_TIER_2 = item("razor_tier_2", () -> new ArmorPlate(Modifier.SHARPNESS), ApeironCreativeTab.GEAR);

	// Tier 3

	/**
	 * The Vitalio essence item from the magic path. This is the third tier magic item in the green path, and it's modifier is
	 * {@link violet.apeiron.data.Modifier#HEALING Healing}, which means tools and weapons with this will heal entities instead of
	 * damaging them. When used on an entity, it will heal the entity, and when used on a block, it will place grass.
	 */
	public static final DeferredItem<Vitalio> VITALIO = item("vitalio", Vitalio::new, ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> CHROMITE_INGOT = item("chromite_ingot", () -> new TieredItem(3), ApeironCreativeTab.MINING);
	public static final DeferredItem<TieredItem> BASILISK_SCALE = item("basilisk_scale", () -> new TieredItem(3), ApeironCreativeTab.BOSS);
	public static final DeferredItem<ArmorPlate> URANIUM_PLATE = item("uranium_plate", () -> new ArmorPlate(Modifier.RADIOACTIVE), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_3 = item("armor_plate_tier_3", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 4
	public static final DeferredItem<ArmorPlate> MAGNIO = item("magnio", () -> new ArmorPlate(Modifier.MAGNETIC), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> CUPRITE_INGOT = item("cuprite_ingot", () -> new TieredItem(4), ApeironCreativeTab.MINING);
	// public static final DeferredItem<ArmorPlate> KARKINOS_CLAW = item("karkinos_claw", () -> new ArmorPlate(Modifier.SHEARING), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> OSMIUM_PLATE = item("osmium_plate", () -> new TieredItem(4), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_4 = item("armor_plate_tier_4", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 5
	// public static final DeferredItem<ArmorPlate> LUSHIO = item("lushio", () -> new ArmorPlate(Modifier.FORTUNE), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> TUGTUPITE_INGOT = item("tugtupite_ingot", () -> new TieredItem(5), ApeironCreativeTab.MINING);
	public static final DeferredItem<UnicornHorn> UNICORN_HORN = item("unicorn_horn", () -> new UnicornHorn(), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> GERMANIUM_PLATE = item("germanium_plate", () -> new TieredItem(5), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_5 = item("armor_plate_tier_5", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 6
	// public static final DeferredItem<ArmorPlate> AQUIO = item("aquio", () -> new ArmorPlate(Modifier.WATER_BREATHING), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> KYANITE_INGOT = item("kyanite_ingot", () -> new TieredItem(6), ApeironCreativeTab.MINING);
	public static final DeferredItem<ArmorPlate> KRAKEN_TENTACLE = item("kraken_tentacle", () -> new ArmorPlate(Modifier.SPEED_SWIM), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> LUTETIUM_PLATE = item("lutetium_plate", () -> new TieredItem(6), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_6 = item("armor_plate_tier_6", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 7
	public static final DeferredItem<TieredItem> TENEBRIO = item("tenebrio", () -> new TieredItem(7), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> KUNZITE_INGOT = item("kunzite_ingot", () -> new TieredItem(7), ApeironCreativeTab.MINING);
	public static final DeferredItem<ArmorPlate> GRIFFIN_TALON = item("griffin_talon", () -> new ArmorPlate(Modifier.THORNS), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> TITANIUM_PLATE = item("titanium_plate", () -> new TieredItem(7), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_7 = item("armor_plate_tier_7", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 8
	public static final DeferredItem<ArmorPlate> FLARIO = item("flario", () -> new ArmorPlate(Modifier.FIRE_RESISTANCE), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> SPHALERITE_INGOT = item("sphalerite_ingot", () -> new TieredItem(8), ApeironCreativeTab.MINING);
	public static final DeferredItem<ArmorPlate> PHOENIX_FEATHER = item("phoenix_feather", () -> new ArmorPlate(Modifier.RESURRECTION), ApeironCreativeTab.BOSS);
	public static final DeferredItem<ArmorPlate> NIOBIUM_PLATE = item("niobium_plate", () -> new ArmorPlate(Modifier.AUTO_SMELT), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_8 = item("armor_plate_tier_8", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 9
	public static final DeferredItem<TieredItem> TRANQUIO = item("tranquio", () -> new TieredItem(9), ApeironCreativeTab.MAGIC);
	public static final DeferredItem<TieredItem> ADAMITE_INGOT = item("adamite_ingot", () -> new TieredItem(9), ApeironCreativeTab.MINING);
	public static final DeferredItem<TieredArmorItem> CYCLOPS_EYE = item("cyclops_eye", () -> new TieredArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, Modifier.NIGHT_VISION), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> CHROMIUM_PLATE = item("chromium_plate", () -> new TieredItem(9), ApeironCreativeTab.TECH);
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_9 = item("armor_plate_tier_9", () -> new ArmorPlate(Modifier.PROTECTION), ApeironCreativeTab.GEAR);

	// Tier 10

	/**
	 * The Infinio item. Infinio is the highest tier (tier 10) of item in the magic path. It has a white-iridescent color, and is
	 * meant to represent infinity. When used on an entity, the entity will be duplicated, and when used on a block, the block will be
	 * duplicated. Both of these actions consume the item. Infinio's modifier is Limitless.
	 */
	public static final DeferredItem<Infinio> INFINIO = item("infinio", Infinio::new, ApeironCreativeTab.MAGIC);
	// public static final DeferredItem<ArmorPlate> IRIDIUM_PLATE = item("iridium_plate", () -> new ArmorPlate(Modifier.RETRIEVING, "Iridium Plate"), ApeironCreativeTab.TECH);
	public static final DeferredItem<OpalDust> OPAL_DUST = item("opal_dust", OpalDust::new, ApeironCreativeTab.MINING);
	public static final DeferredItem<OpalDustClump> OPAL_DUST_CLUMP = item("opal_dust_clump", OpalDustClump::new, ApeironCreativeTab.MINING);
	public static final DeferredItem<ArmorPlate> OPAL_INGOT = item("opal_ingot", () -> new ArmorPlate(Modifier.FLIGHT, "Opal Ingot"), ApeironCreativeTab.MINING);
	public static final DeferredItem<OpalHelmet> OPAL_HELMET = item("opal_helmet", OpalHelmet::new, ApeironCreativeTab.GEAR);
	public static final DeferredItem<OpalChestplate> OPAL_CHESTPLATE = item("opal_chestplate", OpalChestplate::new, ApeironCreativeTab.GEAR);
	public static final DeferredItem<OpalLeggings> OPAL_LEGGINGS = item("opal_leggings", OpalLeggings::new, ApeironCreativeTab.GEAR);
	public static final DeferredItem<OpalBoots> OPAL_BOOTS = item("opal_boots", OpalBoots::new, ApeironCreativeTab.GEAR);
	public static final DeferredItem<ArmorPlate> DRAGON_SCALE = item("dragon_scale", () -> new ArmorPlate(Modifier.FLIGHT, "Dragon Scale"), ApeironCreativeTab.BOSS);
	public static final DeferredItem<TieredItem> ARMOR_PLATE_TIER_10 = item("armor_plate_tier_10", () -> new TieredItem(10, "Armor Plate"), ApeironCreativeTab.GEAR);

	/** The registry of all creative tabs in the "Example" mod. */
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Apeiron.MODID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXPLORATION_TAB = CREATIVE_MODE_TABS.register("exploration", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".exploration")).icon(EMERALD_AWARD.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.EXPLORATION)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGIC_TAB = CREATIVE_MODE_TABS.register("magic", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".magic")).icon(TRANQUIO.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.MAGIC)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINING_TAB = CREATIVE_MODE_TABS.register("mining", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".mining")).icon(OPAL_DUST.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.MINING)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TECH_TAB = CREATIVE_MODE_TABS.register("tech", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".tech")).icon(NIOBIUM_PLATE.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.TECH)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BOSS_TAB = CREATIVE_MODE_TABS.register("boss", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".boss")).icon(KRAKEN_TENTACLE.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.BOSS)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GEAR = CREATIVE_MODE_TABS.register("gear", () -> CreativeModeTab
		.builder()
		.title(Component.translatable("itemGroup." + Apeiron.MODID + ".gear")).icon(ARMOR_PLATE_TIER_7.get()::getDefaultInstance).displayItems((parameters, output) -> {
			for (var item : CREATIVE_TAB_ITEMS.get(ApeironCreativeTab.GEAR)) {
				output.accept(item.get().getDefaultInstance());
			}
		})
		.build()
	);

	/**
	 * Registers the item register with the given event bus, as well as the creative tab register.
	 *
	 * @param eventBus the event bus to register the items and creative tabs on
	 */
	public static void register(IEventBus eventBus) {
		ApeironItems.ITEMS.register(eventBus);
		ApeironItems.CREATIVE_MODE_TABS.register(eventBus);
	}

	public static <T extends Item> DeferredItem<T> item(String id, Supplier<T> supplier, ApeironCreativeTab creativeTab) {
		var deferredItem = ITEMS.register(id, supplier);
		CREATIVE_TAB_ITEMS.computeIfAbsent(creativeTab, _tab -> new ArrayList<>()).add(deferredItem);
		return deferredItem;
	}

	public static enum ApeironCreativeTab {
		GEAR,
		EXPLORATION,
		MAGIC,
		TECH,
		MINING,
		BOSS,
	}
}
