package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPivotTableStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotTableStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivottablestyle0f84type");
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  boolean getShowRowHeaders();
  
  XmlBoolean xgetShowRowHeaders();
  
  boolean isSetShowRowHeaders();
  
  void setShowRowHeaders(boolean paramBoolean);
  
  void xsetShowRowHeaders(XmlBoolean paramXmlBoolean);
  
  void unsetShowRowHeaders();
  
  boolean getShowColHeaders();
  
  XmlBoolean xgetShowColHeaders();
  
  boolean isSetShowColHeaders();
  
  void setShowColHeaders(boolean paramBoolean);
  
  void xsetShowColHeaders(XmlBoolean paramXmlBoolean);
  
  void unsetShowColHeaders();
  
  boolean getShowRowStripes();
  
  XmlBoolean xgetShowRowStripes();
  
  boolean isSetShowRowStripes();
  
  void setShowRowStripes(boolean paramBoolean);
  
  void xsetShowRowStripes(XmlBoolean paramXmlBoolean);
  
  void unsetShowRowStripes();
  
  boolean getShowColStripes();
  
  XmlBoolean xgetShowColStripes();
  
  boolean isSetShowColStripes();
  
  void setShowColStripes(boolean paramBoolean);
  
  void xsetShowColStripes(XmlBoolean paramXmlBoolean);
  
  void unsetShowColStripes();
  
  boolean getShowLastColumn();
  
  XmlBoolean xgetShowLastColumn();
  
  boolean isSetShowLastColumn();
  
  void setShowLastColumn(boolean paramBoolean);
  
  void xsetShowLastColumn(XmlBoolean paramXmlBoolean);
  
  void unsetShowLastColumn();
  
  public static final class Factory {
    public static CTPivotTableStyle newInstance() {
      return (CTPivotTableStyle)POIXMLTypeLoader.newInstance(CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotTableStyle)POIXMLTypeLoader.newInstance(CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(String param1String) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1String, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1String, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(File param1File) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1File, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1File, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1URL, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1URL, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1InputStream, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1InputStream, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1Reader, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1Reader, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(Node param1Node) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1Node, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1Node, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static CTPivotTableStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotTableStyle.type, null);
    }
    
    public static CTPivotTableStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotTableStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotTableStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotTableStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotTableStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotTableStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */