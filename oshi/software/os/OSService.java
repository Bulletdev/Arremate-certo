/*    */ package oshi.software.os;
/*    */ 
/*    */ import oshi.annotation.concurrent.Immutable;
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
/*    */ @Immutable
/*    */ public class OSService
/*    */ {
/*    */   private final String name;
/*    */   private final int processID;
/*    */   private final State state;
/*    */   
/*    */   public enum State
/*    */   {
/* 47 */     RUNNING, STOPPED, OTHER;
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
/*    */   
/*    */   public OSService(String paramString, int paramInt, State paramState) {
/* 61 */     this.name = paramString;
/* 62 */     this.processID = paramInt;
/* 63 */     this.state = paramState;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 74 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getProcessID() {
/* 85 */     return this.processID;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public State getState() {
/* 96 */     return this.state;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\OSService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */