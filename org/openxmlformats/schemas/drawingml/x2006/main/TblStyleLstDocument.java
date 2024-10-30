package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface TblStyleLstDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(TblStyleLstDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("tblstylelst4997doctype");
  
  CTTableStyleList getTblStyleLst();
  
  void setTblStyleLst(CTTableStyleList paramCTTableStyleList);
  
  CTTableStyleList addNewTblStyleLst();
  
  public static final class Factory {
    public static TblStyleLstDocument newInstance() {
      return (TblStyleLstDocument)POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument newInstance(XmlOptions param1XmlOptions) {
      return (TblStyleLstDocument)POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(String param1String) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1String, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1String, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(File param1File) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1File, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1File, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(URL param1URL) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1URL, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1URL, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1InputStream, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1InputStream, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1Reader, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1Reader, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(Node param1Node) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1Node, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1Node, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static TblStyleLstDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, TblStyleLstDocument.type, null);
    }
    
    public static TblStyleLstDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (TblStyleLstDocument)POIXMLTypeLoader.parse(param1XMLInputStream, TblStyleLstDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TblStyleLstDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TblStyleLstDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\TblStyleLstDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */