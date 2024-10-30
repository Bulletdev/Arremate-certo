/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.util.EventObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProtocolCommandEvent
/*     */   extends EventObject
/*     */ {
/*     */   private static final long serialVersionUID = 403743538418947240L;
/*     */   private final int replyCode;
/*     */   private final boolean isCommand;
/*     */   private final String message;
/*     */   private final String command;
/*     */   
/*     */   public ProtocolCommandEvent(Object paramObject, String paramString1, String paramString2) {
/*  57 */     super(paramObject);
/*  58 */     this.replyCode = 0;
/*  59 */     this.message = paramString2;
/*  60 */     this.isCommand = true;
/*  61 */     this.command = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProtocolCommandEvent(Object paramObject, int paramInt, String paramString) {
/*  81 */     super(paramObject);
/*  82 */     this.replyCode = paramInt;
/*  83 */     this.message = paramString;
/*  84 */     this.isCommand = false;
/*  85 */     this.command = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommand() {
/*  98 */     return this.command;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReplyCode() {
/* 111 */     return this.replyCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCommand() {
/* 123 */     return this.isCommand;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReply() {
/* 135 */     return !isCommand();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 146 */     return this.message;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ProtocolCommandEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */