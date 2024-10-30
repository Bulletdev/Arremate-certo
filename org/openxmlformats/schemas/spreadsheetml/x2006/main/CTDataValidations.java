package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDataValidations extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataValidations.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatavalidationse46ftype");
  
  List<CTDataValidation> getDataValidationList();
  
  CTDataValidation[] getDataValidationArray();
  
  CTDataValidation getDataValidationArray(int paramInt);
  
  int sizeOfDataValidationArray();
  
  void setDataValidationArray(CTDataValidation[] paramArrayOfCTDataValidation);
  
  void setDataValidationArray(int paramInt, CTDataValidation paramCTDataValidation);
  
  CTDataValidation insertNewDataValidation(int paramInt);
  
  CTDataValidation addNewDataValidation();
  
  void removeDataValidation(int paramInt);
  
  boolean getDisablePrompts();
  
  XmlBoolean xgetDisablePrompts();
  
  boolean isSetDisablePrompts();
  
  void setDisablePrompts(boolean paramBoolean);
  
  void xsetDisablePrompts(XmlBoolean paramXmlBoolean);
  
  void unsetDisablePrompts();
  
  long getXWindow();
  
  XmlUnsignedInt xgetXWindow();
  
  boolean isSetXWindow();
  
  void setXWindow(long paramLong);
  
  void xsetXWindow(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetXWindow();
  
  long getYWindow();
  
  XmlUnsignedInt xgetYWindow();
  
  boolean isSetYWindow();
  
  void setYWindow(long paramLong);
  
  void xsetYWindow(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetYWindow();
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTDataValidations newInstance() {
      return (CTDataValidations)POIXMLTypeLoader.newInstance(CTDataValidations.type, null);
    }
    
    public static CTDataValidations newInstance(XmlOptions param1XmlOptions) {
      return (CTDataValidations)POIXMLTypeLoader.newInstance(CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(String param1String) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1String, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1String, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(File param1File) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1File, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1File, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(URL param1URL) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1URL, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1URL, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1InputStream, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1InputStream, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1Reader, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1Reader, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(Node param1Node) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1Node, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1Node, CTDataValidations.type, param1XmlOptions);
    }
    
    public static CTDataValidations parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataValidations.type, null);
    }
    
    public static CTDataValidations parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataValidations)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataValidations.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataValidations.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataValidations.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDataValidations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */