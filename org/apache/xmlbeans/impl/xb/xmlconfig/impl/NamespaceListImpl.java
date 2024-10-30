/*    */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlAnyURI;
/*    */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*    */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*    */ import org.apache.xmlbeans.impl.values.XmlUnionImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NamespaceListImpl
/*    */   extends XmlUnionImpl
/*    */   implements NamespaceList, NamespaceList.Member, NamespaceList.Member2
/*    */ {
/*    */   public NamespaceListImpl(SchemaType paramSchemaType) {
/* 21 */     super(paramSchemaType, false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected NamespaceListImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 26 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class MemberImpl
/*    */     extends JavaStringEnumerationHolderEx
/*    */     implements NamespaceList.Member
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
/*    */     implements NamespaceList.Member2
/*    */   {
/*    */     public MemberImpl2(SchemaType param1SchemaType) {
/* 56 */       super(param1SchemaType, false);
/*    */     }
/*    */ 
/*    */     
/*    */     protected MemberImpl2(SchemaType param1SchemaType, boolean param1Boolean) {
/* 61 */       super(param1SchemaType, param1Boolean);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static class ItemImpl
/*    */       extends XmlUnionImpl
/*    */       implements XmlAnyURI, NamespaceList.Member2.Item, NamespaceList.Member2.Item.Member
/*    */     {
/*    */       public ItemImpl(SchemaType param2SchemaType) {
/* 75 */         super(param2SchemaType, false);
/*    */       }
/*    */ 
/*    */       
/*    */       protected ItemImpl(SchemaType param2SchemaType, boolean param2Boolean) {
/* 80 */         super(param2SchemaType, param2Boolean);
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public static class MemberImpl
/*    */         extends JavaStringEnumerationHolderEx
/*    */         implements NamespaceList.Member2.Item.Member
/*    */       {
/*    */         public MemberImpl(SchemaType param3SchemaType) {
/* 92 */           super(param3SchemaType, false);
/*    */         }
/*    */ 
/*    */         
/*    */         protected MemberImpl(SchemaType param3SchemaType, boolean param3Boolean) {
/* 97 */           super(param3SchemaType, param3Boolean);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\NamespaceListImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */