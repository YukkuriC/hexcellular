package miyucomics.hexcellular

import net.fabricmc.api.ModInitializer

class HexcellularMain : ModInitializer, Hexcellular {
    override fun onInitialize() {
        HexcellularPatterns.init()
        Hexcellular.doRegisterIotaType()
    }
}