package org.apache.poi.openxml4j.opc;

import java.util.Date;
import org.apache.poi.openxml4j.util.Nullable;

public interface PackageProperties {
  public static final String NAMESPACE_DCTERMS = "http://purl.org/dc/terms/";
  
  public static final String NAMESPACE_DC = "http://purl.org/dc/elements/1.1/";
  
  Nullable<String> getCategoryProperty();
  
  void setCategoryProperty(String paramString);
  
  Nullable<String> getContentStatusProperty();
  
  void setContentStatusProperty(String paramString);
  
  Nullable<String> getContentTypeProperty();
  
  void setContentTypeProperty(String paramString);
  
  Nullable<Date> getCreatedProperty();
  
  void setCreatedProperty(String paramString);
  
  void setCreatedProperty(Nullable<Date> paramNullable);
  
  Nullable<String> getCreatorProperty();
  
  void setCreatorProperty(String paramString);
  
  Nullable<String> getDescriptionProperty();
  
  void setDescriptionProperty(String paramString);
  
  Nullable<String> getIdentifierProperty();
  
  void setIdentifierProperty(String paramString);
  
  Nullable<String> getKeywordsProperty();
  
  void setKeywordsProperty(String paramString);
  
  Nullable<String> getLanguageProperty();
  
  void setLanguageProperty(String paramString);
  
  Nullable<String> getLastModifiedByProperty();
  
  void setLastModifiedByProperty(String paramString);
  
  Nullable<Date> getLastPrintedProperty();
  
  void setLastPrintedProperty(String paramString);
  
  void setLastPrintedProperty(Nullable<Date> paramNullable);
  
  Nullable<Date> getModifiedProperty();
  
  void setModifiedProperty(String paramString);
  
  void setModifiedProperty(Nullable<Date> paramNullable);
  
  Nullable<String> getRevisionProperty();
  
  void setRevisionProperty(String paramString);
  
  Nullable<String> getSubjectProperty();
  
  void setSubjectProperty(String paramString);
  
  Nullable<String> getTitleProperty();
  
  void setTitleProperty(String paramString);
  
  Nullable<String> getVersionProperty();
  
  void setVersionProperty(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackageProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */