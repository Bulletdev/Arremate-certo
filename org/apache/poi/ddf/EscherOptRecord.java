/*    */ package org.apache.poi.ddf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
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
/*    */ public class EscherOptRecord
/*    */   extends AbstractEscherOptRecord
/*    */ {
/*    */   public static final String RECORD_DESCRIPTION = "msofbtOPT";
/*    */   public static final short RECORD_ID = -4085;
/*    */   
/*    */   public short getInstance() {
/* 35 */     setInstance((short)this.properties.size());
/* 36 */     return super.getInstance();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Internal
/*    */   public short getOptions() {
/* 47 */     getInstance();
/* 48 */     getVersion();
/* 49 */     return super.getOptions();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRecordName() {
/* 55 */     return "Opt";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getVersion() {
/* 61 */     setVersion((short)3);
/* 62 */     return super.getVersion();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVersion(short paramShort) {
/* 68 */     if (paramShort != 3) {
/* 69 */       throw new IllegalArgumentException("msofbtOPT can have only '0x3' version");
/*    */     }
/*    */     
/* 72 */     super.setVersion(paramShort);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherOptRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */