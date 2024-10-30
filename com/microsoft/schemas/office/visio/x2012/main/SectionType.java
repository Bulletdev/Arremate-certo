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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface SectionType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SectionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("sectiontype30a6type");
  
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
  
  List<RowType> getRowList();
  
  RowType[] getRowArray();
  
  RowType getRowArray(int paramInt);
  
  int sizeOfRowArray();
  
  void setRowArray(RowType[] paramArrayOfRowType);
  
  void setRowArray(int paramInt, RowType paramRowType);
  
  RowType insertNewRow(int paramInt);
  
  RowType addNewRow();
  
  void removeRow(int paramInt);
  
  String getN();
  
  XmlString xgetN();
  
  void setN(String paramString);
  
  void xsetN(XmlString paramXmlString);
  
  boolean getDel();
  
  XmlBoolean xgetDel();
  
  boolean isSetDel();
  
  void setDel(boolean paramBoolean);
  
  void xsetDel(XmlBoolean paramXmlBoolean);
  
  void unsetDel();
  
  long getIX();
  
  XmlUnsignedInt xgetIX();
  
  boolean isSetIX();
  
  void setIX(long paramLong);
  
  void xsetIX(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIX();
  
  public static final class Factory {
    public static SectionType newInstance() {
      return (SectionType)POIXMLTypeLoader.newInstance(SectionType.type, null);
    }
    
    public static SectionType newInstance(XmlOptions param1XmlOptions) {
      return (SectionType)POIXMLTypeLoader.newInstance(SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(String param1String) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1String, SectionType.type, null);
    }
    
    public static SectionType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1String, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(File param1File) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1File, SectionType.type, null);
    }
    
    public static SectionType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1File, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(URL param1URL) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1URL, SectionType.type, null);
    }
    
    public static SectionType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1URL, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1InputStream, SectionType.type, null);
    }
    
    public static SectionType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1InputStream, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(Reader param1Reader) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1Reader, SectionType.type, null);
    }
    
    public static SectionType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SectionType)POIXMLTypeLoader.parse(param1Reader, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1XMLStreamReader, SectionType.type, null);
    }
    
    public static SectionType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1XMLStreamReader, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(Node param1Node) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1Node, SectionType.type, null);
    }
    
    public static SectionType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SectionType)POIXMLTypeLoader.parse(param1Node, SectionType.type, param1XmlOptions);
    }
    
    public static SectionType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SectionType)POIXMLTypeLoader.parse(param1XMLInputStream, SectionType.type, null);
    }
    
    public static SectionType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SectionType)POIXMLTypeLoader.parse(param1XMLInputStream, SectionType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SectionType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SectionType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\SectionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */