/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class VoidClassImpl
/*    */   extends BuiltinClassImpl
/*    */ {
/*    */   private static final String SIMPLE_NAME = "void";
/*    */   
/*    */   public static boolean isVoid(String paramString) {
/* 36 */     return paramString.equals("void");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public VoidClassImpl(ElementContext paramElementContext) {
/* 43 */     super(paramElementContext);
/* 44 */     reallySetSimpleName("void");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isVoidType() {
/* 50 */     return true;
/*    */   } public boolean isAssignableFrom(JClass paramJClass) {
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\VoidClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */