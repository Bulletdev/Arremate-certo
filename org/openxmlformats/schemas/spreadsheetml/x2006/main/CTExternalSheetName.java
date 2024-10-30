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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTExternalSheetName extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalSheetName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternalsheetnamefcdetype");
  
  String getVal();
  
  STXstring xgetVal();
  
  boolean isSetVal();
  
  void setVal(String paramString);
  
  void xsetVal(STXstring paramSTXstring);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTExternalSheetName newInstance() {
      return (CTExternalSheetName)POIXMLTypeLoader.newInstance(CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalSheetName)POIXMLTypeLoader.newInstance(CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(String param1String) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1String, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1String, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(File param1File) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1File, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1File, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1URL, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1URL, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1InputStream, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1InputStream, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1Reader, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1Reader, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(Node param1Node) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1Node, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1Node, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static CTExternalSheetName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalSheetName.type, null);
    }
    
    public static CTExternalSheetName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalSheetName)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalSheetName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalSheetName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalSheetName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalSheetName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */