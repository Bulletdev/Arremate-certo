/*    */ package org.h2.engine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.command.CommandInterface;
/*    */ import org.h2.result.ResultInterface;
/*    */ import org.h2.util.New;
/*    */ import org.h2.value.Value;
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
/*    */ abstract class SessionWithState
/*    */   implements SessionInterface
/*    */ {
/*    */   protected ArrayList<String> sessionState;
/*    */   protected boolean sessionStateChanged;
/*    */   private boolean sessionStateUpdating;
/*    */   
/*    */   protected void recreateSessionState() {
/* 27 */     if (this.sessionState != null && this.sessionState.size() > 0) {
/* 28 */       this.sessionStateUpdating = true;
/*    */       try {
/* 30 */         for (String str : this.sessionState) {
/* 31 */           CommandInterface commandInterface = prepareCommand(str, 2147483647);
/* 32 */           commandInterface.executeUpdate();
/*    */         } 
/*    */       } finally {
/* 35 */         this.sessionStateUpdating = false;
/* 36 */         this.sessionStateChanged = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void readSessionState() {
/* 45 */     if (!this.sessionStateChanged || this.sessionStateUpdating) {
/*    */       return;
/*    */     }
/* 48 */     this.sessionStateChanged = false;
/* 49 */     this.sessionState = New.arrayList();
/* 50 */     CommandInterface commandInterface = prepareCommand("SELECT * FROM INFORMATION_SCHEMA.SESSION_STATE", 2147483647);
/*    */ 
/*    */     
/* 53 */     ResultInterface resultInterface = commandInterface.executeQuery(0, false);
/* 54 */     while (resultInterface.next()) {
/* 55 */       Value[] arrayOfValue = resultInterface.currentRow();
/* 56 */       this.sessionState.add(arrayOfValue[1].getString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SessionWithState.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */