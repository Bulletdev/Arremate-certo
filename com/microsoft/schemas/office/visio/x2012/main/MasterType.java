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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface MasterType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(MasterType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("mastertype2d97type");
  
  PageSheetType getPageSheet();
  
  boolean isSetPageSheet();
  
  void setPageSheet(PageSheetType paramPageSheetType);
  
  PageSheetType addNewPageSheet();
  
  void unsetPageSheet();
  
  RelType getRel();
  
  void setRel(RelType paramRelType);
  
  RelType addNewRel();
  
  IconType getIcon();
  
  boolean isSetIcon();
  
  void setIcon(IconType paramIconType);
  
  IconType addNewIcon();
  
  void unsetIcon();
  
  long getID();
  
  XmlUnsignedInt xgetID();
  
  void setID(long paramLong);
  
  void xsetID(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getBaseID();
  
  XmlString xgetBaseID();
  
  boolean isSetBaseID();
  
  void setBaseID(String paramString);
  
  void xsetBaseID(XmlString paramXmlString);
  
  void unsetBaseID();
  
  String getUniqueID();
  
  XmlString xgetUniqueID();
  
  boolean isSetUniqueID();
  
  void setUniqueID(String paramString);
  
  void xsetUniqueID(XmlString paramXmlString);
  
  void unsetUniqueID();
  
  boolean getMatchByName();
  
  XmlBoolean xgetMatchByName();
  
  boolean isSetMatchByName();
  
  void setMatchByName(boolean paramBoolean);
  
  void xsetMatchByName(XmlBoolean paramXmlBoolean);
  
  void unsetMatchByName();
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  String getNameU();
  
  XmlString xgetNameU();
  
  boolean isSetNameU();
  
  void setNameU(String paramString);
  
  void xsetNameU(XmlString paramXmlString);
  
  void unsetNameU();
  
  boolean getIsCustomName();
  
  XmlBoolean xgetIsCustomName();
  
  boolean isSetIsCustomName();
  
  void setIsCustomName(boolean paramBoolean);
  
  void xsetIsCustomName(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomName();
  
  boolean getIsCustomNameU();
  
  XmlBoolean xgetIsCustomNameU();
  
  boolean isSetIsCustomNameU();
  
  void setIsCustomNameU(boolean paramBoolean);
  
  void xsetIsCustomNameU(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomNameU();
  
  int getIconSize();
  
  XmlUnsignedShort xgetIconSize();
  
  boolean isSetIconSize();
  
  void setIconSize(int paramInt);
  
  void xsetIconSize(XmlUnsignedShort paramXmlUnsignedShort);
  
  void unsetIconSize();
  
  int getPatternFlags();
  
  XmlUnsignedShort xgetPatternFlags();
  
  boolean isSetPatternFlags();
  
  void setPatternFlags(int paramInt);
  
  void xsetPatternFlags(XmlUnsignedShort paramXmlUnsignedShort);
  
  void unsetPatternFlags();
  
  String getPrompt();
  
  XmlString xgetPrompt();
  
  boolean isSetPrompt();
  
  void setPrompt(String paramString);
  
  void xsetPrompt(XmlString paramXmlString);
  
  void unsetPrompt();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  boolean getIconUpdate();
  
  XmlBoolean xgetIconUpdate();
  
  boolean isSetIconUpdate();
  
  void setIconUpdate(boolean paramBoolean);
  
  void xsetIconUpdate(XmlBoolean paramXmlBoolean);
  
  void unsetIconUpdate();
  
  int getAlignName();
  
  XmlUnsignedShort xgetAlignName();
  
  boolean isSetAlignName();
  
  void setAlignName(int paramInt);
  
  void xsetAlignName(XmlUnsignedShort paramXmlUnsignedShort);
  
  void unsetAlignName();
  
  int getMasterType();
  
  XmlUnsignedShort xgetMasterType();
  
  boolean isSetMasterType();
  
  void setMasterType(int paramInt);
  
  void xsetMasterType(XmlUnsignedShort paramXmlUnsignedShort);
  
  void unsetMasterType();
  
  public static final class Factory {
    public static MasterType newInstance() {
      return (MasterType)POIXMLTypeLoader.newInstance(MasterType.type, null);
    }
    
    public static MasterType newInstance(XmlOptions param1XmlOptions) {
      return (MasterType)POIXMLTypeLoader.newInstance(MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(String param1String) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1String, MasterType.type, null);
    }
    
    public static MasterType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1String, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(File param1File) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1File, MasterType.type, null);
    }
    
    public static MasterType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1File, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(URL param1URL) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1URL, MasterType.type, null);
    }
    
    public static MasterType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1URL, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1InputStream, MasterType.type, null);
    }
    
    public static MasterType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1InputStream, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(Reader param1Reader) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1Reader, MasterType.type, null);
    }
    
    public static MasterType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MasterType)POIXMLTypeLoader.parse(param1Reader, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1XMLStreamReader, MasterType.type, null);
    }
    
    public static MasterType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1XMLStreamReader, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(Node param1Node) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1Node, MasterType.type, null);
    }
    
    public static MasterType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (MasterType)POIXMLTypeLoader.parse(param1Node, MasterType.type, param1XmlOptions);
    }
    
    public static MasterType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (MasterType)POIXMLTypeLoader.parse(param1XMLInputStream, MasterType.type, null);
    }
    
    public static MasterType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (MasterType)POIXMLTypeLoader.parse(param1XMLInputStream, MasterType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MasterType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MasterType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\MasterType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */