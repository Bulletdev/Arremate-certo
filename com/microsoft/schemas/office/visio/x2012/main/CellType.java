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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CellType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CellType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("celltyped857type");
  
  List<RefByType> getRefByList();
  
  RefByType[] getRefByArray();
  
  RefByType getRefByArray(int paramInt);
  
  int sizeOfRefByArray();
  
  void setRefByArray(RefByType[] paramArrayOfRefByType);
  
  void setRefByArray(int paramInt, RefByType paramRefByType);
  
  RefByType insertNewRefBy(int paramInt);
  
  RefByType addNewRefBy();
  
  void removeRefBy(int paramInt);
  
  String getN();
  
  XmlString xgetN();
  
  void setN(String paramString);
  
  void xsetN(XmlString paramXmlString);
  
  String getU();
  
  XmlString xgetU();
  
  boolean isSetU();
  
  void setU(String paramString);
  
  void xsetU(XmlString paramXmlString);
  
  void unsetU();
  
  String getE();
  
  XmlString xgetE();
  
  boolean isSetE();
  
  void setE(String paramString);
  
  void xsetE(XmlString paramXmlString);
  
  void unsetE();
  
  String getF();
  
  XmlString xgetF();
  
  boolean isSetF();
  
  void setF(String paramString);
  
  void xsetF(XmlString paramXmlString);
  
  void unsetF();
  
  String getV();
  
  XmlString xgetV();
  
  boolean isSetV();
  
  void setV(String paramString);
  
  void xsetV(XmlString paramXmlString);
  
  void unsetV();
  
  public static final class Factory {
    public static CellType newInstance() {
      return (CellType)POIXMLTypeLoader.newInstance(CellType.type, null);
    }
    
    public static CellType newInstance(XmlOptions param1XmlOptions) {
      return (CellType)POIXMLTypeLoader.newInstance(CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(String param1String) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1String, CellType.type, null);
    }
    
    public static CellType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1String, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(File param1File) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1File, CellType.type, null);
    }
    
    public static CellType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1File, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(URL param1URL) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1URL, CellType.type, null);
    }
    
    public static CellType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1URL, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1InputStream, CellType.type, null);
    }
    
    public static CellType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1InputStream, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(Reader param1Reader) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1Reader, CellType.type, null);
    }
    
    public static CellType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CellType)POIXMLTypeLoader.parse(param1Reader, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1XMLStreamReader, CellType.type, null);
    }
    
    public static CellType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1XMLStreamReader, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(Node param1Node) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1Node, CellType.type, null);
    }
    
    public static CellType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CellType)POIXMLTypeLoader.parse(param1Node, CellType.type, param1XmlOptions);
    }
    
    public static CellType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CellType)POIXMLTypeLoader.parse(param1XMLInputStream, CellType.type, null);
    }
    
    public static CellType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CellType)POIXMLTypeLoader.parse(param1XMLInputStream, CellType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CellType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CellType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\CellType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */