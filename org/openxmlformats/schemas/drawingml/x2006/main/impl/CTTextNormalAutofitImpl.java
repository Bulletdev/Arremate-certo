package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontScalePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercent;

public class CTTextNormalAutofitImpl extends XmlComplexContentImpl implements CTTextNormalAutofit {
  private static final b FONTSCALE$0 = new b("", "fontScale");
  
  private static final b LNSPCREDUCTION$2 = new b("", "lnSpcReduction");
  
  public CTTextNormalAutofitImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public int getFontScale() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTSCALE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FONTSCALE$0); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextFontScalePercent xgetFontScale() {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontScalePercent sTTextFontScalePercent = null;
      sTTextFontScalePercent = (STTextFontScalePercent)get_store().find_attribute_user(FONTSCALE$0);
      if (sTTextFontScalePercent == null)
        sTTextFontScalePercent = (STTextFontScalePercent)get_default_attribute_value(FONTSCALE$0); 
      return sTTextFontScalePercent;
    } 
  }
  
  public boolean isSetFontScale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FONTSCALE$0) != null);
    } 
  }
  
  public void setFontScale(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FONTSCALE$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FONTSCALE$0); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetFontScale(STTextFontScalePercent paramSTTextFontScalePercent) {
    synchronized (monitor()) {
      check_orphaned();
      STTextFontScalePercent sTTextFontScalePercent = null;
      sTTextFontScalePercent = (STTextFontScalePercent)get_store().find_attribute_user(FONTSCALE$0);
      if (sTTextFontScalePercent == null)
        sTTextFontScalePercent = (STTextFontScalePercent)get_store().add_attribute_user(FONTSCALE$0); 
      sTTextFontScalePercent.set((XmlObject)paramSTTextFontScalePercent);
    } 
  }
  
  public void unsetFontScale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FONTSCALE$0);
    } 
  }
  
  public int getLnSpcReduction() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LNSPCREDUCTION$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LNSPCREDUCTION$2); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STTextSpacingPercent xgetLnSpcReduction() {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPercent sTTextSpacingPercent = null;
      sTTextSpacingPercent = (STTextSpacingPercent)get_store().find_attribute_user(LNSPCREDUCTION$2);
      if (sTTextSpacingPercent == null)
        sTTextSpacingPercent = (STTextSpacingPercent)get_default_attribute_value(LNSPCREDUCTION$2); 
      return sTTextSpacingPercent;
    } 
  }
  
  public boolean isSetLnSpcReduction() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LNSPCREDUCTION$2) != null);
    } 
  }
  
  public void setLnSpcReduction(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LNSPCREDUCTION$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LNSPCREDUCTION$2); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetLnSpcReduction(STTextSpacingPercent paramSTTextSpacingPercent) {
    synchronized (monitor()) {
      check_orphaned();
      STTextSpacingPercent sTTextSpacingPercent = null;
      sTTextSpacingPercent = (STTextSpacingPercent)get_store().find_attribute_user(LNSPCREDUCTION$2);
      if (sTTextSpacingPercent == null)
        sTTextSpacingPercent = (STTextSpacingPercent)get_store().add_attribute_user(LNSPCREDUCTION$2); 
      sTTextSpacingPercent.set((XmlObject)paramSTTextSpacingPercent);
    } 
  }
  
  public void unsetLnSpcReduction() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LNSPCREDUCTION$2);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextNormalAutofitImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */