/*    */ package org.apache.commons.lang3.builder;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.apache.commons.lang3.ClassUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecursiveToStringStyle
/*    */   extends ToStringStyle
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void appendDetail(StringBuffer paramStringBuffer, String paramString, Object paramObject) {
/* 71 */     if (!ClassUtils.isPrimitiveWrapper(paramObject.getClass()) && 
/* 72 */       !String.class.equals(paramObject.getClass()) && 
/* 73 */       accept(paramObject.getClass())) {
/* 74 */       paramStringBuffer.append(ReflectionToStringBuilder.toString(paramObject, this));
/*    */     } else {
/* 76 */       super.appendDetail(paramStringBuffer, paramString, paramObject);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void appendDetail(StringBuffer paramStringBuffer, String paramString, Collection<?> paramCollection) {
/* 82 */     appendClassName(paramStringBuffer, paramCollection);
/* 83 */     appendIdentityHashCode(paramStringBuffer, paramCollection);
/* 84 */     appendDetail(paramStringBuffer, paramString, paramCollection.toArray());
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
/*    */   
/*    */   protected boolean accept(Class<?> paramClass) {
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\builder\RecursiveToStringStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */