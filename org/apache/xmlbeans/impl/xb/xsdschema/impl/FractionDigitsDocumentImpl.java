/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.FractionDigitsDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FractionDigitsDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements FractionDigitsDocument
/*    */ {
/*    */   public FractionDigitsDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b FRACTIONDIGITS$0 = new b("http://www.w3.org/2001/XMLSchema", "fractionDigits");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet getFractionDigits() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NumFacet numFacet = null;
/* 36 */       numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$0, 0);
/* 37 */       if (numFacet == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setFractionDigits(NumFacet paramNumFacet) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NumFacet numFacet = null;
/* 54 */       numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$0, 0);
/* 55 */       if (numFacet == null)
/*    */       {
/* 57 */         numFacet = (NumFacet)get_store().add_element_user(FRACTIONDIGITS$0);
/*    */       }
/* 59 */       numFacet.set((XmlObject)paramNumFacet);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet addNewFractionDigits() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NumFacet numFacet = null;
/* 72 */       numFacet = (NumFacet)get_store().add_element_user(FRACTIONDIGITS$0);
/* 73 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\FractionDigitsDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */