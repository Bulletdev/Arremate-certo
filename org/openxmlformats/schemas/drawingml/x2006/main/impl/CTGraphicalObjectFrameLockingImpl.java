package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectFrameLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

public class CTGraphicalObjectFrameLockingImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrameLocking {
  private static final b EXTLST$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b NOGRP$2 = new b("", "noGrp");
  
  private static final b NODRILLDOWN$4 = new b("", "noDrilldown");
  
  private static final b NOSELECT$6 = new b("", "noSelect");
  
  private static final b NOCHANGEASPECT$8 = new b("", "noChangeAspect");
  
  private static final b NOMOVE$10 = new b("", "noMove");
  
  private static final b NORESIZE$12 = new b("", "noResize");
  
  public CTGraphicalObjectFrameLockingImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$0) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$0, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$0);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$0, 0);
    } 
  }
  
  public boolean getNoGrp() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOGRP$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NOGRP$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoGrp() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOGRP$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NOGRP$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoGrp() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NOGRP$2) != null);
    } 
  }
  
  public void setNoGrp(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOGRP$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NOGRP$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoGrp(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOGRP$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NOGRP$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoGrp() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NOGRP$2);
    } 
  }
  
  public boolean getNoDrilldown() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NODRILLDOWN$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NODRILLDOWN$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoDrilldown() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NODRILLDOWN$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NODRILLDOWN$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoDrilldown() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NODRILLDOWN$4) != null);
    } 
  }
  
  public void setNoDrilldown(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NODRILLDOWN$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NODRILLDOWN$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoDrilldown(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NODRILLDOWN$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NODRILLDOWN$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoDrilldown() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NODRILLDOWN$4);
    } 
  }
  
  public boolean getNoSelect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOSELECT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NOSELECT$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoSelect() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOSELECT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NOSELECT$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoSelect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NOSELECT$6) != null);
    } 
  }
  
  public void setNoSelect(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOSELECT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NOSELECT$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoSelect(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOSELECT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NOSELECT$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoSelect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NOSELECT$6);
    } 
  }
  
  public boolean getNoChangeAspect() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOCHANGEASPECT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NOCHANGEASPECT$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoChangeAspect() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOCHANGEASPECT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NOCHANGEASPECT$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoChangeAspect() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NOCHANGEASPECT$8) != null);
    } 
  }
  
  public void setNoChangeAspect(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOCHANGEASPECT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NOCHANGEASPECT$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoChangeAspect(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOCHANGEASPECT$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NOCHANGEASPECT$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoChangeAspect() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NOCHANGEASPECT$8);
    } 
  }
  
  public boolean getNoMove() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOMOVE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NOMOVE$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoMove() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOMOVE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NOMOVE$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoMove() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NOMOVE$10) != null);
    } 
  }
  
  public void setNoMove(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NOMOVE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NOMOVE$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoMove(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NOMOVE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NOMOVE$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoMove() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NOMOVE$10);
    } 
  }
  
  public boolean getNoResize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NORESIZE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NORESIZE$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNoResize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NORESIZE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NORESIZE$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNoResize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NORESIZE$12) != null);
    } 
  }
  
  public void setNoResize(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NORESIZE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NORESIZE$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNoResize(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NORESIZE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NORESIZE$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNoResize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NORESIZE$12);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGraphicalObjectFrameLockingImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */