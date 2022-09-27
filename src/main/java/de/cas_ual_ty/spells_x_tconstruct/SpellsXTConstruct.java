package de.cas_ual_ty.spells_x_tconstruct;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

@Mod(SpellsXTConstruct.MOD_ID)
public class SpellsXTConstruct
{
    public static final String MOD_ID = "spells_and_shields_x_tconstruct";
    
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(MOD_ID);
    
    public static final StaticModifier<ManaRegenModifier> MANA_REGEN_MODIFIER = MODIFIERS.register("mana_regen", ManaRegenModifier::new);
    public static final StaticModifier<MaxManaModifier> MAX_MANA_MODIFIER = MODIFIERS.register("max_mana", MaxManaModifier::new);
    
    public SpellsXTConstruct()
    {
        MODIFIERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
