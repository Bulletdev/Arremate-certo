package schemaorg_apache_xmlbeans.system.sXMLLANG;

import org.apache.xmlbeans.SchemaTypeSystem;

public class TypeSystemHolder {
  public static final SchemaTypeSystem typeSystem = loadTypeSystem();
  
  private static final SchemaTypeSystem loadTypeSystem() {
    try {
      return Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, TypeSystemHolder.class.getClassLoader()).getConstructor(new Class[] { Class.class }).newInstance(new Object[] { TypeSystemHolder.class });
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", classNotFoundException);
    } catch (Exception exception) {
      throw new RuntimeException("Could not instantiate SchemaTypeSystemImpl (" + exception.toString() + "): is the version of xbean.jar correct?", exception);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\schemaorg_apache_xmlbeans\system\sXMLLANG\TypeSystemHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */