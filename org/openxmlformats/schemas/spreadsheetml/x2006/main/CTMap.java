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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTMap extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMap.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmap023btype");
  
  CTDataBinding getDataBinding();
  
  boolean isSetDataBinding();
  
  void setDataBinding(CTDataBinding paramCTDataBinding);
  
  CTDataBinding addNewDataBinding();
  
  void unsetDataBinding();
  
  long getID();
  
  XmlUnsignedInt xgetID();
  
  void setID(long paramLong);
  
  void xsetID(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getName();
  
  XmlString xgetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  String getRootElement();
  
  XmlString xgetRootElement();
  
  void setRootElement(String paramString);
  
  void xsetRootElement(XmlString paramXmlString);
  
  String getSchemaID();
  
  XmlString xgetSchemaID();
  
  void setSchemaID(String paramString);
  
  void xsetSchemaID(XmlString paramXmlString);
  
  boolean getShowImportExportValidationErrors();
  
  XmlBoolean xgetShowImportExportValidationErrors();
  
  void setShowImportExportValidationErrors(boolean paramBoolean);
  
  void xsetShowImportExportValidationErrors(XmlBoolean paramXmlBoolean);
  
  boolean getAutoFit();
  
  XmlBoolean xgetAutoFit();
  
  void setAutoFit(boolean paramBoolean);
  
  void xsetAutoFit(XmlBoolean paramXmlBoolean);
  
  boolean getAppend();
  
  XmlBoolean xgetAppend();
  
  void setAppend(boolean paramBoolean);
  
  void xsetAppend(XmlBoolean paramXmlBoolean);
  
  boolean getPreserveSortAFLayout();
  
  XmlBoolean xgetPreserveSortAFLayout();
  
  void setPreserveSortAFLayout(boolean paramBoolean);
  
  void xsetPreserveSortAFLayout(XmlBoolean paramXmlBoolean);
  
  boolean getPreserveFormat();
  
  XmlBoolean xgetPreserveFormat();
  
  void setPreserveFormat(boolean paramBoolean);
  
  void xsetPreserveFormat(XmlBoolean paramXmlBoolean);
  
  public static final class Factory {
    public static CTMap newInstance() {
      return (CTMap)POIXMLTypeLoader.newInstance(CTMap.type, null);
    }
    
    public static CTMap newInstance(XmlOptions param1XmlOptions) {
      return (CTMap)POIXMLTypeLoader.newInstance(CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(String param1String) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1String, CTMap.type, null);
    }
    
    public static CTMap parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1String, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(File param1File) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1File, CTMap.type, null);
    }
    
    public static CTMap parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1File, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(URL param1URL) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1URL, CTMap.type, null);
    }
    
    public static CTMap parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1URL, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1InputStream, CTMap.type, null);
    }
    
    public static CTMap parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1InputStream, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1Reader, CTMap.type, null);
    }
    
    public static CTMap parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMap)POIXMLTypeLoader.parse(param1Reader, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMap.type, null);
    }
    
    public static CTMap parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(Node param1Node) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1Node, CTMap.type, null);
    }
    
    public static CTMap parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMap)POIXMLTypeLoader.parse(param1Node, CTMap.type, param1XmlOptions);
    }
    
    public static CTMap parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMap)POIXMLTypeLoader.parse(param1XMLInputStream, CTMap.type, null);
    }
    
    public static CTMap parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMap)POIXMLTypeLoader.parse(param1XMLInputStream, CTMap.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMap.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMap.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */