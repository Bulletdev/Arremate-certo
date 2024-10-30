package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTDrawing extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDrawing.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdrawing2748type");
  
  List<CTTwoCellAnchor> getTwoCellAnchorList();
  
  CTTwoCellAnchor[] getTwoCellAnchorArray();
  
  CTTwoCellAnchor getTwoCellAnchorArray(int paramInt);
  
  int sizeOfTwoCellAnchorArray();
  
  void setTwoCellAnchorArray(CTTwoCellAnchor[] paramArrayOfCTTwoCellAnchor);
  
  void setTwoCellAnchorArray(int paramInt, CTTwoCellAnchor paramCTTwoCellAnchor);
  
  CTTwoCellAnchor insertNewTwoCellAnchor(int paramInt);
  
  CTTwoCellAnchor addNewTwoCellAnchor();
  
  void removeTwoCellAnchor(int paramInt);
  
  List<CTOneCellAnchor> getOneCellAnchorList();
  
  CTOneCellAnchor[] getOneCellAnchorArray();
  
  CTOneCellAnchor getOneCellAnchorArray(int paramInt);
  
  int sizeOfOneCellAnchorArray();
  
  void setOneCellAnchorArray(CTOneCellAnchor[] paramArrayOfCTOneCellAnchor);
  
  void setOneCellAnchorArray(int paramInt, CTOneCellAnchor paramCTOneCellAnchor);
  
  CTOneCellAnchor insertNewOneCellAnchor(int paramInt);
  
  CTOneCellAnchor addNewOneCellAnchor();
  
  void removeOneCellAnchor(int paramInt);
  
  List<CTAbsoluteAnchor> getAbsoluteAnchorList();
  
  CTAbsoluteAnchor[] getAbsoluteAnchorArray();
  
  CTAbsoluteAnchor getAbsoluteAnchorArray(int paramInt);
  
  int sizeOfAbsoluteAnchorArray();
  
  void setAbsoluteAnchorArray(CTAbsoluteAnchor[] paramArrayOfCTAbsoluteAnchor);
  
  void setAbsoluteAnchorArray(int paramInt, CTAbsoluteAnchor paramCTAbsoluteAnchor);
  
  CTAbsoluteAnchor insertNewAbsoluteAnchor(int paramInt);
  
  CTAbsoluteAnchor addNewAbsoluteAnchor();
  
  void removeAbsoluteAnchor(int paramInt);
  
  public static final class Factory {
    public static CTDrawing newInstance() {
      return (CTDrawing)POIXMLTypeLoader.newInstance(CTDrawing.type, null);
    }
    
    public static CTDrawing newInstance(XmlOptions param1XmlOptions) {
      return (CTDrawing)POIXMLTypeLoader.newInstance(CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(String param1String) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1String, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1String, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(File param1File) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1File, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1File, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(URL param1URL) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1URL, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1URL, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1InputStream, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1InputStream, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1Reader, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1Reader, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(Node param1Node) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1Node, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1Node, CTDrawing.type, param1XmlOptions);
    }
    
    public static CTDrawing parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1XMLInputStream, CTDrawing.type, null);
    }
    
    public static CTDrawing parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDrawing)POIXMLTypeLoader.parse(param1XMLInputStream, CTDrawing.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDrawing.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDrawing.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTDrawing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */