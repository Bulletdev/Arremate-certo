package com.microsoft.schemas.office.x2006.encryption;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface STSpinCount extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STSpinCount.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("stspincount544ftype");
  
  int getIntValue();
  
  void setIntValue(int paramInt);
  
  int intValue();
  
  void set(int paramInt);
  
  public static final class Factory {
    public static STSpinCount newValue(Object param1Object) {
      return (STSpinCount)STSpinCount.type.newValue(param1Object);
    }
    
    public static STSpinCount newInstance() {
      return (STSpinCount)POIXMLTypeLoader.newInstance(STSpinCount.type, null);
    }
    
    public static STSpinCount newInstance(XmlOptions param1XmlOptions) {
      return (STSpinCount)POIXMLTypeLoader.newInstance(STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(String param1String) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1String, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1String, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(File param1File) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1File, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1File, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(URL param1URL) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1URL, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1URL, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1InputStream, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1InputStream, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(Reader param1Reader) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1Reader, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1Reader, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1XMLStreamReader, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1XMLStreamReader, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(Node param1Node) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1Node, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1Node, STSpinCount.type, param1XmlOptions);
    }
    
    public static STSpinCount parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1XMLInputStream, STSpinCount.type, null);
    }
    
    public static STSpinCount parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STSpinCount)POIXMLTypeLoader.parse(param1XMLInputStream, STSpinCount.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSpinCount.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STSpinCount.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STSpinCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */