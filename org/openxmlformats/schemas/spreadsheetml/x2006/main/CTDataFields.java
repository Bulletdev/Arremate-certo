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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDataFields extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDataFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdatafields52cctype");
  
  List<CTDataField> getDataFieldList();
  
  CTDataField[] getDataFieldArray();
  
  CTDataField getDataFieldArray(int paramInt);
  
  int sizeOfDataFieldArray();
  
  void setDataFieldArray(CTDataField[] paramArrayOfCTDataField);
  
  void setDataFieldArray(int paramInt, CTDataField paramCTDataField);
  
  CTDataField insertNewDataField(int paramInt);
  
  CTDataField addNewDataField();
  
  void removeDataField(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTDataFields newInstance() {
      return (CTDataFields)POIXMLTypeLoader.newInstance(CTDataFields.type, null);
    }
    
    public static CTDataFields newInstance(XmlOptions param1XmlOptions) {
      return (CTDataFields)POIXMLTypeLoader.newInstance(CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(String param1String) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1String, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1String, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(File param1File) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1File, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1File, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(URL param1URL) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1URL, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1URL, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1InputStream, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1InputStream, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1Reader, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1Reader, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(Node param1Node) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1Node, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1Node, CTDataFields.type, param1XmlOptions);
    }
    
    public static CTDataFields parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataFields.type, null);
    }
    
    public static CTDataFields parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDataFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTDataFields.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataFields.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDataFields.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDataFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */