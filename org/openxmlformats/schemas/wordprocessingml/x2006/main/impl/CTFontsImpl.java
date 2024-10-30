package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHint;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;

public class CTFontsImpl extends XmlComplexContentImpl implements CTFonts {
  private static final b HINT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hint");
  
  private static final b ASCII$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ascii");
  
  private static final b HANSI$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hAnsi");
  
  private static final b EASTASIA$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsia");
  
  private static final b CS$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs");
  
  private static final b ASCIITHEME$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "asciiTheme");
  
  private static final b HANSITHEME$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hAnsiTheme");
  
  private static final b EASTASIATHEME$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsiaTheme");
  
  private static final b CSTHEME$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cstheme");
  
  public CTFontsImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STHint.Enum getHint() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HINT$0);
      if (simpleValue == null)
        return null; 
      return (STHint.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHint xgetHint() {
    synchronized (monitor()) {
      check_orphaned();
      STHint sTHint = null;
      sTHint = (STHint)get_store().find_attribute_user(HINT$0);
      return sTHint;
    } 
  }
  
  public boolean isSetHint() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HINT$0) != null);
    } 
  }
  
  public void setHint(STHint.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HINT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HINT$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHint(STHint paramSTHint) {
    synchronized (monitor()) {
      check_orphaned();
      STHint sTHint = null;
      sTHint = (STHint)get_store().find_attribute_user(HINT$0);
      if (sTHint == null)
        sTHint = (STHint)get_store().add_attribute_user(HINT$0); 
      sTHint.set((XmlObject)paramSTHint);
    } 
  }
  
  public void unsetHint() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HINT$0);
    } 
  }
  
  public String getAscii() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASCII$2);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetAscii() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(ASCII$2);
      return sTString;
    } 
  }
  
  public boolean isSetAscii() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASCII$2) != null);
    } 
  }
  
  public void setAscii(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASCII$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASCII$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAscii(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(ASCII$2);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(ASCII$2); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetAscii() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASCII$2);
    } 
  }
  
  public String getHAnsi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANSI$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetHAnsi() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(HANSI$4);
      return sTString;
    } 
  }
  
  public boolean isSetHAnsi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HANSI$4) != null);
    } 
  }
  
  public void setHAnsi(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANSI$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HANSI$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHAnsi(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(HANSI$4);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(HANSI$4); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetHAnsi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HANSI$4);
    } 
  }
  
  public String getEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIA$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(EASTASIA$6);
      return sTString;
    } 
  }
  
  public boolean isSetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EASTASIA$6) != null);
    } 
  }
  
  public void setEastAsia(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIA$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EASTASIA$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetEastAsia(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(EASTASIA$6);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(EASTASIA$6); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetEastAsia() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EASTASIA$6);
    } 
  }
  
  public String getCs() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CS$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetCs() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CS$8);
      return sTString;
    } 
  }
  
  public boolean isSetCs() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CS$8) != null);
    } 
  }
  
  public void setCs(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CS$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCs(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CS$8);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(CS$8); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetCs() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CS$8);
    } 
  }
  
  public STTheme.Enum getAsciiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASCIITHEME$10);
      if (simpleValue == null)
        return null; 
      return (STTheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTheme xgetAsciiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(ASCIITHEME$10);
      return sTTheme;
    } 
  }
  
  public boolean isSetAsciiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASCIITHEME$10) != null);
    } 
  }
  
  public void setAsciiTheme(STTheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASCIITHEME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASCIITHEME$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAsciiTheme(STTheme paramSTTheme) {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(ASCIITHEME$10);
      if (sTTheme == null)
        sTTheme = (STTheme)get_store().add_attribute_user(ASCIITHEME$10); 
      sTTheme.set((XmlObject)paramSTTheme);
    } 
  }
  
  public void unsetAsciiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASCIITHEME$10);
    } 
  }
  
  public STTheme.Enum getHAnsiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANSITHEME$12);
      if (simpleValue == null)
        return null; 
      return (STTheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTheme xgetHAnsiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(HANSITHEME$12);
      return sTTheme;
    } 
  }
  
  public boolean isSetHAnsiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HANSITHEME$12) != null);
    } 
  }
  
  public void setHAnsiTheme(STTheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HANSITHEME$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HANSITHEME$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHAnsiTheme(STTheme paramSTTheme) {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(HANSITHEME$12);
      if (sTTheme == null)
        sTTheme = (STTheme)get_store().add_attribute_user(HANSITHEME$12); 
      sTTheme.set((XmlObject)paramSTTheme);
    } 
  }
  
  public void unsetHAnsiTheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HANSITHEME$12);
    } 
  }
  
  public STTheme.Enum getEastAsiaTheme() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIATHEME$14);
      if (simpleValue == null)
        return null; 
      return (STTheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTheme xgetEastAsiaTheme() {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(EASTASIATHEME$14);
      return sTTheme;
    } 
  }
  
  public boolean isSetEastAsiaTheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EASTASIATHEME$14) != null);
    } 
  }
  
  public void setEastAsiaTheme(STTheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EASTASIATHEME$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EASTASIATHEME$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEastAsiaTheme(STTheme paramSTTheme) {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(EASTASIATHEME$14);
      if (sTTheme == null)
        sTTheme = (STTheme)get_store().add_attribute_user(EASTASIATHEME$14); 
      sTTheme.set((XmlObject)paramSTTheme);
    } 
  }
  
  public void unsetEastAsiaTheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EASTASIATHEME$14);
    } 
  }
  
  public STTheme.Enum getCstheme() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CSTHEME$16);
      if (simpleValue == null)
        return null; 
      return (STTheme.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTheme xgetCstheme() {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(CSTHEME$16);
      return sTTheme;
    } 
  }
  
  public boolean isSetCstheme() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CSTHEME$16) != null);
    } 
  }
  
  public void setCstheme(STTheme.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CSTHEME$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CSTHEME$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCstheme(STTheme paramSTTheme) {
    synchronized (monitor()) {
      check_orphaned();
      STTheme sTTheme = null;
      sTTheme = (STTheme)get_store().find_attribute_user(CSTHEME$16);
      if (sTTheme == null)
        sTTheme = (STTheme)get_store().add_attribute_user(CSTHEME$16); 
      sTTheme.set((XmlObject)paramSTTheme);
    } 
  }
  
  public void unsetCstheme() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CSTHEME$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTFontsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */