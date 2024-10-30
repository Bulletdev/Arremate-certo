package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface SheetType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SheetType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sheettype25actype");
  
  List<CellType> getCellList();
  
  CellType[] getCellArray();
  
  CellType getCellArray(int paramInt);
  
  int sizeOfCellArray();
  
  void setCellArray(CellType[] paramArrayOfCellType);
  
  void setCellArray(int paramInt, CellType paramCellType);
  
  CellType insertNewCell(int paramInt);
  
  CellType addNewCell();
  
  void removeCell(int paramInt);
  
  List<TriggerType> getTriggerList();
  
  TriggerType[] getTriggerArray();
  
  TriggerType getTriggerArray(int paramInt);
  
  int sizeOfTriggerArray();
  
  void setTriggerArray(TriggerType[] paramArrayOfTriggerType);
  
  void setTriggerArray(int paramInt, TriggerType paramTriggerType);
  
  TriggerType insertNewTrigger(int paramInt);
  
  TriggerType addNewTrigger();
  
  void removeTrigger(int paramInt);
  
  List<SectionType> getSectionList();
  
  SectionType[] getSectionArray();
  
  SectionType getSectionArray(int paramInt);
  
  int sizeOfSectionArray();
  
  void setSectionArray(SectionType[] paramArrayOfSectionType);
  
  void setSectionArray(int paramInt, SectionType paramSectionType);
  
  SectionType insertNewSection(int paramInt);
  
  SectionType addNewSection();
  
  void removeSection(int paramInt);
  
  long getLineStyle();
  
  XmlUnsignedInt xgetLineStyle();
  
  boolean isSetLineStyle();
  
  void setLineStyle(long paramLong);
  
  void xsetLineStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetLineStyle();
  
  long getFillStyle();
  
  XmlUnsignedInt xgetFillStyle();
  
  boolean isSetFillStyle();
  
  void setFillStyle(long paramLong);
  
  void xsetFillStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetFillStyle();
  
  long getTextStyle();
  
  XmlUnsignedInt xgetTextStyle();
  
  boolean isSetTextStyle();
  
  void setTextStyle(long paramLong);
  
  void xsetTextStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTextStyle();
  
  public static final class Factory {
    public static SheetType newInstance() {
      return (SheetType)POIXMLTypeLoader.newInstance(SheetType.type, null);
    }
    
    public static SheetType newInstance(XmlOptions param1XmlOptions) {
      return (SheetType)POIXMLTypeLoader.newInstance(SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(String param1String) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1String, SheetType.type, null);
    }
    
    public static SheetType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1String, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(File param1File) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1File, SheetType.type, null);
    }
    
    public static SheetType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1File, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(URL param1URL) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1URL, SheetType.type, null);
    }
    
    public static SheetType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1URL, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1InputStream, SheetType.type, null);
    }
    
    public static SheetType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1InputStream, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(Reader param1Reader) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1Reader, SheetType.type, null);
    }
    
    public static SheetType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SheetType)POIXMLTypeLoader.parse(param1Reader, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, SheetType.type, null);
    }
    
    public static SheetType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1XMLStreamReader, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(Node param1Node) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1Node, SheetType.type, null);
    }
    
    public static SheetType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SheetType)POIXMLTypeLoader.parse(param1Node, SheetType.type, param1XmlOptions);
    }
    
    public static SheetType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SheetType)POIXMLTypeLoader.parse(param1XMLInputStream, SheetType.type, null);
    }
    
    public static SheetType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SheetType)POIXMLTypeLoader.parse(param1XMLInputStream, SheetType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SheetType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SheetType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\SheetType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */