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

public interface STHashSize extends XmlUnsignedInt {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(STHashSize.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("sthashsize605btype");
  
  int getIntValue();
  
  void setIntValue(int paramInt);
  
  int intValue();
  
  void set(int paramInt);
  
  public static final class Factory {
    public static STHashSize newValue(Object param1Object) {
      return (STHashSize)STHashSize.type.newValue(param1Object);
    }
    
    public static STHashSize newInstance() {
      return (STHashSize)POIXMLTypeLoader.newInstance(STHashSize.type, null);
    }
    
    public static STHashSize newInstance(XmlOptions param1XmlOptions) {
      return (STHashSize)POIXMLTypeLoader.newInstance(STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(String param1String) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1String, STHashSize.type, null);
    }
    
    public static STHashSize parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1String, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(File param1File) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1File, STHashSize.type, null);
    }
    
    public static STHashSize parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1File, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(URL param1URL) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1URL, STHashSize.type, null);
    }
    
    public static STHashSize parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1URL, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(InputStream param1InputStream) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1InputStream, STHashSize.type, null);
    }
    
    public static STHashSize parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1InputStream, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(Reader param1Reader) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1Reader, STHashSize.type, null);
    }
    
    public static STHashSize parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (STHashSize)POIXMLTypeLoader.parse(param1Reader, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STHashSize.type, null);
    }
    
    public static STHashSize parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1XMLStreamReader, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(Node param1Node) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1Node, STHashSize.type, null);
    }
    
    public static STHashSize parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (STHashSize)POIXMLTypeLoader.parse(param1Node, STHashSize.type, param1XmlOptions);
    }
    
    public static STHashSize parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (STHashSize)POIXMLTypeLoader.parse(param1XMLInputStream, STHashSize.type, null);
    }
    
    public static STHashSize parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (STHashSize)POIXMLTypeLoader.parse(param1XMLInputStream, STHashSize.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHashSize.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, STHashSize.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\encryption\STHashSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */