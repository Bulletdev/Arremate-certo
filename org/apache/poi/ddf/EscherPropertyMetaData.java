/*    */ package org.apache.poi.ddf;
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
/*    */ public class EscherPropertyMetaData
/*    */ {
/*    */   public static final byte TYPE_UNKNOWN = 0;
/*    */   public static final byte TYPE_BOOLEAN = 1;
/*    */   public static final byte TYPE_RGB = 2;
/*    */   public static final byte TYPE_SHAPEPATH = 3;
/*    */   public static final byte TYPE_SIMPLE = 4;
/*    */   public static final byte TYPE_ARRAY = 5;
/*    */   private String description;
/*    */   private byte type;
/*    */   
/*    */   public EscherPropertyMetaData(String paramString) {
/* 45 */     this.description = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EscherPropertyMetaData(String paramString, byte paramByte) {
/* 55 */     this.description = paramString;
/* 56 */     this.type = paramByte;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 61 */     return this.description;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getType() {
/* 66 */     return this.type;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherPropertyMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */