/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
/*     */ 
/*     */ public class FileDescImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements FileDesc {
/*     */   public FileDescImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b CODE$0 = new b("http://www.bea.com/2003/05/xmlbean/ltgfmt", "code");
/*     */   
/*  24 */   private static final b TSDIR$2 = new b("", "tsDir");
/*     */   
/*  26 */   private static final b FOLDER$4 = new b("", "folder");
/*     */   
/*  28 */   private static final b FILENAME$6 = new b("", "fileName");
/*     */   
/*  30 */   private static final b ROLE$8 = new b("", "role");
/*     */   
/*  32 */   private static final b VALIDITY$10 = new b("", "validity");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Code getCode() {
/*  41 */     synchronized (monitor()) {
/*     */       
/*  43 */       check_orphaned();
/*  44 */       Code code = null;
/*  45 */       code = (Code)get_store().find_element_user(CODE$0, 0);
/*  46 */       if (code == null)
/*     */       {
/*  48 */         return null;
/*     */       }
/*  50 */       return code;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetCode() {
/*  59 */     synchronized (monitor()) {
/*     */       
/*  61 */       check_orphaned();
/*  62 */       return (get_store().count_elements(CODE$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCode(Code paramCode) {
/*  71 */     synchronized (monitor()) {
/*     */       
/*  73 */       check_orphaned();
/*  74 */       Code code = null;
/*  75 */       code = (Code)get_store().find_element_user(CODE$0, 0);
/*  76 */       if (code == null)
/*     */       {
/*  78 */         code = (Code)get_store().add_element_user(CODE$0);
/*     */       }
/*  80 */       code.set((XmlObject)paramCode);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Code addNewCode() {
/*  89 */     synchronized (monitor()) {
/*     */       
/*  91 */       check_orphaned();
/*  92 */       Code code = null;
/*  93 */       code = (Code)get_store().add_element_user(CODE$0);
/*  94 */       return code;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetCode() {
/* 103 */     synchronized (monitor()) {
/*     */       
/* 105 */       check_orphaned();
/* 106 */       get_store().remove_element(CODE$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTsDir() {
/* 115 */     synchronized (monitor()) {
/*     */       
/* 117 */       check_orphaned();
/* 118 */       SimpleValue simpleValue = null;
/* 119 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TSDIR$2);
/* 120 */       if (simpleValue == null)
/*     */       {
/* 122 */         return null;
/*     */       }
/* 124 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetTsDir() {
/* 133 */     synchronized (monitor()) {
/*     */       
/* 135 */       check_orphaned();
/* 136 */       XmlToken xmlToken = null;
/* 137 */       xmlToken = (XmlToken)get_store().find_attribute_user(TSDIR$2);
/* 138 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetTsDir() {
/* 147 */     synchronized (monitor()) {
/*     */       
/* 149 */       check_orphaned();
/* 150 */       return (get_store().find_attribute_user(TSDIR$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTsDir(String paramString) {
/* 159 */     synchronized (monitor()) {
/*     */       
/* 161 */       check_orphaned();
/* 162 */       SimpleValue simpleValue = null;
/* 163 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TSDIR$2);
/* 164 */       if (simpleValue == null)
/*     */       {
/* 166 */         simpleValue = (SimpleValue)get_store().add_attribute_user(TSDIR$2);
/*     */       }
/* 168 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetTsDir(XmlToken paramXmlToken) {
/* 177 */     synchronized (monitor()) {
/*     */       
/* 179 */       check_orphaned();
/* 180 */       XmlToken xmlToken = null;
/* 181 */       xmlToken = (XmlToken)get_store().find_attribute_user(TSDIR$2);
/* 182 */       if (xmlToken == null)
/*     */       {
/* 184 */         xmlToken = (XmlToken)get_store().add_attribute_user(TSDIR$2);
/*     */       }
/* 186 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetTsDir() {
/* 195 */     synchronized (monitor()) {
/*     */       
/* 197 */       check_orphaned();
/* 198 */       get_store().remove_attribute(TSDIR$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFolder() {
/* 207 */     synchronized (monitor()) {
/*     */       
/* 209 */       check_orphaned();
/* 210 */       SimpleValue simpleValue = null;
/* 211 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FOLDER$4);
/* 212 */       if (simpleValue == null)
/*     */       {
/* 214 */         return null;
/*     */       }
/* 216 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetFolder() {
/* 225 */     synchronized (monitor()) {
/*     */       
/* 227 */       check_orphaned();
/* 228 */       XmlToken xmlToken = null;
/* 229 */       xmlToken = (XmlToken)get_store().find_attribute_user(FOLDER$4);
/* 230 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFolder() {
/* 239 */     synchronized (monitor()) {
/*     */       
/* 241 */       check_orphaned();
/* 242 */       return (get_store().find_attribute_user(FOLDER$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFolder(String paramString) {
/* 251 */     synchronized (monitor()) {
/*     */       
/* 253 */       check_orphaned();
/* 254 */       SimpleValue simpleValue = null;
/* 255 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FOLDER$4);
/* 256 */       if (simpleValue == null)
/*     */       {
/* 258 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FOLDER$4);
/*     */       }
/* 260 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFolder(XmlToken paramXmlToken) {
/* 269 */     synchronized (monitor()) {
/*     */       
/* 271 */       check_orphaned();
/* 272 */       XmlToken xmlToken = null;
/* 273 */       xmlToken = (XmlToken)get_store().find_attribute_user(FOLDER$4);
/* 274 */       if (xmlToken == null)
/*     */       {
/* 276 */         xmlToken = (XmlToken)get_store().add_attribute_user(FOLDER$4);
/*     */       }
/* 278 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFolder() {
/* 287 */     synchronized (monitor()) {
/*     */       
/* 289 */       check_orphaned();
/* 290 */       get_store().remove_attribute(FOLDER$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 299 */     synchronized (monitor()) {
/*     */       
/* 301 */       check_orphaned();
/* 302 */       SimpleValue simpleValue = null;
/* 303 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FILENAME$6);
/* 304 */       if (simpleValue == null)
/*     */       {
/* 306 */         return null;
/*     */       }
/* 308 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetFileName() {
/* 317 */     synchronized (monitor()) {
/*     */       
/* 319 */       check_orphaned();
/* 320 */       XmlToken xmlToken = null;
/* 321 */       xmlToken = (XmlToken)get_store().find_attribute_user(FILENAME$6);
/* 322 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFileName() {
/* 331 */     synchronized (monitor()) {
/*     */       
/* 333 */       check_orphaned();
/* 334 */       return (get_store().find_attribute_user(FILENAME$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileName(String paramString) {
/* 343 */     synchronized (monitor()) {
/*     */       
/* 345 */       check_orphaned();
/* 346 */       SimpleValue simpleValue = null;
/* 347 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FILENAME$6);
/* 348 */       if (simpleValue == null)
/*     */       {
/* 350 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FILENAME$6);
/*     */       }
/* 352 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFileName(XmlToken paramXmlToken) {
/* 361 */     synchronized (monitor()) {
/*     */       
/* 363 */       check_orphaned();
/* 364 */       XmlToken xmlToken = null;
/* 365 */       xmlToken = (XmlToken)get_store().find_attribute_user(FILENAME$6);
/* 366 */       if (xmlToken == null)
/*     */       {
/* 368 */         xmlToken = (XmlToken)get_store().add_attribute_user(FILENAME$6);
/*     */       }
/* 370 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFileName() {
/* 379 */     synchronized (monitor()) {
/*     */       
/* 381 */       check_orphaned();
/* 382 */       get_store().remove_attribute(FILENAME$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileDesc.Role.Enum getRole() {
/* 391 */     synchronized (monitor()) {
/*     */       
/* 393 */       check_orphaned();
/* 394 */       SimpleValue simpleValue = null;
/* 395 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ROLE$8);
/* 396 */       if (simpleValue == null)
/*     */       {
/* 398 */         return null;
/*     */       }
/* 400 */       return (FileDesc.Role.Enum)simpleValue.getEnumValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileDesc.Role xgetRole() {
/* 409 */     synchronized (monitor()) {
/*     */       
/* 411 */       check_orphaned();
/* 412 */       FileDesc.Role role = null;
/* 413 */       role = (FileDesc.Role)get_store().find_attribute_user(ROLE$8);
/* 414 */       return role;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetRole() {
/* 423 */     synchronized (monitor()) {
/*     */       
/* 425 */       check_orphaned();
/* 426 */       return (get_store().find_attribute_user(ROLE$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRole(FileDesc.Role.Enum paramEnum) {
/* 435 */     synchronized (monitor()) {
/*     */       
/* 437 */       check_orphaned();
/* 438 */       SimpleValue simpleValue = null;
/* 439 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ROLE$8);
/* 440 */       if (simpleValue == null)
/*     */       {
/* 442 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ROLE$8);
/*     */       }
/* 444 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetRole(FileDesc.Role paramRole) {
/* 453 */     synchronized (monitor()) {
/*     */       
/* 455 */       check_orphaned();
/* 456 */       FileDesc.Role role = null;
/* 457 */       role = (FileDesc.Role)get_store().find_attribute_user(ROLE$8);
/* 458 */       if (role == null)
/*     */       {
/* 460 */         role = (FileDesc.Role)get_store().add_attribute_user(ROLE$8);
/*     */       }
/* 462 */       role.set((XmlObject)paramRole);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetRole() {
/* 471 */     synchronized (monitor()) {
/*     */       
/* 473 */       check_orphaned();
/* 474 */       get_store().remove_attribute(ROLE$8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getValidity() {
/* 483 */     synchronized (monitor()) {
/*     */       
/* 485 */       check_orphaned();
/* 486 */       SimpleValue simpleValue = null;
/* 487 */       simpleValue = (SimpleValue)get_store().find_attribute_user(VALIDITY$10);
/* 488 */       if (simpleValue == null)
/*     */       {
/* 490 */         return false;
/*     */       }
/* 492 */       return simpleValue.getBooleanValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlBoolean xgetValidity() {
/* 501 */     synchronized (monitor()) {
/*     */       
/* 503 */       check_orphaned();
/* 504 */       XmlBoolean xmlBoolean = null;
/* 505 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VALIDITY$10);
/* 506 */       return xmlBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetValidity() {
/* 515 */     synchronized (monitor()) {
/*     */       
/* 517 */       check_orphaned();
/* 518 */       return (get_store().find_attribute_user(VALIDITY$10) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidity(boolean paramBoolean) {
/* 527 */     synchronized (monitor()) {
/*     */       
/* 529 */       check_orphaned();
/* 530 */       SimpleValue simpleValue = null;
/* 531 */       simpleValue = (SimpleValue)get_store().find_attribute_user(VALIDITY$10);
/* 532 */       if (simpleValue == null)
/*     */       {
/* 534 */         simpleValue = (SimpleValue)get_store().add_attribute_user(VALIDITY$10);
/*     */       }
/* 536 */       simpleValue.setBooleanValue(paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetValidity(XmlBoolean paramXmlBoolean) {
/* 545 */     synchronized (monitor()) {
/*     */       
/* 547 */       check_orphaned();
/* 548 */       XmlBoolean xmlBoolean = null;
/* 549 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(VALIDITY$10);
/* 550 */       if (xmlBoolean == null)
/*     */       {
/* 552 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(VALIDITY$10);
/*     */       }
/* 554 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetValidity() {
/* 563 */     synchronized (monitor()) {
/*     */       
/* 565 */       check_orphaned();
/* 566 */       get_store().remove_attribute(VALIDITY$10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RoleImpl
/*     */     extends JavaStringEnumerationHolderEx
/*     */     implements FileDesc.Role
/*     */   {
/*     */     public RoleImpl(SchemaType param1SchemaType) {
/* 579 */       super(param1SchemaType, false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected RoleImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 584 */       super(param1SchemaType, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\impl\FileDescImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */