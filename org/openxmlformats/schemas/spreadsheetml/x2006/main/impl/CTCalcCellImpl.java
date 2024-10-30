package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;

public class CTCalcCellImpl extends XmlComplexContentImpl implements CTCalcCell {
  private static final b R$0 = new b("", "r");
  
  private static final b I$2 = new b("", "i");
  
  private static final b S$4 = new b("", "s");
  
  private static final b L$6 = new b("", "l");
  
  private static final b T$8 = new b("", "t");
  
  private static final b A$10 = new b("", "a");
  
  public CTCalcCellImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$0);
      return sTCellRef;
    } 
  }
  
  public void setR(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetR(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R$0);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(R$0); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public int getI() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(I$2); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetI() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(I$2);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_default_attribute_value(I$2); 
      return xmlInt;
    } 
  }
  
  public boolean isSetI() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(I$2) != null);
    } 
  }
  
  public void setI(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(I$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(I$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetI(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(I$2);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(I$2); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(I$2);
    } 
  }
  
  public boolean getS() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(S$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetS() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(S$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(S$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetS() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(S$4) != null);
    } 
  }
  
  public void setS(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(S$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetS(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(S$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(S$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetS() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(S$4);
    } 
  }
  
  public boolean getL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(L$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetL() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(L$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(L$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetL() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(L$6) != null);
    } 
  }
  
  public void setL(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(L$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetL(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(L$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(L$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetL() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(L$6);
    } 
  }
  
  public boolean getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(T$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(T$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(T$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(T$8) != null);
    } 
  }
  
  public void setT(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetT(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(T$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(T$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(T$8);
    } 
  }
  
  public boolean getA() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(A$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(A$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetA() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(A$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(A$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetA() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(A$10) != null);
    } 
  }
  
  public void setA(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(A$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(A$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetA(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(A$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(A$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetA() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(A$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCalcCellImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */