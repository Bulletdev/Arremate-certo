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

public interface CmAuthorLstDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CmAuthorLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cmauthorlst86abdoctype");
  
  CTCommentAuthorList getCmAuthorLst();
  
  void setCmAuthorLst(CTCommentAuthorList paramCTCommentAuthorList);
  
  CTCommentAuthorList addNewCmAuthorLst();
  
  public static final class Factory {
    public static CmAuthorLstDocument newInstance() {
      return (CmAuthorLstDocument)POIXMLTypeLoader.newInstance(CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument newInstance(XmlOptions param1XmlOptions) {
      return (CmAuthorLstDocument)POIXMLTypeLoader.newInstance(CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(String param1String) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1String, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1String, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(File param1File) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1File, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1File, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(URL param1URL) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1URL, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1URL, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1InputStream, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1InputStream, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1Reader, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1Reader, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(Node param1Node) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1Node, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1Node, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static CmAuthorLstDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CmAuthorLstDocument.type, null);
    }
    
    public static CmAuthorLstDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CmAuthorLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CmAuthorLstDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CmAuthorLstDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CmAuthorLstDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CmAuthorLstDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */