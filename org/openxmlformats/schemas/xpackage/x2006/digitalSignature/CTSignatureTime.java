package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

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

public interface CTSignatureTime extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSignatureTime.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctsignaturetime461dtype");
  
  String getFormat();
  
  STFormat xgetFormat();
  
  void setFormat(String paramString);
  
  void xsetFormat(STFormat paramSTFormat);
  
  String getValue();
  
  STValue xgetValue();
  
  void setValue(String paramString);
  
  void xsetValue(STValue paramSTValue);
  
  public static final class Factory {
    public static CTSignatureTime newInstance() {
      return (CTSignatureTime)POIXMLTypeLoader.newInstance(CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime newInstance(XmlOptions param1XmlOptions) {
      return (CTSignatureTime)POIXMLTypeLoader.newInstance(CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(String param1String) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1String, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1String, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(File param1File) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1File, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1File, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(URL param1URL) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1URL, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1URL, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1InputStream, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1InputStream, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1Reader, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1Reader, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(Node param1Node) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1Node, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1Node, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static CTSignatureTime parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignatureTime.type, null);
    }
    
    public static CTSignatureTime parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSignatureTime)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignatureTime.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignatureTime.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignatureTime.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\CTSignatureTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */