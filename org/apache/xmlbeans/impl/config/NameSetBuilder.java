/*    */ package org.apache.xmlbeans.impl.config;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
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
/*    */ public class NameSetBuilder
/*    */ {
/*    */   private boolean _isFinite = true;
/* 38 */   private Set _finiteSet = new HashSet();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void invert() {
/* 46 */     this._isFinite = !this._isFinite;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(String paramString) {
/* 55 */     if (this._isFinite) {
/* 56 */       this._finiteSet.add(paramString);
/*    */     } else {
/* 58 */       this._finiteSet.remove(paramString);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NameSet toNameSet() {
/* 67 */     if (this._finiteSet.size() == 0) {
/* 68 */       if (this._isFinite) {
/* 69 */         return NameSet.EMPTY;
/*    */       }
/* 71 */       return NameSet.EVERYTHING;
/*    */     } 
/* 73 */     return NameSet.newInstance(this._isFinite, this._finiteSet);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\NameSetBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */