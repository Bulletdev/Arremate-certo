package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;

public class CTPaneImpl extends XmlComplexContentImpl implements CTPane {
  private static final b XSPLIT$0 = new b("", "xSplit");
  
  private static final b YSPLIT$2 = new b("", "ySplit");
  
  private static final b TOPLEFTCELL$4 = new b("", "topLeftCell");
  
  private static final b ACTIVEPANE$6 = new b("", "activePane");
  
  private static final b STATE$8 = new b("", "state");
  
  public CTPaneImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public double getXSplit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XSPLIT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(XSPLIT$0); 
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetXSplit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(XSPLIT$0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_default_attribute_value(XSPLIT$0); 
      return xmlDouble;
    } 
  }
  
  public boolean isSetXSplit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(XSPLIT$0) != null);
    } 
  }
  
  public void setXSplit(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(XSPLIT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(XSPLIT$0); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetXSplit(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(XSPLIT$0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(XSPLIT$0); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetXSplit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(XSPLIT$0);
    } 
  }
  
  public double getYSplit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YSPLIT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(YSPLIT$2); 
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetYSplit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(YSPLIT$2);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_default_attribute_value(YSPLIT$2); 
      return xmlDouble;
    } 
  }
  
  public boolean isSetYSplit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(YSPLIT$2) != null);
    } 
  }
  
  public void setYSplit(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(YSPLIT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(YSPLIT$2); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetYSplit(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(YSPLIT$2);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(YSPLIT$2); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetYSplit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(YSPLIT$2);
    } 
  }
  
  public String getTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPLEFTCELL$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(TOPLEFTCELL$4);
      return sTCellRef;
    } 
  }
  
  public boolean isSetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOPLEFTCELL$4) != null);
    } 
  }
  
  public void setTopLeftCell(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPLEFTCELL$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOPLEFTCELL$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTopLeftCell(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(TOPLEFTCELL$4);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(TOPLEFTCELL$4); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetTopLeftCell() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOPLEFTCELL$4);
    } 
  }
  
  public STPane.Enum getActivePane() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVEPANE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ACTIVEPANE$6); 
      if (simpleValue == null)
        return null; 
      return (STPane.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPane xgetActivePane() {
    synchronized (monitor()) {
      check_orphaned();
      STPane sTPane = null;
      sTPane = (STPane)get_store().find_attribute_user(ACTIVEPANE$6);
      if (sTPane == null)
        sTPane = (STPane)get_default_attribute_value(ACTIVEPANE$6); 
      return sTPane;
    } 
  }
  
  public boolean isSetActivePane() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACTIVEPANE$6) != null);
    } 
  }
  
  public void setActivePane(STPane.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACTIVEPANE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACTIVEPANE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetActivePane(STPane paramSTPane) {
    synchronized (monitor()) {
      check_orphaned();
      STPane sTPane = null;
      sTPane = (STPane)get_store().find_attribute_user(ACTIVEPANE$6);
      if (sTPane == null)
        sTPane = (STPane)get_store().add_attribute_user(ACTIVEPANE$6); 
      sTPane.set((XmlObject)paramSTPane);
    } 
  }
  
  public void unsetActivePane() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACTIVEPANE$6);
    } 
  }
  
  public STPaneState.Enum getState() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(STATE$8); 
      if (simpleValue == null)
        return null; 
      return (STPaneState.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPaneState xgetState() {
    synchronized (monitor()) {
      check_orphaned();
      STPaneState sTPaneState = null;
      sTPaneState = (STPaneState)get_store().find_attribute_user(STATE$8);
      if (sTPaneState == null)
        sTPaneState = (STPaneState)get_default_attribute_value(STATE$8); 
      return sTPaneState;
    } 
  }
  
  public boolean isSetState() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STATE$8) != null);
    } 
  }
  
  public void setState(STPaneState.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STATE$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STATE$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetState(STPaneState paramSTPaneState) {
    synchronized (monitor()) {
      check_orphaned();
      STPaneState sTPaneState = null;
      sTPaneState = (STPaneState)get_store().find_attribute_user(STATE$8);
      if (sTPaneState == null)
        sTPaneState = (STPaneState)get_store().add_attribute_user(STATE$8); 
      sTPaneState.set((XmlObject)paramSTPaneState);
    } 
  }
  
  public void unsetState() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STATE$8);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPaneImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */