/*     */ package org.apache.commons.net.imap;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public class IMAPClient
/*     */   extends IMAP
/*     */ {
/*     */   private static final char DQUOTE = '"';
/*     */   private static final String DQUOTE_S = "\"";
/*     */   
/*     */   public boolean capability() throws IOException {
/*  41 */     return doCommand(IMAPCommand.CAPABILITY);
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
/*     */   public boolean noop() throws IOException {
/*  53 */     return doCommand(IMAPCommand.NOOP);
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
/*     */   public boolean logout() throws IOException {
/*  67 */     return doCommand(IMAPCommand.LOGOUT);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean login(String paramString1, String paramString2) throws IOException {
/*  90 */     if (getState() != IMAP.IMAPState.NOT_AUTH_STATE)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!doCommand(IMAPCommand.LOGIN, paramString1 + " " + paramString2))
/*     */     {
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     setState(IMAP.IMAPState.AUTH_STATE);
/*     */     
/* 102 */     return true;
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
/*     */   public boolean select(String paramString) throws IOException {
/* 115 */     return doCommand(IMAPCommand.SELECT, quoteMailboxName(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean examine(String paramString) throws IOException {
/* 126 */     return doCommand(IMAPCommand.EXAMINE, quoteMailboxName(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean create(String paramString) throws IOException {
/* 137 */     return doCommand(IMAPCommand.CREATE, quoteMailboxName(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean delete(String paramString) throws IOException {
/* 148 */     return doCommand(IMAPCommand.DELETE, quoteMailboxName(paramString));
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
/*     */   public boolean rename(String paramString1, String paramString2) throws IOException {
/* 160 */     return doCommand(IMAPCommand.RENAME, quoteMailboxName(paramString1) + " " + quoteMailboxName(paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean subscribe(String paramString) throws IOException {
/* 171 */     return doCommand(IMAPCommand.SUBSCRIBE, quoteMailboxName(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unsubscribe(String paramString) throws IOException {
/* 182 */     return doCommand(IMAPCommand.UNSUBSCRIBE, quoteMailboxName(paramString));
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
/*     */   public boolean list(String paramString1, String paramString2) throws IOException {
/* 199 */     return doCommand(IMAPCommand.LIST, quoteMailboxName(paramString1) + " " + quoteMailboxName(paramString2));
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
/*     */   public boolean lsub(String paramString1, String paramString2) throws IOException {
/* 212 */     return doCommand(IMAPCommand.LSUB, quoteMailboxName(paramString1) + " " + quoteMailboxName(paramString2));
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
/*     */   public boolean status(String paramString, String[] paramArrayOfString) throws IOException {
/* 224 */     if (paramArrayOfString == null || paramArrayOfString.length < 1) {
/* 225 */       throw new IllegalArgumentException("STATUS command requires at least one data item name");
/*     */     }
/*     */     
/* 228 */     StringBuilder stringBuilder = new StringBuilder();
/* 229 */     stringBuilder.append(quoteMailboxName(paramString));
/*     */     
/* 231 */     stringBuilder.append(" (");
/* 232 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/* 234 */       if (b > 0) {
/* 235 */         stringBuilder.append(" ");
/*     */       }
/* 237 */       stringBuilder.append(paramArrayOfString[b]);
/*     */     } 
/* 239 */     stringBuilder.append(")");
/*     */     
/* 241 */     return doCommand(IMAPCommand.STATUS, stringBuilder.toString());
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
/*     */   public boolean append(String paramString1, String paramString2, String paramString3, String paramString4) throws IOException {
/* 256 */     StringBuilder stringBuilder = new StringBuilder(quoteMailboxName(paramString1));
/* 257 */     if (paramString2 != null) {
/* 258 */       stringBuilder.append(" ").append(paramString2);
/*     */     }
/* 260 */     if (paramString3 != null) {
/* 261 */       stringBuilder.append(" ");
/* 262 */       if (paramString3.charAt(0) == '"') {
/* 263 */         stringBuilder.append(paramString3);
/*     */       } else {
/* 265 */         stringBuilder.append('"').append(paramString3).append('"');
/*     */       } 
/*     */     } 
/* 268 */     stringBuilder.append(" ");
/*     */     
/* 270 */     if (paramString4.startsWith("\"") && paramString4.endsWith("\"")) {
/* 271 */       stringBuilder.append(paramString4);
/* 272 */       return doCommand(IMAPCommand.APPEND, stringBuilder.toString());
/*     */     } 
/* 274 */     stringBuilder.append('{').append((paramString4.getBytes("ISO-8859-1")).length).append('}');
/* 275 */     int i = sendCommand(IMAPCommand.APPEND, stringBuilder.toString());
/* 276 */     return (IMAPReply.isContinuation(i) && 
/* 277 */       IMAPReply.isSuccess(sendData(paramString4)));
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
/*     */   @Deprecated
/*     */   public boolean append(String paramString1, String paramString2, String paramString3) throws IOException {
/* 293 */     String str = paramString1;
/* 294 */     if (paramString2 != null) {
/* 295 */       str = str + " " + paramString2;
/*     */     }
/* 297 */     if (paramString3 != null) {
/* 298 */       if (paramString3.charAt(0) == '{') {
/* 299 */         str = str + " " + paramString3;
/*     */       } else {
/* 301 */         str = str + " {" + paramString3 + "}";
/*     */       } 
/*     */     }
/* 304 */     return doCommand(IMAPCommand.APPEND, str);
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
/*     */   @Deprecated
/*     */   public boolean append(String paramString) throws IOException {
/* 318 */     return append(paramString, (String)null, (String)null);
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
/*     */   public boolean check() throws IOException {
/* 330 */     return doCommand(IMAPCommand.CHECK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean close() throws IOException {
/* 340 */     return doCommand(IMAPCommand.CLOSE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean expunge() throws IOException {
/* 350 */     return doCommand(IMAPCommand.EXPUNGE);
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
/*     */   public boolean search(String paramString1, String paramString2) throws IOException {
/* 362 */     String str = "";
/* 363 */     if (paramString1 != null) {
/* 364 */       str = str + "CHARSET " + paramString1;
/*     */     }
/* 366 */     str = str + paramString2;
/* 367 */     return doCommand(IMAPCommand.SEARCH, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean search(String paramString) throws IOException {
/* 378 */     return search((String)null, paramString);
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
/*     */   public boolean fetch(String paramString1, String paramString2) throws IOException {
/* 394 */     return doCommand(IMAPCommand.FETCH, paramString1 + " " + paramString2);
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
/*     */   public boolean store(String paramString1, String paramString2, String paramString3) throws IOException {
/* 408 */     return doCommand(IMAPCommand.STORE, paramString1 + " " + paramString2 + " " + paramString3);
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
/*     */   public boolean copy(String paramString1, String paramString2) throws IOException {
/* 420 */     return doCommand(IMAPCommand.COPY, paramString1 + " " + quoteMailboxName(paramString2));
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
/*     */   public boolean uid(String paramString1, String paramString2) throws IOException {
/* 432 */     return doCommand(IMAPCommand.UID, paramString1 + " " + paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum STATUS_DATA_ITEMS
/*     */   {
/* 441 */     MESSAGES,
/*     */     
/* 443 */     RECENT,
/*     */     
/* 445 */     UIDNEXT,
/*     */     
/* 447 */     UIDVALIDITY,
/*     */     
/* 449 */     UNSEEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum SEARCH_CRITERIA
/*     */   {
/* 458 */     ALL,
/*     */     
/* 460 */     ANSWERED,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 465 */     BCC,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 470 */     BEFORE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 475 */     BODY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 480 */     CC,
/*     */     
/* 482 */     DELETED,
/*     */     
/* 484 */     DRAFT,
/*     */     
/* 486 */     FLAGGED,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 491 */     FROM,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 500 */     HEADER,
/*     */     
/* 502 */     KEYWORD,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 507 */     LARGER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 512 */     NEW,
/*     */     
/* 514 */     NOT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 520 */     OLD,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 525 */     ON,
/*     */     
/* 527 */     OR,
/*     */     
/* 529 */     RECENT,
/*     */     
/* 531 */     SEEN,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 536 */     SENTBEFORE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 541 */     SENTON,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 546 */     SENTSINCE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 551 */     SINCE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 556 */     SMALLER,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 561 */     SUBJECT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 566 */     TEXT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 571 */     TO,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 576 */     UID,
/*     */     
/* 578 */     UNANSWERED,
/*     */     
/* 580 */     UNDELETED,
/*     */     
/* 582 */     UNDRAFT,
/*     */     
/* 584 */     UNFLAGGED,
/*     */     
/* 586 */     UNKEYWORD,
/*     */     
/* 588 */     UNSEEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum FETCH_ITEM_NAMES
/*     */   {
/* 597 */     ALL,
/*     */     
/* 599 */     FAST,
/*     */     
/* 601 */     FULL,
/*     */     
/* 603 */     BODY,
/*     */     
/* 605 */     BODYSTRUCTURE,
/*     */     
/* 607 */     ENVELOPE,
/*     */     
/* 609 */     FLAGS,
/*     */     
/* 611 */     INTERNALDATE,
/*     */     
/* 613 */     RFC822,
/*     */     
/* 615 */     UID;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\imap\IMAPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */