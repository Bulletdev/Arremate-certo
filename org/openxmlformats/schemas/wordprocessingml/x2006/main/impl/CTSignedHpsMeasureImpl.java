package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedHpsMeasure;

public class CTSignedHpsMeasureImpl extends XmlComplexContentImpl implements CTSignedHpsMeasure {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTSignedHpsMeasureImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public BigInteger getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STSignedHpsMeasure xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STSignedHpsMeasure sTSignedHpsMeasure = null;
      sTSignedHpsMeasure = (STSignedHpsMeasure)get_store().find_attribute_user(VAL$0);
      return sTSignedHpsMeasure;
    } 
  }
  
  public void setVal(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetVal(STSignedHpsMeasure paramSTSignedHpsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STSignedHpsMeasure sTSignedHpsMeasure = null;
      sTSignedHpsMeasure = (STSignedHpsMeasure)get_store().find_attribute_user(VAL$0);
      if (sTSignedHpsMeasure == null)
        sTSignedHpsMeasure = (STSignedHpsMeasure)get_store().add_attribute_user(VAL$0); 
      sTSignedHpsMeasure.set((XmlObject)paramSTSignedHpsMeasure);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTSignedHpsMeasureImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */