/*    */ package org.apache.xmlbeans.impl.schema;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaStringEnumEntry;
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
/*    */ public class SchemaStringEnumEntryImpl
/*    */   implements SchemaStringEnumEntry
/*    */ {
/*    */   private String _string;
/*    */   private int _int;
/*    */   private String _enumName;
/*    */   
/*    */   public SchemaStringEnumEntryImpl(String paramString1, int paramInt, String paramString2) {
/* 28 */     this._string = paramString1;
/* 29 */     this._int = paramInt;
/* 30 */     this._enumName = paramString2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getString() {
/* 35 */     return this._string;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIntValue() {
/* 40 */     return this._int;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getEnumName() {
/* 45 */     return this._enumName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaStringEnumEntryImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */