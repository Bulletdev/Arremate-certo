package org.openxmlformats.schemas.drawingml.x2006.picture;

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

public interface PicDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PicDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pic8010doctype");
  
  CTPicture getPic();
  
  void setPic(CTPicture paramCTPicture);
  
  CTPicture addNewPic();
  
  public static final class Factory {
    public static PicDocument newInstance() {
      return (PicDocument)POIXMLTypeLoader.newInstance(PicDocument.type, null);
    }
    
    public static PicDocument newInstance(XmlOptions param1XmlOptions) {
      return (PicDocument)POIXMLTypeLoader.newInstance(PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(String param1String) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1String, PicDocument.type, null);
    }
    
    public static PicDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1String, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(File param1File) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1File, PicDocument.type, null);
    }
    
    public static PicDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1File, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(URL param1URL) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1URL, PicDocument.type, null);
    }
    
    public static PicDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1URL, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1InputStream, PicDocument.type, null);
    }
    
    public static PicDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1InputStream, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1Reader, PicDocument.type, null);
    }
    
    public static PicDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PicDocument)POIXMLTypeLoader.parse(param1Reader, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PicDocument.type, null);
    }
    
    public static PicDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(Node param1Node) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1Node, PicDocument.type, null);
    }
    
    public static PicDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PicDocument)POIXMLTypeLoader.parse(param1Node, PicDocument.type, param1XmlOptions);
    }
    
    public static PicDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PicDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PicDocument.type, null);
    }
    
    public static PicDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PicDocument)POIXMLTypeLoader.parse(param1XMLInputStream, PicDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PicDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PicDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\picture\PicDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */