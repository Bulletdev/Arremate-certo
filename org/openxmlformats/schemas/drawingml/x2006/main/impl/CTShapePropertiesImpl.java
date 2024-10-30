package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShape3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;

public class CTShapePropertiesImpl extends XmlComplexContentImpl implements CTShapeProperties {
  private static final b XFRM$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "xfrm");
  
  private static final b CUSTGEOM$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "custGeom");
  
  private static final b PRSTGEOM$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstGeom");
  
  private static final b NOFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b LN$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "ln");
  
  private static final b EFFECTLST$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectLst");
  
  private static final b EFFECTDAG$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "effectDag");
  
  private static final b SCENE3D$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scene3d");
  
  private static final b SP3D$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sp3d");
  
  private static final b EXTLST$28 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b BWMODE$30 = new b("", "bwMode");
  
  public CTShapePropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTransform2D getXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().find_element_user(XFRM$0, 0);
      if (cTTransform2D == null)
        return null; 
      return cTTransform2D;
    } 
  }
  
  public boolean isSetXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(XFRM$0) != 0);
    } 
  }
  
  public void setXfrm(CTTransform2D paramCTTransform2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().find_element_user(XFRM$0, 0);
      if (cTTransform2D == null)
        cTTransform2D = (CTTransform2D)get_store().add_element_user(XFRM$0); 
      cTTransform2D.set((XmlObject)paramCTTransform2D);
    } 
  }
  
  public CTTransform2D addNewXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      CTTransform2D cTTransform2D = null;
      cTTransform2D = (CTTransform2D)get_store().add_element_user(XFRM$0);
      return cTTransform2D;
    } 
  }
  
  public void unsetXfrm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XFRM$0, 0);
    } 
  }
  
  public CTCustomGeometry2D getCustGeom() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomGeometry2D cTCustomGeometry2D = null;
      cTCustomGeometry2D = (CTCustomGeometry2D)get_store().find_element_user(CUSTGEOM$2, 0);
      if (cTCustomGeometry2D == null)
        return null; 
      return cTCustomGeometry2D;
    } 
  }
  
  public boolean isSetCustGeom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTGEOM$2) != 0);
    } 
  }
  
  public void setCustGeom(CTCustomGeometry2D paramCTCustomGeometry2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomGeometry2D cTCustomGeometry2D = null;
      cTCustomGeometry2D = (CTCustomGeometry2D)get_store().find_element_user(CUSTGEOM$2, 0);
      if (cTCustomGeometry2D == null)
        cTCustomGeometry2D = (CTCustomGeometry2D)get_store().add_element_user(CUSTGEOM$2); 
      cTCustomGeometry2D.set((XmlObject)paramCTCustomGeometry2D);
    } 
  }
  
  public CTCustomGeometry2D addNewCustGeom() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomGeometry2D cTCustomGeometry2D = null;
      cTCustomGeometry2D = (CTCustomGeometry2D)get_store().add_element_user(CUSTGEOM$2);
      return cTCustomGeometry2D;
    } 
  }
  
  public void unsetCustGeom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTGEOM$2, 0);
    } 
  }
  
  public CTPresetGeometry2D getPrstGeom() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetGeometry2D cTPresetGeometry2D = null;
      cTPresetGeometry2D = (CTPresetGeometry2D)get_store().find_element_user(PRSTGEOM$4, 0);
      if (cTPresetGeometry2D == null)
        return null; 
      return cTPresetGeometry2D;
    } 
  }
  
  public boolean isSetPrstGeom() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTGEOM$4) != 0);
    } 
  }
  
  public void setPrstGeom(CTPresetGeometry2D paramCTPresetGeometry2D) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetGeometry2D cTPresetGeometry2D = null;
      cTPresetGeometry2D = (CTPresetGeometry2D)get_store().find_element_user(PRSTGEOM$4, 0);
      if (cTPresetGeometry2D == null)
        cTPresetGeometry2D = (CTPresetGeometry2D)get_store().add_element_user(PRSTGEOM$4); 
      cTPresetGeometry2D.set((XmlObject)paramCTPresetGeometry2D);
    } 
  }
  
  public CTPresetGeometry2D addNewPrstGeom() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetGeometry2D cTPresetGeometry2D = null;
      cTPresetGeometry2D = (CTPresetGeometry2D)get_store().add_element_user(PRSTGEOM$4);
      return cTPresetGeometry2D;
    } 
  }
  
  public void unsetPrstGeom() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTGEOM$4, 0);
    } 
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$6, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$6) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$6, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$6); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$6);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$6, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$8, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$8) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$8, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$8); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$8);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$8, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$10, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$10) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$10, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$10); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$10);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$10, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$12, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$12) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$12, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$12); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$12);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$12, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$14, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$14) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$14, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$14); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$14);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$14, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$16, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$16) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$16, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$16); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$16);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$16, 0);
    } 
  }
  
  public CTLineProperties getLn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$18, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LN$18) != 0);
    } 
  }
  
  public void setLn(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LN$18, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LN$18); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLn() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LN$18);
      return cTLineProperties;
    } 
  }
  
  public void unsetLn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LN$18, 0);
    } 
  }
  
  public CTEffectList getEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$20, 0);
      if (cTEffectList == null)
        return null; 
      return cTEffectList;
    } 
  }
  
  public boolean isSetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTLST$20) != 0);
    } 
  }
  
  public void setEffectLst(CTEffectList paramCTEffectList) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().find_element_user(EFFECTLST$20, 0);
      if (cTEffectList == null)
        cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$20); 
      cTEffectList.set((XmlObject)paramCTEffectList);
    } 
  }
  
  public CTEffectList addNewEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectList cTEffectList = null;
      cTEffectList = (CTEffectList)get_store().add_element_user(EFFECTLST$20);
      return cTEffectList;
    } 
  }
  
  public void unsetEffectLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTLST$20, 0);
    } 
  }
  
  public CTEffectContainer getEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$22, 0);
      if (cTEffectContainer == null)
        return null; 
      return cTEffectContainer;
    } 
  }
  
  public boolean isSetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EFFECTDAG$22) != 0);
    } 
  }
  
  public void setEffectDag(CTEffectContainer paramCTEffectContainer) {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().find_element_user(EFFECTDAG$22, 0);
      if (cTEffectContainer == null)
        cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$22); 
      cTEffectContainer.set((XmlObject)paramCTEffectContainer);
    } 
  }
  
  public CTEffectContainer addNewEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      CTEffectContainer cTEffectContainer = null;
      cTEffectContainer = (CTEffectContainer)get_store().add_element_user(EFFECTDAG$22);
      return cTEffectContainer;
    } 
  }
  
  public void unsetEffectDag() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EFFECTDAG$22, 0);
    } 
  }
  
  public CTScene3D getScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$24, 0);
      if (cTScene3D == null)
        return null; 
      return cTScene3D;
    } 
  }
  
  public boolean isSetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCENE3D$24) != 0);
    } 
  }
  
  public void setScene3D(CTScene3D paramCTScene3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().find_element_user(SCENE3D$24, 0);
      if (cTScene3D == null)
        cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$24); 
      cTScene3D.set((XmlObject)paramCTScene3D);
    } 
  }
  
  public CTScene3D addNewScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTScene3D cTScene3D = null;
      cTScene3D = (CTScene3D)get_store().add_element_user(SCENE3D$24);
      return cTScene3D;
    } 
  }
  
  public void unsetScene3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCENE3D$24, 0);
    } 
  }
  
  public CTShape3D getSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$26, 0);
      if (cTShape3D == null)
        return null; 
      return cTShape3D;
    } 
  }
  
  public boolean isSetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SP3D$26) != 0);
    } 
  }
  
  public void setSp3D(CTShape3D paramCTShape3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().find_element_user(SP3D$26, 0);
      if (cTShape3D == null)
        cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$26); 
      cTShape3D.set((XmlObject)paramCTShape3D);
    } 
  }
  
  public CTShape3D addNewSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTShape3D cTShape3D = null;
      cTShape3D = (CTShape3D)get_store().add_element_user(SP3D$26);
      return cTShape3D;
    } 
  }
  
  public void unsetSp3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SP3D$26, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$28) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$28, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$28); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$28);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$28, 0);
    } 
  }
  
  public STBlackWhiteMode.Enum getBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$30);
      if (simpleValue == null)
        return null; 
      return (STBlackWhiteMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STBlackWhiteMode xgetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$30);
      return sTBlackWhiteMode;
    } 
  }
  
  public boolean isSetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BWMODE$30) != null);
    } 
  }
  
  public void setBwMode(STBlackWhiteMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BWMODE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BWMODE$30); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode) {
    synchronized (monitor()) {
      check_orphaned();
      STBlackWhiteMode sTBlackWhiteMode = null;
      sTBlackWhiteMode = (STBlackWhiteMode)get_store().find_attribute_user(BWMODE$30);
      if (sTBlackWhiteMode == null)
        sTBlackWhiteMode = (STBlackWhiteMode)get_store().add_attribute_user(BWMODE$30); 
      sTBlackWhiteMode.set((XmlObject)paramSTBlackWhiteMode);
    } 
  }
  
  public void unsetBwMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BWMODE$30);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTShapePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */