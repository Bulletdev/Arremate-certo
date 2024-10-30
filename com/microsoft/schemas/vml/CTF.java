package com.microsoft.schemas.vml;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTF extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTF.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfbc3atype");
  
  String getEqn();
  
  XmlString xgetEqn();
  
  boolean isSetEqn();
  
  void setEqn(String paramString);
  
  void xsetEqn(XmlString paramXmlString);
  
  void unsetEqn();
  
  public static final class Factory {
    public static CTF newInstance() {
      return (CTF)POIXMLTypeLoader.newInstance(CTF.type, null);
    }
    
    public static CTF newInstance(XmlOptions param1XmlOptions) {
      return (CTF)POIXMLTypeLoader.newInstance(CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(String param1String) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1String, CTF.type, null);
    }
    
    public static CTF parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1String, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(File param1File) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1File, CTF.type, null);
    }
    
    public static CTF parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1File, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(URL param1URL) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1URL, CTF.type, null);
    }
    
    public static CTF parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1URL, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1InputStream, CTF.type, null);
    }
    
    public static CTF parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1InputStream, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(Reader param1Reader) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1Reader, CTF.type, null);
    }
    
    public static CTF parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTF)POIXMLTypeLoader.parse(param1Reader, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1XMLStreamReader, CTF.type, null);
    }
    
    public static CTF parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1XMLStreamReader, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(Node param1Node) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1Node, CTF.type, null);
    }
    
    public static CTF parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTF)POIXMLTypeLoader.parse(param1Node, CTF.type, param1XmlOptions);
    }
    
    public static CTF parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTF)POIXMLTypeLoader.parse(param1XMLInputStream, CTF.type, null);
    }
    
    public static CTF parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTF)POIXMLTypeLoader.parse(param1XMLInputStream, CTF.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTF.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTF.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\vml\CTF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */