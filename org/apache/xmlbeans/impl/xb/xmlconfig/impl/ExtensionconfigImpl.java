/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.JavaNameList;
/*     */ 
/*     */ 
/*     */ public class ExtensionconfigImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements Extensionconfig
/*     */ {
/*     */   public ExtensionconfigImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b INTERFACE$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "interface");
/*     */   
/*  24 */   private static final b PREPOSTSET$2 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "prePostSet");
/*     */   
/*  26 */   private static final b FOR$4 = new b("", "for");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.Interface[] getInterfaceArray() {
/*  35 */     synchronized (monitor()) {
/*     */       
/*  37 */       check_orphaned();
/*  38 */       ArrayList arrayList = new ArrayList();
/*  39 */       get_store().find_all_element_users(INTERFACE$0, arrayList);
/*  40 */       Extensionconfig.Interface[] arrayOfInterface = new Extensionconfig.Interface[arrayList.size()];
/*  41 */       arrayList.toArray((Object[])arrayOfInterface);
/*  42 */       return arrayOfInterface;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.Interface getInterfaceArray(int paramInt) {
/*  51 */     synchronized (monitor()) {
/*     */       
/*  53 */       check_orphaned();
/*  54 */       Extensionconfig.Interface interface_ = null;
/*  55 */       interface_ = (Extensionconfig.Interface)get_store().find_element_user(INTERFACE$0, paramInt);
/*  56 */       if (interface_ == null)
/*     */       {
/*  58 */         throw new IndexOutOfBoundsException();
/*     */       }
/*  60 */       return interface_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfInterfaceArray() {
/*  69 */     synchronized (monitor()) {
/*     */       
/*  71 */       check_orphaned();
/*  72 */       return get_store().count_elements(INTERFACE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInterfaceArray(Extensionconfig.Interface[] paramArrayOfInterface) {
/*  81 */     synchronized (monitor()) {
/*     */       
/*  83 */       check_orphaned();
/*  84 */       arraySetterHelper((XmlObject[])paramArrayOfInterface, INTERFACE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInterfaceArray(int paramInt, Extensionconfig.Interface paramInterface) {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       Extensionconfig.Interface interface_ = null;
/*  97 */       interface_ = (Extensionconfig.Interface)get_store().find_element_user(INTERFACE$0, paramInt);
/*  98 */       if (interface_ == null)
/*     */       {
/* 100 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 102 */       interface_.set((XmlObject)paramInterface);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.Interface insertNewInterface(int paramInt) {
/* 111 */     synchronized (monitor()) {
/*     */       
/* 113 */       check_orphaned();
/* 114 */       Extensionconfig.Interface interface_ = null;
/* 115 */       interface_ = (Extensionconfig.Interface)get_store().insert_element_user(INTERFACE$0, paramInt);
/* 116 */       return interface_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.Interface addNewInterface() {
/* 125 */     synchronized (monitor()) {
/*     */       
/* 127 */       check_orphaned();
/* 128 */       Extensionconfig.Interface interface_ = null;
/* 129 */       interface_ = (Extensionconfig.Interface)get_store().add_element_user(INTERFACE$0);
/* 130 */       return interface_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeInterface(int paramInt) {
/* 139 */     synchronized (monitor()) {
/*     */       
/* 141 */       check_orphaned();
/* 142 */       get_store().remove_element(INTERFACE$0, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.PrePostSet getPrePostSet() {
/* 151 */     synchronized (monitor()) {
/*     */       
/* 153 */       check_orphaned();
/* 154 */       Extensionconfig.PrePostSet prePostSet = null;
/* 155 */       prePostSet = (Extensionconfig.PrePostSet)get_store().find_element_user(PREPOSTSET$2, 0);
/* 156 */       if (prePostSet == null)
/*     */       {
/* 158 */         return null;
/*     */       }
/* 160 */       return prePostSet;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetPrePostSet() {
/* 169 */     synchronized (monitor()) {
/*     */       
/* 171 */       check_orphaned();
/* 172 */       return (get_store().count_elements(PREPOSTSET$2) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrePostSet(Extensionconfig.PrePostSet paramPrePostSet) {
/* 181 */     synchronized (monitor()) {
/*     */       
/* 183 */       check_orphaned();
/* 184 */       Extensionconfig.PrePostSet prePostSet = null;
/* 185 */       prePostSet = (Extensionconfig.PrePostSet)get_store().find_element_user(PREPOSTSET$2, 0);
/* 186 */       if (prePostSet == null)
/*     */       {
/* 188 */         prePostSet = (Extensionconfig.PrePostSet)get_store().add_element_user(PREPOSTSET$2);
/*     */       }
/* 190 */       prePostSet.set((XmlObject)paramPrePostSet);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Extensionconfig.PrePostSet addNewPrePostSet() {
/* 199 */     synchronized (monitor()) {
/*     */       
/* 201 */       check_orphaned();
/* 202 */       Extensionconfig.PrePostSet prePostSet = null;
/* 203 */       prePostSet = (Extensionconfig.PrePostSet)get_store().add_element_user(PREPOSTSET$2);
/* 204 */       return prePostSet;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetPrePostSet() {
/* 213 */     synchronized (monitor()) {
/*     */       
/* 215 */       check_orphaned();
/* 216 */       get_store().remove_element(PREPOSTSET$2, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getFor() {
/* 225 */     synchronized (monitor()) {
/*     */       
/* 227 */       check_orphaned();
/* 228 */       SimpleValue simpleValue = null;
/* 229 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FOR$4);
/* 230 */       if (simpleValue == null)
/*     */       {
/* 232 */         return null;
/*     */       }
/* 234 */       return simpleValue.getObjectValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JavaNameList xgetFor() {
/* 243 */     synchronized (monitor()) {
/*     */       
/* 245 */       check_orphaned();
/* 246 */       JavaNameList javaNameList = null;
/* 247 */       javaNameList = (JavaNameList)get_store().find_attribute_user(FOR$4);
/* 248 */       return javaNameList;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFor() {
/* 257 */     synchronized (monitor()) {
/*     */       
/* 259 */       check_orphaned();
/* 260 */       return (get_store().find_attribute_user(FOR$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFor(Object paramObject) {
/* 269 */     synchronized (monitor()) {
/*     */       
/* 271 */       check_orphaned();
/* 272 */       SimpleValue simpleValue = null;
/* 273 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FOR$4);
/* 274 */       if (simpleValue == null)
/*     */       {
/* 276 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FOR$4);
/*     */       }
/* 278 */       simpleValue.setObjectValue(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFor(JavaNameList paramJavaNameList) {
/* 287 */     synchronized (monitor()) {
/*     */       
/* 289 */       check_orphaned();
/* 290 */       JavaNameList javaNameList = null;
/* 291 */       javaNameList = (JavaNameList)get_store().find_attribute_user(FOR$4);
/* 292 */       if (javaNameList == null)
/*     */       {
/* 294 */         javaNameList = (JavaNameList)get_store().add_attribute_user(FOR$4);
/*     */       }
/* 296 */       javaNameList.set((XmlObject)paramJavaNameList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFor() {
/* 305 */     synchronized (monitor()) {
/*     */       
/* 307 */       check_orphaned();
/* 308 */       get_store().remove_attribute(FOR$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class InterfaceImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements Extensionconfig.Interface
/*     */   {
/*     */     public InterfaceImpl(SchemaType param1SchemaType) {
/* 321 */       super(param1SchemaType);
/*     */     }
/*     */     
/* 324 */     private static final b STATICHANDLER$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");
/*     */     
/* 326 */     private static final b NAME$2 = new b("", "name");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getStaticHandler() {
/* 335 */       synchronized (monitor()) {
/*     */         
/* 337 */         check_orphaned();
/* 338 */         SimpleValue simpleValue = null;
/* 339 */         simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/* 340 */         if (simpleValue == null)
/*     */         {
/* 342 */           return null;
/*     */         }
/* 344 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlString xgetStaticHandler() {
/* 353 */       synchronized (monitor()) {
/*     */         
/* 355 */         check_orphaned();
/* 356 */         XmlString xmlString = null;
/* 357 */         xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/* 358 */         return xmlString;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setStaticHandler(String param1String) {
/* 367 */       synchronized (monitor()) {
/*     */         
/* 369 */         check_orphaned();
/* 370 */         SimpleValue simpleValue = null;
/* 371 */         simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/* 372 */         if (simpleValue == null)
/*     */         {
/* 374 */           simpleValue = (SimpleValue)get_store().add_element_user(STATICHANDLER$0);
/*     */         }
/* 376 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetStaticHandler(XmlString param1XmlString) {
/* 385 */       synchronized (monitor()) {
/*     */         
/* 387 */         check_orphaned();
/* 388 */         XmlString xmlString = null;
/* 389 */         xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/* 390 */         if (xmlString == null)
/*     */         {
/* 392 */           xmlString = (XmlString)get_store().add_element_user(STATICHANDLER$0);
/*     */         }
/* 394 */         xmlString.set((XmlObject)param1XmlString);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 403 */       synchronized (monitor()) {
/*     */         
/* 405 */         check_orphaned();
/* 406 */         SimpleValue simpleValue = null;
/* 407 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 408 */         if (simpleValue == null)
/*     */         {
/* 410 */           return null;
/*     */         }
/* 412 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlString xgetName() {
/* 421 */       synchronized (monitor()) {
/*     */         
/* 423 */         check_orphaned();
/* 424 */         XmlString xmlString = null;
/* 425 */         xmlString = (XmlString)get_store().find_attribute_user(NAME$2);
/* 426 */         return xmlString;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetName() {
/* 435 */       synchronized (monitor()) {
/*     */         
/* 437 */         check_orphaned();
/* 438 */         return (get_store().find_attribute_user(NAME$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setName(String param1String) {
/* 447 */       synchronized (monitor()) {
/*     */         
/* 449 */         check_orphaned();
/* 450 */         SimpleValue simpleValue = null;
/* 451 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 452 */         if (simpleValue == null)
/*     */         {
/* 454 */           simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$2);
/*     */         }
/* 456 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetName(XmlString param1XmlString) {
/* 465 */       synchronized (monitor()) {
/*     */         
/* 467 */         check_orphaned();
/* 468 */         XmlString xmlString = null;
/* 469 */         xmlString = (XmlString)get_store().find_attribute_user(NAME$2);
/* 470 */         if (xmlString == null)
/*     */         {
/* 472 */           xmlString = (XmlString)get_store().add_attribute_user(NAME$2);
/*     */         }
/* 474 */         xmlString.set((XmlObject)param1XmlString);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetName() {
/* 483 */       synchronized (monitor()) {
/*     */         
/* 485 */         check_orphaned();
/* 486 */         get_store().remove_attribute(NAME$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PrePostSetImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements Extensionconfig.PrePostSet
/*     */   {
/*     */     public PrePostSetImpl(SchemaType param1SchemaType) {
/* 500 */       super(param1SchemaType);
/*     */     }
/*     */     
/* 503 */     private static final b STATICHANDLER$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getStaticHandler() {
/* 512 */       synchronized (monitor()) {
/*     */         
/* 514 */         check_orphaned();
/* 515 */         SimpleValue simpleValue = null;
/* 516 */         simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/* 517 */         if (simpleValue == null)
/*     */         {
/* 519 */           return null;
/*     */         }
/* 521 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlString xgetStaticHandler() {
/* 530 */       synchronized (monitor()) {
/*     */         
/* 532 */         check_orphaned();
/* 533 */         XmlString xmlString = null;
/* 534 */         xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/* 535 */         return xmlString;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setStaticHandler(String param1String) {
/* 544 */       synchronized (monitor()) {
/*     */         
/* 546 */         check_orphaned();
/* 547 */         SimpleValue simpleValue = null;
/* 548 */         simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/* 549 */         if (simpleValue == null)
/*     */         {
/* 551 */           simpleValue = (SimpleValue)get_store().add_element_user(STATICHANDLER$0);
/*     */         }
/* 553 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetStaticHandler(XmlString param1XmlString) {
/* 562 */       synchronized (monitor()) {
/*     */         
/* 564 */         check_orphaned();
/* 565 */         XmlString xmlString = null;
/* 566 */         xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/* 567 */         if (xmlString == null)
/*     */         {
/* 569 */           xmlString = (XmlString)get_store().add_element_user(STATICHANDLER$0);
/*     */         }
/* 571 */         xmlString.set((XmlObject)param1XmlString);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\ExtensionconfigImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */