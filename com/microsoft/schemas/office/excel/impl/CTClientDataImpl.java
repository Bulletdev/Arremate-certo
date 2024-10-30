package com.microsoft.schemas.office.excel.impl;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.excel.STCF;
import com.microsoft.schemas.office.excel.STObjectType;
import com.microsoft.schemas.office.excel.STTrueFalseBlank;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTClientDataImpl extends XmlComplexContentImpl implements CTClientData {
  private static final b MOVEWITHCELLS$0 = new b("urn:schemas-microsoft-com:office:excel", "MoveWithCells");
  
  private static final b SIZEWITHCELLS$2 = new b("urn:schemas-microsoft-com:office:excel", "SizeWithCells");
  
  private static final b ANCHOR$4 = new b("urn:schemas-microsoft-com:office:excel", "Anchor");
  
  private static final b LOCKED$6 = new b("urn:schemas-microsoft-com:office:excel", "Locked");
  
  private static final b DEFAULTSIZE$8 = new b("urn:schemas-microsoft-com:office:excel", "DefaultSize");
  
  private static final b PRINTOBJECT$10 = new b("urn:schemas-microsoft-com:office:excel", "PrintObject");
  
  private static final b DISABLED$12 = new b("urn:schemas-microsoft-com:office:excel", "Disabled");
  
  private static final b AUTOFILL$14 = new b("urn:schemas-microsoft-com:office:excel", "AutoFill");
  
  private static final b AUTOLINE$16 = new b("urn:schemas-microsoft-com:office:excel", "AutoLine");
  
  private static final b AUTOPICT$18 = new b("urn:schemas-microsoft-com:office:excel", "AutoPict");
  
  private static final b FMLAMACRO$20 = new b("urn:schemas-microsoft-com:office:excel", "FmlaMacro");
  
  private static final b TEXTHALIGN$22 = new b("urn:schemas-microsoft-com:office:excel", "TextHAlign");
  
  private static final b TEXTVALIGN$24 = new b("urn:schemas-microsoft-com:office:excel", "TextVAlign");
  
  private static final b LOCKTEXT$26 = new b("urn:schemas-microsoft-com:office:excel", "LockText");
  
  private static final b JUSTLASTX$28 = new b("urn:schemas-microsoft-com:office:excel", "JustLastX");
  
  private static final b SECRETEDIT$30 = new b("urn:schemas-microsoft-com:office:excel", "SecretEdit");
  
  private static final b DEFAULT$32 = new b("urn:schemas-microsoft-com:office:excel", "Default");
  
  private static final b HELP$34 = new b("urn:schemas-microsoft-com:office:excel", "Help");
  
  private static final b CANCEL$36 = new b("urn:schemas-microsoft-com:office:excel", "Cancel");
  
  private static final b DISMISS$38 = new b("urn:schemas-microsoft-com:office:excel", "Dismiss");
  
  private static final b ACCEL$40 = new b("urn:schemas-microsoft-com:office:excel", "Accel");
  
  private static final b ACCEL2$42 = new b("urn:schemas-microsoft-com:office:excel", "Accel2");
  
  private static final b ROW$44 = new b("urn:schemas-microsoft-com:office:excel", "Row");
  
  private static final b COLUMN$46 = new b("urn:schemas-microsoft-com:office:excel", "Column");
  
  private static final b VISIBLE$48 = new b("urn:schemas-microsoft-com:office:excel", "Visible");
  
  private static final b ROWHIDDEN$50 = new b("urn:schemas-microsoft-com:office:excel", "RowHidden");
  
  private static final b COLHIDDEN$52 = new b("urn:schemas-microsoft-com:office:excel", "ColHidden");
  
  private static final b VTEDIT$54 = new b("urn:schemas-microsoft-com:office:excel", "VTEdit");
  
  private static final b MULTILINE$56 = new b("urn:schemas-microsoft-com:office:excel", "MultiLine");
  
  private static final b VSCROLL$58 = new b("urn:schemas-microsoft-com:office:excel", "VScroll");
  
  private static final b VALIDIDS$60 = new b("urn:schemas-microsoft-com:office:excel", "ValidIds");
  
  private static final b FMLARANGE$62 = new b("urn:schemas-microsoft-com:office:excel", "FmlaRange");
  
  private static final b WIDTHMIN$64 = new b("urn:schemas-microsoft-com:office:excel", "WidthMin");
  
  private static final b SEL$66 = new b("urn:schemas-microsoft-com:office:excel", "Sel");
  
  private static final b NOTHREED2$68 = new b("urn:schemas-microsoft-com:office:excel", "NoThreeD2");
  
  private static final b SELTYPE$70 = new b("urn:schemas-microsoft-com:office:excel", "SelType");
  
  private static final b MULTISEL$72 = new b("urn:schemas-microsoft-com:office:excel", "MultiSel");
  
  private static final b LCT$74 = new b("urn:schemas-microsoft-com:office:excel", "LCT");
  
  private static final b LISTITEM$76 = new b("urn:schemas-microsoft-com:office:excel", "ListItem");
  
  private static final b DROPSTYLE$78 = new b("urn:schemas-microsoft-com:office:excel", "DropStyle");
  
  private static final b COLORED$80 = new b("urn:schemas-microsoft-com:office:excel", "Colored");
  
  private static final b DROPLINES$82 = new b("urn:schemas-microsoft-com:office:excel", "DropLines");
  
  private static final b CHECKED$84 = new b("urn:schemas-microsoft-com:office:excel", "Checked");
  
  private static final b FMLALINK$86 = new b("urn:schemas-microsoft-com:office:excel", "FmlaLink");
  
  private static final b FMLAPICT$88 = new b("urn:schemas-microsoft-com:office:excel", "FmlaPict");
  
  private static final b NOTHREED$90 = new b("urn:schemas-microsoft-com:office:excel", "NoThreeD");
  
  private static final b FIRSTBUTTON$92 = new b("urn:schemas-microsoft-com:office:excel", "FirstButton");
  
  private static final b FMLAGROUP$94 = new b("urn:schemas-microsoft-com:office:excel", "FmlaGroup");
  
  private static final b VAL$96 = new b("urn:schemas-microsoft-com:office:excel", "Val");
  
  private static final b MIN$98 = new b("urn:schemas-microsoft-com:office:excel", "Min");
  
  private static final b MAX$100 = new b("urn:schemas-microsoft-com:office:excel", "Max");
  
  private static final b INC$102 = new b("urn:schemas-microsoft-com:office:excel", "Inc");
  
  private static final b PAGE$104 = new b("urn:schemas-microsoft-com:office:excel", "Page");
  
  private static final b HORIZ$106 = new b("urn:schemas-microsoft-com:office:excel", "Horiz");
  
  private static final b DX$108 = new b("urn:schemas-microsoft-com:office:excel", "Dx");
  
  private static final b MAPOCX$110 = new b("urn:schemas-microsoft-com:office:excel", "MapOCX");
  
  private static final b CF$112 = new b("urn:schemas-microsoft-com:office:excel", "CF");
  
  private static final b CAMERA$114 = new b("urn:schemas-microsoft-com:office:excel", "Camera");
  
  private static final b RECALCALWAYS$116 = new b("urn:schemas-microsoft-com:office:excel", "RecalcAlways");
  
  private static final b AUTOSCALE$118 = new b("urn:schemas-microsoft-com:office:excel", "AutoScale");
  
  private static final b DDE$120 = new b("urn:schemas-microsoft-com:office:excel", "DDE");
  
  private static final b UIOBJ$122 = new b("urn:schemas-microsoft-com:office:excel", "UIObj");
  
  private static final b SCRIPTTEXT$124 = new b("urn:schemas-microsoft-com:office:excel", "ScriptText");
  
  private static final b SCRIPTEXTENDED$126 = new b("urn:schemas-microsoft-com:office:excel", "ScriptExtended");
  
  private static final b SCRIPTLANGUAGE$128 = new b("urn:schemas-microsoft-com:office:excel", "ScriptLanguage");
  
  private static final b SCRIPTLOCATION$130 = new b("urn:schemas-microsoft-com:office:excel", "ScriptLocation");
  
  private static final b FMLATXBX$132 = new b("urn:schemas-microsoft-com:office:excel", "FmlaTxbx");
  
  private static final b OBJECTTYPE$134 = new b("", "ObjectType");
  
  public CTClientDataImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<STTrueFalseBlank.Enum> getMoveWithCellsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new MoveWithCellsList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getMoveWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MOVEWITHCELLS$0, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getMoveWithCellsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MOVEWITHCELLS$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetMoveWithCellsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new MoveWithCellsList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetMoveWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MOVEWITHCELLS$0, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetMoveWithCellsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MOVEWITHCELLS$0, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfMoveWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MOVEWITHCELLS$0);
    } 
  }
  
  public void setMoveWithCellsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, MOVEWITHCELLS$0);
    } 
  }
  
  public void setMoveWithCellsArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MOVEWITHCELLS$0, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetMoveWithCellsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, MOVEWITHCELLS$0);
    } 
  }
  
  public void xsetMoveWithCellsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MOVEWITHCELLS$0, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertMoveWithCells(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MOVEWITHCELLS$0, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addMoveWithCells(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MOVEWITHCELLS$0);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewMoveWithCells(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(MOVEWITHCELLS$0, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewMoveWithCells() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(MOVEWITHCELLS$0);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeMoveWithCells(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVEWITHCELLS$0, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getSizeWithCellsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new SizeWithCellsList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getSizeWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SIZEWITHCELLS$2, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getSizeWithCellsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIZEWITHCELLS$2, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetSizeWithCellsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new SizeWithCellsList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetSizeWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SIZEWITHCELLS$2, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetSizeWithCellsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(SIZEWITHCELLS$2, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfSizeWithCellsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SIZEWITHCELLS$2);
    } 
  }
  
  public void setSizeWithCellsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, SIZEWITHCELLS$2);
    } 
  }
  
  public void setSizeWithCellsArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIZEWITHCELLS$2, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSizeWithCellsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, SIZEWITHCELLS$2);
    } 
  }
  
  public void xsetSizeWithCellsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(SIZEWITHCELLS$2, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertSizeWithCells(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SIZEWITHCELLS$2, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addSizeWithCells(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SIZEWITHCELLS$2);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewSizeWithCells(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(SIZEWITHCELLS$2, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewSizeWithCells() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(SIZEWITHCELLS$2);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeSizeWithCells(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SIZEWITHCELLS$2, paramInt);
    } 
  }
  
  public List<String> getAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new AnchorList(this);
    } 
  }
  
  public String[] getAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ANCHOR$4, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ANCHOR$4, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetAnchorList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new AnchorList(this);
    } 
  }
  
  public XmlString[] xgetAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ANCHOR$4, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetAnchorArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(ANCHOR$4, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfAnchorArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ANCHOR$4);
    } 
  }
  
  public void setAnchorArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, ANCHOR$4);
    } 
  }
  
  public void setAnchorArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ANCHOR$4, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAnchorArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, ANCHOR$4);
    } 
  }
  
  public void xsetAnchorArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(ANCHOR$4, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertAnchor(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ANCHOR$4, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addAnchor(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ANCHOR$4);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(ANCHOR$4, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewAnchor() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(ANCHOR$4);
      return xmlString;
    } 
  }
  
  public void removeAnchor(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ANCHOR$4, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getLockedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new LockedList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getLockedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LOCKED$6, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getLockedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LOCKED$6, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetLockedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new LockedList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetLockedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LOCKED$6, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetLockedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(LOCKED$6, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfLockedArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LOCKED$6);
    } 
  }
  
  public void setLockedArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, LOCKED$6);
    } 
  }
  
  public void setLockedArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LOCKED$6, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLockedArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, LOCKED$6);
    } 
  }
  
  public void xsetLockedArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(LOCKED$6, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertLocked(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LOCKED$6, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addLocked(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LOCKED$6);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewLocked(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(LOCKED$6, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewLocked() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(LOCKED$6);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeLocked(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOCKED$6, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getDefaultSizeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new DefaultSizeList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getDefaultSizeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DEFAULTSIZE$8, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getDefaultSizeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DEFAULTSIZE$8, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetDefaultSizeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new DefaultSizeList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetDefaultSizeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DEFAULTSIZE$8, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetDefaultSizeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DEFAULTSIZE$8, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfDefaultSizeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEFAULTSIZE$8);
    } 
  }
  
  public void setDefaultSizeArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, DEFAULTSIZE$8);
    } 
  }
  
  public void setDefaultSizeArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DEFAULTSIZE$8, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefaultSizeArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, DEFAULTSIZE$8);
    } 
  }
  
  public void xsetDefaultSizeArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DEFAULTSIZE$8, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertDefaultSize(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DEFAULTSIZE$8, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addDefaultSize(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DEFAULTSIZE$8);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewDefaultSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(DEFAULTSIZE$8, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewDefaultSize() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(DEFAULTSIZE$8);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeDefaultSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULTSIZE$8, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getPrintObjectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new PrintObjectList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getPrintObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(PRINTOBJECT$10, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getPrintObjectArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PRINTOBJECT$10, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetPrintObjectList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new PrintObjectList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetPrintObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PRINTOBJECT$10, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetPrintObjectArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(PRINTOBJECT$10, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfPrintObjectArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PRINTOBJECT$10);
    } 
  }
  
  public void setPrintObjectArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, PRINTOBJECT$10);
    } 
  }
  
  public void setPrintObjectArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PRINTOBJECT$10, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPrintObjectArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, PRINTOBJECT$10);
    } 
  }
  
  public void xsetPrintObjectArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(PRINTOBJECT$10, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertPrintObject(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(PRINTOBJECT$10, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addPrintObject(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(PRINTOBJECT$10);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewPrintObject(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(PRINTOBJECT$10, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewPrintObject() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(PRINTOBJECT$10);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removePrintObject(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PRINTOBJECT$10, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getDisabledList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new DisabledList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getDisabledArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DISABLED$12, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getDisabledArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DISABLED$12, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetDisabledList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new DisabledList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetDisabledArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DISABLED$12, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetDisabledArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DISABLED$12, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfDisabledArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DISABLED$12);
    } 
  }
  
  public void setDisabledArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, DISABLED$12);
    } 
  }
  
  public void setDisabledArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DISABLED$12, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDisabledArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, DISABLED$12);
    } 
  }
  
  public void xsetDisabledArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DISABLED$12, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertDisabled(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DISABLED$12, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addDisabled(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DISABLED$12);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewDisabled(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(DISABLED$12, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewDisabled() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(DISABLED$12);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeDisabled(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISABLED$12, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getAutoFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new AutoFillList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getAutoFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOFILL$14, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getAutoFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOFILL$14, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetAutoFillList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new AutoFillList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetAutoFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOFILL$14, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetAutoFillArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOFILL$14, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfAutoFillArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AUTOFILL$14);
    } 
  }
  
  public void setAutoFillArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, AUTOFILL$14);
    } 
  }
  
  public void setAutoFillArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOFILL$14, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAutoFillArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, AUTOFILL$14);
    } 
  }
  
  public void xsetAutoFillArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOFILL$14, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertAutoFill(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(AUTOFILL$14, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addAutoFill(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(AUTOFILL$14);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewAutoFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(AUTOFILL$14, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewAutoFill() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(AUTOFILL$14);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeAutoFill(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOFILL$14, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getAutoLineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new AutoLineList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getAutoLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOLINE$16, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getAutoLineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOLINE$16, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetAutoLineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new AutoLineList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetAutoLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOLINE$16, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetAutoLineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOLINE$16, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfAutoLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AUTOLINE$16);
    } 
  }
  
  public void setAutoLineArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, AUTOLINE$16);
    } 
  }
  
  public void setAutoLineArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOLINE$16, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAutoLineArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, AUTOLINE$16);
    } 
  }
  
  public void xsetAutoLineArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOLINE$16, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertAutoLine(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(AUTOLINE$16, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addAutoLine(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(AUTOLINE$16);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewAutoLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(AUTOLINE$16, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewAutoLine() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(AUTOLINE$16);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeAutoLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOLINE$16, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getAutoPictList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new AutoPictList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getAutoPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOPICT$18, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getAutoPictArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOPICT$18, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetAutoPictList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new AutoPictList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetAutoPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOPICT$18, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetAutoPictArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOPICT$18, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfAutoPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AUTOPICT$18);
    } 
  }
  
  public void setAutoPictArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, AUTOPICT$18);
    } 
  }
  
  public void setAutoPictArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOPICT$18, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAutoPictArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, AUTOPICT$18);
    } 
  }
  
  public void xsetAutoPictArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOPICT$18, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertAutoPict(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(AUTOPICT$18, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addAutoPict(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(AUTOPICT$18);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewAutoPict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(AUTOPICT$18, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewAutoPict() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(AUTOPICT$18);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeAutoPict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOPICT$18, paramInt);
    } 
  }
  
  public List<String> getFmlaMacroList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaMacroList(this);
    } 
  }
  
  public String[] getFmlaMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAMACRO$20, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaMacroArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAMACRO$20, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaMacroList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaMacroList(this);
    } 
  }
  
  public XmlString[] xgetFmlaMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAMACRO$20, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaMacroArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAMACRO$20, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaMacroArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLAMACRO$20);
    } 
  }
  
  public void setFmlaMacroArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLAMACRO$20);
    } 
  }
  
  public void setFmlaMacroArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAMACRO$20, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaMacroArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLAMACRO$20);
    } 
  }
  
  public void xsetFmlaMacroArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAMACRO$20, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaMacro(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLAMACRO$20, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaMacro(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLAMACRO$20);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLAMACRO$20, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaMacro() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLAMACRO$20);
      return xmlString;
    } 
  }
  
  public void removeFmlaMacro(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLAMACRO$20, paramInt);
    } 
  }
  
  public List<String> getTextHAlignList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new TextHAlignList(this);
    } 
  }
  
  public String[] getTextHAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTHALIGN$22, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getTextHAlignArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXTHALIGN$22, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetTextHAlignList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new TextHAlignList(this);
    } 
  }
  
  public XmlString[] xgetTextHAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTHALIGN$22, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetTextHAlignArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXTHALIGN$22, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfTextHAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTHALIGN$22);
    } 
  }
  
  public void setTextHAlignArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, TEXTHALIGN$22);
    } 
  }
  
  public void setTextHAlignArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXTHALIGN$22, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTextHAlignArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, TEXTHALIGN$22);
    } 
  }
  
  public void xsetTextHAlignArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXTHALIGN$22, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertTextHAlign(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(TEXTHALIGN$22, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addTextHAlign(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(TEXTHALIGN$22);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewTextHAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(TEXTHALIGN$22, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewTextHAlign() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(TEXTHALIGN$22);
      return xmlString;
    } 
  }
  
  public void removeTextHAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTHALIGN$22, paramInt);
    } 
  }
  
  public List<String> getTextVAlignList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new TextVAlignList(this);
    } 
  }
  
  public String[] getTextVAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTVALIGN$24, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getTextVAlignArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXTVALIGN$24, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetTextVAlignList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new TextVAlignList(this);
    } 
  }
  
  public XmlString[] xgetTextVAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TEXTVALIGN$24, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetTextVAlignArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXTVALIGN$24, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfTextVAlignArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TEXTVALIGN$24);
    } 
  }
  
  public void setTextVAlignArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, TEXTVALIGN$24);
    } 
  }
  
  public void setTextVAlignArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(TEXTVALIGN$24, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetTextVAlignArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, TEXTVALIGN$24);
    } 
  }
  
  public void xsetTextVAlignArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(TEXTVALIGN$24, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertTextVAlign(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(TEXTVALIGN$24, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addTextVAlign(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(TEXTVALIGN$24);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewTextVAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(TEXTVALIGN$24, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewTextVAlign() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(TEXTVALIGN$24);
      return xmlString;
    } 
  }
  
  public void removeTextVAlign(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXTVALIGN$24, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getLockTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new LockTextList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getLockTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LOCKTEXT$26, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getLockTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LOCKTEXT$26, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetLockTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new LockTextList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetLockTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LOCKTEXT$26, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetLockTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(LOCKTEXT$26, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfLockTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LOCKTEXT$26);
    } 
  }
  
  public void setLockTextArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, LOCKTEXT$26);
    } 
  }
  
  public void setLockTextArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LOCKTEXT$26, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLockTextArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, LOCKTEXT$26);
    } 
  }
  
  public void xsetLockTextArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(LOCKTEXT$26, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertLockText(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LOCKTEXT$26, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addLockText(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LOCKTEXT$26);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewLockText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(LOCKTEXT$26, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewLockText() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(LOCKTEXT$26);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeLockText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOCKTEXT$26, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getJustLastXList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new JustLastXList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getJustLastXArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(JUSTLASTX$28, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getJustLastXArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(JUSTLASTX$28, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetJustLastXList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new JustLastXList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetJustLastXArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(JUSTLASTX$28, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetJustLastXArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(JUSTLASTX$28, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfJustLastXArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(JUSTLASTX$28);
    } 
  }
  
  public void setJustLastXArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, JUSTLASTX$28);
    } 
  }
  
  public void setJustLastXArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(JUSTLASTX$28, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetJustLastXArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, JUSTLASTX$28);
    } 
  }
  
  public void xsetJustLastXArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(JUSTLASTX$28, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertJustLastX(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(JUSTLASTX$28, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addJustLastX(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(JUSTLASTX$28);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewJustLastX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(JUSTLASTX$28, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewJustLastX() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(JUSTLASTX$28);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeJustLastX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(JUSTLASTX$28, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getSecretEditList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new SecretEditList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getSecretEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SECRETEDIT$30, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getSecretEditArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SECRETEDIT$30, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetSecretEditList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new SecretEditList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetSecretEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SECRETEDIT$30, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetSecretEditArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(SECRETEDIT$30, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfSecretEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SECRETEDIT$30);
    } 
  }
  
  public void setSecretEditArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, SECRETEDIT$30);
    } 
  }
  
  public void setSecretEditArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SECRETEDIT$30, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSecretEditArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, SECRETEDIT$30);
    } 
  }
  
  public void xsetSecretEditArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(SECRETEDIT$30, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertSecretEdit(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SECRETEDIT$30, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addSecretEdit(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SECRETEDIT$30);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewSecretEdit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(SECRETEDIT$30, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewSecretEdit() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(SECRETEDIT$30);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeSecretEdit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SECRETEDIT$30, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getDefaultList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new DefaultList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getDefaultArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DEFAULT$32, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getDefaultArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DEFAULT$32, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetDefaultList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new DefaultList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetDefaultArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DEFAULT$32, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetDefaultArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DEFAULT$32, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfDefaultArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DEFAULT$32);
    } 
  }
  
  public void setDefaultArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, DEFAULT$32);
    } 
  }
  
  public void setDefaultArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DEFAULT$32, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefaultArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, DEFAULT$32);
    } 
  }
  
  public void xsetDefaultArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DEFAULT$32, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertDefault(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DEFAULT$32, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addDefault(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DEFAULT$32);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewDefault(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(DEFAULT$32, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewDefault() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(DEFAULT$32);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeDefault(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFAULT$32, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getHelpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new HelpList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getHelpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(HELP$34, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getHelpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HELP$34, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetHelpList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new HelpList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetHelpArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HELP$34, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetHelpArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(HELP$34, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfHelpArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HELP$34);
    } 
  }
  
  public void setHelpArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, HELP$34);
    } 
  }
  
  public void setHelpArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HELP$34, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHelpArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, HELP$34);
    } 
  }
  
  public void xsetHelpArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(HELP$34, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertHelp(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(HELP$34, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addHelp(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(HELP$34);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewHelp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(HELP$34, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewHelp() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(HELP$34);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeHelp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HELP$34, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getCancelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new CancelList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getCancelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CANCEL$36, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getCancelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CANCEL$36, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetCancelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new CancelList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetCancelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CANCEL$36, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetCancelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(CANCEL$36, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfCancelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CANCEL$36);
    } 
  }
  
  public void setCancelArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, CANCEL$36);
    } 
  }
  
  public void setCancelArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CANCEL$36, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCancelArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, CANCEL$36);
    } 
  }
  
  public void xsetCancelArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(CANCEL$36, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertCancel(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CANCEL$36, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addCancel(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CANCEL$36);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewCancel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(CANCEL$36, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewCancel() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(CANCEL$36);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeCancel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CANCEL$36, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getDismissList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new DismissList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getDismissArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DISMISS$38, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getDismissArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DISMISS$38, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetDismissList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new DismissList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetDismissArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DISMISS$38, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetDismissArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DISMISS$38, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfDismissArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DISMISS$38);
    } 
  }
  
  public void setDismissArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, DISMISS$38);
    } 
  }
  
  public void setDismissArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DISMISS$38, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDismissArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, DISMISS$38);
    } 
  }
  
  public void xsetDismissArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DISMISS$38, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertDismiss(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DISMISS$38, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addDismiss(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DISMISS$38);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewDismiss(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(DISMISS$38, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewDismiss() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(DISMISS$38);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeDismiss(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DISMISS$38, paramInt);
    } 
  }
  
  public List<BigInteger> getAccelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new AccelList(this);
    } 
  }
  
  public BigInteger[] getAccelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ACCEL$40, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getAccelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ACCEL$40, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetAccelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new AccelList(this);
    } 
  }
  
  public XmlInteger[] xgetAccelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ACCEL$40, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetAccelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ACCEL$40, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfAccelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ACCEL$40);
    } 
  }
  
  public void setAccelArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, ACCEL$40);
    } 
  }
  
  public void setAccelArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ACCEL$40, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetAccelArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, ACCEL$40);
    } 
  }
  
  public void xsetAccelArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ACCEL$40, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertAccel(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ACCEL$40, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addAccel(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ACCEL$40);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewAccel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(ACCEL$40, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewAccel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(ACCEL$40);
      return xmlInteger;
    } 
  }
  
  public void removeAccel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ACCEL$40, paramInt);
    } 
  }
  
  public List<BigInteger> getAccel2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new Accel2List(this);
    } 
  }
  
  public BigInteger[] getAccel2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ACCEL2$42, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getAccel2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ACCEL2$42, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetAccel2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new Accel2List(this);
    } 
  }
  
  public XmlInteger[] xgetAccel2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ACCEL2$42, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetAccel2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ACCEL2$42, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfAccel2Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ACCEL2$42);
    } 
  }
  
  public void setAccel2Array(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, ACCEL2$42);
    } 
  }
  
  public void setAccel2Array(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ACCEL2$42, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetAccel2Array(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, ACCEL2$42);
    } 
  }
  
  public void xsetAccel2Array(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ACCEL2$42, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertAccel2(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ACCEL2$42, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addAccel2(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ACCEL2$42);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewAccel2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(ACCEL2$42, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewAccel2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(ACCEL2$42);
      return xmlInteger;
    } 
  }
  
  public void removeAccel2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ACCEL2$42, paramInt);
    } 
  }
  
  public List<BigInteger> getRowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new RowList(this);
    } 
  }
  
  public BigInteger[] getRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ROW$44, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getRowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROW$44, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetRowList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new RowList(this);
    } 
  }
  
  public XmlInteger[] xgetRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ROW$44, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetRowArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ROW$44, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfRowArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ROW$44);
    } 
  }
  
  public void setRowArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, ROW$44);
    } 
  }
  
  public void setRowArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROW$44, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetRowArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, ROW$44);
    } 
  }
  
  public void xsetRowArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(ROW$44, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertRow(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ROW$44, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addRow(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ROW$44);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(ROW$44, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewRow() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(ROW$44);
      return xmlInteger;
    } 
  }
  
  public void removeRow(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROW$44, paramInt);
    } 
  }
  
  public List<BigInteger> getColumnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new ColumnList(this);
    } 
  }
  
  public BigInteger[] getColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(COLUMN$46, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getColumnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLUMN$46, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetColumnList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new ColumnList(this);
    } 
  }
  
  public XmlInteger[] xgetColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COLUMN$46, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetColumnArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(COLUMN$46, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfColumnArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLUMN$46);
    } 
  }
  
  public void setColumnArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, COLUMN$46);
    } 
  }
  
  public void setColumnArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLUMN$46, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetColumnArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, COLUMN$46);
    } 
  }
  
  public void xsetColumnArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(COLUMN$46, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertColumn(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(COLUMN$46, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addColumn(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(COLUMN$46);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(COLUMN$46, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewColumn() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(COLUMN$46);
      return xmlInteger;
    } 
  }
  
  public void removeColumn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLUMN$46, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getVisibleList() {
    synchronized (monitor()) {
      check_orphaned();
      final class VisibleList extends AbstractList<STTrueFalseBlank.Enum> {
        public STTrueFalseBlank.Enum get(int param1Int) {
          return CTClientDataImpl.this.getVisibleArray(param1Int);
        }
        
        public STTrueFalseBlank.Enum set(int param1Int, STTrueFalseBlank.Enum param1Enum) {
          STTrueFalseBlank.Enum enum_ = CTClientDataImpl.this.getVisibleArray(param1Int);
          CTClientDataImpl.this.setVisibleArray(param1Int, param1Enum);
          return enum_;
        }
        
        public void add(int param1Int, STTrueFalseBlank.Enum param1Enum) {
          CTClientDataImpl.this.insertVisible(param1Int, param1Enum);
        }
        
        public STTrueFalseBlank.Enum remove(int param1Int) {
          STTrueFalseBlank.Enum enum_ = CTClientDataImpl.this.getVisibleArray(param1Int);
          CTClientDataImpl.this.removeVisible(param1Int);
          return enum_;
        }
        
        public int size() {
          return CTClientDataImpl.this.sizeOfVisibleArray();
        }
      };
      return new VisibleList();
    } 
  }
  
  public STTrueFalseBlank.Enum[] getVisibleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(VISIBLE$48, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getVisibleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VISIBLE$48, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetVisibleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new VisibleList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetVisibleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VISIBLE$48, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetVisibleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VISIBLE$48, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfVisibleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VISIBLE$48);
    } 
  }
  
  public void setVisibleArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, VISIBLE$48);
    } 
  }
  
  public void setVisibleArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VISIBLE$48, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVisibleArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, VISIBLE$48);
    } 
  }
  
  public void xsetVisibleArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VISIBLE$48, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertVisible(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(VISIBLE$48, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addVisible(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(VISIBLE$48);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewVisible(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(VISIBLE$48, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewVisible() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(VISIBLE$48);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeVisible(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VISIBLE$48, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getRowHiddenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new RowHiddenList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getRowHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(ROWHIDDEN$50, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getRowHiddenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROWHIDDEN$50, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetRowHiddenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new RowHiddenList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetRowHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ROWHIDDEN$50, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetRowHiddenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(ROWHIDDEN$50, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfRowHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ROWHIDDEN$50);
    } 
  }
  
  public void setRowHiddenArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, ROWHIDDEN$50);
    } 
  }
  
  public void setRowHiddenArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(ROWHIDDEN$50, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRowHiddenArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, ROWHIDDEN$50);
    } 
  }
  
  public void xsetRowHiddenArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(ROWHIDDEN$50, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertRowHidden(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(ROWHIDDEN$50, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addRowHidden(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(ROWHIDDEN$50);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewRowHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(ROWHIDDEN$50, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewRowHidden() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(ROWHIDDEN$50);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeRowHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ROWHIDDEN$50, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getColHiddenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new ColHiddenList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getColHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(COLHIDDEN$52, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getColHiddenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLHIDDEN$52, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetColHiddenList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new ColHiddenList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetColHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COLHIDDEN$52, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetColHiddenArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(COLHIDDEN$52, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfColHiddenArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLHIDDEN$52);
    } 
  }
  
  public void setColHiddenArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, COLHIDDEN$52);
    } 
  }
  
  public void setColHiddenArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLHIDDEN$52, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetColHiddenArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, COLHIDDEN$52);
    } 
  }
  
  public void xsetColHiddenArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(COLHIDDEN$52, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertColHidden(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(COLHIDDEN$52, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addColHidden(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(COLHIDDEN$52);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewColHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(COLHIDDEN$52, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewColHidden() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(COLHIDDEN$52);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeColHidden(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLHIDDEN$52, paramInt);
    } 
  }
  
  public List<BigInteger> getVTEditList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new VTEditList(this);
    } 
  }
  
  public BigInteger[] getVTEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(VTEDIT$54, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getVTEditArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VTEDIT$54, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetVTEditList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new VTEditList(this);
    } 
  }
  
  public XmlInteger[] xgetVTEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VTEDIT$54, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetVTEditArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(VTEDIT$54, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfVTEditArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VTEDIT$54);
    } 
  }
  
  public void setVTEditArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, VTEDIT$54);
    } 
  }
  
  public void setVTEditArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VTEDIT$54, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetVTEditArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, VTEDIT$54);
    } 
  }
  
  public void xsetVTEditArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(VTEDIT$54, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertVTEdit(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(VTEDIT$54, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addVTEdit(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(VTEDIT$54);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewVTEdit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(VTEDIT$54, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewVTEdit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(VTEDIT$54);
      return xmlInteger;
    } 
  }
  
  public void removeVTEdit(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VTEDIT$54, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getMultiLineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new MultiLineList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getMultiLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MULTILINE$56, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getMultiLineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MULTILINE$56, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetMultiLineList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new MultiLineList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetMultiLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MULTILINE$56, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetMultiLineArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MULTILINE$56, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfMultiLineArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MULTILINE$56);
    } 
  }
  
  public void setMultiLineArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, MULTILINE$56);
    } 
  }
  
  public void setMultiLineArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MULTILINE$56, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetMultiLineArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, MULTILINE$56);
    } 
  }
  
  public void xsetMultiLineArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MULTILINE$56, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertMultiLine(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MULTILINE$56, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addMultiLine(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MULTILINE$56);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewMultiLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(MULTILINE$56, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewMultiLine() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(MULTILINE$56);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeMultiLine(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MULTILINE$56, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getVScrollList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new VScrollList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getVScrollArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(VSCROLL$58, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getVScrollArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VSCROLL$58, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetVScrollList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new VScrollList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetVScrollArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VSCROLL$58, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetVScrollArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VSCROLL$58, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfVScrollArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VSCROLL$58);
    } 
  }
  
  public void setVScrollArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, VSCROLL$58);
    } 
  }
  
  public void setVScrollArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VSCROLL$58, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVScrollArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, VSCROLL$58);
    } 
  }
  
  public void xsetVScrollArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VSCROLL$58, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertVScroll(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(VSCROLL$58, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addVScroll(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(VSCROLL$58);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewVScroll(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(VSCROLL$58, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewVScroll() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(VSCROLL$58);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeVScroll(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VSCROLL$58, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getValidIdsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new ValidIdsList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getValidIdsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(VALIDIDS$60, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getValidIdsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VALIDIDS$60, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetValidIdsList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new ValidIdsList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetValidIdsArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VALIDIDS$60, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetValidIdsArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VALIDIDS$60, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfValidIdsArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VALIDIDS$60);
    } 
  }
  
  public void setValidIdsArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, VALIDIDS$60);
    } 
  }
  
  public void setValidIdsArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VALIDIDS$60, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetValidIdsArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, VALIDIDS$60);
    } 
  }
  
  public void xsetValidIdsArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(VALIDIDS$60, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertValidIds(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(VALIDIDS$60, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addValidIds(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(VALIDIDS$60);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewValidIds(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(VALIDIDS$60, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewValidIds() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(VALIDIDS$60);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeValidIds(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VALIDIDS$60, paramInt);
    } 
  }
  
  public List<String> getFmlaRangeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaRangeList(this);
    } 
  }
  
  public String[] getFmlaRangeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLARANGE$62, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaRangeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLARANGE$62, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaRangeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaRangeList(this);
    } 
  }
  
  public XmlString[] xgetFmlaRangeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLARANGE$62, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaRangeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLARANGE$62, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaRangeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLARANGE$62);
    } 
  }
  
  public void setFmlaRangeArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLARANGE$62);
    } 
  }
  
  public void setFmlaRangeArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLARANGE$62, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaRangeArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLARANGE$62);
    } 
  }
  
  public void xsetFmlaRangeArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLARANGE$62, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaRange(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLARANGE$62, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaRange(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLARANGE$62);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaRange(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLARANGE$62, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaRange() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLARANGE$62);
      return xmlString;
    } 
  }
  
  public void removeFmlaRange(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLARANGE$62, paramInt);
    } 
  }
  
  public List<BigInteger> getWidthMinList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new WidthMinList(this);
    } 
  }
  
  public BigInteger[] getWidthMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(WIDTHMIN$64, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getWidthMinArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WIDTHMIN$64, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetWidthMinList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new WidthMinList(this);
    } 
  }
  
  public XmlInteger[] xgetWidthMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(WIDTHMIN$64, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetWidthMinArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(WIDTHMIN$64, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfWidthMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(WIDTHMIN$64);
    } 
  }
  
  public void setWidthMinArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, WIDTHMIN$64);
    } 
  }
  
  public void setWidthMinArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WIDTHMIN$64, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetWidthMinArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, WIDTHMIN$64);
    } 
  }
  
  public void xsetWidthMinArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(WIDTHMIN$64, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertWidthMin(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(WIDTHMIN$64, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addWidthMin(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(WIDTHMIN$64);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewWidthMin(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(WIDTHMIN$64, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewWidthMin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(WIDTHMIN$64);
      return xmlInteger;
    } 
  }
  
  public void removeWidthMin(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WIDTHMIN$64, paramInt);
    } 
  }
  
  public List<BigInteger> getSelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new SelList(this);
    } 
  }
  
  public BigInteger[] getSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SEL$66, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getSelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SEL$66, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetSelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new SelList(this);
    } 
  }
  
  public XmlInteger[] xgetSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SEL$66, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetSelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(SEL$66, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SEL$66);
    } 
  }
  
  public void setSelArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, SEL$66);
    } 
  }
  
  public void setSelArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SEL$66, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetSelArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, SEL$66);
    } 
  }
  
  public void xsetSelArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(SEL$66, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertSel(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SEL$66, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addSel(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SEL$66);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewSel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(SEL$66, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewSel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(SEL$66);
      return xmlInteger;
    } 
  }
  
  public void removeSel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SEL$66, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getNoThreeD2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new NoThreeD2List(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getNoThreeD2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(NOTHREED2$68, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getNoThreeD2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTHREED2$68, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetNoThreeD2List() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new NoThreeD2List(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetNoThreeD2Array() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NOTHREED2$68, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetNoThreeD2Array(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(NOTHREED2$68, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfNoThreeD2Array() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NOTHREED2$68);
    } 
  }
  
  public void setNoThreeD2Array(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, NOTHREED2$68);
    } 
  }
  
  public void setNoThreeD2Array(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTHREED2$68, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetNoThreeD2Array(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, NOTHREED2$68);
    } 
  }
  
  public void xsetNoThreeD2Array(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(NOTHREED2$68, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertNoThreeD2(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(NOTHREED2$68, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addNoThreeD2(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(NOTHREED2$68);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewNoThreeD2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(NOTHREED2$68, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewNoThreeD2() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(NOTHREED2$68);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeNoThreeD2(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTHREED2$68, paramInt);
    } 
  }
  
  public List<String> getSelTypeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new SelTypeList(this);
    } 
  }
  
  public String[] getSelTypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SELTYPE$70, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getSelTypeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SELTYPE$70, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetSelTypeList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new SelTypeList(this);
    } 
  }
  
  public XmlString[] xgetSelTypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SELTYPE$70, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetSelTypeArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SELTYPE$70, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfSelTypeArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SELTYPE$70);
    } 
  }
  
  public void setSelTypeArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, SELTYPE$70);
    } 
  }
  
  public void setSelTypeArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SELTYPE$70, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSelTypeArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, SELTYPE$70);
    } 
  }
  
  public void xsetSelTypeArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SELTYPE$70, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertSelType(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SELTYPE$70, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addSelType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SELTYPE$70);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewSelType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(SELTYPE$70, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewSelType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(SELTYPE$70);
      return xmlString;
    } 
  }
  
  public void removeSelType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SELTYPE$70, paramInt);
    } 
  }
  
  public List<String> getMultiSelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new MultiSelList(this);
    } 
  }
  
  public String[] getMultiSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MULTISEL$72, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getMultiSelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MULTISEL$72, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetMultiSelList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new MultiSelList(this);
    } 
  }
  
  public XmlString[] xgetMultiSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MULTISEL$72, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetMultiSelArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(MULTISEL$72, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfMultiSelArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MULTISEL$72);
    } 
  }
  
  public void setMultiSelArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, MULTISEL$72);
    } 
  }
  
  public void setMultiSelArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MULTISEL$72, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetMultiSelArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, MULTISEL$72);
    } 
  }
  
  public void xsetMultiSelArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(MULTISEL$72, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertMultiSel(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MULTISEL$72, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addMultiSel(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MULTISEL$72);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewMultiSel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(MULTISEL$72, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewMultiSel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(MULTISEL$72);
      return xmlString;
    } 
  }
  
  public void removeMultiSel(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MULTISEL$72, paramInt);
    } 
  }
  
  public List<String> getLCTList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new LCTList(this);
    } 
  }
  
  public String[] getLCTArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LCT$74, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getLCTArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LCT$74, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetLCTList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new LCTList(this);
    } 
  }
  
  public XmlString[] xgetLCTArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LCT$74, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetLCTArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LCT$74, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfLCTArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LCT$74);
    } 
  }
  
  public void setLCTArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, LCT$74);
    } 
  }
  
  public void setLCTArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LCT$74, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetLCTArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, LCT$74);
    } 
  }
  
  public void xsetLCTArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LCT$74, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertLCT(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LCT$74, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addLCT(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LCT$74);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewLCT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(LCT$74, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewLCT() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(LCT$74);
      return xmlString;
    } 
  }
  
  public void removeLCT(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LCT$74, paramInt);
    } 
  }
  
  public List<String> getListItemList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new ListItemList(this);
    } 
  }
  
  public String[] getListItemArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(LISTITEM$76, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getListItemArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LISTITEM$76, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetListItemList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new ListItemList(this);
    } 
  }
  
  public XmlString[] xgetListItemArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(LISTITEM$76, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetListItemArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LISTITEM$76, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfListItemArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(LISTITEM$76);
    } 
  }
  
  public void setListItemArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, LISTITEM$76);
    } 
  }
  
  public void setListItemArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(LISTITEM$76, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetListItemArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, LISTITEM$76);
    } 
  }
  
  public void xsetListItemArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(LISTITEM$76, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertListItem(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(LISTITEM$76, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addListItem(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(LISTITEM$76);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewListItem(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(LISTITEM$76, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewListItem() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(LISTITEM$76);
      return xmlString;
    } 
  }
  
  public void removeListItem(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LISTITEM$76, paramInt);
    } 
  }
  
  public List<String> getDropStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new DropStyleList(this);
    } 
  }
  
  public String[] getDropStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DROPSTYLE$78, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getDropStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DROPSTYLE$78, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetDropStyleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new DropStyleList(this);
    } 
  }
  
  public XmlString[] xgetDropStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DROPSTYLE$78, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetDropStyleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DROPSTYLE$78, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfDropStyleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DROPSTYLE$78);
    } 
  }
  
  public void setDropStyleArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, DROPSTYLE$78);
    } 
  }
  
  public void setDropStyleArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DROPSTYLE$78, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDropStyleArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, DROPSTYLE$78);
    } 
  }
  
  public void xsetDropStyleArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DROPSTYLE$78, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertDropStyle(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DROPSTYLE$78, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addDropStyle(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DROPSTYLE$78);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewDropStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(DROPSTYLE$78, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewDropStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(DROPSTYLE$78);
      return xmlString;
    } 
  }
  
  public void removeDropStyle(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DROPSTYLE$78, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getColoredList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new ColoredList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getColoredArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(COLORED$80, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getColoredArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLORED$80, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetColoredList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new ColoredList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetColoredArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(COLORED$80, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetColoredArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(COLORED$80, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfColoredArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(COLORED$80);
    } 
  }
  
  public void setColoredArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, COLORED$80);
    } 
  }
  
  public void setColoredArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLORED$80, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetColoredArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, COLORED$80);
    } 
  }
  
  public void xsetColoredArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(COLORED$80, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertColored(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(COLORED$80, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addColored(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(COLORED$80);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewColored(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(COLORED$80, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewColored() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(COLORED$80);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeColored(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLORED$80, paramInt);
    } 
  }
  
  public List<BigInteger> getDropLinesList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new DropLinesList(this);
    } 
  }
  
  public BigInteger[] getDropLinesArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DROPLINES$82, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getDropLinesArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DROPLINES$82, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetDropLinesList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new DropLinesList(this);
    } 
  }
  
  public XmlInteger[] xgetDropLinesArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DROPLINES$82, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetDropLinesArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(DROPLINES$82, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfDropLinesArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DROPLINES$82);
    } 
  }
  
  public void setDropLinesArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, DROPLINES$82);
    } 
  }
  
  public void setDropLinesArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DROPLINES$82, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDropLinesArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, DROPLINES$82);
    } 
  }
  
  public void xsetDropLinesArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(DROPLINES$82, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertDropLines(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DROPLINES$82, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addDropLines(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DROPLINES$82);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewDropLines(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(DROPLINES$82, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewDropLines() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(DROPLINES$82);
      return xmlInteger;
    } 
  }
  
  public void removeDropLines(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DROPLINES$82, paramInt);
    } 
  }
  
  public List<BigInteger> getCheckedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new CheckedList(this);
    } 
  }
  
  public BigInteger[] getCheckedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CHECKED$84, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getCheckedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHECKED$84, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetCheckedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new CheckedList(this);
    } 
  }
  
  public XmlInteger[] xgetCheckedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CHECKED$84, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetCheckedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(CHECKED$84, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfCheckedArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CHECKED$84);
    } 
  }
  
  public void setCheckedArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, CHECKED$84);
    } 
  }
  
  public void setCheckedArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CHECKED$84, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetCheckedArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, CHECKED$84);
    } 
  }
  
  public void xsetCheckedArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(CHECKED$84, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertChecked(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CHECKED$84, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addChecked(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CHECKED$84);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewChecked(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(CHECKED$84, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewChecked() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(CHECKED$84);
      return xmlInteger;
    } 
  }
  
  public void removeChecked(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CHECKED$84, paramInt);
    } 
  }
  
  public List<String> getFmlaLinkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaLinkList(this);
    } 
  }
  
  public String[] getFmlaLinkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLALINK$86, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaLinkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLALINK$86, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaLinkList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaLinkList(this);
    } 
  }
  
  public XmlString[] xgetFmlaLinkArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLALINK$86, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaLinkArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLALINK$86, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaLinkArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLALINK$86);
    } 
  }
  
  public void setFmlaLinkArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLALINK$86);
    } 
  }
  
  public void setFmlaLinkArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLALINK$86, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaLinkArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLALINK$86);
    } 
  }
  
  public void xsetFmlaLinkArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLALINK$86, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaLink(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLALINK$86, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaLink(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLALINK$86);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaLink(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLALINK$86, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaLink() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLALINK$86);
      return xmlString;
    } 
  }
  
  public void removeFmlaLink(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLALINK$86, paramInt);
    } 
  }
  
  public List<String> getFmlaPictList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaPictList(this);
    } 
  }
  
  public String[] getFmlaPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAPICT$88, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaPictArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAPICT$88, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaPictList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaPictList(this);
    } 
  }
  
  public XmlString[] xgetFmlaPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAPICT$88, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaPictArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAPICT$88, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaPictArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLAPICT$88);
    } 
  }
  
  public void setFmlaPictArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLAPICT$88);
    } 
  }
  
  public void setFmlaPictArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAPICT$88, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaPictArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLAPICT$88);
    } 
  }
  
  public void xsetFmlaPictArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAPICT$88, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaPict(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLAPICT$88, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaPict(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLAPICT$88);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaPict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLAPICT$88, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaPict() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLAPICT$88);
      return xmlString;
    } 
  }
  
  public void removeFmlaPict(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLAPICT$88, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getNoThreeDList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new NoThreeDList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getNoThreeDArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(NOTHREED$90, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getNoThreeDArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTHREED$90, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetNoThreeDList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new NoThreeDList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetNoThreeDArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(NOTHREED$90, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetNoThreeDArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(NOTHREED$90, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfNoThreeDArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(NOTHREED$90);
    } 
  }
  
  public void setNoThreeDArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, NOTHREED$90);
    } 
  }
  
  public void setNoThreeDArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(NOTHREED$90, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetNoThreeDArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, NOTHREED$90);
    } 
  }
  
  public void xsetNoThreeDArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(NOTHREED$90, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertNoThreeD(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(NOTHREED$90, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addNoThreeD(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(NOTHREED$90);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewNoThreeD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(NOTHREED$90, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewNoThreeD() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(NOTHREED$90);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeNoThreeD(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NOTHREED$90, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getFirstButtonList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new FirstButtonList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getFirstButtonArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FIRSTBUTTON$92, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getFirstButtonArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTBUTTON$92, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetFirstButtonList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new FirstButtonList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetFirstButtonArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FIRSTBUTTON$92, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetFirstButtonArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(FIRSTBUTTON$92, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfFirstButtonArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FIRSTBUTTON$92);
    } 
  }
  
  public void setFirstButtonArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, FIRSTBUTTON$92);
    } 
  }
  
  public void setFirstButtonArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FIRSTBUTTON$92, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFirstButtonArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, FIRSTBUTTON$92);
    } 
  }
  
  public void xsetFirstButtonArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(FIRSTBUTTON$92, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertFirstButton(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FIRSTBUTTON$92, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addFirstButton(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FIRSTBUTTON$92);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewFirstButton(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(FIRSTBUTTON$92, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewFirstButton() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(FIRSTBUTTON$92);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeFirstButton(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FIRSTBUTTON$92, paramInt);
    } 
  }
  
  public List<String> getFmlaGroupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaGroupList(this);
    } 
  }
  
  public String[] getFmlaGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAGROUP$94, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaGroupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAGROUP$94, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaGroupList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaGroupList(this);
    } 
  }
  
  public XmlString[] xgetFmlaGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLAGROUP$94, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaGroupArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAGROUP$94, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaGroupArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLAGROUP$94);
    } 
  }
  
  public void setFmlaGroupArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLAGROUP$94);
    } 
  }
  
  public void setFmlaGroupArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLAGROUP$94, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaGroupArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLAGROUP$94);
    } 
  }
  
  public void xsetFmlaGroupArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLAGROUP$94, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaGroup(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLAGROUP$94, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaGroup(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLAGROUP$94);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLAGROUP$94, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaGroup() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLAGROUP$94);
      return xmlString;
    } 
  }
  
  public void removeFmlaGroup(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLAGROUP$94, paramInt);
    } 
  }
  
  public List<BigInteger> getValList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new ValList(this);
    } 
  }
  
  public BigInteger[] getValArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(VAL$96, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getValArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VAL$96, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetValList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new ValList(this);
    } 
  }
  
  public XmlInteger[] xgetValArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(VAL$96, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetValArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(VAL$96, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfValArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(VAL$96);
    } 
  }
  
  public void setValArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, VAL$96);
    } 
  }
  
  public void setValArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VAL$96, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetValArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, VAL$96);
    } 
  }
  
  public void xsetValArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(VAL$96, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertVal(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(VAL$96, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addVal(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(VAL$96);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewVal(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(VAL$96, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewVal() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(VAL$96);
      return xmlInteger;
    } 
  }
  
  public void removeVal(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(VAL$96, paramInt);
    } 
  }
  
  public List<BigInteger> getMinList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new MinList(this);
    } 
  }
  
  public BigInteger[] getMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MIN$98, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getMinArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MIN$98, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetMinList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new MinList(this);
    } 
  }
  
  public XmlInteger[] xgetMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MIN$98, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetMinArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(MIN$98, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfMinArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MIN$98);
    } 
  }
  
  public void setMinArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, MIN$98);
    } 
  }
  
  public void setMinArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MIN$98, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetMinArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, MIN$98);
    } 
  }
  
  public void xsetMinArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(MIN$98, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertMin(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MIN$98, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addMin(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MIN$98);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewMin(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(MIN$98, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewMin() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(MIN$98);
      return xmlInteger;
    } 
  }
  
  public void removeMin(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MIN$98, paramInt);
    } 
  }
  
  public List<BigInteger> getMaxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new MaxList(this);
    } 
  }
  
  public BigInteger[] getMaxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MAX$100, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getMaxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MAX$100, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetMaxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new MaxList(this);
    } 
  }
  
  public XmlInteger[] xgetMaxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MAX$100, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetMaxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(MAX$100, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfMaxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MAX$100);
    } 
  }
  
  public void setMaxArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, MAX$100);
    } 
  }
  
  public void setMaxArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MAX$100, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetMaxArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, MAX$100);
    } 
  }
  
  public void xsetMaxArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(MAX$100, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertMax(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MAX$100, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addMax(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MAX$100);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewMax(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(MAX$100, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewMax() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(MAX$100);
      return xmlInteger;
    } 
  }
  
  public void removeMax(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAX$100, paramInt);
    } 
  }
  
  public List<BigInteger> getIncList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new IncList(this);
    } 
  }
  
  public BigInteger[] getIncArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(INC$102, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getIncArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(INC$102, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetIncList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new IncList(this);
    } 
  }
  
  public XmlInteger[] xgetIncArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(INC$102, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetIncArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(INC$102, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfIncArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(INC$102);
    } 
  }
  
  public void setIncArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, INC$102);
    } 
  }
  
  public void setIncArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(INC$102, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetIncArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, INC$102);
    } 
  }
  
  public void xsetIncArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(INC$102, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertInc(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(INC$102, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addInc(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(INC$102);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewInc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(INC$102, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewInc() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(INC$102);
      return xmlInteger;
    } 
  }
  
  public void removeInc(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(INC$102, paramInt);
    } 
  }
  
  public List<BigInteger> getPageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new PageList(this);
    } 
  }
  
  public BigInteger[] getPageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(PAGE$104, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getPageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PAGE$104, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetPageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new PageList(this);
    } 
  }
  
  public XmlInteger[] xgetPageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PAGE$104, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetPageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(PAGE$104, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfPageArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PAGE$104);
    } 
  }
  
  public void setPageArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, PAGE$104);
    } 
  }
  
  public void setPageArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(PAGE$104, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetPageArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, PAGE$104);
    } 
  }
  
  public void xsetPageArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(PAGE$104, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertPage(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(PAGE$104, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addPage(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(PAGE$104);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewPage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(PAGE$104, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(PAGE$104);
      return xmlInteger;
    } 
  }
  
  public void removePage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGE$104, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getHorizList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new HorizList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getHorizArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(HORIZ$106, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getHorizArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HORIZ$106, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetHorizList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new HorizList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetHorizArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(HORIZ$106, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetHorizArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(HORIZ$106, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfHorizArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(HORIZ$106);
    } 
  }
  
  public void setHorizArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, HORIZ$106);
    } 
  }
  
  public void setHorizArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HORIZ$106, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHorizArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, HORIZ$106);
    } 
  }
  
  public void xsetHorizArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(HORIZ$106, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertHoriz(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(HORIZ$106, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addHoriz(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(HORIZ$106);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewHoriz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(HORIZ$106, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewHoriz() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(HORIZ$106);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeHoriz(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HORIZ$106, paramInt);
    } 
  }
  
  public List<BigInteger> getDxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new DxList(this);
    } 
  }
  
  public BigInteger[] getDxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DX$108, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getDxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DX$108, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlInteger> xgetDxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlInteger>)new DxList(this);
    } 
  }
  
  public XmlInteger[] xgetDxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DX$108, arrayList);
      XmlInteger[] arrayOfXmlInteger = new XmlInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlInteger);
      return arrayOfXmlInteger;
    } 
  }
  
  public XmlInteger xgetDxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(DX$108, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlInteger;
    } 
  }
  
  public int sizeOfDxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DX$108);
    } 
  }
  
  public void setDxArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, DX$108);
    } 
  }
  
  public void setDxArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DX$108, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetDxArray(XmlInteger[] paramArrayOfXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlInteger, DX$108);
    } 
  }
  
  public void xsetDxArray(int paramInt, XmlInteger paramXmlInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().find_element_user(DX$108, paramInt);
      if (xmlInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlInteger.set((XmlObject)paramXmlInteger);
    } 
  }
  
  public void insertDx(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DX$108, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addDx(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DX$108);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlInteger insertNewDx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().insert_element_user(DX$108, paramInt);
      return xmlInteger;
    } 
  }
  
  public XmlInteger addNewDx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInteger xmlInteger = null;
      xmlInteger = (XmlInteger)get_store().add_element_user(DX$108);
      return xmlInteger;
    } 
  }
  
  public void removeDx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DX$108, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getMapOCXList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new MapOCXList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getMapOCXArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(MAPOCX$110, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getMapOCXArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MAPOCX$110, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetMapOCXList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new MapOCXList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetMapOCXArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(MAPOCX$110, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetMapOCXArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MAPOCX$110, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfMapOCXArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(MAPOCX$110);
    } 
  }
  
  public void setMapOCXArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, MAPOCX$110);
    } 
  }
  
  public void setMapOCXArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MAPOCX$110, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetMapOCXArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, MAPOCX$110);
    } 
  }
  
  public void xsetMapOCXArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(MAPOCX$110, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertMapOCX(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(MAPOCX$110, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addMapOCX(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(MAPOCX$110);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewMapOCX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(MAPOCX$110, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewMapOCX() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(MAPOCX$110);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeMapOCX(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAPOCX$110, paramInt);
    } 
  }
  
  public List<STCF.Enum> getCFList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STCF.Enum>)new CFList(this);
    } 
  }
  
  public STCF.Enum[] getCFArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CF$112, arrayList);
      STCF.Enum[] arrayOfEnum = new STCF.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STCF.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STCF.Enum getCFArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CF$112, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STCF.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STCF> xgetCFList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STCF>)new CFList(this);
    } 
  }
  
  public STCF[] xgetCFArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CF$112, arrayList);
      STCF[] arrayOfSTCF = new STCF[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTCF);
      return arrayOfSTCF;
    } 
  }
  
  public STCF xgetCFArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STCF sTCF = null;
      sTCF = (STCF)get_store().find_element_user(CF$112, paramInt);
      if (sTCF == null)
        throw new IndexOutOfBoundsException(); 
      return sTCF;
    } 
  }
  
  public int sizeOfCFArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CF$112);
    } 
  }
  
  public void setCFArray(STCF.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, CF$112);
    } 
  }
  
  public void setCFArray(int paramInt, STCF.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CF$112, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCFArray(STCF[] paramArrayOfSTCF) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTCF, CF$112);
    } 
  }
  
  public void xsetCFArray(int paramInt, STCF paramSTCF) {
    synchronized (monitor()) {
      check_orphaned();
      STCF sTCF = null;
      sTCF = (STCF)get_store().find_element_user(CF$112, paramInt);
      if (sTCF == null)
        throw new IndexOutOfBoundsException(); 
      sTCF.set((XmlObject)paramSTCF);
    } 
  }
  
  public void insertCF(int paramInt, STCF.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CF$112, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addCF(STCF.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CF$112);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STCF insertNewCF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STCF sTCF = null;
      sTCF = (STCF)get_store().insert_element_user(CF$112, paramInt);
      return sTCF;
    } 
  }
  
  public STCF addNewCF() {
    synchronized (monitor()) {
      check_orphaned();
      STCF sTCF = null;
      sTCF = (STCF)get_store().add_element_user(CF$112);
      return sTCF;
    } 
  }
  
  public void removeCF(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CF$112, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getCameraList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new CameraList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getCameraArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(CAMERA$114, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getCameraArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CAMERA$114, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetCameraList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new CameraList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetCameraArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(CAMERA$114, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetCameraArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(CAMERA$114, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfCameraArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(CAMERA$114);
    } 
  }
  
  public void setCameraArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, CAMERA$114);
    } 
  }
  
  public void setCameraArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(CAMERA$114, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCameraArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, CAMERA$114);
    } 
  }
  
  public void xsetCameraArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(CAMERA$114, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertCamera(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(CAMERA$114, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addCamera(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(CAMERA$114);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewCamera(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(CAMERA$114, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewCamera() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(CAMERA$114);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeCamera(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CAMERA$114, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getRecalcAlwaysList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new RecalcAlwaysList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getRecalcAlwaysArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(RECALCALWAYS$116, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getRecalcAlwaysArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(RECALCALWAYS$116, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetRecalcAlwaysList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new RecalcAlwaysList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetRecalcAlwaysArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(RECALCALWAYS$116, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetRecalcAlwaysArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(RECALCALWAYS$116, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfRecalcAlwaysArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(RECALCALWAYS$116);
    } 
  }
  
  public void setRecalcAlwaysArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, RECALCALWAYS$116);
    } 
  }
  
  public void setRecalcAlwaysArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(RECALCALWAYS$116, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRecalcAlwaysArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, RECALCALWAYS$116);
    } 
  }
  
  public void xsetRecalcAlwaysArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(RECALCALWAYS$116, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertRecalcAlways(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(RECALCALWAYS$116, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addRecalcAlways(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(RECALCALWAYS$116);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewRecalcAlways(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(RECALCALWAYS$116, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewRecalcAlways() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(RECALCALWAYS$116);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeRecalcAlways(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RECALCALWAYS$116, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getAutoScaleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new AutoScaleList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getAutoScaleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOSCALE$118, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getAutoScaleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOSCALE$118, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetAutoScaleList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new AutoScaleList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetAutoScaleArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(AUTOSCALE$118, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetAutoScaleArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOSCALE$118, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfAutoScaleArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(AUTOSCALE$118);
    } 
  }
  
  public void setAutoScaleArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, AUTOSCALE$118);
    } 
  }
  
  public void setAutoScaleArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(AUTOSCALE$118, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAutoScaleArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, AUTOSCALE$118);
    } 
  }
  
  public void xsetAutoScaleArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(AUTOSCALE$118, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertAutoScale(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(AUTOSCALE$118, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addAutoScale(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(AUTOSCALE$118);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewAutoScale(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(AUTOSCALE$118, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewAutoScale() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(AUTOSCALE$118);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeAutoScale(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOSCALE$118, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getDDEList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new DDEList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getDDEArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(DDE$120, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getDDEArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DDE$120, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetDDEList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new DDEList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetDDEArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(DDE$120, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetDDEArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DDE$120, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfDDEArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(DDE$120);
    } 
  }
  
  public void setDDEArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, DDE$120);
    } 
  }
  
  public void setDDEArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DDE$120, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDDEArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, DDE$120);
    } 
  }
  
  public void xsetDDEArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(DDE$120, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertDDE(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(DDE$120, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addDDE(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(DDE$120);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewDDE(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(DDE$120, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewDDE() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(DDE$120);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeDDE(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DDE$120, paramInt);
    } 
  }
  
  public List<STTrueFalseBlank.Enum> getUIObjList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank.Enum>)new UIObjList(this);
    } 
  }
  
  public STTrueFalseBlank.Enum[] getUIObjArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(UIOBJ$122, arrayList);
      STTrueFalseBlank.Enum[] arrayOfEnum = new STTrueFalseBlank.Enum[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfEnum[b1] = (STTrueFalseBlank.Enum)((SimpleValue)arrayList.get(b1)).getEnumValue();
        b1++;
      } 
      return arrayOfEnum;
    } 
  }
  
  public STTrueFalseBlank.Enum getUIObjArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UIOBJ$122, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return (STTrueFalseBlank.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public List<STTrueFalseBlank> xgetUIObjList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<STTrueFalseBlank>)new UIObjList(this);
    } 
  }
  
  public STTrueFalseBlank[] xgetUIObjArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(UIOBJ$122, arrayList);
      STTrueFalseBlank[] arrayOfSTTrueFalseBlank = new STTrueFalseBlank[arrayList.size()];
      arrayList.toArray((Object[])arrayOfSTTrueFalseBlank);
      return arrayOfSTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank xgetUIObjArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(UIOBJ$122, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      return sTTrueFalseBlank;
    } 
  }
  
  public int sizeOfUIObjArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(UIOBJ$122);
    } 
  }
  
  public void setUIObjArray(STTrueFalseBlank.Enum[] paramArrayOfEnum) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((StringEnumAbstractBase[])paramArrayOfEnum, UIOBJ$122);
    } 
  }
  
  public void setUIObjArray(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(UIOBJ$122, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUIObjArray(STTrueFalseBlank[] paramArrayOfSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfSTTrueFalseBlank, UIOBJ$122);
    } 
  }
  
  public void xsetUIObjArray(int paramInt, STTrueFalseBlank paramSTTrueFalseBlank) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().find_element_user(UIOBJ$122, paramInt);
      if (sTTrueFalseBlank == null)
        throw new IndexOutOfBoundsException(); 
      sTTrueFalseBlank.set((XmlObject)paramSTTrueFalseBlank);
    } 
  }
  
  public void insertUIObj(int paramInt, STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(UIOBJ$122, paramInt);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void addUIObj(STTrueFalseBlank.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(UIOBJ$122);
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public STTrueFalseBlank insertNewUIObj(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().insert_element_user(UIOBJ$122, paramInt);
      return sTTrueFalseBlank;
    } 
  }
  
  public STTrueFalseBlank addNewUIObj() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalseBlank sTTrueFalseBlank = null;
      sTTrueFalseBlank = (STTrueFalseBlank)get_store().add_element_user(UIOBJ$122);
      return sTTrueFalseBlank;
    } 
  }
  
  public void removeUIObj(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UIOBJ$122, paramInt);
    } 
  }
  
  public List<String> getScriptTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new ScriptTextList(this);
    } 
  }
  
  public String[] getScriptTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTTEXT$124, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getScriptTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTTEXT$124, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetScriptTextList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new ScriptTextList(this);
    } 
  }
  
  public XmlString[] xgetScriptTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTTEXT$124, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetScriptTextArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SCRIPTTEXT$124, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfScriptTextArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCRIPTTEXT$124);
    } 
  }
  
  public void setScriptTextArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, SCRIPTTEXT$124);
    } 
  }
  
  public void setScriptTextArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTTEXT$124, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetScriptTextArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, SCRIPTTEXT$124);
    } 
  }
  
  public void xsetScriptTextArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SCRIPTTEXT$124, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertScriptText(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SCRIPTTEXT$124, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addScriptText(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SCRIPTTEXT$124);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewScriptText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(SCRIPTTEXT$124, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewScriptText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(SCRIPTTEXT$124);
      return xmlString;
    } 
  }
  
  public void removeScriptText(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRIPTTEXT$124, paramInt);
    } 
  }
  
  public List<String> getScriptExtendedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new ScriptExtendedList(this);
    } 
  }
  
  public String[] getScriptExtendedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTEXTENDED$126, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getScriptExtendedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTEXTENDED$126, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetScriptExtendedList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new ScriptExtendedList(this);
    } 
  }
  
  public XmlString[] xgetScriptExtendedArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTEXTENDED$126, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetScriptExtendedArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SCRIPTEXTENDED$126, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfScriptExtendedArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCRIPTEXTENDED$126);
    } 
  }
  
  public void setScriptExtendedArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, SCRIPTEXTENDED$126);
    } 
  }
  
  public void setScriptExtendedArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTEXTENDED$126, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetScriptExtendedArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, SCRIPTEXTENDED$126);
    } 
  }
  
  public void xsetScriptExtendedArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(SCRIPTEXTENDED$126, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertScriptExtended(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SCRIPTEXTENDED$126, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addScriptExtended(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SCRIPTEXTENDED$126);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewScriptExtended(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(SCRIPTEXTENDED$126, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewScriptExtended() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(SCRIPTEXTENDED$126);
      return xmlString;
    } 
  }
  
  public void removeScriptExtended(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRIPTEXTENDED$126, paramInt);
    } 
  }
  
  public List<BigInteger> getScriptLanguageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new ScriptLanguageList(this);
    } 
  }
  
  public BigInteger[] getScriptLanguageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTLANGUAGE$128, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getScriptLanguageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTLANGUAGE$128, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlNonNegativeInteger> xgetScriptLanguageList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlNonNegativeInteger>)new ScriptLanguageList(this);
    } 
  }
  
  public XmlNonNegativeInteger[] xgetScriptLanguageArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTLANGUAGE$128, arrayList);
      XmlNonNegativeInteger[] arrayOfXmlNonNegativeInteger = new XmlNonNegativeInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlNonNegativeInteger);
      return arrayOfXmlNonNegativeInteger;
    } 
  }
  
  public XmlNonNegativeInteger xgetScriptLanguageArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_element_user(SCRIPTLANGUAGE$128, paramInt);
      if (xmlNonNegativeInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlNonNegativeInteger;
    } 
  }
  
  public int sizeOfScriptLanguageArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCRIPTLANGUAGE$128);
    } 
  }
  
  public void setScriptLanguageArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, SCRIPTLANGUAGE$128);
    } 
  }
  
  public void setScriptLanguageArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTLANGUAGE$128, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetScriptLanguageArray(XmlNonNegativeInteger[] paramArrayOfXmlNonNegativeInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlNonNegativeInteger, SCRIPTLANGUAGE$128);
    } 
  }
  
  public void xsetScriptLanguageArray(int paramInt, XmlNonNegativeInteger paramXmlNonNegativeInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_element_user(SCRIPTLANGUAGE$128, paramInt);
      if (xmlNonNegativeInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlNonNegativeInteger.set((XmlObject)paramXmlNonNegativeInteger);
    } 
  }
  
  public void insertScriptLanguage(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SCRIPTLANGUAGE$128, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addScriptLanguage(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SCRIPTLANGUAGE$128);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlNonNegativeInteger insertNewScriptLanguage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().insert_element_user(SCRIPTLANGUAGE$128, paramInt);
      return xmlNonNegativeInteger;
    } 
  }
  
  public XmlNonNegativeInteger addNewScriptLanguage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().add_element_user(SCRIPTLANGUAGE$128);
      return xmlNonNegativeInteger;
    } 
  }
  
  public void removeScriptLanguage(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRIPTLANGUAGE$128, paramInt);
    } 
  }
  
  public List<BigInteger> getScriptLocationList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<BigInteger>)new ScriptLocationList(this);
    } 
  }
  
  public BigInteger[] getScriptLocationArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTLOCATION$130, arrayList);
      BigInteger[] arrayOfBigInteger = new BigInteger[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfBigInteger[b1] = ((SimpleValue)arrayList.get(b1)).getBigIntegerValue();
        b1++;
      } 
      return arrayOfBigInteger;
    } 
  }
  
  public BigInteger getScriptLocationArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTLOCATION$130, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public List<XmlNonNegativeInteger> xgetScriptLocationList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlNonNegativeInteger>)new ScriptLocationList(this);
    } 
  }
  
  public XmlNonNegativeInteger[] xgetScriptLocationArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(SCRIPTLOCATION$130, arrayList);
      XmlNonNegativeInteger[] arrayOfXmlNonNegativeInteger = new XmlNonNegativeInteger[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlNonNegativeInteger);
      return arrayOfXmlNonNegativeInteger;
    } 
  }
  
  public XmlNonNegativeInteger xgetScriptLocationArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_element_user(SCRIPTLOCATION$130, paramInt);
      if (xmlNonNegativeInteger == null)
        throw new IndexOutOfBoundsException(); 
      return xmlNonNegativeInteger;
    } 
  }
  
  public int sizeOfScriptLocationArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(SCRIPTLOCATION$130);
    } 
  }
  
  public void setScriptLocationArray(BigInteger[] paramArrayOfBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfBigInteger, SCRIPTLOCATION$130);
    } 
  }
  
  public void setScriptLocationArray(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SCRIPTLOCATION$130, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetScriptLocationArray(XmlNonNegativeInteger[] paramArrayOfXmlNonNegativeInteger) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlNonNegativeInteger, SCRIPTLOCATION$130);
    } 
  }
  
  public void xsetScriptLocationArray(int paramInt, XmlNonNegativeInteger paramXmlNonNegativeInteger) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_element_user(SCRIPTLOCATION$130, paramInt);
      if (xmlNonNegativeInteger == null)
        throw new IndexOutOfBoundsException(); 
      xmlNonNegativeInteger.set((XmlObject)paramXmlNonNegativeInteger);
    } 
  }
  
  public void insertScriptLocation(int paramInt, BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SCRIPTLOCATION$130, paramInt);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void addScriptLocation(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(SCRIPTLOCATION$130);
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public XmlNonNegativeInteger insertNewScriptLocation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().insert_element_user(SCRIPTLOCATION$130, paramInt);
      return xmlNonNegativeInteger;
    } 
  }
  
  public XmlNonNegativeInteger addNewScriptLocation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlNonNegativeInteger xmlNonNegativeInteger = null;
      xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().add_element_user(SCRIPTLOCATION$130);
      return xmlNonNegativeInteger;
    } 
  }
  
  public void removeScriptLocation(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SCRIPTLOCATION$130, paramInt);
    } 
  }
  
  public List<String> getFmlaTxbxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<String>)new FmlaTxbxList(this);
    } 
  }
  
  public String[] getFmlaTxbxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList<SimpleValue> arrayList = new ArrayList();
      get_store().find_all_element_users(FMLATXBX$132, arrayList);
      String[] arrayOfString = new String[arrayList.size()];
      byte b1 = 0;
      int i = arrayList.size();
      while (b1 < i) {
        arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue();
        b1++;
      } 
      return arrayOfString;
    } 
  }
  
  public String getFmlaTxbxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLATXBX$132, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      return simpleValue.getStringValue();
    } 
  }
  
  public List<XmlString> xgetFmlaTxbxList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<XmlString>)new FmlaTxbxList(this);
    } 
  }
  
  public XmlString[] xgetFmlaTxbxArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FMLATXBX$132, arrayList);
      XmlString[] arrayOfXmlString = new XmlString[arrayList.size()];
      arrayList.toArray((Object[])arrayOfXmlString);
      return arrayOfXmlString;
    } 
  }
  
  public XmlString xgetFmlaTxbxArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLATXBX$132, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      return xmlString;
    } 
  }
  
  public int sizeOfFmlaTxbxArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FMLATXBX$132);
    } 
  }
  
  public void setFmlaTxbxArray(String[] paramArrayOfString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper(paramArrayOfString, FMLATXBX$132);
    } 
  }
  
  public void setFmlaTxbxArray(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(FMLATXBX$132, paramInt);
      if (simpleValue == null)
        throw new IndexOutOfBoundsException(); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetFmlaTxbxArray(XmlString[] paramArrayOfXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfXmlString, FMLATXBX$132);
    } 
  }
  
  public void xsetFmlaTxbxArray(int paramInt, XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(FMLATXBX$132, paramInt);
      if (xmlString == null)
        throw new IndexOutOfBoundsException(); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void insertFmlaTxbx(int paramInt, String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(FMLATXBX$132, paramInt);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void addFmlaTxbx(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().add_element_user(FMLATXBX$132);
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public XmlString insertNewFmlaTxbx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().insert_element_user(FMLATXBX$132, paramInt);
      return xmlString;
    } 
  }
  
  public XmlString addNewFmlaTxbx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().add_element_user(FMLATXBX$132);
      return xmlString;
    } 
  }
  
  public void removeFmlaTxbx(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FMLATXBX$132, paramInt);
    } 
  }
  
  public STObjectType.Enum getObjectType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBJECTTYPE$134);
      if (simpleValue == null)
        return null; 
      return (STObjectType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STObjectType xgetObjectType() {
    synchronized (monitor()) {
      check_orphaned();
      STObjectType sTObjectType = null;
      sTObjectType = (STObjectType)get_store().find_attribute_user(OBJECTTYPE$134);
      return sTObjectType;
    } 
  }
  
  public void setObjectType(STObjectType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OBJECTTYPE$134);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OBJECTTYPE$134); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetObjectType(STObjectType paramSTObjectType) {
    synchronized (monitor()) {
      check_orphaned();
      STObjectType sTObjectType = null;
      sTObjectType = (STObjectType)get_store().find_attribute_user(OBJECTTYPE$134);
      if (sTObjectType == null)
        sTObjectType = (STObjectType)get_store().add_attribute_user(OBJECTTYPE$134); 
      sTObjectType.set((XmlObject)paramSTObjectType);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\excel\impl\CTClientDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */