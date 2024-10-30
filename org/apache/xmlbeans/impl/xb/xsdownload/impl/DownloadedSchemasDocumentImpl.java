/*     */ package org.apache.xmlbeans.impl.xb.xsdownload.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
/*     */ import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemasDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DownloadedSchemasDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements DownloadedSchemasDocument
/*     */ {
/*     */   public DownloadedSchemasDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b DOWNLOADEDSCHEMAS$0 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "downloaded-schemas");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DownloadedSchemasDocument.DownloadedSchemas getDownloadedSchemas() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = null;
/*  36 */       downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas)get_store().find_element_user(DOWNLOADEDSCHEMAS$0, 0);
/*  37 */       if (downloadedSchemas == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return downloadedSchemas;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDownloadedSchemas(DownloadedSchemasDocument.DownloadedSchemas paramDownloadedSchemas) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = null;
/*  54 */       downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas)get_store().find_element_user(DOWNLOADEDSCHEMAS$0, 0);
/*  55 */       if (downloadedSchemas == null)
/*     */       {
/*  57 */         downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas)get_store().add_element_user(DOWNLOADEDSCHEMAS$0);
/*     */       }
/*  59 */       downloadedSchemas.set((XmlObject)paramDownloadedSchemas);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DownloadedSchemasDocument.DownloadedSchemas addNewDownloadedSchemas() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       DownloadedSchemasDocument.DownloadedSchemas downloadedSchemas = null;
/*  72 */       downloadedSchemas = (DownloadedSchemasDocument.DownloadedSchemas)get_store().add_element_user(DOWNLOADEDSCHEMAS$0);
/*  73 */       return downloadedSchemas;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DownloadedSchemasImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements DownloadedSchemasDocument.DownloadedSchemas
/*     */   {
/*     */     public DownloadedSchemasImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b ENTRY$0 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "entry");
/*     */     
/*  91 */     private static final b DEFAULTDIRECTORY$2 = new b("", "defaultDirectory");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DownloadedSchemaEntry[] getEntryArray() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         ArrayList arrayList = new ArrayList();
/* 104 */         get_store().find_all_element_users(ENTRY$0, arrayList);
/* 105 */         DownloadedSchemaEntry[] arrayOfDownloadedSchemaEntry = new DownloadedSchemaEntry[arrayList.size()];
/* 106 */         arrayList.toArray((Object[])arrayOfDownloadedSchemaEntry);
/* 107 */         return arrayOfDownloadedSchemaEntry;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DownloadedSchemaEntry getEntryArray(int param1Int) {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         DownloadedSchemaEntry downloadedSchemaEntry = null;
/* 120 */         downloadedSchemaEntry = (DownloadedSchemaEntry)get_store().find_element_user(ENTRY$0, param1Int);
/* 121 */         if (downloadedSchemaEntry == null)
/*     */         {
/* 123 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 125 */         return downloadedSchemaEntry;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfEntryArray() {
/* 134 */       synchronized (monitor()) {
/*     */         
/* 136 */         check_orphaned();
/* 137 */         return get_store().count_elements(ENTRY$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEntryArray(DownloadedSchemaEntry[] param1ArrayOfDownloadedSchemaEntry) {
/* 146 */       synchronized (monitor()) {
/*     */         
/* 148 */         check_orphaned();
/* 149 */         arraySetterHelper((XmlObject[])param1ArrayOfDownloadedSchemaEntry, ENTRY$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setEntryArray(int param1Int, DownloadedSchemaEntry param1DownloadedSchemaEntry) {
/* 158 */       synchronized (monitor()) {
/*     */         
/* 160 */         check_orphaned();
/* 161 */         DownloadedSchemaEntry downloadedSchemaEntry = null;
/* 162 */         downloadedSchemaEntry = (DownloadedSchemaEntry)get_store().find_element_user(ENTRY$0, param1Int);
/* 163 */         if (downloadedSchemaEntry == null)
/*     */         {
/* 165 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 167 */         downloadedSchemaEntry.set((XmlObject)param1DownloadedSchemaEntry);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DownloadedSchemaEntry insertNewEntry(int param1Int) {
/* 176 */       synchronized (monitor()) {
/*     */         
/* 178 */         check_orphaned();
/* 179 */         DownloadedSchemaEntry downloadedSchemaEntry = null;
/* 180 */         downloadedSchemaEntry = (DownloadedSchemaEntry)get_store().insert_element_user(ENTRY$0, param1Int);
/* 181 */         return downloadedSchemaEntry;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DownloadedSchemaEntry addNewEntry() {
/* 190 */       synchronized (monitor()) {
/*     */         
/* 192 */         check_orphaned();
/* 193 */         DownloadedSchemaEntry downloadedSchemaEntry = null;
/* 194 */         downloadedSchemaEntry = (DownloadedSchemaEntry)get_store().add_element_user(ENTRY$0);
/* 195 */         return downloadedSchemaEntry;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeEntry(int param1Int) {
/* 204 */       synchronized (monitor()) {
/*     */         
/* 206 */         check_orphaned();
/* 207 */         get_store().remove_element(ENTRY$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getDefaultDirectory() {
/* 216 */       synchronized (monitor()) {
/*     */         
/* 218 */         check_orphaned();
/* 219 */         SimpleValue simpleValue = null;
/* 220 */         simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTDIRECTORY$2);
/* 221 */         if (simpleValue == null)
/*     */         {
/* 223 */           return null;
/*     */         }
/* 225 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlToken xgetDefaultDirectory() {
/* 234 */       synchronized (monitor()) {
/*     */         
/* 236 */         check_orphaned();
/* 237 */         XmlToken xmlToken = null;
/* 238 */         xmlToken = (XmlToken)get_store().find_attribute_user(DEFAULTDIRECTORY$2);
/* 239 */         return xmlToken;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetDefaultDirectory() {
/* 248 */       synchronized (monitor()) {
/*     */         
/* 250 */         check_orphaned();
/* 251 */         return (get_store().find_attribute_user(DEFAULTDIRECTORY$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setDefaultDirectory(String param1String) {
/* 260 */       synchronized (monitor()) {
/*     */         
/* 262 */         check_orphaned();
/* 263 */         SimpleValue simpleValue = null;
/* 264 */         simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTDIRECTORY$2);
/* 265 */         if (simpleValue == null)
/*     */         {
/* 267 */           simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTDIRECTORY$2);
/*     */         }
/* 269 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetDefaultDirectory(XmlToken param1XmlToken) {
/* 278 */       synchronized (monitor()) {
/*     */         
/* 280 */         check_orphaned();
/* 281 */         XmlToken xmlToken = null;
/* 282 */         xmlToken = (XmlToken)get_store().find_attribute_user(DEFAULTDIRECTORY$2);
/* 283 */         if (xmlToken == null)
/*     */         {
/* 285 */           xmlToken = (XmlToken)get_store().add_attribute_user(DEFAULTDIRECTORY$2);
/*     */         }
/* 287 */         xmlToken.set((XmlObject)param1XmlToken);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetDefaultDirectory() {
/* 296 */       synchronized (monitor()) {
/*     */         
/* 298 */         check_orphaned();
/* 299 */         get_store().remove_attribute(DEFAULTDIRECTORY$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdownload\impl\DownloadedSchemasDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */