package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;

public class CTPivotCachesImpl extends XmlComplexContentImpl implements CTPivotCaches {
  private static final b PIVOTCACHE$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCache");
  
  public CTPivotCachesImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTPivotCache> getPivotCacheList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTPivotCache>)new PivotCacheList(this);
    } 
  }
  
  public CTPivotCache[] getPivotCacheArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(PIVOTCACHE$0, arrayList);
      CTPivotCache[] arrayOfCTPivotCache = new CTPivotCache[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTPivotCache);
      return arrayOfCTPivotCache;
    } 
  }
  
  public CTPivotCache getPivotCacheArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCache cTPivotCache = null;
      cTPivotCache = (CTPivotCache)get_store().find_element_user(PIVOTCACHE$0, paramInt);
      if (cTPivotCache == null)
        throw new IndexOutOfBoundsException(); 
      return cTPivotCache;
    } 
  }
  
  public int sizeOfPivotCacheArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(PIVOTCACHE$0);
    } 
  }
  
  public void setPivotCacheArray(CTPivotCache[] paramArrayOfCTPivotCache) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTPivotCache, PIVOTCACHE$0);
    } 
  }
  
  public void setPivotCacheArray(int paramInt, CTPivotCache paramCTPivotCache) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCache cTPivotCache = null;
      cTPivotCache = (CTPivotCache)get_store().find_element_user(PIVOTCACHE$0, paramInt);
      if (cTPivotCache == null)
        throw new IndexOutOfBoundsException(); 
      cTPivotCache.set((XmlObject)paramCTPivotCache);
    } 
  }
  
  public CTPivotCache insertNewPivotCache(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCache cTPivotCache = null;
      cTPivotCache = (CTPivotCache)get_store().insert_element_user(PIVOTCACHE$0, paramInt);
      return cTPivotCache;
    } 
  }
  
  public CTPivotCache addNewPivotCache() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCache cTPivotCache = null;
      cTPivotCache = (CTPivotCache)get_store().add_element_user(PIVOTCACHE$0);
      return cTPivotCache;
    } 
  }
  
  public void removePivotCache(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTCACHE$0, paramInt);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTPivotCachesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */