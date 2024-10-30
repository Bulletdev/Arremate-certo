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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCacheField extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCacheField.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcachefieldae21type");
  
  CTSharedItems getSharedItems();
  
  boolean isSetSharedItems();
  
  void setSharedItems(CTSharedItems paramCTSharedItems);
  
  CTSharedItems addNewSharedItems();
  
  void unsetSharedItems();
  
  CTFieldGroup getFieldGroup();
  
  boolean isSetFieldGroup();
  
  void setFieldGroup(CTFieldGroup paramCTFieldGroup);
  
  CTFieldGroup addNewFieldGroup();
  
  void unsetFieldGroup();
  
  List<CTX> getMpMapList();
  
  CTX[] getMpMapArray();
  
  CTX getMpMapArray(int paramInt);
  
  int sizeOfMpMapArray();
  
  void setMpMapArray(CTX[] paramArrayOfCTX);
  
  void setMpMapArray(int paramInt, CTX paramCTX);
  
  CTX insertNewMpMap(int paramInt);
  
  CTX addNewMpMap();
  
  void removeMpMap(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  String getCaption();
  
  STXstring xgetCaption();
  
  boolean isSetCaption();
  
  void setCaption(String paramString);
  
  void xsetCaption(STXstring paramSTXstring);
  
  void unsetCaption();
  
  String getPropertyName();
  
  STXstring xgetPropertyName();
  
  boolean isSetPropertyName();
  
  void setPropertyName(String paramString);
  
  void xsetPropertyName(STXstring paramSTXstring);
  
  void unsetPropertyName();
  
  boolean getServerField();
  
  XmlBoolean xgetServerField();
  
  boolean isSetServerField();
  
  void setServerField(boolean paramBoolean);
  
  void xsetServerField(XmlBoolean paramXmlBoolean);
  
  void unsetServerField();
  
  boolean getUniqueList();
  
  XmlBoolean xgetUniqueList();
  
  boolean isSetUniqueList();
  
  void setUniqueList(boolean paramBoolean);
  
  void xsetUniqueList(XmlBoolean paramXmlBoolean);
  
  void unsetUniqueList();
  
  long getNumFmtId();
  
  STNumFmtId xgetNumFmtId();
  
  boolean isSetNumFmtId();
  
  void setNumFmtId(long paramLong);
  
  void xsetNumFmtId(STNumFmtId paramSTNumFmtId);
  
  void unsetNumFmtId();
  
  String getFormula();
  
  STXstring xgetFormula();
  
  boolean isSetFormula();
  
  void setFormula(String paramString);
  
  void xsetFormula(STXstring paramSTXstring);
  
  void unsetFormula();
  
  int getSqlType();
  
  XmlInt xgetSqlType();
  
  boolean isSetSqlType();
  
  void setSqlType(int paramInt);
  
  void xsetSqlType(XmlInt paramXmlInt);
  
  void unsetSqlType();
  
  int getHierarchy();
  
  XmlInt xgetHierarchy();
  
  boolean isSetHierarchy();
  
  void setHierarchy(int paramInt);
  
  void xsetHierarchy(XmlInt paramXmlInt);
  
  void unsetHierarchy();
  
  long getLevel();
  
  XmlUnsignedInt xgetLevel();
  
  boolean isSetLevel();
  
  void setLevel(long paramLong);
  
  void xsetLevel(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetLevel();
  
  boolean getDatabaseField();
  
  XmlBoolean xgetDatabaseField();
  
  boolean isSetDatabaseField();
  
  void setDatabaseField(boolean paramBoolean);
  
  void xsetDatabaseField(XmlBoolean paramXmlBoolean);
  
  void unsetDatabaseField();
  
  long getMappingCount();
  
  XmlUnsignedInt xgetMappingCount();
  
  boolean isSetMappingCount();
  
  void setMappingCount(long paramLong);
  
  void xsetMappingCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMappingCount();
  
  boolean getMemberPropertyField();
  
  XmlBoolean xgetMemberPropertyField();
  
  boolean isSetMemberPropertyField();
  
  void setMemberPropertyField(boolean paramBoolean);
  
  void xsetMemberPropertyField(XmlBoolean paramXmlBoolean);
  
  void unsetMemberPropertyField();
  
  public static final class Factory {
    public static CTCacheField newInstance() {
      return (CTCacheField)POIXMLTypeLoader.newInstance(CTCacheField.type, null);
    }
    
    public static CTCacheField newInstance(XmlOptions param1XmlOptions) {
      return (CTCacheField)POIXMLTypeLoader.newInstance(CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(String param1String) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1String, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1String, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(File param1File) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1File, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1File, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(URL param1URL) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1URL, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1URL, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1InputStream, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1InputStream, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1Reader, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1Reader, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(Node param1Node) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1Node, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1Node, CTCacheField.type, param1XmlOptions);
    }
    
    public static CTCacheField parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheField.type, null);
    }
    
    public static CTCacheField parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCacheField)POIXMLTypeLoader.parse(param1XMLInputStream, CTCacheField.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheField.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCacheField.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCacheField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */