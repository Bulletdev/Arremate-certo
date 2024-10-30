package org.openxmlformats.schemas.presentationml.x2006.main;

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

public interface CmLstDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CmLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cmlst3880doctype");
  
  CTCommentList getCmLst();
  
  void setCmLst(CTCommentList paramCTCommentList);
  
  CTCommentList addNewCmLst();
  
  public static final class Factory {
    public static CmLstDocument newInstance() {
      return (CmLstDocument)POIXMLTypeLoader.newInstance(CmLstDocument.type, null);
    }
    
    public static CmLstDocument newInstance(XmlOptions param1XmlOptions) {
      return (CmLstDocument)POIXMLTypeLoader.newInstance(CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(String param1String) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1String, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1String, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(File param1File) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1File, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1File, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(URL param1URL) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1URL, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1URL, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1InputStream, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1InputStream, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1Reader, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1Reader, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(Node param1Node) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1Node, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1Node, CmLstDocument.type, param1XmlOptions);
    }
    
    public static CmLstDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CmLstDocument.type, null);
    }
    
    public static CmLstDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CmLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CmLstDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CmLstDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CmLstDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CmLstDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */