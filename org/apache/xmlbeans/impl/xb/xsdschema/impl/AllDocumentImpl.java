/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AllDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements AllDocument
/*    */ {
/*    */   public AllDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ALL$0 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public All getAll() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       All all = null;
/* 36 */       all = (All)get_store().find_element_user(ALL$0, 0);
/* 37 */       if (all == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return all;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAll(All paramAll) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       All all = null;
/* 54 */       all = (All)get_store().find_element_user(ALL$0, 0);
/* 55 */       if (all == null)
/*    */       {
/* 57 */         all = (All)get_store().add_element_user(ALL$0);
/*    */       }
/* 59 */       all.set((XmlObject)paramAll);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public All addNewAll() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       All all = null;
/* 72 */       all = (All)get_store().add_element_user(ALL$0);
/* 73 */       return all;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AllDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */