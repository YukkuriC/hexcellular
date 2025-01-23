package miyucomics.hexcellular

import net.minecraftforge.fml.common.Mod

@Mod(Hexcellular.MOD_ID)
class HexcellularMain : Hexcellular {
    init {
        HexcellularPatterns.init()
        Hexcellular.doRegisterIotaType()
    }
}