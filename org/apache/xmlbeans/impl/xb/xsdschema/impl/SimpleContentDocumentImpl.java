/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleContentDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements SimpleContentDocument
/*     */ {
/*     */   public SimpleContentDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b SIMPLECONTENT$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleContent");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleContentDocument.SimpleContent getSimpleContent() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*  36 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().find_element_user(SIMPLECONTENT$0, 0);
/*  37 */       if (simpleContent == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return simpleContent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSimpleContent(SimpleContentDocument.SimpleContent paramSimpleContent) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*  54 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().find_element_user(SIMPLECONTENT$0, 0);
/*  55 */       if (simpleContent == null)
/*     */       {
/*  57 */         simpleContent = (SimpleContentDocument.SimpleContent)get_store().add_element_user(SIMPLECONTENT$0);
/*     */       }
/*  59 */       simpleContent.set((XmlObject)paramSimpleContent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleContentDocument.SimpleContent addNewSimpleContent() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*  72 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().add_element_user(SIMPLECONTENT$0);
/*  73 */       return simpleContent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SimpleContentImpl
/*     */     extends AnnotatedImpl
/*     */     implements SimpleContentDocument.SimpleContent
/*     */   {
/*     */     public SimpleContentImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b RESTRICTION$0 = new b("http://www.w3.org/2001/XMLSchema", "restriction");
/*     */     
/*  91 */     private static final b EXTENSION$2 = new b("http://www.w3.org/2001/XMLSchema", "extension");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleRestrictionType getRestriction() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         SimpleRestrictionType simpleRestrictionType = null;
/* 104 */         simpleRestrictionType = (SimpleRestrictionType)get_store().find_element_user(RESTRICTION$0, 0);
/* 105 */         if (simpleRestrictionType == null)
/*     */         {
/* 107 */           return null;
/*     */         }
/* 109 */         return simpleRestrictionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetRestriction() {
/* 118 */       synchronized (monitor()) {
/*     */         
/* 120 */         check_orphaned();
/* 121 */         return (get_store().count_elements(RESTRICTION$0) != 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setRestriction(SimpleRestrictionType param1SimpleRestrictionType) {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         SimpleRestrictionType simpleRestrictionType = null;
/* 134 */         simpleRestrictionType = (SimpleRestrictionType)get_store().find_element_user(RESTRICTION$0, 0);
/* 135 */         if (simpleRestrictionType == null)
/*     */         {
/* 137 */           simpleRestrictionType = (SimpleRestrictionType)get_store().add_element_user(RESTRICTION$0);
/*     */         }
/* 139 */         simpleRestrictionType.set((XmlObject)param1SimpleRestrictionType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleRestrictionType addNewRestriction() {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         SimpleRestrictionType simpleRestrictionType = null;
/* 152 */         simpleRestrictionType = (SimpleRestrictionType)get_store().add_element_user(RESTRICTION$0);
/* 153 */         return simpleRestrictionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetRestriction() {
/* 162 */       synchronized (monitor()) {
/*     */         
/* 164 */         check_orphaned();
/* 165 */         get_store().remove_element(RESTRICTION$0, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleExtensionType getExtension() {
/* 174 */       synchronized (monitor()) {
/*     */         
/* 176 */         check_orphaned();
/* 177 */         SimpleExtensionType simpleExtensionType = null;
/* 178 */         simpleExtensionType = (SimpleExtensionType)get_store().find_element_user(EXTENSION$2, 0);
/* 179 */         if (simpleExtensionType == null)
/*     */         {
/* 181 */           return null;
/*     */         }
/* 183 */         return simpleExtensionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetExtension() {
/* 192 */       synchronized (monitor()) {
/*     */         
/* 194 */         check_orphaned();
/* 195 */         return (get_store().count_elements(EXTENSION$2) != 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setExtension(SimpleExtensionType param1SimpleExtensionType) {
/* 204 */       synchronized (monitor()) {
/*     */         
/* 206 */         check_orphaned();
/* 207 */         SimpleExtensionType simpleExtensionType = null;
/* 208 */         simpleExtensionType = (SimpleExtensionType)get_store().find_element_user(EXTENSION$2, 0);
/* 209 */         if (simpleExtensionType == null)
/*     */         {
/* 211 */           simpleExtensionType = (SimpleExtensionType)get_store().add_element_user(EXTENSION$2);
/*     */         }
/* 213 */         simpleExtensionType.set((XmlObject)param1SimpleExtensionType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleExtensionType addNewExtension() {
/* 222 */       synchronized (monitor()) {
/*     */         
/* 224 */         check_orphaned();
/* 225 */         SimpleExtensionType simpleExtensionType = null;
/* 226 */         simpleExtensionType = (SimpleExtensionType)get_store().add_element_user(EXTENSION$2);
/* 227 */         return simpleExtensionType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetExtension() {
/* 236 */       synchronized (monitor()) {
/*     */         
/* 238 */         check_orphaned();
/* 239 */         get_store().remove_element(EXTENSION$2, 0);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SimpleContentDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */