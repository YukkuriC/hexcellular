package miyucomics.hexcellular;

import at.petrak.hexcasting.common.lib.hex.HexIotaTypes;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface Hexcellular {
    String MOD_ID = "hexcellular";

    static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }

    static void doRegisterIotaType() {
        Registry.register(HexIotaTypes.REGISTRY, id("property"), PropertyIota.TYPE);
    }
}
