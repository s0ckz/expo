package expo.modules.ota

import android.content.Context
import org.unimodules.core.BasePackage
import org.unimodules.core.ExportedModule
import java.util.Collections.singletonList

class OtaPackage @JvmOverloads constructor(private val id: String = DEFAULT_EXPO_OTA_ID) : BasePackage() {

    override fun createExportedModules(context: Context): List<ExportedModule> {
        val persistence = ExpoOTAPersistenceFactory.persistence(context, id)
        val updater = OtaUpdater(context, persistence, id)
        return singletonList<ExportedModule>(OtaModule(context, persistence, updater) as ExportedModule)
    }

}
