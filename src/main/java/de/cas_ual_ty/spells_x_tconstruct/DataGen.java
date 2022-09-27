package de.cas_ual_ty.spells_x_tconstruct;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.recipe.IRecipeHelper;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        event.getGenerator().addProvider(new LangGen(event.getGenerator(), "en_us"));
        event.getGenerator().addProvider(new ModifiersGen(event.getGenerator()));
        event.getGenerator().addProvider(new ModifiersRecipesGen(event.getGenerator()));
    }
    
    public static class LangGen extends LanguageProvider
    {
        public LangGen(DataGenerator gen, String locale)
        {
            super(gen, SpellsXTConstruct.MOD_ID, locale);
        }
        
        @Override
        protected void addTranslations()
        {
            addModifier(SpellsXTConstruct.MANA_REGEN_MODIFIER, "Mana Regeneration", "Replenishing!", "Increases your mana regeneration while worn. More potent on chestplates and leggings than helmets and boots.");
            addModifier(SpellsXTConstruct.MAX_MANA_MODIFIER, "Maximum Mana", "Mana!", "Increases your maximum mana while worn. More potent on chestplates and leggings than helmets and boots.");
        }
        
        public void addModifier(StaticModifier<?> modifier, String name, String flavor, String desc)
        {
            String key = "modifier." + modifier.getId().getNamespace() + "." + modifier.getId().getPath();
            add(key, name);
            add(key + ".flavor", flavor);
            add(key + ".description", desc);
        }
    }
    
    public static class ModifiersGen extends AbstractModifierProvider
    {
        public ModifiersGen(DataGenerator generator)
        {
            super(generator);
        }
        
        @Override
        protected void addModifiers()
        {
            //addModifier(SpellsXTConstruct.MANA_REGEN_MODIFIER.getId(), );
        }
        
        @Override
        public String getName()
        {
            return "Spells & Shields: Magicians' Tinkering Modifiers";
        }
    }
    
    public static class ModifiersRecipesGen extends RecipeProvider implements IConditionBuilder, IRecipeHelper
    {
        public ModifiersRecipesGen(DataGenerator generator)
        {
            super(generator);
        }
        
        @Override
        protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
        {
            ModifierRecipeBuilder.modifier(SpellsXTConstruct.MANA_REGEN_MODIFIER)
                    .setTools(TinkerTags.Items.ARMOR)
                    .addInput(Ingredient.of(Items.TUBE_CORAL_FAN))
                    .addInput(Ingredient.of(Items.BOOK))
                    .setSlots(SlotType.ABILITY, 1)
                    .setMaxLevel(2)
                    .save(consumer, prefix(SpellsXTConstruct.MANA_REGEN_MODIFIER.getId(), "tools/modifiers/upgrade/"));
            
            ModifierRecipeBuilder.modifier(SpellsXTConstruct.MAX_MANA_MODIFIER)
                    .setTools(TinkerTags.Items.ARMOR)
                    .addInput(Tags.Items.GEMS_LAPIS)
                    .addInput(Ingredient.of(Items.BOOK))
                    .setSlots(SlotType.ABILITY, 1)
                    .setMaxLevel(2)
                    .save(consumer, prefix(SpellsXTConstruct.MAX_MANA_MODIFIER.getId(), "tools/modifiers/upgrade/"));
        }
        
        @Override
        public String getModId()
        {
            return SpellsXTConstruct.MOD_ID;
        }
        
        @Override
        public String getName()
        {
            return "Spells & Shields: Magicians' Tinkering Modifier Recipes";
        }
    }
}