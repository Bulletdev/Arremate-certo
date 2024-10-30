/*     */ package org.apache.commons.net.pop3;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ListIterator;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.net.io.DotTerminatedMessageReader;
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
/*     */ 
/*     */ 
/*     */ public class POP3Client
/*     */   extends POP3
/*     */ {
/*     */   private static POP3MessageInfo parseStatus(String paramString) {
/*  59 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString);
/*     */     
/*  61 */     if (!stringTokenizer.hasMoreElements()) {
/*  62 */       return null;
/*     */     }
/*     */     
/*  65 */     int j = 0, i = j;
/*     */ 
/*     */     
/*     */     try {
/*  69 */       i = Integer.parseInt(stringTokenizer.nextToken());
/*     */       
/*  71 */       if (!stringTokenizer.hasMoreElements()) {
/*  72 */         return null;
/*     */       }
/*     */       
/*  75 */       j = Integer.parseInt(stringTokenizer.nextToken());
/*     */     }
/*  77 */     catch (NumberFormatException numberFormatException) {
/*     */       
/*  79 */       return null;
/*     */     } 
/*     */     
/*  82 */     return new POP3MessageInfo(i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static POP3MessageInfo parseUID(String paramString) {
/*  90 */     StringTokenizer stringTokenizer = new StringTokenizer(paramString);
/*     */     
/*  92 */     if (!stringTokenizer.hasMoreElements()) {
/*  93 */       return null;
/*     */     }
/*     */     
/*  96 */     int i = 0;
/*     */ 
/*     */     
/*     */     try {
/* 100 */       i = Integer.parseInt(stringTokenizer.nextToken());
/*     */       
/* 102 */       if (!stringTokenizer.hasMoreElements()) {
/* 103 */         return null;
/*     */       }
/*     */       
/* 106 */       paramString = stringTokenizer.nextToken();
/*     */     }
/* 108 */     catch (NumberFormatException numberFormatException) {
/*     */       
/* 110 */       return null;
/*     */     } 
/*     */     
/* 113 */     return new POP3MessageInfo(i, paramString);
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
/*     */   public boolean capa() throws IOException {
/* 125 */     if (sendCommand(12) == 0) {
/* 126 */       getAdditionalReply();
/* 127 */       return true;
/*     */     } 
/* 129 */     return false;
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
/* 152 */     if (getState() != 0) {
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     if (sendCommand(0, paramString1) != 0) {
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     if (sendCommand(1, paramString2) != 0) {
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     setState(1);
/*     */     
/* 166 */     return true;
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
/*     */   public boolean login(String paramString1, String paramString2, String paramString3) throws IOException, NoSuchAlgorithmException {
/* 212 */     if (getState() != 0) {
/* 213 */       return false;
/*     */     }
/*     */     
/* 216 */     MessageDigest messageDigest = MessageDigest.getInstance("MD5");
/* 217 */     paramString2 = paramString2 + paramString3;
/* 218 */     byte[] arrayOfByte = messageDigest.digest(paramString2.getBytes(getCharset()));
/* 219 */     StringBuilder stringBuilder2 = new StringBuilder(128);
/*     */     
/* 221 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 222 */       int i = arrayOfByte[b] & 0xFF;
/* 223 */       if (i <= 15) {
/* 224 */         stringBuilder2.append("0");
/*     */       }
/* 226 */       stringBuilder2.append(Integer.toHexString(i));
/*     */     } 
/*     */     
/* 229 */     StringBuilder stringBuilder1 = new StringBuilder(256);
/* 230 */     stringBuilder1.append(paramString1);
/* 231 */     stringBuilder1.append(' ');
/* 232 */     stringBuilder1.append(stringBuilder2.toString());
/*     */     
/* 234 */     if (sendCommand(9, stringBuilder1.toString()) != 0) {
/* 235 */       return false;
/*     */     }
/*     */     
/* 238 */     setState(1);
/*     */     
/* 240 */     return true;
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
/*     */   public boolean logout() throws IOException {
/* 261 */     if (getState() == 1) {
/* 262 */       setState(2);
/*     */     }
/* 264 */     sendCommand(2);
/* 265 */     return (this.replyCode == 0);
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
/*     */   public boolean noop() throws IOException {
/* 283 */     if (getState() == 1) {
/* 284 */       return (sendCommand(7) == 0);
/*     */     }
/* 286 */     return false;
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
/*     */   public boolean deleteMessage(int paramInt) throws IOException {
/* 307 */     if (getState() == 1) {
/* 308 */       return (sendCommand(6, Integer.toString(paramInt)) == 0);
/*     */     }
/*     */     
/* 311 */     return false;
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
/*     */   public boolean reset() throws IOException {
/* 328 */     if (getState() == 1) {
/* 329 */       return (sendCommand(8) == 0);
/*     */     }
/* 331 */     return false;
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
/*     */   public POP3MessageInfo status() throws IOException {
/* 351 */     if (getState() != 1) {
/* 352 */       return null;
/*     */     }
/* 354 */     if (sendCommand(3) != 0) {
/* 355 */       return null;
/*     */     }
/* 357 */     return parseStatus(this.lastReplyLine.substring(3));
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
/*     */   public POP3MessageInfo listMessage(int paramInt) throws IOException {
/* 380 */     if (getState() != 1) {
/* 381 */       return null;
/*     */     }
/* 383 */     if (sendCommand(4, Integer.toString(paramInt)) != 0)
/*     */     {
/* 385 */       return null;
/*     */     }
/* 387 */     return parseStatus(this.lastReplyLine.substring(3));
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
/*     */   public POP3MessageInfo[] listMessages() throws IOException {
/* 410 */     if (getState() != 1) {
/* 411 */       return null;
/*     */     }
/* 413 */     if (sendCommand(4) != 0) {
/* 414 */       return null;
/*     */     }
/* 416 */     getAdditionalReply();
/*     */ 
/*     */     
/* 419 */     POP3MessageInfo[] arrayOfPOP3MessageInfo = new POP3MessageInfo[this.replyLines.size() - 2];
/*     */     
/* 421 */     ListIterator<String> listIterator = this.replyLines.listIterator(1);
/*     */ 
/*     */     
/* 424 */     for (byte b = 0; b < arrayOfPOP3MessageInfo.length; b++) {
/* 425 */       arrayOfPOP3MessageInfo[b] = parseStatus(listIterator.next());
/*     */     }
/*     */     
/* 428 */     return arrayOfPOP3MessageInfo;
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
/*     */   public POP3MessageInfo listUniqueIdentifier(int paramInt) throws IOException {
/* 451 */     if (getState() != 1) {
/* 452 */       return null;
/*     */     }
/* 454 */     if (sendCommand(11, Integer.toString(paramInt)) != 0)
/*     */     {
/* 456 */       return null;
/*     */     }
/* 458 */     return parseUID(this.lastReplyLine.substring(3));
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
/*     */   public POP3MessageInfo[] listUniqueIdentifiers() throws IOException {
/* 481 */     if (getState() != 1) {
/* 482 */       return null;
/*     */     }
/* 484 */     if (sendCommand(11) != 0) {
/* 485 */       return null;
/*     */     }
/* 487 */     getAdditionalReply();
/*     */ 
/*     */     
/* 490 */     POP3MessageInfo[] arrayOfPOP3MessageInfo = new POP3MessageInfo[this.replyLines.size() - 2];
/*     */     
/* 492 */     ListIterator<String> listIterator = this.replyLines.listIterator(1);
/*     */ 
/*     */     
/* 495 */     for (byte b = 0; b < arrayOfPOP3MessageInfo.length; b++) {
/* 496 */       arrayOfPOP3MessageInfo[b] = parseUID(listIterator.next());
/*     */     }
/*     */     
/* 499 */     return arrayOfPOP3MessageInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Reader retrieveMessage(int paramInt) throws IOException {
/* 530 */     if (getState() != 1) {
/* 531 */       return null;
/*     */     }
/* 533 */     if (sendCommand(5, Integer.toString(paramInt)) != 0) {
/* 534 */       return null;
/*     */     }
/*     */     
/* 537 */     return (Reader)new DotTerminatedMessageReader(this.reader);
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
/*     */   public Reader retrieveMessageTop(int paramInt1, int paramInt2) throws IOException {
/* 572 */     if (paramInt2 < 0 || getState() != 1) {
/* 573 */       return null;
/*     */     }
/* 575 */     if (sendCommand(10, Integer.toString(paramInt1) + " " + 
/* 576 */         Integer.toString(paramInt2)) != 0) {
/* 577 */       return null;
/*     */     }
/*     */     
/* 580 */     return (Reader)new DotTerminatedMessageReader(this.reader);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\pop3\POP3Client.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */