package net.yorbil.yorcraft.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent Raw_Bacon = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent Cooked_Bacon = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();

    public static final FoodComponent Raw_Ground_Beef = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent Raw_Beef_Patty = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent Cooked_Beef_Patty = new FoodComponent.Builder().nutrition(4).saturationModifier(0.8f).build();

    public static final FoodComponent Tomato = new FoodComponent.Builder().nutrition(3).saturationModifier(0.1f).build();
    public static final FoodComponent Bun = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent Top_Bun = new FoodComponent.Builder().nutrition(1).saturationModifier(0.6f).build();
    public static final FoodComponent Bottom_Bun = new FoodComponent.Builder().nutrition(1).saturationModifier(0.6f).build();

    //Burgers
    public static final FoodComponent Hamburger = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent Double_Hamburger = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent Triple_Hamburger = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent Bacon_Hamburger = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodComponent Double_Bacon_Hamburger = new FoodComponent.Builder().nutrition(3).saturationModifier(0.6f).build();
}
