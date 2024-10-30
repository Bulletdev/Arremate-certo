/*     */ package org.apache.commons.net.imap;
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
/*     */ public enum IMAPCommand
/*     */ {
/*  30 */   CAPABILITY(0),
/*  31 */   NOOP(0),
/*  32 */   LOGOUT(0),
/*     */ 
/*     */   
/*  35 */   STARTTLS(0),
/*  36 */   AUTHENTICATE(1),
/*  37 */   LOGIN(2),
/*     */   
/*  39 */   XOAUTH(1),
/*     */ 
/*     */   
/*  42 */   SELECT(1),
/*  43 */   EXAMINE(1),
/*  44 */   CREATE(1),
/*  45 */   DELETE(1),
/*  46 */   RENAME(2),
/*  47 */   SUBSCRIBE(1),
/*  48 */   UNSUBSCRIBE(1),
/*  49 */   LIST(2),
/*  50 */   LSUB(2),
/*  51 */   STATUS(2),
/*  52 */   APPEND(2, 4),
/*     */ 
/*     */   
/*  55 */   CHECK(0),
/*  56 */   CLOSE(0),
/*  57 */   EXPUNGE(0),
/*  58 */   SEARCH(1, 2147483647),
/*  59 */   FETCH(2),
/*  60 */   STORE(3),
/*  61 */   COPY(2),
/*  62 */   UID(2, 2147483647);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String imapCommand;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int minParamCount;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxParamCount;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   IMAPCommand(String paramString1, int paramInt1, int paramInt2) {
/*  93 */     this.imapCommand = paramString1;
/*  94 */     this.minParamCount = paramInt1;
/*  95 */     this.maxParamCount = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String getCommand(IMAPCommand paramIMAPCommand) {
/* 105 */     return paramIMAPCommand.getIMAPCommand();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIMAPCommand() {
/* 114 */     return (this.imapCommand != null) ? this.imapCommand : name();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\IMAPCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */