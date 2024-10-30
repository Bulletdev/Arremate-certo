package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.STFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STRectAlignment;

public class CTOuterShadowEffectImpl extends XmlComplexContentImpl implements CTOuterShadowEffect {
  private static final b SCRGBCLR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "scrgbClr");
  
  private static final b SRGBCLR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr");
  
  private static final b HSLCLR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "hslClr");
  
  private static final b SYSCLR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "sysClr");
  
  private static final b SCHEMECLR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "schemeClr");
  
  private static final b PRSTCLR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "prstClr");
  
  private static final b BLURRAD$12 = new b("", "blurRad");
  
  private static final b DIST$14 = new b("", "dist");
  
  private static final b DIR$16 = new b("", "dir");
  
  private static final b SX$18 = new b("", "sx");
  
  private static final b SY$20 = new b("", "sy");
  
  private static final b KX$22 = new b("", "kx");
  
  private static final b KY$24 = new b("", "ky");
  
  private static final b ALGN$26 = new b("", "algn");
  
  private static final b ROTWITHSHAPE$28 = new b("", "rotWithShape");
  
  public CTOuterShadowEffectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTScRgbColor getScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$0, 0);
      if (cTScRgbColor == null)
        return null; 
      return cTScRgbColor;
    } 
  }
  
  public boolean isSetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCRGBCLR$0) != 0);
    } 
  }
  
  public void setScrgbClr(CTScRgbColor paramCTScRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().find_element_user(SCRGBCLR$0, 0);
      if (cTScRgbColor == null)
        cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$0); 
      cTScRgbColor.set((XmlObject)paramCTScRgbColor);
    } 
  }
  
  public CTScRgbColor addNewScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTScRgbColor cTScRgbColor = null;
      cTScRgbColor = (CTScRgbColor)get_store().add_element_user(SCRGBCLR$0);
      return cTScRgbColor;
    } 
  }
  
  public void unsetScrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRGBCLR$0, 0);
    } 
  }
  
  public CTSRgbColor getSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$2, 0);
      if (cTSRgbColor == null)
        return null; 
      return cTSRgbColor;
    } 
  }
  
  public boolean isSetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SRGBCLR$2) != 0);
    } 
  }
  
  public void setSrgbClr(CTSRgbColor paramCTSRgbColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().find_element_user(SRGBCLR$2, 0);
      if (cTSRgbColor == null)
        cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$2); 
      cTSRgbColor.set((XmlObject)paramCTSRgbColor);
    } 
  }
  
  public CTSRgbColor addNewSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSRgbColor cTSRgbColor = null;
      cTSRgbColor = (CTSRgbColor)get_store().add_element_user(SRGBCLR$2);
      return cTSRgbColor;
    } 
  }
  
  public void unsetSrgbClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SRGBCLR$2, 0);
    } 
  }
  
  public CTHslColor getHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$4, 0);
      if (cTHslColor == null)
        return null; 
      return cTHslColor;
    } 
  }
  
  public boolean isSetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HSLCLR$4) != 0);
    } 
  }
  
  public void setHslClr(CTHslColor paramCTHslColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().find_element_user(HSLCLR$4, 0);
      if (cTHslColor == null)
        cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$4); 
      cTHslColor.set((XmlObject)paramCTHslColor);
    } 
  }
  
  public CTHslColor addNewHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTHslColor cTHslColor = null;
      cTHslColor = (CTHslColor)get_store().add_element_user(HSLCLR$4);
      return cTHslColor;
    } 
  }
  
  public void unsetHslClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HSLCLR$4, 0);
    } 
  }
  
  public CTSystemColor getSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$6, 0);
      if (cTSystemColor == null)
        return null; 
      return cTSystemColor;
    } 
  }
  
  public boolean isSetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SYSCLR$6) != 0);
    } 
  }
  
  public void setSysClr(CTSystemColor paramCTSystemColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().find_element_user(SYSCLR$6, 0);
      if (cTSystemColor == null)
        cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$6); 
      cTSystemColor.set((XmlObject)paramCTSystemColor);
    } 
  }
  
  public CTSystemColor addNewSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSystemColor cTSystemColor = null;
      cTSystemColor = (CTSystemColor)get_store().add_element_user(SYSCLR$6);
      return cTSystemColor;
    } 
  }
  
  public void unsetSysClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SYSCLR$6, 0);
    } 
  }
  
  public CTSchemeColor getSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$8, 0);
      if (cTSchemeColor == null)
        return null; 
      return cTSchemeColor;
    } 
  }
  
  public boolean isSetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SCHEMECLR$8) != 0);
    } 
  }
  
  public void setSchemeClr(CTSchemeColor paramCTSchemeColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().find_element_user(SCHEMECLR$8, 0);
      if (cTSchemeColor == null)
        cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$8); 
      cTSchemeColor.set((XmlObject)paramCTSchemeColor);
    } 
  }
  
  public CTSchemeColor addNewSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSchemeColor cTSchemeColor = null;
      cTSchemeColor = (CTSchemeColor)get_store().add_element_user(SCHEMECLR$8);
      return cTSchemeColor;
    } 
  }
  
  public void unsetSchemeClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCHEMECLR$8, 0);
    } 
  }
  
  public CTPresetColor getPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$10, 0);
      if (cTPresetColor == null)
        return null; 
      return cTPresetColor;
    } 
  }
  
  public boolean isSetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PRSTCLR$10) != 0);
    } 
  }
  
  public void setPrstClr(CTPresetColor paramCTPresetColor) {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().find_element_user(PRSTCLR$10, 0);
      if (cTPresetColor == null)
        cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$10); 
      cTPresetColor.set((XmlObject)paramCTPresetColor);
    } 
  }
  
  public CTPresetColor addNewPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPresetColor cTPresetColor = null;
      cTPresetColor = (CTPresetColor)get_store().add_element_user(PRSTCLR$10);
      return cTPresetColor;
    } 
  }
  
  public void unsetPrstClr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRSTCLR$10, 0);
    } 
  }
  
  public long getBlurRad() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLURRAD$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BLURRAD$12); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetBlurRad() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(BLURRAD$12);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_default_attribute_value(BLURRAD$12); 
      return sTPositiveCoordinate;
    } 
  }
  
  public boolean isSetBlurRad() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BLURRAD$12) != null);
    } 
  }
  
  public void setBlurRad(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BLURRAD$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BLURRAD$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBlurRad(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(BLURRAD$12);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(BLURRAD$12); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
  
  public void unsetBlurRad() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BLURRAD$12);
    } 
  }
  
  public long getDist() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIST$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIST$14); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STPositiveCoordinate xgetDist() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(DIST$14);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_default_attribute_value(DIST$14); 
      return sTPositiveCoordinate;
    } 
  }
  
  public boolean isSetDist() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIST$14) != null);
    } 
  }
  
  public void setDist(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIST$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIST$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDist(STPositiveCoordinate paramSTPositiveCoordinate) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveCoordinate sTPositiveCoordinate = null;
      sTPositiveCoordinate = (STPositiveCoordinate)get_store().find_attribute_user(DIST$14);
      if (sTPositiveCoordinate == null)
        sTPositiveCoordinate = (STPositiveCoordinate)get_store().add_attribute_user(DIST$14); 
      sTPositiveCoordinate.set((XmlObject)paramSTPositiveCoordinate);
    } 
  }
  
  public void unsetDist() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIST$14);
    } 
  }
  
  public int getDir() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIR$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DIR$16); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveFixedAngle xgetDir() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedAngle sTPositiveFixedAngle = null;
      sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().find_attribute_user(DIR$16);
      if (sTPositiveFixedAngle == null)
        sTPositiveFixedAngle = (STPositiveFixedAngle)get_default_attribute_value(DIR$16); 
      return sTPositiveFixedAngle;
    } 
  }
  
  public boolean isSetDir() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DIR$16) != null);
    } 
  }
  
  public void setDir(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DIR$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DIR$16); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetDir(STPositiveFixedAngle paramSTPositiveFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveFixedAngle sTPositiveFixedAngle = null;
      sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().find_attribute_user(DIR$16);
      if (sTPositiveFixedAngle == null)
        sTPositiveFixedAngle = (STPositiveFixedAngle)get_store().add_attribute_user(DIR$16); 
      sTPositiveFixedAngle.set((XmlObject)paramSTPositiveFixedAngle);
    } 
  }
  
  public void unsetDir() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DIR$16);
    } 
  }
  
  public int getSx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SX$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SX$18); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetSx() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SX$18);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(SX$18); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetSx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SX$18) != null);
    } 
  }
  
  public void setSx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SX$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SX$18); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSx(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SX$18);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(SX$18); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetSx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SX$18);
    } 
  }
  
  public int getSy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SY$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SY$20); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPercentage xgetSy() {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SY$20);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_default_attribute_value(SY$20); 
      return sTPercentage;
    } 
  }
  
  public boolean isSetSy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SY$20) != null);
    } 
  }
  
  public void setSy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SY$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SY$20); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSy(STPercentage paramSTPercentage) {
    synchronized (monitor()) {
      check_orphaned();
      STPercentage sTPercentage = null;
      sTPercentage = (STPercentage)get_store().find_attribute_user(SY$20);
      if (sTPercentage == null)
        sTPercentage = (STPercentage)get_store().add_attribute_user(SY$20); 
      sTPercentage.set((XmlObject)paramSTPercentage);
    } 
  }
  
  public void unsetSy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SY$20);
    } 
  }
  
  public int getKx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KX$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(KX$22); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STFixedAngle xgetKx() {
    synchronized (monitor()) {
      check_orphaned();
      STFixedAngle sTFixedAngle = null;
      sTFixedAngle = (STFixedAngle)get_store().find_attribute_user(KX$22);
      if (sTFixedAngle == null)
        sTFixedAngle = (STFixedAngle)get_default_attribute_value(KX$22); 
      return sTFixedAngle;
    } 
  }
  
  public boolean isSetKx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(KX$22) != null);
    } 
  }
  
  public void setKx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KX$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(KX$22); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetKx(STFixedAngle paramSTFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STFixedAngle sTFixedAngle = null;
      sTFixedAngle = (STFixedAngle)get_store().find_attribute_user(KX$22);
      if (sTFixedAngle == null)
        sTFixedAngle = (STFixedAngle)get_store().add_attribute_user(KX$22); 
      sTFixedAngle.set((XmlObject)paramSTFixedAngle);
    } 
  }
  
  public void unsetKx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(KX$22);
    } 
  }
  
  public int getKy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(KY$24); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STFixedAngle xgetKy() {
    synchronized (monitor()) {
      check_orphaned();
      STFixedAngle sTFixedAngle = null;
      sTFixedAngle = (STFixedAngle)get_store().find_attribute_user(KY$24);
      if (sTFixedAngle == null)
        sTFixedAngle = (STFixedAngle)get_default_attribute_value(KY$24); 
      return sTFixedAngle;
    } 
  }
  
  public boolean isSetKy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(KY$24) != null);
    } 
  }
  
  public void setKy(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(KY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(KY$24); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetKy(STFixedAngle paramSTFixedAngle) {
    synchronized (monitor()) {
      check_orphaned();
      STFixedAngle sTFixedAngle = null;
      sTFixedAngle = (STFixedAngle)get_store().find_attribute_user(KY$24);
      if (sTFixedAngle == null)
        sTFixedAngle = (STFixedAngle)get_store().add_attribute_user(KY$24); 
      sTFixedAngle.set((XmlObject)paramSTFixedAngle);
    } 
  }
  
  public void unsetKy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(KY$24);
    } 
  }
  
  public STRectAlignment.Enum getAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALGN$26); 
      if (simpleValue == null)
        return null; 
      return (STRectAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STRectAlignment xgetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      STRectAlignment sTRectAlignment = null;
      sTRectAlignment = (STRectAlignment)get_store().find_attribute_user(ALGN$26);
      if (sTRectAlignment == null)
        sTRectAlignment = (STRectAlignment)get_default_attribute_value(ALGN$26); 
      return sTRectAlignment;
    } 
  }
  
  public boolean isSetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGN$26) != null);
    } 
  }
  
  public void setAlgn(STRectAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGN$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGN$26); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlgn(STRectAlignment paramSTRectAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STRectAlignment sTRectAlignment = null;
      sTRectAlignment = (STRectAlignment)get_store().find_attribute_user(ALGN$26);
      if (sTRectAlignment == null)
        sTRectAlignment = (STRectAlignment)get_store().add_attribute_user(ALGN$26); 
      sTRectAlignment.set((XmlObject)paramSTRectAlignment);
    } 
  }
  
  public void unsetAlgn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGN$26);
    } 
  }
  
  public boolean getRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTWITHSHAPE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ROTWITHSHAPE$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROTWITHSHAPE$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ROTWITHSHAPE$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROTWITHSHAPE$28) != null);
    } 
  }
  
  public void setRotWithShape(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTWITHSHAPE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROTWITHSHAPE$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRotWithShape(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ROTWITHSHAPE$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ROTWITHSHAPE$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRotWithShape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROTWITHSHAPE$28);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTOuterShadowEffectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */