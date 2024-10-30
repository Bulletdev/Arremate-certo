package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheHierarchies;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalculatedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalculatedMembers;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDimensions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMeasureDimensionMaps;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMeasureGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPCDKPIs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTupleCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXstring;

public class CTPivotCacheDefinitionImpl extends XmlComplexContentImpl implements CTPivotCacheDefinition {
  private static final b CACHESOURCE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheSource");
  
  private static final b CACHEFIELDS$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheFields");
  
  private static final b CACHEHIERARCHIES$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "cacheHierarchies");
  
  private static final b KPIS$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "kpis");
  
  private static final b TUPLECACHE$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "tupleCache");
  
  private static final b CALCULATEDITEMS$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedItems");
  
  private static final b CALCULATEDMEMBERS$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calculatedMembers");
  
  private static final b DIMENSIONS$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "dimensions");
  
  private static final b MEASUREGROUPS$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "measureGroups");
  
  private static final b MAPS$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "maps");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b ID$22 = new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
  
  private static final b INVALID$24 = new b("", "invalid");
  
  private static final b SAVEDATA$26 = new b("", "saveData");
  
  private static final b REFRESHONLOAD$28 = new b("", "refreshOnLoad");
  
  private static final b OPTIMIZEMEMORY$30 = new b("", "optimizeMemory");
  
  private static final b ENABLEREFRESH$32 = new b("", "enableRefresh");
  
  private static final b REFRESHEDBY$34 = new b("", "refreshedBy");
  
  private static final b REFRESHEDDATE$36 = new b("", "refreshedDate");
  
  private static final b BACKGROUNDQUERY$38 = new b("", "backgroundQuery");
  
  private static final b MISSINGITEMSLIMIT$40 = new b("", "missingItemsLimit");
  
  private static final b CREATEDVERSION$42 = new b("", "createdVersion");
  
  private static final b REFRESHEDVERSION$44 = new b("", "refreshedVersion");
  
  private static final b MINREFRESHABLEVERSION$46 = new b("", "minRefreshableVersion");
  
  private static final b RECORDCOUNT$48 = new b("", "recordCount");
  
  private static final b UPGRADEONREFRESH$50 = new b("", "upgradeOnRefresh");
  
  private static final b TUPLECACHE2$52 = new b("", "tupleCache");
  
  private static final b SUPPORTSUBQUERY$54 = new b("", "supportSubquery");
  
  private static final b SUPPORTADVANCEDDRILL$56 = new b("", "supportAdvancedDrill");
  
  public CTPivotCacheDefinitionImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTCacheSource getCacheSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheSource cTCacheSource = null;
      cTCacheSource = (CTCacheSource)get_store().find_element_user(CACHESOURCE$0, 0);
      if (cTCacheSource == null)
        return null; 
      return cTCacheSource;
    } 
  }
  
  public void setCacheSource(CTCacheSource paramCTCacheSource) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheSource cTCacheSource = null;
      cTCacheSource = (CTCacheSource)get_store().find_element_user(CACHESOURCE$0, 0);
      if (cTCacheSource == null)
        cTCacheSource = (CTCacheSource)get_store().add_element_user(CACHESOURCE$0); 
      cTCacheSource.set((XmlObject)paramCTCacheSource);
    } 
  }
  
  public CTCacheSource addNewCacheSource() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheSource cTCacheSource = null;
      cTCacheSource = (CTCacheSource)get_store().add_element_user(CACHESOURCE$0);
      return cTCacheSource;
    } 
  }
  
  public CTCacheFields getCacheFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheFields cTCacheFields = null;
      cTCacheFields = (CTCacheFields)get_store().find_element_user(CACHEFIELDS$2, 0);
      if (cTCacheFields == null)
        return null; 
      return cTCacheFields;
    } 
  }
  
  public void setCacheFields(CTCacheFields paramCTCacheFields) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheFields cTCacheFields = null;
      cTCacheFields = (CTCacheFields)get_store().find_element_user(CACHEFIELDS$2, 0);
      if (cTCacheFields == null)
        cTCacheFields = (CTCacheFields)get_store().add_element_user(CACHEFIELDS$2); 
      cTCacheFields.set((XmlObject)paramCTCacheFields);
    } 
  }
  
  public CTCacheFields addNewCacheFields() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheFields cTCacheFields = null;
      cTCacheFields = (CTCacheFields)get_store().add_element_user(CACHEFIELDS$2);
      return cTCacheFields;
    } 
  }
  
  public CTCacheHierarchies getCacheHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheHierarchies cTCacheHierarchies = null;
      cTCacheHierarchies = (CTCacheHierarchies)get_store().find_element_user(CACHEHIERARCHIES$4, 0);
      if (cTCacheHierarchies == null)
        return null; 
      return cTCacheHierarchies;
    } 
  }
  
  public boolean isSetCacheHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CACHEHIERARCHIES$4) != 0);
    } 
  }
  
  public void setCacheHierarchies(CTCacheHierarchies paramCTCacheHierarchies) {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheHierarchies cTCacheHierarchies = null;
      cTCacheHierarchies = (CTCacheHierarchies)get_store().find_element_user(CACHEHIERARCHIES$4, 0);
      if (cTCacheHierarchies == null)
        cTCacheHierarchies = (CTCacheHierarchies)get_store().add_element_user(CACHEHIERARCHIES$4); 
      cTCacheHierarchies.set((XmlObject)paramCTCacheHierarchies);
    } 
  }
  
  public CTCacheHierarchies addNewCacheHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      CTCacheHierarchies cTCacheHierarchies = null;
      cTCacheHierarchies = (CTCacheHierarchies)get_store().add_element_user(CACHEHIERARCHIES$4);
      return cTCacheHierarchies;
    } 
  }
  
  public void unsetCacheHierarchies() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CACHEHIERARCHIES$4, 0);
    } 
  }
  
  public CTPCDKPIs getKpis() {
    synchronized (monitor()) {
      check_orphaned();
      CTPCDKPIs cTPCDKPIs = null;
      cTPCDKPIs = (CTPCDKPIs)get_store().find_element_user(KPIS$6, 0);
      if (cTPCDKPIs == null)
        return null; 
      return cTPCDKPIs;
    } 
  }
  
  public boolean isSetKpis() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(KPIS$6) != 0);
    } 
  }
  
  public void setKpis(CTPCDKPIs paramCTPCDKPIs) {
    synchronized (monitor()) {
      check_orphaned();
      CTPCDKPIs cTPCDKPIs = null;
      cTPCDKPIs = (CTPCDKPIs)get_store().find_element_user(KPIS$6, 0);
      if (cTPCDKPIs == null)
        cTPCDKPIs = (CTPCDKPIs)get_store().add_element_user(KPIS$6); 
      cTPCDKPIs.set((XmlObject)paramCTPCDKPIs);
    } 
  }
  
  public CTPCDKPIs addNewKpis() {
    synchronized (monitor()) {
      check_orphaned();
      CTPCDKPIs cTPCDKPIs = null;
      cTPCDKPIs = (CTPCDKPIs)get_store().add_element_user(KPIS$6);
      return cTPCDKPIs;
    } 
  }
  
  public void unsetKpis() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(KPIS$6, 0);
    } 
  }
  
  public CTTupleCache getTupleCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTTupleCache cTTupleCache = null;
      cTTupleCache = (CTTupleCache)get_store().find_element_user(TUPLECACHE$8, 0);
      if (cTTupleCache == null)
        return null; 
      return cTTupleCache;
    } 
  }
  
  public boolean isSetTupleCache() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TUPLECACHE$8) != 0);
    } 
  }
  
  public void setTupleCache(CTTupleCache paramCTTupleCache) {
    synchronized (monitor()) {
      check_orphaned();
      CTTupleCache cTTupleCache = null;
      cTTupleCache = (CTTupleCache)get_store().find_element_user(TUPLECACHE$8, 0);
      if (cTTupleCache == null)
        cTTupleCache = (CTTupleCache)get_store().add_element_user(TUPLECACHE$8); 
      cTTupleCache.set((XmlObject)paramCTTupleCache);
    } 
  }
  
  public CTTupleCache addNewTupleCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTTupleCache cTTupleCache = null;
      cTTupleCache = (CTTupleCache)get_store().add_element_user(TUPLECACHE$8);
      return cTTupleCache;
    } 
  }
  
  public void unsetTupleCache() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TUPLECACHE$8, 0);
    } 
  }
  
  public CTCalculatedItems getCalculatedItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedItems cTCalculatedItems = null;
      cTCalculatedItems = (CTCalculatedItems)get_store().find_element_user(CALCULATEDITEMS$10, 0);
      if (cTCalculatedItems == null)
        return null; 
      return cTCalculatedItems;
    } 
  }
  
  public boolean isSetCalculatedItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CALCULATEDITEMS$10) != 0);
    } 
  }
  
  public void setCalculatedItems(CTCalculatedItems paramCTCalculatedItems) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedItems cTCalculatedItems = null;
      cTCalculatedItems = (CTCalculatedItems)get_store().find_element_user(CALCULATEDITEMS$10, 0);
      if (cTCalculatedItems == null)
        cTCalculatedItems = (CTCalculatedItems)get_store().add_element_user(CALCULATEDITEMS$10); 
      cTCalculatedItems.set((XmlObject)paramCTCalculatedItems);
    } 
  }
  
  public CTCalculatedItems addNewCalculatedItems() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedItems cTCalculatedItems = null;
      cTCalculatedItems = (CTCalculatedItems)get_store().add_element_user(CALCULATEDITEMS$10);
      return cTCalculatedItems;
    } 
  }
  
  public void unsetCalculatedItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALCULATEDITEMS$10, 0);
    } 
  }
  
  public CTCalculatedMembers getCalculatedMembers() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedMembers cTCalculatedMembers = null;
      cTCalculatedMembers = (CTCalculatedMembers)get_store().find_element_user(CALCULATEDMEMBERS$12, 0);
      if (cTCalculatedMembers == null)
        return null; 
      return cTCalculatedMembers;
    } 
  }
  
  public boolean isSetCalculatedMembers() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CALCULATEDMEMBERS$12) != 0);
    } 
  }
  
  public void setCalculatedMembers(CTCalculatedMembers paramCTCalculatedMembers) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedMembers cTCalculatedMembers = null;
      cTCalculatedMembers = (CTCalculatedMembers)get_store().find_element_user(CALCULATEDMEMBERS$12, 0);
      if (cTCalculatedMembers == null)
        cTCalculatedMembers = (CTCalculatedMembers)get_store().add_element_user(CALCULATEDMEMBERS$12); 
      cTCalculatedMembers.set((XmlObject)paramCTCalculatedMembers);
    } 
  }
  
  public CTCalculatedMembers addNewCalculatedMembers() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalculatedMembers cTCalculatedMembers = null;
      cTCalculatedMembers = (CTCalculatedMembers)get_store().add_element_user(CALCULATEDMEMBERS$12);
      return cTCalculatedMembers;
    } 
  }
  
  public void unsetCalculatedMembers() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALCULATEDMEMBERS$12, 0);
    } 
  }
  
  public CTDimensions getDimensions() {
    synchronized (monitor()) {
      check_orphaned();
      CTDimensions cTDimensions = null;
      cTDimensions = (CTDimensions)get_store().find_element_user(DIMENSIONS$14, 0);
      if (cTDimensions == null)
        return null; 
      return cTDimensions;
    } 
  }
  
  public boolean isSetDimensions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DIMENSIONS$14) != 0);
    } 
  }
  
  public void setDimensions(CTDimensions paramCTDimensions) {
    synchronized (monitor()) {
      check_orphaned();
      CTDimensions cTDimensions = null;
      cTDimensions = (CTDimensions)get_store().find_element_user(DIMENSIONS$14, 0);
      if (cTDimensions == null)
        cTDimensions = (CTDimensions)get_store().add_element_user(DIMENSIONS$14); 
      cTDimensions.set((XmlObject)paramCTDimensions);
    } 
  }
  
  public CTDimensions addNewDimensions() {
    synchronized (monitor()) {
      check_orphaned();
      CTDimensions cTDimensions = null;
      cTDimensions = (CTDimensions)get_store().add_element_user(DIMENSIONS$14);
      return cTDimensions;
    } 
  }
  
  public void unsetDimensions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DIMENSIONS$14, 0);
    } 
  }
  
  public CTMeasureGroups getMeasureGroups() {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureGroups cTMeasureGroups = null;
      cTMeasureGroups = (CTMeasureGroups)get_store().find_element_user(MEASUREGROUPS$16, 0);
      if (cTMeasureGroups == null)
        return null; 
      return cTMeasureGroups;
    } 
  }
  
  public boolean isSetMeasureGroups() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MEASUREGROUPS$16) != 0);
    } 
  }
  
  public void setMeasureGroups(CTMeasureGroups paramCTMeasureGroups) {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureGroups cTMeasureGroups = null;
      cTMeasureGroups = (CTMeasureGroups)get_store().find_element_user(MEASUREGROUPS$16, 0);
      if (cTMeasureGroups == null)
        cTMeasureGroups = (CTMeasureGroups)get_store().add_element_user(MEASUREGROUPS$16); 
      cTMeasureGroups.set((XmlObject)paramCTMeasureGroups);
    } 
  }
  
  public CTMeasureGroups addNewMeasureGroups() {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureGroups cTMeasureGroups = null;
      cTMeasureGroups = (CTMeasureGroups)get_store().add_element_user(MEASUREGROUPS$16);
      return cTMeasureGroups;
    } 
  }
  
  public void unsetMeasureGroups() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MEASUREGROUPS$16, 0);
    } 
  }
  
  public CTMeasureDimensionMaps getMaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureDimensionMaps cTMeasureDimensionMaps = null;
      cTMeasureDimensionMaps = (CTMeasureDimensionMaps)get_store().find_element_user(MAPS$18, 0);
      if (cTMeasureDimensionMaps == null)
        return null; 
      return cTMeasureDimensionMaps;
    } 
  }
  
  public boolean isSetMaps() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MAPS$18) != 0);
    } 
  }
  
  public void setMaps(CTMeasureDimensionMaps paramCTMeasureDimensionMaps) {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureDimensionMaps cTMeasureDimensionMaps = null;
      cTMeasureDimensionMaps = (CTMeasureDimensionMaps)get_store().find_element_user(MAPS$18, 0);
      if (cTMeasureDimensionMaps == null)
        cTMeasureDimensionMaps = (CTMeasureDimensionMaps)get_store().add_element_user(MAPS$18); 
      cTMeasureDimensionMaps.set((XmlObject)paramCTMeasureDimensionMaps);
    } 
  }
  
  public CTMeasureDimensionMaps addNewMaps() {
    synchronized (monitor()) {
      check_orphaned();
      CTMeasureDimensionMaps cTMeasureDimensionMaps = null;
      cTMeasureDimensionMaps = (CTMeasureDimensionMaps)get_store().add_element_user(MAPS$18);
      return cTMeasureDimensionMaps;
    } 
  }
  
  public void unsetMaps() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MAPS$18, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$20) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$20);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$20, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRelationshipId xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$22);
      return sTRelationshipId;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$22) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$22); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(STRelationshipId paramSTRelationshipId) {
    synchronized (monitor()) {
      check_orphaned();
      STRelationshipId sTRelationshipId = null;
      sTRelationshipId = (STRelationshipId)get_store().find_attribute_user(ID$22);
      if (sTRelationshipId == null)
        sTRelationshipId = (STRelationshipId)get_store().add_attribute_user(ID$22); 
      sTRelationshipId.set((XmlObject)paramSTRelationshipId);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$22);
    } 
  }
  
  public boolean getInvalid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVALID$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(INVALID$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetInvalid() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INVALID$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(INVALID$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetInvalid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INVALID$24) != null);
    } 
  }
  
  public void setInvalid(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INVALID$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INVALID$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetInvalid(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(INVALID$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(INVALID$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetInvalid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INVALID$24);
    } 
  }
  
  public boolean getSaveData() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVEDATA$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SAVEDATA$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSaveData() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVEDATA$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SAVEDATA$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSaveData() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SAVEDATA$26) != null);
    } 
  }
  
  public void setSaveData(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVEDATA$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SAVEDATA$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSaveData(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVEDATA$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SAVEDATA$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSaveData() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SAVEDATA$26);
    } 
  }
  
  public boolean getRefreshOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHONLOAD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REFRESHONLOAD$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRefreshOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REFRESHONLOAD$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(REFRESHONLOAD$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRefreshOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFRESHONLOAD$28) != null);
    } 
  }
  
  public void setRefreshOnLoad(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHONLOAD$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFRESHONLOAD$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRefreshOnLoad(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REFRESHONLOAD$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(REFRESHONLOAD$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRefreshOnLoad() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFRESHONLOAD$28);
    } 
  }
  
  public boolean getOptimizeMemory() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPTIMIZEMEMORY$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OPTIMIZEMEMORY$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetOptimizeMemory() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OPTIMIZEMEMORY$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(OPTIMIZEMEMORY$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetOptimizeMemory() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OPTIMIZEMEMORY$30) != null);
    } 
  }
  
  public void setOptimizeMemory(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OPTIMIZEMEMORY$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OPTIMIZEMEMORY$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetOptimizeMemory(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(OPTIMIZEMEMORY$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(OPTIMIZEMEMORY$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetOptimizeMemory() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OPTIMIZEMEMORY$30);
    } 
  }
  
  public boolean getEnableRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEREFRESH$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ENABLEREFRESH$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetEnableRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEREFRESH$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ENABLEREFRESH$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetEnableRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENABLEREFRESH$32) != null);
    } 
  }
  
  public void setEnableRefresh(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENABLEREFRESH$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENABLEREFRESH$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetEnableRefresh(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ENABLEREFRESH$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ENABLEREFRESH$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetEnableRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENABLEREFRESH$32);
    } 
  }
  
  public String getRefreshedBy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDBY$34);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STXstring xgetRefreshedBy() {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(REFRESHEDBY$34);
      return sTXstring;
    } 
  }
  
  public boolean isSetRefreshedBy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFRESHEDBY$34) != null);
    } 
  }
  
  public void setRefreshedBy(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDBY$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFRESHEDBY$34); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRefreshedBy(STXstring paramSTXstring) {
    synchronized (monitor()) {
      check_orphaned();
      STXstring sTXstring = null;
      sTXstring = (STXstring)get_store().find_attribute_user(REFRESHEDBY$34);
      if (sTXstring == null)
        sTXstring = (STXstring)get_store().add_attribute_user(REFRESHEDBY$34); 
      sTXstring.set((XmlObject)paramSTXstring);
    } 
  }
  
  public void unsetRefreshedBy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFRESHEDBY$34);
    } 
  }
  
  public double getRefreshedDate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDDATE$36);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetRefreshedDate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(REFRESHEDDATE$36);
      return xmlDouble;
    } 
  }
  
  public boolean isSetRefreshedDate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFRESHEDDATE$36) != null);
    } 
  }
  
  public void setRefreshedDate(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDDATE$36);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFRESHEDDATE$36); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetRefreshedDate(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(REFRESHEDDATE$36);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(REFRESHEDDATE$36); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetRefreshedDate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFRESHEDDATE$36);
    } 
  }
  
  public boolean getBackgroundQuery() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKGROUNDQUERY$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BACKGROUNDQUERY$38); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBackgroundQuery() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKGROUNDQUERY$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BACKGROUNDQUERY$38); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBackgroundQuery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BACKGROUNDQUERY$38) != null);
    } 
  }
  
  public void setBackgroundQuery(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKGROUNDQUERY$38);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BACKGROUNDQUERY$38); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBackgroundQuery(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKGROUNDQUERY$38);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BACKGROUNDQUERY$38); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBackgroundQuery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BACKGROUNDQUERY$38);
    } 
  }
  
  public long getMissingItemsLimit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetMissingItemsLimit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetMissingItemsLimit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MISSINGITEMSLIMIT$40) != null);
    } 
  }
  
  public void setMissingItemsLimit(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MISSINGITEMSLIMIT$40); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetMissingItemsLimit(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(MISSINGITEMSLIMIT$40);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(MISSINGITEMSLIMIT$40); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetMissingItemsLimit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MISSINGITEMSLIMIT$40);
    } 
  }
  
  public short getCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CREATEDVERSION$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CREATEDVERSION$42); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(CREATEDVERSION$42);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(CREATEDVERSION$42); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CREATEDVERSION$42) != null);
    } 
  }
  
  public void setCreatedVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CREATEDVERSION$42);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CREATEDVERSION$42); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetCreatedVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(CREATEDVERSION$42);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(CREATEDVERSION$42); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetCreatedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CREATEDVERSION$42);
    } 
  }
  
  public short getRefreshedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDVERSION$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REFRESHEDVERSION$44); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetRefreshedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(REFRESHEDVERSION$44);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(REFRESHEDVERSION$44); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetRefreshedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFRESHEDVERSION$44) != null);
    } 
  }
  
  public void setRefreshedVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHEDVERSION$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFRESHEDVERSION$44); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetRefreshedVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(REFRESHEDVERSION$44);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(REFRESHEDVERSION$44); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetRefreshedVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFRESHEDVERSION$44);
    } 
  }
  
  public short getMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINREFRESHABLEVERSION$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(MINREFRESHABLEVERSION$46); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(MINREFRESHABLEVERSION$46);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(MINREFRESHABLEVERSION$46); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MINREFRESHABLEVERSION$46) != null);
    } 
  }
  
  public void setMinRefreshableVersion(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MINREFRESHABLEVERSION$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MINREFRESHABLEVERSION$46); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetMinRefreshableVersion(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(MINREFRESHABLEVERSION$46);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(MINREFRESHABLEVERSION$46); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetMinRefreshableVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MINREFRESHABLEVERSION$46);
    } 
  }
  
  public long getRecordCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RECORDCOUNT$48);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetRecordCount() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RECORDCOUNT$48);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetRecordCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RECORDCOUNT$48) != null);
    } 
  }
  
  public void setRecordCount(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RECORDCOUNT$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RECORDCOUNT$48); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetRecordCount(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(RECORDCOUNT$48);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(RECORDCOUNT$48); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetRecordCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RECORDCOUNT$48);
    } 
  }
  
  public boolean getUpgradeOnRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPGRADEONREFRESH$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UPGRADEONREFRESH$50); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetUpgradeOnRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UPGRADEONREFRESH$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(UPGRADEONREFRESH$50); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetUpgradeOnRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UPGRADEONREFRESH$50) != null);
    } 
  }
  
  public void setUpgradeOnRefresh(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPGRADEONREFRESH$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UPGRADEONREFRESH$50); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetUpgradeOnRefresh(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(UPGRADEONREFRESH$50);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(UPGRADEONREFRESH$50); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetUpgradeOnRefresh() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UPGRADEONREFRESH$50);
    } 
  }
  
  public boolean getTupleCache2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TUPLECACHE2$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(TUPLECACHE2$52); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetTupleCache2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TUPLECACHE2$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(TUPLECACHE2$52); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetTupleCache2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TUPLECACHE2$52) != null);
    } 
  }
  
  public void setTupleCache2(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TUPLECACHE2$52);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TUPLECACHE2$52); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetTupleCache2(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(TUPLECACHE2$52);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(TUPLECACHE2$52); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetTupleCache2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TUPLECACHE2$52);
    } 
  }
  
  public boolean getSupportSubquery() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUPPORTSUBQUERY$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUPPORTSUBQUERY$54); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSupportSubquery() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUPPORTSUBQUERY$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUPPORTSUBQUERY$54); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSupportSubquery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUPPORTSUBQUERY$54) != null);
    } 
  }
  
  public void setSupportSubquery(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUPPORTSUBQUERY$54);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUPPORTSUBQUERY$54); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSupportSubquery(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUPPORTSUBQUERY$54);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUPPORTSUBQUERY$54); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSupportSubquery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUPPORTSUBQUERY$54);
    } 
  }
  
  public boolean getSupportAdvancedDrill() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SUPPORTADVANCEDDRILL$56); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSupportAdvancedDrill() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SUPPORTADVANCEDDRILL$56); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSupportAdvancedDrill() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56) != null);
    } 
  }
  
  public void setSupportAdvancedDrill(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SUPPORTADVANCEDDRILL$56); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSupportAdvancedDrill(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SUPPORTADVANCEDDRILL$56);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SUPPORTADVANCEDDRILL$56); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSupportAdvancedDrill() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SUPPORTADVANCEDDRILL$56);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotCacheDefinitionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */