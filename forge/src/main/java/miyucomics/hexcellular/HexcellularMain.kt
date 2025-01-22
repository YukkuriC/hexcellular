package miyucomics.hexcellular

import at.petrak.hexcasting.common.lib.HexRegistries
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegisterEvent

@Mod(Hexcellular.MOD_ID)
class HexcellularMain : Hexcellular {
    init {
        MinecraftForge.EVENT_BUS.addListener<RegisterEvent>({ event ->
            val key = event.registryKey
            if (key == HexRegistries.ACTION) HexcellularPatterns.init()
            else if (key == HexRegistries.IOTA_TYPE) Hexcellular.doRegisterIotaType()
        })
    }
}