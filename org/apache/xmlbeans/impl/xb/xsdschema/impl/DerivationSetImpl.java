/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DerivationSetImpl
/*    */   extends XmlUnionImpl
/*    */   implements DerivationSet, DerivationSet.Member, DerivationSet.Member2
/*    */ {
/*    */   public DerivationSetImpl(SchemaType paramSchemaType) {
/* 21 */     super(paramSchemaType, false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected DerivationSetImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 26 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl
/*    */     extends JavaStringEnumerationHolderEx
/*    */     implements DerivationSet.Member
/*    */   {
/*    */     public MemberImpl(SchemaType param1SchemaType) {
/* 38 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MemberImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 43 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl2
/*    */     extends XmlListImpl
/*    */     implements DerivationSet.Member2
/*    */   {
/*    */     public MemberImpl2(SchemaType param1SchemaType) {
/* 56 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MemberImpl2(SchemaType param1SchemaType, boolean param1Boolean) {
/* 61 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\DerivationSetImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */