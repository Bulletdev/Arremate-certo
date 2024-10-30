package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBaseStyles;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorSchemeList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomColorList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTObjectStyleDefaults;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;

public class CTOfficeStyleSheetImpl extends XmlComplexContentImpl implements CTOfficeStyleSheet {
  private static final b THEMEELEMENTS$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "themeElements");
  
  private static final b OBJECTDEFAULTS$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "objectDefaults");
  
  private static final b EXTRACLRSCHEMELST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extraClrSchemeLst");
  
  private static final b CUSTCLRLST$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "custClrLst");
  
  private static final b EXTLST$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b NAME$10 = new b("", "name");
  
  public CTOfficeStyleSheetImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTBaseStyles getThemeElements() {
    synchronized (monitor()) {
      check_orphaned();
      CTBaseStyles cTBaseStyles = null;
      cTBaseStyles = (CTBaseStyles)get_store().find_element_user(THEMEELEMENTS$0, 0);
      if (cTBaseStyles == null)
        return null; 
      return cTBaseStyles;
    } 
  }
  
  public void setThemeElements(CTBaseStyles paramCTBaseStyles) {
    synchronized (monitor()) {
      check_orphaned();
      CTBaseStyles cTBaseStyles = null;
      cTBaseStyles = (CTBaseStyles)get_store().find_element_user(THEMEELEMENTS$0, 0);
      if (cTBaseStyles == null)
        cTBaseStyles = (CTBaseStyles)get_store().add_element_user(THEMEELEMENTS$0); 
      cTBaseStyles.set((XmlObject)paramCTBaseStyles);
    } 
  }
  
  public CTBaseStyles addNewThemeElements() {
    synchronized (monitor()) {
      check_orphaned();
      CTBaseStyles cTBaseStyles = null;
      cTBaseStyles = (CTBaseStyles)get_store().add_element_user(THEMEELEMENTS$0);
      return cTBaseStyles;
    } 
  }
  
  public CTObjectStyleDefaults getObjectDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTObjectStyleDefaults cTObjectStyleDefaults = null;
      cTObjectStyleDefaults = (CTObjectStyleDefaults)get_store().find_element_user(OBJECTDEFAULTS$2, 0);
      if (cTObjectStyleDefaults == null)
        return null; 
      return cTObjectStyleDefaults;
    } 
  }
  
  public boolean isSetObjectDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OBJECTDEFAULTS$2) != 0);
    } 
  }
  
  public void setObjectDefaults(CTObjectStyleDefaults paramCTObjectStyleDefaults) {
    synchronized (monitor()) {
      check_orphaned();
      CTObjectStyleDefaults cTObjectStyleDefaults = null;
      cTObjectStyleDefaults = (CTObjectStyleDefaults)get_store().find_element_user(OBJECTDEFAULTS$2, 0);
      if (cTObjectStyleDefaults == null)
        cTObjectStyleDefaults = (CTObjectStyleDefaults)get_store().add_element_user(OBJECTDEFAULTS$2); 
      cTObjectStyleDefaults.set((XmlObject)paramCTObjectStyleDefaults);
    } 
  }
  
  public CTObjectStyleDefaults addNewObjectDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      CTObjectStyleDefaults cTObjectStyleDefaults = null;
      cTObjectStyleDefaults = (CTObjectStyleDefaults)get_store().add_element_user(OBJECTDEFAULTS$2);
      return cTObjectStyleDefaults;
    } 
  }
  
  public void unsetObjectDefaults() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OBJECTDEFAULTS$2, 0);
    } 
  }
  
  public CTColorSchemeList getExtraClrSchemeLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeList cTColorSchemeList = null;
      cTColorSchemeList = (CTColorSchemeList)get_store().find_element_user(EXTRACLRSCHEMELST$4, 0);
      if (cTColorSchemeList == null)
        return null; 
      return cTColorSchemeList;
    } 
  }
  
  public boolean isSetExtraClrSchemeLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTRACLRSCHEMELST$4) != 0);
    } 
  }
  
  public void setExtraClrSchemeLst(CTColorSchemeList paramCTColorSchemeList) {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeList cTColorSchemeList = null;
      cTColorSchemeList = (CTColorSchemeList)get_store().find_element_user(EXTRACLRSCHEMELST$4, 0);
      if (cTColorSchemeList == null)
        cTColorSchemeList = (CTColorSchemeList)get_store().add_element_user(EXTRACLRSCHEMELST$4); 
      cTColorSchemeList.set((XmlObject)paramCTColorSchemeList);
    } 
  }
  
  public CTColorSchemeList addNewExtraClrSchemeLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTColorSchemeList cTColorSchemeList = null;
      cTColorSchemeList = (CTColorSchemeList)get_store().add_element_user(EXTRACLRSCHEMELST$4);
      return cTColorSchemeList;
    } 
  }
  
  public void unsetExtraClrSchemeLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTRACLRSCHEMELST$4, 0);
    } 
  }
  
  public CTCustomColorList getCustClrLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomColorList cTCustomColorList = null;
      cTCustomColorList = (CTCustomColorList)get_store().find_element_user(CUSTCLRLST$6, 0);
      if (cTCustomColorList == null)
        return null; 
      return cTCustomColorList;
    } 
  }
  
  public boolean isSetCustClrLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTCLRLST$6) != 0);
    } 
  }
  
  public void setCustClrLst(CTCustomColorList paramCTCustomColorList) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomColorList cTCustomColorList = null;
      cTCustomColorList = (CTCustomColorList)get_store().find_element_user(CUSTCLRLST$6, 0);
      if (cTCustomColorList == null)
        cTCustomColorList = (CTCustomColorList)get_store().add_element_user(CUSTCLRLST$6); 
      cTCustomColorList.set((XmlObject)paramCTCustomColorList);
    } 
  }
  
  public CTCustomColorList addNewCustClrLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomColorList cTCustomColorList = null;
      cTCustomColorList = (CTCustomColorList)get_store().add_element_user(CUSTCLRLST$6);
      return cTCustomColorList;
    } 
  }
  
  public void unsetCustClrLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTCLRLST$6, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$8) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$8, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$8); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$8);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$8, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NAME$10); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(NAME$10); 
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$10) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTOfficeStyleSheetImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */