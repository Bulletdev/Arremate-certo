package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;

public class CTPageMarginsImpl extends XmlComplexContentImpl implements CTPageMargins {
  private static final b L$0 = new b("", "l");
  
  private static final b R$2 = new b("", "r");
  
  private static final b T$4 = new b("", "t");
  
  private static final b B$6 = new b("", "b");
  
  private static final b HEADER$8 = new b("", "header");
  
  private static final b FOOTER$10 = new b("", "footer");
  
  public CTPageMarginsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public double getL() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetL() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(L$0);
      return xmlDouble;
    } 
  }
  
  public void setL(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(L$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(L$0); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetL(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(L$0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(L$0); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$2);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(R$2);
      return xmlDouble;
    } 
  }
  
  public void setR(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$2); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetR(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(R$2);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(R$2); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$4);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(T$4);
      return xmlDouble;
    } 
  }
  
  public void setT(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$4); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetT(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(T$4);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(T$4); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getB() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetB() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(B$6);
      return xmlDouble;
    } 
  }
  
  public void setB(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(B$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(B$6); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetB(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(B$6);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(B$6); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getHeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADER$8);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetHeader() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(HEADER$8);
      return xmlDouble;
    } 
  }
  
  public void setHeader(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADER$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADER$8); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetHeader(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(HEADER$8);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(HEADER$8); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getFooter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOOTER$10);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetFooter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(FOOTER$10);
      return xmlDouble;
    } 
  }
  
  public void setFooter(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FOOTER$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FOOTER$10); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetFooter(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(FOOTER$10);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(FOOTER$10); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\impl\CTPageMarginsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */