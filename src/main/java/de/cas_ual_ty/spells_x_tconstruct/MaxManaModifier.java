package de.cas_ual_ty.spells_x_tconstruct;

import de.cas_ual_ty.spells.SpellsRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.UUID;
import java.util.function.BiConsumer;

public class MaxManaModifier extends Modifier
{
    @Override
    public void addAttributes(IToolStackView tool, int level, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer)
    {
        double increase = SpellsRegistries.MAX_MANA_ENCHANTMENT.get().getAttributeIncrease(level, slot);
        consumer.accept(SpellsRegistries.MAX_MANA_ATTRIBUTE.get(), new AttributeModifier(UUID.fromString("6C883BE3-9726-476C-89B3-C923D1E48D2F"), "Max mana modifier", increase, AttributeModifier.Operation.ADDITION));
    }
}
