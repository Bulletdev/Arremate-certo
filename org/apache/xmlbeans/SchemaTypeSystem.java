package org.apache.xmlbeans;

import java.io.File;

public interface SchemaTypeSystem extends SchemaTypeLoader {
  String getName();
  
  SchemaType[] globalTypes();
  
  SchemaType[] documentTypes();
  
  SchemaType[] attributeTypes();
  
  SchemaGlobalElement[] globalElements();
  
  SchemaGlobalAttribute[] globalAttributes();
  
  SchemaModelGroup[] modelGroups();
  
  SchemaAttributeGroup[] attributeGroups();
  
  SchemaAnnotation[] annotations();
  
  void resolve();
  
  SchemaComponent resolveHandle(String paramString);
  
  SchemaType typeForHandle(String paramString);
  
  ClassLoader getClassLoader();
  
  void saveToDirectory(File paramFile);
  
  void save(Filer paramFiler);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaTypeSystem.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */