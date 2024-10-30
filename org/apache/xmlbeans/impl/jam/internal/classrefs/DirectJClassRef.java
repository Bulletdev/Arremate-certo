/*    */ package org.apache.xmlbeans.impl.jam.internal.classrefs;
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
/*    */ public class DirectJClassRef
/*    */   implements JClassRef
/*    */ {
/*    */   private JClass mClass;
/*    */   
/*    */   public static JClassRef create(JClass paramJClass) {
/* 31 */     if (paramJClass instanceof JClassRef) return (JClassRef)paramJClass; 
/* 32 */     return new DirectJClassRef(paramJClass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private DirectJClassRef(JClass paramJClass) {
/* 44 */     if (paramJClass == null) throw new IllegalArgumentException("null clazz"); 
/* 45 */     this.mClass = paramJClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JClass getRefClass() {
/* 52 */     return this.mClass;
/*    */   }
/*    */   
/*    */   public String getQualifiedName() {
/* 56 */     return this.mClass.getQualifiedName();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\classrefs\DirectJClassRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */