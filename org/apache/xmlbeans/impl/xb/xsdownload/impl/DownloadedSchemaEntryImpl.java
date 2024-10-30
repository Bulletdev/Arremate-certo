/*     */ package org.apache.xmlbeans.impl.xb.xsdownload.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
/*     */ 
/*     */ 
/*     */ public class DownloadedSchemaEntryImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements DownloadedSchemaEntry
/*     */ {
/*     */   public DownloadedSchemaEntryImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b FILENAME$0 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "filename");
/*     */   
/*  24 */   private static final b SHA1$2 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "sha1");
/*     */   
/*  26 */   private static final b SCHEMALOCATION$4 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "schemaLocation");
/*     */   
/*  28 */   private static final b NAMESPACE$6 = new b("http://www.bea.com/2003/01/xmlbean/xsdownload", "namespace");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilename() {
/*  37 */     synchronized (monitor()) {
/*     */       
/*  39 */       check_orphaned();
/*  40 */       SimpleValue simpleValue = null;
/*  41 */       simpleValue = (SimpleValue)get_store().find_element_user(FILENAME$0, 0);
/*  42 */       if (simpleValue == null)
/*     */       {
/*  44 */         return null;
/*     */       }
/*  46 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetFilename() {
/*  55 */     synchronized (monitor()) {
/*     */       
/*  57 */       check_orphaned();
/*  58 */       XmlToken xmlToken = null;
/*  59 */       xmlToken = (XmlToken)get_store().find_element_user(FILENAME$0, 0);
/*  60 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilename(String paramString) {
/*  69 */     synchronized (monitor()) {
/*     */       
/*  71 */       check_orphaned();
/*  72 */       SimpleValue simpleValue = null;
/*  73 */       simpleValue = (SimpleValue)get_store().find_element_user(FILENAME$0, 0);
/*  74 */       if (simpleValue == null)
/*     */       {
/*  76 */         simpleValue = (SimpleValue)get_store().add_element_user(FILENAME$0);
/*     */       }
/*  78 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFilename(XmlToken paramXmlToken) {
/*  87 */     synchronized (monitor()) {
/*     */       
/*  89 */       check_orphaned();
/*  90 */       XmlToken xmlToken = null;
/*  91 */       xmlToken = (XmlToken)get_store().find_element_user(FILENAME$0, 0);
/*  92 */       if (xmlToken == null)
/*     */       {
/*  94 */         xmlToken = (XmlToken)get_store().add_element_user(FILENAME$0);
/*     */       }
/*  96 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSha1() {
/* 105 */     synchronized (monitor()) {
/*     */       
/* 107 */       check_orphaned();
/* 108 */       SimpleValue simpleValue = null;
/* 109 */       simpleValue = (SimpleValue)get_store().find_element_user(SHA1$2, 0);
/* 110 */       if (simpleValue == null)
/*     */       {
/* 112 */         return null;
/*     */       }
/* 114 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetSha1() {
/* 123 */     synchronized (monitor()) {
/*     */       
/* 125 */       check_orphaned();
/* 126 */       XmlToken xmlToken = null;
/* 127 */       xmlToken = (XmlToken)get_store().find_element_user(SHA1$2, 0);
/* 128 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSha1(String paramString) {
/* 137 */     synchronized (monitor()) {
/*     */       
/* 139 */       check_orphaned();
/* 140 */       SimpleValue simpleValue = null;
/* 141 */       simpleValue = (SimpleValue)get_store().find_element_user(SHA1$2, 0);
/* 142 */       if (simpleValue == null)
/*     */       {
/* 144 */         simpleValue = (SimpleValue)get_store().add_element_user(SHA1$2);
/*     */       }
/* 146 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetSha1(XmlToken paramXmlToken) {
/* 155 */     synchronized (monitor()) {
/*     */       
/* 157 */       check_orphaned();
/* 158 */       XmlToken xmlToken = null;
/* 159 */       xmlToken = (XmlToken)get_store().find_element_user(SHA1$2, 0);
/* 160 */       if (xmlToken == null)
/*     */       {
/* 162 */         xmlToken = (XmlToken)get_store().add_element_user(SHA1$2);
/*     */       }
/* 164 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getSchemaLocationArray() {
/* 173 */     synchronized (monitor()) {
/*     */       
/* 175 */       check_orphaned();
/* 176 */       ArrayList arrayList = new ArrayList();
/* 177 */       get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
/* 178 */       String[] arrayOfString = new String[arrayList.size()]; byte b1; int i;
/* 179 */       for (b1 = 0, i = arrayList.size(); b1 < i; b1++)
/* 180 */         arrayOfString[b1] = ((SimpleValue)arrayList.get(b1)).getStringValue(); 
/* 181 */       return arrayOfString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemaLocationArray(int paramInt) {
/* 190 */     synchronized (monitor()) {
/*     */       
/* 192 */       check_orphaned();
/* 193 */       SimpleValue simpleValue = null;
/* 194 */       simpleValue = (SimpleValue)get_store().find_element_user(SCHEMALOCATION$4, paramInt);
/* 195 */       if (simpleValue == null)
/*     */       {
/* 197 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 199 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI[] xgetSchemaLocationArray() {
/* 208 */     synchronized (monitor()) {
/*     */       
/* 210 */       check_orphaned();
/* 211 */       ArrayList arrayList = new ArrayList();
/* 212 */       get_store().find_all_element_users(SCHEMALOCATION$4, arrayList);
/* 213 */       XmlAnyURI[] arrayOfXmlAnyURI = new XmlAnyURI[arrayList.size()];
/* 214 */       arrayList.toArray((Object[])arrayOfXmlAnyURI);
/* 215 */       return arrayOfXmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI xgetSchemaLocationArray(int paramInt) {
/* 224 */     synchronized (monitor()) {
/*     */       
/* 226 */       check_orphaned();
/* 227 */       XmlAnyURI xmlAnyURI = null;
/* 228 */       xmlAnyURI = (XmlAnyURI)get_store().find_element_user(SCHEMALOCATION$4, paramInt);
/* 229 */       if (xmlAnyURI == null)
/*     */       {
/* 231 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 233 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfSchemaLocationArray() {
/* 242 */     synchronized (monitor()) {
/*     */       
/* 244 */       check_orphaned();
/* 245 */       return get_store().count_elements(SCHEMALOCATION$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchemaLocationArray(String[] paramArrayOfString) {
/* 254 */     synchronized (monitor()) {
/*     */       
/* 256 */       check_orphaned();
/* 257 */       arraySetterHelper(paramArrayOfString, SCHEMALOCATION$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchemaLocationArray(int paramInt, String paramString) {
/* 266 */     synchronized (monitor()) {
/*     */       
/* 268 */       check_orphaned();
/* 269 */       SimpleValue simpleValue = null;
/* 270 */       simpleValue = (SimpleValue)get_store().find_element_user(SCHEMALOCATION$4, paramInt);
/* 271 */       if (simpleValue == null)
/*     */       {
/* 273 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 275 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetSchemaLocationArray(XmlAnyURI[] paramArrayOfXmlAnyURI) {
/* 284 */     synchronized (monitor()) {
/*     */       
/* 286 */       check_orphaned();
/* 287 */       arraySetterHelper((XmlObject[])paramArrayOfXmlAnyURI, SCHEMALOCATION$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetSchemaLocationArray(int paramInt, XmlAnyURI paramXmlAnyURI) {
/* 296 */     synchronized (monitor()) {
/*     */       
/* 298 */       check_orphaned();
/* 299 */       XmlAnyURI xmlAnyURI = null;
/* 300 */       xmlAnyURI = (XmlAnyURI)get_store().find_element_user(SCHEMALOCATION$4, paramInt);
/* 301 */       if (xmlAnyURI == null)
/*     */       {
/* 303 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 305 */       xmlAnyURI.set((XmlObject)paramXmlAnyURI);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertSchemaLocation(int paramInt, String paramString) {
/* 314 */     synchronized (monitor()) {
/*     */       
/* 316 */       check_orphaned();
/* 317 */       SimpleValue simpleValue = (SimpleValue)get_store().insert_element_user(SCHEMALOCATION$4, paramInt);
/*     */       
/* 319 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSchemaLocation(String paramString) {
/* 328 */     synchronized (monitor()) {
/*     */       
/* 330 */       check_orphaned();
/* 331 */       SimpleValue simpleValue = null;
/* 332 */       simpleValue = (SimpleValue)get_store().add_element_user(SCHEMALOCATION$4);
/* 333 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI insertNewSchemaLocation(int paramInt) {
/* 342 */     synchronized (monitor()) {
/*     */       
/* 344 */       check_orphaned();
/* 345 */       XmlAnyURI xmlAnyURI = null;
/* 346 */       xmlAnyURI = (XmlAnyURI)get_store().insert_element_user(SCHEMALOCATION$4, paramInt);
/* 347 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI addNewSchemaLocation() {
/* 356 */     synchronized (monitor()) {
/*     */       
/* 358 */       check_orphaned();
/* 359 */       XmlAnyURI xmlAnyURI = null;
/* 360 */       xmlAnyURI = (XmlAnyURI)get_store().add_element_user(SCHEMALOCATION$4);
/* 361 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSchemaLocation(int paramInt) {
/* 370 */     synchronized (monitor()) {
/*     */       
/* 372 */       check_orphaned();
/* 373 */       get_store().remove_element(SCHEMALOCATION$4, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNamespace() {
/* 382 */     synchronized (monitor()) {
/*     */       
/* 384 */       check_orphaned();
/* 385 */       SimpleValue simpleValue = null;
/* 386 */       simpleValue = (SimpleValue)get_store().find_element_user(NAMESPACE$6, 0);
/* 387 */       if (simpleValue == null)
/*     */       {
/* 389 */         return null;
/*     */       }
/* 391 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI xgetNamespace() {
/* 400 */     synchronized (monitor()) {
/*     */       
/* 402 */       check_orphaned();
/* 403 */       XmlAnyURI xmlAnyURI = null;
/* 404 */       xmlAnyURI = (XmlAnyURI)get_store().find_element_user(NAMESPACE$6, 0);
/* 405 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetNamespace() {
/* 414 */     synchronized (monitor()) {
/*     */       
/* 416 */       check_orphaned();
/* 417 */       return (get_store().count_elements(NAMESPACE$6) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamespace(String paramString) {
/* 426 */     synchronized (monitor()) {
/*     */       
/* 428 */       check_orphaned();
/* 429 */       SimpleValue simpleValue = null;
/* 430 */       simpleValue = (SimpleValue)get_store().find_element_user(NAMESPACE$6, 0);
/* 431 */       if (simpleValue == null)
/*     */       {
/* 433 */         simpleValue = (SimpleValue)get_store().add_element_user(NAMESPACE$6);
/*     */       }
/* 435 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetNamespace(XmlAnyURI paramXmlAnyURI) {
/* 444 */     synchronized (monitor()) {
/*     */       
/* 446 */       check_orphaned();
/* 447 */       XmlAnyURI xmlAnyURI = null;
/* 448 */       xmlAnyURI = (XmlAnyURI)get_store().find_element_user(NAMESPACE$6, 0);
/* 449 */       if (xmlAnyURI == null)
/*     */       {
/* 451 */         xmlAnyURI = (XmlAnyURI)get_store().add_element_user(NAMESPACE$6);
/*     */       }
/* 453 */       xmlAnyURI.set((XmlObject)paramXmlAnyURI);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetNamespace() {
/* 462 */     synchronized (monitor()) {
/*     */       
/* 464 */       check_orphaned();
/* 465 */       get_store().remove_element(NAMESPACE$6, 0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdownload\impl\DownloadedSchemaEntryImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */