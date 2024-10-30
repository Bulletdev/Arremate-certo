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

public interface CTStyleMatrixReference extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStyleMatrixReference.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstylematrixreference6ef4type");
  
  CTScRgbColor getScrgbClr();
  
  boolean isSetScrgbClr();
  
  void setScrgbClr(CTScRgbColor paramCTScRgbColor);
  
  CTScRgbColor addNewScrgbClr();
  
  void unsetScrgbClr();
  
  CTSRgbColor getSrgbClr();
  
  boolean isSetSrgbClr();
  
  void setSrgbClr(CTSRgbColor paramCTSRgbColor);
  
  CTSRgbColor addNewSrgbClr();
  
  void unsetSrgbClr();
  
  CTHslColor getHslClr();
  
  boolean isSetHslClr();
  
  void setHslClr(CTHslColor paramCTHslColor);
  
  CTHslColor addNewHslClr();
  
  void unsetHslClr();
  
  CTSystemColor getSysClr();
  
  boolean isSetSysClr();
  
  void setSysClr(CTSystemColor paramCTSystemColor);
  
  CTSystemColor addNewSysClr();
  
  void unsetSysClr();
  
  CTSchemeColor getSchemeClr();
  
  boolean isSetSchemeClr();
  
  void setSchemeClr(CTSchemeColor paramCTSchemeColor);
  
  CTSchemeColor addNewSchemeClr();
  
  void unsetSchemeClr();
  
  CTPresetColor getPrstClr();
  
  boolean isSetPrstClr();
  
  void setPrstClr(CTPresetColor paramCTPresetColor);
  
  CTPresetColor addNewPrstClr();
  
  void unsetPrstClr();
  
  long getIdx();
  
  STStyleMatrixColumnIndex xgetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(STStyleMatrixColumnIndex paramSTStyleMatrixColumnIndex);
  
  public static final class Factory {
    public static CTStyleMatrixReference newInstance() {
      return (CTStyleMatrixReference)POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference newInstance(XmlOptions param1XmlOptions) {
      return (CTStyleMatrixReference)POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(String param1String) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1String, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1String, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(File param1File) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1File, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1File, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(URL param1URL) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1URL, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1URL, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1InputStream, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1InputStream, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1Reader, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1Reader, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(Node param1Node) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1Node, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1Node, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static CTStyleMatrixReference parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyleMatrixReference.type, null);
    }
    
    public static CTStyleMatrixReference parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStyleMatrixReference)POIXMLTypeLoader.parse(param1XMLInputStream, CTStyleMatrixReference.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyleMatrixReference.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStyleMatrixReference.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTStyleMatrixReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */