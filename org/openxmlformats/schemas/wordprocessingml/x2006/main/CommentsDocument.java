package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CommentsDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CommentsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("comments3da0doctype");
  
  CTComments getComments();
  
  void setComments(CTComments paramCTComments);
  
  CTComments addNewComments();
  
  public static final class Factory {
    public static CommentsDocument newInstance() {
      return (CommentsDocument)POIXMLTypeLoader.newInstance(CommentsDocument.type, null);
    }
    
    public static CommentsDocument newInstance(XmlOptions param1XmlOptions) {
      return (CommentsDocument)POIXMLTypeLoader.newInstance(CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(String param1String) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1String, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1String, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(File param1File) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1File, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1File, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(URL param1URL) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1URL, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1URL, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1InputStream, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1InputStream, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1Reader, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1Reader, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(Node param1Node) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1Node, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1Node, CommentsDocument.type, param1XmlOptions);
    }
    
    public static CommentsDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CommentsDocument.type, null);
    }
    
    public static CommentsDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CommentsDocument)POIXMLTypeLoader.parse(param1XMLInputStream, CommentsDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CommentsDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CommentsDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CommentsDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */