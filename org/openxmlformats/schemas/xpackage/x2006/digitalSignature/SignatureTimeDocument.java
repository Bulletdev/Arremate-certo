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

public interface SignatureTimeDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(SignatureTimeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("signaturetime9c91doctype");
  
  CTSignatureTime getSignatureTime();
  
  void setSignatureTime(CTSignatureTime paramCTSignatureTime);
  
  CTSignatureTime addNewSignatureTime();
  
  public static final class Factory {
    public static SignatureTimeDocument newInstance() {
      return (SignatureTimeDocument)POIXMLTypeLoader.newInstance(SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument newInstance(XmlOptions param1XmlOptions) {
      return (SignatureTimeDocument)POIXMLTypeLoader.newInstance(SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(String param1String) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1String, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1String, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(File param1File) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1File, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1File, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(URL param1URL) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1URL, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1URL, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1InputStream, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1InputStream, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1Reader, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1Reader, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(Node param1Node) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1Node, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1Node, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static SignatureTimeDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SignatureTimeDocument.type, null);
    }
    
    public static SignatureTimeDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (SignatureTimeDocument)POIXMLTypeLoader.parse(param1XMLInputStream, SignatureTimeDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SignatureTimeDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, SignatureTimeDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\xpackage\x2006\digitalSignature\SignatureTimeDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */