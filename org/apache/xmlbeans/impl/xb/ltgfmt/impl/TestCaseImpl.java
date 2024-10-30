/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
/*     */ 
/*     */ public class TestCaseImpl
/*     */   extends XmlComplexContentImpl implements TestCase {
/*     */   public TestCaseImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b DESCRIPTION$0 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "description");
/*     */   
/*  24 */   private static final b FILES$2 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "files");
/*     */   
/*  26 */   private static final b ID$4 = new b("", "id");
/*     */   
/*  28 */   private static final b ORIGIN$6 = new b("", "origin");
/*     */   
/*  30 */   private static final b MODIFIED$8 = new b("", "modified");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  39 */     synchronized (monitor()) {
/*     */       
/*  41 */       check_orphaned();
/*  42 */       SimpleValue simpleValue = null;
/*  43 */       simpleValue = (SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
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
/*     */   public XmlString xgetDescription() {
/*  57 */     synchronized (monitor()) {
/*     */       
/*  59 */       check_orphaned();
/*  60 */       XmlString xmlString = null;
/*  61 */       xmlString = (XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
/*  62 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetDescription() {
/*  71 */     synchronized (monitor()) {
/*     */       
/*  73 */       check_orphaned();
/*  74 */       return (get_store().count_elements(DESCRIPTION$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String paramString) {
/*  83 */     synchronized (monitor()) {
/*     */       
/*  85 */       check_orphaned();
/*  86 */       SimpleValue simpleValue = null;
/*  87 */       simpleValue = (SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
/*  88 */       if (simpleValue == null)
/*     */       {
/*  90 */         simpleValue = (SimpleValue)get_store().add_element_user(DESCRIPTION$0);
/*     */       }
/*  92 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetDescription(XmlString paramXmlString) {
/* 101 */     synchronized (monitor()) {
/*     */       
/* 103 */       check_orphaned();
/* 104 */       XmlString xmlString = null;
/* 105 */       xmlString = (XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
/* 106 */       if (xmlString == null)
/*     */       {
/* 108 */         xmlString = (XmlString)get_store().add_element_user(DESCRIPTION$0);
/*     */       }
/* 110 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetDescription() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       get_store().remove_element(DESCRIPTION$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestCase.Files getFiles() {
/* 131 */     synchronized (monitor()) {
/*     */       
/* 133 */       check_orphaned();
/* 134 */       TestCase.Files files = null;
/* 135 */       files = (TestCase.Files)get_store().find_element_user(FILES$2, 0);
/* 136 */       if (files == null)
/*     */       {
/* 138 */         return null;
/*     */       }
/* 140 */       return files;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFiles(TestCase.Files paramFiles) {
/* 149 */     synchronized (monitor()) {
/*     */       
/* 151 */       check_orphaned();
/* 152 */       TestCase.Files files = null;
/* 153 */       files = (TestCase.Files)get_store().find_element_user(FILES$2, 0);
/* 154 */       if (files == null)
/*     */       {
/* 156 */         files = (TestCase.Files)get_store().add_element_user(FILES$2);
/*     */       }
/* 158 */       files.set((XmlObject)paramFiles);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TestCase.Files addNewFiles() {
/* 167 */     synchronized (monitor()) {
/*     */       
/* 169 */       check_orphaned();
/* 170 */       TestCase.Files files = null;
/* 171 */       files = (TestCase.Files)get_store().add_element_user(FILES$2);
/* 172 */       return files;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 181 */     synchronized (monitor()) {
/*     */       
/* 183 */       check_orphaned();
/* 184 */       SimpleValue simpleValue = null;
/* 185 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
/* 186 */       if (simpleValue == null)
/*     */       {
/* 188 */         return null;
/*     */       }
/* 190 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlID xgetId() {
/* 199 */     synchronized (monitor()) {
/*     */       
/* 201 */       check_orphaned();
/* 202 */       XmlID xmlID = null;
/* 203 */       xmlID = (XmlID)get_store().find_attribute_user(ID$4);
/* 204 */       return xmlID;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetId() {
/* 213 */     synchronized (monitor()) {
/*     */       
/* 215 */       check_orphaned();
/* 216 */       return (get_store().find_attribute_user(ID$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String paramString) {
/* 225 */     synchronized (monitor()) {
/*     */       
/* 227 */       check_orphaned();
/* 228 */       SimpleValue simpleValue = null;
/* 229 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
/* 230 */       if (simpleValue == null)
/*     */       {
/* 232 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4);
/*     */       }
/* 234 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetId(XmlID paramXmlID) {
/* 243 */     synchronized (monitor()) {
/*     */       
/* 245 */       check_orphaned();
/* 246 */       XmlID xmlID = null;
/* 247 */       xmlID = (XmlID)get_store().find_attribute_user(ID$4);
/* 248 */       if (xmlID == null)
/*     */       {
/* 250 */         xmlID = (XmlID)get_store().add_attribute_user(ID$4);
/*     */       }
/* 252 */       xmlID.set((XmlObject)paramXmlID);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetId() {
/* 261 */     synchronized (monitor()) {
/*     */       
/* 263 */       check_orphaned();
/* 264 */       get_store().remove_attribute(ID$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrigin() {
/* 273 */     synchronized (monitor()) {
/*     */       
/* 275 */       check_orphaned();
/* 276 */       SimpleValue simpleValue = null;
/* 277 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$6);
/* 278 */       if (simpleValue == null)
/*     */       {
/* 280 */         return null;
/*     */       }
/* 282 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetOrigin() {
/* 291 */     synchronized (monitor()) {
/*     */       
/* 293 */       check_orphaned();
/* 294 */       XmlToken xmlToken = null;
/* 295 */       xmlToken = (XmlToken)get_store().find_attribute_user(ORIGIN$6);
/* 296 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetOrigin() {
/* 305 */     synchronized (monitor()) {
/*     */       
/* 307 */       check_orphaned();
/* 308 */       return (get_store().find_attribute_user(ORIGIN$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrigin(String paramString) {
/* 317 */     synchronized (monitor()) {
/*     */       
/* 319 */       check_orphaned();
/* 320 */       SimpleValue simpleValue = null;
/* 321 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ORIGIN$6);
/* 322 */       if (simpleValue == null)
/*     */       {
/* 324 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ORIGIN$6);
/*     */       }
/* 326 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetOrigin(XmlToken paramXmlToken) {
/* 335 */     synchronized (monitor()) {
/*     */       
/* 337 */       check_orphaned();
/* 338 */       XmlToken xmlToken = null;
/* 339 */       xmlToken = (XmlToken)get_store().find_attribute_user(ORIGIN$6);
/* 340 */       if (xmlToken == null)
/*     */       {
/* 342 */         xmlToken = (XmlToken)get_store().add_attribute_user(ORIGIN$6);
/*     */       }
/* 344 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetOrigin() {
/* 353 */     synchronized (monitor()) {
/*     */       
/* 355 */       check_orphaned();
/* 356 */       get_store().remove_attribute(ORIGIN$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getModified() {
/* 365 */     synchronized (monitor()) {
/*     */       
/* 367 */       check_orphaned();
/* 368 */       SimpleValue simpleValue = null;
/* 369 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MODIFIED$8);
/* 370 */       if (simpleValue == null)
/*     */       {
/* 372 */         return false;
/*     */       }
/* 374 */       return simpleValue.getBooleanValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlBoolean xgetModified() {
/* 383 */     synchronized (monitor()) {
/*     */       
/* 385 */       check_orphaned();
/* 386 */       XmlBoolean xmlBoolean = null;
/* 387 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MODIFIED$8);
/* 388 */       return xmlBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetModified() {
/* 397 */     synchronized (monitor()) {
/*     */       
/* 399 */       check_orphaned();
/* 400 */       return (get_store().find_attribute_user(MODIFIED$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModified(boolean paramBoolean) {
/* 409 */     synchronized (monitor()) {
/*     */       
/* 411 */       check_orphaned();
/* 412 */       SimpleValue simpleValue = null;
/* 413 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MODIFIED$8);
/* 414 */       if (simpleValue == null)
/*     */       {
/* 416 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MODIFIED$8);
/*     */       }
/* 418 */       simpleValue.setBooleanValue(paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetModified(XmlBoolean paramXmlBoolean) {
/* 427 */     synchronized (monitor()) {
/*     */       
/* 429 */       check_orphaned();
/* 430 */       XmlBoolean xmlBoolean = null;
/* 431 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MODIFIED$8);
/* 432 */       if (xmlBoolean == null)
/*     */       {
/* 434 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MODIFIED$8);
/*     */       }
/* 436 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetModified() {
/* 445 */     synchronized (monitor()) {
/*     */       
/* 447 */       check_orphaned();
/* 448 */       get_store().remove_attribute(MODIFIED$8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FilesImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements TestCase.Files
/*     */   {
/*     */     public FilesImpl(SchemaType param1SchemaType) {
/* 461 */       super(param1SchemaType);
/*     */     }
/*     */     
/* 464 */     private static final b FILE$0 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "file");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FileDesc[] getFileArray() {
/* 473 */       synchronized (monitor()) {
/*     */         
/* 475 */         check_orphaned();
/* 476 */         ArrayList arrayList = new ArrayList();
/* 477 */         get_store().find_all_element_users(FILE$0, arrayList);
/* 478 */         FileDesc[] arrayOfFileDesc = new FileDesc[arrayList.size()];
/* 479 */         arrayList.toArray((Object[])arrayOfFileDesc);
/* 480 */         return arrayOfFileDesc;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FileDesc getFileArray(int param1Int) {
/* 489 */       synchronized (monitor()) {
/*     */         
/* 491 */         check_orphaned();
/* 492 */         FileDesc fileDesc = null;
/* 493 */         fileDesc = (FileDesc)get_store().find_element_user(FILE$0, param1Int);
/* 494 */         if (fileDesc == null)
/*     */         {
/* 496 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 498 */         return fileDesc;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfFileArray() {
/* 507 */       synchronized (monitor()) {
/*     */         
/* 509 */         check_orphaned();
/* 510 */         return get_store().count_elements(FILE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFileArray(FileDesc[] param1ArrayOfFileDesc) {
/* 519 */       synchronized (monitor()) {
/*     */         
/* 521 */         check_orphaned();
/* 522 */         arraySetterHelper((XmlObject[])param1ArrayOfFileDesc, FILE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setFileArray(int param1Int, FileDesc param1FileDesc) {
/* 531 */       synchronized (monitor()) {
/*     */         
/* 533 */         check_orphaned();
/* 534 */         FileDesc fileDesc = null;
/* 535 */         fileDesc = (FileDesc)get_store().find_element_user(FILE$0, param1Int);
/* 536 */         if (fileDesc == null)
/*     */         {
/* 538 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 540 */         fileDesc.set((XmlObject)param1FileDesc);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FileDesc insertNewFile(int param1Int) {
/* 549 */       synchronized (monitor()) {
/*     */         
/* 551 */         check_orphaned();
/* 552 */         FileDesc fileDesc = null;
/* 553 */         fileDesc = (FileDesc)get_store().insert_element_user(FILE$0, param1Int);
/* 554 */         return fileDesc;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FileDesc addNewFile() {
/* 563 */       synchronized (monitor()) {
/*     */         
/* 565 */         check_orphaned();
/* 566 */         FileDesc fileDesc = null;
/* 567 */         fileDesc = (FileDesc)get_store().add_element_user(FILE$0);
/* 568 */         return fileDesc;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeFile(int param1Int) {
/* 577 */       synchronized (monitor()) {
/*     */         
/* 579 */         check_orphaned();
/* 580 */         get_store().remove_element(FILE$0, param1Int);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\impl\TestCaseImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */