package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

public class CTTblGridColImpl extends XmlComplexContentImpl implements CTTblGridCol {
  private static final b W$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
  
  public CTTblGridColImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getW() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STTwipsMeasure xgetW() {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(W$0);
      return sTTwipsMeasure;
    } 
  }
  
  public boolean isSetW() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(W$0) != null);
    } 
  }
  
  public void setW(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(W$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(W$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetW(STTwipsMeasure paramSTTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STTwipsMeasure sTTwipsMeasure = null;
      sTTwipsMeasure = (STTwipsMeasure)get_store().find_attribute_user(W$0);
      if (sTTwipsMeasure == null)
        sTTwipsMeasure = (STTwipsMeasure)get_store().add_attribute_user(W$0); 
      sTTwipsMeasure.set((XmlObject)paramSTTwipsMeasure);
    } 
  }
  
  public void unsetW() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(W$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTblGridColImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */