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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTExternalDefinedName extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalDefinedName.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternaldefinedname9408type");
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  String getRefersTo();
  
  STXstring xgetRefersTo();
  
  boolean isSetRefersTo();
  
  void setRefersTo(String paramString);
  
  void xsetRefersTo(STXstring paramSTXstring);
  
  void unsetRefersTo();
  
  long getSheetId();
  
  XmlUnsignedInt xgetSheetId();
  
  boolean isSetSheetId();
  
  void setSheetId(long paramLong);
  
  void xsetSheetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetSheetId();
  
  public static final class Factory {
    public static CTExternalDefinedName newInstance() {
      return (CTExternalDefinedName)POIXMLTypeLoader.newInstance(CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalDefinedName)POIXMLTypeLoader.newInstance(CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(String param1String) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1String, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1String, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(File param1File) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1File, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1File, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1URL, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1URL, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1InputStream, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1InputStream, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1Reader, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1Reader, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(Node param1Node) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1Node, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1Node, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static CTExternalDefinedName parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalDefinedName.type, null);
    }
    
    public static CTExternalDefinedName parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalDefinedName)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalDefinedName.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalDefinedName.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalDefinedName.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalDefinedName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */