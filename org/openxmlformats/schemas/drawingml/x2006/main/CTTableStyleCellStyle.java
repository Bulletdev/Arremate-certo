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

public interface CTTableStyleCellStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableStyleCellStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablestylecellstyle1fddtype");
  
  CTTableCellBorderStyle getTcBdr();
  
  boolean isSetTcBdr();
  
  void setTcBdr(CTTableCellBorderStyle paramCTTableCellBorderStyle);
  
  CTTableCellBorderStyle addNewTcBdr();
  
  void unsetTcBdr();
  
  CTFillProperties getFill();
  
  boolean isSetFill();
  
  void setFill(CTFillProperties paramCTFillProperties);
  
  CTFillProperties addNewFill();
  
  void unsetFill();
  
  CTStyleMatrixReference getFillRef();
  
  boolean isSetFillRef();
  
  void setFillRef(CTStyleMatrixReference paramCTStyleMatrixReference);
  
  CTStyleMatrixReference addNewFillRef();
  
  void unsetFillRef();
  
  CTCell3D getCell3D();
  
  boolean isSetCell3D();
  
  void setCell3D(CTCell3D paramCTCell3D);
  
  CTCell3D addNewCell3D();
  
  void unsetCell3D();
  
  public static final class Factory {
    public static CTTableStyleCellStyle newInstance() {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(String param1String) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1String, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1String, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(File param1File) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1File, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1File, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1URL, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1InputStream, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1Reader, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(Node param1Node) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1Node, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static CTTableStyleCellStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleCellStyle.type, null);
    }
    
    public static CTTableStyleCellStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableStyleCellStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableStyleCellStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleCellStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableStyleCellStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTableStyleCellStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */