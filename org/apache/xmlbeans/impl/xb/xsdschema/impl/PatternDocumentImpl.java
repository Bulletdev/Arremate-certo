/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PatternDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements PatternDocument
/*    */ {
/*    */   public PatternDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b PATTERN$0 = new b("http://www.w3.org/2001/XMLSchema", "pattern");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PatternDocument.Pattern getPattern() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       PatternDocument.Pattern pattern = null;
/* 36 */       pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$0, 0);
/* 37 */       if (pattern == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return pattern;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPattern(PatternDocument.Pattern paramPattern) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       PatternDocument.Pattern pattern = null;
/* 54 */       pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$0, 0);
/* 55 */       if (pattern == null)
/*    */       {
/* 57 */         pattern = (PatternDocument.Pattern)get_store().add_element_user(PATTERN$0);
/*    */       }
/* 59 */       pattern.set((XmlObject)paramPattern);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public PatternDocument.Pattern addNewPattern() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       PatternDocument.Pattern pattern = null;
/* 72 */       pattern = (PatternDocument.Pattern)get_store().add_element_user(PATTERN$0);
/* 73 */       return pattern;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class PatternImpl
/*    */     extends NoFixedFacetImpl
/*    */     implements PatternDocument.Pattern
/*    */   {
/*    */     public PatternImpl(SchemaType param1SchemaType) {
/* 86 */       super(param1SchemaType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\PatternDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */