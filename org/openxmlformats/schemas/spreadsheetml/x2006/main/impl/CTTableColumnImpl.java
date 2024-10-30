package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDxfId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STTotalsRowFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTTableColumnImpl extends XmlComplexContentImpl implements CTTableColumn {
  private static final b CALCULATEDCOLUMNFORMULA$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedColumnFormula");
  
  private static final b TOTALSROWFORMULA$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "totalsRowFormula");
  
  private static final b XMLCOLUMNPR$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "xmlColumnPr");
  
  private static final b EXTLST$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b ID$8 = new b("", "id");
  
  private static final b UNIQUENAME$10 = new b("", "uniqueName");
  
  private static final b NAME$12 = new b("", "name");
  
  private static final b TOTALSROWFUNCTION$14 = new b("", "totalsRowFunction");
  
  private static final b TOTALSROWLABEL$16 = new b("", "totalsRowLabel");
  
  private static final b QUERYTABLEFIELDID$18 = new b("", "queryTableFieldId");
  
  private static final b HEADERROWDXFID$20 = new b("", "headerRowDxfId");
  
  private static final b DATADXFID$22 = new b("", "dataDxfId");
  
  private static final b TOTALSROWDXFID$24 = new b("", "totalsRowDxfId");
  
  private static final b HEADERROWCELLSTYLE$26 = new b("", "headerRowCellStyle");
  
  private static final b DATACELLSTYLE$28 = new b("", "dataCellStyle");
  
  private static final b TOTALSROWCELLSTYLE$30 = new b("", "totalsRowCellStyle");
  
  public CTTableColumnImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTableFormula getCalculatedColumnFormula() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().find_element_user(CALCULATEDCOLUMNFORMULA$0, 0);
      if (cTTableFormula == null)
        return null; 
      return cTTableFormula;
    } 
  }
  
  public boolean isSetCalculatedColumnFormula() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CALCULATEDCOLUMNFORMULA$0) != 0);
    } 
  }
  
  public void setCalculatedColumnFormula(CTTableFormula paramCTTableFormula) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().find_element_user(CALCULATEDCOLUMNFORMULA$0, 0);
      if (cTTableFormula == null)
        cTTableFormula = (CTTableFormula)get_store().add_element_user(CALCULATEDCOLUMNFORMULA$0); 
      cTTableFormula.set((XmlObject)paramCTTableFormula);
    } 
  }
  
  public CTTableFormula addNewCalculatedColumnFormula() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().add_element_user(CALCULATEDCOLUMNFORMULA$0);
      return cTTableFormula;
    } 
  }
  
  public void unsetCalculatedColumnFormula() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALCULATEDCOLUMNFORMULA$0, 0);
    } 
  }
  
  public CTTableFormula getTotalsRowFormula() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().find_element_user(TOTALSROWFORMULA$2, 0);
      if (cTTableFormula == null)
        return null; 
      return cTTableFormula;
    } 
  }
  
  public boolean isSetTotalsRowFormula() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TOTALSROWFORMULA$2) != 0);
    } 
  }
  
  public void setTotalsRowFormula(CTTableFormula paramCTTableFormula) {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().find_element_user(TOTALSROWFORMULA$2, 0);
      if (cTTableFormula == null)
        cTTableFormula = (CTTableFormula)get_store().add_element_user(TOTALSROWFORMULA$2); 
      cTTableFormula.set((XmlObject)paramCTTableFormula);
    } 
  }
  
  public CTTableFormula addNewTotalsRowFormula() {
    synchronized (monitor()) {
      check_orphaned();
      CTTableFormula cTTableFormula = null;
      cTTableFormula = (CTTableFormula)get_store().add_element_user(TOTALSROWFORMULA$2);
      return cTTableFormula;
    } 
  }
  
  public void unsetTotalsRowFormula() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TOTALSROWFORMULA$2, 0);
    } 
  }
  
  public CTXmlColumnPr getXmlColumnPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlColumnPr cTXmlColumnPr = null;
      cTXmlColumnPr = (CTXmlColumnPr)get_store().find_element_user(XMLCOLUMNPR$4, 0);
      if (cTXmlColumnPr == null)
        return null; 
      return cTXmlColumnPr;
    } 
  }
  
  public boolean isSetXmlColumnPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(XMLCOLUMNPR$4) != 0);
    } 
  }
  
  public void setXmlColumnPr(CTXmlColumnPr paramCTXmlColumnPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlColumnPr cTXmlColumnPr = null;
      cTXmlColumnPr = (CTXmlColumnPr)get_store().find_element_user(XMLCOLUMNPR$4, 0);
      if (cTXmlColumnPr == null)
        cTXmlColumnPr = (CTXmlColumnPr)get_store().add_element_user(XMLCOLUMNPR$4); 
      cTXmlColumnPr.set((XmlObject)paramCTXmlColumnPr);
    } 
  }
  
  public CTXmlColumnPr addNewXmlColumnPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTXmlColumnPr cTXmlColumnPr = null;
      cTXmlColumnPr = (CTXmlColumnPr)get_store().add_element_user(XMLCOLUMNPR$4);
      return cTXmlColumnPr;
    } 
  }
  
  public void unsetXmlColumnPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(XMLCOLUMNPR$4, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$6) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$6, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$6);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$6, 0);
    } 
  }
  
  public long getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$8);
      return xmlUnsignedInt;
    } 
  }
  
  public void setId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUENAME$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUENAME$10);
      return sTXstring;
    } 
  }
  
  public boolean isSetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUENAME$10) != null);
    } 
  }
  
  public void setUniqueName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUENAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUENAME$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(UNIQUENAME$10);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(UNIQUENAME$10); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetUniqueName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUENAME$10);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$12);
      return sTXstring;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(NAME$12);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(NAME$12); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public STTotalsRowFunction.Enum getTotalsRowFunction() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWFUNCTION$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TOTALSROWFUNCTION$14); 
      if (simpleValue == null)
        return null; 
      return (STTotalsRowFunction.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTotalsRowFunction xgetTotalsRowFunction() {
    synchronized (monitor()) {
      check_orphaned();
      STTotalsRowFunction sTTotalsRowFunction = null;
      sTTotalsRowFunction = (STTotalsRowFunction)get_store().find_attribute_user(TOTALSROWFUNCTION$14);
      if (sTTotalsRowFunction == null)
        sTTotalsRowFunction = (STTotalsRowFunction)get_default_attribute_value(TOTALSROWFUNCTION$14); 
      return sTTotalsRowFunction;
    } 
  }
  
  public boolean isSetTotalsRowFunction() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWFUNCTION$14) != null);
    } 
  }
  
  public void setTotalsRowFunction(STTotalsRowFunction.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWFUNCTION$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWFUNCTION$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetTotalsRowFunction(STTotalsRowFunction paramSTTotalsRowFunction) {
    synchronized (monitor()) {
      check_orphaned();
      STTotalsRowFunction sTTotalsRowFunction = null;
      sTTotalsRowFunction = (STTotalsRowFunction)get_store().find_attribute_user(TOTALSROWFUNCTION$14);
      if (sTTotalsRowFunction == null)
        sTTotalsRowFunction = (STTotalsRowFunction)get_store().add_attribute_user(TOTALSROWFUNCTION$14); 
      sTTotalsRowFunction.set((XmlObject)paramSTTotalsRowFunction);
    } 
  }
  
  public void unsetTotalsRowFunction() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWFUNCTION$14);
    } 
  }
  
  public String getTotalsRowLabel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWLABEL$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetTotalsRowLabel() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWLABEL$16);
      return sTXstring;
    } 
  }
  
  public boolean isSetTotalsRowLabel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWLABEL$16) != null);
    } 
  }
  
  public void setTotalsRowLabel(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWLABEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWLABEL$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTotalsRowLabel(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWLABEL$16);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(TOTALSROWLABEL$16); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetTotalsRowLabel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWLABEL$16);
    } 
  }
  
  public long getQueryTableFieldId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QUERYTABLEFIELDID$18);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetQueryTableFieldId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(QUERYTABLEFIELDID$18);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetQueryTableFieldId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(QUERYTABLEFIELDID$18) != null);
    } 
  }
  
  public void setQueryTableFieldId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(QUERYTABLEFIELDID$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(QUERYTABLEFIELDID$18); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetQueryTableFieldId(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(QUERYTABLEFIELDID$18);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(QUERYTABLEFIELDID$18); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetQueryTableFieldId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(QUERYTABLEFIELDID$18);
    } 
  }
  
  public long getHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWDXFID$20);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWDXFID$20);
      return sTDxfId;
    } 
  }
  
  public boolean isSetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWDXFID$20) != null);
    } 
  }
  
  public void setHeaderRowDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWDXFID$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWDXFID$20); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetHeaderRowDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(HEADERROWDXFID$20);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(HEADERROWDXFID$20); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetHeaderRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWDXFID$20);
    } 
  }
  
  public long getDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATADXFID$22);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DATADXFID$22);
      return sTDxfId;
    } 
  }
  
  public boolean isSetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATADXFID$22) != null);
    } 
  }
  
  public void setDataDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATADXFID$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATADXFID$22); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDataDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(DATADXFID$22);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(DATADXFID$22); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetDataDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATADXFID$22);
    } 
  }
  
  public long getTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWDXFID$24);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public STDxfId xgetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWDXFID$24);
      return sTDxfId;
    } 
  }
  
  public boolean isSetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWDXFID$24) != null);
    } 
  }
  
  public void setTotalsRowDxfId(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWDXFID$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWDXFID$24); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTotalsRowDxfId(STDxfId paramSTDxfId) {
    synchronized (monitor()) {
      check_orphaned();
      STDxfId sTDxfId = null;
      sTDxfId = (STDxfId)get_store().find_attribute_user(TOTALSROWDXFID$24);
      if (sTDxfId == null)
        sTDxfId = (STDxfId)get_store().add_attribute_user(TOTALSROWDXFID$24); 
      sTDxfId.set((XmlObject)paramSTDxfId);
    } 
  }
  
  public void unsetTotalsRowDxfId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWDXFID$24);
    } 
  }
  
  public String getHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
      return sTXstring;
    } 
  }
  
  public boolean isSetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HEADERROWCELLSTYLE$26) != null);
    } 
  }
  
  public void setHeaderRowCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HEADERROWCELLSTYLE$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetHeaderRowCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(HEADERROWCELLSTYLE$26);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(HEADERROWCELLSTYLE$26); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetHeaderRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HEADERROWCELLSTYLE$26);
    } 
  }
  
  public String getDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACELLSTYLE$28);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACELLSTYLE$28);
      return sTXstring;
    } 
  }
  
  public boolean isSetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATACELLSTYLE$28) != null);
    } 
  }
  
  public void setDataCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATACELLSTYLE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATACELLSTYLE$28); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDataCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(DATACELLSTYLE$28);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(DATACELLSTYLE$28); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetDataCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATACELLSTYLE$28);
    } 
  }
  
  public String getTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
      return sTXstring;
    } 
  }
  
  public boolean isSetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOTALSROWCELLSTYLE$30) != null);
    } 
  }
  
  public void setTotalsRowCellStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOTALSROWCELLSTYLE$30); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTotalsRowCellStyle(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(TOTALSROWCELLSTYLE$30);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(TOTALSROWCELLSTYLE$30); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetTotalsRowCellStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOTALSROWCELLSTYLE$30);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTTableColumnImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */