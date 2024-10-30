package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSqref;

public class CTIgnoredErrorImpl extends XmlComplexContentImpl implements CTIgnoredError {
  private static final b SQREF$0 = new b("", "sqref");
  
  private static final b EVALERROR$2 = new b("", "evalError");
  
  private static final b TWODIGITTEXTYEAR$4 = new b("", "twoDigitTextYear");
  
  private static final b NUMBERSTOREDASTEXT$6 = new b("", "numberStoredAsText");
  
  private static final b FORMULA$8 = new b("", "formula");
  
  private static final b FORMULARANGE$10 = new b("", "formulaRange");
  
  private static final b UNLOCKEDFORMULA$12 = new b("", "unlockedFormula");
  
  private static final b EMPTYCELLREFERENCE$14 = new b("", "emptyCellReference");
  
  private static final b LISTDATAVALIDATION$16 = new b("", "listDataValidation");
  
  private static final b CALCULATEDCOLUMN$18 = new b("", "calculatedColumn");
  
  public CTIgnoredErrorImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List getSqref() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getListValue();
    } 
  }
  
  public STSqref xgetSqref() {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$0);
      return sTSqref;
    } 
  }
  
  public void setSqref(List paramList) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SQREF$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SQREF$0); 
      simpleValue.setListValue(paramList);
    } 
  }
  
  public void xsetSqref(STSqref paramSTSqref) {
    synchronized (monitor()) {
      check_orphaned();
      STSqref sTSqref = null;
      sTSqref = (STSqref)get_store().find_attribute_user(SQREF$0);
      if (sTSqref == null)
        sTSqref = (STSqref)get_store().add_attribute_user(SQREF$0); 
      sTSqref.set((XmlObject)paramSTSqref);
    } 
  }
  
  public boolean getEvalError() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EVALERROR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EVALERROR$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEvalError() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EVALERROR$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EVALERROR$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEvalError() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EVALERROR$2) != null);
    } 
  }
  
  public void setEvalError(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EVALERROR$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EVALERROR$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEvalError(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EVALERROR$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EVALERROR$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEvalError() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EVALERROR$2);
    } 
  }
  
  public boolean getTwoDigitTextYear() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TWODIGITTEXTYEAR$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TWODIGITTEXTYEAR$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTwoDigitTextYear() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TWODIGITTEXTYEAR$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TWODIGITTEXTYEAR$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTwoDigitTextYear() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TWODIGITTEXTYEAR$4) != null);
    } 
  }
  
  public void setTwoDigitTextYear(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TWODIGITTEXTYEAR$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TWODIGITTEXTYEAR$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTwoDigitTextYear(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TWODIGITTEXTYEAR$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TWODIGITTEXTYEAR$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTwoDigitTextYear() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TWODIGITTEXTYEAR$4);
    } 
  }
  
  public boolean getNumberStoredAsText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMBERSTOREDASTEXT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(NUMBERSTOREDASTEXT$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetNumberStoredAsText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NUMBERSTOREDASTEXT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(NUMBERSTOREDASTEXT$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetNumberStoredAsText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NUMBERSTOREDASTEXT$6) != null);
    } 
  }
  
  public void setNumberStoredAsText(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NUMBERSTOREDASTEXT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NUMBERSTOREDASTEXT$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetNumberStoredAsText(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NUMBERSTOREDASTEXT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NUMBERSTOREDASTEXT$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetNumberStoredAsText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NUMBERSTOREDASTEXT$6);
    } 
  }
  
  public boolean getFormula() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULA$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FORMULA$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMULA$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FORMULA$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMULA$8) != null);
    } 
  }
  
  public void setFormula(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULA$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMULA$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFormula(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMULA$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORMULA$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFormula() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMULA$8);
    } 
  }
  
  public boolean getFormulaRange() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULARANGE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FORMULARANGE$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFormulaRange() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMULARANGE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FORMULARANGE$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFormulaRange() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMULARANGE$10) != null);
    } 
  }
  
  public void setFormulaRange(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMULARANGE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMULARANGE$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFormulaRange(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FORMULARANGE$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FORMULARANGE$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFormulaRange() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMULARANGE$10);
    } 
  }
  
  public boolean getUnlockedFormula() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNLOCKEDFORMULA$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UNLOCKEDFORMULA$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUnlockedFormula() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UNLOCKEDFORMULA$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(UNLOCKEDFORMULA$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUnlockedFormula() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNLOCKEDFORMULA$12) != null);
    } 
  }
  
  public void setUnlockedFormula(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNLOCKEDFORMULA$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNLOCKEDFORMULA$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUnlockedFormula(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UNLOCKEDFORMULA$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(UNLOCKEDFORMULA$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUnlockedFormula() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNLOCKEDFORMULA$12);
    } 
  }
  
  public boolean getEmptyCellReference() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMPTYCELLREFERENCE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(EMPTYCELLREFERENCE$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEmptyCellReference() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EMPTYCELLREFERENCE$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(EMPTYCELLREFERENCE$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEmptyCellReference() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EMPTYCELLREFERENCE$14) != null);
    } 
  }
  
  public void setEmptyCellReference(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EMPTYCELLREFERENCE$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EMPTYCELLREFERENCE$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEmptyCellReference(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(EMPTYCELLREFERENCE$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(EMPTYCELLREFERENCE$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEmptyCellReference() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EMPTYCELLREFERENCE$14);
    } 
  }
  
  public boolean getListDataValidation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LISTDATAVALIDATION$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(LISTDATAVALIDATION$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetListDataValidation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LISTDATAVALIDATION$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(LISTDATAVALIDATION$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetListDataValidation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LISTDATAVALIDATION$16) != null);
    } 
  }
  
  public void setListDataValidation(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LISTDATAVALIDATION$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LISTDATAVALIDATION$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetListDataValidation(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(LISTDATAVALIDATION$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(LISTDATAVALIDATION$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetListDataValidation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LISTDATAVALIDATION$16);
    } 
  }
  
  public boolean getCalculatedColumn() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCULATEDCOLUMN$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CALCULATEDCOLUMN$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCalculatedColumn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCULATEDCOLUMN$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CALCULATEDCOLUMN$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCalculatedColumn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CALCULATEDCOLUMN$18) != null);
    } 
  }
  
  public void setCalculatedColumn(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CALCULATEDCOLUMN$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CALCULATEDCOLUMN$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCalculatedColumn(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CALCULATEDCOLUMN$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CALCULATEDCOLUMN$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCalculatedColumn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CALCULATEDCOLUMN$18);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTIgnoredErrorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */