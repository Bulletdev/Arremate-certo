package com.microsoft.schemas.office.visio.x2012.main;

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

public interface DocumentSettingsType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(DocumentSettingsType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("documentsettingstype945btype");
  
  GlueSettingsType getGlueSettings();
  
  boolean isSetGlueSettings();
  
  void setGlueSettings(GlueSettingsType paramGlueSettingsType);
  
  GlueSettingsType addNewGlueSettings();
  
  void unsetGlueSettings();
  
  SnapSettingsType getSnapSettings();
  
  boolean isSetSnapSettings();
  
  void setSnapSettings(SnapSettingsType paramSnapSettingsType);
  
  SnapSettingsType addNewSnapSettings();
  
  void unsetSnapSettings();
  
  SnapExtensionsType getSnapExtensions();
  
  boolean isSetSnapExtensions();
  
  void setSnapExtensions(SnapExtensionsType paramSnapExtensionsType);
  
  SnapExtensionsType addNewSnapExtensions();
  
  void unsetSnapExtensions();
  
  SnapAnglesType getSnapAngles();
  
  boolean isSetSnapAngles();
  
  void setSnapAngles(SnapAnglesType paramSnapAnglesType);
  
  SnapAnglesType addNewSnapAngles();
  
  void unsetSnapAngles();
  
  DynamicGridEnabledType getDynamicGridEnabled();
  
  boolean isSetDynamicGridEnabled();
  
  void setDynamicGridEnabled(DynamicGridEnabledType paramDynamicGridEnabledType);
  
  DynamicGridEnabledType addNewDynamicGridEnabled();
  
  void unsetDynamicGridEnabled();
  
  ProtectStylesType getProtectStyles();
  
  boolean isSetProtectStyles();
  
  void setProtectStyles(ProtectStylesType paramProtectStylesType);
  
  ProtectStylesType addNewProtectStyles();
  
  void unsetProtectStyles();
  
  ProtectShapesType getProtectShapes();
  
  boolean isSetProtectShapes();
  
  void setProtectShapes(ProtectShapesType paramProtectShapesType);
  
  ProtectShapesType addNewProtectShapes();
  
  void unsetProtectShapes();
  
  ProtectMastersType getProtectMasters();
  
  boolean isSetProtectMasters();
  
  void setProtectMasters(ProtectMastersType paramProtectMastersType);
  
  ProtectMastersType addNewProtectMasters();
  
  void unsetProtectMasters();
  
  ProtectBkgndsType getProtectBkgnds();
  
  boolean isSetProtectBkgnds();
  
  void setProtectBkgnds(ProtectBkgndsType paramProtectBkgndsType);
  
  ProtectBkgndsType addNewProtectBkgnds();
  
  void unsetProtectBkgnds();
  
  CustomMenusFileType getCustomMenusFile();
  
  boolean isSetCustomMenusFile();
  
  void setCustomMenusFile(CustomMenusFileType paramCustomMenusFileType);
  
  CustomMenusFileType addNewCustomMenusFile();
  
  void unsetCustomMenusFile();
  
  CustomToolbarsFileType getCustomToolbarsFile();
  
  boolean isSetCustomToolbarsFile();
  
  void setCustomToolbarsFile(CustomToolbarsFileType paramCustomToolbarsFileType);
  
  CustomToolbarsFileType addNewCustomToolbarsFile();
  
  void unsetCustomToolbarsFile();
  
  AttachedToolbarsType getAttachedToolbars();
  
  boolean isSetAttachedToolbars();
  
  void setAttachedToolbars(AttachedToolbarsType paramAttachedToolbarsType);
  
  AttachedToolbarsType addNewAttachedToolbars();
  
  void unsetAttachedToolbars();
  
  long getTopPage();
  
  XmlUnsignedInt xgetTopPage();
  
  boolean isSetTopPage();
  
  void setTopPage(long paramLong);
  
  void xsetTopPage(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTopPage();
  
  long getDefaultTextStyle();
  
  XmlUnsignedInt xgetDefaultTextStyle();
  
  boolean isSetDefaultTextStyle();
  
  void setDefaultTextStyle(long paramLong);
  
  void xsetDefaultTextStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDefaultTextStyle();
  
  long getDefaultLineStyle();
  
  XmlUnsignedInt xgetDefaultLineStyle();
  
  boolean isSetDefaultLineStyle();
  
  void setDefaultLineStyle(long paramLong);
  
  void xsetDefaultLineStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDefaultLineStyle();
  
  long getDefaultFillStyle();
  
  XmlUnsignedInt xgetDefaultFillStyle();
  
  boolean isSetDefaultFillStyle();
  
  void setDefaultFillStyle(long paramLong);
  
  void xsetDefaultFillStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDefaultFillStyle();
  
  long getDefaultGuideStyle();
  
  XmlUnsignedInt xgetDefaultGuideStyle();
  
  boolean isSetDefaultGuideStyle();
  
  void setDefaultGuideStyle(long paramLong);
  
  void xsetDefaultGuideStyle(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetDefaultGuideStyle();
  
  public static final class Factory {
    public static DocumentSettingsType newInstance() {
      return (DocumentSettingsType)POIXMLTypeLoader.newInstance(DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType newInstance(XmlOptions param1XmlOptions) {
      return (DocumentSettingsType)POIXMLTypeLoader.newInstance(DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(String param1String) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1String, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1String, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(File param1File) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1File, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1File, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(URL param1URL) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1URL, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1URL, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1InputStream, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1InputStream, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(Reader param1Reader) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1Reader, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1Reader, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1XMLStreamReader, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1XMLStreamReader, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(Node param1Node) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1Node, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1Node, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static DocumentSettingsType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1XMLInputStream, DocumentSettingsType.type, null);
    }
    
    public static DocumentSettingsType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (DocumentSettingsType)POIXMLTypeLoader.parse(param1XMLInputStream, DocumentSettingsType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, DocumentSettingsType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, DocumentSettingsType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\DocumentSettingsType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */