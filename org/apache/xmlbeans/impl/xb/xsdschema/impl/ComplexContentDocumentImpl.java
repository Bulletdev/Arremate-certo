/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComplexContentDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements ComplexContentDocument
/*     */ {
/*     */   public ComplexContentDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b COMPLEXCONTENT$0 = new b("http://www.w3.org/2001/XMLSchema", "complexContent");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComplexContentDocument.ComplexContent getComplexContent() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  36 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().find_element_user(COMPLEXCONTENT$0, 0);
/*  37 */       if (complexContent == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return complexContent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComplexContent(ComplexContentDocument.ComplexContent paramComplexContent) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  54 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().find_element_user(COMPLEXCONTENT$0, 0);
/*  55 */       if (complexContent == null)
/*     */       {
/*  57 */         complexContent = (ComplexContentDocument.ComplexContent)get_store().add_element_user(COMPLEXCONTENT$0);
/*     */       }
/*  59 */       complexContent.set((XmlObject)paramComplexContent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ComplexContentDocument.ComplexContent addNewComplexContent() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  72 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().add_element_user(COMPLEXCONTENT$0);
/*  73 */       return complexContent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ComplexContentImpl
/*     */     extends AnnotatedImpl
/*     */     implements ComplexContentDocument.ComplexContent
/*     */   {
/*     */     public ComplexContentImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b RESTRICTION$0 = new b("http://www.w3.org/2001/XMLSchema", "restriction");
/*     */     
/*  91 */     private static final b EXTENSION$2 = new b("http://www.w3.org/2001/XMLSchema", "extension");
/*     */     
/*  93 */     private static final b MIXED$4 = new b("", "mixed");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ComplexRestrictionType getRestriction() {
/* 102 */       synchronized (monitor()) {
/*     */         
/* 104 */         check_orphaned();
/* 105 */         ComplexRestrictionType complexRestrictionType = null;
/* 106 */         complexRestrictionType = (ComplexRestrictionType)get_store().find_element_user(RESTRICTION$0, 0);
/* 107 */         if (complexRestrictionType == null)
/*     */         {
/* 109 */           return null;
/*     */         }
/* 111 */         return complexRestrictionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetRestriction() {
/* 120 */       synchronized (monitor()) {
/*     */         
/* 122 */         check_orphaned();
/* 123 */         return (get_store().count_elements(RESTRICTION$0) != 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setRestriction(ComplexRestrictionType param1ComplexRestrictionType) {
/* 132 */       synchronized (monitor()) {
/*     */         
/* 134 */         check_orphaned();
/* 135 */         ComplexRestrictionType complexRestrictionType = null;
/* 136 */         complexRestrictionType = (ComplexRestrictionType)get_store().find_element_user(RESTRICTION$0, 0);
/* 137 */         if (complexRestrictionType == null)
/*     */         {
/* 139 */           complexRestrictionType = (ComplexRestrictionType)get_store().add_element_user(RESTRICTION$0);
/*     */         }
/* 141 */         complexRestrictionType.set((XmlObject)param1ComplexRestrictionType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ComplexRestrictionType addNewRestriction() {
/* 150 */       synchronized (monitor()) {
/*     */         
/* 152 */         check_orphaned();
/* 153 */         ComplexRestrictionType complexRestrictionType = null;
/* 154 */         complexRestrictionType = (ComplexRestrictionType)get_store().add_element_user(RESTRICTION$0);
/* 155 */         return complexRestrictionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetRestriction() {
/* 164 */       synchronized (monitor()) {
/*     */         
/* 166 */         check_orphaned();
/* 167 */         get_store().remove_element(RESTRICTION$0, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ExtensionType getExtension() {
/* 176 */       synchronized (monitor()) {
/*     */         
/* 178 */         check_orphaned();
/* 179 */         ExtensionType extensionType = null;
/* 180 */         extensionType = (ExtensionType)get_store().find_element_user(EXTENSION$2, 0);
/* 181 */         if (extensionType == null)
/*     */         {
/* 183 */           return null;
/*     */         }
/* 185 */         return extensionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetExtension() {
/* 194 */       synchronized (monitor()) {
/*     */         
/* 196 */         check_orphaned();
/* 197 */         return (get_store().count_elements(EXTENSION$2) != 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExtension(ExtensionType param1ExtensionType) {
/* 206 */       synchronized (monitor()) {
/*     */         
/* 208 */         check_orphaned();
/* 209 */         ExtensionType extensionType = null;
/* 210 */         extensionType = (ExtensionType)get_store().find_element_user(EXTENSION$2, 0);
/* 211 */         if (extensionType == null)
/*     */         {
/* 213 */           extensionType = (ExtensionType)get_store().add_element_user(EXTENSION$2);
/*     */         }
/* 215 */         extensionType.set((XmlObject)param1ExtensionType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ExtensionType addNewExtension() {
/* 224 */       synchronized (monitor()) {
/*     */         
/* 226 */         check_orphaned();
/* 227 */         ExtensionType extensionType = null;
/* 228 */         extensionType = (ExtensionType)get_store().add_element_user(EXTENSION$2);
/* 229 */         return extensionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetExtension() {
/* 238 */       synchronized (monitor()) {
/*     */         
/* 240 */         check_orphaned();
/* 241 */         get_store().remove_element(EXTENSION$2, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean getMixed() {
/* 250 */       synchronized (monitor()) {
/*     */         
/* 252 */         check_orphaned();
/* 253 */         SimpleValue simpleValue = null;
/* 254 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MIXED$4);
/* 255 */         if (simpleValue == null)
/*     */         {
/* 257 */           return false;
/*     */         }
/* 259 */         return simpleValue.getBooleanValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlBoolean xgetMixed() {
/* 268 */       synchronized (monitor()) {
/*     */         
/* 270 */         check_orphaned();
/* 271 */         XmlBoolean xmlBoolean = null;
/* 272 */         xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MIXED$4);
/* 273 */         return xmlBoolean;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetMixed() {
/* 282 */       synchronized (monitor()) {
/*     */         
/* 284 */         check_orphaned();
/* 285 */         return (get_store().find_attribute_user(MIXED$4) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMixed(boolean param1Boolean) {
/* 294 */       synchronized (monitor()) {
/*     */         
/* 296 */         check_orphaned();
/* 297 */         SimpleValue simpleValue = null;
/* 298 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MIXED$4);
/* 299 */         if (simpleValue == null)
/*     */         {
/* 301 */           simpleValue = (SimpleValue)get_store().add_attribute_user(MIXED$4);
/*     */         }
/* 303 */         simpleValue.setBooleanValue(param1Boolean);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetMixed(XmlBoolean param1XmlBoolean) {
/* 312 */       synchronized (monitor()) {
/*     */         
/* 314 */         check_orphaned();
/* 315 */         XmlBoolean xmlBoolean = null;
/* 316 */         xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MIXED$4);
/* 317 */         if (xmlBoolean == null)
/*     */         {
/* 319 */           xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MIXED$4);
/*     */         }
/* 321 */         xmlBoolean.set((XmlObject)param1XmlBoolean);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetMixed() {
/* 330 */       synchronized (monitor()) {
/*     */         
/* 332 */         check_orphaned();
/* 333 */         get_store().remove_attribute(MIXED$4);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ComplexContentDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */