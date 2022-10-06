package de.cas_ual_ty.spells_x_tconstruct;

import de.cas_ual_ty.spells.SpellsRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.UUID;
import java.util.function.BiConsumer;

public class ManaRegenModifier extends Modifier
{
    @Override
    public void addAttributes(IToolStackView tool, int level, EquipmentSlot slot, BiConsumer<Attribute, AttributeModifier> consumer)
    {
        double increase = SpellsRegistries.MANA_REGENERATION_ENCHANTMENT.get().getAttributeIncrease(level, slot);
        consumer.accept(SpellsRegistries.MANA_REGENERATION_ATTRIBUTE.get(), new AttributeModifier(UUID.fromString("A2EE86EC-2C7F-4355-BE41-FD80ADD1FFB5"), "Mana regeneration modifier", increase, AttributeModifier.Operation.ADDITION));
    }
}
