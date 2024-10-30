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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTPivotCacheDefinition extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPivotCacheDefinition.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpivotcachedefinition575ctype");
  
  CTCacheSource getCacheSource();
  
  void setCacheSource(CTCacheSource paramCTCacheSource);
  
  CTCacheSource addNewCacheSource();
  
  CTCacheFields getCacheFields();
  
  void setCacheFields(CTCacheFields paramCTCacheFields);
  
  CTCacheFields addNewCacheFields();
  
  CTCacheHierarchies getCacheHierarchies();
  
  boolean isSetCacheHierarchies();
  
  void setCacheHierarchies(CTCacheHierarchies paramCTCacheHierarchies);
  
  CTCacheHierarchies addNewCacheHierarchies();
  
  void unsetCacheHierarchies();
  
  CTPCDKPIs getKpis();
  
  boolean isSetKpis();
  
  void setKpis(CTPCDKPIs paramCTPCDKPIs);
  
  CTPCDKPIs addNewKpis();
  
  void unsetKpis();
  
  CTTupleCache getTupleCache();
  
  boolean isSetTupleCache();
  
  void setTupleCache(CTTupleCache paramCTTupleCache);
  
  CTTupleCache addNewTupleCache();
  
  void unsetTupleCache();
  
  CTCalculatedItems getCalculatedItems();
  
  boolean isSetCalculatedItems();
  
  void setCalculatedItems(CTCalculatedItems paramCTCalculatedItems);
  
  CTCalculatedItems addNewCalculatedItems();
  
  void unsetCalculatedItems();
  
  CTCalculatedMembers getCalculatedMembers();
  
  boolean isSetCalculatedMembers();
  
  void setCalculatedMembers(CTCalculatedMembers paramCTCalculatedMembers);
  
  CTCalculatedMembers addNewCalculatedMembers();
  
  void unsetCalculatedMembers();
  
  CTDimensions getDimensions();
  
  boolean isSetDimensions();
  
  void setDimensions(CTDimensions paramCTDimensions);
  
  CTDimensions addNewDimensions();
  
  void unsetDimensions();
  
  CTMeasureGroups getMeasureGroups();
  
  boolean isSetMeasureGroups();
  
  void setMeasureGroups(CTMeasureGroups paramCTMeasureGroups);
  
  CTMeasureGroups addNewMeasureGroups();
  
  void unsetMeasureGroups();
  
  CTMeasureDimensionMaps getMaps();
  
  boolean isSetMaps();
  
  void setMaps(CTMeasureDimensionMaps paramCTMeasureDimensionMaps);
  
  CTMeasureDimensionMaps addNewMaps();
  
  void unsetMaps();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  String getId();
  
  STRelationshipId xgetId();
  
  boolean isSetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  void unsetId();
  
  boolean getInvalid();
  
  XmlBoolean xgetInvalid();
  
  boolean isSetInvalid();
  
  void setInvalid(boolean paramBoolean);
  
  void xsetInvalid(XmlBoolean paramXmlBoolean);
  
  void unsetInvalid();
  
  boolean getSaveData();
  
  XmlBoolean xgetSaveData();
  
  boolean isSetSaveData();
  
  void setSaveData(boolean paramBoolean);
  
  void xsetSaveData(XmlBoolean paramXmlBoolean);
  
  void unsetSaveData();
  
  boolean getRefreshOnLoad();
  
  XmlBoolean xgetRefreshOnLoad();
  
  boolean isSetRefreshOnLoad();
  
  void setRefreshOnLoad(boolean paramBoolean);
  
  void xsetRefreshOnLoad(XmlBoolean paramXmlBoolean);
  
  void unsetRefreshOnLoad();
  
  boolean getOptimizeMemory();
  
  XmlBoolean xgetOptimizeMemory();
  
  boolean isSetOptimizeMemory();
  
  void setOptimizeMemory(boolean paramBoolean);
  
  void xsetOptimizeMemory(XmlBoolean paramXmlBoolean);
  
  void unsetOptimizeMemory();
  
  boolean getEnableRefresh();
  
  XmlBoolean xgetEnableRefresh();
  
  boolean isSetEnableRefresh();
  
  void setEnableRefresh(boolean paramBoolean);
  
  void xsetEnableRefresh(XmlBoolean paramXmlBoolean);
  
  void unsetEnableRefresh();
  
  String getRefreshedBy();
  
  STXstring xgetRefreshedBy();
  
  boolean isSetRefreshedBy();
  
  void setRefreshedBy(String paramString);
  
  void xsetRefreshedBy(STXstring paramSTXstring);
  
  void unsetRefreshedBy();
  
  double getRefreshedDate();
  
  XmlDouble xgetRefreshedDate();
  
  boolean isSetRefreshedDate();
  
  void setRefreshedDate(double paramDouble);
  
  void xsetRefreshedDate(XmlDouble paramXmlDouble);
  
  void unsetRefreshedDate();
  
  boolean getBackgroundQuery();
  
  XmlBoolean xgetBackgroundQuery();
  
  boolean isSetBackgroundQuery();
  
  void setBackgroundQuery(boolean paramBoolean);
  
  void xsetBackgroundQuery(XmlBoolean paramXmlBoolean);
  
  void unsetBackgroundQuery();
  
  long getMissingItemsLimit();
  
  XmlUnsignedInt xgetMissingItemsLimit();
  
  boolean isSetMissingItemsLimit();
  
  void setMissingItemsLimit(long paramLong);
  
  void xsetMissingItemsLimit(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetMissingItemsLimit();
  
  short getCreatedVersion();
  
  XmlUnsignedByte xgetCreatedVersion();
  
  boolean isSetCreatedVersion();
  
  void setCreatedVersion(short paramShort);
  
  void xsetCreatedVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetCreatedVersion();
  
  short getRefreshedVersion();
  
  XmlUnsignedByte xgetRefreshedVersion();
  
  boolean isSetRefreshedVersion();
  
  void setRefreshedVersion(short paramShort);
  
  void xsetRefreshedVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetRefreshedVersion();
  
  short getMinRefreshableVersion();
  
  XmlUnsignedByte xgetMinRefreshableVersion();
  
  boolean isSetMinRefreshableVersion();
  
  void setMinRefreshableVersion(short paramShort);
  
  void xsetMinRefreshableVersion(XmlUnsignedByte paramXmlUnsignedByte);
  
  void unsetMinRefreshableVersion();
  
  long getRecordCount();
  
  XmlUnsignedInt xgetRecordCount();
  
  boolean isSetRecordCount();
  
  void setRecordCount(long paramLong);
  
  void xsetRecordCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetRecordCount();
  
  boolean getUpgradeOnRefresh();
  
  XmlBoolean xgetUpgradeOnRefresh();
  
  boolean isSetUpgradeOnRefresh();
  
  void setUpgradeOnRefresh(boolean paramBoolean);
  
  void xsetUpgradeOnRefresh(XmlBoolean paramXmlBoolean);
  
  void unsetUpgradeOnRefresh();
  
  boolean getTupleCache2();
  
  XmlBoolean xgetTupleCache2();
  
  boolean isSetTupleCache2();
  
  void setTupleCache2(boolean paramBoolean);
  
  void xsetTupleCache2(XmlBoolean paramXmlBoolean);
  
  void unsetTupleCache2();
  
  boolean getSupportSubquery();
  
  XmlBoolean xgetSupportSubquery();
  
  boolean isSetSupportSubquery();
  
  void setSupportSubquery(boolean paramBoolean);
  
  void xsetSupportSubquery(XmlBoolean paramXmlBoolean);
  
  void unsetSupportSubquery();
  
  boolean getSupportAdvancedDrill();
  
  XmlBoolean xgetSupportAdvancedDrill();
  
  boolean isSetSupportAdvancedDrill();
  
  void setSupportAdvancedDrill(boolean paramBoolean);
  
  void xsetSupportAdvancedDrill(XmlBoolean paramXmlBoolean);
  
  void unsetSupportAdvancedDrill();
  
  public static final class Factory {
    public static CTPivotCacheDefinition newInstance() {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.newInstance(CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition newInstance(XmlOptions param1XmlOptions) {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.newInstance(CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(String param1String) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1String, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1String, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(File param1File) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1File, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1File, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(URL param1URL) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1URL, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1URL, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1InputStream, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1InputStream, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1Reader, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1Reader, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(Node param1Node) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1Node, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1Node, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static CTPivotCacheDefinition parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCacheDefinition.type, null);
    }
    
    public static CTPivotCacheDefinition parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPivotCacheDefinition)POIXMLTypeLoader.parse(param1XMLInputStream, CTPivotCacheDefinition.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCacheDefinition.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPivotCacheDefinition.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPivotCacheDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */