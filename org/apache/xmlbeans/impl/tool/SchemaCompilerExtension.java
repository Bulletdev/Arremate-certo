package org.apache.xmlbeans.impl.tool;

import java.util.Map;
import org.apache.xmlbeans.SchemaTypeSystem;

public interface SchemaCompilerExtension {
  void schemaCompilerExtension(SchemaTypeSystem paramSchemaTypeSystem, Map paramMap);
  
  String getExtensionName();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaCompilerExtension.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */