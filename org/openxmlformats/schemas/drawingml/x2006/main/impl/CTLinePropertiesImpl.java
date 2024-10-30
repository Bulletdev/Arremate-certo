package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinBevel;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinMiterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineJoinRound;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;

public class CTLinePropertiesImpl extends XmlComplexContentImpl implements CTLineProperties {
  private static final b NOFILL$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill");
  
  private static final b SOLIDFILL$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill");
  
  private static final b GRADFILL$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill");
  
  private static final b PATTFILL$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill");
  
  private static final b PRSTDASH$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstDash");
  
  private static final b CUSTDASH$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "custDash");
  
  private static final b ROUND$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "round");
  
  private static final b BEVEL$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "bevel");
  
  private static final b MITER$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "miter");
  
  private static final b HEADEND$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "headEnd");
  
  private static final b TAILEND$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tailEnd");
  
  private static final b EXTLST$22 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  private static final b W$24 = new b("", "w");
  
  private static final b CAP$26 = new b("", "cap");
  
  private static final b CMPD$28 = new b("", "cmpd");
  
  private static final b ALGN$30 = new b("", "algn");
  
  public CTLinePropertiesImpl(SchemaType paramSchemaType) {
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
  
  public CTPatternFillProperties getPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$6, 0);
      if (cTPatternFillProperties == null)
        return null; 
      return cTPatternFillProperties;
    } 
  }
  
  public boolean isSetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PATTFILL$6) != 0);
    } 
  }
  
  public void setPattFill(CTPatternFillProperties paramCTPatternFillProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().find_element_user(PATTFILL$6, 0);
      if (cTPatternFillProperties == null)
        cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$6); 
      cTPatternFillProperties.set((XmlObject)paramCTPatternFillProperties);
    } 
  }
  
  public CTPatternFillProperties addNewPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      CTPatternFillProperties cTPatternFillProperties = null;
      cTPatternFillProperties = (CTPatternFillProperties)get_store().add_element_user(PATTFILL$6);
      return cTPatternFillProperties;
    } 
  }
  
  public void unsetPattFill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PATTFILL$6, 0);
    } 
  }
  
  public CTPresetLineDashProperties getPrstDash() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetLineDashProperties cTPresetLineDashProperties = null;
      cTPresetLineDashProperties = (CTPresetLineDashProperties)get_store().find_element_user(PRSTDASH$8, 0);
      if (cTPresetLineDashProperties == null)
        return null; 
      return cTPresetLineDashProperties;
    } 
  }
  
  public boolean isSetPrstDash() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTDASH$8) != 0);
    } 
  }
  
  public void setPrstDash(CTPresetLineDashProperties paramCTPresetLineDashProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetLineDashProperties cTPresetLineDashProperties = null;
      cTPresetLineDashProperties = (CTPresetLineDashProperties)get_store().find_element_user(PRSTDASH$8, 0);
      if (cTPresetLineDashProperties == null)
        cTPresetLineDashProperties = (CTPresetLineDashProperties)get_store().add_element_user(PRSTDASH$8); 
      cTPresetLineDashProperties.set((XmlObject)paramCTPresetLineDashProperties);
    } 
  }
  
  public CTPresetLineDashProperties addNewPrstDash() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetLineDashProperties cTPresetLineDashProperties = null;
      cTPresetLineDashProperties = (CTPresetLineDashProperties)get_store().add_element_user(PRSTDASH$8);
      return cTPresetLineDashProperties;
    } 
  }
  
  public void unsetPrstDash() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTDASH$8, 0);
    } 
  }
  
  public CTDashStopList getCustDash() {
    synchronized (monitor()) {
      check_orphaned();
      CTDashStopList cTDashStopList = null;
      cTDashStopList = (CTDashStopList)get_store().find_element_user(CUSTDASH$10, 0);
      if (cTDashStopList == null)
        return null; 
      return cTDashStopList;
    } 
  }
  
  public boolean isSetCustDash() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTDASH$10) != 0);
    } 
  }
  
  public void setCustDash(CTDashStopList paramCTDashStopList) {
    synchronized (monitor()) {
      check_orphaned();
      CTDashStopList cTDashStopList = null;
      cTDashStopList = (CTDashStopList)get_store().find_element_user(CUSTDASH$10, 0);
      if (cTDashStopList == null)
        cTDashStopList = (CTDashStopList)get_store().add_element_user(CUSTDASH$10); 
      cTDashStopList.set((XmlObject)paramCTDashStopList);
    } 
  }
  
  public CTDashStopList addNewCustDash() {
    synchronized (monitor()) {
      check_orphaned();
      CTDashStopList cTDashStopList = null;
      cTDashStopList = (CTDashStopList)get_store().add_element_user(CUSTDASH$10);
      return cTDashStopList;
    } 
  }
  
  public void unsetCustDash() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTDASH$10, 0);
    } 
  }
  
  public CTLineJoinRound getRound() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinRound cTLineJoinRound = null;
      cTLineJoinRound = (CTLineJoinRound)get_store().find_element_user(ROUND$12, 0);
      if (cTLineJoinRound == null)
        return null; 
      return cTLineJoinRound;
    } 
  }
  
  public boolean isSetRound() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ROUND$12) != 0);
    } 
  }
  
  public void setRound(CTLineJoinRound paramCTLineJoinRound) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinRound cTLineJoinRound = null;
      cTLineJoinRound = (CTLineJoinRound)get_store().find_element_user(ROUND$12, 0);
      if (cTLineJoinRound == null)
        cTLineJoinRound = (CTLineJoinRound)get_store().add_element_user(ROUND$12); 
      cTLineJoinRound.set((XmlObject)paramCTLineJoinRound);
    } 
  }
  
  public CTLineJoinRound addNewRound() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinRound cTLineJoinRound = null;
      cTLineJoinRound = (CTLineJoinRound)get_store().add_element_user(ROUND$12);
      return cTLineJoinRound;
    } 
  }
  
  public void unsetRound() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROUND$12, 0);
    } 
  }
  
  public CTLineJoinBevel getBevel() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinBevel cTLineJoinBevel = null;
      cTLineJoinBevel = (CTLineJoinBevel)get_store().find_element_user(BEVEL$14, 0);
      if (cTLineJoinBevel == null)
        return null; 
      return cTLineJoinBevel;
    } 
  }
  
  public boolean isSetBevel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BEVEL$14) != 0);
    } 
  }
  
  public void setBevel(CTLineJoinBevel paramCTLineJoinBevel) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinBevel cTLineJoinBevel = null;
      cTLineJoinBevel = (CTLineJoinBevel)get_store().find_element_user(BEVEL$14, 0);
      if (cTLineJoinBevel == null)
        cTLineJoinBevel = (CTLineJoinBevel)get_store().add_element_user(BEVEL$14); 
      cTLineJoinBevel.set((XmlObject)paramCTLineJoinBevel);
    } 
  }
  
  public CTLineJoinBevel addNewBevel() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinBevel cTLineJoinBevel = null;
      cTLineJoinBevel = (CTLineJoinBevel)get_store().add_element_user(BEVEL$14);
      return cTLineJoinBevel;
    } 
  }
  
  public void unsetBevel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BEVEL$14, 0);
    } 
  }
  
  public CTLineJoinMiterProperties getMiter() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinMiterProperties cTLineJoinMiterProperties = null;
      cTLineJoinMiterProperties = (CTLineJoinMiterProperties)get_store().find_element_user(MITER$16, 0);
      if (cTLineJoinMiterProperties == null)
        return null; 
      return cTLineJoinMiterProperties;
    } 
  }
  
  public boolean isSetMiter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MITER$16) != 0);
    } 
  }
  
  public void setMiter(CTLineJoinMiterProperties paramCTLineJoinMiterProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinMiterProperties cTLineJoinMiterProperties = null;
      cTLineJoinMiterProperties = (CTLineJoinMiterProperties)get_store().find_element_user(MITER$16, 0);
      if (cTLineJoinMiterProperties == null)
        cTLineJoinMiterProperties = (CTLineJoinMiterProperties)get_store().add_element_user(MITER$16); 
      cTLineJoinMiterProperties.set((XmlObject)paramCTLineJoinMiterProperties);
    } 
  }
  
  public CTLineJoinMiterProperties addNewMiter() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineJoinMiterProperties cTLineJoinMiterProperties = null;
      cTLineJoinMiterProperties = (CTLineJoinMiterProperties)get_store().add_element_user(MITER$16);
      return cTLineJoinMiterProperties;
    } 
  }
  
  public void unsetMiter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MITER$16, 0);
    } 
  }
  
  public CTLineEndProperties getHeadEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().find_element_user(HEADEND$18, 0);
      if (cTLineEndProperties == null)
        return null; 
      return cTLineEndProperties;
    } 
  }
  
  public boolean isSetHeadEnd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADEND$18) != 0);
    } 
  }
  
  public void setHeadEnd(CTLineEndProperties paramCTLineEndProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().find_element_user(HEADEND$18, 0);
      if (cTLineEndProperties == null)
        cTLineEndProperties = (CTLineEndProperties)get_store().add_element_user(HEADEND$18); 
      cTLineEndProperties.set((XmlObject)paramCTLineEndProperties);
    } 
  }
  
  public CTLineEndProperties addNewHeadEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().add_element_user(HEADEND$18);
      return cTLineEndProperties;
    } 
  }
  
  public void unsetHeadEnd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADEND$18, 0);
    } 
  }
  
  public CTLineEndProperties getTailEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().find_element_user(TAILEND$20, 0);
      if (cTLineEndProperties == null)
        return null; 
      return cTLineEndProperties;
    } 
  }
  
  public boolean isSetTailEnd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TAILEND$20) != 0);
    } 
  }
  
  public void setTailEnd(CTLineEndProperties paramCTLineEndProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().find_element_user(TAILEND$20, 0);
      if (cTLineEndProperties == null)
        cTLineEndProperties = (CTLineEndProperties)get_store().add_element_user(TAILEND$20); 
      cTLineEndProperties.set((XmlObject)paramCTLineEndProperties);
    } 
  }
  
  public CTLineEndProperties addNewTailEnd() {
    synchronized (monitor()) {
      check_orphaned();
      CTLineEndProperties cTLineEndProperties = null;
      cTLineEndProperties = (CTLineEndProperties)get_store().add_element_user(TAILEND$20);
      return cTLineEndProperties;
    } 
  }
  
  public void unsetTailEnd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TAILEND$20, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$22, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$22) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$22, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$22); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$22);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$22, 0);
    } 
  }
  
  public int getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$24);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STLineWidth xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STLineWidth sTLineWidth = null;
      sTLineWidth = (STLineWidth)get_store().find_attribute_user(W$24);
      return sTLineWidth;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(W$24) != null);
    } 
  }
  
  public void setW(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$24); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetW(STLineWidth paramSTLineWidth) {
    synchronized (monitor()) {
      check_orphaned();
      STLineWidth sTLineWidth = null;
      sTLineWidth = (STLineWidth)get_store().find_attribute_user(W$24);
      if (sTLineWidth == null)
        sTLineWidth = (STLineWidth)get_store().add_attribute_user(W$24); 
      sTLineWidth.set((XmlObject)paramSTLineWidth);
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(W$24);
    } 
  }
  
  public STLineCap.Enum getCap() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAP$26);
      if (simpleValue == null)
        return null; 
      return (STLineCap.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STLineCap xgetCap() {
    synchronized (monitor()) {
      check_orphaned();
      STLineCap sTLineCap = null;
      sTLineCap = (STLineCap)get_store().find_attribute_user(CAP$26);
      return sTLineCap;
    } 
  }
  
  public boolean isSetCap() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CAP$26) != null);
    } 
  }
  
  public void setCap(STLineCap.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CAP$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CAP$26); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCap(STLineCap paramSTLineCap) {
    synchronized (monitor()) {
      check_orphaned();
      STLineCap sTLineCap = null;
      sTLineCap = (STLineCap)get_store().find_attribute_user(CAP$26);
      if (sTLineCap == null)
        sTLineCap = (STLineCap)get_store().add_attribute_user(CAP$26); 
      sTLineCap.set((XmlObject)paramSTLineCap);
    } 
  }
  
  public void unsetCap() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CAP$26);
    } 
  }
  
  public STCompoundLine.Enum getCmpd() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CMPD$28);
      if (simpleValue == null)
        return null; 
      return (STCompoundLine.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCompoundLine xgetCmpd() {
    synchronized (monitor()) {
      check_orphaned();
      STCompoundLine sTCompoundLine = null;
      sTCompoundLine = (STCompoundLine)get_store().find_attribute_user(CMPD$28);
      return sTCompoundLine;
    } 
  }
  
  public boolean isSetCmpd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CMPD$28) != null);
    } 
  }
  
  public void setCmpd(STCompoundLine.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CMPD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CMPD$28); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCmpd(STCompoundLine paramSTCompoundLine) {
    synchronized (monitor()) {
      check_orphaned();
      STCompoundLine sTCompoundLine = null;
      sTCompoundLine = (STCompoundLine)get_store().find_attribute_user(CMPD$28);
      if (sTCompoundLine == null)
        sTCompoundLine = (STCompoundLine)get_store().add_attribute_user(CMPD$28); 
      sTCompoundLine.set((XmlObject)paramSTCompoundLine);
    } 
  }
  
  public void unsetCmpd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CMPD$28);
    } 
  }
  
  public STPenAlignment.Enum getAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$30);
      if (simpleValue == null)
        return null; 
      return (STPenAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPenAlignment xgetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      STPenAlignment sTPenAlignment = null;
      sTPenAlignment = (STPenAlignment)get_store().find_attribute_user(ALGN$30);
      return sTPenAlignment;
    } 
  }
  
  public boolean isSetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGN$30) != null);
    } 
  }
  
  public void setAlgn(STPenAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGN$30); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlgn(STPenAlignment paramSTPenAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STPenAlignment sTPenAlignment = null;
      sTPenAlignment = (STPenAlignment)get_store().find_attribute_user(ALGN$30);
      if (sTPenAlignment == null)
        sTPenAlignment = (STPenAlignment)get_store().add_attribute_user(ALGN$30); 
      sTPenAlignment.set((XmlObject)paramSTPenAlignment);
    } 
  }
  
  public void unsetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGN$30);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTLinePropertiesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */