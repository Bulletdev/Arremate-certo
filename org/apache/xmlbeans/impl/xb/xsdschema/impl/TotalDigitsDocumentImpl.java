/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TotalDigitsDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements TotalDigitsDocument
/*    */ {
/*    */   public TotalDigitsDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b TOTALDIGITS$0 = new b("http://www.w3.org/2001/XMLSchema", "totalDigits");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TotalDigitsDocument.TotalDigits getTotalDigits() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/* 36 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$0, 0);
/* 37 */       if (totalDigits == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return totalDigits;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTotalDigits(TotalDigitsDocument.TotalDigits paramTotalDigits) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/* 54 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$0, 0);
/* 55 */       if (totalDigits == null)
/*    */       {
/* 57 */         totalDigits = (TotalDigitsDocument.TotalDigits)get_store().add_element_user(TOTALDIGITS$0);
/*    */       }
/* 59 */       totalDigits.set((XmlObject)paramTotalDigits);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/* 72 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().add_element_user(TOTALDIGITS$0);
/* 73 */       return totalDigits;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class TotalDigitsImpl
/*    */     extends NumFacetImpl
/*    */     implements TotalDigitsDocument.TotalDigits
/*    */   {
/*    */     public TotalDigitsImpl(SchemaType param1SchemaType) {
/* 86 */       super(param1SchemaType);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\TotalDigitsDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */