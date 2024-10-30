package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCell3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;

public class CTTableCellPropertiesImpl extends XmlComplexContentImpl implements CTTableCellProperties {
  private static final b LNL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnL");
  
  private static final b LNR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnR");
  
  private static final b LNT$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnT");
  
  private static final b LNB$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnB");
  
  private static final b LNTLTOBR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnTlToBr");
  
  private static final b LNBLTOTR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lnBlToTr");
  
  private static final b CELL3D$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "cell3D");
  
  private static final b NOFILL$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b BLIPFILL$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill");
  
  private static final b PATTFILL$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b GRPFILL$24 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill");
  
  private static final b EXTLST$26 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b MARL$28 = new b("", "marL");
  
  private static final b MARR$30 = new b("", "marR");
  
  private static final b MART$32 = new b("", "marT");
  
  private static final b MARB$34 = new b("", "marB");
  
  private static final b VERT$36 = new b("", "vert");
  
  private static final b ANCHOR$38 = new b("", "anchor");
  
  private static final b ANCHORCTR$40 = new b("", "anchorCtr");
  
  private static final b HORZOVERFLOW$42 = new b("", "horzOverflow");
  
  public CTTableCellPropertiesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTLineProperties getLnL() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNL$0, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNL$0) != 0);
    } 
  }
  
  public void setLnL(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNL$0, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNL$0); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnL() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNL$0);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNL$0, 0);
    } 
  }
  
  public CTLineProperties getLnR() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNR$2, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNR$2) != 0);
    } 
  }
  
  public void setLnR(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNR$2, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNR$2); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnR() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNR$2);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNR$2, 0);
    } 
  }
  
  public CTLineProperties getLnT() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNT$4, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNT$4) != 0);
    } 
  }
  
  public void setLnT(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNT$4, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNT$4); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnT() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNT$4);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNT$4, 0);
    } 
  }
  
  public CTLineProperties getLnB() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNB$6, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNB$6) != 0);
    } 
  }
  
  public void setLnB(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNB$6, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNB$6); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnB() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNB$6);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNB$6, 0);
    } 
  }
  
  public CTLineProperties getLnTlToBr() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNTLTOBR$8, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnTlToBr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNTLTOBR$8) != 0);
    } 
  }
  
  public void setLnTlToBr(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNTLTOBR$8, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNTLTOBR$8); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnTlToBr() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNTLTOBR$8);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnTlToBr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNTLTOBR$8, 0);
    } 
  }
  
  public CTLineProperties getLnBlToTr() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNBLTOTR$10, 0);
      if (cTLineProperties == null)
        return null; 
      return cTLineProperties;
    } 
  }
  
  public boolean isSetLnBlToTr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LNBLTOTR$10) != 0);
    } 
  }
  
  public void setLnBlToTr(CTLineProperties paramCTLineProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().find_element_user(LNBLTOTR$10, 0);
      if (cTLineProperties == null)
        cTLineProperties = (CTLineProperties)get_store().add_element_user(LNBLTOTR$10); 
      cTLineProperties.set((XmlObject)paramCTLineProperties);
    } 
  }
  
  public CTLineProperties addNewLnBlToTr() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineProperties cTLineProperties = null;
      cTLineProperties = (CTLineProperties)get_store().add_element_user(LNBLTOTR$10);
      return cTLineProperties;
    } 
  }
  
  public void unsetLnBlToTr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LNBLTOTR$10, 0);
    } 
  }
  
  public CTCell3D getCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().find_element_user(CELL3D$12, 0);
      if (cTCell3D == null)
        return null; 
      return cTCell3D;
    } 
  }
  
  public boolean isSetCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CELL3D$12) != 0);
    } 
  }
  
  public void setCell3D(CTCell3D paramCTCell3D) {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().find_element_user(CELL3D$12, 0);
      if (cTCell3D == null)
        cTCell3D = (CTCell3D)get_store().add_element_user(CELL3D$12); 
      cTCell3D.set((XmlObject)paramCTCell3D);
    } 
  }
  
  public CTCell3D addNewCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      CTCell3D cTCell3D = null;
      cTCell3D = (CTCell3D)get_store().add_element_user(CELL3D$12);
      return cTCell3D;
    } 
  }
  
  public void unsetCell3D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CELL3D$12, 0);
    } 
  }
  
  public CTNoFillProperties getNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$14, 0);
      if (cTNoFillProperties == null)
        return null; 
      return cTNoFillProperties;
    } 
  }
  
  public boolean isSetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NOFILL$14) != 0);
    } 
  }
  
  public void setNoFill(CTNoFillProperties paramCTNoFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().find_element_user(NOFILL$14, 0);
      if (cTNoFillProperties == null)
        cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$14); 
      cTNoFillProperties.set((XmlObject)paramCTNoFillProperties);
    } 
  }
  
  public CTNoFillProperties addNewNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTNoFillProperties cTNoFillProperties = null;
      cTNoFillProperties = (CTNoFillProperties)get_store().add_element_user(NOFILL$14);
      return cTNoFillProperties;
    } 
  }
  
  public void unsetNoFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOFILL$14, 0);
    } 
  }
  
  public CTSolidColorFillProperties getSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$16, 0);
      if (cTSolidColorFillProperties == null)
        return null; 
      return cTSolidColorFillProperties;
    } 
  }
  
  public boolean isSetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SOLIDFILL$16) != 0);
    } 
  }
  
  public void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().find_element_user(SOLIDFILL$16, 0);
      if (cTSolidColorFillProperties == null)
        cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$16); 
      cTSolidColorFillProperties.set((XmlObject)paramCTSolidColorFillProperties);
    } 
  }
  
  public CTSolidColorFillProperties addNewSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTSolidColorFillProperties cTSolidColorFillProperties = null;
      cTSolidColorFillProperties = (CTSolidColorFillProperties)get_store().add_element_user(SOLIDFILL$16);
      return cTSolidColorFillProperties;
    } 
  }
  
  public void unsetSolidFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SOLIDFILL$16, 0);
    } 
  }
  
  public CTGradientFillProperties getGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$18, 0);
      if (cTGradientFillProperties == null)
        return null; 
      return cTGradientFillProperties;
    } 
  }
  
  public boolean isSetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRADFILL$18) != 0);
    } 
  }
  
  public void setGradFill(CTGradientFillProperties paramCTGradientFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().find_element_user(GRADFILL$18, 0);
      if (cTGradientFillProperties == null)
        cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$18); 
      cTGradientFillProperties.set((XmlObject)paramCTGradientFillProperties);
    } 
  }
  
  public CTGradientFillProperties addNewGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGradientFillProperties cTGradientFillProperties = null;
      cTGradientFillProperties = (CTGradientFillProperties)get_store().add_element_user(GRADFILL$18);
      return cTGradientFillProperties;
    } 
  }
  
  public void unsetGradFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRADFILL$18, 0);
    } 
  }
  
  public CTBlipFillProperties getBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$20, 0);
      if (cTBlipFillProperties == null)
        return null; 
      return cTBlipFillProperties;
    } 
  }
  
  public boolean isSetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BLIPFILL$20) != 0);
    } 
  }
  
  public void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().find_element_user(BLIPFILL$20, 0);
      if (cTBlipFillProperties == null)
        cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$20); 
      cTBlipFillProperties.set((XmlObject)paramCTBlipFillProperties);
    } 
  }
  
  public CTBlipFillProperties addNewBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTBlipFillProperties cTBlipFillProperties = null;
      cTBlipFillProperties = (CTBlipFillProperties)get_store().add_element_user(BLIPFILL$20);
      return cTBlipFillProperties;
    } 
  }
  
  public void unsetBlipFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BLIPFILL$20, 0);
    } 
  }
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$22, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$22) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$22, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$22); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$22);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$22, 0);
    } 
  }
  
  public CTGroupFillProperties getGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$24, 0);
      if (cTGroupFillProperties == null)
        return null; 
      return cTGroupFillProperties;
    } 
  }
  
  public boolean isSetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GRPFILL$24) != 0);
    } 
  }
  
  public void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().find_element_user(GRPFILL$24, 0);
      if (cTGroupFillProperties == null)
        cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$24); 
      cTGroupFillProperties.set((XmlObject)paramCTGroupFillProperties);
    } 
  }
  
  public CTGroupFillProperties addNewGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTGroupFillProperties cTGroupFillProperties = null;
      cTGroupFillProperties = (CTGroupFillProperties)get_store().add_element_user(GRPFILL$24);
      return cTGroupFillProperties;
    } 
  }
  
  public void unsetGrpFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GRPFILL$24, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$26) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$26, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$26); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$26);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$26, 0);
    } 
  }
  
  public int getMarL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARL$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MARL$28); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARL$28);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_default_attribute_value(MARL$28); 
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MARL$28) != null);
    } 
  }
  
  public void setMarL(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARL$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MARL$28); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarL(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARL$28);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(MARL$28); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetMarL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MARL$28);
    } 
  }
  
  public int getMarR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARR$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MARR$30); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARR$30);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_default_attribute_value(MARR$30); 
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MARR$30) != null);
    } 
  }
  
  public void setMarR(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARR$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MARR$30); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarR(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARR$30);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(MARR$30); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetMarR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MARR$30);
    } 
  }
  
  public int getMarT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MART$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MART$32); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetMarT() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MART$32);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_default_attribute_value(MART$32); 
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetMarT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MART$32) != null);
    } 
  }
  
  public void setMarT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MART$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MART$32); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarT(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MART$32);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(MART$32); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetMarT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MART$32);
    } 
  }
  
  public int getMarB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARB$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MARB$34); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STCoordinate32 xgetMarB() {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARB$34);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_default_attribute_value(MARB$34); 
      return sTCoordinate32;
    } 
  }
  
  public boolean isSetMarB() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MARB$34) != null);
    } 
  }
  
  public void setMarB(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MARB$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MARB$34); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMarB(STCoordinate32 paramSTCoordinate32) {
    synchronized (monitor()) {
      check_orphaned();
      STCoordinate32 sTCoordinate32 = null;
      sTCoordinate32 = (STCoordinate32)get_store().find_attribute_user(MARB$34);
      if (sTCoordinate32 == null)
        sTCoordinate32 = (STCoordinate32)get_store().add_attribute_user(MARB$34); 
      sTCoordinate32.set((XmlObject)paramSTCoordinate32);
    } 
  }
  
  public void unsetMarB() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MARB$34);
    } 
  }
  
  public STTextVerticalType.Enum getVert() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERT$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(VERT$36); 
      if (simpleValue == null)
        return null; 
      return (STTextVerticalType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextVerticalType xgetVert() {
    synchronized (monitor()) {
      check_orphaned();
      STTextVerticalType sTTextVerticalType = null;
      sTTextVerticalType = (STTextVerticalType)get_store().find_attribute_user(VERT$36);
      if (sTTextVerticalType == null)
        sTTextVerticalType = (STTextVerticalType)get_default_attribute_value(VERT$36); 
      return sTTextVerticalType;
    } 
  }
  
  public boolean isSetVert() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERT$36) != null);
    } 
  }
  
  public void setVert(STTextVerticalType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERT$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERT$36); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVert(STTextVerticalType paramSTTextVerticalType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextVerticalType sTTextVerticalType = null;
      sTTextVerticalType = (STTextVerticalType)get_store().find_attribute_user(VERT$36);
      if (sTTextVerticalType == null)
        sTTextVerticalType = (STTextVerticalType)get_store().add_attribute_user(VERT$36); 
      sTTextVerticalType.set((XmlObject)paramSTTextVerticalType);
    } 
  }
  
  public void unsetVert() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERT$36);
    } 
  }
  
  public STTextAnchoringType.Enum getAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHOR$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ANCHOR$38); 
      if (simpleValue == null)
        return null; 
      return (STTextAnchoringType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextAnchoringType xgetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      STTextAnchoringType sTTextAnchoringType = null;
      sTTextAnchoringType = (STTextAnchoringType)get_store().find_attribute_user(ANCHOR$38);
      if (sTTextAnchoringType == null)
        sTTextAnchoringType = (STTextAnchoringType)get_default_attribute_value(ANCHOR$38); 
      return sTTextAnchoringType;
    } 
  }
  
  public boolean isSetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANCHOR$38) != null);
    } 
  }
  
  public void setAnchor(STTextAnchoringType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHOR$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANCHOR$38); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAnchor(STTextAnchoringType paramSTTextAnchoringType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextAnchoringType sTTextAnchoringType = null;
      sTTextAnchoringType = (STTextAnchoringType)get_store().find_attribute_user(ANCHOR$38);
      if (sTTextAnchoringType == null)
        sTTextAnchoringType = (STTextAnchoringType)get_store().add_attribute_user(ANCHOR$38); 
      sTTextAnchoringType.set((XmlObject)paramSTTextAnchoringType);
    } 
  }
  
  public void unsetAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANCHOR$38);
    } 
  }
  
  public boolean getAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHORCTR$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ANCHORCTR$40); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ANCHORCTR$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ANCHORCTR$40); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ANCHORCTR$40) != null);
    } 
  }
  
  public void setAnchorCtr(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ANCHORCTR$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ANCHORCTR$40); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAnchorCtr(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ANCHORCTR$40);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ANCHORCTR$40); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAnchorCtr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ANCHORCTR$40);
    } 
  }
  
  public STTextHorzOverflowType.Enum getHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORZOVERFLOW$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HORZOVERFLOW$42); 
      if (simpleValue == null)
        return null; 
      return (STTextHorzOverflowType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTextHorzOverflowType xgetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      STTextHorzOverflowType sTTextHorzOverflowType = null;
      sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().find_attribute_user(HORZOVERFLOW$42);
      if (sTTextHorzOverflowType == null)
        sTTextHorzOverflowType = (STTextHorzOverflowType)get_default_attribute_value(HORZOVERFLOW$42); 
      return sTTextHorzOverflowType;
    } 
  }
  
  public boolean isSetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORZOVERFLOW$42) != null);
    } 
  }
  
  public void setHorzOverflow(STTextHorzOverflowType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORZOVERFLOW$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORZOVERFLOW$42); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHorzOverflow(STTextHorzOverflowType paramSTTextHorzOverflowType) {
    synchronized (monitor()) {
      check_orphaned();
      STTextHorzOverflowType sTTextHorzOverflowType = null;
      sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().find_attribute_user(HORZOVERFLOW$42);
      if (sTTextHorzOverflowType == null)
        sTTextHorzOverflowType = (STTextHorzOverflowType)get_store().add_attribute_user(HORZOVERFLOW$42); 
      sTTextHorzOverflowType.set((XmlObject)paramSTTextHorzOverflowType);
    } 
  }
  
  public void unsetHorzOverflow() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORZOVERFLOW$42);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTableCellPropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */