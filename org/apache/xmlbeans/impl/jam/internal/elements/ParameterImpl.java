/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JParameter;
/*    */ import org.apache.xmlbeans.impl.jam.internal.classrefs.DirectJClassRef;
/*    */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*    */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*    */ import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
/*    */ import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
/*    */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
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
/*    */ 
/*    */ public class ParameterImpl
/*    */   extends MemberImpl
/*    */   implements MParameter
/*    */ {
/*    */   private JClassRef mTypeClassRef;
/*    */   
/*    */   ParameterImpl(String paramString1, InvokableImpl paramInvokableImpl, String paramString2) {
/* 46 */     super(paramInvokableImpl);
/* 47 */     setSimpleName(paramString1);
/* 48 */     setType(paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQualifiedName() {
/* 55 */     return getSimpleName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setType(String paramString) {
/* 62 */     if (paramString == null) throw new IllegalArgumentException("null typename"); 
/* 63 */     this.mTypeClassRef = QualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*    */   }
/*    */ 
/*    */   
/*    */   public void setType(JClass paramJClass) {
/* 68 */     if (paramJClass == null) throw new IllegalArgumentException("null qcname"); 
/* 69 */     this.mTypeClassRef = DirectJClassRef.create(paramJClass);
/*    */   }
/*    */   
/*    */   public void setUnqualifiedType(String paramString) {
/* 73 */     if (paramString == null) throw new IllegalArgumentException("null ucname"); 
/* 74 */     this.mTypeClassRef = UnqualifiedJClassRef.create(paramString, (ClassImpl)getContainingClass());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JClass getType() {
/* 82 */     return this.mTypeClassRef.getRefClass();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void accept(MVisitor paramMVisitor) {
/* 88 */     paramMVisitor.visit(this);
/*    */   } public void accept(JVisitor paramJVisitor) {
/* 90 */     paramJVisitor.visit((JParameter)this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ParameterImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */