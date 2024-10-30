package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTItemImpl extends XmlComplexContentImpl implements CTItem {
  private static final b N$0 = new b("", "n");
  
  private static final b T$2 = new b("", "t");
  
  private static final b H$4 = new b("", "h");
  
  private static final b S$6 = new b("", "s");
  
  private static final b SD$8 = new b("", "sd");
  
  private static final b F$10 = new b("", "f");
  
  private static final b M$12 = new b("", "m");
  
  private static final b C$14 = new b("", "c");
  
  private static final b X$16 = new b("", "x");
  
  private static final b D$18 = new b("", "d");
  
  private static final b E$20 = new b("", "e");
  
  public CTItemImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getN() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetN() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(N$0);
      return sTXstring;
    } 
  }
  
  public boolean isSetN() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(N$0) != null);
    } 
  }
  
  public void setN(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(N$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(N$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetN(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(N$0);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(N$0); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetN() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(N$0);
    } 
  }
  
  public STItemType.Enum getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(T$2); 
      if (simpleValue == null)
        return null; 
      return (STItemType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STItemType xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STItemType sTItemType = null;
      sTItemType = (STItemType)get_store().find_attribute_user(T$2);
      if (sTItemType == null)
        sTItemType = (STItemType)get_default_attribute_value(T$2); 
      return sTItemType;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(T$2) != null);
    } 
  }
  
  public void setT(STItemType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetT(STItemType paramSTItemType) {
    synchronized (monitor()) {
      check_orphaned();
      STItemType sTItemType = null;
      sTItemType = (STItemType)get_store().find_attribute_user(T$2);
      if (sTItemType == null)
        sTItemType = (STItemType)get_store().add_attribute_user(T$2); 
      sTItemType.set((XmlObject)paramSTItemType);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(T$2);
    } 
  }
  
  public boolean getH() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(H$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetH() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(H$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(H$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetH() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(H$4) != null);
    } 
  }
  
  public void setH(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(H$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(H$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetH(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(H$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(H$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(H$4);
    } 
  }
  
  public boolean getS() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(S$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetS() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(S$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(S$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetS() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(S$6) != null);
    } 
  }
  
  public void setS(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(S$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetS(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(S$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(S$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetS() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(S$6);
    } 
  }
  
  public boolean getSd() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SD$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SD$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSd() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SD$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SD$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSd() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SD$8) != null);
    } 
  }
  
  public void setSd(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SD$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SD$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSd(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SD$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SD$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSd() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SD$8);
    } 
  }
  
  public boolean getF() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(F$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(F$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetF() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(F$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(F$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetF() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(F$10) != null);
    } 
  }
  
  public void setF(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(F$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(F$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetF(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(F$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(F$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(F$10);
    } 
  }
  
  public boolean getM() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(M$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(M$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetM() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(M$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(M$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetM() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(M$12) != null);
    } 
  }
  
  public void setM(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(M$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(M$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetM(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(M$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(M$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetM() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(M$12);
    } 
  }
  
  public boolean getC() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(C$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(C$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetC() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(C$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(C$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetC() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(C$14) != null);
    } 
  }
  
  public void setC(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(C$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(C$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetC(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(C$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(C$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetC() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(C$14);
    } 
  }
  
  public long getX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$16);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetX() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(X$16);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetX() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(X$16) != null);
    } 
  }
  
  public void setX(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(X$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(X$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetX(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(X$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(X$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetX() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(X$16);
    } 
  }
  
  public boolean getD() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(D$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(D$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetD() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(D$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(D$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetD() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(D$18) != null);
    } 
  }
  
  public void setD(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(D$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(D$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetD(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(D$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(D$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetD() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(D$18);
    } 
  }
  
  public boolean getE() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(E$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(E$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetE() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(E$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(E$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetE() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(E$20) != null);
    } 
  }
  
  public void setE(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(E$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(E$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetE(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(E$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(E$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetE() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(E$20);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTItemImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */