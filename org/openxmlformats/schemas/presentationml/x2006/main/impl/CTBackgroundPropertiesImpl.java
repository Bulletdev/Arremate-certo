package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;

public class CTBackgroundPropertiesImpl extends XmlComplexContentImpl implements CTBackgroundProperties {
  private static final b NOFILL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b EFFECTLST$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b EXTLST$16 = new b("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
  
  private static final b SHADETOTITLE$18 = new b("", "shadeToTitle");
  
  public CTBackgroundPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$0) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$0, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$0); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$0);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$0, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$2) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$2, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$2); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$2);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$2, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$4) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$4, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$4); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$4);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$4, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$6) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$6, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$6); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$6);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$6, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$8) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$8, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$8); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$8);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$8, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$10) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$10, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$10); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$10);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$10, 0);
    } 
  }
  
  public CTEffectList getEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$12, 0);
      if (cTEffectList == null)
        return null; 
      return cTEffectList;
    } 
  }
  
  public boolean isSetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTLST$12) != 0);
    } 
  }
  
  public void setEffectLst(CTEffectList paramCTEffectList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$12, 0);
      if (cTEffectList == null)
        cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$12); 
      cTEffectList.set((XmlObject)paramCTEffectList);
    } 
  }
  
  public CTEffectList addNewEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$12);
      return cTEffectList;
    } 
  }
  
  public void unsetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTLST$12, 0);
    } 
  }
  
  public CTEffectContainer getEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$14, 0);
      if (cTEffectContainer == null)
        return null; 
      return cTEffectContainer;
    } 
  }
  
  public boolean isSetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTDAG$14) != 0);
    } 
  }
  
  public void setEffectDag(CTEffectContainer paramCTEffectContainer) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$14, 0);
      if (cTEffectContainer == null)
        cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$14); 
      cTEffectContainer.set((XmlObject)paramCTEffectContainer);
    } 
  }
  
  public CTEffectContainer addNewEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$14);
      return cTEffectContainer;
    } 
  }
  
  public void unsetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTDAG$14, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$16, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$16) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$16, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$16); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$16);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$16, 0);
    } 
  }
  
  public boolean getShadeToTitle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADETOTITLE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHADETOTITLE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShadeToTitle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHADETOTITLE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHADETOTITLE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShadeToTitle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHADETOTITLE$18) != null);
    } 
  }
  
  public void setShadeToTitle(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHADETOTITLE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHADETOTITLE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShadeToTitle(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHADETOTITLE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHADETOTITLE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShadeToTitle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHADETOTITLE$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\impl\CTBackgroundPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */