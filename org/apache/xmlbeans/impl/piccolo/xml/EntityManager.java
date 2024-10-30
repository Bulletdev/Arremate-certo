/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.CharArrayReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.impl.piccolo.util.RecursionException;
/*     */ import org.xml.sax.EntityResolver;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityManager
/*     */ {
/*     */   public static final int GENERAL = 0;
/*     */   public static final int PARAMETER = 1;
/*     */   private EntityResolver resolver;
/*     */   
/*     */   private final class Entry
/*     */     implements Entity
/*     */   {
/*     */     boolean isOpen = false;
/*     */     char[] value;
/*     */     String pubID;
/*     */     String sysID;
/*     */     String ndata;
/*  38 */     XMLInputReader reader = null;
/*     */     boolean isStandalone = false;
/*     */     
/*     */     Entry(String param1String) {
/*  42 */       this.pubID = this.sysID = this.ndata = null;
/*  43 */       this.value = param1String.toCharArray();
/*     */     }
/*     */     private final EntityManager this$0;
/*     */     Entry(String param1String1, String param1String2) {
/*  47 */       this(param1String1, param1String2, null);
/*     */     }
/*     */     
/*     */     Entry(String param1String1, String param1String2, String param1String3) {
/*  51 */       this.pubID = param1String1;
/*  52 */       this.sysID = param1String2;
/*  53 */       this.ndata = param1String3;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void open() throws RecursionException, SAXException, IOException {
/*  59 */       if (this.ndata != null) {
/*  60 */         throw new FatalParsingException("Cannot reference entity; unknown NDATA type '" + this.ndata + "'");
/*     */       }
/*     */       
/*  63 */       if (this.isOpen) {
/*  64 */         throw new RecursionException();
/*     */       }
/*  66 */       if (!isInternal()) {
/*  67 */         if (EntityManager.this.resolver == null) {
/*  68 */           this.reader = new XMLStreamReader((new URL(this.sysID)).openStream(), true);
/*     */         } else {
/*  70 */           InputSource inputSource = EntityManager.this.resolver.resolveEntity(this.pubID, this.sysID);
/*  71 */           if (inputSource == null) {
/*  72 */             this.reader = new XMLStreamReader((new URL(this.sysID)).openStream(), true);
/*     */           } else {
/*     */             
/*  75 */             Reader reader = inputSource.getCharacterStream();
/*  76 */             if (reader != null) {
/*  77 */               this.reader = new XMLReaderReader(reader, true);
/*     */             }
/*     */             else {
/*     */               
/*  81 */               InputStream inputStream = inputSource.getByteStream();
/*  82 */               if (inputStream != null) {
/*  83 */                 this.reader = new XMLStreamReader(inputStream, inputSource.getEncoding(), true);
/*     */               } else {
/*  85 */                 this.reader = new XMLStreamReader((new URL(inputSource.getSystemId())).openStream(), inputSource.getEncoding(), true);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*  90 */         this.isStandalone = this.reader.isXMLStandalone();
/*     */       } 
/*  92 */       this.isOpen = true;
/*     */     }
/*     */     
/*     */     public boolean isOpen() {
/*  96 */       return this.isOpen;
/*     */     }
/*     */     
/*     */     public void close() {
/* 100 */       this.isOpen = false;
/* 101 */       this.reader = null;
/*     */     }
/*     */     
/*     */     public String getSystemID() {
/* 105 */       return this.sysID;
/*     */     }
/*     */     
/*     */     public String getPublicID() {
/* 109 */       return this.pubID;
/*     */     }
/*     */     
/*     */     public boolean isStandalone() {
/* 113 */       return this.isStandalone;
/*     */     }
/*     */     
/*     */     public void setStandalone(boolean param1Boolean) {
/* 117 */       this.isStandalone = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean isInternal() {
/* 121 */       return (this.sysID == null);
/*     */     }
/*     */     
/*     */     public boolean isParsed() {
/* 125 */       return (this.ndata == null);
/*     */     }
/*     */     
/*     */     public String getDeclaredEncoding() {
/* 129 */       if (this.reader != null) {
/* 130 */         return this.reader.getXMLDeclaredEncoding();
/*     */       }
/* 132 */       return null;
/*     */     }
/*     */     
/*     */     public boolean isStandaloneDeclared() {
/* 136 */       if (this.reader != null) {
/* 137 */         return this.reader.isXMLStandaloneDeclared();
/*     */       }
/* 139 */       return false;
/*     */     }
/*     */     
/*     */     public String getXMLVersion() {
/* 143 */       if (this.reader != null) {
/* 144 */         return this.reader.getXMLVersion();
/*     */       }
/* 146 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Reader getReader() {
/* 151 */       if (isInternal()) {
/* 152 */         return new CharArrayReader(this.value);
/*     */       }
/* 154 */       return this.reader;
/*     */     }
/*     */     
/*     */     public String stringValue() {
/* 158 */       return new String(this.value);
/*     */     }
/*     */     
/*     */     public char[] charArrayValue() {
/* 162 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 169 */   private Map[] entityMaps = new HashMap[] { new HashMap(), new HashMap() };
/* 170 */   private Map entitiesByURI = new HashMap();
/*     */   
/*     */   public EntityManager() {
/* 173 */     this(null);
/*     */   }
/*     */   
/*     */   public EntityManager(EntityResolver paramEntityResolver) {
/* 177 */     setResolver(paramEntityResolver);
/*     */   }
/*     */   
/*     */   public void setResolver(EntityResolver paramEntityResolver) {
/* 181 */     this.resolver = paramEntityResolver;
/*     */   }
/*     */   
/*     */   public EntityResolver getResolver() {
/* 185 */     return this.resolver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean putInternal(String paramString1, String paramString2, int paramInt) {
/* 193 */     if (this.entityMaps[paramInt].get(paramString1) == null) {
/* 194 */       this.entityMaps[paramInt].put(paramString1, new Entry(paramString2));
/* 195 */       return true;
/*     */     } 
/*     */     
/* 198 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean putExternal(Entity paramEntity, String paramString1, String paramString2, String paramString3, int paramInt) throws MalformedURLException {
/* 209 */     if (this.entityMaps[paramInt].get(paramString1) == null) {
/*     */       
/* 211 */       paramString3 = resolveSystemID(paramEntity.getSystemID(), paramString3);
/*     */ 
/*     */ 
/*     */       
/* 215 */       Entry entry = new Entry(paramString2, paramString3);
/* 216 */       this.entityMaps[paramInt].put(paramString1, entry);
/* 217 */       if (paramString2 != null && paramString2.length() > 0)
/* 218 */         this.entitiesByURI.put(paramString2, entry); 
/* 219 */       this.entitiesByURI.put(paramString3, entry);
/* 220 */       return true;
/*     */     } 
/*     */     
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean putUnparsed(Entity paramEntity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) throws MalformedURLException {
/* 235 */     if (this.entityMaps[paramInt].get(paramString1) == null) {
/*     */ 
/*     */ 
/*     */       
/* 239 */       this.entityMaps[paramInt].put(paramString1, new Entry(paramString2, paramString3, paramString4));
/* 240 */       return true;
/*     */     } 
/*     */     
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 247 */     this.entityMaps[0].clear();
/* 248 */     this.entityMaps[1].clear();
/* 249 */     this.entitiesByURI.clear();
/*     */   }
/*     */   
/*     */   public Entity getByName(String paramString, int paramInt) {
/* 253 */     return this.entityMaps[paramInt].get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Entity getByID(Entity paramEntity, String paramString1, String paramString2) throws MalformedURLException {
/* 259 */     Entity entity = null;
/*     */     
/* 261 */     paramString2 = resolveSystemID(paramEntity.getSystemID(), paramString2);
/*     */     
/* 263 */     entity = (Entity)this.entitiesByURI.get(paramString2);
/* 264 */     if (entity != null) {
/* 265 */       return entity;
/*     */     }
/* 267 */     if (paramString1 != null && paramString1.length() > 0) {
/* 268 */       entity = (Entity)this.entitiesByURI.get(paramString1);
/* 269 */       if (entity != null) {
/* 270 */         return entity;
/*     */       }
/*     */     } 
/*     */     
/* 274 */     entity = new Entry(paramString1, paramString2);
/* 275 */     if (paramString1 != null && paramString1.length() > 0)
/* 276 */       this.entitiesByURI.put(paramString1, entity); 
/* 277 */     this.entitiesByURI.put(paramString2, entity);
/*     */     
/* 279 */     return entity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String resolveSystemID(String paramString1, String paramString2) throws MalformedURLException {
/*     */     URL uRL;
/* 286 */     if (paramString1 != null) {
/* 287 */       uRL = new URL(new URL(paramString1), paramString2);
/*     */     } else {
/* 289 */       uRL = new URL(paramString2);
/*     */     } 
/* 291 */     return uRL.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\EntityManager.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */