package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.DataType;
import com.microsoft.schemas.office.visio.x2012.main.ForeignDataType;
import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import com.microsoft.schemas.office.visio.x2012.main.TextType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.XmlUnsignedInt;

public class ShapeSheetTypeImpl extends SheetTypeImpl implements ShapeSheetType {
  private static final b TEXT$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Text");
  
  private static final b DATA1$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Data1");
  
  private static final b DATA2$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Data2");
  
  private static final b DATA3$6 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Data3");
  
  private static final b FOREIGNDATA$8 = new b("http://schemas.microsoft.com/office/visio/2012/main", "ForeignData");
  
  private static final b SHAPES$10 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Shapes");
  
  private static final b ID$12 = new b("", "ID");
  
  private static final b ORIGINALID$14 = new b("", "OriginalID");
  
  private static final b DEL$16 = new b("", "Del");
  
  private static final b MASTERSHAPE$18 = new b("", "MasterShape");
  
  private static final b UNIQUEID$20 = new b("", "UniqueID");
  
  private static final b NAME$22 = new b("", "Name");
  
  private static final b NAMEU$24 = new b("", "NameU");
  
  private static final b ISCUSTOMNAME$26 = new b("", "IsCustomName");
  
  private static final b ISCUSTOMNAMEU$28 = new b("", "IsCustomNameU");
  
  private static final b MASTER$30 = new b("", "Master");
  
  private static final b TYPE$32 = new b("", "Type");
  
  public ShapeSheetTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public TextType getText() {
    synchronized (monitor()) {
      check_orphaned();
      TextType textType = null;
      textType = (TextType)get_store().find_element_user(TEXT$0, 0);
      if (textType == null)
        return null; 
      return textType;
    } 
  }
  
  public boolean isSetText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TEXT$0) != 0);
    } 
  }
  
  public void setText(TextType paramTextType) {
    synchronized (monitor()) {
      check_orphaned();
      TextType textType = null;
      textType = (TextType)get_store().find_element_user(TEXT$0, 0);
      if (textType == null)
        textType = (TextType)get_store().add_element_user(TEXT$0); 
      textType.set((XmlObject)paramTextType);
    } 
  }
  
  public TextType addNewText() {
    synchronized (monitor()) {
      check_orphaned();
      TextType textType = null;
      textType = (TextType)get_store().add_element_user(TEXT$0);
      return textType;
    } 
  }
  
  public void unsetText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TEXT$0, 0);
    } 
  }
  
  public DataType getData1() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA1$2, 0);
      if (dataType == null)
        return null; 
      return dataType;
    } 
  }
  
  public boolean isSetData1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATA1$2) != 0);
    } 
  }
  
  public void setData1(DataType paramDataType) {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA1$2, 0);
      if (dataType == null)
        dataType = (DataType)get_store().add_element_user(DATA1$2); 
      dataType.set((XmlObject)paramDataType);
    } 
  }
  
  public DataType addNewData1() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().add_element_user(DATA1$2);
      return dataType;
    } 
  }
  
  public void unsetData1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATA1$2, 0);
    } 
  }
  
  public DataType getData2() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA2$4, 0);
      if (dataType == null)
        return null; 
      return dataType;
    } 
  }
  
  public boolean isSetData2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATA2$4) != 0);
    } 
  }
  
  public void setData2(DataType paramDataType) {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA2$4, 0);
      if (dataType == null)
        dataType = (DataType)get_store().add_element_user(DATA2$4); 
      dataType.set((XmlObject)paramDataType);
    } 
  }
  
  public DataType addNewData2() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().add_element_user(DATA2$4);
      return dataType;
    } 
  }
  
  public void unsetData2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATA2$4, 0);
    } 
  }
  
  public DataType getData3() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA3$6, 0);
      if (dataType == null)
        return null; 
      return dataType;
    } 
  }
  
  public boolean isSetData3() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DATA3$6) != 0);
    } 
  }
  
  public void setData3(DataType paramDataType) {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().find_element_user(DATA3$6, 0);
      if (dataType == null)
        dataType = (DataType)get_store().add_element_user(DATA3$6); 
      dataType.set((XmlObject)paramDataType);
    } 
  }
  
  public DataType addNewData3() {
    synchronized (monitor()) {
      check_orphaned();
      DataType dataType = null;
      dataType = (DataType)get_store().add_element_user(DATA3$6);
      return dataType;
    } 
  }
  
  public void unsetData3() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DATA3$6, 0);
    } 
  }
  
  public ForeignDataType getForeignData() {
    synchronized (monitor()) {
      check_orphaned();
      ForeignDataType foreignDataType = null;
      foreignDataType = (ForeignDataType)get_store().find_element_user(FOREIGNDATA$8, 0);
      if (foreignDataType == null)
        return null; 
      return foreignDataType;
    } 
  }
  
  public boolean isSetForeignData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FOREIGNDATA$8) != 0);
    } 
  }
  
  public void setForeignData(ForeignDataType paramForeignDataType) {
    synchronized (monitor()) {
      check_orphaned();
      ForeignDataType foreignDataType = null;
      foreignDataType = (ForeignDataType)get_store().find_element_user(FOREIGNDATA$8, 0);
      if (foreignDataType == null)
        foreignDataType = (ForeignDataType)get_store().add_element_user(FOREIGNDATA$8); 
      foreignDataType.set((XmlObject)paramForeignDataType);
    } 
  }
  
  public ForeignDataType addNewForeignData() {
    synchronized (monitor()) {
      check_orphaned();
      ForeignDataType foreignDataType = null;
      foreignDataType = (ForeignDataType)get_store().add_element_user(FOREIGNDATA$8);
      return foreignDataType;
    } 
  }
  
  public void unsetForeignData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FOREIGNDATA$8, 0);
    } 
  }
  
  public ShapesType getShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().find_element_user(SHAPES$10, 0);
      if (shapesType == null)
        return null; 
      return shapesType;
    } 
  }
  
  public boolean isSetShapes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SHAPES$10) != 0);
    } 
  }
  
  public void setShapes(ShapesType paramShapesType) {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().find_element_user(SHAPES$10, 0);
      if (shapesType == null)
        shapesType = (ShapesType)get_store().add_element_user(SHAPES$10); 
      shapesType.set((XmlObject)paramShapesType);
    } 
  }
  
  public ShapesType addNewShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ShapesType shapesType = null;
      shapesType = (ShapesType)get_store().add_element_user(SHAPES$10);
      return shapesType;
    } 
  }
  
  public void unsetShapes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SHAPES$10, 0);
    } 
  }
  
  public long getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$12);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$12);
      return xmlUnsignedInt;
    } 
  }
  
  public void setID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$12); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$12);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$12); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public long getOriginalID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGINALID$14);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetOriginalID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ORIGINALID$14);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetOriginalID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ORIGINALID$14) != null);
    } 
  }
  
  public void setOriginalID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGINALID$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ORIGINALID$14); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetOriginalID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ORIGINALID$14);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ORIGINALID$14); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetOriginalID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ORIGINALID$14);
    } 
  }
  
  public boolean getDel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL$16);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL$16);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEL$16) != null);
    } 
  }
  
  public void setDel(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEL$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDel(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEL$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEL$16);
    } 
  }
  
  public long getMasterShape() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTERSHAPE$18);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMasterShape() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MASTERSHAPE$18);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMasterShape() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MASTERSHAPE$18) != null);
    } 
  }
  
  public void setMasterShape(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTERSHAPE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MASTERSHAPE$18); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMasterShape(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MASTERSHAPE$18);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MASTERSHAPE$18); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMasterShape() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MASTERSHAPE$18);
    } 
  }
  
  public String getUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$20);
      return xmlString;
    } 
  }
  
  public boolean isSetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUEID$20) != null);
    } 
  }
  
  public void setUniqueID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUEID$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$20);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(UNIQUEID$20); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUEID$20);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$22);
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$22) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$22); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$22);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$22); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$22);
    } 
  }
  
  public String getNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$24);
      return xmlString;
    } 
  }
  
  public boolean isSetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAMEU$24) != null);
    } 
  }
  
  public void setNameU(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAMEU$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetNameU(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$24);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAMEU$24); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAMEU$24);
    } 
  }
  
  public boolean getIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$26);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$26);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAME$26) != null);
    } 
  }
  
  public void setIsCustomName(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAME$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomName(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAME$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAME$26);
    } 
  }
  
  public boolean getIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$28);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$28);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAMEU$28) != null);
    } 
  }
  
  public void setIsCustomNameU(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAMEU$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomNameU(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAMEU$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAMEU$28);
    } 
  }
  
  public long getMaster() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTER$30);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMaster() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MASTER$30);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMaster() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MASTER$30) != null);
    } 
  }
  
  public void setMaster(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTER$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MASTER$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMaster(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MASTER$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MASTER$30); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMaster() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MASTER$30);
    } 
  }
  
  public String getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$32);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlToken xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlToken xmlToken = null;
      xmlToken = (XmlToken)get_store().find_attribute_user(TYPE$32);
      return xmlToken;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$32) != null);
    } 
  }
  
  public void setType(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetType(XmlToken paramXmlToken) {
    synchronized (monitor()) {
      check_orphaned();
      XmlToken xmlToken = null;
      xmlToken = (XmlToken)get_store().find_attribute_user(TYPE$32);
      if (xmlToken == null)
        xmlToken = (XmlToken)get_store().add_attribute_user(TYPE$32); 
      xmlToken.set((XmlObject)paramXmlToken);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$32);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\ShapeSheetTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */