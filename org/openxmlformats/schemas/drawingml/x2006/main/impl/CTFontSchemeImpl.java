package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTFontSchemeImpl extends XmlComplexContentImpl implements CTFontScheme {
  private static final b MAJORFONT$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "majorFont");
  
  private static final b MINORFONT$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "minorFont");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b NAME$6 = new b("", "name");
  
  public CTFontSchemeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFontCollection getMajorFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(MAJORFONT$0, 0);
      if (cTFontCollection == null)
        return null; 
      return cTFontCollection;
    } 
  }
  
  public void setMajorFont(CTFontCollection paramCTFontCollection) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(MAJORFONT$0, 0);
      if (cTFontCollection == null)
        cTFontCollection = (CTFontCollection)get_store().add_element_user(MAJORFONT$0); 
      cTFontCollection.set((XmlObject)paramCTFontCollection);
    } 
  }
  
  public CTFontCollection addNewMajorFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().add_element_user(MAJORFONT$0);
      return cTFontCollection;
    } 
  }
  
  public CTFontCollection getMinorFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(MINORFONT$2, 0);
      if (cTFontCollection == null)
        return null; 
      return cTFontCollection;
    } 
  }
  
  public void setMinorFont(CTFontCollection paramCTFontCollection) {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().find_element_user(MINORFONT$2, 0);
      if (cTFontCollection == null)
        cTFontCollection = (CTFontCollection)get_store().add_element_user(MINORFONT$2); 
      cTFontCollection.set((XmlObject)paramCTFontCollection);
    } 
  }
  
  public CTFontCollection addNewMinorFont() {
    synchronized (monitor()) {
      check_orphaned();
      CTFontCollection cTFontCollection = null;
      cTFontCollection = (CTFontCollection)get_store().add_element_user(MINORFONT$2);
      return cTFontCollection;
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$4) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$4, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$4); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$4);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$4, 0);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$6);
      return xmlString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTFontSchemeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */