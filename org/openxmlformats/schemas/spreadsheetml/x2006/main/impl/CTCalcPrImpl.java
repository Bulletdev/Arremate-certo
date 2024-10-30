package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRefMode;

public class CTCalcPrImpl extends XmlComplexContentImpl implements CTCalcPr {
  private static final b CALCID$0 = new b("", "calcId");
  
  private static final b CALCMODE$2 = new b("", "calcMode");
  
  private static final b FULLCALCONLOAD$4 = new b("", "fullCalcOnLoad");
  
  private static final b REFMODE$6 = new b("", "refMode");
  
  private static final b ITERATE$8 = new b("", "iterate");
  
  private static final b ITERATECOUNT$10 = new b("", "iterateCount");
  
  private static final b ITERATEDELTA$12 = new b("", "iterateDelta");
  
  private static final b FULLPRECISION$14 = new b("", "fullPrecision");
  
  private static final b CALCCOMPLETED$16 = new b("", "calcCompleted");
  
  private static final b CALCONSAVE$18 = new b("", "calcOnSave");
  
  private static final b CONCURRENTCALC$20 = new b("", "concurrentCalc");
  
  private static final b CONCURRENTMANUALCOUNT$22 = new b("", "concurrentManualCount");
  
  private static final b FORCEFULLCALC$24 = new b("", "forceFullCalc");
  
  public CTCalcPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public long getCalcId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCID$0);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetCalcId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CALCID$0);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetCalcId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CALCID$0) != null);
    } 
  }
  
  public void setCalcId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCID$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CALCID$0); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetCalcId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CALCID$0);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CALCID$0); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetCalcId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CALCID$0);
    } 
  }
  
  public STCalcMode.Enum getCalcMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCMODE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CALCMODE$2); 
      if (simpleValue == null)
        return null; 
      return (STCalcMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCalcMode xgetCalcMode() {
    synchronized (monitor()) {
      check_orphaned();
      STCalcMode sTCalcMode = null;
      sTCalcMode = (STCalcMode)get_store().find_attribute_user(CALCMODE$2);
      if (sTCalcMode == null)
        sTCalcMode = (STCalcMode)get_default_attribute_value(CALCMODE$2); 
      return sTCalcMode;
    } 
  }
  
  public boolean isSetCalcMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CALCMODE$2) != null);
    } 
  }
  
  public void setCalcMode(STCalcMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCMODE$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CALCMODE$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCalcMode(STCalcMode paramSTCalcMode) {
    synchronized (monitor()) {
      check_orphaned();
      STCalcMode sTCalcMode = null;
      sTCalcMode = (STCalcMode)get_store().find_attribute_user(CALCMODE$2);
      if (sTCalcMode == null)
        sTCalcMode = (STCalcMode)get_store().add_attribute_user(CALCMODE$2); 
      sTCalcMode.set((XmlObject)paramSTCalcMode);
    } 
  }
  
  public void unsetCalcMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CALCMODE$2);
    } 
  }
  
  public boolean getFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLCALCONLOAD$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FULLCALCONLOAD$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLCALCONLOAD$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FULLCALCONLOAD$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FULLCALCONLOAD$4) != null);
    } 
  }
  
  public void setFullCalcOnLoad(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLCALCONLOAD$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FULLCALCONLOAD$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFullCalcOnLoad(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLCALCONLOAD$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FULLCALCONLOAD$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFullCalcOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FULLCALCONLOAD$4);
    } 
  }
  
  public STRefMode.Enum getRefMode() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFMODE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REFMODE$6); 
      if (simpleValue == null)
        return null; 
      return (STRefMode.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STRefMode xgetRefMode() {
    synchronized (monitor()) {
      check_orphaned();
      STRefMode sTRefMode = null;
      sTRefMode = (STRefMode)get_store().find_attribute_user(REFMODE$6);
      if (sTRefMode == null)
        sTRefMode = (STRefMode)get_default_attribute_value(REFMODE$6); 
      return sTRefMode;
    } 
  }
  
  public boolean isSetRefMode() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFMODE$6) != null);
    } 
  }
  
  public void setRefMode(STRefMode.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFMODE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFMODE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRefMode(STRefMode paramSTRefMode) {
    synchronized (monitor()) {
      check_orphaned();
      STRefMode sTRefMode = null;
      sTRefMode = (STRefMode)get_store().find_attribute_user(REFMODE$6);
      if (sTRefMode == null)
        sTRefMode = (STRefMode)get_store().add_attribute_user(REFMODE$6); 
      sTRefMode.set((XmlObject)paramSTRefMode);
    } 
  }
  
  public void unsetRefMode() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFMODE$6);
    } 
  }
  
  public boolean getIterate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ITERATE$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIterate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ITERATE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ITERATE$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIterate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ITERATE$8) != null);
    } 
  }
  
  public void setIterate(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ITERATE$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIterate(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ITERATE$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ITERATE$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIterate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ITERATE$8);
    } 
  }
  
  public long getIterateCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATECOUNT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ITERATECOUNT$10); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIterateCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ITERATECOUNT$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(ITERATECOUNT$10); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIterateCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ITERATECOUNT$10) != null);
    } 
  }
  
  public void setIterateCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATECOUNT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ITERATECOUNT$10); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIterateCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ITERATECOUNT$10);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ITERATECOUNT$10); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIterateCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ITERATECOUNT$10);
    } 
  }
  
  public double getIterateDelta() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATEDELTA$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ITERATEDELTA$12); 
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetIterateDelta() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(ITERATEDELTA$12);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_default_attribute_value(ITERATEDELTA$12); 
      return xmlDouble;
    } 
  }
  
  public boolean isSetIterateDelta() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ITERATEDELTA$12) != null);
    } 
  }
  
  public void setIterateDelta(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ITERATEDELTA$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ITERATEDELTA$12); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetIterateDelta(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(ITERATEDELTA$12);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(ITERATEDELTA$12); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetIterateDelta() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ITERATEDELTA$12);
    } 
  }
  
  public boolean getFullPrecision() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLPRECISION$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FULLPRECISION$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFullPrecision() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLPRECISION$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FULLPRECISION$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFullPrecision() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FULLPRECISION$14) != null);
    } 
  }
  
  public void setFullPrecision(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FULLPRECISION$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FULLPRECISION$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFullPrecision(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FULLPRECISION$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FULLPRECISION$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFullPrecision() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FULLPRECISION$14);
    } 
  }
  
  public boolean getCalcCompleted() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCCOMPLETED$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CALCCOMPLETED$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCalcCompleted() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCCOMPLETED$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CALCCOMPLETED$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCalcCompleted() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CALCCOMPLETED$16) != null);
    } 
  }
  
  public void setCalcCompleted(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCCOMPLETED$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CALCCOMPLETED$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCalcCompleted(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCCOMPLETED$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CALCCOMPLETED$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCalcCompleted() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CALCCOMPLETED$16);
    } 
  }
  
  public boolean getCalcOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCONSAVE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CALCONSAVE$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCalcOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCONSAVE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CALCONSAVE$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCalcOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CALCONSAVE$18) != null);
    } 
  }
  
  public void setCalcOnSave(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCONSAVE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CALCONSAVE$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCalcOnSave(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCONSAVE$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CALCONSAVE$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCalcOnSave() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CALCONSAVE$18);
    } 
  }
  
  public boolean getConcurrentCalc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONCURRENTCALC$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CONCURRENTCALC$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetConcurrentCalc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONCURRENTCALC$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CONCURRENTCALC$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetConcurrentCalc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONCURRENTCALC$20) != null);
    } 
  }
  
  public void setConcurrentCalc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONCURRENTCALC$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONCURRENTCALC$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetConcurrentCalc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CONCURRENTCALC$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CONCURRENTCALC$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetConcurrentCalc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONCURRENTCALC$20);
    } 
  }
  
  public long getConcurrentManualCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONCURRENTMANUALCOUNT$22);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetConcurrentManualCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONCURRENTMANUALCOUNT$22);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetConcurrentManualCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CONCURRENTMANUALCOUNT$22) != null);
    } 
  }
  
  public void setConcurrentManualCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CONCURRENTMANUALCOUNT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CONCURRENTMANUALCOUNT$22); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetConcurrentManualCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(CONCURRENTMANUALCOUNT$22);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(CONCURRENTMANUALCOUNT$22); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetConcurrentManualCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CONCURRENTMANUALCOUNT$22);
    } 
  }
  
  public boolean getForceFullCalc() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEFULLCALC$24);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetForceFullCalc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORCEFULLCALC$24);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetForceFullCalc() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORCEFULLCALC$24) != null);
    } 
  }
  
  public void setForceFullCalc(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORCEFULLCALC$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORCEFULLCALC$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetForceFullCalc(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORCEFULLCALC$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORCEFULLCALC$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetForceFullCalc() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORCEFULLCALC$24);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCalcPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */