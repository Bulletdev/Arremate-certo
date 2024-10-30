/*    */ package org.apache.poi.ss.formula;
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
/*    */ public class NameIdentifier
/*    */ {
/*    */   private final String _name;
/*    */   private final boolean _isQuoted;
/*    */   
/*    */   public NameIdentifier(String paramString, boolean paramBoolean) {
/* 25 */     this._name = paramString;
/* 26 */     this._isQuoted = paramBoolean;
/*    */   }
/*    */   public String getName() {
/* 29 */     return this._name;
/*    */   }
/*    */   public boolean isQuoted() {
/* 32 */     return this._isQuoted;
/*    */   }
/*    */   public String toString() {
/* 35 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 36 */     stringBuffer.append(getClass().getName());
/* 37 */     stringBuffer.append(" [");
/* 38 */     if (this._isQuoted) {
/* 39 */       stringBuffer.append("'").append(this._name).append("'");
/*    */     } else {
/* 41 */       stringBuffer.append(this._name);
/*    */     } 
/* 43 */     stringBuffer.append("]");
/* 44 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\NameIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */