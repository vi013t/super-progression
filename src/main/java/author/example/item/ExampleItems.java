package author.example.item;

import author.example.Example;
import author.example.data.Modifier;
import author.example.item.boss.CyclopsEye;
import author.example.item.boss.UnicornHorn;
import author.example.item.exploration.opal.armor.OpalBoots;
import author.example.item.exploration.opal.armor.OpalChestplate;
import author.example.item.exploration.opal.armor.OpalHelmet;
import author.example.item.exploration.opal.armor.OpalLeggings;
import author.example.item.exploration.opal.material.OpalDust;
import author.example.item.exploration.opal.material.OpalDustClump;
import author.example.item.exploration.opal.material.OpalIngot;
import author.example.item.general.ArmorPlate;
import author.example.item.general.BaseSword;
import author.example.item.general.TieredItem;
import author.example.item.magic.Electrio;
import author.example.item.magic.Infinio;
import author.example.item.magic.KrakenTentacles;
import author.example.item.magic.Vitalio;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Utility class for handling items in the Example mod. This class handles the instantiation of all items, all of which can be
 * retrieved as fields of this class, as well as registering all the items via the {@link #register(IEventBus)} method which
 * should be called in the {@link Example main} class's constructor with the given {@link IEventBus} from NeoForge.
 */
public class ExampleItems {

	/** The registry of all items in the "Example" mod. */
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Example.MODID);

	// General
	public static final DeferredItem<KrakenTentacles> KRAKEN_TENTACLES = ITEMS.register("kraken_tentacles", KrakenTentacles::new);

	// Tier 0
	public static final DeferredItem<TieredItem> ARMOR_PLATE = ITEMS.register("armor_plate", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> AXE_HEAD = ITEMS.register("axe_head", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> PICKAXE_HEAD = ITEMS.register("pickaxe_head", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> SHOVEL_HEAD = ITEMS.register("shovel_head", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> BLADE = ITEMS.register("blade", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> BASE_HELMET = ITEMS.register("base_helmet", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> BASE_CHESTPLATE = ITEMS.register("base_chestplate", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> BASE_LEGGINGS = ITEMS.register("base_leggings", () -> new TieredItem(0));
	public static final DeferredItem<TieredItem> BASE_BOOTS = ITEMS.register("base_boots", () -> new TieredItem(0));
	public static final DeferredItem<BaseSword> BASE_SWORD = ITEMS.register("base_sword", BaseSword::new);

	// Tier 1
	public static final DeferredItem<TieredItem> TERRIO = ITEMS.register("terrio", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> RHENIUM_PLATE = ITEMS.register("rhenium_plate", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> JACKALOPE_ANTLER = ITEMS.register("jackalope_antler", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> ANDALUSITE_INGOT = ITEMS.register("andalusite_ingot", () -> new TieredItem(1));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_1 = ITEMS.register("armor_plate_tier_1", () -> new ArmorPlate(Modifier.PROTECTION, 1));
	public static final DeferredItem<TieredItem> BLADE_TIER_1 = ITEMS.register("blade_tier_1", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> PICKAXE_HEAD_TIER_1 = ITEMS.register("pickaxe_head_tier_1", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> SHOVEL_HEAD_TIER_1 = ITEMS.register("shovel_head_tier_1", () -> new TieredItem(1));
	public static final DeferredItem<TieredItem> AXE_HEAD_TIER_1 = ITEMS.register("axe_head_tier_1", () -> new TieredItem(1));

	// Tier 2
	public static final DeferredItem<Electrio> ELECTRIO = ITEMS.register("electrio", Electrio::new);
	public static final DeferredItem<TieredItem> DANBURITE_DUST = ITEMS.register("danburite_dust", () -> new TieredItem(2));
	public static final DeferredItem<TieredItem> DANBURITE_INGOT = ITEMS.register("danburite_ingot", () -> new TieredItem(2));
	public static final DeferredItem<TieredItem> YTTRIUM_PLATE = ITEMS.register("yttrium_plate", () -> new TieredItem(2));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_2 = ITEMS.register("armor_plate_tier_2", () -> new ArmorPlate(Modifier.PROTECTION, 2));

	// Tier 3

	/**
	 * The Vitalio essence item from the magic path. This is the third tier magic item in the green path, and it's modifier is
	 * {@link author.example.data.Modifier#HEALING Healing}, which means tools and weapons with this will heal entities instead of
	 * damaging them. When used on an entity, it will heal the entity, and when used on a block, it will place grass.
	 */
	public static final DeferredItem<Vitalio> VITALIO = ITEMS.register("vitalio", Vitalio::new);
	public static final DeferredItem<TieredItem> CHROMITE_INGOT = ITEMS.register("chromite_ingot", () -> new TieredItem(3));
	public static final DeferredItem<TieredItem> BASILISK_SCALE = ITEMS.register("basilisk_scale", () -> new TieredItem(3));
	public static final DeferredItem<TieredItem> URANIUIM_PLATE = ITEMS.register("uranium_plate", () -> new TieredItem(3));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_3 = ITEMS.register("armor_plate_tier_3", () -> new ArmorPlate(Modifier.PROTECTION, 3));

	// Tier 4
	public static final DeferredItem<ArmorPlate> MAGNIO = ITEMS.register("magnio", () -> new ArmorPlate(Modifier.MAGNETIC, 4));
	public static final DeferredItem<TieredItem> CUPRITE_INGOT = ITEMS.register("cuprite_ingot", () -> new TieredItem(4));
	public static final DeferredItem<ArmorPlate> KARKINOS_CLAW = ITEMS.register("karkinos_claw", () -> new ArmorPlate(Modifier.SHEARING, 4));
	public static final DeferredItem<TieredItem> OSMIUM_PLATE = ITEMS.register("osmium_plate", () -> new TieredItem(4));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_4 = ITEMS.register("armor_plate_tier_4", () -> new ArmorPlate(Modifier.PROTECTION, 4));

	// Tier 5
	public static final DeferredItem<ArmorPlate> LUSHIO = ITEMS.register("lushio", () -> new ArmorPlate(Modifier.FORTUNE, 5));
	public static final DeferredItem<TieredItem> TUGTUPITE_INGOT = ITEMS.register("tugtupite_ingot", () -> new TieredItem(5));
	public static final DeferredItem<UnicornHorn> UNICORN_HORN = ITEMS.register("unicorn_horn", () -> new UnicornHorn());
	public static final DeferredItem<TieredItem> GERMANIUM_PLATE = ITEMS.register("germanium_plate", () -> new TieredItem(5));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_5 = ITEMS.register("armor_plate_tier_5", () -> new ArmorPlate(Modifier.PROTECTION, 5));

	// Tier 6
	public static final DeferredItem<ArmorPlate> AQUIO = ITEMS.register("aquio", () -> new ArmorPlate(Modifier.DOUSING, 6));
	public static final DeferredItem<TieredItem> KYANITE_INGOT = ITEMS.register("kyanite_ingot", () -> new TieredItem(6));
	public static final DeferredItem<TieredItem> KRAKEN_TENTACLE = ITEMS.register("kraken_tentacle", () -> new TieredItem(6));
	public static final DeferredItem<TieredItem> LUTETIUM_PLATE = ITEMS.register("lutetium_plate", () -> new TieredItem(6));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_6 = ITEMS.register("armor_plate_tier_6", () -> new ArmorPlate(Modifier.PROTECTION, 6));

	// Tier 7
	public static final DeferredItem<TieredItem> TENEBRIO = ITEMS.register("tenebrio", () -> new TieredItem(7));
	public static final DeferredItem<TieredItem> KUNZITE_INGOT = ITEMS.register("kunzite_ingot", () -> new TieredItem(7));
	public static final DeferredItem<TieredItem> GRIFFIN_TALON = ITEMS.register("griffin_talon", () -> new TieredItem(7));
	public static final DeferredItem<TieredItem> TITANIUM_PLATE = ITEMS.register("titanium_plate", () -> new TieredItem(7));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_7 = ITEMS.register("armor_plate_tier_7", () -> new ArmorPlate(Modifier.PROTECTION, 7));

	// Tier 8
	public static final DeferredItem<ArmorPlate> FLARIO = ITEMS.register("flario", () -> new ArmorPlate(Modifier.FIRE_RESISTANCE, 8));
	public static final DeferredItem<TieredItem> SPHALERITE_INGOT = ITEMS.register("sphalerite_ingot", () -> new TieredItem(8));
	public static final DeferredItem<TieredItem> PHOENIX_FEATHER = ITEMS.register("phoenix_feather", () -> new TieredItem(8));
	public static final DeferredItem<TieredItem> NIOBIUM_PLATE = ITEMS.register("niobium_plate", () -> new TieredItem(8));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_8 = ITEMS.register("armor_plate_tier_8", () -> new ArmorPlate(Modifier.PROTECTION, 8));

	// Tier 9
	public static final DeferredItem<TieredItem> TRANQUIO = ITEMS.register("tranquio", () -> new TieredItem(9));
	public static final DeferredItem<TieredItem> ADAMITE_INGOT = ITEMS.register("adamite_ingot", () -> new TieredItem(9));
	public static final DeferredItem<CyclopsEye> CYCLOPS_EYE = ITEMS.register("cyclops_eye", CyclopsEye::new);
	public static final DeferredItem<TieredItem> CHROMIUM_PLATE = ITEMS.register("chromium_plate", () -> new TieredItem(9));
	public static final DeferredItem<ArmorPlate> ARMOR_PLATE_TIER_9 = ITEMS.register("armor_plate_tier_9", () -> new ArmorPlate(Modifier.PROTECTION, 9));

	// Tier 10

	/**
	 * The Infinio item. Infinio is the highest tier (tier 10) of item in the magic path. It has a white-iridescent color, and is
	 * meant to represent infinity. When used on an entity, the entity will be duplicated, and when used on a block, the block will be
	 * duplicated. Both of these actions consume the item. Infinio's modifier is unbreakability.
	 */
	public static final DeferredItem<Infinio> INFINIO = ITEMS.register("infinio", Infinio::new);
	public static final DeferredItem<OpalDust> OPAL_DUST = ITEMS.register("opal_dust", OpalDust::new);
	public static final DeferredItem<OpalDustClump> OPAL_DUST_CLUMP = ITEMS.register("opal_dust_clump", OpalDustClump::new);
	public static final DeferredItem<OpalIngot> OPAL_INGOT = ITEMS.register("opal_ingot", OpalIngot::new);
	public static final DeferredItem<OpalHelmet> OPAL_HELMET = ITEMS.register("opal_helmet", OpalHelmet::new);
	public static final DeferredItem<OpalChestplate> OPAL_CHESTPLATE = ITEMS.register("opal_chestplate", OpalChestplate::new);
	public static final DeferredItem<OpalLeggings> OPAL_LEGGINGS = ITEMS.register("opal_leggings", OpalLeggings::new);
	public static final DeferredItem<OpalBoots> OPAL_BOOTS = ITEMS.register("opal_boots", OpalBoots::new);
	public static final DeferredItem<TieredItem> DRAGON_SCALE = ITEMS.register("dragon_scale", () -> new TieredItem(9));
	public static final DeferredItem<TieredItem> ARMOR_PLATE_TIER_10 = ITEMS.register("armor_plate_tier_10", () -> new TieredItem(10, "Armor Plate"));

	/** The registry of all creative tabs in the "Example" mod. */
	@SuppressWarnings("null")
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Example.MODID);

	/**
	 * The one and only creative tab for all items and blocks in the Example mod.
	 */
	@SuppressWarnings("null")
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register(Example.MODID, () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + Example.MODID)).icon(OPAL_DUST.get()::getDefaultInstance).displayItems((parameters, output) -> {
				for (var item : ExampleItems.ITEMS.getEntries()) {
					output.accept(item.get().getDefaultInstance());
				}
			}).build());

	private static DeferredItem<Item> basicItem(String name) {
		return ITEMS.register(name, () -> new Item(new Item.Properties()));
	}

	/**
	 * Registers the item register with the given event bus, as well as the creative tab register.
	 *
	 * @param eventBus the event bus to register the items and creative tabs on
	 */
	public static void register(IEventBus eventBus) {
		ExampleItems.ITEMS.register(eventBus);
		ExampleItems.CREATIVE_MODE_TABS.register(eventBus);
	}
}
