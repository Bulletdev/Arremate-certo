package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;

public class CTGroupShapePropertiesImpl extends XmlComplexContentImpl implements CTGroupShapeProperties {
  private static final b XFRM$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "xfrm");
  
  private static final b NOFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b EFFECTLST$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b SCENE3D$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b BWMODE$22 = new b("", "bwMode");
  
  public CTGroupShapePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTGroupTransform2D getXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupTransform2D cTGroupTransform2D = null;
      cTGroupTransform2D = (CTGroupTransform2D)get_store().find_element_user(XFRM$0, 0);
      if (cTGroupTransform2D == null)
        return null; 
      return cTGroupTransform2D;
    } 
  }
  
  public boolean isSetXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(XFRM$0) != 0);
    } 
  }
  
  public void setXfrm(CTGroupTransform2D paramCTGroupTransform2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupTransform2D cTGroupTransform2D = null;
      cTGroupTransform2D = (CTGroupTransform2D)get_store().find_element_user(XFRM$0, 0);
      if (cTGroupTransform2D == null)
        cTGroupTransform2D = (CTGroupTransform2D)get_store().add_element_user(XFRM$0); 
      cTGroupTransform2D.set((XmlObject)paramCTGroupTransform2D);
    } 
  }
  
  public CTGroupTransform2D addNewXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupTransform2D cTGroupTransform2D = null;
      cTGroupTransform2D = (CTGroupTransform2D)get_store().add_element_user(XFRM$0);
      return cTGroupTransform2D;
    } 
  }
  
  public void unsetXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XFRM$0, 0);
    } 
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$2, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$2) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$2, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$2); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$2);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$2, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$4, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$4) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$4, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$4); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$4);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$4, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$6, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$6) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$6, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$6); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$6);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$6, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$8, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$8) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$8, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$8); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$8);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$8, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$10, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$10) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$10, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$10); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$10);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$10, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$12, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$12) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$12, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$12); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$12);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$12, 0);
    } 
  }
  
  public CTEffectList getEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$14, 0);
      if (cTEffectList == null)
        return null; 
      return cTEffectList;
    } 
  }
  
  public boolean isSetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTLST$14) != 0);
    } 
  }
  
  public void setEffectLst(CTEffectList paramCTEffectList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$14, 0);
      if (cTEffectList == null)
        cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$14); 
      cTEffectList.set((XmlObject)paramCTEffectList);
    } 
  }
  
  public CTEffectList addNewEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$14);
      return cTEffectList;
    } 
  }
  
  public void unsetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTLST$14, 0);
    } 
  }
  
  public CTEffectContainer getEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$16, 0);
      if (cTEffectContainer == null)
        return null; 
      return cTEffectContainer;
    } 
  }
  
  public boolean isSetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTDAG$16) != 0);
    } 
  }
  
  public void setEffectDag(CTEffectContainer paramCTEffectContainer) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$16, 0);
      if (cTEffectContainer == null)
        cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$16); 
      cTEffectContainer.set((XmlObject)paramCTEffectContainer);
    } 
  }
  
  public CTEffectContainer addNewEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$16);
      return cTEffectContainer;
    } 
  }
  
  public void unsetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTDAG$16, 0);
    } 
  }
  
  public CTScene3D getScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$18, 0);
      if (cTScene3D == null)
        return null; 
      return cTScene3D;
    } 
  }
  
  public boolean isSetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCENE3D$18) != 0);
    } 
  }
  
  public void setScene3D(CTScene3D paramCTScene3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$18, 0);
      if (cTScene3D == null)
        cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$18); 
      cTScene3D.set((XmlObject)paramCTScene3D);
    } 
  }
  
  public CTScene3D addNewScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$18);
      return cTScene3D;
    } 
  }
  
  public void unsetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCENE3D$18, 0);
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
  
  public STBlackWhiteMode.Enum getBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$22);
      if (simpleValue == null)
        return null; 
      return (STBlackWhiteMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBlackWhiteMode xgetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$22);
      return sTBlackWhiteMode;
    } 
  }
  
  public boolean isSetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWMODE$22) != null);
    } 
  }
  
  public void setBwMode(STBlackWhiteMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWMODE$22); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$22);
      if (sTBlackWhiteMode == null)
        sTBlackWhiteMode = (STBlackWhiteMode)get_store().add_attribute_user(BWMODE$22); 
      sTBlackWhiteMode.set((XmlObject)paramSTBlackWhiteMode);
    } 
  }
  
  public void unsetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWMODE$22);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTGroupShapePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */