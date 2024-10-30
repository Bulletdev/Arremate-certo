/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FullDerivationSetImpl
/*    */   extends XmlUnionImpl
/*    */   implements FullDerivationSet, FullDerivationSet.Member, FullDerivationSet.Member2
/*    */ {
/*    */   public FullDerivationSetImpl(SchemaType paramSchemaType) {
/* 21 */     super(paramSchemaType, false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected FullDerivationSetImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 26 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl
/*    */     extends JavaStringEnumerationHolderEx
/*    */     implements FullDerivationSet.Member
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
/*    */     implements FullDerivationSet.Member2
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\FullDerivationSetImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */