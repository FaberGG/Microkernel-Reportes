package co.unicauca.reportes.core;

import co.unicauca.reportes.common.interfaces.IReportPlugin;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReportPluginManager {
    
    private static final String PLUGIN_PROPERTIES = "plugins.properties";
    private Properties pluginProperties;
    
    public ReportPluginManager() {
        loadPluginProperties();
    }
    
    private void loadPluginProperties() {
        pluginProperties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(PLUGIN_PROPERTIES)) {
            if (is != null) {
                pluginProperties.load(is);
            }
        } catch (IOException e) {
            System.err.println("Error cargando plugins.properties: " + e.getMessage());
        }
    }
    
    public IReportPlugin createPlugin(String pluginType) {
        String className = pluginProperties.getProperty(pluginType);
        if (className == null) {
            throw new IllegalArgumentException("Plugin no encontrado: " + pluginType);
        }
        
        try {
            Class<?> clazz = Class.forName(className);
            return (IReportPlugin) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error creando plugin: " + pluginType, e);
        }
    }
}