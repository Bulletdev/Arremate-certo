package org.openxmlformats.schemas.drawingml.x2006.main.impl;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

public class CTTablePropertiesImpl extends XmlComplexContentImpl implements CTTableProperties {
  private static final b NOFILL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b EFFECTLST$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b TABLESTYLE$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tableStyle");
  
  private static final b TABLESTYLEID$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tableStyleId");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b RTL$22 = new b("", "rtl");
  
  private static final b FIRSTROW$24 = new b("", "firstRow");
  
  private static final b FIRSTCOL$26 = new b("", "firstCol");
  
  private static final b LASTROW$28 = new b("", "lastRow");
  
  private static final b LASTCOL$30 = new b("", "lastCol");
  
  private static final b BANDROW$32 = new b("", "bandRow");
  
  private static final b BANDCOL$34 = new b("", "bandCol");
  
  public CTTablePropertiesImpl(SchemaType paramSchemaType) {
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
  
  public CTTableStyle getTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().find_element_user(TABLESTYLE$16, 0);
      if (cTTableStyle == null)
        return null; 
      return cTTableStyle;
    } 
  }
  
  public boolean isSetTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLESTYLE$16) != 0);
    } 
  }
  
  public void setTableStyle(CTTableStyle paramCTTableStyle) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().find_element_user(TABLESTYLE$16, 0);
      if (cTTableStyle == null)
        cTTableStyle = (CTTableStyle)get_store().add_element_user(TABLESTYLE$16); 
      cTTableStyle.set((XmlObject)paramCTTableStyle);
    } 
  }
  
  public CTTableStyle addNewTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableStyle cTTableStyle = null;
      cTTableStyle = (CTTableStyle)get_store().add_element_user(TABLESTYLE$16);
      return cTTableStyle;
    } 
  }
  
  public void unsetTableStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLESTYLE$16, 0);
    } 
  }
  
  public String getTableStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TABLESTYLEID$18, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STGuid xgetTableStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_element_user(TABLESTYLEID$18, 0);
      return sTGuid;
    } 
  }
  
  public boolean isSetTableStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TABLESTYLEID$18) != 0);
    } 
  }
  
  public void setTableStyleId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TABLESTYLEID$18, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(TABLESTYLEID$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTableStyleId(STGuid paramSTGuid) {
    synchronized (monitor()) {
      check_orphaned();
      STGuid sTGuid = null;
      sTGuid = (STGuid)get_store().find_element_user(TABLESTYLEID$18, 0);
      if (sTGuid == null)
        sTGuid = (STGuid)get_store().add_element_user(TABLESTYLEID$18); 
      sTGuid.set((XmlObject)paramSTGuid);
    } 
  }
  
  public void unsetTableStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TABLESTYLEID$18, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$20) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$20); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$20);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$20, 0);
    } 
  }
  
  public boolean getRtl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(RTL$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(RTL$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RTL$22) != null);
    } 
  }
  
  public void setRtl(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RTL$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RTL$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRtl(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(RTL$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(RTL$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRtl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RTL$22);
    } 
  }
  
  public boolean getFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTROW$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTROW$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIRSTROW$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FIRSTROW$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTROW$24) != null);
    } 
  }
  
  public void setFirstRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTROW$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTROW$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFirstRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIRSTROW$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FIRSTROW$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFirstRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTROW$24);
    } 
  }
  
  public boolean getFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTCOL$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FIRSTCOL$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIRSTCOL$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FIRSTCOL$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FIRSTCOL$26) != null);
    } 
  }
  
  public void setFirstCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FIRSTCOL$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FIRSTCOL$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFirstCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIRSTCOL$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FIRSTCOL$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFirstCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FIRSTCOL$26);
    } 
  }
  
  public boolean getLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTROW$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LASTROW$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LASTROW$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LASTROW$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LASTROW$28) != null);
    } 
  }
  
  public void setLastRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTROW$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LASTROW$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLastRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LASTROW$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LASTROW$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLastRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LASTROW$28);
    } 
  }
  
  public boolean getLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTCOL$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LASTCOL$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LASTCOL$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LASTCOL$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LASTCOL$30) != null);
    } 
  }
  
  public void setLastCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LASTCOL$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LASTCOL$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetLastCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LASTCOL$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LASTCOL$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetLastCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LASTCOL$30);
    } 
  }
  
  public boolean getBandRow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BANDROW$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BANDROW$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBandRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BANDROW$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BANDROW$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBandRow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BANDROW$32) != null);
    } 
  }
  
  public void setBandRow(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BANDROW$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BANDROW$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBandRow(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BANDROW$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BANDROW$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBandRow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BANDROW$32);
    } 
  }
  
  public boolean getBandCol() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BANDCOL$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BANDCOL$34); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBandCol() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BANDCOL$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BANDCOL$34); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBandCol() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BANDCOL$34) != null);
    } 
  }
  
  public void setBandCol(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BANDCOL$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BANDCOL$34); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBandCol(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BANDCOL$34);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BANDCOL$34); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBandCol() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BANDCOL$34);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTablePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */