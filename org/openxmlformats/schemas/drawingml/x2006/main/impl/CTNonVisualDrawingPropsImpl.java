package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

public class CTNonVisualDrawingPropsImpl extends XmlComplexContentImpl implements CTNonVisualDrawingProps {
  private static final b HLINKCLICK$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkClick");
  
  private static final b HLINKHOVER$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hlinkHover");
  
  private static final b EXTLST$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b ID$6 = new b("", "id");
  
  private static final b NAME$8 = new b("", "name");
  
  private static final b DESCR$10 = new b("", "descr");
  
  private static final b HIDDEN$12 = new b("", "hidden");
  
  public CTNonVisualDrawingPropsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTHyperlink getHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKCLICK$0, 0);
      if (cTHyperlink == null)
        return null; 
      return cTHyperlink;
    } 
  }
  
  public boolean isSetHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HLINKCLICK$0) != 0);
    } 
  }
  
  public void setHlinkClick(CTHyperlink paramCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKCLICK$0, 0);
      if (cTHyperlink == null)
        cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKCLICK$0); 
      cTHyperlink.set((XmlObject)paramCTHyperlink);
    } 
  }
  
  public CTHyperlink addNewHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKCLICK$0);
      return cTHyperlink;
    } 
  }
  
  public void unsetHlinkClick() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HLINKCLICK$0, 0);
    } 
  }
  
  public CTHyperlink getHlinkHover() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKHOVER$2, 0);
      if (cTHyperlink == null)
        return null; 
      return cTHyperlink;
    } 
  }
  
  public boolean isSetHlinkHover() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HLINKHOVER$2) != 0);
    } 
  }
  
  public void setHlinkHover(CTHyperlink paramCTHyperlink) {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().find_element_user(HLINKHOVER$2, 0);
      if (cTHyperlink == null)
        cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKHOVER$2); 
      cTHyperlink.set((XmlObject)paramCTHyperlink);
    } 
  }
  
  public CTHyperlink addNewHlinkHover() {
    synchronized (monitor()) {
      check_orphaned();
      CTHyperlink cTHyperlink = null;
      cTHyperlink = (CTHyperlink)get_store().add_element_user(HLINKHOVER$2);
      return cTHyperlink;
    } 
  }
  
  public void unsetHlinkHover() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HLINKHOVER$2, 0);
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
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDrawingElementId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STDrawingElementId sTDrawingElementId = null;
      sTDrawingElementId = (STDrawingElementId)get_store().find_attribute_user(ID$6);
      return sTDrawingElementId;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(STDrawingElementId paramSTDrawingElementId) {
    synchronized (monitor()) {
      check_orphaned();
      STDrawingElementId sTDrawingElementId = null;
      sTDrawingElementId = (STDrawingElementId)get_store().find_attribute_user(ID$6);
      if (sTDrawingElementId == null)
        sTDrawingElementId = (STDrawingElementId)get_store().add_attribute_user(ID$6); 
      sTDrawingElementId.set((XmlObject)paramSTDrawingElementId);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$8);
      return xmlString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public String getDescr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DESCR$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DESCR$10); 
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetDescr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DESCR$10);
      if (xmlString == null)
        xmlString = (XmlString)get_default_attribute_value(DESCR$10); 
      return xmlString;
    } 
  }
  
  public boolean isSetDescr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DESCR$10) != null);
    } 
  }
  
  public void setDescr(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DESCR$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DESCR$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDescr(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(DESCR$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(DESCR$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetDescr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DESCR$10);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDDEN$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDDEN$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$12) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$12);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTNonVisualDrawingPropsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */