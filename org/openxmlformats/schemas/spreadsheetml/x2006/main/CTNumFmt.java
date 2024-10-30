package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTNumFmt extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumFmt.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumfmt3870type");
  
  long getNumFmtId();
  
  STNumFmtId xgetNumFmtId();
  
  void setNumFmtId(long paramLong);
  
  void xsetNumFmtId(STNumFmtId paramSTNumFmtId);
  
  String getFormatCode();
  
  STXstring xgetFormatCode();
  
  void setFormatCode(String paramString);
  
  void xsetFormatCode(STXstring paramSTXstring);
  
  public static final class Factory {
    public static CTNumFmt newInstance() {
      return (CTNumFmt)POIXMLTypeLoader.newInstance(CTNumFmt.type, null);
    }
    
    public static CTNumFmt newInstance(XmlOptions param1XmlOptions) {
      return (CTNumFmt)POIXMLTypeLoader.newInstance(CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(String param1String) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1String, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1String, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(File param1File) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1File, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1File, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(URL param1URL) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1URL, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1URL, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1InputStream, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1InputStream, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1Reader, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1Reader, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(Node param1Node) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1Node, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1Node, CTNumFmt.type, param1XmlOptions);
    }
    
    public static CTNumFmt parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumFmt.type, null);
    }
    
    public static CTNumFmt parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumFmt)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumFmt.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumFmt.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumFmt.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTNumFmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */