/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.NamespacePrefixList;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
/*     */ 
/*     */ public class NsconfigImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements Nsconfig
/*     */ {
/*     */   public NsconfigImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b PACKAGE$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "package");
/*     */   
/*  24 */   private static final b PREFIX$2 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prefix");
/*     */   
/*  26 */   private static final b SUFFIX$4 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "suffix");
/*     */   
/*  28 */   private static final b URI$6 = new b("", "uri");
/*     */   
/*  30 */   private static final b URIPREFIX$8 = new b("", "uriprefix");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPackage() {
/*  39 */     synchronized (monitor()) {
/*     */       
/*  41 */       check_orphaned();
/*  42 */       SimpleValue simpleValue = null;
/*  43 */       simpleValue = (SimpleValue)get_store().find_element_user(PACKAGE$0, 0);
/*  44 */       if (simpleValue == null)
/*     */       {
/*  46 */         return null;
/*     */       }
/*  48 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetPackage() {
/*  57 */     synchronized (monitor()) {
/*     */       
/*  59 */       check_orphaned();
/*  60 */       XmlString xmlString = null;
/*  61 */       xmlString = (XmlString)get_store().find_element_user(PACKAGE$0, 0);
/*  62 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetPackage() {
/*  71 */     synchronized (monitor()) {
/*     */       
/*  73 */       check_orphaned();
/*  74 */       return (get_store().count_elements(PACKAGE$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPackage(String paramString) {
/*  83 */     synchronized (monitor()) {
/*     */       
/*  85 */       check_orphaned();
/*  86 */       SimpleValue simpleValue = null;
/*  87 */       simpleValue = (SimpleValue)get_store().find_element_user(PACKAGE$0, 0);
/*  88 */       if (simpleValue == null)
/*     */       {
/*  90 */         simpleValue = (SimpleValue)get_store().add_element_user(PACKAGE$0);
/*     */       }
/*  92 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetPackage(XmlString paramXmlString) {
/* 101 */     synchronized (monitor()) {
/*     */       
/* 103 */       check_orphaned();
/* 104 */       XmlString xmlString = null;
/* 105 */       xmlString = (XmlString)get_store().find_element_user(PACKAGE$0, 0);
/* 106 */       if (xmlString == null)
/*     */       {
/* 108 */         xmlString = (XmlString)get_store().add_element_user(PACKAGE$0);
/*     */       }
/* 110 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetPackage() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       get_store().remove_element(PACKAGE$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrefix() {
/* 131 */     synchronized (monitor()) {
/*     */       
/* 133 */       check_orphaned();
/* 134 */       SimpleValue simpleValue = null;
/* 135 */       simpleValue = (SimpleValue)get_store().find_element_user(PREFIX$2, 0);
/* 136 */       if (simpleValue == null)
/*     */       {
/* 138 */         return null;
/*     */       }
/* 140 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetPrefix() {
/* 149 */     synchronized (monitor()) {
/*     */       
/* 151 */       check_orphaned();
/* 152 */       XmlString xmlString = null;
/* 153 */       xmlString = (XmlString)get_store().find_element_user(PREFIX$2, 0);
/* 154 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetPrefix() {
/* 163 */     synchronized (monitor()) {
/*     */       
/* 165 */       check_orphaned();
/* 166 */       return (get_store().count_elements(PREFIX$2) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrefix(String paramString) {
/* 175 */     synchronized (monitor()) {
/*     */       
/* 177 */       check_orphaned();
/* 178 */       SimpleValue simpleValue = null;
/* 179 */       simpleValue = (SimpleValue)get_store().find_element_user(PREFIX$2, 0);
/* 180 */       if (simpleValue == null)
/*     */       {
/* 182 */         simpleValue = (SimpleValue)get_store().add_element_user(PREFIX$2);
/*     */       }
/* 184 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetPrefix(XmlString paramXmlString) {
/* 193 */     synchronized (monitor()) {
/*     */       
/* 195 */       check_orphaned();
/* 196 */       XmlString xmlString = null;
/* 197 */       xmlString = (XmlString)get_store().find_element_user(PREFIX$2, 0);
/* 198 */       if (xmlString == null)
/*     */       {
/* 200 */         xmlString = (XmlString)get_store().add_element_user(PREFIX$2);
/*     */       }
/* 202 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetPrefix() {
/* 211 */     synchronized (monitor()) {
/*     */       
/* 213 */       check_orphaned();
/* 214 */       get_store().remove_element(PREFIX$2, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSuffix() {
/* 223 */     synchronized (monitor()) {
/*     */       
/* 225 */       check_orphaned();
/* 226 */       SimpleValue simpleValue = null;
/* 227 */       simpleValue = (SimpleValue)get_store().find_element_user(SUFFIX$4, 0);
/* 228 */       if (simpleValue == null)
/*     */       {
/* 230 */         return null;
/*     */       }
/* 232 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetSuffix() {
/* 241 */     synchronized (monitor()) {
/*     */       
/* 243 */       check_orphaned();
/* 244 */       XmlString xmlString = null;
/* 245 */       xmlString = (XmlString)get_store().find_element_user(SUFFIX$4, 0);
/* 246 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetSuffix() {
/* 255 */     synchronized (monitor()) {
/*     */       
/* 257 */       check_orphaned();
/* 258 */       return (get_store().count_elements(SUFFIX$4) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuffix(String paramString) {
/* 267 */     synchronized (monitor()) {
/*     */       
/* 269 */       check_orphaned();
/* 270 */       SimpleValue simpleValue = null;
/* 271 */       simpleValue = (SimpleValue)get_store().find_element_user(SUFFIX$4, 0);
/* 272 */       if (simpleValue == null)
/*     */       {
/* 274 */         simpleValue = (SimpleValue)get_store().add_element_user(SUFFIX$4);
/*     */       }
/* 276 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetSuffix(XmlString paramXmlString) {
/* 285 */     synchronized (monitor()) {
/*     */       
/* 287 */       check_orphaned();
/* 288 */       XmlString xmlString = null;
/* 289 */       xmlString = (XmlString)get_store().find_element_user(SUFFIX$4, 0);
/* 290 */       if (xmlString == null)
/*     */       {
/* 292 */         xmlString = (XmlString)get_store().add_element_user(SUFFIX$4);
/*     */       }
/* 294 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetSuffix() {
/* 303 */     synchronized (monitor()) {
/*     */       
/* 305 */       check_orphaned();
/* 306 */       get_store().remove_element(SUFFIX$4, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getUri() {
/* 315 */     synchronized (monitor()) {
/*     */       
/* 317 */       check_orphaned();
/* 318 */       SimpleValue simpleValue = null;
/* 319 */       simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
/* 320 */       if (simpleValue == null)
/*     */       {
/* 322 */         return null;
/*     */       }
/* 324 */       return simpleValue.getObjectValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NamespaceList xgetUri() {
/* 333 */     synchronized (monitor()) {
/*     */       
/* 335 */       check_orphaned();
/* 336 */       NamespaceList namespaceList = null;
/* 337 */       namespaceList = (NamespaceList)get_store().find_attribute_user(URI$6);
/* 338 */       return namespaceList;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetUri() {
/* 347 */     synchronized (monitor()) {
/*     */       
/* 349 */       check_orphaned();
/* 350 */       return (get_store().find_attribute_user(URI$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUri(Object paramObject) {
/* 359 */     synchronized (monitor()) {
/*     */       
/* 361 */       check_orphaned();
/* 362 */       SimpleValue simpleValue = null;
/* 363 */       simpleValue = (SimpleValue)get_store().find_attribute_user(URI$6);
/* 364 */       if (simpleValue == null)
/*     */       {
/* 366 */         simpleValue = (SimpleValue)get_store().add_attribute_user(URI$6);
/*     */       }
/* 368 */       simpleValue.setObjectValue(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetUri(NamespaceList paramNamespaceList) {
/* 377 */     synchronized (monitor()) {
/*     */       
/* 379 */       check_orphaned();
/* 380 */       NamespaceList namespaceList = null;
/* 381 */       namespaceList = (NamespaceList)get_store().find_attribute_user(URI$6);
/* 382 */       if (namespaceList == null)
/*     */       {
/* 384 */         namespaceList = (NamespaceList)get_store().add_attribute_user(URI$6);
/*     */       }
/* 386 */       namespaceList.set((XmlObject)paramNamespaceList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetUri() {
/* 395 */     synchronized (monitor()) {
/*     */       
/* 397 */       check_orphaned();
/* 398 */       get_store().remove_attribute(URI$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getUriprefix() {
/* 407 */     synchronized (monitor()) {
/*     */       
/* 409 */       check_orphaned();
/* 410 */       SimpleValue simpleValue = null;
/* 411 */       simpleValue = (SimpleValue)get_store().find_attribute_user(URIPREFIX$8);
/* 412 */       if (simpleValue == null)
/*     */       {
/* 414 */         return null;
/*     */       }
/* 416 */       return simpleValue.getListValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NamespacePrefixList xgetUriprefix() {
/* 425 */     synchronized (monitor()) {
/*     */       
/* 427 */       check_orphaned();
/* 428 */       NamespacePrefixList namespacePrefixList = null;
/* 429 */       namespacePrefixList = (NamespacePrefixList)get_store().find_attribute_user(URIPREFIX$8);
/* 430 */       return namespacePrefixList;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetUriprefix() {
/* 439 */     synchronized (monitor()) {
/*     */       
/* 441 */       check_orphaned();
/* 442 */       return (get_store().find_attribute_user(URIPREFIX$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUriprefix(List paramList) {
/* 451 */     synchronized (monitor()) {
/*     */       
/* 453 */       check_orphaned();
/* 454 */       SimpleValue simpleValue = null;
/* 455 */       simpleValue = (SimpleValue)get_store().find_attribute_user(URIPREFIX$8);
/* 456 */       if (simpleValue == null)
/*     */       {
/* 458 */         simpleValue = (SimpleValue)get_store().add_attribute_user(URIPREFIX$8);
/*     */       }
/* 460 */       simpleValue.setListValue(paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetUriprefix(NamespacePrefixList paramNamespacePrefixList) {
/* 469 */     synchronized (monitor()) {
/*     */       
/* 471 */       check_orphaned();
/* 472 */       NamespacePrefixList namespacePrefixList = null;
/* 473 */       namespacePrefixList = (NamespacePrefixList)get_store().find_attribute_user(URIPREFIX$8);
/* 474 */       if (namespacePrefixList == null)
/*     */       {
/* 476 */         namespacePrefixList = (NamespacePrefixList)get_store().add_attribute_user(URIPREFIX$8);
/*     */       }
/* 478 */       namespacePrefixList.set((XmlObject)paramNamespacePrefixList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetUriprefix() {
/* 487 */     synchronized (monitor()) {
/*     */       
/* 489 */       check_orphaned();
/* 490 */       get_store().remove_attribute(URIPREFIX$8);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\NsconfigImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */