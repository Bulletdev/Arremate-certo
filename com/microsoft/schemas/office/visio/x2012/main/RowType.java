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

public interface RowType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(RowType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("rowtype03d1type");
  
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
  
  String getN();
  
  XmlString xgetN();
  
  boolean isSetN();
  
  void setN(String paramString);
  
  void xsetN(XmlString paramXmlString);
  
  void unsetN();
  
  String getLocalName();
  
  XmlString xgetLocalName();
  
  boolean isSetLocalName();
  
  void setLocalName(String paramString);
  
  void xsetLocalName(XmlString paramXmlString);
  
  void unsetLocalName();
  
  long getIX();
  
  XmlUnsignedInt xgetIX();
  
  boolean isSetIX();
  
  void setIX(long paramLong);
  
  void xsetIX(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIX();
  
  String getT();
  
  XmlString xgetT();
  
  boolean isSetT();
  
  void setT(String paramString);
  
  void xsetT(XmlString paramXmlString);
  
  void unsetT();
  
  boolean getDel();
  
  XmlBoolean xgetDel();
  
  boolean isSetDel();
  
  void setDel(boolean paramBoolean);
  
  void xsetDel(XmlBoolean paramXmlBoolean);
  
  void unsetDel();
  
  public static final class Factory {
    public static RowType newInstance() {
      return (RowType)POIXMLTypeLoader.newInstance(RowType.type, null);
    }
    
    public static RowType newInstance(XmlOptions param1XmlOptions) {
      return (RowType)POIXMLTypeLoader.newInstance(RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(String param1String) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1String, RowType.type, null);
    }
    
    public static RowType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1String, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(File param1File) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1File, RowType.type, null);
    }
    
    public static RowType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1File, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(URL param1URL) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1URL, RowType.type, null);
    }
    
    public static RowType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1URL, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1InputStream, RowType.type, null);
    }
    
    public static RowType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1InputStream, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(Reader param1Reader) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1Reader, RowType.type, null);
    }
    
    public static RowType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (RowType)POIXMLTypeLoader.parse(param1Reader, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1XMLStreamReader, RowType.type, null);
    }
    
    public static RowType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1XMLStreamReader, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(Node param1Node) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1Node, RowType.type, null);
    }
    
    public static RowType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (RowType)POIXMLTypeLoader.parse(param1Node, RowType.type, param1XmlOptions);
    }
    
    public static RowType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (RowType)POIXMLTypeLoader.parse(param1XMLInputStream, RowType.type, null);
    }
    
    public static RowType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (RowType)POIXMLTypeLoader.parse(param1XMLInputStream, RowType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RowType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, RowType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\RowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */