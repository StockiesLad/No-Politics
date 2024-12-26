package net.stockieslad.no_politics.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {

    @Inject(method = "apply(Ljava/util/List;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("HEAD"))
    private void undoPoliticalChanges(List<String> list, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        list.removeAll(List.of(
                "Black lives matter!",
                "Be anti-racist!",
                "Speak OUT against injustice and UP for equality!",
                "Amplify and listen to BIPOC voices!",
                "Educate your friends on anti-racism!",
                "Support the BIPOC community and creators!",
                "Stand up for equality in your community!",
                "You are valid!",
                "Your gender is valid!",
                "Contains infinite genders!"
        ));
        list.addAll(List.of(
                "Привет Россия!",
                "Made by Notch!",
                "The Work of Notch!",
                "110813"
        ));
    }
}
