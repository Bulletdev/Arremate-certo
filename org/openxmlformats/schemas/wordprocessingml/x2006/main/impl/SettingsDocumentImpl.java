package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;

public class SettingsDocumentImpl extends XmlComplexContentImpl implements SettingsDocument {
  private static final b SETTINGS$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "settings");
  
  public SettingsDocumentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTSettings getSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTSettings cTSettings = null;
      cTSettings = (CTSettings)get_store().find_element_user(SETTINGS$0, 0);
      if (cTSettings == null)
        return null; 
      return cTSettings;
    } 
  }
  
  public void setSettings(CTSettings paramCTSettings) {
    synchronized (monitor()) {
      check_orphaned();
      CTSettings cTSettings = null;
      cTSettings = (CTSettings)get_store().find_element_user(SETTINGS$0, 0);
      if (cTSettings == null)
        cTSettings = (CTSettings)get_store().add_element_user(SETTINGS$0); 
      cTSettings.set((XmlObject)paramCTSettings);
    } 
  }
  
  public CTSettings addNewSettings() {
    synchronized (monitor()) {
      check_orphaned();
      CTSettings cTSettings = null;
      cTSettings = (CTSettings)get_store().add_element_user(SETTINGS$0);
      return cTSettings;
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\SettingsDocumentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */