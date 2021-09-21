package dunnewoertel.axolotlbucketfix;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class AxolotlBucketFixMain implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {

        FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("variant"), (itemStack, clientWorld, livingEntity, i) -> {
            float axolotlType = 0;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Variant"))
                axolotlType = itemStack.getNbt().getInt("Variant");
            return axolotlType * 0.01f + 0.0001f;
        });

        FabricModelPredicateProviderRegistry.register(Items.AXOLOTL_BUCKET, new Identifier("age"), (itemStack, clientWorld, livingEntity, i) -> {
            float age = 1;
            if (itemStack.getNbt() != null && itemStack.getNbt().contains("Age") && itemStack.getNbt().getInt("Age") < 0)
                age = 0;
            return age;
        });
    }

}