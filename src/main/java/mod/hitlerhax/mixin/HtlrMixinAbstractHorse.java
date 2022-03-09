package mod.hitlerhax.mixin;

import net.minecraft.entity.passive.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import mod.hitlerhax.event.HtlrEventBus;
import mod.hitlerhax.event.events.HtlrEventHorseSaddled;
import mod.hitlerhax.event.events.HtlrEventSteerEntity;

@Mixin(AbstractHorse.class)
public class HtlrMixinAbstractHorse {
	@Inject(method = "canBeSteered", at = @At("HEAD"), cancellable = true)
	public void canBeSteered(CallbackInfoReturnable<Boolean> cir) {
		HtlrEventSteerEntity l_Event = new HtlrEventSteerEntity();
		HtlrEventBus.EVENT_BUS.post(l_Event);

		if (l_Event.isCancelled()) {
			cir.cancel();
			cir.setReturnValue(true);
		}
	}

	@Inject(method = "isHorseSaddled", at = @At("HEAD"), cancellable = true)
	public void isHorseSaddled(CallbackInfoReturnable<Boolean> cir) {
		HtlrEventHorseSaddled l_Event = new HtlrEventHorseSaddled();
		HtlrEventBus.EVENT_BUS.post(l_Event);

		if (l_Event.isCancelled()) {
			cir.cancel();
			cir.setReturnValue(true);
		}
	}
}
