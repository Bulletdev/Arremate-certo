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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCommentAuthor extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCommentAuthor.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcommentauthora405type");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getName();
  
  STName xgetName();
  
  void setName(String paramString);
  
  void xsetName(STName paramSTName);
  
  String getInitials();
  
  STName xgetInitials();
  
  void setInitials(String paramString);
  
  void xsetInitials(STName paramSTName);
  
  long getLastIdx();
  
  XmlUnsignedInt xgetLastIdx();
  
  void setLastIdx(long paramLong);
  
  void xsetLastIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  long getClrIdx();
  
  XmlUnsignedInt xgetClrIdx();
  
  void setClrIdx(long paramLong);
  
  void xsetClrIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  public static final class Factory {
    public static CTCommentAuthor newInstance() {
      return (CTCommentAuthor)POIXMLTypeLoader.newInstance(CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor newInstance(XmlOptions param1XmlOptions) {
      return (CTCommentAuthor)POIXMLTypeLoader.newInstance(CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(String param1String) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1String, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1String, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(File param1File) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1File, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1File, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(URL param1URL) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1URL, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1URL, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1InputStream, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1InputStream, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1Reader, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1Reader, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(Node param1Node) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1Node, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1Node, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static CTCommentAuthor parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommentAuthor.type, null);
    }
    
    public static CTCommentAuthor parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCommentAuthor)POIXMLTypeLoader.parse(param1XMLInputStream, CTCommentAuthor.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommentAuthor.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCommentAuthor.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTCommentAuthor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */