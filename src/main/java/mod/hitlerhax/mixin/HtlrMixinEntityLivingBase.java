package mod.hitlerhax.mixin;

import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.hitlerhax.event.HtlrEventBus;
import mod.hitlerhax.event.events.HtlrEventTotemPop;

@Mixin(EntityLivingBase.class)
public class HtlrMixinEntityLivingBase {
	@Inject(method = "checkTotemDeathProtection", at = @At(value = "RETURN", ordinal = 1))
	public void onTotemPop(CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue()) {
			HtlrEventBus.EVENT_BUS.post(new HtlrEventTotemPop());
		}
	}
}
