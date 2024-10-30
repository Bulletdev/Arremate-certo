/*    */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*    */ 
/*    */ import java.lang.reflect.Modifier;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JElement;
/*    */ import org.apache.xmlbeans.impl.jam.JMember;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MMember;
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
/*    */ public abstract class MemberImpl
/*    */   extends AnnotatedElementImpl
/*    */   implements MMember
/*    */ {
/* 35 */   private int mModifiers = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected MemberImpl(ElementImpl paramElementImpl) {
/* 41 */     super(paramElementImpl);
/*    */   }
/*    */   
/*    */   protected MemberImpl(ElementContext paramElementContext) {
/* 45 */     super(paramElementContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JClass getContainingClass() {
/* 52 */     JElement jElement = getParent();
/*    */     
/* 54 */     if (jElement instanceof JClass) return (JClass)jElement; 
/* 55 */     if (jElement instanceof JMember) return ((JMember)jElement).getContainingClass(); 
/* 56 */     return null;
/*    */   }
/*    */   public int getModifiers() {
/* 59 */     return this.mModifiers;
/*    */   }
/*    */   public boolean isPackagePrivate() {
/* 62 */     return (!isPrivate() && !isPublic() && !isProtected());
/*    */   }
/*    */   public boolean isPrivate() {
/* 65 */     return Modifier.isPrivate(getModifiers());
/*    */   } public boolean isProtected() {
/* 67 */     return Modifier.isProtected(getModifiers());
/*    */   } public boolean isPublic() {
/* 69 */     return Modifier.isPublic(getModifiers());
/*    */   }
/*    */ 
/*    */   
/*    */   public void setModifiers(int paramInt) {
/* 74 */     this.mModifiers = paramInt;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\MemberImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */