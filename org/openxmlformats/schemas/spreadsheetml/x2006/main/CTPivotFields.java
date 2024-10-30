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

public interface CTPivotFields extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotFields.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotfields12batype");
  
  List<CTPivotField> getPivotFieldList();
  
  CTPivotField[] getPivotFieldArray();
  
  CTPivotField getPivotFieldArray(int paramInt);
  
  int sizeOfPivotFieldArray();
  
  void setPivotFieldArray(CTPivotField[] paramArrayOfCTPivotField);
  
  void setPivotFieldArray(int paramInt, CTPivotField paramCTPivotField);
  
  CTPivotField insertNewPivotField(int paramInt);
  
  CTPivotField addNewPivotField();
  
  void removePivotField(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTPivotFields newInstance() {
      return (CTPivotFields)POIXMLTypeLoader.newInstance(CTPivotFields.type, null);
    }
    
    public static CTPivotFields newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotFields)POIXMLTypeLoader.newInstance(CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(String param1String) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1String, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1String, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(File param1File) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1File, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1File, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1URL, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1URL, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1InputStream, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1InputStream, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1Reader, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1Reader, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(Node param1Node) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1Node, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1Node, CTPivotFields.type, param1XmlOptions);
    }
    
    public static CTPivotFields parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotFields.type, null);
    }
    
    public static CTPivotFields parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotFields)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotFields.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotFields.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotFields.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */