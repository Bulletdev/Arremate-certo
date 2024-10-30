/*     */ package org.apache.xmlbeans.impl.xb.substwsdl.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
/*     */ import org.apache.xmlbeans.impl.xb.substwsdl.TImport;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefinitionsDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements DefinitionsDocument
/*     */ {
/*     */   public DefinitionsDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b DEFINITIONS$0 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "definitions");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefinitionsDocument.Definitions getDefinitions() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       DefinitionsDocument.Definitions definitions = null;
/*  36 */       definitions = (DefinitionsDocument.Definitions)get_store().find_element_user(DEFINITIONS$0, 0);
/*  37 */       if (definitions == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return definitions;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefinitions(DefinitionsDocument.Definitions paramDefinitions) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       DefinitionsDocument.Definitions definitions = null;
/*  54 */       definitions = (DefinitionsDocument.Definitions)get_store().find_element_user(DEFINITIONS$0, 0);
/*  55 */       if (definitions == null)
/*     */       {
/*  57 */         definitions = (DefinitionsDocument.Definitions)get_store().add_element_user(DEFINITIONS$0);
/*     */       }
/*  59 */       definitions.set((XmlObject)paramDefinitions);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefinitionsDocument.Definitions addNewDefinitions() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       DefinitionsDocument.Definitions definitions = null;
/*  72 */       definitions = (DefinitionsDocument.Definitions)get_store().add_element_user(DEFINITIONS$0);
/*  73 */       return definitions;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DefinitionsImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements DefinitionsDocument.Definitions
/*     */   {
/*     */     public DefinitionsImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b IMPORT$0 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "import");
/*     */     
/*  91 */     private static final b TYPES$2 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "types");
/*     */     
/*  93 */     private static final b MESSAGE$4 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "message");
/*     */     
/*  95 */     private static final b BINDING$6 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "binding");
/*     */     
/*  97 */     private static final b PORTTYPE$8 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "portType");
/*     */     
/*  99 */     private static final b SERVICE$10 = new b("http://www.apache.org/internal/xmlbeans/wsdlsubst", "service");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TImport[] getImportArray() {
/* 108 */       synchronized (monitor()) {
/*     */         
/* 110 */         check_orphaned();
/* 111 */         ArrayList arrayList = new ArrayList();
/* 112 */         get_store().find_all_element_users(IMPORT$0, arrayList);
/* 113 */         TImport[] arrayOfTImport = new TImport[arrayList.size()];
/* 114 */         arrayList.toArray((Object[])arrayOfTImport);
/* 115 */         return arrayOfTImport;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TImport getImportArray(int param1Int) {
/* 124 */       synchronized (monitor()) {
/*     */         
/* 126 */         check_orphaned();
/* 127 */         TImport tImport = null;
/* 128 */         tImport = (TImport)get_store().find_element_user(IMPORT$0, param1Int);
/* 129 */         if (tImport == null)
/*     */         {
/* 131 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 133 */         return tImport;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfImportArray() {
/* 142 */       synchronized (monitor()) {
/*     */         
/* 144 */         check_orphaned();
/* 145 */         return get_store().count_elements(IMPORT$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setImportArray(TImport[] param1ArrayOfTImport) {
/* 154 */       synchronized (monitor()) {
/*     */         
/* 156 */         check_orphaned();
/* 157 */         arraySetterHelper((XmlObject[])param1ArrayOfTImport, IMPORT$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setImportArray(int param1Int, TImport param1TImport) {
/* 166 */       synchronized (monitor()) {
/*     */         
/* 168 */         check_orphaned();
/* 169 */         TImport tImport = null;
/* 170 */         tImport = (TImport)get_store().find_element_user(IMPORT$0, param1Int);
/* 171 */         if (tImport == null)
/*     */         {
/* 173 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 175 */         tImport.set((XmlObject)param1TImport);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TImport insertNewImport(int param1Int) {
/* 184 */       synchronized (monitor()) {
/*     */         
/* 186 */         check_orphaned();
/* 187 */         TImport tImport = null;
/* 188 */         tImport = (TImport)get_store().insert_element_user(IMPORT$0, param1Int);
/* 189 */         return tImport;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TImport addNewImport() {
/* 198 */       synchronized (monitor()) {
/*     */         
/* 200 */         check_orphaned();
/* 201 */         TImport tImport = null;
/* 202 */         tImport = (TImport)get_store().add_element_user(IMPORT$0);
/* 203 */         return tImport;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeImport(int param1Int) {
/* 212 */       synchronized (monitor()) {
/*     */         
/* 214 */         check_orphaned();
/* 215 */         get_store().remove_element(IMPORT$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject[] getTypesArray() {
/* 224 */       synchronized (monitor()) {
/*     */         
/* 226 */         check_orphaned();
/* 227 */         ArrayList arrayList = new ArrayList();
/* 228 */         get_store().find_all_element_users(TYPES$2, arrayList);
/* 229 */         XmlObject[] arrayOfXmlObject = new XmlObject[arrayList.size()];
/* 230 */         arrayList.toArray((Object[])arrayOfXmlObject);
/* 231 */         return arrayOfXmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject getTypesArray(int param1Int) {
/* 240 */       synchronized (monitor()) {
/*     */         
/* 242 */         check_orphaned();
/* 243 */         XmlObject xmlObject = null;
/* 244 */         xmlObject = (XmlObject)get_store().find_element_user(TYPES$2, param1Int);
/* 245 */         if (xmlObject == null)
/*     */         {
/* 247 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 249 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfTypesArray() {
/* 258 */       synchronized (monitor()) {
/*     */         
/* 260 */         check_orphaned();
/* 261 */         return get_store().count_elements(TYPES$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTypesArray(XmlObject[] param1ArrayOfXmlObject) {
/* 270 */       synchronized (monitor()) {
/*     */         
/* 272 */         check_orphaned();
/* 273 */         arraySetterHelper(param1ArrayOfXmlObject, TYPES$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setTypesArray(int param1Int, XmlObject param1XmlObject) {
/* 282 */       synchronized (monitor()) {
/*     */         
/* 284 */         check_orphaned();
/* 285 */         XmlObject xmlObject = null;
/* 286 */         xmlObject = (XmlObject)get_store().find_element_user(TYPES$2, param1Int);
/* 287 */         if (xmlObject == null)
/*     */         {
/* 289 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 291 */         xmlObject.set(param1XmlObject);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject insertNewTypes(int param1Int) {
/* 300 */       synchronized (monitor()) {
/*     */         
/* 302 */         check_orphaned();
/* 303 */         XmlObject xmlObject = null;
/* 304 */         xmlObject = (XmlObject)get_store().insert_element_user(TYPES$2, param1Int);
/* 305 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject addNewTypes() {
/* 314 */       synchronized (monitor()) {
/*     */         
/* 316 */         check_orphaned();
/* 317 */         XmlObject xmlObject = null;
/* 318 */         xmlObject = (XmlObject)get_store().add_element_user(TYPES$2);
/* 319 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeTypes(int param1Int) {
/* 328 */       synchronized (monitor()) {
/*     */         
/* 330 */         check_orphaned();
/* 331 */         get_store().remove_element(TYPES$2, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject[] getMessageArray() {
/* 340 */       synchronized (monitor()) {
/*     */         
/* 342 */         check_orphaned();
/* 343 */         ArrayList arrayList = new ArrayList();
/* 344 */         get_store().find_all_element_users(MESSAGE$4, arrayList);
/* 345 */         XmlObject[] arrayOfXmlObject = new XmlObject[arrayList.size()];
/* 346 */         arrayList.toArray((Object[])arrayOfXmlObject);
/* 347 */         return arrayOfXmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject getMessageArray(int param1Int) {
/* 356 */       synchronized (monitor()) {
/*     */         
/* 358 */         check_orphaned();
/* 359 */         XmlObject xmlObject = null;
/* 360 */         xmlObject = (XmlObject)get_store().find_element_user(MESSAGE$4, param1Int);
/* 361 */         if (xmlObject == null)
/*     */         {
/* 363 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 365 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfMessageArray() {
/* 374 */       synchronized (monitor()) {
/*     */         
/* 376 */         check_orphaned();
/* 377 */         return get_store().count_elements(MESSAGE$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMessageArray(XmlObject[] param1ArrayOfXmlObject) {
/* 386 */       synchronized (monitor()) {
/*     */         
/* 388 */         check_orphaned();
/* 389 */         arraySetterHelper(param1ArrayOfXmlObject, MESSAGE$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMessageArray(int param1Int, XmlObject param1XmlObject) {
/* 398 */       synchronized (monitor()) {
/*     */         
/* 400 */         check_orphaned();
/* 401 */         XmlObject xmlObject = null;
/* 402 */         xmlObject = (XmlObject)get_store().find_element_user(MESSAGE$4, param1Int);
/* 403 */         if (xmlObject == null)
/*     */         {
/* 405 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 407 */         xmlObject.set(param1XmlObject);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject insertNewMessage(int param1Int) {
/* 416 */       synchronized (monitor()) {
/*     */         
/* 418 */         check_orphaned();
/* 419 */         XmlObject xmlObject = null;
/* 420 */         xmlObject = (XmlObject)get_store().insert_element_user(MESSAGE$4, param1Int);
/* 421 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject addNewMessage() {
/* 430 */       synchronized (monitor()) {
/*     */         
/* 432 */         check_orphaned();
/* 433 */         XmlObject xmlObject = null;
/* 434 */         xmlObject = (XmlObject)get_store().add_element_user(MESSAGE$4);
/* 435 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeMessage(int param1Int) {
/* 444 */       synchronized (monitor()) {
/*     */         
/* 446 */         check_orphaned();
/* 447 */         get_store().remove_element(MESSAGE$4, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject[] getBindingArray() {
/* 456 */       synchronized (monitor()) {
/*     */         
/* 458 */         check_orphaned();
/* 459 */         ArrayList arrayList = new ArrayList();
/* 460 */         get_store().find_all_element_users(BINDING$6, arrayList);
/* 461 */         XmlObject[] arrayOfXmlObject = new XmlObject[arrayList.size()];
/* 462 */         arrayList.toArray((Object[])arrayOfXmlObject);
/* 463 */         return arrayOfXmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject getBindingArray(int param1Int) {
/* 472 */       synchronized (monitor()) {
/*     */         
/* 474 */         check_orphaned();
/* 475 */         XmlObject xmlObject = null;
/* 476 */         xmlObject = (XmlObject)get_store().find_element_user(BINDING$6, param1Int);
/* 477 */         if (xmlObject == null)
/*     */         {
/* 479 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 481 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfBindingArray() {
/* 490 */       synchronized (monitor()) {
/*     */         
/* 492 */         check_orphaned();
/* 493 */         return get_store().count_elements(BINDING$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setBindingArray(XmlObject[] param1ArrayOfXmlObject) {
/* 502 */       synchronized (monitor()) {
/*     */         
/* 504 */         check_orphaned();
/* 505 */         arraySetterHelper(param1ArrayOfXmlObject, BINDING$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setBindingArray(int param1Int, XmlObject param1XmlObject) {
/* 514 */       synchronized (monitor()) {
/*     */         
/* 516 */         check_orphaned();
/* 517 */         XmlObject xmlObject = null;
/* 518 */         xmlObject = (XmlObject)get_store().find_element_user(BINDING$6, param1Int);
/* 519 */         if (xmlObject == null)
/*     */         {
/* 521 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 523 */         xmlObject.set(param1XmlObject);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject insertNewBinding(int param1Int) {
/* 532 */       synchronized (monitor()) {
/*     */         
/* 534 */         check_orphaned();
/* 535 */         XmlObject xmlObject = null;
/* 536 */         xmlObject = (XmlObject)get_store().insert_element_user(BINDING$6, param1Int);
/* 537 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject addNewBinding() {
/* 546 */       synchronized (monitor()) {
/*     */         
/* 548 */         check_orphaned();
/* 549 */         XmlObject xmlObject = null;
/* 550 */         xmlObject = (XmlObject)get_store().add_element_user(BINDING$6);
/* 551 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeBinding(int param1Int) {
/* 560 */       synchronized (monitor()) {
/*     */         
/* 562 */         check_orphaned();
/* 563 */         get_store().remove_element(BINDING$6, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject[] getPortTypeArray() {
/* 572 */       synchronized (monitor()) {
/*     */         
/* 574 */         check_orphaned();
/* 575 */         ArrayList arrayList = new ArrayList();
/* 576 */         get_store().find_all_element_users(PORTTYPE$8, arrayList);
/* 577 */         XmlObject[] arrayOfXmlObject = new XmlObject[arrayList.size()];
/* 578 */         arrayList.toArray((Object[])arrayOfXmlObject);
/* 579 */         return arrayOfXmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject getPortTypeArray(int param1Int) {
/* 588 */       synchronized (monitor()) {
/*     */         
/* 590 */         check_orphaned();
/* 591 */         XmlObject xmlObject = null;
/* 592 */         xmlObject = (XmlObject)get_store().find_element_user(PORTTYPE$8, param1Int);
/* 593 */         if (xmlObject == null)
/*     */         {
/* 595 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 597 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfPortTypeArray() {
/* 606 */       synchronized (monitor()) {
/*     */         
/* 608 */         check_orphaned();
/* 609 */         return get_store().count_elements(PORTTYPE$8);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setPortTypeArray(XmlObject[] param1ArrayOfXmlObject) {
/* 618 */       synchronized (monitor()) {
/*     */         
/* 620 */         check_orphaned();
/* 621 */         arraySetterHelper(param1ArrayOfXmlObject, PORTTYPE$8);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setPortTypeArray(int param1Int, XmlObject param1XmlObject) {
/* 630 */       synchronized (monitor()) {
/*     */         
/* 632 */         check_orphaned();
/* 633 */         XmlObject xmlObject = null;
/* 634 */         xmlObject = (XmlObject)get_store().find_element_user(PORTTYPE$8, param1Int);
/* 635 */         if (xmlObject == null)
/*     */         {
/* 637 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 639 */         xmlObject.set(param1XmlObject);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject insertNewPortType(int param1Int) {
/* 648 */       synchronized (monitor()) {
/*     */         
/* 650 */         check_orphaned();
/* 651 */         XmlObject xmlObject = null;
/* 652 */         xmlObject = (XmlObject)get_store().insert_element_user(PORTTYPE$8, param1Int);
/* 653 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject addNewPortType() {
/* 662 */       synchronized (monitor()) {
/*     */         
/* 664 */         check_orphaned();
/* 665 */         XmlObject xmlObject = null;
/* 666 */         xmlObject = (XmlObject)get_store().add_element_user(PORTTYPE$8);
/* 667 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removePortType(int param1Int) {
/* 676 */       synchronized (monitor()) {
/*     */         
/* 678 */         check_orphaned();
/* 679 */         get_store().remove_element(PORTTYPE$8, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject[] getServiceArray() {
/* 688 */       synchronized (monitor()) {
/*     */         
/* 690 */         check_orphaned();
/* 691 */         ArrayList arrayList = new ArrayList();
/* 692 */         get_store().find_all_element_users(SERVICE$10, arrayList);
/* 693 */         XmlObject[] arrayOfXmlObject = new XmlObject[arrayList.size()];
/* 694 */         arrayList.toArray((Object[])arrayOfXmlObject);
/* 695 */         return arrayOfXmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject getServiceArray(int param1Int) {
/* 704 */       synchronized (monitor()) {
/*     */         
/* 706 */         check_orphaned();
/* 707 */         XmlObject xmlObject = null;
/* 708 */         xmlObject = (XmlObject)get_store().find_element_user(SERVICE$10, param1Int);
/* 709 */         if (xmlObject == null)
/*     */         {
/* 711 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 713 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfServiceArray() {
/* 722 */       synchronized (monitor()) {
/*     */         
/* 724 */         check_orphaned();
/* 725 */         return get_store().count_elements(SERVICE$10);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setServiceArray(XmlObject[] param1ArrayOfXmlObject) {
/* 734 */       synchronized (monitor()) {
/*     */         
/* 736 */         check_orphaned();
/* 737 */         arraySetterHelper(param1ArrayOfXmlObject, SERVICE$10);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setServiceArray(int param1Int, XmlObject param1XmlObject) {
/* 746 */       synchronized (monitor()) {
/*     */         
/* 748 */         check_orphaned();
/* 749 */         XmlObject xmlObject = null;
/* 750 */         xmlObject = (XmlObject)get_store().find_element_user(SERVICE$10, param1Int);
/* 751 */         if (xmlObject == null)
/*     */         {
/* 753 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 755 */         xmlObject.set(param1XmlObject);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject insertNewService(int param1Int) {
/* 764 */       synchronized (monitor()) {
/*     */         
/* 766 */         check_orphaned();
/* 767 */         XmlObject xmlObject = null;
/* 768 */         xmlObject = (XmlObject)get_store().insert_element_user(SERVICE$10, param1Int);
/* 769 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlObject addNewService() {
/* 778 */       synchronized (monitor()) {
/*     */         
/* 780 */         check_orphaned();
/* 781 */         XmlObject xmlObject = null;
/* 782 */         xmlObject = (XmlObject)get_store().add_element_user(SERVICE$10);
/* 783 */         return xmlObject;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeService(int param1Int) {
/* 792 */       synchronized (monitor()) {
/*     */         
/* 794 */         check_orphaned();
/* 795 */         get_store().remove_element(SERVICE$10, param1Int);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\substwsdl\impl\DefinitionsDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */