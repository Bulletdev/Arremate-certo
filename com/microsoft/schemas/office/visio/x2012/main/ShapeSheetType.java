package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface ShapeSheetType extends SheetType {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ShapeSheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("shapesheettype59bbtype");
  
  TextType getText();
  
  boolean isSetText();
  
  void setText(TextType paramTextType);
  
  TextType addNewText();
  
  void unsetText();
  
  DataType getData1();
  
  boolean isSetData1();
  
  void setData1(DataType paramDataType);
  
  DataType addNewData1();
  
  void unsetData1();
  
  DataType getData2();
  
  boolean isSetData2();
  
  void setData2(DataType paramDataType);
  
  DataType addNewData2();
  
  void unsetData2();
  
  DataType getData3();
  
  boolean isSetData3();
  
  void setData3(DataType paramDataType);
  
  DataType addNewData3();
  
  void unsetData3();
  
  ForeignDataType getForeignData();
  
  boolean isSetForeignData();
  
  void setForeignData(ForeignDataType paramForeignDataType);
  
  ForeignDataType addNewForeignData();
  
  void unsetForeignData();
  
  ShapesType getShapes();
  
  boolean isSetShapes();
  
  void setShapes(ShapesType paramShapesType);
  
  ShapesType addNewShapes();
  
  void unsetShapes();
  
  long getID();
  
  XmlUnsignedInt xgetID();
  
  void setID(long paramLong);
  
  void xsetID(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getOriginalID();
  
  XmlUnsignedInt xgetOriginalID();
  
  boolean isSetOriginalID();
  
  void setOriginalID(long paramLong);
  
  void xsetOriginalID(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetOriginalID();
  
  boolean getDel();
  
  XmlBoolean xgetDel();
  
  boolean isSetDel();
  
  void setDel(boolean paramBoolean);
  
  void xsetDel(XmlBoolean paramXmlBoolean);
  
  void unsetDel();
  
  long getMasterShape();
  
  XmlUnsignedInt xgetMasterShape();
  
  boolean isSetMasterShape();
  
  void setMasterShape(long paramLong);
  
  void xsetMasterShape(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMasterShape();
  
  String getUniqueID();
  
  XmlString xgetUniqueID();
  
  boolean isSetUniqueID();
  
  void setUniqueID(String paramString);
  
  void xsetUniqueID(XmlString paramXmlString);
  
  void unsetUniqueID();
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  String getNameU();
  
  XmlString xgetNameU();
  
  boolean isSetNameU();
  
  void setNameU(String paramString);
  
  void xsetNameU(XmlString paramXmlString);
  
  void unsetNameU();
  
  boolean getIsCustomName();
  
  XmlBoolean xgetIsCustomName();
  
  boolean isSetIsCustomName();
  
  void setIsCustomName(boolean paramBoolean);
  
  void xsetIsCustomName(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomName();
  
  boolean getIsCustomNameU();
  
  XmlBoolean xgetIsCustomNameU();
  
  boolean isSetIsCustomNameU();
  
  void setIsCustomNameU(boolean paramBoolean);
  
  void xsetIsCustomNameU(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomNameU();
  
  long getMaster();
  
  XmlUnsignedInt xgetMaster();
  
  boolean isSetMaster();
  
  void setMaster(long paramLong);
  
  void xsetMaster(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMaster();
  
  String getType();
  
  XmlToken xgetType();
  
  boolean isSetType();
  
  void setType(String paramString);
  
  void xsetType(XmlToken paramXmlToken);
  
  void unsetType();
  
  public static final class Factory {
    public static ShapeSheetType newInstance() {
      return (ShapeSheetType)POIXMLTypeLoader.newInstance(ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType newInstance(XmlOptions param1XmlOptions) {
      return (ShapeSheetType)POIXMLTypeLoader.newInstance(ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(String param1String) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1String, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1String, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(File param1File) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1File, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1File, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(URL param1URL) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1URL, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1URL, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1InputStream, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1InputStream, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(Reader param1Reader) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1Reader, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1Reader, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(Node param1Node) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1Node, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1Node, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static ShapeSheetType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, ShapeSheetType.type, null);
    }
    
    public static ShapeSheetType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ShapeSheetType)POIXMLTypeLoader.parse(param1XMLInputStream, ShapeSheetType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ShapeSheetType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ShapeSheetType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\ShapeSheetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */