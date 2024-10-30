/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JPackage;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MPackage;
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
/*    */ public class PackageImpl
/*    */   extends AnnotatedElementImpl
/*    */   implements MPackage
/*    */ {
/* 40 */   private List mRootClasses = new ArrayList();
/*    */ 
/*    */   
/*    */   private String mName;
/*    */ 
/*    */   
/*    */   public PackageImpl(ElementContext paramElementContext, String paramString) {
/* 47 */     super(paramElementContext);
/* 48 */     this.mName = paramString;
/* 49 */     int i = this.mName.lastIndexOf('.');
/* 50 */     setSimpleName((i == -1) ? this.mName : this.mName.substring(i + 1));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getQualifiedName() {
/* 56 */     return this.mName;
/*    */   } public void accept(MVisitor paramMVisitor) {
/* 58 */     paramMVisitor.visit(this);
/*    */   } public void accept(JVisitor paramJVisitor) {
/* 60 */     paramJVisitor.visit((JPackage)this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public JClass[] getClasses() {
/* 66 */     JClass[] arrayOfJClass = new JClass[this.mRootClasses.size()];
/* 67 */     this.mRootClasses.toArray((Object[])arrayOfJClass);
/* 68 */     return arrayOfJClass;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MClass[] getMutableClasses() {
/* 75 */     MClass[] arrayOfMClass = new MClass[this.mRootClasses.size()];
/* 76 */     this.mRootClasses.toArray((Object[])arrayOfMClass);
/* 77 */     return arrayOfMClass;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\PackageImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */