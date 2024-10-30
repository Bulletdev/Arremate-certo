package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;

public class CTPageMarginsImpl extends XmlComplexContentImpl implements CTPageMargins {
  private static final b LEFT$0 = new b("", "left");
  
  private static final b RIGHT$2 = new b("", "right");
  
  private static final b TOP$4 = new b("", "top");
  
  private static final b BOTTOM$6 = new b("", "bottom");
  
  private static final b HEADER$8 = new b("", "header");
  
  private static final b FOOTER$10 = new b("", "footer");
  
  public CTPageMarginsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public double getLeft() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFT$0);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetLeft() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(LEFT$0);
      return xmlDouble;
    } 
  }
  
  public void setLeft(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEFT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEFT$0); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetLeft(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(LEFT$0);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(LEFT$0); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getRight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHT$2);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetRight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(RIGHT$2);
      return xmlDouble;
    } 
  }
  
  public void setRight(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RIGHT$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RIGHT$2); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetRight(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(RIGHT$2);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(RIGHT$2); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getTop() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOP$4);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetTop() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(TOP$4);
      return xmlDouble;
    } 
  }
  
  public void setTop(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOP$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOP$4); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetTop(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(TOP$4);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(TOP$4); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public double getBottom() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOTTOM$6);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetBottom() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(BOTTOM$6);
      return xmlDouble;
    } 
  }
  
  public void setBottom(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BOTTOM$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BOTTOM$6); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetBottom(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(BOTTOM$6);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(BOTTOM$6); 
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


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPageMarginsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */