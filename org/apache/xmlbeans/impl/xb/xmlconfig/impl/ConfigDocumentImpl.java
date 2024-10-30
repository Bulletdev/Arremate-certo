/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
/*     */ 
/*     */ 
/*     */ public class ConfigDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements ConfigDocument
/*     */ {
/*     */   public ConfigDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b CONFIG$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "config");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigDocument.Config getConfig() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       ConfigDocument.Config config = null;
/*  36 */       config = (ConfigDocument.Config)get_store().find_element_user(CONFIG$0, 0);
/*  37 */       if (config == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return config;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(ConfigDocument.Config paramConfig) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       ConfigDocument.Config config = null;
/*  54 */       config = (ConfigDocument.Config)get_store().find_element_user(CONFIG$0, 0);
/*  55 */       if (config == null)
/*     */       {
/*  57 */         config = (ConfigDocument.Config)get_store().add_element_user(CONFIG$0);
/*     */       }
/*  59 */       config.set((XmlObject)paramConfig);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigDocument.Config addNewConfig() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       ConfigDocument.Config config = null;
/*  72 */       config = (ConfigDocument.Config)get_store().add_element_user(CONFIG$0);
/*  73 */       return config;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ConfigImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements ConfigDocument.Config
/*     */   {
/*     */     public ConfigImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b NAMESPACE$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "namespace");
/*     */     
/*  91 */     private static final b QNAME$2 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "qname");
/*     */     
/*  93 */     private static final b EXTENSION$4 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "extension");
/*     */     
/*  95 */     private static final b USERTYPE$6 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "usertype");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Nsconfig[] getNamespaceArray() {
/* 104 */       synchronized (monitor()) {
/*     */         
/* 106 */         check_orphaned();
/* 107 */         ArrayList arrayList = new ArrayList();
/* 108 */         get_store().find_all_element_users(NAMESPACE$0, arrayList);
/* 109 */         Nsconfig[] arrayOfNsconfig = new Nsconfig[arrayList.size()];
/* 110 */         arrayList.toArray((Object[])arrayOfNsconfig);
/* 111 */         return arrayOfNsconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Nsconfig getNamespaceArray(int param1Int) {
/* 120 */       synchronized (monitor()) {
/*     */         
/* 122 */         check_orphaned();
/* 123 */         Nsconfig nsconfig = null;
/* 124 */         nsconfig = (Nsconfig)get_store().find_element_user(NAMESPACE$0, param1Int);
/* 125 */         if (nsconfig == null)
/*     */         {
/* 127 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 129 */         return nsconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfNamespaceArray() {
/* 138 */       synchronized (monitor()) {
/*     */         
/* 140 */         check_orphaned();
/* 141 */         return get_store().count_elements(NAMESPACE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNamespaceArray(Nsconfig[] param1ArrayOfNsconfig) {
/* 150 */       synchronized (monitor()) {
/*     */         
/* 152 */         check_orphaned();
/* 153 */         arraySetterHelper((XmlObject[])param1ArrayOfNsconfig, NAMESPACE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNamespaceArray(int param1Int, Nsconfig param1Nsconfig) {
/* 162 */       synchronized (monitor()) {
/*     */         
/* 164 */         check_orphaned();
/* 165 */         Nsconfig nsconfig = null;
/* 166 */         nsconfig = (Nsconfig)get_store().find_element_user(NAMESPACE$0, param1Int);
/* 167 */         if (nsconfig == null)
/*     */         {
/* 169 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 171 */         nsconfig.set((XmlObject)param1Nsconfig);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Nsconfig insertNewNamespace(int param1Int) {
/* 180 */       synchronized (monitor()) {
/*     */         
/* 182 */         check_orphaned();
/* 183 */         Nsconfig nsconfig = null;
/* 184 */         nsconfig = (Nsconfig)get_store().insert_element_user(NAMESPACE$0, param1Int);
/* 185 */         return nsconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Nsconfig addNewNamespace() {
/* 194 */       synchronized (monitor()) {
/*     */         
/* 196 */         check_orphaned();
/* 197 */         Nsconfig nsconfig = null;
/* 198 */         nsconfig = (Nsconfig)get_store().add_element_user(NAMESPACE$0);
/* 199 */         return nsconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeNamespace(int param1Int) {
/* 208 */       synchronized (monitor()) {
/*     */         
/* 210 */         check_orphaned();
/* 211 */         get_store().remove_element(NAMESPACE$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Qnameconfig[] getQnameArray() {
/* 220 */       synchronized (monitor()) {
/*     */         
/* 222 */         check_orphaned();
/* 223 */         ArrayList arrayList = new ArrayList();
/* 224 */         get_store().find_all_element_users(QNAME$2, arrayList);
/* 225 */         Qnameconfig[] arrayOfQnameconfig = new Qnameconfig[arrayList.size()];
/* 226 */         arrayList.toArray((Object[])arrayOfQnameconfig);
/* 227 */         return arrayOfQnameconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Qnameconfig getQnameArray(int param1Int) {
/* 236 */       synchronized (monitor()) {
/*     */         
/* 238 */         check_orphaned();
/* 239 */         Qnameconfig qnameconfig = null;
/* 240 */         qnameconfig = (Qnameconfig)get_store().find_element_user(QNAME$2, param1Int);
/* 241 */         if (qnameconfig == null)
/*     */         {
/* 243 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 245 */         return qnameconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfQnameArray() {
/* 254 */       synchronized (monitor()) {
/*     */         
/* 256 */         check_orphaned();
/* 257 */         return get_store().count_elements(QNAME$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setQnameArray(Qnameconfig[] param1ArrayOfQnameconfig) {
/* 266 */       synchronized (monitor()) {
/*     */         
/* 268 */         check_orphaned();
/* 269 */         arraySetterHelper((XmlObject[])param1ArrayOfQnameconfig, QNAME$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setQnameArray(int param1Int, Qnameconfig param1Qnameconfig) {
/* 278 */       synchronized (monitor()) {
/*     */         
/* 280 */         check_orphaned();
/* 281 */         Qnameconfig qnameconfig = null;
/* 282 */         qnameconfig = (Qnameconfig)get_store().find_element_user(QNAME$2, param1Int);
/* 283 */         if (qnameconfig == null)
/*     */         {
/* 285 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 287 */         qnameconfig.set((XmlObject)param1Qnameconfig);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Qnameconfig insertNewQname(int param1Int) {
/* 296 */       synchronized (monitor()) {
/*     */         
/* 298 */         check_orphaned();
/* 299 */         Qnameconfig qnameconfig = null;
/* 300 */         qnameconfig = (Qnameconfig)get_store().insert_element_user(QNAME$2, param1Int);
/* 301 */         return qnameconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Qnameconfig addNewQname() {
/* 310 */       synchronized (monitor()) {
/*     */         
/* 312 */         check_orphaned();
/* 313 */         Qnameconfig qnameconfig = null;
/* 314 */         qnameconfig = (Qnameconfig)get_store().add_element_user(QNAME$2);
/* 315 */         return qnameconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeQname(int param1Int) {
/* 324 */       synchronized (monitor()) {
/*     */         
/* 326 */         check_orphaned();
/* 327 */         get_store().remove_element(QNAME$2, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Extensionconfig[] getExtensionArray() {
/* 336 */       synchronized (monitor()) {
/*     */         
/* 338 */         check_orphaned();
/* 339 */         ArrayList arrayList = new ArrayList();
/* 340 */         get_store().find_all_element_users(EXTENSION$4, arrayList);
/* 341 */         Extensionconfig[] arrayOfExtensionconfig = new Extensionconfig[arrayList.size()];
/* 342 */         arrayList.toArray((Object[])arrayOfExtensionconfig);
/* 343 */         return arrayOfExtensionconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Extensionconfig getExtensionArray(int param1Int) {
/* 352 */       synchronized (monitor()) {
/*     */         
/* 354 */         check_orphaned();
/* 355 */         Extensionconfig extensionconfig = null;
/* 356 */         extensionconfig = (Extensionconfig)get_store().find_element_user(EXTENSION$4, param1Int);
/* 357 */         if (extensionconfig == null)
/*     */         {
/* 359 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 361 */         return extensionconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfExtensionArray() {
/* 370 */       synchronized (monitor()) {
/*     */         
/* 372 */         check_orphaned();
/* 373 */         return get_store().count_elements(EXTENSION$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExtensionArray(Extensionconfig[] param1ArrayOfExtensionconfig) {
/* 382 */       synchronized (monitor()) {
/*     */         
/* 384 */         check_orphaned();
/* 385 */         arraySetterHelper((XmlObject[])param1ArrayOfExtensionconfig, EXTENSION$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExtensionArray(int param1Int, Extensionconfig param1Extensionconfig) {
/* 394 */       synchronized (monitor()) {
/*     */         
/* 396 */         check_orphaned();
/* 397 */         Extensionconfig extensionconfig = null;
/* 398 */         extensionconfig = (Extensionconfig)get_store().find_element_user(EXTENSION$4, param1Int);
/* 399 */         if (extensionconfig == null)
/*     */         {
/* 401 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 403 */         extensionconfig.set((XmlObject)param1Extensionconfig);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Extensionconfig insertNewExtension(int param1Int) {
/* 412 */       synchronized (monitor()) {
/*     */         
/* 414 */         check_orphaned();
/* 415 */         Extensionconfig extensionconfig = null;
/* 416 */         extensionconfig = (Extensionconfig)get_store().insert_element_user(EXTENSION$4, param1Int);
/* 417 */         return extensionconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Extensionconfig addNewExtension() {
/* 426 */       synchronized (monitor()) {
/*     */         
/* 428 */         check_orphaned();
/* 429 */         Extensionconfig extensionconfig = null;
/* 430 */         extensionconfig = (Extensionconfig)get_store().add_element_user(EXTENSION$4);
/* 431 */         return extensionconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeExtension(int param1Int) {
/* 440 */       synchronized (monitor()) {
/*     */         
/* 442 */         check_orphaned();
/* 443 */         get_store().remove_element(EXTENSION$4, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Usertypeconfig[] getUsertypeArray() {
/* 452 */       synchronized (monitor()) {
/*     */         
/* 454 */         check_orphaned();
/* 455 */         ArrayList arrayList = new ArrayList();
/* 456 */         get_store().find_all_element_users(USERTYPE$6, arrayList);
/* 457 */         Usertypeconfig[] arrayOfUsertypeconfig = new Usertypeconfig[arrayList.size()];
/* 458 */         arrayList.toArray((Object[])arrayOfUsertypeconfig);
/* 459 */         return arrayOfUsertypeconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Usertypeconfig getUsertypeArray(int param1Int) {
/* 468 */       synchronized (monitor()) {
/*     */         
/* 470 */         check_orphaned();
/* 471 */         Usertypeconfig usertypeconfig = null;
/* 472 */         usertypeconfig = (Usertypeconfig)get_store().find_element_user(USERTYPE$6, param1Int);
/* 473 */         if (usertypeconfig == null)
/*     */         {
/* 475 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 477 */         return usertypeconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfUsertypeArray() {
/* 486 */       synchronized (monitor()) {
/*     */         
/* 488 */         check_orphaned();
/* 489 */         return get_store().count_elements(USERTYPE$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setUsertypeArray(Usertypeconfig[] param1ArrayOfUsertypeconfig) {
/* 498 */       synchronized (monitor()) {
/*     */         
/* 500 */         check_orphaned();
/* 501 */         arraySetterHelper((XmlObject[])param1ArrayOfUsertypeconfig, USERTYPE$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setUsertypeArray(int param1Int, Usertypeconfig param1Usertypeconfig) {
/* 510 */       synchronized (monitor()) {
/*     */         
/* 512 */         check_orphaned();
/* 513 */         Usertypeconfig usertypeconfig = null;
/* 514 */         usertypeconfig = (Usertypeconfig)get_store().find_element_user(USERTYPE$6, param1Int);
/* 515 */         if (usertypeconfig == null)
/*     */         {
/* 517 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 519 */         usertypeconfig.set((XmlObject)param1Usertypeconfig);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Usertypeconfig insertNewUsertype(int param1Int) {
/* 528 */       synchronized (monitor()) {
/*     */         
/* 530 */         check_orphaned();
/* 531 */         Usertypeconfig usertypeconfig = null;
/* 532 */         usertypeconfig = (Usertypeconfig)get_store().insert_element_user(USERTYPE$6, param1Int);
/* 533 */         return usertypeconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Usertypeconfig addNewUsertype() {
/* 542 */       synchronized (monitor()) {
/*     */         
/* 544 */         check_orphaned();
/* 545 */         Usertypeconfig usertypeconfig = null;
/* 546 */         usertypeconfig = (Usertypeconfig)get_store().add_element_user(USERTYPE$6);
/* 547 */         return usertypeconfig;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeUsertype(int param1Int) {
/* 556 */       synchronized (monitor()) {
/*     */         
/* 558 */         check_orphaned();
/* 559 */         get_store().remove_element(USERTYPE$6, param1Int);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\ConfigDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */